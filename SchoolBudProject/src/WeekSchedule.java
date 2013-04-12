import java.util.ArrayList;

/**
 * 
 */

/**
 * @author John
 * 
 */
public class WeekSchedule {

	private ArrayList<ClassDay> scheduleHours;

	public WeekSchedule(ArrayList<ClassDay> days) {

		if (days.size() != 7) {
			throw new InstantiationError();
		}
	}

	/**
	 * @return the scheduleHours
	 */
	public ArrayList<ClassDay> getScheduleHours() {
		return scheduleHours;
	}

	/**
	 * @param scheduleHours the scheduleHours to set
	 */
	public void setScheduleHours(ArrayList<ClassDay> scheduleHours) {
		this.scheduleHours = scheduleHours;
	}

}
