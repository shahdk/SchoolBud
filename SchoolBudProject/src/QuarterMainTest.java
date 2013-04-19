import static org.junit.Assert.*;

import org.junit.Test;


public class QuarterMainTest {

	@Test
	public void testJUnit() {
		assertTrue("JUnit works!", true);
	}
	
	@Test
	public void testInitialize(){
		assertNotNull(new QuarterMain());
	}
	
	//tests for adding and getting quarters
	@Test
	public void testaddQuarter(){
		QuarterMain qtMain = new QuarterMain();
		Quarter qt1 = new Quarter("Fall2012");
		Quarter qt2 = new Quarter("Winter2012");
		Quarter qt3 = new Quarter("Spring2013");
		qtMain.addQuarter(qt1);
		qtMain.addQuarter(qt2);
		qtMain.addQuarter(qt3);
		assertEquals("Fall2012", qtMain.getQuarterList().get(0).getName());
		assertEquals("Winter2012", qtMain.getQuarterList().get(1).getName());
		assertEquals("Spring2013", qtMain.getQuarterList().get(2).getName());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testaddQuarterTwo(){
		QuarterMain qtMain = new QuarterMain();
		Quarter qt1 = new Quarter("Fall2012");
		Quarter qt2 = new Quarter("Fall2012");
		qtMain.addQuarter(qt1);
		qtMain.addQuarter(qt2);	}
	
	@Test
	public void testremoveQuarter(){
		QuarterMain qtMain = new QuarterMain();
		Quarter qt1 = new Quarter("Fall2012");
		Quarter qt2 = new Quarter("Winter2012");
		Quarter qt3 = new Quarter("Spring2013");
		qtMain.addQuarter(qt1);
		qtMain.addQuarter(qt2);
		qtMain.addQuarter(qt3);
		assertTrue(qtMain.removeQuarter("Fall2012"));
	}
	
	@Test
	public void testremoveQuarterTwo(){
		QuarterMain qtMain = new QuarterMain();
		Quarter qt1 = new Quarter("Fall2012");
		Quarter qt2 = new Quarter("Winter2012");
		qtMain.addQuarter(qt1);
		qtMain.addQuarter(qt2);
		assertTrue(qtMain.removeQuarter("Fall2012"));
		assertEquals("Winter2012", qtMain.getQuarterList().get(0).getName());
	}
	
	@Test
	public void testremoveQuarterThree(){
		QuarterMain qtMain = new QuarterMain();
		assertFalse(qtMain.removeQuarter("Fall2012"));
	}
	
	@Test
	public void testremoveQuarterFour(){
		QuarterMain qtMain = new QuarterMain();
		Quarter qt2 = new Quarter("Winter2012");
		qtMain.addQuarter(qt2);
		assertFalse(qtMain.removeQuarter("Fall2012"));
	}
	
	@Test
	public void testremoveQuarterFive(){
		QuarterMain qtMain = new QuarterMain();
		Quarter qt2 = new Quarter("Winter2012");
		qtMain.addQuarter(qt2);
		assertFalse(qtMain.removeQuarter("Fall2012"));
		assertEquals("Winter2012", qtMain.getQuarterList().get(0).getName());
	}
	
	@Test
	public void testLoadAndSaveQuarter(){
		QuarterMain qtMain = new QuarterMain();
		Quarter qt1 = new Quarter("Fall2012");
		Quarter qt2 = new Quarter("Winter2012");
		Quarter qt3 = new Quarter("Spring2013");
		Course course = new Course("CSSE376", 3);
		Course course1 = new Course("CSSE290", 4);
		Category cat = new Category("HW", 1, 10.0);
		Category cat1 = new Category("HW", 1, 10.0);
		Rubric rubric = new Rubric();
		rubric.setDefaults();
		
		cat.getItemList().get(0).setEarnedPoints("73");
		cat.getItemList().get(0).setTotalPoints("100");
		cat1.getItemList().get(0).setEarnedPoints("95");
		cat1.getItemList().get(0).setTotalPoints("100");
		
		course.addCategory(cat);
		course1.addCategory(cat);
		course1.addCategory(cat1);
		course.setRubric(rubric);
		course1.setRubric(rubric);
		
		qt1.addCourse(course);
		qt1.addCourse(course1);
		qt2.addCourse(course);		
		
		qtMain.addQuarter(qt1);
		qtMain.addQuarter(qt2);
		qtMain.addQuarter(qt3);
		
		qtMain.saveFile("shahdk.txt");
		qtMain.loadFile("shahdk.txt");
		
		assertEquals("Fall2012", qtMain.getQuarterList().get(0).getName());
	}

}
