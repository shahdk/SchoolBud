import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class ItemTest {
	
	@Test
	public void testJUnit() {
		assertTrue("JUnit works!", true);
	}
	
	@Test
	public void testItemInitializeWithThreeParameters(){
		Item item = new Item("HW1", "8.5", "10", new Date());
		assertNotNull(item);
	}
	
	@Test
	public void testItemInitializeWithTwoParameters(){
		Item item = new Item("HW1", "10", new Date());
		assertNotNull(item);
	}
	
	@Test
	public void testItemInitializeWithOneParameters(){
		Item item = new Item("HW1", new Date());
		assertNotNull(item);
	}
	
	@Test
	public void testGetEarnedPoints(){
		Item item = new Item("HW1", "8.5", "10", new Date());
		assertEquals("8.5", item.getEarnedPoints());
	}
	
	@Test
	public void testGetTotalPoints(){
		Item item = new Item("HW1", "8.5", "10", new Date());
		assertEquals("10", item.getTotalPoints());
	}
	
	@Test
	public void testGetName(){
		Item item = new Item("HW1", "8.5", "10", new Date());
		assertEquals("HW1", item.getName());
	}
	
	@Test
	public void testSetEarnedPoints(){
		Item item = new Item("HW1", "8.5", "10", new Date());
		item.setEarnedPoints("10");
		assertEquals("10", item.getEarnedPoints());
	}
	
	@Test
	public void testSetTotalPoints(){
		Item item = new Item("HW1", "8.5", "10", new Date());
		item.setTotalPoints("15");
		assertEquals("15", item.getTotalPoints());
	}
	
	@Test
	public void testSetName(){
		Item item = new Item("HW1", "8.5", "10", new Date());
		item.setName("HW2");
		assertEquals("HW2", item.getName());
	}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testItemInitializationWithNegativeTotalPointsOne() {
		Item item = new Item("HW1", "8.5", "-10", new Date());	}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testItemInitializationWithNegativeTotalPointsTwo() {
		Item item = new Item("HW1", "-10", new Date());	}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testItemInitializationWithZeroTotalPointsOne() {
		Item item = new Item("HW1", "8.5", "0", new Date());}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testItemInitializationWithZeroTotalPoints() {
		Item item = new Item("HW1", "0", new Date());}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testItemInitializationWithEmptyNameOne() {
		Item item = new Item("", "8.5", "10", new Date());}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testItemInitializationWithEmptyNameTwo() {
		Item item = new Item("", "10", new Date());}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testItemInitializationWithEmptyNameThree() {
		Item item = new Item("", new Date());}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testItemInitializationWithNonNumericTotalPointsOne() {
		Item item = new Item("HW1", "8.5", "lol", new Date());}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testItemInitializationWithNonNumericTotalPointsTwo() {
		Item item = new Item("HW1", "lol", new Date());}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetItemWithNegativeTotalPoints() {
		Item item = new Item("HW1", "8.5", "10", new Date());
		item.setTotalPoints("-2");}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetItemWithZeroTotalPoints() {
		Item item = new Item("HW1", "8.5", "10", new Date());
		item.setTotalPoints("0");}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetItemWithEmptyNameThree() {
		Item item = new Item("HW1", "8.5", "10", new Date());
		item.setName("");}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetItemWithNonNumericTotalPoints() {
		Item item = new Item("HW1", "8.5", "10", new Date());
		item.setTotalPoints("lol");}
	
	@Test
	public void testSetAndGetDate() throws Exception{
		Date date = new Date();
		SimpleDateFormat dtFormat = new SimpleDateFormat("MM/dd/yyyy");
		Item item = new Item("HW1", date);
		assertEquals(date, item.getCreationDate());
		
		String newDate = "04/25/2013";
		Date newDt = dtFormat.parse(newDate);
		item.setCreationdate(newDt);
		assertEquals(newDt, item.getCreationDate());
	}
}
