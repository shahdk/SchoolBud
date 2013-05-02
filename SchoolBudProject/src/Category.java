import java.util.ArrayList;
import java.util.Date;

/**
 * Object to store information on course categories like hw, exams, etc.
 * 
 * @author shahdk
 * 
 */
public class Category {

	/**
	 * Name of the category
	 */
	private String catName;
	/**
	 * Weight of the category
	 */
	private double weight;
	/**
	 * List of items in a category
	 */
	private ArrayList<Item> items;
	/**
	 * Number of items in a category
	 */
	private int numOfItems;
	/**
	 * Starting date of a course
	 */
	private Date startDate;
	/**
	 * End date of a course
	 */
	private Date endDate;

	/**
	 * Initializes a category object with name, and weight
	 * 
	 * @param name
	 * @param weight
	 */
	public Category(String name, double weight) {
		if (weight < 0 || weight > 100 || name.length() == 0) {
			throw new IllegalArgumentException();
		}
		this.catName = name;
		this.weight = weight;
		this.items = new ArrayList<Item>();
		this.numOfItems = this.items.size();
	}

	/**
	 * Initializes a cateogry object with name, weight, and creates a list of
	 * items under the category based on the give number of items.
	 * 
	 * @param name
	 * @param numOfItems
	 * @param weight
	 */
	public Category(String name, int numOfItems, double weight) {
		if (weight < 0 || weight > 100 || name.length() == 0) {
			throw new IllegalArgumentException();
		}
		this.catName = name;
		this.weight = weight;
		this.items = new ArrayList<Item>();
		for (int i = 0; i < numOfItems; i++) {
			Date date = new Date();
			this.items.add(new Item(name + (i + 1), date));
		}
		this.numOfItems = this.items.size();
		this.checkItemUpdateDate();
	}

	/**
	 * Checks for the date when the item was last updated. If the date is before
	 * the start date of the course, it will set the update date of the item to
	 * be the start date of the course. If the update date is after the end date
	 * of the course, then it will set the update date to be the end date of the
	 * course.
	 */
	public void checkItemUpdateDate() {
		for (Item i : this.items) {
			if (this.startDate != null
					&& i.getUpdateDate().before(this.startDate)) {
				i.setUpdateDate(this.startDate);
			} else if (this.endDate != null
					&& i.getUpdateDate().after(this.endDate)) {
				i.setUpdateDate(this.endDate);
			}
		}
	}

	/**
	 * Sets the course start date and checks if an item's update date is after
	 * the course start date.
	 * 
	 * @param startDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
		this.checkItemUpdateDate();
	}

	/**
	 * Sets the course end date and checks if an items's update date is before
	 * the course end date.
	 * 
	 * @param endDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
		this.checkItemUpdateDate();
	}

	/**
	 * Returns the list of items for the cateogory
	 * 
	 * @return arraylist of items
	 */
	public ArrayList<Item> getItemList() {
		return this.items;
	}

	/**
	 * Returns the name of the category
	 * 
	 * @return string name
	 */
	public String getName() {
		return this.catName;
	}

	/**
	 * Returns the weight of the category
	 * 
	 * @return double weight
	 */
	public double getWeight() {
		return this.weight;
	}

	/**
	 * Sets the item list of the category to the given arraylist of items.
	 * 
	 * @param items
	 */
	public void setItemList(ArrayList<Item> items) {
		this.items = new ArrayList<Item>();
		for (int i = 0; i < items.size(); i++) {
			this.items.add(items.get(i));
		}
		this.numOfItems = this.items.size();
	}

	/**
	 * Sets the name of the category to the given name.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		if (name.length() == 0) {
			throw new IllegalArgumentException();
		}
		this.catName = name;
	}

	/**
	 * Sets the wirght of the category to the given name.
	 * 
	 * @param weight
	 */
	public void setWeight(int weight) {
		if (weight < 0 || weight > 100) {
			throw new IllegalArgumentException();
		}
		this.weight = weight;
	}

	/**
	 * Returns the number of items in the category
	 * 
	 * @return int number of items.
	 */
	public int getNumOfItems() {
		return this.numOfItems;
	}

	/**
	 * Adds the given item to the list of existing items.
	 * 
	 * @param item
	 */
	public void addItem(Item item) {
		for (Item i : this.items) {
			if (i.getName().equals(item.getName())) {
				throw new IllegalArgumentException();
			}
		}
		this.items.add(item);
		this.numOfItems = this.items.size();
	}

	/**
	 * Calculates the total points earned in the category
	 * 
	 * @return double total earned points.
	 */
	public double getTotalEarnedPoints() {
		double earnedGrades = 0;
		for (Item i : this.items) {
			double earnedGrade = Double.parseDouble(i.getEarnedPoints());
			earnedGrades += earnedGrade;
		}
		return earnedGrades;
	}

	/**
	 * Calculates the total possible points for the category
	 * 
	 * @return double total possible points.
	 */
	public double getTotalPossiblePoints() {
		double totalGrades = 0;
		for (Item i : this.items) {
			double totalGrade = Double.parseDouble(i.getTotalPoints());
			totalGrades += totalGrade;
		}
		return totalGrades;
	}

	/**
	 * Calculates the percentage earned for the category
	 * 
	 * @return double percentage earned.
	 */
	public double getTotalPoints() {
		double totalPoints = (this.getTotalEarnedPoints() / this
				.getTotalPossiblePoints()) * 100;
		return (Math.round(totalPoints * 100)) / 100.0;
	}

	/**
	 * Removes an item from the list of items, and returns true if successful
	 * else returns false.
	 * 
	 * @param name
	 * @return boolean removed
	 */
	public boolean removeItem(String name) {
		if (this.items.size() == 0) {
			return false;
		}
		int index = -1;
		for (int i = 0; i < this.items.size(); i++) {
			if (this.items.get(i).getName().equals(name)) {
				index = i;
				break;
			}
		}

		if (index == -1) {
			return false;
		}

		this.items.remove(index);
		return true;
	}

}
