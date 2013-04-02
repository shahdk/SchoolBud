
public class Item {
	
	private double weight = 0;
	private String earnedPoints = "";
	private String totalPoints = "";
	private String name = "";

	public Item(String name, double weight) {
		if (weight < 0 || weight > 100 || name.length()==0) { 
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.weight = weight;
	}

	public Item(String name, String totalPoints, double weight) {
		if (weight < 0 || weight > 100 || name.length()==0 || (!totalPoints.matches("([0-9]+(\\.[0-9]+)?)+"))) { 
			throw new IllegalArgumentException();
		}
		try{
			Double temp = Double.parseDouble(totalPoints);
			if(temp.equals(new Double(0))){
				throw new IllegalArgumentException();
			}
			this.name = name;
			this.weight = weight;
			this.totalPoints = totalPoints;
		}catch (Exception e){
			throw new IllegalArgumentException();
		}
	}

	public Item(String name, String earnedPoints, String totalPoints, double weight) {
		if (weight<0 || weight > 100 || name.length()==0 || (!totalPoints.matches("([0-9]+(\\.[0-9]+)?)+"))) { 
			throw new IllegalArgumentException();
		}
		try{
			Double temp = Double.parseDouble(totalPoints);
			if(temp.equals(new Double(0))){
				throw new IllegalArgumentException();
			}
			this.name = name;
			this.weight = weight;
			this.earnedPoints = earnedPoints;
			this.totalPoints = totalPoints;
		}catch (Exception e){
			throw new IllegalArgumentException();
		}
	}

	public String getEarnedPoints() {
		return this.earnedPoints;
	}

	public String getTotalPoints() {
		return this.totalPoints;
	}

	public double getWeight() {
		return this.weight;
	}

	public String getName() {
		return this.name;
	}

	public void setEarnedPoints(String earnedPoints) {
		this.earnedPoints = earnedPoints;
	}

	public void setTotalPoints(String totalPoints) {
		if(!totalPoints.matches("([0-9]+(\\.[0-9]+)?)+")){
			throw new IllegalArgumentException();
		}try{
			Double temp = Double.parseDouble(totalPoints);
			if(temp.equals(new Double(0))){
				throw new IllegalArgumentException();
			}
			this.totalPoints = totalPoints;
		}catch (Exception e){
			throw new IllegalArgumentException();
		}
	}

	public void setWeight(double weight) {
		if(weight < 0 || weight > 100){
			throw new IllegalArgumentException();
		}
		this.weight = weight;
	}

	public void setName(String name) {
		if(name.length() == 0){
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

}
