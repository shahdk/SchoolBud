import java.util.ArrayList;

/* The Scheduler class finds all of the permutations of possible schedules
 * depending on a students entered classes and their respective hours 
 * 
 */

public class Scheduler {

	private ArrayList<SchedulerCourse> classes;
	private ArrayList<ArrayList<ArrayList<SchedulerCourse>>> schedules;
	private ArrayList<SchedulerCourse> aSchedule;
	private int numClassHours;
	private int numClasses;

	public Scheduler(int classHours, ArrayList<SchedulerCourse> classes) {
		this.classes = classes;
		this.numClassHours = classHours;
		this.schedules = new ArrayList<ArrayList<ArrayList<SchedulerCourse>>>();
		this.numClasses = this.classes.size();
		this.aSchedule = new ArrayList<SchedulerCourse>();
	}

	private void resetSchedule() {

		this.aSchedule.clear();

		// initialize 7 days of the week with an arrayList
		for (int i = 0; i < 6; i++) {
			this.aSchedule.add(new ArrayList<SchedulerCourse>());
		}
	}

	public ArrayList<ArrayList<ArrayList<SchedulerCourse>>> permutateSchedules() {
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

				// -------------------------INNER----------------------------------------------------------

				// go through ALL other courses
				for (SchedulerCourse courseInner : this.classes) {
					ClassSection sectionsInner = courseInner.getSections();

					// go through ALL Other course sections
					for (WeekSchedule sectionInner : sectionsInner
							.getSections()) {

						// compare ALL sections
						if (!this.sectionOverlapWithSection(section,
								sectionInner)) {

							// add to course-section list
							// then try to find the rest of the matching section
							// for all the other courses
						}
					}
				}
			}
		}

		return this.schedules;
	}

	public ArrayList<SchedulerCourse> findMatchingCoursesWithSections(
			SchedulerCourse currentCourse, WeekSchedule currentSection) {

		ArrayList<SchedulerCourse> theCourses = new ArrayList<SchedulerCourse>();
		SchedulerCourse course;
		boolean foundCourseMarch = false;

		// go through each course
		for (SchedulerCourse acourse : this.classes) {
			ClassSection sections = acourse.getSections();

			// go through each course section
			for (WeekSchedule section : sections.getSections()) {
				
				if (acourse.equals(currentCourse)) {
					break;
				}

				// -------------------------INNER----------------------------------------------------------

				// go through ALL other courses
				for (SchedulerCourse courseInner : this.classes) {
					ClassSection sectionsInner = courseInner.getSections();

					// go through ALL Other course sections
					for (WeekSchedule sectionInner : sectionsInner
							.getSections()) {
						if (foundCourseMarch) {
							foundCourseMarch = false;
							break;
						}

						// compare ALL sections
						if (!this.sectionOverlapWithSection(section,
								sectionInner)) {
							ArrayList<WeekSchedule> weeks = new ArrayList<WeekSchedule>();
							weeks.add(sectionInner);
							ClassSection sects = new ClassSection(weeks);
							course = new SchedulerCourse(
									courseInner.getCourseName(),
									courseInner.getTeacher(), sects);
							this.aSchedule.add(course);
							foundCourseMarch = true;
						}
					}
				}
			}
		}

		return theCourses;

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
							return false;
						}
					}
				}

			}
		}

		return true;
	}
}
