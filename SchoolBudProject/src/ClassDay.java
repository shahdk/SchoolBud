import java.util.ArrayList;

/**
 * 
 */

/**
 * @author John
 *
 */
public class ClassDay {

	
	private ArrayList<Integer> hourSlots;
	
	public ClassDay(ArrayList<Integer> hourSlots) {
		
		this.setHourSlots(hourSlots);
	}

	/**
	 * @return the hourSlots
	 */
	public ArrayList<Integer> getHourSlots() {
		return hourSlots;
	}

	/**
	 * @param hourSlots the hourSlots to set
	 */
	public void setHourSlots(ArrayList<Integer> hourSlots) {
		this.hourSlots = hourSlots;
	}


}
