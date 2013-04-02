import java.util.ArrayList;

public class Category {

	private String catName;
	private double weight;
	private ArrayList<Item> items;
	private int numOfItems;

	public Category(String name, double weight) {
		if (weight < 0 || weight > 100 || name.length() == 0) {
			throw new IllegalArgumentException();
		}
		this.catName = name;
		this.weight = weight;
		this.items = new ArrayList<Item>();
		this.numOfItems = this.items.size();
	}

	public Category(String name, int numOfItems, double weight) {
		if (weight < 0 || weight > 100 || name.length() == 0) {
			throw new IllegalArgumentException();
		}
		this.catName = name;
		this.weight = weight;
		this.items = new ArrayList<Item>();
		double eachWeight = weight / numOfItems;
		for (int i = 0; i < numOfItems; i++) {
			this.items.add(new Item(name + (i + 1), eachWeight));
		}
		this.numOfItems = this.items.size();
	}

	public ArrayList<Item> getItemList() {
		return this.items;
	}

	public String getName() {
		return this.catName;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setItemList(ArrayList<Item> items) {
		this.items = new ArrayList<Item>();
		for (int i = 0; i < items.size(); i++) {
			this.items.add(items.get(i));
		}
		this.numOfItems = this.items.size();
	}

	public void setName(String name) {
		if (name.length() == 0) {
			throw new IllegalArgumentException();
		}
		this.catName = name;
	}

	public void setWeight(int weight) {
		if (weight < 0 || weight > 100) {
			throw new IllegalArgumentException();
		}

		if (this.numOfItems > 0) {
			double eachWeight = weight / this.numOfItems;
			for (int i = 0; i < numOfItems; i++) {
				this.items.get(i).setWeight(eachWeight);
			}
		}
		this.weight = weight;
	}

	public int getNumOfItems() {
		return this.numOfItems;
	}

	public void addItem(Item item) {
		this.items.add(item);
		this.numOfItems = this.items.size();
		if (this.numOfItems > 0) {
			double eachWeight = this.weight / this.numOfItems;
			eachWeight = Math.round(eachWeight * 100) / 100.00;
			for (int i = 0; i < this.numOfItems; i++) {
				this.items.get(i).setWeight(eachWeight);
			}
		}
	}

	public double getTotalEarnedPoints() {
		double earnedGrades = 0;
		for (Item i : this.items) {
			double earnedGrade = Double.parseDouble(i.getEarnedPoints());
			earnedGrades += earnedGrade;
		}
		return earnedGrades;
	}

	public double getTotalPossiblePoints() {
		double totalGrades = 0;
		for (Item i : this.items) {
			double totalGrade = Double.parseDouble(i.getTotalPoints());
			totalGrades += totalGrade;
		}
		return totalGrades;
	}

	public double getTotalPoints() {
		double totalPoints = (this.getTotalEarnedPoints() / this
				.getTotalPossiblePoints()) * 100;
		return (Math.round(totalPoints * 100)) / 100.0;
	}

}
