import java.util.ArrayList;

import com.sun.org.apache.xerces.internal.dom.DeepNodeListImpl;

/* The Scheduler class finds all of the permutations of possible schedules
 * depending on a students entered classes and their respective hours 
 * 
 */

public class Scheduler {

	private ArrayList<SchedulerCourse> classes;
	private ArrayList<ArrayList<SchedulerCourse>> schedules;
	private ArrayList<ArrayList<SchedulerCourse>> filteredSchedules;
	private ArrayList<SchedulerCourse> nonOptionalClasses;

	public Scheduler(int classHours, ArrayList<SchedulerCourse> classes) {
		this.classes = classes;
		this.schedules = new ArrayList<ArrayList<SchedulerCourse>>();
		this.filteredSchedules = new ArrayList<ArrayList<SchedulerCourse>>();
		this.nonOptionalClasses = new ArrayList<SchedulerCourse>();

	}

	// ===========================================================================================
	//
	
	public void setClasses(ArrayList<SchedulerCourse> courses){
		this.classes = courses;
	}

	public ArrayList<ArrayList<SchedulerCourse>> permutateSchedules() {

		// reset instance variables
		this.schedules.clear();
		this.filteredSchedules.clear();
		this.nonOptionalClasses.clear();

		if (this.classes == null || this.classes.size() == 0) {
			return this.schedules;
		}

		// find NON-optional classes
		for (SchedulerCourse course : this.classes) {
			if (!course.isOptional()) {
				this.nonOptionalClasses.add(course);
			}
		}

		// fixate one course to create branches from
		SchedulerCourse course = this.classes.get(0);
		ArrayList<ClassSection> sections = course.getSections();

		// go through each section
		for (ClassSection section : sections) {

			if (!isSectionEmpty(section)) {

				ArrayList<ClassSection> sectionList = new ArrayList<ClassSection>();
				sectionList.add(section);
				SchedulerCourse cour = new SchedulerCourse(
						course.getCourseName(), sectionList,
						course.isOptional());
				ArrayList<SchedulerCourse> courses = new ArrayList<SchedulerCourse>();
				courses.add(cour);

				// deep clone classes list
				ArrayList<SchedulerCourse> coursesToCheck = this
						.cloneSchedulerCoursList(this.classes);

				// remove courses not to check
				int index = this.classes.indexOf(course);
				for (int i = 0; i <= index; i++) {
					coursesToCheck.remove(i);
				}
				this.findMatchingCoursesWithSections(courses, coursesToCheck);
			}
		}

		return this.schedules;
	}

	// ===========================================================================================
	//

	private boolean containsAllClasses(ArrayList<SchedulerCourse> classes) {
		int total = this.nonOptionalClasses.size();
		int count = 0;
		for (SchedulerCourse course : classes) {
			if (!course.isOptional()) {
				count++;
			}
		}
		return (count == total);
	}

	// ===========================================================================================
	//

	public void findMatchingCoursesWithSections(
			ArrayList<SchedulerCourse> currSectionCourses,
			ArrayList<SchedulerCourse> coursesToCheck) {

		// Base case - when you run out of classes to check against
		if (coursesToCheck.size() == 0) {
			if (this.containsAllClasses(currSectionCourses)) {
				this.schedules.add(currSectionCourses);
				this.filteredSchedules.add(currSectionCourses);
			}
		} else {
			// go through JUST next course to check against
			ArrayList<SchedulerCourse> tempCoursesToCheck = this
					.cloneSchedulerCoursList(coursesToCheck);
			SchedulerCourse course = tempCoursesToCheck.get(0);
			ArrayList<ClassSection> sections = course.getSections();
			tempCoursesToCheck.remove(0);
			boolean notAlreadyFound = true;
			// compile all sections of all current
			// built up classes for later comparison
			// compare ALL sections to current built up list
			ArrayList<ClassSection> currClassSections = new ArrayList<ClassSection>();
			for (SchedulerCourse currCourse : currSectionCourses) {
				for (ClassSection classSect : currCourse.getSections()) {
					currClassSections.add(classSect);
				}
			}

			// check for optional classes
			if (course.isOptional()) {
				notAlreadyFound = false;
				this.findMatchingCoursesWithSections(currSectionCourses,
						tempCoursesToCheck);
			}

			// go through each course section of JUST this course
			for (ClassSection section : sections) {

				if (!isSectionEmpty(section)) {
					if (!this.sectionsOverlapWithnewSection(currClassSections,
							section)) {

						ArrayList<ClassSection> newClassSections = new ArrayList<ClassSection>();
						newClassSections.add(section);
						SchedulerCourse newCourse = new SchedulerCourse(
								course.getCourseName(), newClassSections,
								course.isOptional());
						ArrayList<SchedulerCourse> newCourses = this
								.cloneSchedulerCoursList(currSectionCourses);
						newCourses.add(newCourse);

						this.findMatchingCoursesWithSections(newCourses,
								tempCoursesToCheck);

					}

				}

			}
		}

	}

