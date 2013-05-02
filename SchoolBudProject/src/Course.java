import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Object that stores information about a particular course.
 * 
 * @author shahdk
 * 
 */
public class Course {

	/**
	 * Name of the course
	 */
	private String courseName;
	/**
	 * Credit hours for the course.
	 */
	private double creditHours;
	/**
	 * List of categories under the course.
	 */
	private ArrayList<Category> categories;
	/**
	 * Target grade for the course.
	 */
	private double targetGrade;
	/**
	 * Rubric for the course.
	 */
	private Rubric courseRubric;
	/**
	 * Start date for the course
	 */
	private Date startDate;
	/**
	 * End date for the course
	 */
	private Date endDate;

	/**
	 * Constructor to initialize the course with a name
	 * 
	 * @param name
	 */
	public Course(String name) {
		if (name.length() == 0) {
			throw new IllegalArgumentException();
		}
		this.courseName = name;
		this.creditHours = 0.0;
		this.categories = new ArrayList<Category>();
		this.targetGrade = 0;
		this.courseRubric = new Rubric();
	}

	/**
	 * Constructor to initialize the course with name, and credit hours.
	 * 
	 * @param name
	 * @param creditHours
	 */
	public Course(String name, double creditHours) {
		if (name.length() == 0 || creditHours < 0) {
			throw new IllegalArgumentException();
		}
		this.courseName = name;
		this.creditHours = creditHours;
		this.categories = new ArrayList<Category>();
		this.targetGrade = 0;
		this.courseRubric = new Rubric();
	}

	/**
	 * Constructor to initialize a course with name, credit hours, start and end
	 * date.
	 * 
	 * @param name
	 * @param creditHours
	 * @param startDate
	 * @param endDate
	 */
	public Course(String name, double creditHours, Date startDate, Date endDate) {
		if (name.length() == 0) {
			throw new IllegalArgumentException();
		}
		this.courseName = name;
		this.creditHours = creditHours;
		this.categories = new ArrayList<Category>();
		this.targetGrade = 0;
		this.courseRubric = new Rubric();
		this.setStartDate(startDate);
		this.setEndDate(endDate);
	}

	/**
	 * Constructor to initialize a course with name, start and end date.
	 * 
	 * @param name
	 * @param startDate
	 * @param endDate
	 */
	public Course(String name, Date startDate, Date endDate) {
		if (name.length() == 0) {
			throw new IllegalArgumentException();
		}
		this.courseName = name;
		this.creditHours = 0.0;
		this.categories = new ArrayList<Category>();
		this.targetGrade = 0;
		this.courseRubric = new Rubric();
		this.setStartDate(startDate);
		this.setEndDate(endDate);
	}

	/**
	 * Returns the name of the course
	 * 
	 * @return string name
	 */
	public String getCourseName() {
		return this.courseName;
	}

	/**
	 * Returns the credit hours for the course
	 * 
	 * @return double credit hours
	 */
	public double getCreditHours() {
		return this.creditHours;
	}

	/**
	 * Sets the name of the course to the given name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		if (name.length() == 0) {
			throw new IllegalArgumentException();
		}
		this.courseName = name;
	}

	/**
	 * Sets the credit hours of a course to the given credit hours and throws an
	 * exception if the given credit hours is negative
	 * 
	 * @param creditHours
	 */
	public void setCreditHours(double creditHours) {
		if (creditHours < 0) {
			throw new IllegalArgumentException();
		}
		this.creditHours = creditHours;
	}

	/**
	 * Adds the given category to the list of categories of the course
	 * 
	 * @param cat
	 */
	public void addCategory(Category cat) {
		double weight = 0;
		for (Category c : this.categories) {
			weight += c.getWeight();
			if (weight + cat.getWeight() > 100
					|| cat.getName().equals(c.getName())) {
				throw new IllegalArgumentException();
			}
		}
		this.categories.add(cat);
	}

	/**
	 * Returns the list of categories for the course
	 * 
	 * @return arraylist of the categories
	 */
	public ArrayList<Category> getCategories() {
		return this.categories;
	}

	/**
	 * Returns the percentage earned for the course.
	 * 
	 * @return double percent earned
	 */
	public double getCourseGrade() {
		double totalWeight = 0;
		double totalGrade = 0;

		for (Category c : this.categories) {
			totalWeight += c.getWeight();
			totalGrade += (c.getTotalPoints() * c.getWeight());
		}

		double courseGrade = totalGrade / totalWeight;
		double percent = Math.round(courseGrade * 100.0);
		return percent / 100.0;
	}

	/**
	 * Returns the target grade for the course
	 * 
	 * @return double target grade
	 */
	public double getTargetGrade() {
		return this.targetGrade;
	}

