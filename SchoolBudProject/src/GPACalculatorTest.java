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
	public void testGPACalculatorInitialze(){
		double[] val = {0, 4};
		GPACalculator obj = new GPACalculator(list(val));
		assertNotNull(obj);
	}
	
	@Test
	public void testTotalGradePointsOne() {
		double[] val = {0, 4};
		GPACalculator obj = new GPACalculator(list(val));
		assertEquals(0, obj.TotalGradePoints(), DELTA);
	}
	
	@Test
	public void testTotalGradePointsTwo() {
		double[] val = {1, 4};
		GPACalculator obj = new GPACalculator(list(val));
		assertEquals(4.0, obj.TotalGradePoints(), DELTA);
	}
	
	@Test
	public void testTotalGradePointsThree() {
		double[] val1 = {3, 4};
		double[] val2 = {1, 3};
		double[] val3 = {3, 2};
		double[] val4 = {4, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4));
		assertEquals(21.0, obj.TotalGradePoints(), DELTA);
	}
	
	@Test
	public void testTotalGradePointsFour() {
		double[] val1 = {3, 0};
		double[] val2 = {1, 3};
		double[] val3 = {3, 2};
		double[] val4 = {4, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4));
		assertEquals(9.0, obj.TotalGradePoints(), DELTA);
	}
	
	
	@Test
	public void testTotalGradePointsFive() {
		double[] val1 = {0, 4};
		double[] val2 = {1, 3};
		double[] val3 = {2, 2};
		double[] val4 = {3, 1};
		double[] val5 = {4, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4, val5));
		assertEquals(10.0, obj.TotalGradePoints(), DELTA);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsExceptionOne() {
		double[] val1 = {3, 4};
		double[] val2 = {1, 3};
		double[] val3 = {-3, 2};
		double[] val4 = {4, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4));
		obj.TotalGradePoints();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsExceptionTwo() {
		double[] val1 = {3, 4};
		double[] val2 = {1, -3};
		double[] val3 = {3, 2};
		double[] val4 = {4, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4));
		obj.TotalGradePoints();
	}
	
	@Test
	public void testTotalGPAOne() {
		double[] val = {1, 4};
		GPACalculator obj = new GPACalculator(list(val));
		assertEquals(4, obj.TotalGPA(), DELTA);
	}
	
	@Test
	public void testTotalGPATwo() {
		double[] val = {1, 4};
		double[] val2 = {3, 2};
		GPACalculator obj = new GPACalculator(list(val, val2));
		assertEquals(2.5, obj.TotalGPA(), DELTA);
	}
	
	@Test
	public void testTotalGPAThree() {
		double[] val1 = {3, 4};
		double[] val2 = {1, 3};
		double[] val3 = {3, 2};
		double[] val4 = {4, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4));
		assertEquals(1.91, obj.TotalGPA(), DELTA);
	}
	
	@Test
	public void testTotalGPAFour() {
		double[] val1 = {4, 4};
		double[] val2 = {4, 3.33};
		double[] val3 = {2, 2.3};
		double[] val4 = {4, 4};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4));
		assertEquals(3.57, obj.TotalGPA(), DELTA);
	}
	
	@Test
	public void testTotalGPAFive() {
		double[] val1 = {3, 3.33};
		double[] val2 = {1, 2.67};
		double[] val3 = {3, 3.5};
		double[] val4 = {4, 1};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4));
		assertEquals(2.47, obj.TotalGPA(), DELTA);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGPAExceptionOne() {
		double[] val1 = {3, 4};
		double[] val2 = {1, 3};
		double[] val3 = {-3, 2};
		double[] val4 = {4, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4));
		obj.TotalGPA();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGPAExceptionTwo() {
		double[] val1 = {3, 4};
		double[] val2 = {1, -3};
		double[] val3 = {3, 2};
		double[] val4 = {4, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4));
		obj.TotalGPA();
	}
	
	@Test(expected=ArithmeticException.class)
	public void testTotalGPAExceptionThree() {
		double[] val1 = {0, 4};
		double[] val2 = {0, 3};
		double[] val3 = {0, 2};
		double[] val4 = {0, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4));
		obj.TotalGPA();
	}
	
	private ArrayList<double[]> list(double[]... vals){
		ArrayList<double[]> ret = new ArrayList<double[]>();
		for(double[] i: vals){
			ret.add(i);
		}
		return ret;
	}

}
