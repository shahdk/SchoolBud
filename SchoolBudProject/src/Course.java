public class Course {

	private String courseName;
	private double creditHours;

	public Course(String name) {
		if(name.length()==0){
			throw new IllegalArgumentException();
		}
		this.courseName = name;
		this.creditHours = 0.0;
	}

	public Course(String name, double creditHours) {
		if(name.length()==0 || creditHours < 0){
			throw new IllegalArgumentException();
		}
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
