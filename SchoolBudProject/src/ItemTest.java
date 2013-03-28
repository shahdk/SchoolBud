import static org.junit.Assert.*;

import org.junit.Test;

public class ItemTest {

	@Test
	public void testJUnit() {
		assertTrue("JUnit works!", true);
	}
	
	@Test
	public void testItemInitializeWithFourParameters(){
		Item item = new Item("HW1", "8.5", "10", 10);
		assertNotNull(item);
	}
	
	@Test
	public void testItemInitializeWithThreeParameters(){
		Item item = new Item("HW1", "10", 10);
		assertNotNull(item);
	}
	
	@Test
	public void testItemInitializeWithTwoParameters(){
		Item item = new Item("HW1", 10);
		assertNotNull(item);
	}
	
	@Test
	public void testGetEarnedPoints(){
		Item item = new Item("HW1", "8.5", "10", 10);
		assertEquals("8.5", item.getEarnedPoints());
	}
	
	@Test
	public void testGetTotalPoints(){
		Item item = new Item("HW1", "8.5", "10", 10);
		assertEquals("10", item.getTotalPoints());
	}
	
	@Test
	public void testGetWeight(){
		Item item = new Item("HW1", "8.5", "10", 10);
		assertEquals(10, item.getWeight());
	}
	
	@Test
	public void testGetName(){
		Item item = new Item("HW1", "8.5", "10", 10);
		assertEquals("HW1", item.getName());
	}
	
	@Test
	public void testSetEarnedPoints(){
		Item item = new Item("HW1", "8.5", "10", 10);
		item.setEarnedPoints("10");
		assertEquals("10", item.getEarnedPoints());
	}
	
	@Test
	public void testSetTotalPoints(){
		Item item = new Item("HW1", "8.5", "10", 10);
		item.setTotalPoints("15");
		assertEquals("15", item.getTotalPoints());
	}
	
	@Test
	public void testSetWeight(){
		Item item = new Item("HW1", "8.5", "10", 10);
		item.setWeight(20);
		assertEquals(20, item.getWeight());
	}
	
	@Test
	public void testSetName(){
		Item item = new Item("HW1", "8.5", "10", 10);
		item.setName("HW2");
		assertEquals("HW2", item.getName());
	}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testItemInitializationWithNegativeWeightOne() {
		Item item = new Item("HW1", "8.5", "10", -10);	}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testItemInitializationWithNegativeWeightTwo() {
		Item item = new Item("HW1", "10", -10);	}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testItemInitializationWithNegativeWeightThree() {
		Item item = new Item("HW1", -10);	}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testItemInitializationWithMaxPlusWeightOne() {
		Item item = new Item("HW1", "8.5", "10", 101);	}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testItemInitializationWithMaxPlusWeightTwo() {
		Item item = new Item("HW1", "10", 102);	}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testItemInitializationWithMaxPlusWeightThree() {
		Item item = new Item("HW1", 104);	}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testItemInitializationWithNegativeTotalPointsOne() {
		Item item = new Item("HW1", "8.5", "-10", 10);	}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testItemInitializationWithNegativeTotalPointsTwo() {
		Item item = new Item("HW1", "-10", 10);	}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testItemInitializationWithZeroTotalPointsOne() {
		Item item = new Item("HW1", "8.5", "0", 10);}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testItemInitializationWithZeroTotalPoints() {
		Item item = new Item("HW1", "0", 10);}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testItemInitializationWithEmptyNameOne() {
		Item item = new Item("", "8.5", "10", 10);}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testItemInitializationWithEmptyNameTwo() {
		Item item = new Item("", "10", 10);}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testItemInitializationWithEmptyNameThree() {
		Item item = new Item("", 10);}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testItemInitializationWithNonNumericTotalPointsOne() {
		Item item = new Item("HW1", "8.5", "lol", 10);}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testItemInitializationWithNonNumericTotalPointsTwo() {
		Item item = new Item("HW1", "lol", 10);}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetItemWithNegativeWeight() {
		Item item = new Item("HW1", "8.5", "10", 10);
		item.setWeight(-10);	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetItemWithMaxPlusWeight() {
		Item item = new Item("HW1", "8.5", "10", 10);
		item.setWeight(101);	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetItemWithNegativeTotalPoints() {
		Item item = new Item("HW1", "8.5", "10", 10);
		item.setTotalPoints("-2");}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetItemWithZeroTotalPoints() {
		Item item = new Item("HW1", "8.5", "10", 10);
		item.setTotalPoints("0");}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetItemWithEmptyNameThree() {
		Item item = new Item("HW1", "8.5", "10", 10);
		item.setName("");}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetItemWithNonNumericTotalPoints() {
		Item item = new Item("HW1", "8.5", "10", 10);
		item.setTotalPoints("lol");}
}
