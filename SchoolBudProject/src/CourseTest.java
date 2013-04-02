import static org.junit.Assert.*;

import org.junit.Test;

public class CourseTest {

	private static final double DELTA = 1e-15;

	@Test
	public void testJUnit() {
		assertTrue("JUnit works!", true);
	}

	// test cases for initializing Course
	@Test
	public void testInitializeOne() {
		assertNotNull(new Course("CSSE376"));
	}

	@Test
	public void testInitializeTwo() {
		assertNotNull(new Course("CSSE376", 4.0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInitializeWithEmptyName() {
		new Course("");	}

	@Test(expected = IllegalArgumentException.class)
	public void testInitializeWithEmptyNameTwo() {
		new Course("", 4.0);	}

	@Test(expected = IllegalArgumentException.class)
	public void testInitializeWithNegativeCreditHours() {
		new Course("CSSE376", -9.0);	}

	// test case for get methods
	@Test
	public void testGetNameOne() {
		Course course = new Course("CSSE376");
		assertEquals("CSSE376", course.getCourseName());
	}

	@Test
	public void testGetNameTwo() {
		Course course = new Course("CSSE376", 4.0);
		assertEquals("CSSE376", course.getCourseName());
	}

	@Test
	public void testGetCreditHoursOne() {
		Course course = new Course("CSSE376", 4.0);
		assertEquals(4.0, course.getCreditHours(), DELTA);
	}

	@Test
	public void testGetCreditHoursTwo() {
		Course course = new Course("CSSE376");
		assertEquals(0.0, course.getCreditHours(), DELTA);
	}

	// test cases for set methods
	@Test
	public void testSetNameOne() {
		Course course = new Course("CSSE376");
		course.setName("CSSE304");
		assertEquals("CSSE304", course.getCourseName());
	}

	@Test
	public void testSetNameTwo() {
		Course course = new Course("CSSE376", 4.0);
		course.setName("CSSE304");
		assertEquals("CSSE304", course.getCourseName());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetEmptyName() {
		Course course = new Course("CSSE376", 4.0);
		course.setName("");	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetEmptyNameTwo() {
		Course course = new Course("CSSE376");
		course.setName("");	}

	@Test
	public void testSetCreditHoursOne() {
		Course course = new Course("CSSE376", 4.0);
		course.setCreditHours(5.0);
		assertEquals(5.0, course.getCreditHours(), DELTA);
	}

	@Test
	public void testSetCreditHoursTwo() {
		Course course = new Course("CSSE376");
		course.setCreditHours(4.0);
		assertEquals(4.0, course.getCreditHours(), DELTA);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetNegativeCreditHour() {
		Course course = new Course("CSSE376", 4.0);
		course.setCreditHours(-6.0);	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetNegativeCreditHourTwo() {
		Course course = new Course("CSSE376");
		course.setCreditHours(-5.5);	}

	// test cases for adding and getting categories
	@Test
	public void testAddCategory() {
		Category cat = new Category("HW", 10.0);
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(cat);
		assertEquals("HW", course.getCategories().get(0).getName());
	}

	@Test
	public void testAddCategoryTwo() {
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(new Category("HW", 10.0));
		course.addCategory(new Category("Quiz", 20.0));
		course.addCategory(new Category("Exam", 40.0));
		course.addCategory(new Category("Final", 30.0));
		assertEquals("Final", course.getCategories().get(3).getName());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddCategorThree() {
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(new Category("HW", 10.0));
		course.addCategory(new Category("Quiz", 20.0));
		course.addCategory(new Category("Exam", 40.0));
		course.addCategory(new Category("Final", 30.0));
		course.addCategory(new Category("Final2", 30.0));	}

	//test cases for getting and setting target grade
	@Test
	public void testTargetGradeMin(){
		Course course = new Course("CSSE376", 4.0);
		course.setTargetGrade(0.0);
		assertEquals(0.0, course.getTargetGrade(), DELTA);
	}
	
	@Test
	public void testTargetMinPlus(){
		Course course = new Course("CSSE376", 4.0);
		course.setTargetGrade(10.0);
		assertEquals(10.0, course.getTargetGrade(), DELTA);
	}
	
	@Test
	public void testTargetGradeNominal(){
		Course course = new Course("CSSE376", 4.0);
		course.setTargetGrade(50.0);
		assertEquals(50.0, course.getTargetGrade(), DELTA);
	}
	
	@Test
	public void testTargetGradeMaxMinus(){
		Course course = new Course("CSSE376", 4.0);
		course.setTargetGrade(90.0);
		assertEquals(90.0, course.getTargetGrade(), DELTA);
	}
	
	@Test
	public void testTargetGradeMax(){
		Course course = new Course("CSSE376", 4.0);
		course.setTargetGrade(100.0);
		assertEquals(100.0, course.getTargetGrade(), DELTA);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTargetGradeOverHundred(){
		Course course = new Course("CSSE376", 4.0);
		course.setTargetGrade(190.0);	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTargetGradeNegative(){
		Course course = new Course("CSSE376", 4.0);
		course.setTargetGrade(-90.0);	}
	
	// test cases course grades
	@Test
	public void testCourseGrades() {
		Category cat = new Category("HW", 10, 10.0);
		Course course = new Course("CSSE376", 4.0);
		for (int i = 0; i < 10; i++) {
			cat.getItemList().get(i).setEarnedPoints("8.5");
			cat.getItemList().get(i).setTotalPoints("10");
		}
		course.addCategory(cat);
		assertEquals(85.0, course.getCourseGrade(), DELTA);
	}

	@Test
	public void testCourseGradesOne() {
		Category hw = new Category("HW", 10, 10.0);
		Category quiz = new Category("Quiz", 5, 20.0);
		Course course = new Course("CSSE376", 4.0);
		for (int i = 0; i < 10; i++) {
			hw.getItemList().get(i).setEarnedPoints("8.5");
			hw.getItemList().get(i).setTotalPoints("10");
		}
		for (int i = 0; i < 5; i++) {
			quiz.getItemList().get(i).setEarnedPoints("95");
			quiz.getItemList().get(i).setTotalPoints("100");
		}
		course.addCategory(hw);
		course.addCategory(quiz);
		assertEquals(91.67, course.getCourseGrade(), DELTA);
	}
	
	//test cases for calculating course to acheive target grade
	@Test
	public void testNeededCourseGrades() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		
		item1.getItemList().get(0).setEarnedPoints("86");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("72");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("92");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("50");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(82.40);
		assertEquals(85.0, course.getNeededCourseGrade(), DELTA);
	}
}
