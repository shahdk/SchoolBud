import java.util.ArrayList;

/* This creates a CLASS class to store the info about normal classes
 * Includes getters and setters
 */

public class SchedulerCourse extends Course {

	private String teacher;
	private ArrayList<ClassDay> scheduleHours;

	public SchedulerCourse(String className, String teacherName, ArrayList<ClassDay> scheduleHours)
			throws InstantiationError {
		super(className);

		if (scheduleHours.size() != 7) {
			throw new InstantiationError();
		}

		this.teacher = teacherName;
		this.scheduleHours = scheduleHours;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	/**
	 * @return the scheduleHours
	 */
	public ArrayList<ClassDay> getScheduleHours() {
		return scheduleHours;
	}

	/**
	 * @param scheduleHours
	 *            the scheduleHours to set
	 */
	public void setScheduleHours(ArrayList<ClassDay> scheduleHours) {
		this.scheduleHours = scheduleHours;
	}

}
