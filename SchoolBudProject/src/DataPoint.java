import java.util.Date;


/**
 * Simple Helper class to store 
 * X and Y points for graphing purposes
 */

/**
 * @author John
 *
 */
public class DataPoint {

	private Date x;
	private double y;
	
	
	public DataPoint(Date x, double y) {
		this.setX(x);
		this.setY(y);
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

	/**
	 * @return the x
	 */
	public Date getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(Date x) {
		this.x = x;
	}


	
}
