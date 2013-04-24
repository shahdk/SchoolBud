
/**
 * Simple Helper class to store 
 * X and Y points for graphing purposes
 */

/**
 * @author John
 *
 */
public class DataPoint {

	private int x;
	private int y;
	
	
	public DataPoint(int x, int y) {
		this.setX(x);
		this.setY(y);
	}


	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}


	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}


	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}


	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	
}
