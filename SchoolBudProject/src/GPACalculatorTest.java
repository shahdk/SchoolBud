import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;


public class GPACalculatorTest {

	private static final double DELTA = 1e-15;
	private static final double maxCreditHours = 4.0;
	private static final double maxGPA = 4.0;
	
	
	/**
	 * double[] val variable stores the credit hours and GPA.
	 * val[0] is the credit hours for a particular course
	 * val[1] is the GPA grade received for that particular course.
	 */
	
	@Test
	public void testJUnit() {
		assertTrue("JUnit works!", true);
	}
	
	@Test
	public void testGPACalculatorInitialze(){
		double[] val = {0, 4};
		GPACalculator obj = new GPACalculator(list(val), maxCreditHours, maxGPA);
		assertNotNull(obj);	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithMinMinusCrhrsAndMaxPlusGPA() {
		double[] val1 = {-3, 6};
		double[] val2 = {-1, 6};
		double[] val3 = {-3, 6};
		double[] val4 = {-4, 6};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGradePoints();	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithMinMinusCrhrsAndMaxGPA() {
		double[] val1 = {-3, 4};
		double[] val2 = {-1, 4};
		double[] val3 = {-3, 4};
		double[] val4 = {-4, 4};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGradePoints();	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithMinMinusCrhrsAndMaxMinusGPA() {
		double[] val1 = {-3, 3.9};
		double[] val2 = {-1, 3.9};
		double[] val3 = {-3, 3.9};
		double[] val4 = {-4, 3.9};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGradePoints();	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithMinMinusCrhrsAndNominalGPA() {
		double[] val1 = {-3, 2};
		double[] val2 = {-1, 2};
		double[] val3 = {-3, 2};
		double[] val4 = {-4, 2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGradePoints();	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithMinMinusCrhrsAndMinPlusGPA() {
		double[] val1 = {-3, 0.1};
		double[] val2 = {-1, 0.1};
		double[] val3 = {-3, 0.1};
		double[] val4 = {-4, 0.1};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGradePoints();	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithMinMinusCrhrsAndMinGPA() {
		double[] val1 = {-3, 0};
		double[] val2 = {-1, 0};
		double[] val3 = {-3, 0};
		double[] val4 = {-4, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGradePoints();	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithMinMinusCrhrsAndMinMinusGPA() {
		double[] val1 = {-3, -2};
		double[] val2 = {-1, -2};
		double[] val3 = {-3, -2};
		double[] val4 = {-4, -2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGradePoints();	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithZeroCrhrsAndMaxPlusGPA() {
		double[] val1 = {0, 6};
		double[] val2 = {0, 6};
		double[] val3 = {0, 6};
		double[] val4 = {0, 6};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGradePoints();	}
	
	@Test
	public void testTotalGradePointsWithZeroCrhrsAndMaxGPA() {
		double[] val1 = {0, 4};
		double[] val2 = {0, 4};
		double[] val3 = {0, 4};
		double[] val4 = {0, 4};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.0, obj.totalGradePoints(), DELTA); }
	
	@Test
	public void testTotalGradePointsWithZeroCrhrsAndMaxMinusGPA() {
		double[] val1 = {0, 3.9};
		double[] val2 = {0, 3.9};
		double[] val3 = {0, 3.9};
		double[] val4 = {0, 3.9};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.0, obj.totalGradePoints(), DELTA); }
	
	@Test
	public void testTotalGradePointsWithZeroCrhrsAndNominalGPA() {
		double[] val1 = {0, 2};
		double[] val2 = {0, 2};
		double[] val3 = {0, 2};
		double[] val4 = {0, 2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.0, obj.totalGradePoints(), DELTA); }
	
	
	@Test
	public void testTotalGradePointsWithZeroCrhrsAndMinPlusGPA() {
		double[] val1 = {0, 0.1};
		double[] val2 = {0, 0.1};
		double[] val3 = {0, 0.1};
		double[] val4 = {0, 0.1};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.0, obj.totalGradePoints(), DELTA); }
	
	@Test
	public void testTotalGradePointsWithZeroCrhrsAndMinGPA() {
		double[] val1 = {0, 0};
		double[] val2 = {0, 0};
		double[] val3 = {0, 0};
		double[] val4 = {0, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.0, obj.totalGradePoints(), DELTA); }
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithZeroCrhrsAndMinMinusGPA() {
		double[] val1 = {0, -2};
		double[] val2 = {0, -2};
		double[] val3 = {0, -2};
		double[] val4 = {0, -2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGradePoints();	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithMinPlusCrhrsAndMaxPlusGPA() {
		double[] val1 = {0.2, 6};
		double[] val2 = {0.2, 6};
		double[] val3 = {0.2, 6};
		double[] val4 = {0.2, 6};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGradePoints();	}
	
	@Test
	public void testTotalGradePointsWithMinPlusCrhrsAndMaxGPA() {
		double[] val1 = {0.2, 4};
		double[] val2 = {0.1, 4};
		double[] val3 = {0.2, 4};
		double[] val4 = {0.1, 4};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(2.4, obj.totalGradePoints(), DELTA);	}
	
	@Test
	public void testTotalGradePointsWithMinPlusCrhrsAndMaxMinusGPA() {
		double[] val1 = {0.2, 3.9};
		double[] val2 = {0.1, 3.9};
		double[] val3 = {0.2, 3.9};
		double[] val4 = {0.1, 3.9};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(2.34, obj.totalGradePoints(), DELTA);	}
	
	@Test
	public void testTotalGradePointsWithMinPlusCrhrsAndNominalGPA() {
		double[] val1 = {0.2, 2};
		double[] val2 = {0.1, 2};
		double[] val3 = {0.2, 2};
		double[] val4 = {0.1, 2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(1.2, obj.totalGradePoints(), DELTA);	}
	
	
	@Test
	public void testTotalGradePointsWithMinPlusCrhrsAndMinPlusGPA() {
		double[] val1 = {0.2, 0.1};
		double[] val2 = {0.1, 0.1};
		double[] val3 = {0.2, 0.1};
		double[] val4 = {0.1, 0.1};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.06, obj.totalGradePoints(), DELTA);	}
	
	@Test
	public void testTotalGradePointsWithMinPlusCrhrsAndMinGPA() {
		double[] val1 = {0.2, 0};
		double[] val2 = {0.1, 0};
		double[] val3 = {0.2, 0};
		double[] val4 = {0.1, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.0, obj.totalGradePoints(), DELTA);	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithMinPlusCrhrsAndMinMinusGPA() {
		double[] val1 = {0.2, -2};
		double[] val2 = {0.2, -2};
		double[] val3 = {0.2, -2};
		double[] val4 = {0.2, -2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGradePoints();	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithNominalCrhrsAndMaxPlusGPA() {
		double[] val1 = {2, 6};
		double[] val2 = {2, 6};
		double[] val3 = {2, 6};
		double[] val4 = {2, 6};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGradePoints();	}
	
	@Test
	public void testTotalGradePointsWithNominalCrhrsAndMaxGPA() {
		double[] val1 = {2, 4};
		double[] val2 = {2, 4};
		double[] val3 = {2, 4};
		double[] val4 = {2, 4};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(32, obj.totalGradePoints(), DELTA);	}
	
	@Test
	public void testTotalGradePointsWithNominalCrhrsAndMaxMinusGPA() {
		double[] val1 = {2, 3.9};
		double[] val2 = {2, 3.9};
		double[] val3 = {2, 3.9};
		double[] val4 = {2, 3.9};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(31.2, obj.totalGradePoints(), DELTA);	}
	
	@Test
	public void testTotalGradePointsWithNominalCrhrsAndNominalGPA() {
		double[] val1 = {2, 2};
		double[] val2 = {2, 2};
		double[] val3 = {2, 2};
		double[] val4 = {2, 2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(16, obj.totalGradePoints(), DELTA);	}
	
	
	@Test
	public void testTotalGradePointsWithNominalCrhrsAndMinPlusGPA() {
		double[] val1 = {2, 0.1};
		double[] val2 = {2, 0.1};
		double[] val3 = {2, 0.1};
		double[] val4 = {2, 0.1};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.8, obj.totalGradePoints(), DELTA);	}
	
	@Test
	public void testTotalGradePointsWithNominalCrhrsAndMinGPA() {
		double[] val1 = {2, 0};
		double[] val2 = {2, 0};
		double[] val3 = {2, 0};
		double[] val4 = {2, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.0, obj.totalGradePoints(), DELTA);	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithNominalCrhrsAndMinMinusGPA() {
		double[] val1 = {2, -2};
		double[] val2 = {2, -2};
		double[] val3 = {2, -2};
		double[] val4 = {2, -2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGradePoints();	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithMaxMinusCrhrsAndMaxPlusGPA() {
		double[] val1 = {3.9, 6};
		double[] val2 = {3.9, 6};
		double[] val3 = {3.9, 6};
		double[] val4 = {3.9, 6};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGradePoints();	}
	
	@Test
	public void testTotalGradePointsWithMaxMinusCrhrsAndMaxGPA() {
		double[] val1 = {3.9, 4};
		double[] val2 = {3.9, 4};
		double[] val3 = {3.9, 4};
		double[] val4 = {3.9, 4};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(62.4, obj.totalGradePoints(), DELTA);	}
	
	@Test
	public void testTotalGradePointsWithMaxMinusCrhrsAndMaxMinusGPA() {
		double[] val1 = {3.9, 3.9};
		double[] val2 = {3.9, 3.9};
		double[] val3 = {3.9, 3.9};
		double[] val4 = {3.9, 3.9};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(60.84, obj.totalGradePoints(), DELTA);	}
	
	@Test
	public void testTotalGradePointsWithMaxMinusCrhrsAndNominalGPA() {
		double[] val1 = {3.9, 2};
		double[] val2 = {3.9, 2};
		double[] val3 = {3.9, 2};
		double[] val4 = {3.9, 2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(31.2, obj.totalGradePoints(), DELTA);	}
	
	
	@Test
	public void testTotalGradePointsWithMaxMinusCrhrsAndMinPlusGPA() {
		double[] val1 = {3.9, 0.1};
		double[] val2 = {3.9, 0.1};
		double[] val3 = {3.9, 0.1};
		double[] val4 = {3.9, 0.1};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(1.56, obj.totalGradePoints(), DELTA);	}
	
	@Test
	public void testTotalGradePointsWithMaxMinusCrhrsAndMinGPA() {
		double[] val1 = {3.9, 0};
		double[] val2 = {3.9, 0};
		double[] val3 = {3.9, 0};
		double[] val4 = {3.9, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.0, obj.totalGradePoints(), DELTA);	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithMaxMinusCrhrsAndMinMinusGPA() {
		double[] val1 = {3.9, -2};
		double[] val2 = {3.9, -2};
		double[] val3 = {3.9, -2};
		double[] val4 = {3.9, -2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGradePoints();	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithMaxCrhrsAndMaxPlusGPA() {
		double[] val1 = {4, 6};
		double[] val2 = {4, 6};
		double[] val3 = {4, 6};
		double[] val4 = {4, 6};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGradePoints();	}
	
	@Test
	public void testTotalGradePointsWithMaxCrhrsAndMaxGPA() {
		double[] val1 = {4, 4};
		double[] val2 = {4, 4};
		double[] val3 = {4, 4};
		double[] val4 = {4, 4};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(64, obj.totalGradePoints(), DELTA);	}
	
	@Test
	public void testTotalGradePointsWithMaxCrhrsAndMaxMinusGPA() {
		double[] val1 = {4, 3.9};
		double[] val2 = {4, 3.9};
		double[] val3 = {4, 3.9};
		double[] val4 = {4, 3.9};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(62.4, obj.totalGradePoints(), DELTA);	}
	
	@Test
	public void testTotalGradePointsWithMaxCrhrsAndNominalGPA() {
		double[] val1 = {4, 2};
		double[] val2 = {4, 2};
		double[] val3 = {4, 2};
		double[] val4 = {4, 2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(32, obj.totalGradePoints(), DELTA);	}
	
	
	@Test
	public void testTotalGradePointsWithMaxCrhrsAndMinPlusGPA() {
		double[] val1 = {4, 0.1};
		double[] val2 = {4, 0.1};
		double[] val3 = {4, 0.1};
		double[] val4 = {4, 0.1};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(1.6, obj.totalGradePoints(), DELTA);	}
	
	@Test
	public void testTotalGradePointsWithMaxCrhrsAndMinGPA() {
		double[] val1 = {4, 0};
		double[] val2 = {4, 0};
		double[] val3 = {4, 0};
		double[] val4 = {4, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.0, obj.totalGradePoints(), DELTA);	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithMaxCrhrsAndMinMinusGPA() {
		double[] val1 = {4, -2};
		double[] val2 = {4, -2};
		double[] val3 = {4, -2};
		double[] val4 = {4, -2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGradePoints();	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithMaxPlusCrhrsAndMaxPlusGPA() {
		double[] val1 = {6, 6};
		double[] val2 = {6, 6};
		double[] val3 = {6, 6};
		double[] val4 = {6, 6};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGradePoints();	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithMaxPlusCrhrsAndMaxGPA() {
		double[] val1 = {6, 4};
		double[] val2 = {6, 4};
		double[] val3 = {6, 4};
		double[] val4 = {6, 4};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGradePoints();	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithMaxPlusCrhrsAndMaxMinusGPA() {
		double[] val1 = {6, 3.9};
		double[] val2 = {6, 3.9};
		double[] val3 = {6, 3.9};
		double[] val4 = {6, 3.9};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGradePoints();	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithMaxPlusCrhrsAndNominalGPA() {
		double[] val1 = {6, 2};
		double[] val2 = {6, 2};
		double[] val3 = {6, 2};
		double[] val4 = {6, 2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGradePoints();	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithMaxPlusCrhrsAndMinPlusGPA() {
		double[] val1 = {6, 0.1};
		double[] val2 = {6, 0.1};
		double[] val3 = {6, 0.1};
		double[] val4 = {6, 0.1};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGradePoints();	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithMaxPlusCrhrsAndMinGPA() {
		double[] val1 = {6, 0};
		double[] val2 = {6, 0};
		double[] val3 = {6, 0};
		double[] val4 = {6, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGradePoints();	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGradePointsWithMaxPlusCrhrsAndMinMinuGPA() {
		double[] val1 = {6, -2};
		double[] val2 = {6, -2};
		double[] val3 = {6, -2};
		double[] val4 = {6, -2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGradePoints();	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGPAWithMinMinusCrhrsAndMaxPlusGPA() {
		double[] val1 = {-3, 6};
		double[] val2 = {-1, 6};
		double[] val3 = {-3, 6};
		double[] val4 = {-4, 6};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGPA();	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGPAWithMinMinusCrhrsAndMaxGPA() {
		double[] val1 = {-3, 4};
		double[] val2 = {-1, 4};
		double[] val3 = {-3, 4};
		double[] val4 = {-4, 4};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGPA();	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGPAWithMinMinusCrhrsAndMaxMinusGPA() {
		double[] val1 = {-3, 3.9};
		double[] val2 = {-1, 3.9};
		double[] val3 = {-3, 3.9};
		double[] val4 = {-4, 3.9};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGPA();	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGPAWithMinMinusCrhrsAndNominalGPA() {
		double[] val1 = {-3, 2};
		double[] val2 = {-1, 2};
		double[] val3 = {-3, 2};
		double[] val4 = {-4, 2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGPA();	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGPAWithMinMinusCrhrsAndMinPlusGPA() {
		double[] val1 = {-3, 0.1};
		double[] val2 = {-1, 0.1};
		double[] val3 = {-3, 0.1};
		double[] val4 = {-4, 0.1};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGPA();	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGPAWithMinMinusCrhrsAndMinGPA() {
		double[] val1 = {-3, 0};
		double[] val2 = {-1, 0};
		double[] val3 = {-3, 0};
		double[] val4 = {-4, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGPA();	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGPAWithMinMinusCrhrsAndMinMinusGPA() {
		double[] val1 = {-3, -2};
		double[] val2 = {-1, -2};
		double[] val3 = {-3, -2};
		double[] val4 = {-4, -2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGPA();	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGPAWithZeroCrhrsAndMaxPlusGPA() {
		double[] val1 = {0, 6};
		double[] val2 = {0, 6};
		double[] val3 = {0, 6};
		double[] val4 = {0, 6};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGPA();	}
	
	@Test(expected=ArithmeticException.class)
	public void testTotalGPAWithZeroCrhrsAndMaxGPA() {
		double[] val1 = {0, 4};
		double[] val2 = {0, 4};
		double[] val3 = {0, 4};
		double[] val4 = {0, 4};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.0, obj.totalGPA(), DELTA);	}
	
	@Test(expected=ArithmeticException.class)
	public void testTotalGPAWithZeroCrhrsAndMaxMinusGPA() {
		double[] val1 = {0, 3.9};
		double[] val2 = {0, 3.9};
		double[] val3 = {0, 3.9};
		double[] val4 = {0, 3.9};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.0, obj.totalGPA(), DELTA);	}
	
	@Test(expected=ArithmeticException.class)
	public void testTotalGPAWithZeroCrhrsAndNominalGPA() {
		double[] val1 = {0, 2};
		double[] val2 = {0, 2};
		double[] val3 = {0, 2};
		double[] val4 = {0, 2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.0, obj.totalGPA(), DELTA);	}
	
	
	@Test(expected=ArithmeticException.class)
	public void testTotalGPAWithZeroCrhrsAndMinPlusGPA() {
		double[] val1 = {0, 0.1};
		double[] val2 = {0, 0.1};
		double[] val3 = {0, 0.1};
		double[] val4 = {0, 0.1};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.0, obj.totalGPA(), DELTA);	}
	
	@Test(expected=ArithmeticException.class)
	public void testTotalGPAWithZeroCrhrsAndMinGPA() {
		double[] val1 = {0, 0};
		double[] val2 = {0, 0};
		double[] val3 = {0, 0};
		double[] val4 = {0, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.0, obj.totalGPA(), DELTA);	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGPAWithZeroCrhrsAndMinMinusGPA() {
		double[] val1 = {0, -2};
		double[] val2 = {0, -2};
		double[] val3 = {0, -2};
		double[] val4 = {0, -2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGPA();	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGPAWithMinPlusCrhrsAndMaxPlusGPA() {
		double[] val1 = {0.2, 6};
		double[] val2 = {0.2, 6};
		double[] val3 = {0.2, 6};
		double[] val4 = {0.2, 6};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGPA();	}
	
	@Test
	public void testTotalGPAWithMinPlusCrhrsAndMaxGPA() {
		double[] val1 = {0.2, 4};
		double[] val2 = {0.1, 4};
		double[] val3 = {0.2, 4};
		double[] val4 = {0.1, 4};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(4, obj.totalGPA(), DELTA);	}
	
	@Test
	public void testTotalGPAWithMinPlusCrhrsAndMaxMinusGPA() {
		double[] val1 = {0.2, 3.9};
		double[] val2 = {0.1, 3.9};
		double[] val3 = {0.2, 3.9};
		double[] val4 = {0.1, 3.9};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(3.9, obj.totalGPA(), DELTA);	}
	
	@Test
	public void testTotalGPAWithMinPlusCrhrsAndNominalGPA() {
		double[] val1 = {0.2, 2};
		double[] val2 = {0.1, 2};
		double[] val3 = {0.2, 2};
		double[] val4 = {0.1, 2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(2, obj.totalGPA(), DELTA);	}
	
	
	@Test
	public void testTotalGPAWithMinPlusCrhrsAndMinPlusGPA() {
		double[] val1 = {0.2, 0.1};
		double[] val2 = {0.1, 0.1};
		double[] val3 = {0.2, 0.1};
		double[] val4 = {0.1, 0.1};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.1, obj.totalGPA(), DELTA);	}
	
	@Test
	public void testTotalGPAWithMinPlusCrhrsAndMinGPA() {
		double[] val1 = {0.2, 0};
		double[] val2 = {0.1, 0};
		double[] val3 = {0.2, 0};
		double[] val4 = {0.1, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.0, obj.totalGPA(), DELTA);	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGPAWithMinPlusCrhrsAndMinMinusGPA() {
		double[] val1 = {0.2, -2};
		double[] val2 = {0.2, -2};
		double[] val3 = {0.2, -2};
		double[] val4 = {0.2, -2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGPA();	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGPAWithNominalCrhrsAndMaxPlusGPA() {
		double[] val1 = {2, 6};
		double[] val2 = {2, 6};
		double[] val3 = {2, 6};
		double[] val4 = {2, 6};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGPA();	}
	
	@Test
	public void testTotalGPAWithNominalCrhrsAndMaxGPA() {
		double[] val1 = {2, 4};
		double[] val2 = {2, 4};
		double[] val3 = {2, 4};
		double[] val4 = {2, 4};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(4, obj.totalGPA(), DELTA);	}
	
	@Test
	public void testTotalGPAWithNominalCrhrsAndMaxMinusGPA() {
		double[] val1 = {2, 3.9};
		double[] val2 = {2, 3.9};
		double[] val3 = {2, 3.9};
		double[] val4 = {2, 3.9};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(3.9, obj.totalGPA(), DELTA);	}
	
	@Test
	public void testTotalGPAWithNominalCrhrsAndNominalGPA() {
		double[] val1 = {2, 2};
		double[] val2 = {2, 2};
		double[] val3 = {2, 2};
		double[] val4 = {2, 2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(2, obj.totalGPA(), DELTA);	}
	
	
	@Test
	public void testTotalGPAWithNominalCrhrsAndMinPlusGPA() {
		double[] val1 = {2, 0.1};
		double[] val2 = {2, 0.1};
		double[] val3 = {2, 0.1};
		double[] val4 = {2, 0.1};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.1, obj.totalGPA(), DELTA);	}
	
	@Test
	public void testTotalGPAWithNominalCrhrsAndMinGPA() {
		double[] val1 = {2, 0};
		double[] val2 = {2, 0};
		double[] val3 = {2, 0};
		double[] val4 = {2, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.0, obj.totalGPA(), DELTA);	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGPAWithNominalCrhrsAndMinMinusGPA() {
		double[] val1 = {2, -2};
		double[] val2 = {2, -2};
		double[] val3 = {2, -2};
		double[] val4 = {2, -2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGPA();	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGPAWithMaxMinusCrhrsAndMaxPlusGPA() {
		double[] val1 = {3.9, 6};
		double[] val2 = {3.9, 6};
		double[] val3 = {3.9, 6};
		double[] val4 = {3.9, 6};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGPA();	}
	
	@Test
	public void testTotalGPAWithMaxMinusCrhrsAndMaxGPA() {
		double[] val1 = {3.9, 4};
		double[] val2 = {3.9, 4};
		double[] val3 = {3.9, 4};
		double[] val4 = {3.9, 4};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(4, obj.totalGPA(), DELTA);	}
	
	@Test
	public void testTotalGPAWithMaxMinusCrhrsAndMaxMinusGPA() {
		double[] val1 = {3.9, 3.9};
		double[] val2 = {3.9, 3.9};
		double[] val3 = {3.9, 3.9};
		double[] val4 = {3.9, 3.9};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(3.9, obj.totalGPA(), DELTA);	}
	
	@Test
	public void testTotalGPAWithMaxMinusCrhrsAndNominalGPA() {
		double[] val1 = {3.9, 2};
		double[] val2 = {3.9, 2};
		double[] val3 = {3.9, 2};
		double[] val4 = {3.9, 2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(2, obj.totalGPA(), DELTA);	}
	
	
	@Test
	public void testTotalGPAWithMaxMinusCrhrsAndMinPlusGPA() {
		double[] val1 = {3.9, 0.1};
		double[] val2 = {3.9, 0.1};
		double[] val3 = {3.9, 0.1};
		double[] val4 = {3.9, 0.1};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.1, obj.totalGPA(), DELTA);	}
	
	@Test
	public void testTotalGPAWithMaxMinusCrhrsAndMinGPA() {
		double[] val1 = {3.9, 0};
		double[] val2 = {3.9, 0};
		double[] val3 = {3.9, 0};
		double[] val4 = {3.9, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.0, obj.totalGPA(), DELTA);	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGPAWithMaxMinusCrhrsAndMinMinusGPA() {
		double[] val1 = {3.9, -2};
		double[] val2 = {3.9, -2};
		double[] val3 = {3.9, -2};
		double[] val4 = {3.9, -2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGPA();	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGPAWithMaxCrhrsAndMaxPlusGPA() {
		double[] val1 = {4, 6};
		double[] val2 = {4, 6};
		double[] val3 = {4, 6};
		double[] val4 = {4, 6};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGPA();	}
	
	@Test
	public void testTotalGPAWithMaxCrhrsAndMaxGPA() {
		double[] val1 = {4, 4};
		double[] val2 = {4, 4};
		double[] val3 = {4, 4};
		double[] val4 = {4, 4};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(4, obj.totalGPA(), DELTA);	}
	
	@Test
	public void testTotalGPAWithMaxCrhrsAndMaxMinusGPA() {
		double[] val1 = {4, 3.9};
		double[] val2 = {4, 3.9};
		double[] val3 = {4, 3.9};
		double[] val4 = {4, 3.9};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(3.9, obj.totalGPA(), DELTA);	}
	
	@Test
	public void testTotalGPAWithMaxCrhrsAndNominalGPA() {
		double[] val1 = {4, 2};
		double[] val2 = {4, 2};
		double[] val3 = {4, 2};
		double[] val4 = {4, 2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(2, obj.totalGPA(), DELTA);	}
	
	
	@Test
	public void testTotalGPAWithMaxCrhrsAndMinPlusGPA() {
		double[] val1 = {4, 0.1};
		double[] val2 = {4, 0.1};
		double[] val3 = {4, 0.1};
		double[] val4 = {4, 0.1};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.1, obj.totalGPA(), DELTA);	}
	
	@Test
	public void testTotalGPAWithMaxCrhrsAndMinGPA() {
		double[] val1 = {4, 0};
		double[] val2 = {4, 0};
		double[] val3 = {4, 0};
		double[] val4 = {4, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		assertEquals(0.0, obj.totalGPA(), DELTA);	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGPAWithMaxCrhrsAndMinMinusGPA() {
		double[] val1 = {4, -2};
		double[] val2 = {4, -2};
		double[] val3 = {4, -2};
		double[] val4 = {4, -2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGPA();	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGPAWithMaxPlusCrhrsAndMaxPlusGPA() {
		double[] val1 = {6, 6};
		double[] val2 = {6, 6};
		double[] val3 = {6, 6};
		double[] val4 = {6, 6};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGPA();	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGPAWithMaxPlusCrhrsAndMaxGPA() {
		double[] val1 = {6, 4};
		double[] val2 = {6, 4};
		double[] val3 = {6, 4};
		double[] val4 = {6, 4};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGPA();	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGPAWithMaxPlusCrhrsAndMaxMinusGPA() {
		double[] val1 = {6, 3.9};
		double[] val2 = {6, 3.9};
		double[] val3 = {6, 3.9};
		double[] val4 = {6, 3.9};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGPA();	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGPAWithMaxPlusCrhrsAndNominalGPA() {
		double[] val1 = {6, 2};
		double[] val2 = {6, 2};
		double[] val3 = {6, 2};
		double[] val4 = {6, 2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGPA();	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGPAWithMaxPlusCrhrsAndMinPlusGPA() {
		double[] val1 = {6, 0.1};
		double[] val2 = {6, 0.1};
		double[] val3 = {6, 0.1};
		double[] val4 = {6, 0.1};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGPA();	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGPAWithMaxPlusCrhrsAndMinGPA() {
		double[] val1 = {6, 0};
		double[] val2 = {6, 0};
		double[] val3 = {6, 0};
		double[] val4 = {6, 0};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGPA();	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTotalGPAWithMaxPlusCrhrsAndMinMinuGPA() {
		double[] val1 = {6, -2};
		double[] val2 = {6, -2};
		double[] val3 = {6, -2};
		double[] val4 = {6, -2};
		GPACalculator obj = new GPACalculator(list(val1, val2, val3, val4), maxCreditHours, maxGPA);
		obj.totalGPA();	}
	
	
	private ArrayList<double[]> list(double[]... vals){
		ArrayList<double[]> ret = new ArrayList<double[]>();
		for(double[] i: vals){
			ret.add(i);
		}
		return ret;
	}

}
