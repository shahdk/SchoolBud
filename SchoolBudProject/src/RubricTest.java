import static org.junit.Assert.*;

import org.junit.Test;


public class RubricTest {

	@Test
	public void testJUnit() {
		assertTrue("JUnit works!", true);
	}
	
	@Test
	public void testRubricInitialization(){
		assertNotNull(new Rubric());
	}

}
