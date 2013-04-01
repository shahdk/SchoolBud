public class Course {

	private String courseName;
	private double creditHours;

	public Course(String name) {
		this.courseName = name;
		this.creditHours = 0.0;
	}

	public Course(String name, double creditHours) {
		this.courseName = name;
		this.creditHours = creditHours;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public double getCreditHours() {
		return this.creditHours;
	}

}
