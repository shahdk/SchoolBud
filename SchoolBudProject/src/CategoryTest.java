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
	
	//initialization test cases
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
	
	//test code for get methods
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
	
	//test code for set methods
	@Test
	public void testSetItemsOne(){
		for(int i=1; i<=10; i++){
			this.hwItems.add(new Item("HW"+i, "0.01"));
		}
		Category cat = new Category("HW", "0.10");
		cat.setItemList(this.hwItems);
		assertEquals(this.hwItems, cat.getItemList());
	}
	
	@Test
	public void testSetItemsTwo(){
		for(int i=1; i<=10; i++){
			this.hwItems.add(new Item("HW"+i, "0.01"));
		}
		Category cat = new Category("HW", this.hwItems, "0.10");
		cat.setItemList(new ArrayList<Item>());
		assertEquals(new ArrayList<Item>(), cat.getItemList());
	}
	
	@Test
	public void testSetNameOne(){
		Category cat = new Category("HW", "0.10");
		cat.setName("HomeWork");
		assertEquals("HomeWork", cat.getName());
	}
	
	@Test
	public void testSetNameTwo(){
		for(int i=1; i<=10; i++){
			this.hwItems.add(new Item("HW"+i, "0.01"));
		}
		Category cat = new Category("HW", this.hwItems, "0.10");
		cat.setName("HomeWork");
		assertEquals("HomeWork", cat.getName());
	}
	
	@Test
	public void testSetWeightOne(){
		Category cat = new Category("HW", "0.10");
		cat.setWeight("0.20");
		assertEquals("0.20", cat.getWeight());
	}
	
	@Test
	public void testSetWeightTwo(){
		for(int i=1; i<=10; i++){
			this.hwItems.add(new Item("HW"+i, "0.01"));
		}
		Category cat = new Category("HW", this.hwItems, "0.10");
		cat.setWeight("0.20");
		assertEquals("0.20", cat.getWeight());
	}
	
	//test code for add items
	public void testAddItemOne(){
		Category cat = new Category("HW", "0.10");
		this.hwItems.add(new Item("HW1", "0.01"));
		cat.addItem(new Item("HW1", "0.01"));
		assertEquals(this.hwItems, cat.getItemList());
	}
	
	@Test
	public void testAddItemTwo(){
		for(int i=1; i<=10; i++){
			this.hwItems.add(new Item("HW"+i, "0.01"));
		}
		Category cat = new Category("HW", this.hwItems, "0.10");
		this.hwItems.add(new Item("HW11", "0.01"));
		cat.addItem(new Item("HW11", "0.01"));
		assertEquals("0.20", cat.getItemList());
	}
	
	//test code for calculating number of items in a category
	@Test
	public void testNUmOfItemsOne(){
		Category cat = new Category("HW", "0.10");
		assertEquals(0, cat.getNumOfItems());
	}
	
	@Test
	public void testNumOfItemsTwo(){
		for(int i=1; i<=10; i++){
			this.hwItems.add(new Item("HW"+i, "0.01"));
		}
		Category cat = new Category("HW", this.hwItems, "0.10");
		assertEquals(10, cat.getNumOfItems());
	}
	
	@Test
	public void testNumOfItemsThree(){
		for(int i=1; i<=10; i++){
			this.hwItems.add(new Item("HW"+i, "0.01"));
		}
		Category cat = new Category("HW", "0.10");
		cat.setItemList(this.hwItems);
		assertEquals(10, cat.getNumOfItems());
	}
	
	@Test
	public void testNumOfItemsFour(){
		for(int i=1; i<=10; i++){
			this.hwItems.add(new Item("HW"+i, "0.01"));
		}
		Category cat = new Category("HW", this.hwItems, "0.10");
		cat.setItemList(new ArrayList<Item>());
		assertEquals(0, cat.getNumOfItems());
	}
	
	

}
