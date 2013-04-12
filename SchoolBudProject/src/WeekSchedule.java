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
		this.scheduleHours = days;
	}

	/**
	 * @return the scheduleHours
	 */
	public ArrayList<ClassDay> getScheduleHours() {
		return this.scheduleHours;
	}

	/**
	 * @param scheduleHours the scheduleHours to set
	 */
	public void setScheduleHours(ArrayList<ClassDay> scheduleHours) {
		this.scheduleHours = scheduleHours;
	}
	
	public static ArrayList<ClassDay> create7DayArrayList() {
		ArrayList<ClassDay> list = new ArrayList<ClassDay>();
		for (int i = 0; i < 7; i++) {
			list.add(new ClassDay(new ArrayList<Integer>()));
		}
		return list;
		
	}

}
