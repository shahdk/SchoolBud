import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class ItemTest {

	@Test
	public void testJUnit() {
		assertTrue("JUnit works!", true);
	}
	
	@Test
	public void testItemInitializeWithFourParameters(){
		Item item = new Item("HW1", "8.5", "10", "0.10");
		assertNotNull(item);
	}
	
	@Test
	public void testItemInitializeWithThreeParameters(){
		Item item = new Item("HW1", "10", "0.10");
		assertNotNull(item);
	}
	
	@Test
	public void testItemInitializeWithTwoParameters(){
		Item item = new Item("HW1", "0.10");
		assertNotNull(item);
	}
	
	@Test
	public void testGetEarnedPoints(){
		Item item = new Item("HW1", "8.5", "10", "0.10");
		assertEquals("8.5", item.getEarnedPoints());
	}
	
	@Test
	public void testGetTotalPoints(){
		Item item = new Item("HW1", "8.5", "10", "0.10");
		assertEquals("10", item.getTotalPoints());
	}
	
	@Test
	public void testGetWeight(){
		Item item = new Item("HW1", "8.5", "10", "0.10");
		assertEquals("0.10", item.getWeight());
	}
	
	@Test
	public void testGetName(){
		Item item = new Item("HW1", "8.5", "10", "0.10");
		assertEquals("HW1", item.getName());
	}
	
	@Test
	public void testSetEarnedPoints(){
		Item item = new Item("HW1", "8.5", "10", "0.10");
		item.setEarnedPoints("10");
		assertEquals("10", item.getEarnedPoints());
	}
	
	@Test
	public void testSetTotalPoints(){
		Item item = new Item("HW1", "8.5", "10", "0.10");
		item.setTotalPoints("15");
		assertEquals("15", item.getTotalPoints());
	}
	
	@Test
	public void testSetWeight(){
		Item item = new Item("HW1", "8.5", "10", "0.10");
		item.setWeight("0.20");
		assertEquals("0.20", item.getWeight());
	}
	
	@Test
	public void testSetName(){
		Item item = new Item("HW1", "8.5", "10", "0.10");
		item.setName("HW2");
		assertEquals("HW2", item.getName());
	}
	
	private ArrayList<String> list(String... vals){
		ArrayList<String> ret = new ArrayList<String>();
		for(String i: vals){
			ret.add(i);
		}
		return ret;
	}

}
