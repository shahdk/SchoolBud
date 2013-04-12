import java.util.ArrayList;

/**
 * 
 */

/**
 * @author John
 *
 */
public class ClassSection {

	private ArrayList<WeekSchedule> classes;
	
	public ClassSection (ArrayList<SchedulerCourse> courses) {
		
	}

	/**
	 * @return the classes
	 */
	public ArrayList<WeekSchedule> getClasses() {
		return classes;
	}

	/**
	 * @param classes the classes to set
	 */
	public void setClasses(ArrayList<WeekSchedule> classes) {
		this.classes = classes;
	}


}
