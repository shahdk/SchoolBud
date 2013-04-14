import java.util.ArrayList;

public class Course {

	private String courseName;
	private double creditHours;
	private ArrayList<Category> categories;
	private double targetGrade;

	public Course(String name) {
		if (name.length() == 0) {
			throw new IllegalArgumentException();
		}
		this.courseName = name;
		this.creditHours = 0.0;
		this.categories = new ArrayList<Category>();
		this.targetGrade = 0;
	}

	public Course(String name, double creditHours) {
		if (name.length() == 0 || creditHours < 0) {
			throw new IllegalArgumentException();
		}
		this.courseName = name;
		this.creditHours = creditHours;
		this.categories = new ArrayList<Category>();
		this.targetGrade = 0;
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
			if (weight + cat.getWeight() > 100 || cat.getName().equals(c.getName())) {
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
		return percent/100;
	}

	public boolean removeCategory(String name) {
		if(this.categories.size() == 0){
			return false;
		}
		int index = -1;
		for(int i=0; i<this.categories.size(); i++){
			if(this.categories.get(i).getName().equals(name)){
				index = i;
				break;
			}
		}
		
		if(index == -1){
			return false;
		}
		
		this.categories.remove(index);
		return true;
	}

}
