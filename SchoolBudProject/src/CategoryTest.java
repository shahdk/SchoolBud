import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CategoryTest {

	private ArrayList<Item> hwItems;
	private ArrayList<Item> quizItems;
	private ArrayList<Item> examItems;
	private ArrayList<Item> finalItems;
	
	@Before
	public void setUp(){
		this.hwItems = new ArrayList<Item>();
		this.quizItems = new ArrayList<Item>();
		this.examItems = new ArrayList<Item>();
		this.finalItems = new ArrayList<Item>();
	}
	
	@After
	public void tearDown(){
		this.hwItems = null;
		this.quizItems = null;
		this.examItems = null;
		this.finalItems = null;
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

}
