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
	
	@Test(expected = IllegalArgumentException.class)
	public void testremoveQuarterTwo(){
		QuarterMain qtMain = new QuarterMain();
		Quarter qt1 = new Quarter("Fall2012");
		Quarter qt2 = new Quarter("Winter2012");
		qtMain.addQuarter(qt1);
		qtMain.addQuarter(qt2);
		assertTrue(qtMain.removeQuarter("Fall2012"));
		assertEquals("Winter2012", qtMain.getQuarterList().get(0).getName());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testremoveQuarterThree(){
		QuarterMain qtMain = new QuarterMain();
		assertFalse(qtMain.removeQuarter("Fall2012"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testremoveQuarterFour(){
		QuarterMain qtMain = new QuarterMain();
		Quarter qt2 = new Quarter("Winter2012");
		qtMain.addQuarter(qt2);
		assertFalse(qtMain.removeQuarter("Fall2012"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testremoveQuarterFour(){
		QuarterMain qtMain = new QuarterMain();
		Quarter qt2 = new Quarter("Winter2012");
		qtMain.addQuarter(qt2);
		assertFalse(qtMain.removeQuarter("Fall2012"));
		assertEquals("Winter2012", qtMain.getQuarterList().get(0).getName());
	}

}
