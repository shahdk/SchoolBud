import static org.junit.Assert.*;

import org.junit.Test;


public class ItemTest {

	@Test
	public void testJUnit() {
		assertTrue("JUnit works!", true);
	}
	
	public void testItemInitializeWithThreeParameters(){
		Item item = new Item("HW1", 8.5, 10, 0.10);
		assertNotNull(item);
	}
	
	public void testItemInitializeWithTwoParameters(){
		Item item = new Item("HW1", 10, 0.10);
		assertNotNull(item);
	}
	
	public void testItemInitializeWithOneParameters(){
		Item item = new Item("HW1", 0.10);
		assertNotNull(item);
	}

}
