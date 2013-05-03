import static org.junit.Assert.*;

import java.awt.event.ItemListener;
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

	private static final double DELTA = 1e-15;

	// test internal helper methods

	// TEST Compare Item Lists
	@Test
	public void testInternalHelperMethods() throws ParseException {
		SimpleDateFormat dtFormat = new SimpleDateFormat("MM/dd/yyyy");

		// initialize items
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

		ArrayList<Item> itemByDateList = new ArrayList<Item>();
		itemByDateList.add(item3);
		itemByDateList.add(item4);
		itemByDateList.add(item2);
		itemByDateList.add(item1);

		ArrayList<Item> itemByDateList2 = new ArrayList<Item>();
		itemByDateList2.add(item3);
		itemByDateList2.add(item4);
		itemByDateList2.add(item1);
		itemByDateList2.add(item2);

		ArrayList<Item> itemByDateList3 = new ArrayList<Item>();
		itemByDateList3.add(item3);
		itemByDateList3.add(item4);
		itemByDateList3.add(item2);

		// test true for equal lists
		assertTrue(this.compareItemLists(itemByDateList, itemByDateList));

		// test false for unequal same size lists
		assertFalse(this.compareItemLists(itemByDateList, itemByDateList2));

		// test false for different size lists
		assertFalse(this.compareItemLists(itemByDateList, itemByDateList3));

	}

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

		GradeTrendGraph graph = new GradeTrendGraph(new Course("math"), 1, 5);

		// test getters
		assertEquals(1, graph.getClassDifficulty_1_5());
		assertEquals(5, graph.getFutureWorkRate_neg5_pos5());
		assertEquals("math", graph.getCourse().getCourseName());

		// test setters
		graph.setClassDifficulty_1_5(3);
		graph.setFutureWorkRate_neg5_pos5(-3);
		graph.setCourse(new Course("science"));

		assertEquals("science", graph.getCourse().getCourseName());
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
	public void testInstantiationErrorThrownForNullCourse() {

		boolean thrown = false;

		try {
			new GradeTrendGraph(null, 3, 3);
		} catch (InstantiationError e) {
			thrown = true;
			assertEquals(e.getMessage(), "Must Enter Valid Course");
		}

		assertTrue(thrown);
	}

	@Test
	public void testUpdateAndOrganizeItemListByDate() throws ParseException {
		SimpleDateFormat dtFormat = new SimpleDateFormat("MM/dd/yyyy");

		String sDate = "02/25/2012";
		Date startDate = dtFormat.parse(sDate);
		String eDate = "09/25/2012";
		Date endDate = dtFormat.parse(eDate);

		Course course1 = new Course("math");
		course1.setStartDate(startDate);
		course1.setEndDate(endDate);

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
		assertTrue(this.compareItemLists(itemByDateList,
				graph.getDateOrderedItemsList()));

		// TEST 3 -- set Date Scope
		String d = "08/26/2012";
		Date date = dtFormat.parse(d);
		graph.setStartDate(newDt4);
		graph.setEndDate(date);
		graph.updateAndOrganizeItemListByDate();
		itemByDateList.remove(item3);
		assertTrue(this.compareItemLists(itemByDateList,
				graph.getDateOrderedItemsList()));

		// TEST 4 -- set Date Scope For No results
		graph.setStartDate(date);
		graph.setEndDate(date);
		graph.updateAndOrganizeItemListByDate();
		assertEquals(0, graph.getDateOrderedItemsList().size());

	}

	@Test
	public void testUpdateExtremeGradesOne() throws Exception {
		SimpleDateFormat dtFormat = new SimpleDateFormat("MM/dd/yyyy");

		String newDate1 = "04/03/2013";
		Date newDt1 = dtFormat.parse(newDate1);

		String newDate2 = "04/23/2013";
		Date newDt2 = dtFormat.parse(newDate2);

		Course course = new Course("Temp", 4.0, newDt1, newDt2);
		Category cat = new Category("HW", 8, 100);
		course.addCategory(cat);

		GradeTrendGraph graph = new GradeTrendGraph(course, 2, 5);
		graph.setStartDate(newDt1);
		graph.setEndDate(newDt1);
		graph.updateGraph();

		assertEquals(0, graph.getWorstCaseGrade(), DELTA);
		assertEquals(100, graph.getBestCaseGrade(), DELTA);
	}

	@Test
	public void testUpdateExtremeGradesTwo() throws Exception {
		SimpleDateFormat dtFormat = new SimpleDateFormat("MM/dd/yyyy");

		String newDate1 = "04/03/2013";
		Date newDt1 = dtFormat.parse(newDate1);

		String newDate2 = "04/23/2013";
		Date newDt2 = dtFormat.parse(newDate2);

		Course course = new Course("Temp", 4.0, newDt1, newDt2);
		Category cat = new Category("HW", 8, 100);
		course.addCategory(cat);

		GradeTrendGraph graph = new GradeTrendGraph(course, 2, 5);
		graph.setStartDate(newDt1);
		graph.setEndDate(newDt2);
		graph.updateGraph();

		assertEquals(0, graph.getWorstCaseGrade(), DELTA);
		assertEquals(100, graph.getBestCaseGrade(), DELTA);
	}

	@Test
	public void testUpdateExtremeGradesThree() throws Exception {
		SimpleDateFormat dtFormat = new SimpleDateFormat("MM/dd/yyyy");

		String newDate1 = "04/08/2013";
		Date newDt1 = dtFormat.parse(newDate1);

		String newDate2 = "04/28/2013";
		Date newDt2 = dtFormat.parse(newDate2);

		String newDate3 = "04/18/2013";
		Date newDt3 = dtFormat.parse(newDate3);

		Course course = new Course("Temp", 4.0, newDt1, newDt2);
		Category cat = new Category("HW", 100);

		String[] date = { "4/08/2013", "4/09/2013", "4/10/2013", "4/11/2013",
				"4/12/2013", "4/13/2013", "4/14/2013" };
		for (int i = 0; i < 10; i++) {
			int rand = (int) Math.random() * date.length;
			Item it = new Item("HW" + i, dtFormat.parse(date[rand]));
			it.setEarnedPoints("50");
			it.setTotalPoints("100");
			cat.addItem(it);
		}

		course.addCategory(cat);

		GradeTrendGraph graph = new GradeTrendGraph(course, 2, 5);
		graph.setStartDate(newDt1);
		graph.setEndDate(newDt3);
		graph.updateGraph();

		assertEquals(25, graph.getWorstCaseGrade(), DELTA);
		assertEquals(75, graph.getBestCaseGrade(), DELTA);
	}

	public boolean compareItemLists(ArrayList<Item> list1, ArrayList<Item> list2) {

		if (list1.size() != list2.size()) {
			return false;
		}

		for (int i = 0; i < list1.size(); i++) {
			Item item1 = list1.get(i);
			Item item2 = list2.get(i);

			if (!(item1.getUpdateDate() == item2.getUpdateDate() && item1
					.getName() == item2.getName())) {
				return false;
			}

		}

		return true;
	}

	// public boolean compareDateLists(ArrayList<Date> list1, ArrayList<Date>
	// list2) {
	//
	// if (list1.size() != list2.size()) {
	// return false;
	// }
	//
	// for (Date date1 : list1) {
	// for (Date date2 : list2) {
	// if (date1.compareTo(date2) != 0) {
	// return false;
	// }
	// }
	// }
	//
	// return true;
	// }
}
