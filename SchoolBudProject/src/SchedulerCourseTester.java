import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

/* Tests the CLASS class */

public class SchedulerCourseTester {

	@Test
	public void testName() {
		ArrayList<ClassDay> days = WeekSchedule.create7DayArrayList();
		ArrayList<Integer> hours = new ArrayList<Integer>();
		hours.add(1);
		hours.add(5);
		ClassDay day = new ClassDay(hours);
		days.set(0, day);
		WeekSchedule week = new WeekSchedule(days);
		ArrayList<WeekSchedule> sections = new ArrayList<WeekSchedule>();
		sections.add(week);
		ClassSection sectionHolder = new ClassSection(sections);

		SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man",
				sectionHolder);

		assertEquals(class1.getCourseName(), "Math");
		class1.setName("Physics");
		assertEquals(class1.getCourseName(), "Physics");

	}

	@Test
	public void testSetGetScheduleHours() {

		ArrayList<ClassDay> days = WeekSchedule.create7DayArrayList();
		ArrayList<Integer> hours = new ArrayList<Integer>();
		hours.add(1);
		hours.add(5);
		ClassDay day = new ClassDay(hours);
		days.set(0, day);
		WeekSchedule week = new WeekSchedule(days);
		ArrayList<WeekSchedule> sections = new ArrayList<WeekSchedule>();
		sections.add(week);
		ClassSection sectionHolder = new ClassSection(sections);

		SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man",
				sectionHolder);
		assertEquals(class1.getSections(), sectionHolder);

		SchedulerCourse class2 = new SchedulerCourse("Physics", "Mr. Much",
				null);
		class2.setSections(class1.getSections());
		assertEquals(class2.getSections(), sectionHolder);

	}

	@Test
	public void testTeacher() {

		ArrayList<ClassDay> days = WeekSchedule.create7DayArrayList();
		ArrayList<Integer> hours = new ArrayList<Integer>();
		hours.add(1);
		hours.add(5);
		ClassDay day = new ClassDay(hours);
		days.set(0, day);
		WeekSchedule week = new WeekSchedule(days);
		ArrayList<WeekSchedule> sections = new ArrayList<WeekSchedule>();
		sections.add(week);
		ClassSection sectionHolder = new ClassSection(sections);

		SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man", sectionHolder);
		assertEquals(class1.getTeacher(), "Mr. Man");
		class1.setTeacher("Mrs. Lady");
		assertEquals(class1.getTeacher(), "Mrs. Lady");

	}

//	
//	 @Test
//	 public void testThrownErrorForNon7DaysEntry(){
//	 boolean caught = false;
//	 ArrayList<ArrayList<ClassDay>> scheds = new
//	 ArrayList<ArrayList<ClassDay>>();
//	 ArrayList<Integer> hours1 = new ArrayList<Integer>();
//	 hours1.add(1);
//	 ClassDay day = new ClassDay(hours1);
//	
//	 ArrayList<ClassDay> sched =
//	 SchedulerCourseTester.createInitialized7DayList();
//	 sched.set(2, day);
//	
//	 scheds.add(sched);
//	 scheds.add(new ArrayList<ClassDay>());
//	
//	 try {
//	 SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man", scheds);
//	 }
//	 catch (InstantiationError e) {
//	 caught = true;
//	 }
//	
//	 assertTrue(caught);
//	 }
//	
	// @Test
	// public void testHours() {
	//
	// //section 1
	// ArrayList<ArrayList<ClassDay>> scheds = new
	// ArrayList<ArrayList<ClassDay>>();
	//
	// //create the hours for days
	// ArrayList<Integer> hours1 = new ArrayList<Integer>();
	// hours1.add(1);
	// hours1.add(2);
	// ClassDay day = new ClassDay(hours1);
	//
	// ArrayList<ClassDay> sched =
	// SchedulerCourseTester.createInitialized7DayList();
	// sched.set(2, day);
	//
	// //add section1 to the class' section list
	// scheds.add(sched);
	//
	// //create class
	// SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man", scheds);
	//
	// //check to see if class got the schedule section1
	// assertEquals(class1.getScheduleHours().get(0), sched);
	//
	// //START section2
	// ArrayList<Integer> hours2 = new ArrayList<Integer>();
	// hours2.add(4);
	// hours2.add(5);
	// ClassDay day2 = new ClassDay(hours2);
	//
	// //create hours for days for section2
	// ArrayList<ClassDay> sched2 =
	// SchedulerCourseTester.createInitialized7DayList();
	// sched2.set(5, day2);
	//
	// //add section2 to class' section list
	// scheds.add(sched2);
	// SchedulerCourse class2 = new SchedulerCourse("Math2", "Mr. Man2",
	// scheds);
	//
	// assertEquals(class1.getScheduleHours().get(0), sched);
	// assertEquals(class2.getScheduleHours().get(0), sched);
	// assertEquals(class2.getScheduleHours().get(1), sched2);
	//
	// }

	public static ArrayList<ClassDay> createInitialized7DayList() {
		ArrayList<ClassDay> list = new ArrayList<ClassDay>();

		for (int i = 0; i < 7; i++) {
			list.add(new ClassDay(new ArrayList<Integer>()));
		}

		return list;
	}

}
