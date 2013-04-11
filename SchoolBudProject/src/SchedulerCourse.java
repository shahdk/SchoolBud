import java.util.ArrayList;

/* This creates a CLASS class to store the info about normal classes
 * Includes getters and setters
 */

public class SchedulerCourse extends Course {

	private String teacher;
	private ArrayList<ArrayList<ClassDay>> scheduleHours;

	public SchedulerCourse(String className, String teacherName, ArrayList<ArrayList<ClassDay>> scheduleHours)
			throws InstantiationError {
		super(className);

		for (ArrayList<ClassDay> sched : scheduleHours) {
			if (sched.size() != 7) {
				throw new InstantiationError();
			}
		}
		
		this.teacher = teacherName;
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
	public ArrayList<ArrayList<ClassDay>> getScheduleHours() {
		return scheduleHours;
	}

	/**
	 * @param scheduleHours the scheduleHours to set
	 */
	public void setScheduleHours(ArrayList<ArrayList<ClassDay>> scheduleHours) {
		this.scheduleHours = scheduleHours;
	}


}
