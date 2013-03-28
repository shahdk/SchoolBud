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

}
