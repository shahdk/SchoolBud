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
		Category cat = new Category("HW", 10, 10);
		assertNotNull(cat);
	}

	// initialization with negative weights, empty weights, and empty names
	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void testCategoryInitializeWithNegativeWeight() {
		Category cat = new Category("HW", -10);	}

	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void testCategoryInitializeWithItemAndNegativeWeight() {
		Category cat = new Category("HW", 10, -10);	}

	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void testCategoryInitializeWithMaxPLusWeight() {
		Category cat = new Category("HW", 101);	}

	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void testCategoryInitializeWithItemAndMaxPLusWeight() {
		Category cat = new Category("HW", 10, 101);	}

	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void testCategoryInitializeWithEmptyName() {
		Category cat = new Category("", 10);	}

	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void testCategoryInitializeWithItemAndEmptyName() {
		Category cat = new Category("", 10, 10);	}

	// test code for get methods
	@Test
	public void testGetItemsOne() {
		Category cat = new Category("HW", 10, 10);
		assertEquals("HW1", cat.getItemList().get(0).getName());
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
		Category cat = new Category("HW", 10, 10);
		assertEquals("HW", cat.getName());
	}

	@Test
	public void testGetWeightOne() {
		Category cat = new Category("HW", 10);
		assertEquals(10, cat.getWeight(), DELTA);
	}

	@Test
	public void testGetWeightTwo() {
		Category cat = new Category("HW", 10, 10);
		assertEquals(10, cat.getWeight(), DELTA);
	}

	// test code for set methods
	@Test
	public void testSetItemsOne() {
		for (int i = 1; i <= 10; i++) {
			this.hwItems.add(new Item("HW" + i));
		}
		Category cat = new Category("HW", 10);
		cat.setItemList(this.hwItems);
		assertEquals(this.hwItems, cat.getItemList());
	}

	@Test
	public void testSetItemsTwo() {
		for (int i = 1; i <= 10; i++) {
			this.hwItems.add(new Item("HW" + i));
		}
		Category cat = new Category("HW", 10, 10);
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
		Category cat = new Category("HW", 10, 10);
		cat.setName("HomeWork");
		assertEquals("HomeWork", cat.getName());
	}

	@Test
	public void testSetWeightOne() {
		Category cat = new Category("HW", 10);
		cat.setWeight(20);
		assertEquals(20, cat.getWeight(), DELTA);
	}

	@Test
	public void testSetWeightTwo() {
		Category cat = new Category("HW", 10, 10);
		cat.setWeight(20);
		assertEquals(20, cat.getWeight(), DELTA);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetNegativeWeightOne() {
		Category cat = new Category("HW", 10);
		cat.setWeight(-20);	}

	@Test(expected = IllegalArgumentException.class)
	public void testSeNegativetWeightTwo() {
		Category cat = new Category("HW", 10, 10);
		cat.setWeight(-20);	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetMaxPlusWeightOne() {
		Category cat = new Category("HW", 10);
		cat.setWeight(101); }

	@Test(expected = IllegalArgumentException.class)
	public void testSetMaxPlusWeightTwo() {
		Category cat = new Category("HW", 10, 10);
		cat.setWeight(101);	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetEmptyNameOne() {
		Category cat = new Category("HW", 10);
		cat.setName("");	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetEmptyNameTwo() {
		Category cat = new Category("HW", 10, 10);
		cat.setName("");	}

	// test code for add items
	@Test
	public void testAddItemOne() {
		Category cat = new Category("HW", 10);
		cat.addItem(new Item("HW1"));
		assertEquals("HW1", cat.getItemList().get(0).getName());
	}

	@Test
	public void testAddItemTwo() {
		Category cat = new Category("HW", 10, 10);
		cat.addItem(new Item("HW11"));
		assertEquals("HW11", cat.getItemList().get(10).getName());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddItemSameName() {
		Category cat = new Category("HW", 10, 10);
		cat.addItem(new Item("HW10"));	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddItemSameNameTwo() {
		Category cat = new Category("HW", 10);
		cat.addItem(new Item("HW1"));
		cat.addItem(new Item("HW1")); }

	//test cases for removing items
	@Test
	public void testRemoveItemOne() {
		Category cat = new Category("HW", 10);
		cat.addItem(new Item("HW1"));
		assertTrue(cat.removeItem("HW1"));
		assertEquals(0, cat.getItemList().size());
	}

	@Test
	public void testRemoveItemTwo() {
		Category cat = new Category("HW", 10, 10);
		cat.addItem(new Item("HW11"));
		assertTrue(cat.removeItem("HW1"));
		assertEquals(10, cat.getItemList().size());
	}
	
	@Test
	public void testRemoveItemThree() {
		Category cat = new Category("HW", 10);
		assertFalse(cat.removeItem("HW1"));
	}

	@Test
	public void testRemoveItemFour() {
		Category cat = new Category("HW", 10, 10);
		assertFalse(cat.removeItem("HW11"));
	}
	
	@Test
	public void testRemoveItemFive() {
		Category cat = new Category("HW", 10);
		cat.addItem(new Item("HW1"));
		cat.addItem(new Item("HW2"));
		cat.removeItem("HW1");
		assertEquals("HW2", cat.getItemList().get(0).getName());
	}

	@Test
	public void testRemoveItemSix() {
		Category cat = new Category("HW", 10, 10);
		cat.removeItem("HW1");
		assertEquals("HW7", cat.getItemList().get(5).getName());
	}
	
	// test code for calculating number of items in a category
	@Test
	public void testNUmOfItemsOne() {
		Category cat = new Category("HW", 10);
		assertEquals(0, cat.getNumOfItems());
	}

	@Test
	public void testNumOfItemsTwo() {
		Category cat = new Category("HW", 10, 10);
		assertEquals(10, cat.getNumOfItems());
	}

	@Test
	public void testNumOfItemsThree() {
		this.hwItems.clear();
		for (int i = 1; i <= 10; i++) {
			this.hwItems.add(new Item("HW" + i));
		}
		Category cat = new Category("HW", 10);
		cat.setItemList(this.hwItems);
		assertEquals(10, cat.getNumOfItems());
	}

	@Test
	public void testNumOfItemsFour() {
		Category cat = new Category("HW", 10, 10);
		cat.setItemList(new ArrayList<Item>());
		assertEquals(0, cat.getNumOfItems());
	}

	@Test
	public void testNumItemsWithAddItemOne() {
		Category cat = new Category("HW", 10);
		cat.addItem(new Item("HW1"));
		assertEquals(1, cat.getNumOfItems());
	}

	@Test
	public void testNumItemsWithAddItemTwo() {
		Category cat = new Category("HW", 10, 10);
		cat.addItem(new Item("HW11"));
		assertEquals(11, cat.getNumOfItems());
	}	

	// test cases for getting the total earned grades.
	/**
	 * For testing purposes only we consider min to be 0
	 * and max to be 100.
	 */

	@Test
	public void testTotalEarnedGradesMin() {
		Category cat = new Category("HW", 10, 10);
		for (int i = 0; i < 10; i++) {
			cat.getItemList().get(i).setEarnedPoints("0.0");
			cat.getItemList().get(i).setTotalPoints("10");
		}
		assertEquals(0.0, cat.getTotalEarnedPoints(), DELTA);
	}

	@Test
	public void testTotalEarnedGradesMinMinus() {
		double sumGrade = 0;
		Category cat = new Category("HW", 10, 10);
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * -10;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("10");
			sumGrade += tempGrade;
		}
		assertEquals(sumGrade, cat.getTotalEarnedPoints(), DELTA);
	}

	@Test
	public void testTotalEarnedGradesMinPlus() {
		double sumGrade = 0;
		Category cat = new Category("HW", 10, 10);
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 10;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("10");
			sumGrade += tempGrade;
		}
		assertEquals(sumGrade, cat.getTotalEarnedPoints(), DELTA);
	}
	
	@Test
	public void testTotalEarnedGradesNominal() {
		double sumGrade = 0;
		Category cat = new Category("HW", 10, 10);
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 50;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("10");
			sumGrade += tempGrade;
		}
		assertEquals(sumGrade, cat.getTotalEarnedPoints(), DELTA);
	}
	
	@Test
	public void testTotalEarnedGradesMaxMinus() {
		double sumGrade = 0;
		Category cat = new Category("HW", 10, 10);
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 90;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("10");
			sumGrade += tempGrade;
		}
		assertEquals(sumGrade, cat.getTotalEarnedPoints(), DELTA);
	}
	
	@Test
	public void testTotalEarnedGradesMax() {
		double sumGrade = 0;
		Category cat = new Category("HW", 10, 10);
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 100;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("10");
			sumGrade += tempGrade;
		}
		assertEquals(sumGrade, cat.getTotalEarnedPoints(), DELTA);
	}
	
	@Test
	public void testTotalEarnedGradesMaxPlus() {
		double sumGrade = 0;
		Category cat = new Category("HW", 10, 10);
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 190;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("10");
			sumGrade += tempGrade;
		}
		assertEquals(sumGrade, cat.getTotalEarnedPoints(), DELTA);
	}
	
	// test cases for getting the total possible grades.
	@Test(expected = IllegalArgumentException.class)
	public void testTotalPossibleGradesMinMinus() {
		Category cat = new Category("HW", 10, 10);
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * -10;
			cat.getItemList().get(i).setTotalPoints(tempGrade+""); } }
	
	@Test(expected = IllegalArgumentException.class)
	public void testTotalPossibleGradesMin() {
		Category cat = new Category("HW", 10, 10);
		for (int i = 0; i < 10; i++) {
			cat.getItemList().get(i).setTotalPoints("0.0");	}	}
	
	@Test
	public void testTotalPossibleGradesMinPlus() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 10;
			cat.getItemList().get(i).setTotalPoints(tempGrade+"");
			sumGrade += tempGrade;
		}
		assertEquals(sumGrade, cat.getTotalPossiblePoints(), DELTA);
	}
	
	@Test
	public void testTotalPossibleGradesNominal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 50;
			cat.getItemList().get(i).setTotalPoints(tempGrade+"");
			sumGrade += tempGrade;
		}
		assertEquals(sumGrade, cat.getTotalPossiblePoints(), DELTA);
	}
	
	@Test
	public void testTotalPossibleGradesMaxMinus() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 90;
			cat.getItemList().get(i).setTotalPoints(tempGrade+"");
			sumGrade += tempGrade;
		}
		assertEquals(sumGrade, cat.getTotalPossiblePoints(), DELTA);
	}
	
	@Test
	public void testTotalPossibleGradesMax() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 100;
			cat.getItemList().get(i).setTotalPoints(tempGrade+"");
			sumGrade += tempGrade;
		}
		assertEquals(sumGrade, cat.getTotalPossiblePoints(), DELTA);
	}
	
	@Test
	public void testTotalPossibleGradesMaxPlus() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 110;
			cat.getItemList().get(i).setTotalPoints(tempGrade+"");
			sumGrade += tempGrade;
		}
		assertEquals(sumGrade, cat.getTotalPossiblePoints(), DELTA);
	}

	// test cases for getting the total possible grades.
	@Test(expected = IllegalArgumentException.class)
	public void testTotalGradesWithMinMinusEarnedMinMinusTotal() {
		Category cat = new Category("HW", 10, 10);
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * -10;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("-10");	} }

	@Test(expected = IllegalArgumentException.class)
	public void testTotalGradesWithMinMinusEarnedMinTotal() {
		Category cat = new Category("HW", 10, 10);
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * -10;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("0");}	}

	@Test
	public void testTotalGradesWithMinMinusEarnedMinPlusTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * -10;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("10");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/100)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test
	public void testTotalGradesWithMinMinusEarnedNominalTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * -10;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("50");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/500)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test
	public void testTotalGradesWithMinMinusEarnedMaxMinusTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * -10;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("90");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/900)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test
	public void testTotalGradesWithMinMinusEarnedMaxTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * -10;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("100");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/1000)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test
	public void testTotalGradesWithMinMinusEarnedMaxPlusTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * -10;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("110");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/1100)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTotalGradesWithMinEarnedMinMinusTotal() {
		Category cat = new Category("HW", 10, 10);
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 0;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("-10");	} }

	@Test(expected = IllegalArgumentException.class)
	public void testTotalGradesWithMinEarnedMinTotal() {
		Category cat = new Category("HW", 10, 10);
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 0;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("0");}	}

	@Test
	public void testTotalGradesWithMinEarnedMinPlusTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 0;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("10");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/100)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test
	public void testTotalGradesWithMinEarnedNominalTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 0;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("50");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/500)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test
	public void testTotalGradesWithMinEarnedMaxMinusTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 0;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("90");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/900)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test
	public void testTotalGradesWithMinEarnedMaxTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 0;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("100");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/1000)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test
	public void testTotalGradesWithMinEarnedMaxPlusTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 0;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("110");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/1100)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTotalGradesWithMinPlusEarnedMinMinusTotal() {
		Category cat = new Category("HW", 10, 10);
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 10;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("-10");	} }

	@Test(expected = IllegalArgumentException.class)
	public void testTotalGradesWithMinPlusEarnedMinTotal() {
		Category cat = new Category("HW", 10, 10);
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 10;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("0");}	}

	@Test
	public void testTotalGradesWithMinPlusEarnedMinPlusTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 10;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("10");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/100)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test
	public void testTotalGradesWithMinPlusEarnedNominalTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 10;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("50");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/500)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test
	public void testTotalGradesWithMinPlusEarnedMaxMinusTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 10;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("90");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/900)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test
	public void testTotalGradesWithMinPlusEarnedMaxTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 10;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("100");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/1000)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test
	public void testTotalGradesWithMinPlusEarnedMaxPlusTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 10;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("110");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/1100)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTotalGradesWithNominalEarnedMinMinusTotal() {
		Category cat = new Category("HW", 10, 10);
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 50;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("-10");	} }

	@Test(expected = IllegalArgumentException.class)
	public void testTotalGradesWithNominalEarnedMinTotal() {
		Category cat = new Category("HW", 10, 10);
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 50;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("0");}	}

	@Test
	public void testTotalGradesWithNominalEarnedMinPlusTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 50;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("10");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/100)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test
	public void testTotalGradesWithNominalEarnedNominalTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 50;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("50");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/500)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test
	public void testTotalGradesWithNominalEarnedMaxMinusTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 50;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("90");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/900)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test
	public void testTotalGradesWithNominalEarnedMaxTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 50;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("100");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/1000)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test
	public void testTotalGradesWithNominalEarnedMaxPlusTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 50;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("110");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/1100)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTotalGradesWithMaxMinusEarnedMinMinusTotal() {
		Category cat = new Category("HW", 10, 10);
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 90;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("-10");	} }

	@Test(expected = IllegalArgumentException.class)
	public void testTotalGradesWithMaxMinusEarnedMinTotal() {
		Category cat = new Category("HW", 10, 10);
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 90;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("0");}	}

	@Test
	public void testTotalGradesWithMaxMinusEarnedMinPlusTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 90;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("10");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/100)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test
	public void testTotalGradesWithMaxMinusEarnedNominalTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 90;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("50");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/500)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test
	public void testTotalGradesWithMaxMinusEarnedMaxMinusTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 90;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("90");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/900)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test
	public void testTotalGradesWithMaxMinusEarnedMaxTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 90;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("100");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/1000)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test
	public void testTotalGradesWithMaxMinusEarnedMaxPlusTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 90;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("110");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/1100)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTotalGradesWithMaxEarnedMinMinusTotal() {
		Category cat = new Category("HW", 10, 10);
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 100;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("-10");	} }

	@Test(expected = IllegalArgumentException.class)
	public void testTotalGradesWithMaxEarnedMinTotal() {
		Category cat = new Category("HW", 10, 10);
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 100;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("0");}	}

	@Test
	public void testTotalGradesWithMaxEarnedMinPlusTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 100;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("10");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/100)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test
	public void testTotalGradesWithMaxEarnedNominalTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 100;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("50");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/500)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test
	public void testTotalGradesWithMaxEarnedMaxMinusTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 100;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("90");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/900)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test
	public void testTotalGradesWithMaxEarnedMaxTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 100;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("100");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/1000)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test
	public void testTotalGradesWithMaxEarnedMaxPlusTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 100;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("110");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/1100)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTotalGradesWithMaxPlusEarnedMinMinusTotal() {
		Category cat = new Category("HW", 10, 10);
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 110;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("-10");	} }

	@Test(expected = IllegalArgumentException.class)
	public void testTotalGradesWithMaxPlusEarnedMinTotal() {
		Category cat = new Category("HW", 10, 10);
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 110;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("0");}	}

	@Test
	public void testTotalGradesWithMaxPlusEarnedMinPlusTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 110;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("10");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/100)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test
	public void testTotalGradesWithMaxPlusEarnedNominalTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 110;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("50");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/500)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test
	public void testTotalGradesWithMaxPlusEarnedMaxMinusTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 110;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("90");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/900)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test
	public void testTotalGradesWithMaxPlusEarnedMaxTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 110;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("100");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/1000)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}
	
	@Test
	public void testTotalGradesWithMaxPlusEarnedMaxPlusTotal() {
		Category cat = new Category("HW", 10, 10);
		double sumGrade = 0;
		for (int i = 0; i < 10; i++) {
			double tempGrade = Math.random() * 110;
			cat.getItemList().get(i).setEarnedPoints(tempGrade+"");
			cat.getItemList().get(i).setTotalPoints("110");
			sumGrade += tempGrade;
		}
		double answer = Math.round(((sumGrade/1100)*100)*100);
		assertEquals(answer/100, cat.getTotalPoints(), DELTA);
	}

}
