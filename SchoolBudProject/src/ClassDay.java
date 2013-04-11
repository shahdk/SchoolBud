import java.util.ArrayList;

/**
 * 
 */

/**
 * @author John
 *
 */
public class ClassDay {

	
	private ArrayList<ArrayList<Integer>> hourSlots;
	
	public ClassDay(ArrayList<ArrayList<Integer>> hourSlots) {
		
		this.hourSlots = hourSlots;
	}

	/**
	 * @return the hourSlots
	 */
	public ArrayList<ArrayList<Integer>> getHourSlots() {
		return hourSlots;
	}

	/**
	 * @param hourSlots the hourSlots to set
	 */
	public void setHourSlots(ArrayList<ArrayList<Integer>> hourSlots) {
		this.hourSlots = hourSlots;
	}
}
