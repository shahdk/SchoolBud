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
		this.aSchedule = new ArrayList<ArrayList<SchedulerCourse>>();
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
		
		//go through each class
		for (SchedulerCourse course : this.classes) {
			
			//go through each class section
			for (ArrayList<ClassDay> section : course.getScheduleHours()) {
				
				//go through each day
				for (ClassDay day : section) {
					
					//compare each day's hours with the hours of
					//every other class' section's hours and check for overlap
					//when there is an overlap - skip that section
					
				}
			}
			
		}
		
		return this.schedules;
	}

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
