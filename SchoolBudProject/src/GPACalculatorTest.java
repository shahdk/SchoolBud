import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;


public class GPACalculatorTest {

	private static final double DELTA = 1e-15;
	
	@Test
	public void testJUnit() {
		assertTrue("JUnit works!", true);
	}
	
	@Test
	public void testGPACalculatorInitialze(){
		double[] val = {0, 4};
		assertNotNull(new GPACalculator(list(val)));
	}
	
	@Test
	public void testTotalGradePointsOne() {
		double[] val = {0, 4};
		assertEquals(0, GPACalculator.TotalGradePoints(list(val)), DELTA);
	}
	
	@Test
	public void testTotalGradePointsTwo() {
		double[] val = {1, 4};
		assertEquals(4.0, GPACalculator.TotalGradePoints(list(val)), DELTA);
	}
	
	@Test
	public void testTotalGradePointsThree() {
		double[] val1 = {3, 4};
		double[] val2 = {1, 3};
		double[] val3 = {3, 2};
		double[] val4 = {4, 0};
		assertEquals(21.0, GPACalculator.TotalGradePoints(list(val1, val2, val3, val4)), DELTA);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsExceptionOne() {
		double[] val1 = {3, 4};
		double[] val2 = {1, 3};
		double[] val3 = {-3, 2};
		double[] val4 = {4, 0};
		GPACalculator.TotalGradePoints(list(val1, val2, val3, val4));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsExceptionTwo() {
		double[] val1 = {3, 4};
		double[] val2 = {1, -3};
		double[] val3 = {3, 2};
		double[] val4 = {4, 0};
		GPACalculator.TotalGradePoints(list(val1, val2, val3, val4));
	}
	
	@Test
	public void testTotalGPAOne() {
		double[] val = {1, 4};
		assertEquals(4, GPACalculator.TotalGPA(list(val)), DELTA);
	}
	
	@Test
	public void testTotalGPATwo() {
		double[] val = {1, 4};
		double[] val2 = {3, 2};
		assertEquals(2.5, GPACalculator.TotalGPA(list(val, val2)), DELTA);
	}
	
	@Test
	public void testTotalGPAThree() {
		double[] val1 = {3, 4};
		double[] val2 = {1, 3};
		double[] val3 = {3, 2};
		double[] val4 = {4, 0};
		assertEquals(1.91, GPACalculator.TotalGPA(list(val1, val2, val3, val4)), DELTA);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGPAExceptionOne() {
		double[] val1 = {3, 4};
		double[] val2 = {1, 3};
		double[] val3 = {-3, 2};
		double[] val4 = {4, 0};
		GPACalculator.TotalGPA(list(val1, val2, val3, val4));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGPAExceptionTwo() {
		double[] val1 = {3, 4};
		double[] val2 = {1, -3};
		double[] val3 = {3, 2};
		double[] val4 = {4, 0};
		GPACalculator.TotalGPA(list(val1, val2, val3, val4));
	}
	
	@Test(expected=ArithmeticException.class)
	public void testTotalGPAExceptionThree() {
		double[] val1 = {0, 4};
		double[] val2 = {0, 3};
		double[] val3 = {0, 2};
		double[] val4 = {0, 0};
		GPACalculator.TotalGPA(list(val1, val2, val3, val4));
	}
	
	private ArrayList<double[]> list(double[]... vals){
		ArrayList<double[]> ret = new ArrayList<double[]>();
		for(double[] i: vals){
			ret.add(i);
		}
		return ret;
	}

}
