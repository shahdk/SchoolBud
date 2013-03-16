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
	
	private ArrayList<double[]> list(double[]... vals){
		ArrayList<double[]> ret = new ArrayList<double[]>();
		for(double[] i: vals){
			ret.add(i);
		}
		return ret;
	}

}
