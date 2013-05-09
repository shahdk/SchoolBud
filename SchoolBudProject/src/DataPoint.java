
/**
 * Simple Helper class to store 
 * X and Y points for graphing purposes
 */

/**
 * @author John
 *
 */
public class DataPoint {

	private double x;
	private double y;
	
	
	public DataPoint(double x, double y) {
		this.setX(x);
		this.setY(y);
	}


	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}


	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}


	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}


	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}


	
}
