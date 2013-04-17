import java.util.ArrayList;


public class Quarter {
	
	private String quaterName;
	private ArrayList<Course> courseList;

	public Quarter(String name) {
		if(name.length() == 0){
			throw new IllegalArgumentException();
		}
		this.quaterName = name;
		this.courseList = new ArrayList<Course>();
	}

	public String getName() {
		return this.quaterName;
	}

	public void setName(String name) {
		if(name.length()==0){
			throw new IllegalArgumentException();
		}
		this.quaterName = name;
	}

	public void addCourse(Course course) {
		this.courseList.add(course);
	}

	public ArrayList<Course> getCourseList() {
		return this.courseList;
	}

	public boolean removeCourse(Course course) {
		if(this.courseList.isEmpty()){
			return false;
		}
		
		return this.courseList.remove(course);
	}

	public double getTotalCreditHours() {
		double sum = 0;
		for(Course c : this.courseList){
			sum += c.getCreditHours();
		}
		return sum;
	}

}
