import static org.junit.Assert.*;

import org.junit.Test;

public class QuarterTest {

	private static final double DELTA = 1e-15;

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
		assertEquals("CSSE376", qt.getCourseList().get(0).getCourseName());
	}

	//test cases for removing a course
	@Test
	public void testRemoveCourseOne(){
		Quarter qt = new Quarter("Spring2013");
		Course course = new Course("CSSE376");
		Course course1 = new Course("CSSE290");
		qt.addCourse(course);
		qt.addCourse(course1);
		assertTrue(qt.removeCourse(course1));
	}

	@Test
	public void testRemoveCourseTwo(){
		Quarter qt = new Quarter("Spring2013");
		Course course = new Course("CSSE376");
		assertFalse(qt.removeCourse(course));
	}

	@Test
	public void testRemoveCourseThree(){
		Quarter qt = new Quarter("Spring2013");
		Course course = new Course("CSSE376");
		Course course1 = new Course("CSSE290");
		qt.addCourse(course);
		assertFalse(qt.removeCourse(course1));
	}

	@Test
	public void testRemoveCourseFour(){
		Quarter qt = new Quarter("Spring2013");
		Course course = new Course("CSSE376");
		Course course1 = new Course("CSSE290");
		qt.addCourse(course);
		qt.addCourse(course1);
		assertTrue(qt.removeCourse(course));
		assertEquals("CSSE290", qt.getCourseList().get(0).getCourseName());
	}

	//test cases for getting the total credit hours taken in a quarter
	@Test
	public void testGetTotalCreditHoursOne(){
		Quarter qt = new Quarter("Spring2013");
		Course course = new Course("CSSE376", 4);
		Course course1 = new Course("CSSE290", 4);
		qt.addCourse(course);
		qt.addCourse(course1);
		assertEquals(8.0, qt.getTotalCreditHours(), DELTA);
	}

	@Test
	public void testGetTotalCreditHoursTwo(){
		Quarter qt = new Quarter("Spring2013");
		assertEquals(0.0, qt.getTotalCreditHours(), DELTA);
	}

	@Test
	public void testGetTotalCreditHoursThree(){
		Quarter qt = new Quarter("Spring2013");
		Course course = new Course("CSSE376", 4);
		Course course1 = new Course("CSSE290", 4);
		qt.addCourse(course);
		qt.addCourse(course1);
		qt.removeCourse(course1);
		assertEquals(4.0, qt.getTotalCreditHours(), DELTA);
	}

	@Test
	public void testGetTotalCreditHoursFour(){
		Quarter qt = new Quarter("Spring2013");
		Course course = new Course("CSSE376", 3);
		Course course1 = new Course("CSSE290", 4);
		qt.addCourse(course);
		qt.addCourse(course1);
		qt.removeCourse(course1);
		assertEquals(3.0, qt.getTotalCreditHours(), DELTA);
	}

	@Test
	public void testGetQuarterGPAOne()throws Exception{
		Quarter qt = new Quarter("Spring2013");
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("95");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		course.setRubric("rubric.txt");

		Category cat1 = new Category("HW", 1, 10.0);
		Course course1 = new Course("CSSE376", 4.0);
		cat1.getItemList().get(0).setEarnedPoints("95");
		cat1.getItemList().get(0).setTotalPoints("100");
		course1.addCategory(cat1);
		course1.setRubric("rubric.txt");

		qt.addCourse(course);
		qt.addCourse(course1);
		assertEquals(4.0, qt.getQuarterGPA(), DELTA);
	}

	@Test
	public void testGetQuarterGPATwo()throws Exception{
		Quarter qt = new Quarter("Spring2013");
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("95");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		course.setRubric("rubric.txt");

		Category cat1 = new Category("HW", 1, 10.0);
		Course course1 = new Course("CSSE376", 3.0);
		cat1.getItemList().get(0).setEarnedPoints("95");
		cat1.getItemList().get(0).setTotalPoints("100");
		course1.addCategory(cat1);
		course1.setRubric("rubric.txt");

		qt.addCourse(course);
		qt.addCourse(course1);
		assertEquals(4.0, qt.getQuarterGPA(), DELTA);
	}

	@Test
	public void testGetQuarterGPAThree()throws Exception{
		Quarter qt = new Quarter("Spring2013");
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("95");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		course.setRubric("rubric.txt");

		Category cat1 = new Category("HW", 1, 10.0);
		Course course1 = new Course("CSSE376", 4.0);
		cat1.getItemList().get(0).setEarnedPoints("80");
		cat1.getItemList().get(0).setTotalPoints("100");
		course1.addCategory(cat1);
		course1.setRubric("rubric.txt");

		qt.addCourse(course);
		qt.addCourse(course1);
		assertEquals(3.5, qt.getQuarterGPA(), DELTA);
	}

	@Test
	public void testGetQuarterGPAFour()throws Exception{
		Quarter qt = new Quarter("Spring2013");
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("95");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		course.setRubric("rubric.txt");

		Category cat1 = new Category("HW", 1, 10.0);
		Course course1 = new Course("CSSE376", 3.0);
		cat1.getItemList().get(0).setEarnedPoints("80");
		cat1.getItemList().get(0).setTotalPoints("100");
		course1.addCategory(cat1);
		course1.setRubric("rubric.txt");

		qt.addCourse(course);
		qt.addCourse(course1);		
		assertEquals(3.57, qt.getQuarterGPA(), DELTA);
	}
}