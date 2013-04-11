import java.util.ArrayList;

/* The Scheduler class finds all of the permutations of possible schedules
 * depending on a students entered classes and their respective hours 
 * 
 */

public class Scheduler {

	private ArrayList<SchedulerCourse> classes;
	private ArrayList<ArrayList<ArrayList<SchedulerCourse>>> schedules;
	private ArrayList<ArrayList<SchedulerCourse>> aSchedule;
	private int numClassHours;
	private int numClasses;

	public Scheduler(int classHours, ArrayList<SchedulerCourse> classes) {
		this.classes = classes;
		this.numClassHours = classHours;
		this.schedules = new ArrayList<ArrayList<ArrayList<SchedulerCourse>>>();
		this.numClasses = this.classes.size();
	}

	private void resetSchedule() {

		this.aSchedule.clear();

		// initialize 7 days of the week with an arrayList
		for (int i = 0; i < 6; i++) {
			this.aSchedule.add(new ArrayList<SchedulerCourse>());
		}
	}

	public ArrayList<ArrayList<ArrayList<SchedulerCourse>>> permutateSchedules(){
		this.resetSchedule();
		this.schedules.clear();
		
		if (this.classes == null){
			return this.schedules;
		}
		
//		ArrayList<Integer> taken = new ArrayList<Integer>();
//		
//		//iterate through each class
//		for (SchedulerCourse course : this.classes) {
//			
//			//iterate through each class day for the week
//			for (ArrayList<Integer> dayWithHours : course.getScheduleHours()) {
//				
//				//iterate through each hour as 'SET' for the rest of the week
//				//to attempt to make a schedule based around that hour
//				for (Integer hourOfDay : dayWithHours) {
//					
//					//compare through ALL other classes to compare
//					
////-----------------------------INNER------------------------------------------------------------------------------
//					
//					//iterate through each class
//					for (SchedulerCourse courseInner : this.classes) {
//						
//						//iterate through each class day for the week
//						for (ArrayList<Integer> dayWithHoursInner : courseInner.getScheduleHours()) {
//							
//							//iterate through each hour as 'SET' for the rest of the week
//							//to attempt to make a schedule based around that hour
//							for (Integer hourOfDayInner : dayWithHoursInner) {
//								
//								
//								
//							}
//				}
//			}
//		}
//		
//		//iterate through days of the week
//		for (int i = 0; i < 6; i++) {
//			
//		}
//		
//		return this.schedules;
//	}

	public boolean isFull(Class[] theHours) {
		int count = 0;
		for (Class theClass : theHours) {
			if (theClass != null) {
				count++;
			}
			if (count == this.classes.size()) {
				return true;
			}
		}

		return false;

	}

}
