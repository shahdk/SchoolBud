import java.util.ArrayList;

/* This creates a CLASS class to store the info about normal classes
 * Includes getters and setters
 */

public class SchedulerCourse extends Course {

	private ArrayList<ClassSection> sections;
	private boolean isOptional;

	public SchedulerCourse(String className, ArrayList<ClassSection> sections,
			boolean isOptional) {
		super(className);
		this.setSections(sections);
		this.setOptional(isOptional);
	}

	/**
	 * @return the sections
	 */
	public ArrayList<ClassSection> getSections() {
		return sections;
	}

	/**
	 * @param sections the sections to set
	 */
	public void setSections(ArrayList<ClassSection> sections) {
		this.sections = sections;
	}

	/**
	 * @return the isOptional
	 */
	public boolean isOptional() {
		return isOptional;
	}

	/**
	 * @param isOptional the isOptional to set
	 */
	public void setOptional(boolean isOptional) {
		this.isOptional = isOptional;
	}
}
