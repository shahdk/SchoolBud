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
	
	@Test(expected=IllegalArgumentException.class)
	public void testInitializeWithEmptyName(){
		new Course("");	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInitializeWithEmptyNameTwo(){
		new Course("", 4.0);	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInitializeWithNegativeCreditHours(){
		new Course("CSSE376", -9.0);	}

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
	
	//test cases for set methods
	@Test
	public void testSetNameOne(){
		Course course = new Course("CSSE376");
		course.setName("CSSE304");
		assertEquals("CSSE304", course.getCourseName());
	}
	
	@Test
	public void testSetNameTwo(){
		Course course = new Course("CSSE376", 4.0);
		course.setName("CSSE304");
		assertEquals("CSSE304", course.getCourseName());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetEmptyName(){
		Course course = new Course("CSSE376", 4.0);
		course.setName(""); }
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetEmptyNameTwo(){
		Course course = new Course("CSSE376");
		course.setName(""); }
	
	@Test
	public void testSetCreditHoursOne(){
		Course course = new Course("CSSE376", 4.0);
		course.setCreditHours(5.0);
		assertEquals(5.0, course.getCreditHours(), DELTA);
	}
	
	@Test
	public void testSetCreditHoursTwo(){
		Course course = new Course("CSSE376");
		course.setCreditHours(4.0);
		assertEquals(4.0, course.getCreditHours(), DELTA);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetNegativeCreditHour(){
		Course course = new Course("CSSE376", 4.0);
		course.setCreditHours(-6.0); }
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetNegativeCreditHourTwo(){
		Course course = new Course("CSSE376");
		course.setCreditHours(-5.5); }
}
