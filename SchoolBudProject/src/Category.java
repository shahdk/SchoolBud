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
		for (int i = 0; i < numOfItems; i++) {
			this.items.add(new Item(name + (i + 1)));
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
		this.weight = weight;
	}

	public int getNumOfItems() {
		return this.numOfItems;
	}

	public void addItem(Item item) {
		for(Item i: this.items){
			if(i.getName().equals(item.getName())){
				throw new IllegalArgumentException();
			}
		}
		this.items.add(item);
		this.numOfItems = this.items.size();
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

	public boolean removeItem(String name) {
		if(this.items.size() == 0){
			return false;
		}
		int index = -1;
		for(int i=0; i<this.items.size(); i++){
			if(this.items.get(i).getName().equals(name)){
				index = i;
				break;
			}
		}
		
		if(index == -1){
			return false;
		}
		
		this.items.remove(index);
		return true;
	}

}
