import java.util.ArrayList;

public class Course {

	private String courseName;
	private double creditHours;
	private ArrayList<Category> categories;

	public Course(String name) {
		if(name.length()==0){
			throw new IllegalArgumentException();
		}
		this.courseName = name;
		this.creditHours = 0.0;
		this.categories = new ArrayList<Category>();
	}

	public Course(String name, double creditHours) {
		if(name.length()==0 || creditHours < 0){
			throw new IllegalArgumentException();
		}
		this.courseName = name;
		this.creditHours = creditHours;
		this.categories = new ArrayList<Category>();
	}

	public String getCourseName() {
		return this.courseName;
	}

	public double getCreditHours() {
		return this.creditHours;
	}

	public void setName(String name) {
		if(name.length()==0){
			throw new IllegalArgumentException();
		}
		this.courseName = name;
	}

	public void setCreditHours(double creditHours) {
		if(creditHours < 0){
			throw new IllegalArgumentException();
		}
		this.creditHours = creditHours;
	}

	public void addCategory(Category cat) {
		double weight = 0;
		for (Category c: this.categories){
			weight += c.getWeight();
			if(weight+cat.getWeight() > 100){
				throw new IllegalArgumentException();
			}
		}
		this.categories.add(cat);
	}

	public ArrayList<Category> getCategories() {
		return this.categories;
	}

}
