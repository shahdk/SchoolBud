
public class Item {
	
	private String weight = "";
	private String earnedPoints = "";
	private String totalPoints = "";
	private String name = "";

	public Item(String name, String weight) {
		this.name = name;
		this.weight = weight;
	}

	public Item(String name, String totalPoints, String weight) {
		this.name = name;
		this.weight = weight;
		this.totalPoints = totalPoints;
	}

	public Item(String name, String earnedPoints, String totalPoints, String weight) {
		this.name = name;
		this.weight = weight;
		this.earnedPoints = earnedPoints;
		this.totalPoints = totalPoints;
	}

}
