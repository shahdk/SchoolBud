import static org.junit.Assert.*;

import org.junit.Test;

public class QuarterTest {

	@Test
	public void testJUnit() {
		assertTrue("JUnit works!", true);
	}
	
	@Test
	public void testInitializeOne(){
		assertNotNull(new Quarter("Spring2013"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInitializeTwo(){
		assertNotNull(new Quarter(""));	}
	
	//test cases for getting and setting quarter name.
	@Test
	public void testGetNameOne(){
		Quarter qt = new Quarter("Spring2013");
		assertEquals("Spring2013", qt.getName());
	}
	
	@Test
	public void testSetNameOne(){
		Quarter qt = new Quarter("Spring2013");
		qt.setName("Spring2012-13");
		assertEquals("Spring2012-13", qt.getName());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetNameTwo(){
		Quarter qt = new Quarter("Spring2013");
		qt.setName("");	}
	
	//test cases for getting and adding courses
	@Test
	public void testAddCourseOne(){
		Quarter qt = new Quarter("Spring2013");
		Course course = new Course("CSSE376");
		qt.addCourse(course);
		assertEquals("CSSE376", qt.getCourseList().get(0).getName());
	}
}
