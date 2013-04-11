import java.util.ArrayList;

/* The Scheduler class finds all of the permutations of possible schedules
 * depending on a students entered classes and their respective hours 
 * 
 */

public class Scheduler {
	
	private ArrayList<SchedulerCourse> classes;
	private ArrayList<ArrayList<SchedulerCourse>> schedules;
	private int numClassHours;

	public Scheduler(int classHours, ArrayList<SchedulerCourse> classes) {
		this.classes = classes;
		this.numClassHours = classHours;
		this.schedules = new ArrayList<ArrayList<SchedulerCourse>>();
		
		//initialize 7 days of the week with an arrayList
		for (int i = 0; i < 6; i++) {
			this.schedules.add(new ArrayList<SchedulerCourse>());
		}
	}
	
	
	public ArrayList<ArrayList<SchedulerCourse>> permutateSchedules(){
		
		this.schedules.clear();
		
//		if (this.classes == null){
//			return this.schedules;
//		}
//		
//		
//		ArrayList<Integer> taken = new ArrayList<Integer>();
//		@SuppressWarnings("unchecked")
//		ArrayList<Class> tempClasses = (ArrayList<Class>) this.classes.clone();
//		if (this.classes == null){
//			return this.schedules;
//		}
//		
//		for (Class theClass : this.classes) {
//			tempClasses.remove(0);
//			
//			for (Integer hour : theClass.getHours()) {
//				Class[] theHours = new Class[this.classHours];
//				taken.clear();
//				taken.add(hour);
//				theHours[hour] = theClass;
//				
//				
//				for (Class theClassInner : this.classes) {
//					if (theClassInner.equals(theClass)){
//						continue;
//					}
//					for (Integer hourInner : theClassInner.getHours()) {
//						if (! taken.contains(hourInner)){
//							theHours[hourInner] = theClassInner;
//							taken.add(hourInner);
//;						}
//					}
//					
//				}
//				
//				if (this.isFull(theHours)) {
//					this.schedules.add(theHours);
//				}
//			}
//			
//		}
			
		return this.schedules;
	}
	
	
	public boolean isFull(Class[] theHours) {
		int count = 0;
		for (Class theClass : theHours){
			if (theClass != null) {
				count++;
			}
			if (count == this.classes.size()){
				return true;
			}
		}
		
		return false;
		
	}
	
}
