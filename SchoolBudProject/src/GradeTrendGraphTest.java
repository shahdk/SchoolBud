import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

/**
 * 
 */

/**
 * @author John
 * 
 */
public class GradeTrendGraphTest {

	// Test DataPoint Helper Class
	@Test
	public void testDataPointHelperClass() {

		DataPoint point = new DataPoint(5, 8);

		// test getters
		assertEquals(5, point.getX());
		assertEquals(8, point.getY());

		// test setters
		point.setX(6);
		point.setY(0);

		assertEquals(6, point.getX());
		assertEquals(0, point.getY());

	}

	@Test
	public void testAllUserEnteredVariablesGettersAndSetters() {

		GradeTrendGraph graph = new GradeTrendGraph(null, 1, 5);

		// test getters
		assertNull(graph.getCourse());
		assertEquals(1, graph.getClassDifficulty_1_5());
		assertEquals(5, graph.getFutureWorkRate_neg5_pos5());

		// test setters
		graph.setClassDifficulty_1_5(3);
		graph.setFutureWorkRate_neg5_pos5(-3);
		graph.setCourse(new Course("science"));

		assertNotNull(graph.getCourse());
		assertEquals(3, graph.getClassDifficulty_1_5());
		assertEquals(-3, graph.getFutureWorkRate_neg5_pos5());

	}

	@Test
	public void testInstantiationErrorThrownForInvalidClassDifficulty() {

		boolean thrown = false;

		try {
			new GradeTrendGraph(null, 0, 5);
		} catch (InstantiationError e) {
			thrown = true;
			assertEquals(e.getMessage(),
					"Class Difficulty must be and integer 1 to 5");
		}

		assertTrue(thrown);
	}

	@Test
	public void testInstantiationErrorThrownForInvalidFutureWorkRate() {

		boolean thrown = false;

		try {
			new GradeTrendGraph(null, 3, -6);
		} catch (InstantiationError e) {
			thrown = true;
			assertEquals(e.getMessage(),
					"Future work rate must be and integer -5 to 5");
		}

		assertTrue(thrown);
	}

	@Test
	public void testUpdateAndOrganizeItemListByDate() throws ParseException {
		SimpleDateFormat dtFormat = new SimpleDateFormat("MM/dd/yyyy");

		Course course1 = new Course("math");
		Category cat1 = new Category("tests", 20);
		Category cat2 = new Category("hwk", 10);

		String newDate1 = "07/25/2012";
		Date newDt1 = dtFormat.parse(newDate1);
		Item item1 = new Item("exam1", newDt1);

		String newDate2 = "05/21/2012";
		Date newDt2 = dtFormat.parse(newDate2);
		Item item2 = new Item("exam2", newDt2);

		String newDate3 = "04/29/2012";
		Date newDt3 = dtFormat.parse(newDate3);
		Item item3 = new Item("hwk1", newDt3);

		String newDate4 = "05/21/2012";
		Date newDt4 = dtFormat.parse(newDate4);
		Item item4 = new Item("hwk2", newDt4);

		cat1.addItem(item1);
		cat1.addItem(item2);
		cat2.addItem(item3);
		cat2.addItem(item4);
		course1.addCategory(cat1);
		course1.addCategory(cat2);

		// TEST 1
		ArrayList<Item> itemByDateList = new ArrayList<Item>();
		itemByDateList.add(item3);
		itemByDateList.add(item4);
		itemByDateList.add(item2);
		itemByDateList.add(item1);

		GradeTrendGraph graph = new GradeTrendGraph(course1, 4, 0);
		assertEquals(0, graph.getDateOrderedItemsList().size());
		graph.updateAndOrganizeItemListByDate();
		assertTrue(this.compareItemLists(itemByDateList,
				graph.getDateOrderedItemsList()));

		// TEST 2 (add item then update)
		String newDate5 = "07/26/2012";
		Date newDt5 = dtFormat.parse(newDate5);
		Item item5 = new Item("exam3", newDt5);
		graph.getCourse().getCategories().get(0).getItemList().add(item5);
		graph.updateAndOrganizeItemListByDate();
		itemByDateList.add(item5);
		System.out.println(graph.getDateOrderedItemsList().size());
		assertTrue(this.compareItemLists(itemByDateList,
				graph.getDateOrderedItemsList()));

	}

	public boolean compareItemLists(ArrayList<Item> list1, ArrayList<Item> list2) {

		if (list1.size() != list2.size()) {
			return false;
		}

		for (int i = 0; i < list1.size(); i++) {
			Item item1 = list1.get(i);
			Item item2 = list2.get(i);

			if (!(item1.getCreationDate() == item2.getCreationDate() && item1
					.getName() == item2.getName())) {
				return false;
			}

		}

		return true;
	}

//	public boolean compareDateLists(ArrayList<Date> list1, ArrayList<Date> list2) {
//
//		if (list1.size() != list2.size()) {
//			return false;
//		}
//
//		for (Date date1 : list1) {
//			for (Date date2 : list2) {
//				if (date1.compareTo(date2) != 0) {
//					return false;
//				}
//			}
//		}
//
//		return true;
//	}
}
