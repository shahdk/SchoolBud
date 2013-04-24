import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * @author John
 *
 */
public class GradeTrendGraphTest {

	
	//Test DataPoint Helper Class
	@Test
	public void testDataPointHelperClass() {
		
		DataPoint point = new DataPoint(5, 8);
		
		//test getters
		 assertEquals(5, point.getX());
		 assertEquals(8, point.getY());
		 
		//test setters
		 point.setX(6);
		 point.setY(0);
		 
		 assertEquals(6, point.getX());
		 assertEquals(0, point.getY());
		 
	}
	
	@Test
	public void test() {
		
	}

}
