import static org.junit.Assert.*;

import org.junit.Test;


public class RubricTest {

	private static final double DELTA = 1e-15;
	
	@Test
	public void testJUnit() {
		assertTrue("JUnit works!", true);
	}
	
	@Test
	public void testRubricInitialization(){
		assertNotNull(new Rubric());
	}
	
	//test cases for getting and setting the letter grade along with max and min limits
	@Test
	public void testGetLowerLimit(){
		Rubric rubric = new Rubric();
		rubric.addGrade("A", 90, 100, 4.0);
		assertEquals(90.0, rubric.getLowerLimit("A"), DELTA);
	}
	
	@Test
	public void testGetUpperLimit(){
		Rubric rubric = new Rubric();
		rubric.addGrade("A", 90, 100, 4.0);
		assertEquals(100.0, rubric.getUpperLimit("A"), DELTA);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetInvalidLowerLimit(){
		Rubric rubric = new Rubric();
		rubric.addGrade("A", -90, 100, 4.0);	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetInvalidUpperLimit(){
		Rubric rubric = new Rubric();
		rubric.addGrade("A", 90, 110, 4.0);	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetInvalidUpperLimitTwo(){
		Rubric rubric = new Rubric();
		rubric.addGrade("A", 90, -100, 4.0);	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetInvalidLowerLimitTwo(){
		Rubric rubric = new Rubric();
		rubric.addGrade("A", 190, 200, 4.0);	}
	
	@Test
	public void testDefaults(){
		Rubric rubric = new Rubric();
		rubric.setDefaults();
		assertEquals(4.0, rubric.getGPA("A"), DELTA);
	}
	
	@Test
	public void testGetGPA(){
		Rubric rubric = new Rubric();
		rubric.addGrade("A", 90, 100, 4.0);
		assertEquals(4.0, rubric.getGPA("A"), DELTA);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddGradesExceptionOne(){
		Rubric rubric = new Rubric();
		rubric.addGrade("A", 190, 100, 4.0);}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddOverlappingGrades(){
		Rubric rubric = new Rubric();
		rubric.addGrade("A", 90, 100, 4.0);
		rubric.addGrade("B", 80, 100, 3.0);}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddOverlappingGradesOne(){
		Rubric rubric = new Rubric();
		rubric.addGrade("A", 90, 100, 4.0);
		rubric.addGrade("B", 95, 99, 3.0);}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddOverlappingGradesTwo(){
		Rubric rubric = new Rubric();
		rubric.addGrade("A", 90, 100, 4.0);
		rubric.addGrade("B", 85, 95, 3.0);}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddOverlappingGPA(){
		Rubric rubric = new Rubric();
		rubric.addGrade("A", 90, 100, 4.0);
		rubric.addGrade("B", 85, 89, 4.0);}
}
