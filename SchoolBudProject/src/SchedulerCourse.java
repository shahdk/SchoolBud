import java.util.ArrayList;

/* This creates a CLASS class to store the info about normal classes
 * Includes getters and setters
 */

public class SchedulerCourse extends Course {

	private String teacher;
	private ClassSection sections;

	public SchedulerCourse(String className, String teacherName,
			ClassSection sections) {
		super(className);

		this.teacher = teacherName;
		this.sections = sections;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	/**
	 * @return the sections
	 */
	public ClassSection getSections() {
		return sections;
	}

	/**
	 * @param sections
	 *            the sections to set
	 */
	public void setSections(ClassSection sections) {
		this.sections = sections;
	}

}
