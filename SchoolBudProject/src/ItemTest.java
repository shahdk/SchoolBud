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
		assertEquals("8.5", item.getTotalPoints());
	}
	
	@Test
	public void testGetWeight(){
		Item item = new Item("HW1", "8.5", "10", "0.10");
		assertEquals("8.5", item.getWeight());
	}
	
	@Test
	public void testGetName(){
		Item item = new Item("HW1", "8.5", "10", "0.10");
		assertEquals("8.5", item.getName());
	}
	
	private ArrayList<String> list(String... vals){
		ArrayList<String> ret = new ArrayList<String>();
		for(String i: vals){
			ret.add(i);
		}
		return ret;
	}

}
