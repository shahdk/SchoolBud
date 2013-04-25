import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Course {

	private String courseName;
	private double creditHours;
	private ArrayList<Category> categories;
	private double targetGrade;
	private Rubric courseRubric;
	private Date startDate, endDate;

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
	
	public Course(String name, double creditHours, Date startDate, Date endDate){
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
	
	public Course(String name, Date startDate, Date endDate){
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

	public String getCourseName() {
		return this.courseName;
	}

	public double getCreditHours() {
		return this.creditHours;
	}

	public void setName(String name) {
		if (name.length() == 0) {
			throw new IllegalArgumentException();
		}
		this.courseName = name;
	}

	public void setCreditHours(double creditHours) {
		if (creditHours < 0) {
			throw new IllegalArgumentException();
		}
		this.creditHours = creditHours;
	}

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

	public ArrayList<Category> getCategories() {
		return this.categories;
	}

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

	public double getTargetGrade() {
		return this.targetGrade;
	}

	public void setTargetGrade(double targetGrade) {
		if (targetGrade < 0 || targetGrade > 100) {
			throw new IllegalArgumentException();
		}
		this.targetGrade = targetGrade;
	}

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

	public Rubric getRubric() {
		return this.courseRubric;
	}

	public void setRubric(Rubric rubric){
		for(String s: rubric.getGradeList()){
			this.courseRubric.addGrade(s, rubric.getLowerLimit(s), rubric.getUpperLimit(s), rubric.getGPA(s));
		}
//		this.courseRubric = rubric;
	}

	public String getLetterGrade() {

		double courseGrade = ((int) (this.getCourseGrade()+0.5));
		for (String grade : this.courseRubric.getGradeList()) {
			double lower = this.courseRubric.getLowerLimit(grade);
			double upper = this.courseRubric.getUpperLimit(grade);
			if((upper == 100 && courseGrade > upper) || (lower == 0 && courseGrade < lower) || (courseGrade >= lower && courseGrade <= upper)){
				return grade;
			}
		}
		return "";
	}

	public double getCourseGPA() {
		return this.courseRubric.getGPA(this.getLetterGrade());
	}
	
	public void setEndDate(Date dt){
		
		if(this.startDate != null && dt.before(this.startDate)){
			throw new IllegalArgumentException();
		}
		
		this.endDate = dt;
		for(Category cat: this.categories){
			cat.setEndDate(this.endDate);
		}
	}
	
	public void setStartDate(Date dt){

		if(this.endDate != null && dt.after(this.endDate)){
			throw new IllegalArgumentException();
		}
		
		this.startDate = dt;
		for(Category cat: this.categories){
			cat.setStartDate(this.startDate);
		}
	}
	
	public Date getStartDate(){
		return this.startDate;
	}
	
	public Date getEndDate(){
		return this.endDate;
	}

	public HashMap<String, Integer> getItemFrequency(Date limit) {
		HashMap<String, Integer> frequencies = new HashMap<String, Integer>();
		
		if(limit.before(this.startDate) || limit.after(this.endDate)){
			throw new IllegalArgumentException();
		}
		
		for(Category cat: this.categories){
			int count = 0;
			for(Item i: cat.getItemList()){
				Date creationDate = i.getCreationDate();
				if(creationDate.before(limit) || creationDate.equals(limit)){
					count++;
				}
			}
			frequencies.put(cat.getName(), count);
		}
		
		return frequencies;
	}

}
