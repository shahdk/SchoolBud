import java.util.ArrayList;

/* This creates a CLASS class to store the info about normal classes
 * Includes getters and setters
 */

public class SchedulerCourse extends Course {

	private String teacher;
	private ArrayList<ArrayList<Integer>> scheduleHours;

	public SchedulerCourse(String className, String teacherName,
			ArrayList<ArrayList<Integer>> scheduleHours)
			throws InstantiationError {
		super(className);

		if (scheduleHours.size() != 7) {
			throw new InstantiationError();
		}

		this.setTeacher(teacherName);
		this.setScheduleHours(scheduleHours);
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
	public ArrayList<ArrayList<Integer>> getScheduleHours() {
		return scheduleHours;
	}

	/**
	 * @param scheduleHours
	 *            the scheduleHours to set
	 */
	public void setScheduleHours(ArrayList<ArrayList<Integer>> scheduleHours) {
		this.scheduleHours = scheduleHours;
	}

}