	/**
	 * Sets the target grade to give grade
	 * 
	 * @param targetGrade
	 */
	public void setTargetGrade(double targetGrade) {
		if (targetGrade < 0 || targetGrade > 100) {
			throw new IllegalArgumentException();
		}
		this.targetGrade = targetGrade;
	}

	/**
	 * Returns the percentage needed to meet the target grade
	 * 
	 * @return double percent needed
	 */
	public double getNeededCourseGrade() {
		double totalWeight = 0;
		double totalGrade = 0;

		for (Category c : this.categories) {
			totalWeight += c.getWeight();
			totalGrade += (c.getTotalPoints() * c.getWeight() / 100);
		}

		double remainingWeight = (100 - totalWeight) / 100;
		double remainingGrade = this.targetGrade - totalGrade;

		double neededGrade = remainingGrade / remainingWeight;

		double percent = Math.round(neededGrade * 100);
		return percent / 100;
	}

	/**
	 * Removes the given category from the list of categories in the course.
	 * 
	 * @param name
	 * @return true if successfully removed
	 */
	public boolean removeCategory(String name) {
		if (this.categories.size() == 0) {
			return false;
		}
		int index = -1;
		for (int i = 0; i < this.categories.size(); i++) {
			if (this.categories.get(i).getName().equals(name)) {
				index = i;
				break;
			}
		}

		if (index == -1) {
			return false;
		}

		this.categories.remove(index);
		return true;
	}

	/**
	 * Returns the rubric associated with the course
	 * 
	 * @return Rubric
	 */
	public Rubric getRubric() {
		return this.courseRubric;
	}

	/**
	 * Sets the course rubric to the given rubric
	 * 
	 * @param rubric
	 */
	public void setRubric(Rubric rubric) {
		for (String s : rubric.getGradeList()) {
			this.courseRubric.addGrade(s, rubric.getLowerLimit(s),
					rubric.getUpperLimit(s), rubric.getGPA(s));
		}
	}

	/**
	 * Calculates the letter grade for the course based on the percent earned
	 * and the associated rubric.
	 * 
	 * @return String letter grade
	 */
	public String getLetterGrade() {

		double courseGrade = ((int) (this.getCourseGrade() + 0.5));
		for (String grade : this.courseRubric.getGradeList()) {
			double lower = this.courseRubric.getLowerLimit(grade);
			double upper = this.courseRubric.getUpperLimit(grade);
			if ((upper == 100 && courseGrade > upper)
					|| (lower == 0 && courseGrade < lower)
					|| (courseGrade >= lower && courseGrade <= upper)) {
				return grade;
			}
		}
		return "";
	}

	/**
	 * Calculates the GPA for the course based on the percent earned and the
	 * associated rubric.
	 * 
	 * @return double course GPA
	 */
	public double getCourseGPA() {
		return this.courseRubric.getGPA(this.getLetterGrade());
	}

	/**
	 * Sets the end date for the course to the given end date
	 * 
	 * @param dt
	 */
	public void setEndDate(Date dt) {

		if (this.startDate != null && dt.before(this.startDate)) {
			throw new IllegalArgumentException();
		}

		this.endDate = dt;
		for (Category cat : this.categories) {
			cat.setEndDate(this.endDate);
		}
	}

	/**
	 * Sets the start date of a course to the given start date.
	 * 
	 * @param dt
	 */
	public void setStartDate(Date dt) {

		if (this.endDate != null && dt.after(this.endDate)) {
			throw new IllegalArgumentException();
		}

		this.startDate = dt;
		for (Category cat : this.categories) {
			cat.setStartDate(this.startDate);
		}
	}

	/**
	 * Returns the start date of the course
	 * 
	 * @return Date start date
	 */
	public Date getStartDate() {
		return this.startDate;
	}

	/**
	 * Returns the end date of the course
	 * 
	 * @return Date end date
	 */
	public Date getEndDate() {
		return this.endDate;
	}

	/**
	 * Calculates the frequencies of the items from the start of the course to
	 * the given date.
	 * 
	 * @param limit
	 * @return HashMap<String, Integer> frequency of items.
	 */
	public HashMap<String, Integer> getItemFrequency(Date start, Date end) {
		HashMap<String, Integer> frequencies = new HashMap<String, Integer>();

		if (end.before(start) || start.after(end)) {
			throw new IllegalArgumentException();
		}

		for (Category cat : this.categories) {
			int count = 0;
			for (Item i : cat.getItemList()) {
				Date creationDate = i.getUpdateDate();
				if ((creationDate.before(end) || creationDate.equals(end)) && (creationDate.after(start) || creationDate.equals(start))) {
					count++;
				}
			}
			frequencies.put(cat.getName(), count);
		}

		return frequencies;
	}

}
