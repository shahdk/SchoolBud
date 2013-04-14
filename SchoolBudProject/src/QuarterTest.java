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
}
