import java.util.ArrayList;

/**
 * Stores the information about a Quarter, including its name, and a list of
 * courses associated with it.
 * 
 * @author shahdk
 * 
 */
public class Quarter {

	/**
	 * Stores the name of the quarter.
	 */
	private String quaterName;
	/**
	 * Stores the list of course associated with the quarter.
	 */
	private ArrayList<Course> courseList;

	/**
	 * Constructor to initialize the Quarter object with its name.
	 * 
	 * @param name
	 */
	public Quarter(String name) {
		if (name.length() == 0) {
			throw new IllegalArgumentException();
		}
		this.quaterName = name;
		this.courseList = new ArrayList<Course>();
	}

	/**
	 * Returns the name of the quarter.
	 * 
	 * @return String name
	 */
	public String getName() {
		return this.quaterName;
	}

	/**
	 * Sets the name of the quarter to the given name.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		if (name.length() == 0) {
			throw new IllegalArgumentException();
		}
		this.quaterName = name;
	}

	/**
	 * Adds the given course to the list of courses for the Quarter.
	 * 
	 * @param course
	 */
	public void addCourse(Course course) {
		this.courseList.add(course);
	}

	/**
	 * Returns the list of courses in the quarter.
	 * 
	 * @return ArryaList<Course>
	 */
	public ArrayList<Course> getCourseList() {
		return this.courseList;
	}

	/**
	 * Removes the given course from the list of courses for the quarter.
	 * 
	 * @param course
	 * @return true if successful in removing.
	 */
	public boolean removeCourse(Course course) {
		if (this.courseList.isEmpty()) {
			return false;
		}

		return this.courseList.remove(course);
	}

	/**
	 * Calculates the total credit hours taken during the quarter.
	 * 
	 * @return double total credit hours
	 */
	public double getTotalCreditHours() {
		double sum = 0;
		for (Course c : this.courseList) {
			sum += c.getCreditHours();
		}
		return sum;
	}

	/**
	 * Calculates the GPA earned for the quarter
	 * 
	 * @return double GPA
	 */
	public double getQuarterGPA() {

		double sumCreditHours = 0;
		double totalCreditPoints = 0;
		for (Course c : this.courseList) {
			sumCreditHours += c.getCreditHours();
			totalCreditPoints += (c.getCourseGPA() * c.getCreditHours());
		}
		double gpa = Math.round((totalCreditPoints / sumCreditHours) * 100.0);
		return gpa / 100;
	}

}
