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
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddSameGradeName(){
		Rubric rubric = new Rubric();
		rubric.addGrade("A", 90, 100, 4.0);
		rubric.addGrade("A", 85, 89, 3.0);}
	
	//test cases for setting letter grade, gpa, lower limit, and upper limit.
	@Test
	public void testsetGPA(){
		Rubric rubric = new Rubric();
		rubric.addGrade("A", 90, 100, 4.0);
		rubric.setGPA("A", 3.90);
		assertEquals(3.90, rubric.getGPA("A"), DELTA);
	}
	
	@Test
	public void testsetLetterGrade(){
		Rubric rubric = new Rubric();
		rubric.addGrade("A", 90, 100, 4.0);
		rubric.setLetterGrade("A", "B");
		assertEquals(4.0, rubric.getGPA("B"), DELTA);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testsetLetterGradeWithSameName(){
		Rubric rubric = new Rubric();
		rubric.addGrade("A", 90, 100, 4.0);
		rubric.addGrade("B", 85, 89, 3.0);
		rubric.setLetterGrade("A", "B");}
	
	@Test(expected = IllegalArgumentException.class)
	public void testsetLetterGradeWithEmptyName(){
		Rubric rubric = new Rubric();
		rubric.addGrade("A", 90, 100, 4.0);
		rubric.addGrade("B", 85, 89, 3.0);
		rubric.setLetterGrade("A", "");	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testsetGPATwo(){
		Rubric rubric = new Rubric();
		rubric.addGrade("A", 90, 100, 4.0);
		rubric.setGPA("A", -3.90);	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testsetGPAThree(){
		Rubric rubric = new Rubric();
		rubric.addGrade("A", 90, 100, 4.0);
		rubric.addGrade("B", 85, 89, 3.0);
		rubric.setGPA("A", 3.0);	}
	
	@Test
	public void testsetLowerLimit(){
		Rubric rubric = new Rubric();
		rubric.addGrade("A", 90, 100, 4.0);
		rubric.setLowerLimit("A", 95);
		assertEquals(95, rubric.getLowerLimit("A"), DELTA);
	}
	
	@Test
	public void testsetUpperLimit(){
		Rubric rubric = new Rubric();
		rubric.addGrade("A", 90, 100, 4.0);
		rubric.setUpperLimit("A", 95);
		assertEquals(95, rubric.getUpperLimit("A"), DELTA);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testsetLowerLimitExceptionOne(){
		Rubric rubric = new Rubric();
		rubric.addGrade("A", 90, 100, 4.0);
		rubric.setLowerLimit("A", 190);}
	
	@Test(expected = IllegalArgumentException.class)
	public void testsetLowerLimitExceptionTwo(){
		Rubric rubric = new Rubric();
		rubric.addGrade("A", 90, 100, 4.0);
		rubric.setLowerLimit("A", -10);}
	
	@Test(expected = IllegalArgumentException.class)
	public void testsetUpperLimitExcpetionOne(){
		Rubric rubric = new Rubric();
		rubric.addGrade("A", 90, 100, 4.0);
		rubric.addGrade("B", 80, 89, 3.0);
		rubric.setUpperLimit("B", 190); }
	
	@Test(expected = IllegalArgumentException.class)
	public void testsetUpperLimitExcpetionTwo(){
		Rubric rubric = new Rubric();
		rubric.addGrade("A", 90, 100, 4.0);
		rubric.addGrade("B", 80, 89, 3.0);
		rubric.setUpperLimit("B", 100); }
	
	@Test(expected = IllegalArgumentException.class)
	public void testsetUpperLimitExcpetionThree(){
		Rubric rubric = new Rubric();
		rubric.addGrade("A", 90, 100, 4.0);
		rubric.addGrade("B", 80, 89, 3.0);
		rubric.setUpperLimit("B", -190); }
	
	@Test(expected = IllegalArgumentException.class)
	public void testsetUpperLimitExceptionFour(){
		Rubric rubric = new Rubric();
		rubric.addGrade("A", 90, 100, 4.0);
		rubric.addGrade("B", 85, 89, 3.0);
		rubric.setUpperLimit("B", 95);}
	
}
