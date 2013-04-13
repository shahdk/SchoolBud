import java.util.ArrayList;

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

	public ArrayList<ArrayList<SchedulerCourse>> permutateSchedules() {
		this.schedules.clear();

		if (this.classes == null || this.classes.size() == 0) {
			return this.schedules;
		}

		// // go through each course
		// for (SchedulerCourse course : this.classes) {
		// ClassSection sections = course.getSections();

		SchedulerCourse course = this.classes.get(0);
		ClassSection sections = course.getSections();
		// go through each course section

		for (WeekSchedule section : sections.getSections()) {

			if (!isWeekSheduleEmpty(section)) {

				ArrayList<WeekSchedule> weeks = new ArrayList<WeekSchedule>();
				weeks.add(section);
				ClassSection sects = new ClassSection(weeks);
				SchedulerCourse cour = new SchedulerCourse(
						course.getCourseName(), course.getTeacher(), sects);
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
		// }

		return this.schedules;
	}

	public void findMatchingCoursesWithSections(
			ArrayList<SchedulerCourse> currSectionCourses,
			ArrayList<SchedulerCourse> coursesToCheck) {

		// Base case - when you run out of classes to check against
		if (coursesToCheck.size() == 0) {
			if (this.classes.size() == currSectionCourses.size()) {
				this.schedules.add(currSectionCourses);
			}
		} else {
			// go through JUST next course to check against
			ArrayList<SchedulerCourse> tempCoursesToCheck = this
					.cloneSchedulerCoursList(coursesToCheck);
			SchedulerCourse course = tempCoursesToCheck.get(0);
			ClassSection sections = course.getSections();
			tempCoursesToCheck.remove(0);

			// compile all week schedule sections of all current
			// built up classes for later comparison
			// compare ALL sections to current built up list
			ArrayList<WeekSchedule> currClassWeekSchedules = new ArrayList<WeekSchedule>();
			for (SchedulerCourse currCourse : currSectionCourses) {
				for (WeekSchedule classSect : currCourse.getSections().getSections()) {
					currClassWeekSchedules.add(classSect);
				}
			}
			ClassSection currentClassSections = new ClassSection(currClassWeekSchedules);
			

			// go through each course section of JUST this course
			for (WeekSchedule section : sections.getSections()) {

				if (!isWeekSheduleEmpty(section)) {

					if (!this.sectionsOverlapWithnewSection(
							currentClassSections, section)) {
						ArrayList<WeekSchedule> weeks = new ArrayList<WeekSchedule>();
						weeks.add(section);
						ClassSection sects = new ClassSection(weeks);
						SchedulerCourse newCourse = new SchedulerCourse(
								course.getCourseName(), course.getTeacher(),
								sects);
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

//	public static void printSchedules(
//			ArrayList<ArrayList<SchedulerCourse>> schedules) {
//		int count = 0;
//		for (ArrayList<SchedulerCourse> schedule : schedules) {
//			System.out.println();
//			System.out
//					.println("#"
//							+ count
//							+ "-------------------------------------------------------------------");
//			count++;
//			System.out.println();
//			for (SchedulerCourse course : schedule) {
//				System.out.println();
//				System.out.println();
//				System.out.println("COURSE");
//				for (WeekSchedule section : course.getSections().getSections()) {
//					for (ClassDay day : section.getScheduleHours()) {
//						System.out.println();
//						System.out.print("DAY:");
//						for (Integer hour : day.getHourSlots()) {
//							System.out.print(hour + ", ");
//						}
//					}
//				}
//			}
//		}
//	}

	public static ArrayList<Integer> getDayHoursLists(
			ArrayList<ArrayList<SchedulerCourse>> schedules) {

		ArrayList<Integer> hours = new ArrayList<Integer>();
		;

		for (ArrayList<SchedulerCourse> schedule : schedules) {
			for (SchedulerCourse course : schedule) {
				for (WeekSchedule section : course.getSections().getSections()) {
					for (ClassDay day : section.getScheduleHours()) {
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
}
