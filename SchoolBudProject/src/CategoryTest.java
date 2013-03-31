import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CategoryTest {

	private ArrayList<Item> hwItems;
	private static final double DELTA = 1e-15;

	@Before
	public void setUp() {
		this.hwItems = new ArrayList<Item>();
	}

	@After
	public void tearDown() {
		this.hwItems = null;
	}

	@Test
	public void testJUnit() {
		assertTrue("JUnit works!", true);
	}

	// initialization test cases
	@Test
	public void testCategoryInitialize() {
		Category cat = new Category("HW", 10);
		assertNotNull(cat);
	}

	@Test
	public void testCategoryInitializeWithItem() {
		for (int i = 1; i <= 10; i++) {
			this.hwItems.add(new Item("HW" + i, 1));
		}
		Category cat = new Category("HW", this.hwItems, 10);
		assertNotNull(cat);
	}

	// initialization with negative weights, empty weights, and empty names
	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void testCategoryInitializeWithNegativeWeight() {
		Category cat = new Category("HW", -10);
	}

	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void testCategoryInitializeWithItemAndNegativeWeight() {
		for (int i = 1; i <= 10; i++) {
			this.hwItems.add(new Item("HW" + i, 1));
		}
		Category cat = new Category("HW", this.hwItems, -10);
	}

	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void testCategoryInitializeWithMaxPLusWeight() {
		Category cat = new Category("HW", 101);
	}

	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void testCategoryInitializeWithItemAndMaxPLusWeight() {
		for (int i = 1; i <= 10; i++) {
			this.hwItems.add(new Item("HW" + i, 1));
		}
		Category cat = new Category("HW", this.hwItems, 101);
	}

	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void testCategoryInitializeWithEmptyName() {
		Category cat = new Category("", 10);
	}

	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void testCategoryInitializeWithItemAndEmptyName() {
		for (int i = 1; i <= 10; i++) {
			this.hwItems.add(new Item("HW" + i, 1));
		}
		Category cat = new Category("", this.hwItems, 10);
	}

	// test code for get methods
	@Test
	public void testGetItemsOne() {
		for (int i = 1; i <= 10; i++) {
			this.hwItems.add(new Item("HW" + i, 1));
		}
		Category cat = new Category("HW", this.hwItems, 10);
		assertEquals(this.hwItems, cat.getItemList());
	}

	@Test
	public void testGetItemsTwo() {
		Category cat = new Category("HW", 10);
		assertEquals(new ArrayList<Item>(), cat.getItemList());
	}

	@Test
	public void testGetNameOne() {
		Category cat = new Category("HW", 10);
		assertEquals("HW", cat.getName());
	}

	@Test
	public void testGetNameTwo() {
		for (int i = 1; i <= 10; i++) {
			this.hwItems.add(new Item("HW" + i, 1));
		}
		Category cat = new Category("HW", this.hwItems, 10);
		assertEquals("HW", cat.getName());
	}

	@Test
	public void testGetWeightOne() {
		Category cat = new Category("HW", 10);
		assertEquals(10, cat.getWeight());
	}

	@Test
	public void testGetWeightTwo() {
		for (int i = 1; i <= 10; i++) {
			this.hwItems.add(new Item("HW" + i, 1));
		}
		Category cat = new Category("HW", this.hwItems, 10);
		assertEquals(10, cat.getWeight());
	}

	// test code for set methods
	@Test
	public void testSetItemsOne() {
		for (int i = 1; i <= 10; i++) {
			this.hwItems.add(new Item("HW" + i, 1));
		}
		Category cat = new Category("HW", 10);
		cat.setItemList(this.hwItems);
		assertEquals(this.hwItems, cat.getItemList());
	}

	@Test
	public void testSetItemsTwo() {
		for (int i = 1; i <= 10; i++) {
			this.hwItems.add(new Item("HW" + i, 1));
		}
		Category cat = new Category("HW", this.hwItems, 10);
		cat.setItemList(new ArrayList<Item>());
		assertEquals(new ArrayList<Item>(), cat.getItemList());
	}

	@Test
	public void testSetNameOne() {
		Category cat = new Category("HW", 10);
		cat.setName("HomeWork");
		assertEquals("HomeWork", cat.getName());
	}

	@Test
	public void testSetNameTwo() {
		for (int i = 1; i <= 10; i++) {
			this.hwItems.add(new Item("HW" + i, 1));
		}
		Category cat = new Category("HW", this.hwItems, 10);
		cat.setName("HomeWork");
		assertEquals("HomeWork", cat.getName());
	}

	@Test
	public void testSetWeightOne() {
		Category cat = new Category("HW", 10);
		cat.setWeight(20);
		assertEquals(20, cat.getWeight());
	}

	@Test
	public void testSetWeightTwo() {
		for (int i = 1; i <= 10; i++) {
			this.hwItems.add(new Item("HW" + i, 1));
		}
		Category cat = new Category("HW", this.hwItems, 10);
		cat.setWeight(20);
		assertEquals(20, cat.getWeight());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetNegativeWeightOne() {
		Category cat = new Category("HW", 10);
		cat.setWeight(-20);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSeNegativetWeightTwo() {
		for (int i = 1; i <= 10; i++) {
			this.hwItems.add(new Item("HW" + i, 1));
		}
		Category cat = new Category("HW", this.hwItems, 10);
		cat.setWeight(-20);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetMaxPlusWeightOne() {
		Category cat = new Category("HW", 10);
		cat.setWeight(101);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetMaxPlusWeightTwo() {
		for (int i = 1; i <= 10; i++) {
			this.hwItems.add(new Item("HW" + i, 1));
		}
		Category cat = new Category("HW", this.hwItems, 10);
		cat.setWeight(101);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetEmptyNameOne() {
		Category cat = new Category("HW", 10);
		cat.setName("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetEmptyNameTwo() {
		for (int i = 1; i <= 10; i++) {
			this.hwItems.add(new Item("HW" + i, 1));
		}
		Category cat = new Category("HW", this.hwItems, 10);
		cat.setName("");
	}

	// test code for add items
	@Test
	public void testAddItemOne() {
		Category cat = new Category("HW", 10);
		cat.addItem(new Item("HW1", 1));
		assertEquals("HW1", cat.getItemList().get(0).getName());
		assertEquals(1, cat.getItemList().get(0).getWeight());
	}

	@Test
	public void testAddItemTwo() {
		for (int i = 1; i <= 10; i++) {
			this.hwItems.add(new Item("HW" + i, 1));
		}
		Category cat = new Category("HW", this.hwItems, 10);
		this.hwItems.add(new Item("HW11", 1));
		cat.addItem(new Item("HW11", 1));
		assertEquals("HW11", cat.getItemList().get(10).getName());
		assertEquals(1, cat.getItemList().get(10).getWeight());
	}

	// test code for calculating number of items in a category
	@Test
	public void testNUmOfItemsOne() {
		Category cat = new Category("HW", 10);
		assertEquals(0, cat.getNumOfItems());
	}

	@Test
	public void testNumOfItemsTwo() {
		for (int i = 1; i <= 10; i++) {
			this.hwItems.add(new Item("HW" + i, 1));
		}
		Category cat = new Category("HW", this.hwItems, 10);
		assertEquals(10, cat.getNumOfItems());
	}

	@Test
	public void testNumOfItemsThree() {
		this.hwItems.clear();
		for (int i = 1; i <= 10; i++) {
			this.hwItems.add(new Item("HW" + i, 1));
		}
		Category cat = new Category("HW", 10);
		cat.setItemList(this.hwItems);
		assertEquals(10, cat.getNumOfItems());
	}

	@Test
	public void testNumOfItemsFour() {
		this.hwItems.clear();
		for (int i = 1; i <= 10; i++) {
			this.hwItems.add(new Item("HW" + i, 1));
		}
		Category cat = new Category("HW", this.hwItems, 10);
		cat.setItemList(new ArrayList<Item>());
		assertEquals(0, cat.getNumOfItems());
	}

	@Test
	public void testNumItemsWithAddItemOne() {
		Category cat = new Category("HW", 10);
		cat.addItem(new Item("HW1", 1));
		assertEquals(1, cat.getNumOfItems());
	}

	@Test
	public void testNumItemsWithAddItemTwo() {
		ArrayList<Item> items = new ArrayList<Item>();
		for (int i = 1; i <= 10; i++) {
			items.add(new Item("HW" + i, 1));
		}
		Category cat = new Category("HW", items, 10);
		items.add(new Item("HW11", 1));
		cat.addItem(new Item("HW11", 1));
		assertEquals(11, cat.getNumOfItems());
	}

	// test cases for getting the total earned grades.
	@Test
	public void testTotalEarnedGrades() {
		double sumGrade = 0;
		for (int i = 1; i <= 10; i++) {
			double tempGrade = Math.random() * 10;
			this.hwItems.add(new Item("HW" + i, tempGrade + "", "10", 1));
			sumGrade += tempGrade;
		}
		Category cat = new Category("HW", this.hwItems, 10);
		assertEquals(sumGrade, cat.getTotalEarnedPoints(), DELTA);
	}

	@Test
	public void testZeroTotalEarnedGrades() {
		for (int i = 1; i <= 10; i++) {
			this.hwItems.add(new Item("HW" + i, "0", "10", 1));
		}
		Category cat = new Category("HW", this.hwItems, 10);
		assertEquals(0.0, cat.getTotalEarnedPoints(), DELTA);
	}

	@Test
	public void testNegativeTotalEarnedGrades() {
		double sumGrade = 0;
		for (int i = 1; i <= 10; i++) {
			double tempGrade = Math.random() * -10;
			this.hwItems.add(new Item("HW" + i, tempGrade + "", "10", 1));
			sumGrade += tempGrade;
		}
		Category cat = new Category("HW", this.hwItems, 10);
		assertEquals(sumGrade, cat.getTotalEarnedPoints(), DELTA);
	}

	// test cases for getting the total possible grades.
	@Test
	public void testTotalPossibleGrades() {
		double sumGrade = 0;
		for (int i = 1; i <= 10; i++) {
			double tempGrade = Math.random() * 10;
			this.hwItems.add(new Item("HW" + i, tempGrade + "", 1));
			sumGrade += tempGrade;
		}
		Category cat = new Category("HW", this.hwItems, 10);
		assertEquals(sumGrade, cat.getTotalPossiblePoints(), DELTA);
	}

	// test cases for getting the total possible grades.
	@Test
	public void testTotalGradesOne() {
		double sumGrade = 0;
		for (int i = 1; i <= 10; i++) {
			double tempGrade = Math.random() * 10;
			this.hwItems.add(new Item("HW" + i, tempGrade + "", "10", 1));
			sumGrade += tempGrade;
		}
		
		Category cat = new Category("HW", this.hwItems, 10);
		double answer = Math.round((sumGrade*100))/100.00;
		assertEquals(answer, cat.getTotalPoints(), DELTA);
	}

	@Test
	public void testTotalGradesTwo() {
		double sumGrade = 0;
		for (int i = 1; i <= 10; i++) {
			double tempGrade = Math.random() * -10;
			this.hwItems.add(new Item("HW" + i, tempGrade + "", "10", 1));
			sumGrade += tempGrade;

		}
		Category cat = new Category("HW", this.hwItems, 10);
		double answer = Math.round((sumGrade*100))/100.00;
		assertEquals(answer, cat.getTotalPoints(), DELTA);
	}

	@Test
	public void testTotalGradesThree() {
		for (int i = 1; i <= 10; i++) {
			this.hwItems.add(new Item("HW" + i, "0.0", "10", 1));
		}
		Category cat = new Category("HW", this.hwItems, 10);
		assertEquals(0.0, cat.getTotalPoints(), DELTA);
	}

}
