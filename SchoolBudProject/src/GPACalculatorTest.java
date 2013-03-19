import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class GPACalculatorTest {

	private static final double DELTA = 1e-15;
	private static final double maxCreditHours = 4.0;
	private static final double maxGPA = 4.0;
	
	@Test
	public void testJUnit() {
		assertTrue("JUnit works!", true);
	}
	
	@Test
	public void testGPACalculatorInitialze(){
		double[] val = {0, 4};
		GPACalculator obj = new GPACalculator(list(val), maxCreditHours, maxGPA);
		assertNotNull(obj);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithNegativeCrhrsAndVaryingGPAOne() {
		double[] val1 = {-3, 6};
		double[] val2 = {-1, 6};
		double[] val3 = {-3, 6};
		double[] val4 = {-4, 6};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.TotalGradePoints();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithNegativeCrhrsAndVaryingGPATwo() {
		double[] val1 = {-3, 4};
		double[] val2 = {-1, 4};
		double[] val3 = {-3, 4};
		double[] val4 = {-4, 4};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.TotalGradePoints();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithNegativeCrhrsAndVaryingGPAThree() {
		double[] val1 = {-3, 3.9};
		double[] val2 = {-1, 3.9};
		double[] val3 = {-3, 3.9};
		double[] val4 = {-4, 3.9};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.TotalGradePoints();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithNegativeCrhrsAndVaryingGPAFour() {
		double[] val1 = {-3, 2};
		double[] val2 = {-1, 2};
		double[] val3 = {-3, 2};
		double[] val4 = {-4, 2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.TotalGradePoints();
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithNegativeCrhrsAndVaryingGPAFive() {
		double[] val1 = {-3, 0.1};
		double[] val2 = {-1, 0.1};
		double[] val3 = {-3, 0.1};
		double[] val4 = {-4, 0.1};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.TotalGradePoints();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithNegativeCrhrsAndVaryingGPASix() {
		double[] val1 = {-3, 0};
		double[] val2 = {-1, 0};
		double[] val3 = {-3, 0};
		double[] val4 = {-4, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.TotalGradePoints();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithNegativeCrhrsAndVaryingGPASeven() {
		double[] val1 = {-3, -2};
		double[] val2 = {-1, -2};
		double[] val3 = {-3, -2};
		double[] val4 = {-4, -2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.TotalGradePoints();
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithZeroCrhrsAndVaryingGPAOne() {
		double[] val1 = {0, 6};
		double[] val2 = {0, 6};
		double[] val3 = {0, 6};
		double[] val4 = {0, 6};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.TotalGradePoints();
	}
	
	@Test
	public void testTotalGradePointsWithZeroCrhrsAndVaryingGPATwo() {
		double[] val1 = {0, 4};
		double[] val2 = {0, 4};
		double[] val3 = {0, 4};
		double[] val4 = {0, 4};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.0, obj.TotalGradePoints(), DELTA);
	}
	
	@Test
	public void testTotalGradePointsWithZeroCrhrsAndVaryingGPAThree() {
		double[] val1 = {0, 3.9};
		double[] val2 = {0, 3.9};
		double[] val3 = {0, 3.9};
		double[] val4 = {0, 3.9};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.0, obj.TotalGradePoints(), DELTA);
	}
	
	@Test
	public void testTotalGradePointsWithZeroCrhrsAndVaryingGPAFour() {
		double[] val1 = {0, 2};
		double[] val2 = {0, 2};
		double[] val3 = {0, 2};
		double[] val4 = {0, 2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.0, obj.TotalGradePoints(), DELTA);
	}
	
	
	@Test
	public void testTotalGradePointsWithZeroCrhrsAndVaryingGPAFive() {
		double[] val1 = {0, 0.1};
		double[] val2 = {0, 0.1};
		double[] val3 = {0, 0.1};
		double[] val4 = {0, 0.1};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.0, obj.TotalGradePoints(), DELTA);
	}
	
	@Test
	public void testTotalGradePointsWithZeroCrhrsAndVaryingGPASix() {
		double[] val1 = {0, 0};
		double[] val2 = {0, 0};
		double[] val3 = {0, 0};
		double[] val4 = {0, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.0, obj.TotalGradePoints(), DELTA);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithZeroCrhrsAndVaryingGPASeven() {
		double[] val1 = {0, -2};
		double[] val2 = {0, -2};
		double[] val3 = {0, -2};
		double[] val4 = {0, -2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.TotalGradePoints();
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithMinPlusCrhrsAndVaryingGPAOne() {
		double[] val1 = {0.2, 6};
		double[] val2 = {0.2, 6};
		double[] val3 = {0.2, 6};
		double[] val4 = {0.2, 6};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.TotalGradePoints();
	}
	
	@Test
	public void testTotalGradePointsWithMinPlusCrhrsAndVaryingGPATwo() {
		double[] val1 = {0.2, 4};
		double[] val2 = {0.1, 4};
		double[] val3 = {0.2, 4};
		double[] val4 = {0.1, 4};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(2.4, obj.TotalGradePoints(), DELTA);
	}
	
	@Test
	public void testTotalGradePointsWithMinPlusCrhrsAndVaryingGPAThree() {
		double[] val1 = {0.2, 3.9};
		double[] val2 = {0.1, 3.9};
		double[] val3 = {0.2, 3.9};
		double[] val4 = {0.1, 3.9};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(2.34, obj.TotalGradePoints(), DELTA);
	}
	
	@Test
	public void testTotalGradePointsWithMinPlusCrhrsAndVaryingGPAFour() {
		double[] val1 = {0.2, 2};
		double[] val2 = {0.1, 2};
		double[] val3 = {0.2, 2};
		double[] val4 = {0.1, 2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(1.2, obj.TotalGradePoints(), DELTA);
	}
	
	
	@Test
	public void testTotalGradePointsWithMinPlusCrhrsAndVaryingGPAFive() {
		double[] val1 = {0.2, 0.1};
		double[] val2 = {0.1, 0.1};
		double[] val3 = {0.2, 0.1};
		double[] val4 = {0.1, 0.1};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.06, obj.TotalGradePoints(), DELTA);
	}
	
	@Test
	public void testTotalGradePointsWithMinPlusCrhrsAndVaryingGPASix() {
		double[] val1 = {0.2, 0};
		double[] val2 = {0.1, 0};
		double[] val3 = {0.2, 0};
		double[] val4 = {0.1, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.0, obj.TotalGradePoints(), DELTA);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithMinPlusCrhrsAndVaryingGPASeven() {
		double[] val1 = {0.2, -2};
		double[] val2 = {0.2, -2};
		double[] val3 = {0.2, -2};
		double[] val4 = {0.2, -2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.TotalGradePoints();
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithNominalCrhrsAndVaryingGPAOne() {
		double[] val1 = {2, 6};
		double[] val2 = {2, 6};
		double[] val3 = {2, 6};
		double[] val4 = {2, 6};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.TotalGradePoints();
	}
	
	@Test
	public void testTotalGradePointsWithNominalCrhrsAndVaryingGPATwo() {
		double[] val1 = {2, 4};
		double[] val2 = {2, 4};
		double[] val3 = {2, 4};
		double[] val4 = {2, 4};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(32, obj.TotalGradePoints(), DELTA);
	}
	
	@Test
	public void testTotalGradePointsWithNominalCrhrsAndVaryingGPAThree() {
		double[] val1 = {2, 3.9};
		double[] val2 = {2, 3.9};
		double[] val3 = {2, 3.9};
		double[] val4 = {2, 3.9};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(31.2, obj.TotalGradePoints(), DELTA);
	}
	
	@Test
	public void testTotalGradePointsWithNominalCrhrsAndVaryingGPAFour() {
		double[] val1 = {2, 2};
		double[] val2 = {2, 2};
		double[] val3 = {2, 2};
		double[] val4 = {2, 2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(16, obj.TotalGradePoints(), DELTA);
	}
	
	
	@Test
	public void testTotalGradePointsWithNominalCrhrsAndVaryingGPAFive() {
		double[] val1 = {2, 0.1};
		double[] val2 = {2, 0.1};
		double[] val3 = {2, 0.1};
		double[] val4 = {2, 0.1};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.8, obj.TotalGradePoints(), DELTA);
	}
	
	@Test
	public void testTotalGradePointsWithNominalCrhrsAndVaryingGPASix() {
		double[] val1 = {2, 0};
		double[] val2 = {2, 0};
		double[] val3 = {2, 0};
		double[] val4 = {2, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.0, obj.TotalGradePoints(), DELTA);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithNominalCrhrsAndVaryingGPASeven() {
		double[] val1 = {2, -2};
		double[] val2 = {2, -2};
		double[] val3 = {2, -2};
		double[] val4 = {2, -2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.TotalGradePoints();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithMaxMinusCrhrsAndVaryingGPAOne() {
		double[] val1 = {3.9, 6};
		double[] val2 = {3.9, 6};
		double[] val3 = {3.9, 6};
		double[] val4 = {3.9, 6};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.TotalGradePoints();
	}
	
	@Test
	public void testTotalGradePointsWithMaxMinusCrhrsAndVaryingGPATwo() {
		double[] val1 = {3.9, 4};
		double[] val2 = {3.9, 4};
		double[] val3 = {3.9, 4};
		double[] val4 = {3.9, 4};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(62.4, obj.TotalGradePoints(), DELTA);
	}
	
	@Test
	public void testTotalGradePointsWithMaxMinusCrhrsAndVaryingGPAThree() {
		double[] val1 = {3.9, 3.9};
		double[] val2 = {3.9, 3.9};
		double[] val3 = {3.9, 3.9};
		double[] val4 = {3.9, 3.9};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(60.84, obj.TotalGradePoints(), DELTA);
	}
	
	@Test
	public void testTotalGradePointsWithMaxMinusCrhrsAndVaryingGPAFour() {
		double[] val1 = {3.9, 2};
		double[] val2 = {3.9, 2};
		double[] val3 = {3.9, 2};
		double[] val4 = {3.9, 2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(31.2, obj.TotalGradePoints(), DELTA);
	}
	
	
	@Test
	public void testTotalGradePointsWithMaxMinusCrhrsAndVaryingGPAFive() {
		double[] val1 = {3.9, 0.1};
		double[] val2 = {3.9, 0.1};
		double[] val3 = {3.9, 0.1};
		double[] val4 = {3.9, 0.1};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(1.56, obj.TotalGradePoints(), DELTA);
	}
	
	@Test
	public void testTotalGradePointsWithMaxMinusCrhrsAndVaryingGPASix() {
		double[] val1 = {3.9, 0};
		double[] val2 = {3.9, 0};
		double[] val3 = {3.9, 0};
		double[] val4 = {3.9, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.0, obj.TotalGradePoints(), DELTA);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithMaxMinusCrhrsAndVaryingGPASeven() {
		double[] val1 = {3.9, -2};
		double[] val2 = {3.9, -2};
		double[] val3 = {3.9, -2};
		double[] val4 = {3.9, -2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.TotalGradePoints();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithMaxCrhrsAndVaryingGPAOne() {
		double[] val1 = {4, 6};
		double[] val2 = {4, 6};
		double[] val3 = {4, 6};
		double[] val4 = {4, 6};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.TotalGradePoints();
	}
	
	@Test
	public void testTotalGradePointsWithMaxCrhrsAndVaryingGPATwo() {
		double[] val1 = {4, 4};
		double[] val2 = {4, 4};
		double[] val3 = {4, 4};
		double[] val4 = {4, 4};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(64, obj.TotalGradePoints(), DELTA);
	}
	
	@Test
	public void testTotalGradePointsWithMaxCrhrsAndVaryingGPAThree() {
		double[] val1 = {4, 3.9};
		double[] val2 = {4, 3.9};
		double[] val3 = {4, 3.9};
		double[] val4 = {4, 3.9};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(62.4, obj.TotalGradePoints(), DELTA);
	}
	
	@Test
	public void testTotalGradePointsWithMaxCrhrsAndVaryingGPAFour() {
		double[] val1 = {4, 2};
		double[] val2 = {4, 2};
		double[] val3 = {4, 2};
		double[] val4 = {4, 2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(32, obj.TotalGradePoints(), DELTA);
	}
	
	
	@Test
	public void testTotalGradePointsWithMaxCrhrsAndVaryingGPAFive() {
		double[] val1 = {4, 0.1};
		double[] val2 = {4, 0.1};
		double[] val3 = {4, 0.1};
		double[] val4 = {4, 0.1};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(1.6, obj.TotalGradePoints(), DELTA);
	}
	
	@Test
	public void testTotalGradePointsWithMaxCrhrsAndVaryingGPASix() {
		double[] val1 = {4, 0};
		double[] val2 = {4, 0};
		double[] val3 = {4, 0};
		double[] val4 = {4, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.0, obj.TotalGradePoints(), DELTA);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithMaxCrhrsAndVaryingGPASeven() {
		double[] val1 = {4, -2};
		double[] val2 = {4, -2};
		double[] val3 = {4, -2};
		double[] val4 = {4, -2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.TotalGradePoints();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void testTotalGPAOne() {
		double[] val = {1, 4};
		GPACalculator obj = new GPACalculator(list(val), maxCreditHours, maxGPA);
		assertEquals(4, obj.TotalGPA(), DELTA);
	}
	
	@Test
	public void testTotalGPATwo() {
		double[] val = {1, 4};
		double[] val2 = {3, 2};
		GPACalculator obj = new GPACalculator(list(val, val2), maxCreditHours, maxGPA);
		assertEquals(2.5, obj.TotalGPA(), DELTA);
	}
	
	@Test
	public void testTotalGPAThree() {
		double[] val1 = {3, 4};
		double[] val2 = {1, 3};
		double[] val3 = {3, 2};
		double[] val4 = {4, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(1.90, obj.TotalGPA(), DELTA);
	}
	
	@Test
	public void testTotalGPAFour() {
		double[] val1 = {4, 4};
		double[] val2 = {4, 3.33};
		double[] val3 = {2, 2.3};
		double[] val4 = {4, 4};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(3.56, obj.TotalGPA(), DELTA);
	}
	
	@Test
	public void testTotalGPAFive() {
		double[] val1 = {3, 3.33};
		double[] val2 = {1, 2.67};
		double[] val3 = {3, 3.5};
		double[] val4 = {4, 1};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(2.46, obj.TotalGPA(), DELTA);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGPAExceptionOne() {
		double[] val1 = {3, 4};
		double[] val2 = {1, 3};
		double[] val3 = {-3, 2};
		double[] val4 = {4, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.TotalGPA();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGPAExceptionTwo() {
		double[] val1 = {3, 4};
		double[] val2 = {1, -3};
		double[] val3 = {3, 2};
		double[] val4 = {4, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.TotalGPA();
	}
	
	@Test(expected=ArithmeticException.class)
	public void testTotalGPAExceptionThree() {
		double[] val1 = {0, 4};
		double[] val2 = {0, 3};
		double[] val3 = {0, 2};
		double[] val4 = {0, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
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
