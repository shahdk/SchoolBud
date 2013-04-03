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
	
	@Test
	public void testGetGPA(){
		Rubric rubric = new Rubric();
		rubric.addGrade("A", 90, 100, 4.0);
		assertEquals(4.0, rubric.getGPA("A"), DELTA);
	}

}
