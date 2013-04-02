import static org.junit.Assert.*;

import java.util.ArrayList;

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
	
	//test cases for adding and getting categories
	@Test
	public void testAddCategory(){
		Category cat = new Category("HW", 10.0);
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(cat);
		assertEquals("HW", course.getCategories().get(0).getName());
	}
	
	@Test
	public void testAddCategoryTwo(){
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(new Category("HW", 10.0));
		course.addCategory(new Category("Quiz", 20.0));
		course.addCategory(new Category("Exam", 40.0));
		course.addCategory(new Category("Final", 30.0));
		assertEquals("Final", course.getCategories().get(3).getName());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAddCategorThree(){
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(new Category("HW", 10.0));
		course.addCategory(new Category("Quiz", 20.0));
		course.addCategory(new Category("Exam", 40.0));
		course.addCategory(new Category("Final", 30.0));
		course.addCategory(new Category("Final2", 30.0)); }
	
	//test cases course grades
	@Test
	public void testCourseGrades(){
		ArrayList<Item> hwItems = new ArrayList<Item>();
		for (int i = 1; i <= 10; i++) {
			hwItems.add(new Item("HW" + i, "8.5", "10", 1));
		}
		Category cat = new Category("HW", hwItems, 10.0);
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(cat);
		assertEquals(85.0, course.getCourseGrade(), DELTA);
	}
	
	
	@Test
	public void testCourseGradesOne(){
		ArrayList<Item> hwItems = new ArrayList<Item>();
		ArrayList<Item> quizItems = new ArrayList<Item>();
		for (int i = 1; i <= 10; i++) {
			hwItems.add(new Item("HW" + i, "8.5", "10", 1));
		}
		for(int i=1; i<= 5 ; i++){
			quizItems.add(new Item("Quiz"+i, "95", "100", 4));
		}
		Category hw = new Category("HW", hwItems, 10.0);
		Category quiz = new Category("Quiz", quizItems, 20.0);
		Course course = new Course("CSSE376", 4.0);
		course.addCategory(hw);
		course.addCategory(quiz);
		assertEquals(91.67, course.getCourseGrade(), DELTA);
	}
}
