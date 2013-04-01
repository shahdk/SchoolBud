import static org.junit.Assert.*;

import org.junit.Test;


public class CourseTest {
	
	private static final double DELTA = 1e-15;

	@Test
	public void testJUnit() {
		assertTrue("JUnit works!", true);
	}
	
	//test cases for initializing Course
	@Test
	public void testInitializeOne(){
		assertNotNull(new Course("CSSE376"));
	}
	
	@Test
	public void testInitializeTwo(){
		assertNotNull(new Course("CSSE376", 4.0));
	}

	//test case for get methods
	@Test
	public void testGetNameOne(){
		Course course = new Course("CSSE376");
		assertEquals("CSSE376", course.getCourseName());
	}
	
	@Test
	public void testGetNameTwo(){
		Course course = new Course("CSSE376", 4.0);
		assertEquals("CSSE376", course.getCourseName());
	}
	
	@Test
	public void testGetCreditHoursOne(){
		Course course = new Course("CSSE376", 4.0);
		assertEquals(4.0, course.getCreditHours(), DELTA);
	}
	
	@Test
	public void testGetCreditHoursTwo(){
		Course course = new Course("CSSE376");
		assertEquals(0.0, course.getCreditHours(), DELTA);
	}
}
