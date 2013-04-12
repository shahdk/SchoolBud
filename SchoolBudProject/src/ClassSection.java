import java.util.ArrayList;

/**
 * 
 */

/**
 * @author John
 *
 */
public class ClassSection {

	private ArrayList<WeekSchedule> sections;
	
	public ClassSection (ArrayList<WeekSchedule> sections) {
		this.sections = sections;
	}

	/**
	 * @return the sections
	 */
	public ArrayList<WeekSchedule> getSections() {
		return sections;
	}

	/**
	 * @param sections the sections to set
	 */
	public void setSections(ArrayList<WeekSchedule> sections) {
		this.sections = sections;
	}



}
