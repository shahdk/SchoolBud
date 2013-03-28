import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CategoryTest {

	private ArrayList<Item> hwItems;
	
	@Before
	public void setUp(){
		this.hwItems = new ArrayList<Item>();	
	}
	
	@After
	public void tearDown(){
		this.hwItems = null;
	}
	
	@Test
	public void testJUnit() {
		assertTrue("JUnit works!", true);
	}
	
	@Test
	public void testCategoryInitialize(){
		Category cat = new Category("HW", "0.10");
		assertNotNull(cat);
	}
	
	@Test
	public void testCategoryInitializeWithItem(){
		for(int i=1; i<=10; i++){
			this.hwItems.add(new Item("HW"+i, "0.01"));
		}
		Category cat = new Category("HW", this.hwItems, "0.10");
		assertNotNull(cat);
	}
	
	@Test
	public void testGetItemsOne(){
		for(int i=1; i<=10; i++){
			this.hwItems.add(new Item("HW"+i, "0.01"));
		}
		Category cat = new Category("HW", this.hwItems, "0.10");
		assertEquals(this.hwItems, cat.getItemList());
	}
	
	@Test
	public void testGetItemsTwo(){
		Category cat = new Category("HW", "0.10");
		assertEquals(new ArrayList<Item>(), cat.getItemList());
	}
	
	@Test
	public void testGetNameOne(){
		Category cat = new Category("HW", "0.10");
		assertEquals("HW", cat.getName());
	}
	
	@Test
	public void testGetNameTwo(){
		for(int i=1; i<=10; i++){
			this.hwItems.add(new Item("HW"+i, "0.01"));
		}
		Category cat = new Category("HW", this.hwItems, "0.10");
		assertEquals("HW", cat.getName());
	}
	
	@Test
	public void testGetWeightOne(){
		Category cat = new Category("HW", "0.10");
		assertEquals("0.10", cat.getWeight());
	}
	
	@Test
	public void testGetWeightTwo(){
		for(int i=1; i<=10; i++){
			this.hwItems.add(new Item("HW"+i, "0.01"));
		}
		Category cat = new Category("HW", this.hwItems, "0.10");
		assertEquals("0.10", cat.getWeight());
	}

}
