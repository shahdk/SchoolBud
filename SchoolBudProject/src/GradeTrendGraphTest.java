import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

	// // TEST Compare Item Lists
	// @Test
	// public void testInternalHelperMethods() throws ParseException {
	// SimpleDateFormat dtFormat = new SimpleDateFormat("MM/dd/yyyy");
	//
	// // initialize items
	// String newDate1 = "07/25/2012";
	// Date newDt1 = dtFormat.parse(newDate1);
	// Item item1 = new Item("exam1", newDt1);
	//
	// String newDate2 = "05/21/2012";
	// Date newDt2 = dtFormat.parse(newDate2);
	// Item item2 = new Item("exam2", newDt2);
	//
	// String newDate3 = "04/29/2012";
	// Date newDt3 = dtFormat.parse(newDate3);
	// Item item3 = new Item("hwk1", newDt3);
	//
	// String newDate4 = "05/21/2012";
	// Date newDt4 = dtFormat.parse(newDate4);
	// Item item4 = new Item("hwk2", newDt4);
	//
	// ArrayList<Item> itemByDateList = new ArrayList<Item>();
	// itemByDateList.add(item3);
	// itemByDateList.add(item4);
	// itemByDateList.add(item2);
	// itemByDateList.add(item1);
	//
	// ArrayList<Item> itemByDateList2 = new ArrayList<Item>();
	// itemByDateList2.add(item3);
	// itemByDateList2.add(item4);
	// itemByDateList2.add(item1);
	// itemByDateList2.add(item2);
	//
	// ArrayList<Item> itemByDateList3 = new ArrayList<Item>();
	// itemByDateList3.add(item3);
	// itemByDateList3.add(item4);
	// itemByDateList3.add(item2);
	//
	// // test true for equal lists
	// assertTrue(this.compareItemLists(itemByDateList, itemByDateList));
	//
	// // test false for unequal same size lists
	// assertFalse(this.compareItemLists(itemByDateList, itemByDateList2));
	//
	// // test false for different size lists
	// assertFalse(this.compareItemLists(itemByDateList, itemByDateList3));
	//
	// }
	//
	// // Test DataPoint Helper Class
	// @Test
	// public void testDataPointHelperClass() throws ParseException {
	//
	// SimpleDateFormat dtFormat = new SimpleDateFormat("MM/dd/yyyy");
	//
	// String sDate = "02/25/2012";
	// Date d1 = dtFormat.parse(sDate);
	// String eDate = "09/25/2012";
	// Date d2 = dtFormat.parse(eDate);
	//
	// DataPoint point = new DataPoint(d1, 8);
	//
	// // test getters
	// assertEquals(d1, point.getX());
	// assertEquals(8, point.getY(), DELTA);
	//
	// // test setters
	// point.setX(d2);
	// point.setY(0);
	//
	// assertEquals(d2, point.getX());
	// assertEquals(0, point.getY(), DELTA);
	//
	// }
	//
	// @Test
	// public void testAllUserEnteredVariablesGettersAndSetters()
	// throws ParseException {
	//
	// SimpleDateFormat dtFormat = new SimpleDateFormat("MM/dd/yyyy");
	//
	// String sDate = "02/25/2012";
	// Date startDate = dtFormat.parse(sDate);
	// String eDate = "09/25/2012";
	// Date endDate = dtFormat.parse(eDate);
	//
	// GradeTrendGraph graph = new GradeTrendGraph(new Course("math"), 1, 5);
	// graph.setStartDate(startDate);
	// graph.setEndDate(endDate);
	//
	// // test getters
	// assertEquals(1, graph.getClassDifficulty_1_5());
	// assertEquals(5, graph.getFutureWorkRate_neg5_pos5());
	// assertEquals("math", graph.getCourse().getCourseName());
	//
	// // test setters
	// graph.setClassDifficulty_1_5(3);
	// graph.setFutureWorkRate_neg5_pos5(-3);
	// graph.setCourse(new Course("science"));
	//
	// assertEquals("science", graph.getCourse().getCourseName());
	// assertEquals(3, graph.getClassDifficulty_1_5());
	// assertEquals(-3, graph.getFutureWorkRate_neg5_pos5());
	//
	// // Test setters - getters for start and end date scope
	// assertEquals(graph.getStartDate(), startDate);
	// assertEquals(graph.getEndDate(), endDate);
	//
	// }
	//
	// @Test
	// public void testInstantiationErrorThrownForInvalidClassDifficulty() {
	//
	// boolean thrown = false;
	//
	// try {
	// new GradeTrendGraph(null, 0, 5);
	// } catch (InstantiationError e) {
	// thrown = true;
	// assertEquals(e.getMessage(),
	// "Class Difficulty must be and integer 1 to 5");
	// }
	//
	// assertTrue(thrown);
	// }
	//
	// @Test
	// public void testInstantiationErrorThrownForInvalidFutureWorkRate() {
	//
	// boolean thrown = false;
	//
	// try {
	// new GradeTrendGraph(null, 3, -6);
	// } catch (InstantiationError e) {
	// thrown = true;
	// assertEquals(e.getMessage(),
	// "Future work rate must be and integer -5 to 5");
	// }
	//
	// assertTrue(thrown);
	// }
	//
	// @Test
	// public void testInstantiationErrorThrownForNullCourse() {
	//
	// boolean thrown = false;
	//
	// try {
	// new GradeTrendGraph(null, 3, 3);
	// } catch (InstantiationError e) {
	// thrown = true;
	// assertEquals(e.getMessage(), "Must Enter Valid Course");
	// }
	//
	// assertTrue(thrown);
	// }
	//
	// @Test
	// public void testUpdateAndOrganizeItemListByDate() throws ParseException {
	// SimpleDateFormat dtFormat = new SimpleDateFormat("MM/dd/yyyy");
	//
	// String sDate = "02/25/2012";
	// Date startDate = dtFormat.parse(sDate);
	// String eDate = "09/25/2012";
	// Date endDate = dtFormat.parse(eDate);
	//
	// Course course1 = new Course("math");
	// course1.setStartDate(startDate);
	// course1.setEndDate(endDate);
	//
	// Category cat1 = new Category("tests", 20);
	// Category cat2 = new Category("hwk", 10);
	//
	// String newDate1 = "07/25/2012";
	// Date newDt1 = dtFormat.parse(newDate1);
	// Item item1 = new Item("exam1", newDt1);
	//
	// String newDate2 = "05/21/2012";
	// Date newDt2 = dtFormat.parse(newDate2);
	// Item item2 = new Item("exam2", newDt2);
	//
	// String newDate3 = "04/29/2012";
	// Date newDt3 = dtFormat.parse(newDate3);
	// Item item3 = new Item("hwk1", newDt3);
	//
	// String newDate4 = "05/21/2012";
	// Date newDt4 = dtFormat.parse(newDate4);
	// Item item4 = new Item("hwk2", newDt4);
	//
	// cat1.addItem(item1);
	// cat1.addItem(item2);
	// cat2.addItem(item3);
	// cat2.addItem(item4);
	// course1.addCategory(cat1);
	// course1.addCategory(cat2);
	//
	// // TEST 1
	// ArrayList<Item> itemByDateList = new ArrayList<Item>();
	// itemByDateList.add(item3);
	// itemByDateList.add(item4);
	// itemByDateList.add(item2);
	// itemByDateList.add(item1);
	//
	// GradeTrendGraph graph = new GradeTrendGraph(course1, 4, 0);
	// assertEquals(0, graph.getDateOrderedItemsList().size());
	// graph.updateAndOrganizeItemListByDate();
	// assertTrue(this.compareItemLists(itemByDateList,
	// graph.getDateOrderedItemsList()));
	//
	// // TEST 2 (add item then update)
	// String newDate5 = "07/26/2012";
	// Date newDt5 = dtFormat.parse(newDate5);
	// Item item5 = new Item("exam3", newDt5);
	// graph.getCourse().getCategories().get(0).getItemList().add(item5);
	// graph.updateAndOrganizeItemListByDate();
	// itemByDateList.add(item5);
	// assertTrue(this.compareItemLists(itemByDateList,
	// graph.getDateOrderedItemsList()));
	//
	// // TEST 3 -- set Date Scope
	// String d = "08/26/2012";
	// Date date = dtFormat.parse(d);
	// graph.setStartDate(newDt4);
	// graph.setEndDate(date);
	// graph.updateAndOrganizeItemListByDate();
	// itemByDateList.remove(item3);
	// assertTrue(this.compareItemLists(itemByDateList,
	// graph.getDateOrderedItemsList()));
	//
	// // TEST 4 -- set Date Scope For No results
	// graph.setStartDate(date);
	// graph.setEndDate(date);
	// graph.updateAndOrganizeItemListByDate();
	// assertEquals(0, graph.getDateOrderedItemsList().size());
	//
	// }
	//
	// @Test
	// public void testUpdateExtremeGradesOne() throws Exception {
	// SimpleDateFormat dtFormat = new SimpleDateFormat("MM/dd/yyyy");
	//
	// String newDate1 = "04/03/2013";
	// Date newDt1 = dtFormat.parse(newDate1);
	//
	// String newDate2 = "04/23/2013";
	// Date newDt2 = dtFormat.parse(newDate2);
	//
	// Course course = new Course("Temp", 4.0, newDt1, newDt2);
	// Category cat = new Category("HW", 8, 100);
	// course.addCategory(cat);
	//
	// GradeTrendGraph graph = new GradeTrendGraph(course, 2, 5);
	// graph.setStartDate(newDt1);
	// graph.setEndDate(newDt1);
	// graph.updateGraph();
	//
	// assertEquals(0, graph.getWorstCaseGrade(), DELTA);
	// assertEquals(100, graph.getBestCaseGrade(), DELTA);
	// }
	//
	// @Test
	// public void testUpdateExtremeGradesTwo() throws Exception {
	// SimpleDateFormat dtFormat = new SimpleDateFormat("MM/dd/yyyy");
	//
	// String newDate1 = "04/03/2013";
	// Date newDt1 = dtFormat.parse(newDate1);
	//
	// String newDate2 = "04/23/2013";
	// Date newDt2 = dtFormat.parse(newDate2);
	//
	// Course course = new Course("Temp", 4.0, newDt1, newDt2);
	// Category cat = new Category("HW", 8, 100);
	// course.addCategory(cat);
	//
	// GradeTrendGraph graph = new GradeTrendGraph(course, 2, 5);
	// graph.setStartDate(newDt1);
	// graph.setEndDate(newDt2);
	// graph.updateGraph();
	//
	// assertEquals(0, graph.getWorstCaseGrade(), DELTA);
	// assertEquals(100, graph.getBestCaseGrade(), DELTA);
	// }
	//
	// @Test
	// public void testUpdateExtremeGradesThree() throws Exception {
	// SimpleDateFormat dtFormat = new SimpleDateFormat("MM/dd/yyyy");
	//
	// String newDate1 = "04/08/2013";
	// Date newDt1 = dtFormat.parse(newDate1);
	//
	// String newDate2 = "04/28/2013";
	// Date newDt2 = dtFormat.parse(newDate2);
	//
	// String newDate3 = "04/18/2013";
	// Date newDt3 = dtFormat.parse(newDate3);
	//
	// Course course = new Course("Temp", 4.0, newDt1, newDt2);
	// Category cat = new Category("HW", 100);
	//
	// String[] date = { "4/08/2013", "4/09/2013", "4/10/2013", "4/11/2013",
	// "4/12/2013", "4/13/2013", "4/14/2013" };
	// for (int i = 0; i < 10; i++) {
	// int rand = (int) Math.random() * date.length;
	// Item it = new Item("HW" + i, dtFormat.parse(date[rand]));
	// it.setEarnedPoints("50");
	// it.setTotalPoints("100");
	// cat.addItem(it);
	// }
	//
	// course.addCategory(cat);
	//
	// GradeTrendGraph graph = new GradeTrendGraph(course, 2, 5);
	// graph.setStartDate(newDt1);
	// graph.setEndDate(newDt3);
	// graph.updateGraph();
	//
	// assertEquals(25, graph.getWorstCaseGrade(), DELTA);
	// assertEquals(75, graph.getBestCaseGrade(), DELTA);
	// }
	//
	// @Test
	// public void testUpdateExtremeGradesFour()throws Exception{
	// SimpleDateFormat dtFormat = new SimpleDateFormat("MM/dd/yyyy");
	//
	// String newDate1 = "04/08/2013";
	// Date newDt1 = dtFormat.parse(newDate1);
	//
	// String newDate2 = "04/28/2013";
	// Date newDt2 = dtFormat.parse(newDate2);
	//
	// String newDate3 = "04/18/2013";
	// Date newDt3 = dtFormat.parse(newDate3);
	//
	// Course course = new Course("Temp", 4.0, newDt1, newDt2);
	// Category cat = new Category("HW", 25);
	// Category cat2 = new Category("Exam", 75);
	//
	// String[] date = {"4/08/2013", "4/09/2013", "4/10/2013", "4/11/2013",
	// "4/12/2013", "4/13/2013", "4/14/2013"};
	// for(int i=0; i<10; i++){
	// int rand = (int) Math.random() * date.length;
	// Item it = new Item("HW"+i, dtFormat.parse(date[rand]));
	// it.setEarnedPoints("50");
	// it.setTotalPoints("100");
	// cat.addItem(it);
	// }
	//
	// for(int i=0; i<5; i++){
	// int rand = (int) Math.random() * date.length;
	// Item it = new Item("Exam"+i, dtFormat.parse(date[rand]));
	// it.setEarnedPoints("90");
	// it.setTotalPoints("100");
	// cat2.addItem(it);
	// }
	//
	// course.addCategory(cat);
	// course.addCategory(cat2);
	//
	// GradeTrendGraph graph = new GradeTrendGraph(course, 2, 5);
	// graph.setStartDate(newDt1);
	// graph.setEndDate(newDt3);
	// graph.updateGraph();
	//
	// assertEquals(40, graph.getWorstCaseGrade(), DELTA);
	// assertEquals(90, graph.getBestCaseGrade(), DELTA);
	// }
	//
	// @Test
	// public void testUpdateExtremeGradesFive()throws Exception{
	// SimpleDateFormat dtFormat = new SimpleDateFormat("MM/dd/yyyy");
	//
	// String newDate1 = "04/08/2013";
	// Date newDt1 = dtFormat.parse(newDate1);
	//
	// String newDate2 = "04/28/2013";
	// Date newDt2 = dtFormat.parse(newDate2);
	//
	// String newDate3 = "04/18/2013";
	// Date newDt3 = dtFormat.parse(newDate3);
	//
	// Course course = new Course("Temp", 4.0, newDt1, newDt2);
	// Category cat = new Category("HW", 25);
	// Category cat2 = new Category("Exam", 36);
	// Category cat3 = new Category("Project", 39);
	//
	// String[] date = {"4/08/2013", "4/09/2013", "4/10/2013", "4/11/2013",
	// "4/12/2013", "4/13/2013", "4/14/2013"};
	// for(int i=0; i<10; i++){
	// int rand = (int) Math.random() * date.length;
	// Item it = new Item("HW"+i, dtFormat.parse(date[rand]));
	// it.setEarnedPoints("75");
	// it.setTotalPoints("100");
	// cat.addItem(it);
	// }
	//
	// for(int i=0; i<3; i++){
	// int rand = (int) Math.random() * date.length;
	// Item it = new Item("Exam"+i, dtFormat.parse(date[rand]));
	// it.setEarnedPoints("86");
	// it.setTotalPoints("100");
	// cat2.addItem(it);
	// }
	//
	// int rand = (int) Math.random() * date.length;
	// Item it = new Item("Project0", dtFormat.parse(date[rand]));
	// it.setEarnedPoints("91");
	// it.setTotalPoints("100");
	// cat3.addItem(it);
	//
	// course.addCategory(cat);
	// course.addCategory(cat2);
	// course.addCategory(cat3);
	//
	// GradeTrendGraph graph = new GradeTrendGraph(course, 2, 5);
	// graph.setStartDate(newDt1);
	// graph.setEndDate(newDt3);
	// graph.updateGraph();
	//
	// assertEquals(43, graph.getWorstCaseGrade(), DELTA);
	// assertEquals(93, graph.getBestCaseGrade(), DELTA);
	// }
	//
	// @Test
	// public void testUpdateExtremeGradesSix()throws Exception{
	// SimpleDateFormat dtFormat = new SimpleDateFormat("MM/dd/yyyy");
	//
	// String newDate1 = "04/08/2013";
	// Date newDt1 = dtFormat.parse(newDate1);
	//
	// String newDate2 = "04/28/2013";
	// Date newDt2 = dtFormat.parse(newDate2);
	//
	// String newDate3 = "04/12/2013";
	// Date newDt3 = dtFormat.parse(newDate3);
	//
	// Course course = new Course("Temp", 4.0, newDt1, newDt2);
	// Category cat = new Category("HW", 100);
	//
	// String[] date = {"4/08/2013", "4/09/2013", "4/10/2013"};
	// for(int i=0; i<10; i++){
	// int rand = (int) Math.random() * date.length;
	// Item it = new Item("HW"+i, dtFormat.parse(date[rand]));
	// it.setEarnedPoints("78");
	// it.setTotalPoints("100");
	// cat.addItem(it);
	// }
	//
	// course.addCategory(cat);
	//
	// GradeTrendGraph graph = new GradeTrendGraph(course, 2, 5);
	// graph.setStartDate(newDt1);
	// graph.setEndDate(newDt3);
	// graph.updateGraph();
	//
	// assertEquals(16, graph.getWorstCaseGrade(), DELTA);
	// assertEquals(96, graph.getBestCaseGrade(), DELTA);
	// }
	//
	// @Test
	// public void testUpdateExtremeGradesSeven()throws Exception{
	// SimpleDateFormat dtFormat = new SimpleDateFormat("MM/dd/yyyy");
	//
	// String newDate1 = "04/08/2013";
	// Date newDt1 = dtFormat.parse(newDate1);
	//
	// String newDate2 = "04/28/2013";
	// Date newDt2 = dtFormat.parse(newDate2);
	//
	// String newDate3 = "04/11/2013";
	// Date newDt3 = dtFormat.parse(newDate3);
	//
	// Course course = new Course("Temp", 4.0, newDt1, newDt2);
	// Category cat = new Category("HW", 25);
	// Category cat2 = new Category("Exam", 75);
	//
	// String[] date = {"4/08/2013", "4/09/2013", "4/10/2013"};
	// for(int i=0; i<10; i++){
	// int rand = (int) Math.random() * date.length;
	// Item it = new Item("HW"+i, dtFormat.parse(date[rand]));
	// it.setEarnedPoints("68");
	// it.setTotalPoints("100");
	// cat.addItem(it);
	// }
	//
	// for(int i=0; i<5; i++){
	// int rand = (int) Math.random() * date.length;
	// Item it = new Item("Exam"+i, dtFormat.parse(date[rand]));
	// it.setEarnedPoints("90");
	// it.setTotalPoints("100");
	// cat2.addItem(it);
	// }
	//
	// course.addCategory(cat);
	// course.addCategory(cat2);
	//
	// GradeTrendGraph graph = new GradeTrendGraph(course, 2, 5);
	// graph.setStartDate(newDt1);
	// graph.setEndDate(newDt3);
	// graph.updateGraph();
	//
	// assertEquals(13, graph.getWorstCaseGrade(), DELTA);
	// assertEquals(98, graph.getBestCaseGrade(), DELTA);
	// }
	//
	// @Test
	// public void testUpdateExtremeGradesEight()throws Exception{
	// SimpleDateFormat dtFormat = new SimpleDateFormat("MM/dd/yyyy");
	//
	// String newDate1 = "04/08/2013";
	// Date newDt1 = dtFormat.parse(newDate1);
	//
	// String newDate2 = "04/28/2013";
	// Date newDt2 = dtFormat.parse(newDate2);
	//
	// String newDate3 = "04/13/2013";
	// Date newDt3 = dtFormat.parse(newDate3);
	//
	// Course course = new Course("Temp", 4.0, newDt1, newDt2);
	// Category cat = new Category("HW", 25);
	// Category cat2 = new Category("Exam", 36);
	// Category cat3 = new Category("Project", 39);
	//
	// String[] date = {"4/08/2013", "4/09/2013"};
	// for(int i=0; i<10; i++){
	// int rand = (int) Math.random() * date.length;
	// Item it = new Item("HW"+i, dtFormat.parse(date[rand]));
	// it.setEarnedPoints("75");
	// it.setTotalPoints("100");
	// cat.addItem(it);
	// }
	//
	// for(int i=0; i<3; i++){
	// int rand = (int) Math.random() * date.length;
	// Item it = new Item("Exam"+i, dtFormat.parse(date[rand]));
	// it.setEarnedPoints("86");
	// it.setTotalPoints("100");
	// cat2.addItem(it);
	// }
	//
	// int rand = (int) Math.random() * date.length;
	// Item it = new Item("Project0", dtFormat.parse(date[rand]));
	// it.setEarnedPoints("77");
	// it.setTotalPoints("100");
	// cat3.addItem(it);
	//
	// course.addCategory(cat);
	// course.addCategory(cat2);
	// course.addCategory(cat3);
	//
	// GradeTrendGraph graph = new GradeTrendGraph(course, 2, 5);
	// graph.setStartDate(newDt1);
	// graph.setEndDate(newDt3);
	// graph.updateGraph();
	//
	// assertEquals(20, graph.getWorstCaseGrade(), DELTA);
	// assertEquals(95, graph.getBestCaseGrade(), DELTA);
	// }
	//
	// @Test
	// public void testFindCategoryIndex() {
	//
	// ArrayList<Category> cats = new ArrayList<Category>();
	//
	// Category cat1 = new Category("tests", 0.5);
	// Category cat2 = new Category("homework", 0.3);
	// Category cat3 = new Category("quizzes", 0.2);
	//
	// Course course = new Course("math");
	// course.addCategory(cat1);
	// course.addCategory(cat2);
	// course.addCategory(cat3);
	// cats.add(cat1);
	// cats.add(cat2);
	// cats.add(cat3);
	//
	// GradeTrendGraph graph = new GradeTrendGraph(course, 4, 3);
	//
	// int i = graph.findCategoryIndex(cat2, cats);
	//
	// assertEquals("homework", cats.get(i).getName());
	//
	// }
	//
	// @Test
	// public void testGetRecentGradeVariation() throws ParseException {
	//
	// SimpleDateFormat dtFormat = new SimpleDateFormat("MM/dd/yyyy");
	//
	// String newDate1 = "04/08/2013";
	// Date newDt1 = dtFormat.parse(newDate1);
	//
	// String newDate2 = "04/28/2013";
	// Date newDt2 = dtFormat.parse(newDate2);
	//
	// String newDate3 = "04/18/2013";
	// Date newDt3 = dtFormat.parse(newDate3);
	//
	// Course course = new Course("Temp", 4.0, newDt1, newDt2);
	// Category cat = new Category("HW", 40);
	// Category cat2 = new Category("TEST", 60);
	//
	// String[] date = { "4/08/2013", "4/09/2013", "4/10/2013", "4/11/2013",
	// "4/12/2013", "4/13/2013", "4/14/2013" };
	// int count = 0;
	// for (int i = 0; i < 10; i++) {
	// if (count > 6) {
	// count = 0;
	// }
	// Item it = new Item("HW" + i, dtFormat.parse(date[count]));
	// it.setEarnedPoints(i * 8 + count + "");
	// it.setTotalPoints("100");
	// cat.addItem(it);
	// count++;
	// }
	//
	// count = 3;
	// for (int i = 5; i <= 9; i++) {
	// if (count > 6) {
	// count = 3;
	// }
	// Item it = new Item("TEST" + i, dtFormat.parse(date[count]));
	// it.setEarnedPoints((i * 9) + count + "");
	// it.setTotalPoints("100");
	// cat2.addItem(it);
	// count++;
	// }
	//
	// course.addCategory(cat);
	// course.addCategory(cat2);
	//
	// GradeTrendGraph graph = new GradeTrendGraph(course, 2, 5);
	// graph.setStartDate(newDt1);
	// graph.setEndDate(newDt3);
	// graph.updateGraph();
	//
	// assertEquals(55.68, course.getCourseGrade(), DELTA);
	// assertEquals(56.1, graph.getRecentGradeVariation(), DELTA);
	//
	// }
	//
	// @Test
	// public void testGetPercenDaysRemaining() throws ParseException {
	// SimpleDateFormat dtFormat = new SimpleDateFormat("MM/dd/yyyy");
	//
	// String newDate2 = "04/20/2013";
	// Date cur = dtFormat.parse(newDate2);
	//
	// String newDate3 = "04/28/2013";
	// Date end = dtFormat.parse(newDate3);
	//
	// assertEquals(GradeTrendGraph.getPercenDaysRemaining(cur, end, 20), 0.4,
	// DELTA);
	//
	// }
	//
	// @Test
	// public void testGetDateDiffDays() throws ParseException {
	// SimpleDateFormat dtFormat = new SimpleDateFormat("MM/dd/yyyy");
	//
	// String newDate1 = "04/08/2013";
	// Date newDt1 = dtFormat.parse(newDate1);
	//
	// String newDate2 = "04/28/2013";
	// Date newDt2 = dtFormat.parse(newDate2);
	//
	// String newDate3 = "05/18/2013";
	// Date newDt3 = dtFormat.parse(newDate3);
	//
	// assertEquals(GradeTrendGraph.getDateDiffDays(newDt1, newDt2), 20);
	// assertEquals(GradeTrendGraph.getDateDiffDays(newDt1, newDt3), 40);
	// }
	//
	// @Test
	// public void testGetPercentChangeValueFutureWorkRate() {
	//
	// // test pos
	// double val = GradeTrendGraph.getPercentChangeValue(0, 3);
	// assertEquals(1.15, val, DELTA);
	//
	// // test neg
	// val = GradeTrendGraph.getPercentChangeValue(0, -5);
	// assertEquals(.25, val, DELTA);
	//
	// // test nom
	// val = GradeTrendGraph.getPercentChangeValue(0, 0);
	// assertEquals(1, val, DELTA);
	//
	// }
	//
	// @Test
	// public void testGetPercentChangeValueClassDifficulty() {
	//
	// // test above - easy
	// double val = GradeTrendGraph.getPercentChangeValue(3, 5);
	// assertEquals(1.1, val, DELTA);
	//
	// // test below - hard
	// val = GradeTrendGraph.getPercentChangeValue(3, 1);
	// assertEquals(0.1, val, DELTA);
	//
	// // test nom
	// val = GradeTrendGraph.getPercentChangeValue(3, 3);
	// assertEquals(1, val, DELTA);
	//
	// }

	@Test
	public void testIntegrationGradeTrendGraph() throws ParseException {

		SimpleDateFormat dtFormat = new SimpleDateFormat("MM/dd/yyyy");

		String newDate1 = "04/03/2013";
		Date start = dtFormat.parse(newDate1);

		String newDate2 = "04/28/2013";
		Date end = dtFormat.parse(newDate2);

		String newDate3 = "04/05/2013";
		Date curr = dtFormat.parse(newDate3);

		Course course = new Course("Temp", 4.0, start, end);
		Category cat = new Category("HW", 40);
		Category cat2 = new Category("TEST", 60);

		String[] date = { "4/08/2013", "4/09/2013", "4/10/2013", "4/11/2013",
				"4/12/2013", "4/13/2013", "4/14/2013" };
		int count = 0;
		for (int i = 0; i < 10; i++) {
			if (count > 6) {
				count = 0;
			}
			Item it = new Item("HW" + i, dtFormat.parse(date[count]));
			it.setEarnedPoints(i * 8 + count + "");
			it.setTotalPoints("100");
			cat.addItem(it);
			count++;
		}

		count = 3;
		for (int i = 5; i <= 9; i++) {
			if (count > 6) {
				count = 3;
			}
			Item it = new Item("TEST" + i, dtFormat.parse(date[count]));
			it.setEarnedPoints((i * 9) + count + "");
			it.setTotalPoints("100");
			cat2.addItem(it);
			count++;
		}

		course.addCategory(cat);
		course.addCategory(cat2);

		GradeTrendGraph graph = new GradeTrendGraph(course, 3, 0);
		graph.setStartDate(start);
		graph.setEndDate(end);
		graph.setTestCurrentDate(curr);

		// UPDATE ALL
		graph.updateAll();

		// check FINAL stats
		assertEquals(55.68, course.getCourseGrade(), DELTA);
		assertEquals(56, graph.getPredictedGrade(), 0.5);
		assertEquals(38, graph.getPredictedWorstCaseGrade(), 0.6);
		assertEquals(71, graph.getPredictedBestCaseGrade(), 0.5);
		assertEquals(100, graph.getBestCaseGrade(), DELTA);
		assertEquals(0, graph.getWorstCaseGrade(), DELTA);

		// TEST DATES
		ArrayList<Date> dates = this.findDates(curr, end);
		// GRAPH DATES
		ArrayList<DataPoint> pred = graph.getGradePredictionCurvePoints();

		// check points X - date
		assertEquals(pred.get(0).getX(), curr);
		System.out.println("0--- " + pred.get(0).getX());
		System.out.println("0--- " + curr);

		assertEquals(pred.get(1).getX(), dates.get(1));
		System.out.println("1--- " + pred.get(1).getX());
		System.out.println("1--- " + dates.get(1));

		assertEquals(pred.get(2).getX(), dates.get(2));
		System.out.println("2--- " + pred.get(2).getX());
		System.out.println("2--- " + dates.get(2));
		
		// remaining days
		assertEquals(pred.get(3).getX(), dates.get(3));
		System.out.println("3--- " + pred.get(3).getX());
		System.out.println("3--- " + dates.get(3));

		// assertEquals(graph.getBestGradePredictionCurvePoints().get(0).getX(),
		// curr);
		// assertEquals(graph.getBestGradePredictionCurvePoints().get(1).getX(),
		// dates.get(1));
		// assertEquals(graph.getWorstGradePredictionCurvePoints().get(0).getX(),
		// curr);
		// assertEquals(graph.getWorstGradePredictionCurvePoints().get(1).getX(),
		// dates.get(1));

		// check points Y - grade
		assertEquals(graph.getGradePredictionCurvePoints().get(0).getY(), 56,
				0.5);
		assertEquals(graph.getGradePredictionCurvePoints().get(1).getY(), 56,
				0.5);
		assertEquals(graph.getBestGradePredictionCurvePoints().get(1).getY(),
				71, 0.5);
		assertEquals(graph.getWorstGradePredictionCurvePoints().get(1).getY(),
				37, 0.5);

	}

	public ArrayList<Date> findDates(Date s, Date e) {

		ArrayList<Date> dateList = new ArrayList<Date>();

		// find time periods --- get number of weeks --- and left over days
		int numDays = GradeTrendGraph.getDateDiffDays(s, e);
		int numWeeks = numDays / 7;
		int numRemainDays = numDays % 7;

		// setup calander incrementer
		Calendar c = Calendar.getInstance();
		c.setTime(s);

		// loop through num weeks and calculate data point for each week
		for (int i = 0; i < numWeeks; i++) {

			// add current incremented date to list
			dateList.add(c.getTime());

			// THEN increment calender by a week
			c.add(Calendar.DATE, 7);

		}

		// increment date to remaining days
		c.add(Calendar.DATE, numRemainDays);
		dateList.add(c.getTime());

		return dateList;
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
}