	// ===========================================================================================
	//

	public boolean sectionOverlapWithSection(ClassSection section1,
			ClassSection section2) {

		for (ClassDay day : section1.getClassDays()) {

			for (Integer hour : day.getHourSlots()) {

				for (ClassDay day2 : section2.getClassDays()) {

					for (Integer hour2 : day2.getHourSlots()) {

						if (hour == hour2) {
							return true;
						}
					}
				}

			}
		}

		return false;
	}

	// ===========================================================================================
	//

	public boolean sectionsOverlapWithnewSection(
			ArrayList<ClassSection> sections, ClassSection newSection) {

		for (ClassSection sect : sections) {

			if (sectionOverlapWithSection(sect, newSection)) {
				return true;
			}

		}

		return false;
	}

	// ===========================================================================================
	//
	// checks to see if a section does not have any class days with hours in
	// them
	public boolean isSectionEmpty(ClassSection section) {
		for (ClassDay day : section.getClassDays()) {
			if (day.getHourSlots().size() > 0) {
				return false;
			}
		}

		return true;
	}

	// ===========================================================================================
	//
	// completely flattens out a list of schedules to an ArrayList of Integers
	public static ArrayList<Integer> getDayHoursLists(
			ArrayList<ArrayList<SchedulerCourse>> schedules) {

		ArrayList<Integer> hours = new ArrayList<Integer>();

		for (ArrayList<SchedulerCourse> schedule : schedules) {
			for (SchedulerCourse course : schedule) {
				for (ClassSection section : course.getSections()) {
					for (ClassDay day : section.getClassDays()) {
						for (Integer hour : day.getHourSlots()) {
							hours.add(hour);
						}
					}
				}
			}
		}

		return hours;
	}

	// ===========================================================================================
	//
	// makes a deeper clone of an arrayList of courses
	public ArrayList<SchedulerCourse> cloneSchedulerCoursList(
			ArrayList<SchedulerCourse> classes) {

		ArrayList<SchedulerCourse> courses = new ArrayList<SchedulerCourse>();
		for (SchedulerCourse course : classes) {
			courses.add(course);
		}

		return courses;
	}

	// ===========================================================================================
	//
	// Filters out schedules that have a greater number of gaps between classes
	// than
	// the denoted OR that has the max number of gaps occur more than the
	// denoted amount
	public ArrayList<ArrayList<SchedulerCourse>> filterGaps(
			int maxNumOfGapHours, int maxNumOfOccurencesMax,
			int minNumOfGapHours, int maxNumOfOccurencesMin,
			int maxNumOfOccurencesMid, int maxNumExceptions,
			ArrayList<Integer> ignoreDays) {

		if (ignoreDays == null) {
			ignoreDays = new ArrayList<Integer>();
		}

		int gapsOccurencesMax;
		int gapsOccurencesMin;
		int gapsOccurencesMid;
		int occuredExceptions;
		boolean isValid;
		ArrayList<ArrayList<SchedulerCourse>> schedsToRemove = new ArrayList<ArrayList<SchedulerCourse>>();

		// go through each schedule
		for (ArrayList<SchedulerCourse> schedule : this.filteredSchedules) {
			// reset values for each new schedule
			isValid = true;
			gapsOccurencesMax = 0;
			gapsOccurencesMin = 0;
			gapsOccurencesMid = 0;
			occuredExceptions = 0;

			// flatten out that schedule into a week of days of hours
			ArrayList<ArrayList<Integer>> week = this
					.flattenScheduleDays(schedule);
			// go through each day and make desired filtration
			for (int i = 0; i < 7; i++) {
				if (!isValid) {
					break;
				}
				// ignore days the user dose not want filter to apply to
				if (!ignoreDays.contains(i)) {
					ArrayList<Integer> day = week.get(i);
					// go through each pair of hours
					for (int h = 0; h < day.size(); h++) {
						if (h + 1 >= day.size()) {
							break;
						}

						// subtract 1 to get ACTUAL NUM of HOURS GAP
						int hourDiff = day.get(h + 1) - day.get(h) - 1;

						// check out of range
						if ((hourDiff > maxNumOfGapHours)
								|| (hourDiff < minNumOfGapHours)) {

							if (occuredExceptions == maxNumExceptions) {
								isValid = false;
								break;
							} else {
								occuredExceptions++;
							}
						}
						// check gaps in between min / max
						else if ((hourDiff < maxNumOfGapHours)
								&& (hourDiff > minNumOfGapHours)) {
							if (gapsOccurencesMid >= maxNumOfOccurencesMid) {
								if (occuredExceptions == maxNumExceptions) {
									isValid = false;
									break;
								} else {
									occuredExceptions++;
								}
							}
							gapsOccurencesMid++;

						}

						// check Max allowed gaps
						else if (hourDiff == maxNumOfGapHours) {
							if (gapsOccurencesMax >= maxNumOfOccurencesMax) {
								if (occuredExceptions == maxNumExceptions) {
									isValid = false;
									break;
								} else {
									occuredExceptions++;
								}
							}
							gapsOccurencesMax++;

						}

						// check Min allowed gaps
						else if (hourDiff == minNumOfGapHours) {
							if (gapsOccurencesMin >= maxNumOfOccurencesMin) {
								if (occuredExceptions == maxNumExceptions) {
									isValid = false;
									break;
								} else {
									occuredExceptions++;
								}
							}
							gapsOccurencesMin++;
						}
					}
				}
			}

			if (!isValid) {
				schedsToRemove.add(schedule);
			}

		}

		// remove all found schedules
		for (ArrayList<SchedulerCourse> sched : schedsToRemove) {
			this.filteredSchedules.remove(sched);
		}

		return this.filteredSchedules;
	}

