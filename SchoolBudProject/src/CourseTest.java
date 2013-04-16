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
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddCategorFour() {
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(new Category("HW", 10.0));
		course.addCategory(new Category("HW", 20.0));}
	
	//test cases for removing categories
	@Test
	public void testRemoveCategoryOne() {
		Category cat = new Category("HW", 10.0);
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(cat);
		assertTrue(course.removeCategory("HW"));
	}

	@Test
	public void testRemoveCategoryTwo() {
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(new Category("HW", 10.0));
		course.addCategory(new Category("Quiz", 20.0));
		course.addCategory(new Category("Exam", 40.0));
		course.addCategory(new Category("Final", 30.0));
		assertTrue(course.removeCategory("Quiz"));
		assertEquals("Exam", course.getCategories().get(1).getName());
	}

	@Test
	public void testRemoveCategoryThree() {
		Course course = new Course("CSSE376", 4.0);
		assertFalse(course.removeCategory("HW"));
	}
	
	@Test
	public void testRemoveCategoryFour() {
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(new Category("HW", 10.0));
		course.addCategory(new Category("Exam", 40.0));
		assertFalse(course.removeCategory("Final"));
	}

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
	/**
	 * For the purpose of testing we are using 0 as a min, and 100 as a max. 
	 * However, we do not throw an exception if the value is less than 0 because 
	 * it is possible to have negative grades, or grades greater than 100.
	 */
	@Test
	public void testCourseGradesMinMinus() {
		Category cat = new Category("HW", 10, 10.0);
		Course course = new Course("CSSE376", 4.0);
		for (int i = 0; i < 10; i++) {
			cat.getItemList().get(i).setEarnedPoints("-7.5");
			cat.getItemList().get(i).setTotalPoints("10");
		}
		course.addCategory(cat);
		assertEquals(-75.0, course.getCourseGrade(), DELTA);
	}
	
	@Test
	public void testCourseGradesMin() {
		Category cat = new Category("HW", 10, 10.0);
		Course course = new Course("CSSE376", 4.0);
		for (int i = 0; i < 10; i++) {
			cat.getItemList().get(i).setEarnedPoints("0");
			cat.getItemList().get(i).setTotalPoints("10");
		}
		course.addCategory(cat);
		assertEquals(0.0, course.getCourseGrade(), DELTA);
	}
	
	@Test
	public void testCourseGradesMinPlus() {
		Category cat = new Category("HW", 10, 10.0);
		Course course = new Course("CSSE376", 4.0);
		for (int i = 0; i < 10; i++) {
			cat.getItemList().get(i).setEarnedPoints("2.5");
			cat.getItemList().get(i).setTotalPoints("10");
		}
		course.addCategory(cat);
		assertEquals(25.0, course.getCourseGrade(), DELTA);
	}
	
	@Test
	public void testCourseGradesNominal() {
		Category cat = new Category("HW", 10, 10.0);
		Course course = new Course("CSSE376", 4.0);
		for (int i = 0; i < 10; i++) {
			cat.getItemList().get(i).setEarnedPoints("6.5");
			cat.getItemList().get(i).setTotalPoints("10");
		}
		course.addCategory(cat);
		assertEquals(65.0, course.getCourseGrade(), DELTA);
	}

	@Test
	public void testCourseGradesMaxMinus() {
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
	
	@Test
	public void testCourseGradesMax() {
		Category hw = new Category("HW", 10, 10.0);
		Category quiz = new Category("Quiz", 5, 20.0);
		Course course = new Course("CSSE376", 4.0);
		for (int i = 0; i < 10; i++) {
			hw.getItemList().get(i).setEarnedPoints("10");
			hw.getItemList().get(i).setTotalPoints("10");
		}
		for (int i = 0; i < 5; i++) {
			quiz.getItemList().get(i).setEarnedPoints("100");
			quiz.getItemList().get(i).setTotalPoints("100");
		}
		course.addCategory(hw);
		course.addCategory(quiz);
		assertEquals(100.0, course.getCourseGrade(), DELTA);
	}
	
	@Test
	public void testCourseGradesMaxPlus() {
		Category cat = new Category("HW", 10, 10.0);
		Course course = new Course("CSSE376", 4.0);
		for (int i = 0; i < 10; i++) {
			cat.getItemList().get(i).setEarnedPoints("10.5");
			cat.getItemList().get(i).setTotalPoints("10");
		}
		course.addCategory(cat);
		assertEquals(105.0, course.getCourseGrade(), DELTA);
	}
	
	//test cases for calculating course to acheive target grade
	@Test(expected = IllegalArgumentException.class)
	public void testNeededCourseGradesMinMinusTargetGradeAndMinMinusEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("-86");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("-72");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("-92");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("-50");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(-5);	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNeededCourseGradesMinMinusTargetGradeAndMinEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("0");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("0");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("0");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("0");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(-5);	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNeededCourseGradesMinMinusTargetGradeAndMinPlusEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("5");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("7");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("9");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("5");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(-5);	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNeededCourseGradesMinMinusTargetGradeAndNominalEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("50");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("50");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("50");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("50");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(-5);	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNeededCourseGradesMinMinusTargetGradeAndMaxMinusEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("95");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("95");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("95");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("95");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(-5);	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNeededCourseGradesMinMinusTargetGradeAndMaxEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("100");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("100");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("100");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("100");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(-5);	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNeededCourseGradesMinMinusTargetGradeAndMaxPlusEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("110");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("110");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("110");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("110");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(-5);	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNeededCourseGradesMaxPlusTargetGradeAndMinMinusEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("-86");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("-72");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("-92");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("-50");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(110);	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNeededCourseGradesMaxPlusTargetGradeAndMinEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("0");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("0");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("0");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("0");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(110);	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNeededCourseGradesMaxPlusTargetGradeAndMinPlusEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("5");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("7");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("9");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("5");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(110);	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNeededCourseGradesMaxPlusTargetGradeAndNominalEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("50");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("50");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("50");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("50");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(110);	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNeededCourseGradesMaxPlusTargetGradeAndMaxMinusEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("95");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("95");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("95");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("95");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(110);	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNeededCourseGradesMaxPlusTargetGradeAndMaxEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("100");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("100");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("100");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("100");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(110);	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNeededCourseGradesMaxPlusTargetGradeAndMaxPlusEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("110");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("110");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("110");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("110");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(110);	}
	
	@Test
	public void testNeededCourseGradesMinTargetGradeAndMinMinusEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("-86");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("-72");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("-92");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("-50");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(0);
		assertEquals(327.0, course.getNeededCourseGrade(), DELTA);
	}
	
	@Test
	public void testNeededCourseGradesMinTargetGradeAndMinEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("0");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("0");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("0");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("0");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(0);
		assertEquals(0.0, course.getNeededCourseGrade(), DELTA);	
	}
	
	@Test
	public void testNeededCourseGradesMinTargetGradeAndMinPlusEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("5");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("7");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("9");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("5");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(0);
		assertEquals(-26.0, course.getNeededCourseGrade(), DELTA);
	}
	
	@Test
	public void testNeededCourseGradesMinTargetGradeAndNominalEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("50");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("50");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("50");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("50");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(0);
		assertEquals(-200.0, course.getNeededCourseGrade(), DELTA);
	}
	
	@Test
	public void testNeededCourseGradesMinTargetGradeAndMaxMinusEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("95");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("95");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("95");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("95");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(0);
		assertEquals(-380.0, course.getNeededCourseGrade(), DELTA);
	}
	
	@Test
	public void testNeededCourseGradesMinTargetGradeAndMaxEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("100");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("100");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("100");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("100");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(0);
		assertEquals(-400.0, course.getNeededCourseGrade(), DELTA);
	}
	
	@Test
	public void testNeededCourseGradesMinTargetGradeAndMaxPlusEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("110");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("110");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("110");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("110");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(0);
		assertEquals(-440.0, course.getNeededCourseGrade(), DELTA);
	}
	
	@Test
	public void testNeededCourseGradesMinPlusTargetGradeAndMinMinusEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("-86");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("-72");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("-92");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("-50");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(5);
		assertEquals(352.0, course.getNeededCourseGrade(), DELTA);
	}
	
	@Test
	public void testNeededCourseGradesMinPlusTargetGradeAndMinEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("0");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("0");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("0");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("0");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(5);
		assertEquals(25.0, course.getNeededCourseGrade(), DELTA);	
	}
	
	@Test
	public void testNeededCourseGradesMinPlusTargetGradeAndMinPlusEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("5");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("7");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("9");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("5");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(5);
		assertEquals(-1.0, course.getNeededCourseGrade(), DELTA);
	}
	
	@Test
	public void testNeededCourseGradesMinPlusTargetGradeAndNominalEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("50");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("50");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("50");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("50");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(5);
		assertEquals(-175.0, course.getNeededCourseGrade(), DELTA);
	}
	
	@Test
	public void testNeededCourseGradesMinPlusTargetGradeAndMaxMinusEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("95");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("95");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("95");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("95");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(5);
		assertEquals(-355.0, course.getNeededCourseGrade(), DELTA);
	}
	
	@Test
	public void testNeededCourseGradesMinPlusTargetGradeAndMaxEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("100");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("100");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("100");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("100");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(5);
		assertEquals(-375.0, course.getNeededCourseGrade(), DELTA);
	}
	
	@Test
	public void testNeededCourseGradesMinPlusTargetGradeAndMaxPlusEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("110");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("110");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("110");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("110");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(5);
		assertEquals(-415.0, course.getNeededCourseGrade(), DELTA);
	}
	
	@Test
	public void testNeededCourseGradesNominalTargetGradeAndMinMinusEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("-86");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("-72");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("-92");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("-50");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(50);
		assertEquals(577.0, course.getNeededCourseGrade(), DELTA);
	}
	
	@Test
	public void testNeededCourseGradesNominalTargetGradeAndMinEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("0");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("0");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("0");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("0");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(50);
		assertEquals(250.0, course.getNeededCourseGrade(), DELTA);	
	}
	
	@Test
	public void testNeededCourseGradesNominalTargetGradeAndMinPlusEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("5");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("7");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("9");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("5");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(50);
		assertEquals(224.0, course.getNeededCourseGrade(), DELTA);
	}
	
	@Test
	public void testNeededCourseGradesNominalTargetGradeAndNominalEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("50");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("50");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("50");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("50");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(50);
		assertEquals(50.0, course.getNeededCourseGrade(), DELTA);
	}
	
	@Test
	public void testNeededCourseGradesNominalTargetGradeAndMaxMinusEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("95");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("95");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("95");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("95");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(50);
		assertEquals(-130.0, course.getNeededCourseGrade(), DELTA);
	}
	
	@Test
	public void testNeededCourseGradesNominalTargetGradeAndMaxEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("100");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("100");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("100");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("100");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(50);
		assertEquals(-150.0, course.getNeededCourseGrade(), DELTA);
	}
	
	@Test
	public void testNeededCourseGradesNominalTargetGradeAndMaxPlusEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("110");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("110");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("110");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("110");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(50);
		assertEquals(-190.0, course.getNeededCourseGrade(), DELTA);
	}
	
	@Test
	public void testNeededCourseGradesMaxMinusTargetGradeAndMinMinusEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("-86");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("-72");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("-92");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("-50");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(90);
		assertEquals(777.0, course.getNeededCourseGrade(), DELTA);
	}
	
	@Test
	public void testNeededCourseGradesMaxMinusTargetGradeAndMinEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("0");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("0");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("0");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("0");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(90);
		assertEquals(450.0, course.getNeededCourseGrade(), DELTA);	
	}
	
	@Test
	public void testNeededCourseGradesMaxMinusTargetGradeAndMinPlusEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("5");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("7");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("9");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("5");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(90);
		assertEquals(424.0, course.getNeededCourseGrade(), DELTA);
	}
	
	@Test
	public void testNeededCourseGradesMaxMinusTargetGradeAndNominalEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("50");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("50");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("50");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("50");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(90);
		assertEquals(250.0, course.getNeededCourseGrade(), DELTA);
	}
	
	@Test
	public void testNeededCourseGradesMaxMinusTargetGradeAndMaxMinusEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("95");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("95");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("95");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("95");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(90);
		assertEquals(70.0, course.getNeededCourseGrade(), DELTA);
	}
	
	@Test
	public void testNeededCourseGradesMaxMinusTargetGradeAndMaxEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("100");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("100");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("100");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("100");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(90);
		assertEquals(50.0, course.getNeededCourseGrade(), DELTA);
	}
	
	@Test
	public void testNeededCourseGradesMaxMinusTargetGradeAndMaxPlusEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("110");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("110");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("110");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("110");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(90);
		assertEquals(10.0, course.getNeededCourseGrade(), DELTA);
	}
	
	@Test
	public void testNeededCourseGradesMaxTargetGradeAndMinMinusEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("-86");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("-72");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("-92");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("-50");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(100);
		assertEquals(827.0, course.getNeededCourseGrade(), DELTA);
	}
	
	@Test
	public void testNeededCourseGradesMaxTargetGradeAndMinEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("0");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("0");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("0");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("0");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(100);
		assertEquals(500.0, course.getNeededCourseGrade(), DELTA);	
	}
	
	@Test
	public void testNeededCourseGradesMaxTargetGradeAndMinPlusEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("5");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("7");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("9");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("5");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(100);
		assertEquals(474.0, course.getNeededCourseGrade(), DELTA);
	}
	
	@Test
	public void testNeededCourseGradesMaxTargetGradeAndNominalEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("50");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("50");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("50");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("50");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(100);
		assertEquals(300.0, course.getNeededCourseGrade(), DELTA);
	}
	
	@Test
	public void testNeededCourseGradesMaxTargetGradeAndMaxMinusEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("95");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("95");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("95");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("95");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(100);
		assertEquals(120.0, course.getNeededCourseGrade(), DELTA);
	}
	
	@Test
	public void testNeededCourseGradesMaxTargetGradeAndMaxEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("100");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("100");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("100");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("100");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(100);
		assertEquals(100.0, course.getNeededCourseGrade(), DELTA);
	}
	
	@Test
	public void testNeededCourseGradesMaxTargetGradeAndMaxPlusEarnedGrade() {
		Category item1 = new Category("HW", 1, 35.0);
		Category item2 = new Category("Quiz", 1, 20.0);
		Category item3 = new Category("Assignment", 1, 20.0);
		Category item4 = new Category("Temp", 1, 5.0);
		
		item1.getItemList().get(0).setEarnedPoints("110");
		item1.getItemList().get(0).setTotalPoints("100");
		item2.getItemList().get(0).setEarnedPoints("110");
		item2.getItemList().get(0).setTotalPoints("100");
		item3.getItemList().get(0).setEarnedPoints("110");
		item3.getItemList().get(0).setTotalPoints("100");
		item4.getItemList().get(0).setEarnedPoints("110");
		item4.getItemList().get(0).setTotalPoints("100");
		
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(item1);
		course.addCategory(item2);
		course.addCategory(item3);
		course.addCategory(item4);
		course.setTargetGrade(100);
		assertEquals(60.0, course.getNeededCourseGrade(), DELTA);
	}
	
	@Test
	public void testSetrubricOne() throws Exception{
		Course course = new Course("CSSE376", 4.0);
		course.setRubric("rubric.txt");
		assertEquals(4.0, course.getRubric().getGPA("A"), DELTA);
	}
	
	@Test
	public void testSetrubricTwo() throws Exception{
		Course course = new Course("CSSE376");
		course.setRubric("rubric.txt");
		assertEquals(4.0, course.getRubric().getGPA("A"), DELTA);
	}
	
	@Test
	public void testALetterGradesMinMinus() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("89.99");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("A", course.getLetterGrade());
	}
	
	@Test
	public void testALetterGradesMin() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("90.0");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("A", course.getLetterGrade());
	}
	
	@Test
	public void testALetterGradesMinPlus() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("90.99");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("A", course.getLetterGrade());
	}
	
	@Test
	public void testALetterGradesNominal() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("95.00");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("A", course.getLetterGrade());
	}

	@Test
	public void testALetterGradesMaxMinus() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("99.99");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("A", course.getLetterGrade());
	}
	
	@Test
	public void testALetterGradesMax() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("100");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("A", course.getLetterGrade());
	}
	
	@Test
	public void testALetterGradesMaxPlus() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("100.99");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("A", course.getLetterGrade());
	}
	
	@Test
	public void testBPlusLetterGradesMinMinus() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("84.99");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("B+", course.getLetterGrade());
	}
	
	@Test
	public void testBPlusLetterGradesMin() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("85.0");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("B+", course.getLetterGrade());
	}
	
	@Test
	public void testBPlusLetterGradesMinPlus() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("85.99");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("B+", course.getLetterGrade());
	}
	
	@Test
	public void testBPlusLetterGradesNominal() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("87.00");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("B+", course.getLetterGrade());
	}

	@Test
	public void testBPlusLetterGradesMaxMinus() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("88.99");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("B+", course.getLetterGrade());
	}
	
	@Test
	public void testBPlusLetterGradesMax() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("89");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("B+", course.getLetterGrade());
	}
	
	@Test
	public void testBPlusLetterGradesMaxPlus() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("89.99");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("A", course.getLetterGrade());
	}
	
	@Test
	public void testBLetterGradesMinMinus() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("79.99");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("B", course.getLetterGrade());
	}
	
	@Test
	public void testBLetterGradesMin() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("80.0");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("B", course.getLetterGrade());
	}
	
	@Test
	public void testBLetterGradesMinPlus() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("80.99");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("B", course.getLetterGrade());
	}
	
	@Test
	public void testBLetterGradesNominal() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("82.00");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("B", course.getLetterGrade());
	}

	@Test
	public void testBLetterGradesMaxMinus() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("83.99");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("B", course.getLetterGrade());
	}
	
	@Test
	public void testBLetterGradesMax() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("84");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("B", course.getLetterGrade());
	}
	
	@Test
	public void testBLetterGradesMaxPlus() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("84.99");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("B+", course.getLetterGrade());
	}
	
	@Test
	public void testCLetterGradesMinMinus() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("69.99");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("C", course.getLetterGrade());
	}
	
	@Test
	public void testCLetterGradesMin() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("70.0");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("C", course.getLetterGrade());
	}
	
	@Test
	public void testCLetterGradesMinPlus() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("70.99");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("C", course.getLetterGrade());
	}
	
	@Test
	public void testCLetterGradesNominal() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("72.00");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("C", course.getLetterGrade());
	}

	@Test
	public void testCLetterGradesMaxMinus() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("73.99");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("C", course.getLetterGrade());
	}
	
	@Test
	public void testCLetterGradesMax() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("74");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("C", course.getLetterGrade());
	}
	
	@Test
	public void testCLetterGradesMaxPlus() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("74.99");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("C+", course.getLetterGrade());
	}
	
	@Test
	public void testCPlusLetterGradesMinMinus() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("74.99");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("C+", course.getLetterGrade());
	}
	
	@Test
	public void testCPlusLetterGradesMin() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("75.0");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("C+", course.getLetterGrade());
	}
	
	@Test
	public void testCPlusLetterGradesMinPlus() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("75.99");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("C+", course.getLetterGrade());
	}
	
	@Test
	public void testCPlusLetterGradesNominal() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("77.00");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("C+", course.getLetterGrade());
	}

	@Test
	public void testCPlusLetterGradesMaxMinus() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("78.99");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("C+", course.getLetterGrade());
	}
	
	@Test
	public void testCPlusLetterGradesMax() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("79");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("C+", course.getLetterGrade());
	}
	
	@Test
	public void testCPlusLetterGradesMaxPlus() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("79.99");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("B", course.getLetterGrade());
	}
	
	@Test
	public void testDPlusLetterGradesMinMinus() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("64.99");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("D+", course.getLetterGrade());
	}
	
	@Test
	public void testDPlusLetterGradesMin() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("65.0");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("D+", course.getLetterGrade());
	}
	
	@Test
	public void testDPLusLetterGradesMinPlus() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("65.99");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("DPlus", course.getLetterGrade());
	}
	
	@Test
	public void testDPlusLetterGradesNominal() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("67.00");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("D+", course.getLetterGrade());
	}

	@Test
	public void testDPlusLetterGradesMaxMinus() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("68.99");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("D+", course.getLetterGrade());
	}
	
	@Test
	public void testDPlusLetterGradesMax() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("69");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("D+", course.getLetterGrade());
	}
	
	@Test
	public void testDPlusLetterGradesMaxPlus() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("69.99");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("C", course.getLetterGrade());
	}
	
	@Test
	public void testDLetterGradesMinMinus() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("59.99");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("D", course.getLetterGrade());
	}
	
	@Test
	public void testDLetterGradesMin() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("60.0");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("D", course.getLetterGrade());
	}
	
	@Test
	public void testDLetterGradesMinPlus() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("60.99");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("D", course.getLetterGrade());
	}
	
	@Test
	public void testDLetterGradesNominal() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("62.00");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("D", course.getLetterGrade());
	}

	@Test
	public void testDLetterGradesMaxMinus() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("63.99");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("D", course.getLetterGrade());
	}
	
	@Test
	public void testDLetterGradesMax() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("64");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("D", course.getLetterGrade());
	}
	
	@Test
	public void testDLetterGradesMaxPlus() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("64.99");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("D+", course.getLetterGrade());
	}
	
	@Test
	public void testFLetterGradesMinMinus() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("-89.99");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("F", course.getLetterGrade());
	}
	
	@Test
	public void testFLetterGradesMin() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("0.0");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("F", course.getLetterGrade());
	}
	
	@Test
	public void testFLetterGradesMinPlus() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("0.99");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("F", course.getLetterGrade());
	}
	
	@Test
	public void testFLetterGradesNominal() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("30.00");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("F", course.getLetterGrade());
	}

	@Test
	public void testFLetterGradesMaxMinus() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("54.99");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("F", course.getLetterGrade());
	}
	
	@Test
	public void testFLetterGradesMax() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("59");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("F", course.getLetterGrade());
	}
	
	@Test
	public void testFLetterGradesMaxPlus() {
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("59.99");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals("D", course.getLetterGrade());
	}
	
	@Test
	public void testALetterGPA(){
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("95");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals(4.0, course.getCourseGPA(), DELTA);
	}
	
	@Test
	public void testBPlusLetterGPA(){
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("88");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals(3.5, course.getCourseGPA(), DELTA);
	}
	
	@Test
	public void testBLetterGPA(){
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("82");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals(3.0, course.getCourseGPA(), DELTA);
	}
	
	@Test
	public void testCPlusLetterGPA(){
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("78");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals(2.5, course.getCourseGPA(), DELTA);
	}
	
	@Test
	public void testCLetterGPA(){
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("73");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals(2.0, course.getCourseGPA(), DELTA);
	}
	
	@Test
	public void testDPlusLetterGPA(){
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("68");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals(1.5, course.getCourseGPA(), DELTA);
	}
	
	@Test
	public void testDLetterGPA(){
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("62");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals(1.0, course.getCourseGPA(), DELTA);
	}
	
	@Test
	public void testFLetterGPA(){
		Category cat = new Category("HW", 1, 10.0);
		Course course = new Course("CSSE376", 4.0);
		cat.getItemList().get(0).setEarnedPoints("40");
		cat.getItemList().get(0).setTotalPoints("100");
		course.addCategory(cat);
		assertEquals(0.0, course.getCourseGPA(), DELTA);
	}
}
