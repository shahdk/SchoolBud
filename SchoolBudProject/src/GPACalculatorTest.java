import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class GPACalculatorTest {

	private static final double DELTA = 1e-15;
	
	@Test
	public void testJUnit() {
		assertTrue("JUnit works!", true);
	}
	
	@Test
	public void testTotalGradePointsOne() {
		double[] val = {0, 4};
		assertEquals(0, GPACalculator.TotalGrapdePoints(list(val)), DELTA);
	}
	
	@Test
	public void testTotalGradePointsTwo() {
		double[] val = {1, 4};
		assertEquals(4.0, GPACalculator.TotalGrapdePoints(list(val)), DELTA);
	}
	
	@Test
	public void testTotalGradePointsThree() {
		double[] val1 = {3, 4};
		double[] val2 = {1, 3};
		double[] val3 = {3, 2};
		double[] val4 = {4, 0};
		assertEquals(21.0, GPACalculator.TotalGrapdePoints(list(val1, val2, val3, val4)), DELTA);
	}
	
	private ArrayList<double[]> list(double[]... vals){
		ArrayList<double[]> ret = new ArrayList<double[]>();
		for(double[] i: vals){
			ret.add(i);
		}
		return ret;
	}

}
