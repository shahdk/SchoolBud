import java.util.ArrayList;
import java.util.HashMap;

public class Course {

	private Item courseItem;

	public Course(String itemName, double weight) {
		this.courseItem = new Item(itemName, weight);
	}

	public Course(String item, ArrayList<String> subItem, double earnedPoints,
			double totalPoints) {
		this.courseItem = new Item(item, subItem, earnedPoints, totalPoints);
	}

	private class Item {

		private String itemName;
		private ArrayList<String> subItem;
		private double weight, earnedPoints, totalPoints;

		public Item(String itemName, double weight) {
			this.itemName = itemName;
			this.weight = weight;
		}

		public Item(String item, ArrayList<String> subItem,
				double earnedPoints, double totalPoints) {
			this.itemName = item;
			this.subItem = subItem;
			this.earnedPoints = earnedPoints;
			this.totalPoints = totalPoints;
		}

	}
}
