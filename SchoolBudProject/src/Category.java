import java.util.ArrayList;


public class Category {

	private String catName;
	private String weight;
	private ArrayList<Item> items;
	private int numOfItems;
	
	public Category(String name, String weight) {
		this.catName = name;
		this.weight = weight;
		this.items = new ArrayList<Item>();
		this.numOfItems = this.items.size();
	}

	public Category(String name, ArrayList<Item> items, String weight) {
		this.catName = name;
		this.weight = weight;
		this.items = items;
		this.numOfItems = this.items.size();
	}

	public ArrayList<Item> getItemList() {
		return this.items;
	}

	public String getName() {
		return this.catName;
	}

	public String getWeight() {
		return this.weight;
	}

	public void setItemList(ArrayList<Item> items) {
		this.items = items;
		this.numOfItems = this.items.size();
	}

	public void setName(String name) {
		this.catName = name;
	}

	public void setWeight(String weight) {
		this.weight = weight;		
	}

	public int getNumOfItems() {
		return this.numOfItems;
	}

}
