import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class SchedulerTester {

//	 @Test
//	 public void test() {
//	 assertTrue(true);
//	 }
//	
//	 @Test
//	 public void testInitialize() {
//	
//	 ArrayList<ClassDay> days = WeekSchedule.create7DayArrayList();
//	 ArrayList<Integer> hours = new ArrayList<Integer>();
//	 hours.add(1);
//	 hours.add(5);
//	 ClassDay day = new ClassDay(hours);
//	 days.set(0, day);
//	 WeekSchedule week = new WeekSchedule(days);
//	 ArrayList<WeekSchedule> sections = new ArrayList<WeekSchedule>();
//	 sections.add(week);
//	 ClassSection sectionHolder = new ClassSection(sections);
//	
//	 SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man",
//	 sectionHolder);
//	
//	 ArrayList<SchedulerCourse> classes = new ArrayList<SchedulerCourse>();
//	 classes.add(class1);
//	
//	 assertNotNull(new Scheduler(5, classes));
//	 }
//	
//	 @Test
//	 public void testScheduleEmptyClasses() {
//	
//	 Scheduler scheduler = new Scheduler(5, new ArrayList<SchedulerCourse>());
//	
//	 assertEquals(new ArrayList<ArrayList<ArrayList<SchedulerCourse>>>(),
//	 scheduler.permutateSchedules());
//	 }
//	
//	 @Test
//	 public void testScheduleOneClassZeroHours() {
//	
//	 ArrayList<ClassDay> days = WeekSchedule.create7DayArrayList();
//	 ArrayList<Integer> hours = new ArrayList<Integer>();
//	 ClassDay day = new ClassDay(hours);
//	 days.set(0, day);
//	 WeekSchedule week = new WeekSchedule(days);
//	 ArrayList<WeekSchedule> sections = new ArrayList<WeekSchedule>();
//	 sections.add(week);
//	 ClassSection sectionHolder = new ClassSection(sections);
//	
//	 SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man",
//	 sectionHolder);
//	
//	 ArrayList<SchedulerCourse> classes = new ArrayList<SchedulerCourse>();
//	 classes.add(class1);
//	
//	 Scheduler scheduler = new Scheduler(8, classes);
//	
//	 assertEquals(0, scheduler.permutateSchedules().size());
//	 }
//	
//	 @Test
//	 public void testScheduleOneClassOneHour() {
//	 ArrayList<ClassDay> days = WeekSchedule.create7DayArrayList();
//	 ArrayList<Integer> hours = new ArrayList<Integer>();
//	 hours.add(2);
//	 ClassDay day = new ClassDay(hours);
//	 days.set(0, day);
//	 WeekSchedule week = new WeekSchedule(days);
//	 ArrayList<WeekSchedule> sections = new ArrayList<WeekSchedule>();
//	 sections.add(week);
//	 ClassSection sectionHolder = new ClassSection(sections);
//	
//	 SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man",
//	 sectionHolder);
//	
//	 ArrayList<SchedulerCourse> classes = new ArrayList<SchedulerCourse>();
//	 classes.add(class1);
//	
//	 Scheduler scheduler = new Scheduler(8, classes);
//	
//	 assertEquals(1, scheduler.permutateSchedules().size());
//	 }
//	
//	 @Test
//	 public void testScheduleOneClassTwoHoursOneSection() {
//	
//	 ArrayList<ClassDay> days = WeekSchedule.create7DayArrayList();
//	 ArrayList<Integer> hours = new ArrayList<Integer>();
//	 hours.add(2);
//	 hours.add(3);
//	 ClassDay day = new ClassDay(hours);
//	 days.set(0, day);
//	 WeekSchedule week = new WeekSchedule(days);
//	 ArrayList<WeekSchedule> sections = new ArrayList<WeekSchedule>();
//	 sections.add(week);
//	 ClassSection sectionHolder = new ClassSection(sections);
//	
//	 SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man",
//	 sectionHolder);
//	
//	 ArrayList<SchedulerCourse> classes = new ArrayList<SchedulerCourse>();
//	 classes.add(class1);
//	
//	 Scheduler scheduler = new Scheduler(8, classes);
//	
//	 assertEquals(1, scheduler.permutateSchedules().size());
//	 }
//
//	 @Test
//	 public void testScheduleTwoClassesWithOneHoursSectionEach() {
//	
//	 ArrayList<ClassDay> days = WeekSchedule.create7DayArrayList();
//	 ArrayList<Integer> hours = new ArrayList<Integer>();
//	 hours.add(2);
//	 ClassDay day = new ClassDay(hours);
//	 days.set(0, day);
//	 WeekSchedule week = new WeekSchedule(days);
//	 ArrayList<WeekSchedule> sections = new ArrayList<WeekSchedule>();
//	 sections.add(week);
//	 ClassSection sectionHolder = new ClassSection(sections);
//	
//	 SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man",
//	 sectionHolder);
//	
//	 ArrayList<ClassDay> days2 = WeekSchedule.create7DayArrayList();
//	 ArrayList<Integer> hours2 = new ArrayList<Integer>();
//	 hours2.add(3);
//	 ClassDay day2 = new ClassDay(hours2);
//	 days2.set(0, day2);
//	 WeekSchedule week2 = new WeekSchedule(days2);
//	 ArrayList<WeekSchedule> sections2 = new ArrayList<WeekSchedule>();
//	 sections2.add(week2);
//	 ClassSection sectionHolder2 = new ClassSection(sections2);
//	
//	 SchedulerCourse class2 = new SchedulerCourse("Science", "Mr. Foley",
//	 sectionHolder2);
//	
//	 ArrayList<SchedulerCourse> classes = new ArrayList<SchedulerCourse>();
//	 classes.add(class1);
//	 classes.add(class2);
//	
//	 Scheduler scheduler = new Scheduler(8, classes);
//	
//	 assertEquals(1, scheduler.permutateSchedules().size());
//	 }

//	@Test
//	public void testScheduleOneClassWithTwoSectionsOfOneHour() {
//
//		ArrayList<ClassDay> days = WeekSchedule.create7DayArrayList();
//		ArrayList<Integer> hours = new ArrayList<Integer>();
//		ArrayList<ClassDay> days2 = WeekSchedule.create7DayArrayList();
//		ArrayList<Integer> hours2 = new ArrayList<Integer>();
//		hours.add(2);
//		hours2.add(4);
//		ClassDay day = new ClassDay(hours);
//		ClassDay day2 = new ClassDay(hours2);
//		days.set(0, day);
//		days2.set(0, day2);
//		WeekSchedule week = new WeekSchedule(days);
//		WeekSchedule week2 = new WeekSchedule(days2);
//		ArrayList<WeekSchedule> sections = new ArrayList<WeekSchedule>();
//		sections.add(week);
//		sections.add(week2);
//		ClassSection sectionHolder = new ClassSection(sections);
//
//		SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man",
//				sectionHolder);
//
//		ArrayList<SchedulerCourse> classes = new ArrayList<SchedulerCourse>();
//		classes.add(class1);
//
//		Scheduler scheduler = new Scheduler(8, classes);
//
//		assertEquals(2, scheduler.permutateSchedules().size());
//		assertEquals(1, scheduler.permutateSchedules().get(0).size());
//		assertEquals(1, scheduler.permutateSchedules().get(1).size());
//		assertEquals(hours, scheduler.permutateSchedules().get(0).get(0)
//				.getSections().getSections().get(0).getScheduleHours().get(0)
//				.getHourSlots());
//	}
	
	@Test
	public void testScheduleTwoClassesWithOneSectionEach() {

		ArrayList<ClassDay> days = WeekSchedule.create7DayArrayList();
		ArrayList<Integer> hours = new ArrayList<Integer>();
		ArrayList<ClassDay> days2 = WeekSchedule.create7DayArrayList();
		ArrayList<Integer> hours2 = new ArrayList<Integer>();
		hours.add(2);
		hours2.add(4);
		ClassDay day = new ClassDay(hours);
		ClassDay day2 = new ClassDay(hours2);
		days.set(0, day);
		days2.set(0, day2);
		WeekSchedule week = new WeekSchedule(days);
		WeekSchedule week2 = new WeekSchedule(days2);
		ArrayList<WeekSchedule> sections = new ArrayList<WeekSchedule>();
		sections.add(week);
		sections.add(week2);
		ClassSection sectionHolder = new ClassSection(sections);

		SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man",
				sectionHolder);

		ArrayList<SchedulerCourse> classes = new ArrayList<SchedulerCourse>();
		classes.add(class1);

		Scheduler scheduler = new Scheduler(8, classes);

		assertEquals(2, scheduler.permutateSchedules().size());
		assertEquals(1, scheduler.permutateSchedules().get(0).size());
		assertEquals(1, scheduler.permutateSchedules().get(1).size());
		assertEquals(hours, scheduler.permutateSchedules().get(0).get(0)
				.getSections().getSections().get(0).getScheduleHours().get(0)
				.getHourSlots());
	}

	// @Test
	// public void testScheduleOneClassFiveHoursWithMaxHourAndMinHourUsed() {
	//
	// ArrayList<Integer> hours1 = new ArrayList<Integer>();
	//
	// hours1.add(1);
	// hours1.add(6);
	// hours1.add(7);
	// hours1.add(9);
	// hours1.add(10);
	//
	// Class class1 = new Class("Math", "Mr. Man", hours1);
	// ArrayList<Class> classes = new ArrayList<Class>();
	// classes.add(class1);
	//
	// Scheduler scheduler = new Scheduler(10, classes);
	//
	// assertEquals(class1, scheduler.permutateSchedules().get(0)[1]);
	// assertEquals(class1, scheduler.permutateSchedules().get(1)[6]);
	// assertEquals(class1, scheduler.permutateSchedules().get(2)[7]);
	// assertEquals(class1, scheduler.permutateSchedules().get(3)[9]);
	// assertEquals(class1, scheduler.permutateSchedules().get(4)[10]);
	// }
	//
	//
	// @Test
	// public void testScheduleTwoClassesOneHourOnly() {
	//
	// ArrayList<Integer> hours1 = new ArrayList<Integer>();
	// ArrayList<Integer> hours2 = new ArrayList<Integer>();
	//
	// hours1.add(2);
	//
	// Class class1 = new Class("Math", "Mr. Man", hours1);
	// Class class2 = new Class("Physics", "Mr. Nam", hours2);
	// ArrayList<Class> classes = new ArrayList<Class>();
	// classes.add(class1);
	// classes.add(class2);
	//
	// Scheduler scheduler = new Scheduler(4, classes);
	//
	// assertEquals(new ArrayList<Class[]>(), scheduler.permutateSchedules());
	// }
	//
	//
	// @Test
	// public void testScheduleTwoClassesOneHourEach() {
	//
	// ArrayList<Integer> hours1 = new ArrayList<Integer>();
	// ArrayList<Integer> hours2 = new ArrayList<Integer>();
	//
	// hours1.add(2);
	// hours2.add(7);
	//
	// Class class1 = new Class("Math", "Mr. Man", hours1);
	// Class class2 = new Class("Physics", "Mr. Nam", hours2);
	// ArrayList<Class> classes = new ArrayList<Class>();
	// classes.add(class1);
	// classes.add(class2);
	//
	// Scheduler scheduler = new Scheduler(7, classes);
	//
	//
	//
	// assertEquals(class1, scheduler.permutateSchedules().get(0)[2]);
	// assertEquals(class2, scheduler.permutateSchedules().get(0)[7]);
	// }
	//
	//
	// @Test
	// public void testScheduleTwoClassesEachHaveSameTwoHours() {
	//
	// ArrayList<Integer> hours1 = new ArrayList<Integer>();
	// ArrayList<Integer> hours2 = new ArrayList<Integer>();
	//
	// hours1.add(2);
	// hours1.add(7);
	// hours2.add(2);
	// hours2.add(7);
	//
	// Class class1 = new Class("Math", "Mr. Man", hours1);
	// Class class2 = new Class("Physics", "Mr. Nam", hours2);
	// ArrayList<Class> classes = new ArrayList<Class>();
	// classes.add(class1);
	// classes.add(class2);
	//
	// Scheduler scheduler = new Scheduler(7, classes);
	//
	// assertEquals(class1, scheduler.permutateSchedules().get(0)[2]);
	// assertEquals(class2, scheduler.permutateSchedules().get(0)[7]);
	// assertEquals(class1, scheduler.permutateSchedules().get(1)[7]);
	// assertEquals(class2, scheduler.permutateSchedules().get(1)[2]);
	// }
	//
	// @Test
	// public void testScheduleThreeClassesThreeDifferentPeriodsEach() {
	//
	// ArrayList<Integer> hours1 = new ArrayList<Integer>();
	// ArrayList<Integer> hours2 = new ArrayList<Integer>();
	// ArrayList<Integer> hours3 = new ArrayList<Integer>();
	//
	// hours1.add(1);
	// hours1.add(2);
	// hours1.add(3);
	// hours2.add(4);
	// hours2.add(5);
	// hours2.add(6);
	// hours3.add(7);
	// hours3.add(8);
	// hours3.add(9);
	//
	// Class class1 = new Class("Math", "Mr. Man", hours1);
	// Class class2 = new Class("Physics", "Mr. Nam", hours2);
	// Class class3 = new Class("Social Studies", "Mohan", hours3);
	// ArrayList<Class> classes = new ArrayList<Class>();
	// classes.add(class1);
	// classes.add(class2);
	// classes.add(class3);
	//
	// Scheduler scheduler = new Scheduler(10, classes);
	//
	//
	//
	// assertEquals(class1, scheduler.permutateSchedules().get(0)[1]);
	// assertEquals(class2, scheduler.permutateSchedules().get(0)[4]);
	// assertEquals(class3, scheduler.permutateSchedules().get(0)[7]);
	// assertEquals(null, scheduler.permutateSchedules().get(0)[10]);
	//
	// assertEquals(class1, scheduler.permutateSchedules().get(1)[2]);
	// assertEquals(class2, scheduler.permutateSchedules().get(1)[5]);
	// assertEquals(class3, scheduler.permutateSchedules().get(1)[8]);
	// assertEquals(null, scheduler.permutateSchedules().get(1)[10]);
	//
	// assertEquals(class1, scheduler.permutateSchedules().get(2)[3]);
	// assertEquals(class2, scheduler.permutateSchedules().get(2)[6]);
	// assertEquals(class3, scheduler.permutateSchedules().get(2)[9]);
	// assertEquals(null, scheduler.permutateSchedules().get(2)[10]);
	//
	//
	// int size = scheduler.permutateSchedules().size();
	// assertEquals(9, size);
	//
	//
	// }

	//
	// for (int i = 0; i < size; i++){
	// assertEquals(3,
	// this.countArrayItems(scheduler.permutateSchedules().get(i)));
	// }

	// private int countArrayItems (Class[] list){
	// int count = 0;
	// for (Class i : list){
	// if (i != null) {
	// count++;
	// }
	// }
	// return count;
	// }

	private ArrayList<ArrayList<SchedulerCourse>> resetSchedules() {

		ArrayList<ArrayList<SchedulerCourse>> schedules = new ArrayList<ArrayList<SchedulerCourse>>();
		// initialize 7 days of the week with an arrayList
		for (int i = 0; i < 6; i++) {
			schedules.add(new ArrayList<SchedulerCourse>());
		}

		return schedules;
	}
}