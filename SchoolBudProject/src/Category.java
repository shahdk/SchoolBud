import java.util.ArrayList;


public class Category {

	private String catName;
	private String weight;
	private ArrayList<Item> items;
	
	public Category(String name, String weight) {
		this.catName = name;
		this.weight = weight;
		this.items = new ArrayList<Item>();
	}

	public Category(String name, ArrayList<Item> items, String weight) {
		this.catName = name;
		this.weight = weight;
		this.items = items;
	}

}
