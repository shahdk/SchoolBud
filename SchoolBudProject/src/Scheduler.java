import java.util.ArrayList;

/* The Scheduler class finds all of the permutations of possible schedules
 * depending on a students entered classes and their respective hours 
 * 
 */

public class Scheduler {
	
	private ArrayList<Class> classes;
	private ArrayList<Class[]> schedules;
	private int classHours;

	public Scheduler(int classHours, ArrayList<Class> classes) {
		this.classes = classes;
		this.classHours = classHours + 1;
		this.schedules = new ArrayList<Class[]>();
	}
	
	
	public ArrayList<Class[]> permutateSchedules(){
		
		this.schedules.clear();
		
		if (this.classes == null){
			return this.schedules;
		}
		
		
		ArrayList<Integer> taken = new ArrayList<Integer>();
		@SuppressWarnings("unchecked")
		ArrayList<Class> tempClasses = (ArrayList<Class>) this.classes.clone();
		if (this.classes == null){
			return this.schedules;
		}
		
		for (Class theClass : this.classes) {
			tempClasses.remove(0);
			
			for (Integer hour : theClass.getHours()) {
				Class[] theHours = new Class[this.classHours];
				taken.clear();
				taken.add(hour);
				theHours[hour] = theClass;
				
				
				for (Class theClassInner : this.classes) {
					if (theClassInner.equals(theClass)){
						continue;
					}
					for (Integer hourInner : theClassInner.getHours()) {
						if (! taken.contains(hourInner)){
							theHours[hourInner] = theClassInner;
							taken.add(hourInner);
;						}
					}
					
				}
				
				if (this.isFull(theHours)) {
					this.schedules.add(theHours);
				}
			}
			
		}
			
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
