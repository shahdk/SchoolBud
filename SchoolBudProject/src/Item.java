import java.util.Date;

/**
 * Stores the information on particular item like the name, earned points, total
 * possible points and the date when the item was last updated.
 * 
 * @author shahdk
 * 
 */
public class Item {

	/**
	 * Points earned for the item
	 */
	private String earnedPoints = "";
	/**
	 * total possible points for an item
	 */
	private String totalPoints = "";
	/**
	 * Stores the name for the item
	 */
	private String name = "";
	/**
	 * Stores the date when the item was last updated
	 */
	private Date updateDate;

	/**
	 * Constructor to initialize an Item object with its name and update date.
	 * 
	 * @param name
	 * @param updateDate
	 */
	public Item(String name, Date updateDate) {
		if (name.length() == 0) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.updateDate = updateDate;
	}

	/**
	 * Constructor to initialize an Item object with its name, total possible
	 * points, and update date.
	 * 
	 * @param name
	 * @param totalPoints
	 * @param updateDate
	 */
	public Item(String name, String totalPoints, Date updateDate) {
		if (name.length() == 0
				|| (!totalPoints.matches("([0-9]+(\\.[0-9]+)?)+"))) {
			throw new IllegalArgumentException();
		}
		try {
			Double temp = Double.parseDouble(totalPoints);
			if (temp.equals(new Double(0))) {
				throw new IllegalArgumentException();
			}
			this.name = name;
			this.totalPoints = totalPoints;
			this.updateDate = updateDate;
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Constructor to initialize an Item object with its name, earned points,
	 * total possible points and update date.
	 * 
	 * @param name
	 * @param earnedPoints
	 * @param totalPoints
	 * @param updateDate
	 */
	public Item(String name, String earnedPoints, String totalPoints,
			Date updateDate) {
		if (name.length() == 0
				|| (!totalPoints.matches("([0-9]+(\\.[0-9]+)?)+"))) {
			throw new IllegalArgumentException();
		}
		try {
			Double temp = Double.parseDouble(totalPoints);
			if (temp.equals(new Double(0))) {
				throw new IllegalArgumentException();
			}
			this.name = name;
			this.earnedPoints = earnedPoints;
			this.totalPoints = totalPoints;
			this.updateDate = updateDate;
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Returns the points earned for the item
	 * 
	 * @return String earned points
	 */
	public String getEarnedPoints() {
		return this.earnedPoints;
	}

	/**
	 * Returns the total possible points for the item.
	 * 
	 * @return String total points.
	 */
	public String getTotalPoints() {
		return this.totalPoints;
	}

	/**
	 * Returns the name of the item
	 * 
	 * @return String name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Returns the date when the item was last updated
	 * 
	 * @return Date update date.
	 */
	public Date getUpdateDate() {
		return this.updateDate;
	}

	/**
	 * Sets the update date for the item to the given date.
	 * 
	 * @param updateDate
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * Sets the earned points for the item to the given points
	 * 
	 * @param earnedPoints
	 */
	public void setEarnedPoints(String earnedPoints) {
		this.earnedPoints = earnedPoints;
	}

	/**
	 * Sets the total points for the item to the given points
	 * 
	 * @param totalPoints
	 */
	public void setTotalPoints(String totalPoints) {
		if (!totalPoints.matches("([0-9]+(\\.[0-9]+)?)+")) {
			throw new IllegalArgumentException();
		}
		try {
			Double temp = Double.parseDouble(totalPoints);
			if (temp.equals(new Double(0))) {
				throw new IllegalArgumentException();
			}
			this.totalPoints = totalPoints;
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Sets the name of the item to the given name.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		if (name.length() == 0) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

}
