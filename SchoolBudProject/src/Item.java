import java.text.SimpleDateFormat;
import java.util.Date;

public class Item {

	private String earnedPoints = "";
	private String totalPoints = "";
	private String name = "";
	private String creationDate;
	private SimpleDateFormat dtFormat = new SimpleDateFormat("MM/dd/yyyy");

	public Item(String name, Date creationDate) {
		if (name.length() == 0) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.creationDate = this.dtFormat.format(creationDate);
		System.out.println(this.creationDate);
	}

	public Item(String name, String totalPoints, Date creationDate) {
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
			this.creationDate = this.dtFormat.format(creationDate);
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}

	public Item(String name, String earnedPoints, String totalPoints, Date creationDate) {
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
			this.creationDate = this.dtFormat.format(creationDate);
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}

	public String getEarnedPoints() {
		return this.earnedPoints;
	}

	public String getTotalPoints() {
		return this.totalPoints;
	}

	public String getName() {
		return this.name;
	}
	
	public String getCreationDate(){
		return this.creationDate;
	}
	
	public void setCreationdate(Date creationDate){
		this.creationDate = this.dtFormat.format(creationDate);
	}

	public void setEarnedPoints(String earnedPoints) {
		this.earnedPoints = earnedPoints;
	}

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

	public void setName(String name) {
		if (name.length() == 0) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

}