	// ===========================================================================================
	//
	// Filters out schedules that are not contained within the min / max
	// enclosing
	// unless they are an ignored day
	public ArrayList<ArrayList<SchedulerCourse>> filterHoursConcentration(
			int minStartHour, int maxEndHour, ArrayList<Integer> ignoreDays) {

		if (ignoreDays == null) {
			ignoreDays = new ArrayList<Integer>();
		}

		boolean isValid;
		ArrayList<ArrayList<SchedulerCourse>> schedsToRemove = new ArrayList<ArrayList<SchedulerCourse>>();

		// go through each schedule
		for (ArrayList<SchedulerCourse> schedule : this.filteredSchedules) {
			// reset values for each new schedule
			isValid = true;

			// flatten out that schedule into a week of days of hours
			ArrayList<ArrayList<Integer>> week = this
					.flattenScheduleDays(schedule);

			// go through each day and make desired filtration
			for (int i = 0; i < 7; i++) {
				if (!isValid) {
					break;
				}
				// ignore days the user dose not want filter to apply to
				if (!ignoreDays.contains(i)) {
					ArrayList<Integer> day = week.get(i);
					int startHour;
					int endHour;
					
					// check beginning and start hours
					//check for properly filled days
					if (day.size() == 0) {
						continue;
					}
					else if (day.size() == 1) {
						startHour =  endHour = day.get(0);
					}
					else {
						startHour = day.get(0);
						endHour = day.get(day.size() - 1);
					}
					
					//compare start / end hours
					if (startHour < minStartHour || endHour > maxEndHour) {
						isValid = false;
					}

				}
			}

			if (!isValid) {
				schedsToRemove.add(schedule);
			}
		}

		// remove all found schedules
		for (ArrayList<SchedulerCourse> sched : schedsToRemove) {
			this.filteredSchedules.remove(sched);
		}

		return this.filteredSchedules;
	}

	// ===========================================================================================
	//
	//
	// Flattens our a single schedule (or list of scheduler classes with 1
	// section each)
	// so that it returns an ArrayList of 7 days, with all the hours
	// respectively put into each day
	public ArrayList<ArrayList<Integer>> flattenScheduleDays(
			ArrayList<SchedulerCourse> courses) {
		ArrayList<ArrayList<Integer>> week = new ArrayList<ArrayList<Integer>>();
		// create seven days of the week
		for (int i = 0; i < 7; i++) {
			week.add(new ArrayList<Integer>());
		}

		// go through each course
		for (SchedulerCourse course : courses) {
			// get that courses 1 section
			ClassSection section = course.getSections().get(0);

			// go through days of that 1 section
			for (int d = 0; d < 7; d++) {

				// append each days hours onto the respective day
				week.get(d)
						.addAll(section.getClassDays().get(d).getHourSlots());
			}
		}

		// sort each days hours
		for (ArrayList<Integer> day : week) {
			java.util.Collections.sort(day);
		}
		return week;
	}

	// =============================================================================================

	public ArrayList<ArrayList<SchedulerCourse>> getFilteredSchedules() {
		return this.filteredSchedules;
	}

	 public static void printSchedules(
	 ArrayList<ArrayList<SchedulerCourse>> schedules) {
	 int count = 0;
	 for (ArrayList<SchedulerCourse> schedule : schedules) {
	 System.out.println();
	 System.out
	 .println("#"
	 + count
	 + "-------------------------------------------------------------------");
	 count++;
	 System.out.println();
	 for (SchedulerCourse course : schedule) {
	 System.out.println();
	 System.out.println();
	 System.out.println("COURSE");
	 System.out.println(course.getName());
	 for (ClassSection section : course.getSections()) {
	 for (ClassDay day : section.getClassDays()) {
	 System.out.println();
	 System.out.print("DAY:");
	 for (Integer hour : day.getHourSlots()) {
	 System.out.print(section.getTeacher() +hour + ", ");
	 }
	 }
	 }
	 }
	 }
	 }

}
