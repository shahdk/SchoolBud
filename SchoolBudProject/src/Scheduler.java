import java.util.ArrayList;

/* The Scheduler class finds all of the permutations of possible schedules
 * depending on a students entered classes and their respective hours 
 * 
 */

public class Scheduler {

	private ArrayList<SchedulerCourse> classes;
	private ArrayList<ArrayList<SchedulerCourse>> schedules;
	private ArrayList<ArrayList<SchedulerCourse>> filteredSchedules;
	private int numClassHours;
	private int numClasses;

	public Scheduler(int classHours, ArrayList<SchedulerCourse> classes) {
		this.classes = classes;
		this.schedules = new ArrayList<ArrayList<SchedulerCourse>>();
		this.filteredSchedules = new ArrayList<ArrayList<SchedulerCourse>>();
		this.numClassHours = classHours;
		this.numClasses = this.classes.size();
	}

	public ArrayList<ArrayList<SchedulerCourse>> permutateSchedules() {
		this.schedules.clear();

		if (this.classes == null || this.classes.size() == 0) {
			return this.schedules;
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

	public void findMatchingCoursesWithSections(
			ArrayList<SchedulerCourse> currSectionCourses,
			ArrayList<SchedulerCourse> coursesToCheck) {

		// Base case - when you run out of classes to check against
		if (coursesToCheck.size() == 0) {
			if (this.classes.size() == currSectionCourses.size()) {
				this.schedules.add(currSectionCourses);
				this.filteredSchedules.add(currSectionCourses);
			}
		} else {
			// go through JUST next course to check against
			ArrayList<SchedulerCourse> tempCoursesToCheck = this.cloneSchedulerCoursList(coursesToCheck);
			SchedulerCourse course = tempCoursesToCheck.get(0);
			ArrayList<ClassSection> sections = course.getSections();
			tempCoursesToCheck.remove(0);
	

			// compile all sections of all current
			// built up classes for later comparison
			// compare ALL sections to current built up list
			ArrayList<ClassSection> currClassSections = new ArrayList<ClassSection>();
			for (SchedulerCourse currCourse : currSectionCourses) {
				for (ClassSection classSect : currCourse.getSections()) {
					currClassSections.add(classSect);
				}
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

	public boolean sectionsOverlapWithnewSection(
			ArrayList<ClassSection> sections, ClassSection newSection) {

		for (ClassSection sect : sections) {

			if (sectionOverlapWithSection(sect, newSection)) {
				return true;
			}

		}

		return false;
	}

	public boolean isSectionEmpty(ClassSection section) {
		for (ClassDay day : section.getClassDays()) {
			if (day.getHourSlots().size() > 0) {
				return false;
			}
		}

		return true;
	}

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

	public ArrayList<SchedulerCourse> cloneSchedulerCoursList(
			ArrayList<SchedulerCourse> classes) {

		ArrayList<SchedulerCourse> courses = new ArrayList<SchedulerCourse>();
		for (SchedulerCourse course : classes) {
			courses.add(course);
		}

		return courses;
	}
	
	//Filters out schedules that have a greater number of gaps between classes than
	//the denoted OR that has the max number of gaps occur more than the denoted amount
	public ArrayList<ArrayList<SchedulerCourse>> filterGaps(int maxNumOfGaps, int maxNumOfOccurences) {
		ArrayList<ArrayList<SchedulerCourse>> filteredResults = new ArrayList<ArrayList<SchedulerCourse>>();
		
		return filteredResults;
	}
	
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
				for (ClassSection section : course.getSections()) {
					for (ClassDay day : section.getClassDays()) {
						System.out.println();
						System.out.print("DAY:");
						for (Integer hour : day.getHourSlots()) {
							System.out.print(hour + ", ");
						}
					}
				}
			}
		}
	}

}
