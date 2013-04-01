
public class Course {

	private String courseName;
	private double creditHours;
	
	public Course(String name){
		this.courseName = name;
	}

	public Course(String name, double creditHours) {
		this.courseName = name;
		this.creditHours = creditHours;
	}
	
}
