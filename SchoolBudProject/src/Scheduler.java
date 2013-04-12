import java.util.ArrayList;

import sun.awt.geom.Curve;

/* The Scheduler class finds all of the permutations of possible schedules
 * depending on a students entered classes and their respective hours 
 * 
 */

public class Scheduler {

	private ArrayList<SchedulerCourse> classes;
	private ArrayList<SchedulerCourse> visitedCourses;
	private ArrayList<ArrayList<SchedulerCourse>> schedules;
	private ArrayList<SchedulerCourse> aSchedule;
	private int numClassHours;
	private int numClasses;

	public Scheduler(int classHours, ArrayList<SchedulerCourse> classes) {
		this.classes = classes;
		this.numClassHours = classHours;
		this.schedules = new ArrayList<ArrayList<SchedulerCourse>>();
		this.numClasses = this.classes.size();
		this.aSchedule = new ArrayList<SchedulerCourse>();
		this.visitedCourses = new ArrayList<SchedulerCourse>();
	}

	private void resetSchedule() {

		this.aSchedule.clear();

		// // initialize 7 days of the week with an arrayList
		// for (int i = 0; i < 6; i++) {
		// this.aSchedule.add(new ArrayList<SchedulerCourse>());
		// }
	}

	public ArrayList<ArrayList<SchedulerCourse>> permutateSchedules() {
		this.resetSchedule();
		this.schedules.clear();

		if (this.classes == null) {
			return this.schedules;
		}

		// go through each course
		for (SchedulerCourse course : this.classes) {
			ClassSection sections = course.getSections();

			// go through each course section
			for (WeekSchedule section : sections.getSections()) {
				
				if (! isWeekSheduleEmpty(section)) {
					ArrayList<WeekSchedule> weeks = new ArrayList<WeekSchedule>();
					weeks.add(section);
					ClassSection sects = new ClassSection(weeks);
					SchedulerCourse cour = new SchedulerCourse(
							course.getCourseName(), course.getTeacher(), sects);
					ArrayList<SchedulerCourse> courses = new ArrayList<SchedulerCourse>();
					courses.add(cour);

					this.findMatchingCoursesWithSections(courses);
				}
			}
			//
			// //
			// -------------------------INNER----------------------------------------------------------
			//
			// // go through ALL other courses
			// for (SchedulerCourse courseInner : this.classes) {
			// ClassSection sectionsInner = courseInner.getSections();
			//
			// // go through ALL Other course sections
			// for (WeekSchedule sectionInner : sectionsInner
			// .getSections()) {
			//
			// // compare ALL sections
			// if (!this.sectionOverlapWithSection(section,
			// sectionInner)) {
			//
			// // add to course-section list
			// // then try to find the rest of the matching section
			// // for all the other courses
			// }
			// }
			// }
			// }
		}

		return this.schedules;
	}

	public void findMatchingCoursesWithSections(
			ArrayList<SchedulerCourse> currSectionCourses) {

		boolean foundCourseMarch = false;

		// go through each course
		for (SchedulerCourse course : this.classes) {
			ClassSection sections = course.getSections();

			// go through each course section
			for (WeekSchedule section : sections.getSections()) {

				if (this.visitedCourses.contains(course)) {
					break;
				} else {
					this.visitedCourses.add(course);
				}

				// -------------------------INNER----------------------------------------------------------

				// go through ALL other courses
				for (SchedulerCourse courseInner : this.classes) {
					if (isWeekSheduleEmpty(section)) {
						break;
					}

					ClassSection sectionsInner = courseInner.getSections();

					// go through ALL Other course sections
					for (WeekSchedule sectionInner : sectionsInner
							.getSections()) {
						if (courseInner.equals(course)) {
							break;
						}
						// if (foundCourseMarch) {
						// foundCourseMarch = false;
						// break;
						// }

						if (! isWeekSheduleEmpty(sectionInner)) {

							// compare ALL sections to current built up list
							for (SchedulerCourse sch : currSectionCourses) {
								if (!this.sectionsOverlapWithnewSection(
										sch.getSections(), sectionInner)) {
									ArrayList<WeekSchedule> weeks = new ArrayList<WeekSchedule>();
									weeks.add(sectionInner);
									ClassSection sects = new ClassSection(weeks);
									course = new SchedulerCourse(
											courseInner.getCourseName(),
											courseInner.getTeacher(), sects);
									ArrayList<SchedulerCourse> newCourses = new ArrayList<SchedulerCourse>();
									newCourses.addAll(currSectionCourses);
									newCourses.add(course);
									this.findMatchingCoursesWithSections(newCourses);
									// foundCourseMarch = true;
								}
							}
						}

					}
				}
			}
		}

		if (this.classes.size() == currSectionCourses.size()) {
			this.schedules.add(currSectionCourses);
		}

	}

	public boolean CourseOverlapWithCourse(ClassSection courseSections1,
			ClassSection courseSections2) {

		for (WeekSchedule sect : courseSections1.getSections()) {

			for (WeekSchedule sect2 : courseSections2.getSections()) {

				if (this.sectionOverlapWithSection(sect, sect2)) {
					return false;
				}
			}
		}

		return true;
	}

	public boolean sectionOverlapWithSection(WeekSchedule section1,
			WeekSchedule section2) {

		for (ClassDay day : section1.getScheduleHours()) {

			for (Integer hour : day.getHourSlots()) {

				for (ClassDay day2 : section2.getScheduleHours()) {

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

	public boolean sectionsOverlapWithnewSection(ClassSection sections,
			WeekSchedule newSection) {

		for (WeekSchedule sect : sections.getSections()) {

			if (sectionOverlapWithSection(sect, newSection)) {
				return true;
			}

		}

		return false;
	}
	
	public boolean isWeekSheduleEmpty(WeekSchedule sched) {
		for (ClassDay day : sched.getScheduleHours()) {
			if (day.getHourSlots().size() > 0) {
				return false;
			}
		}
		
		return true;
	}
}
