import java.util.ArrayList;


/* This creates a CLASS class to store the info about normal classes
 * Includes getters and setters
 */

public class Class {
	
	private String name;
	private String teacher;
	private ArrayList<Integer> hours;
	
	
	public Class (String className, String teacherName, ArrayList<Integer> hours) {
		this.setName(className);
		this.setTeacher(teacherName);
		this.setHours(hours);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTeacher() {
		return teacher;
	}


	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}


	public ArrayList<Integer> getHours() {
		return hours;
	}


	public void setHours(ArrayList<Integer> hours) {
		this.hours = hours;
	}
	
}
