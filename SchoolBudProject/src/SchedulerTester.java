import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class SchedulerTester {

	@Test
	public void test() {
		assertTrue(true);
	}

	 @Test
	 public void testInitialize() {
	
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
	
	 ArrayList<SchedulerCourse> classes = new ArrayList<SchedulerCourse>();
	 classes.add(class1);
	
	 assertNotNull(new Scheduler(5, classes));
	 }
	
	 @Test
	 public void testScheduleEmptyClasses() {
	
	 Scheduler scheduler = new Scheduler(5, new ArrayList<SchedulerCourse>());
	
	 assertEquals(new ArrayList<ArrayList<ArrayList<SchedulerCourse>>>(),
	 scheduler.permutateSchedules());
	 }
	
	 @Test
	 public void testScheduleOneClassZeroHours() {
	
	 ArrayList<ClassDay> days = WeekSchedule.create7DayArrayList();
	 ArrayList<Integer> hours = new ArrayList<Integer>();
	 ClassDay day = new ClassDay(hours);
	 days.set(0, day);
	 WeekSchedule week = new WeekSchedule(days);
	 ArrayList<WeekSchedule> sections = new ArrayList<WeekSchedule>();
	 sections.add(week);
	 ClassSection sectionHolder = new ClassSection(sections);
	
	 SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man",
	 sectionHolder);
	
	 ArrayList<SchedulerCourse> classes = new ArrayList<SchedulerCourse>();
	 classes.add(class1);
	
	 Scheduler scheduler = new Scheduler(8, classes);
	
	 assertEquals(0, scheduler.permutateSchedules().size());
	 }
	
	 @Test
	 public void testScheduleOneClassOneHour() {
	 ArrayList<ClassDay> days = WeekSchedule.create7DayArrayList();
	 ArrayList<Integer> hours = new ArrayList<Integer>();
	 hours.add(2);
	 ClassDay day = new ClassDay(hours);
	 days.set(0, day);
	 WeekSchedule week = new WeekSchedule(days);
	 ArrayList<WeekSchedule> sections = new ArrayList<WeekSchedule>();
	 sections.add(week);
	 ClassSection sectionHolder = new ClassSection(sections);
	
	 SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man",
	 sectionHolder);
	
	 ArrayList<SchedulerCourse> classes = new ArrayList<SchedulerCourse>();
	 classes.add(class1);
	
	 Scheduler scheduler = new Scheduler(8, classes);
	
	 assertEquals(1, scheduler.permutateSchedules().size());
	 }
	
	 @Test
	 public void testScheduleOneClassTwoHoursOneSection() {
	
	 ArrayList<ClassDay> days = WeekSchedule.create7DayArrayList();
	 ArrayList<Integer> hours = new ArrayList<Integer>();
	 hours.add(2);
	 hours.add(3);
	 ClassDay day = new ClassDay(hours);
	 days.set(0, day);
	 WeekSchedule week = new WeekSchedule(days);
	 ArrayList<WeekSchedule> sections = new ArrayList<WeekSchedule>();
	 sections.add(week);
	 ClassSection sectionHolder = new ClassSection(sections);
	
	 SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man",
	 sectionHolder);
	
	 ArrayList<SchedulerCourse> classes = new ArrayList<SchedulerCourse>();
	 classes.add(class1);
	
	 Scheduler scheduler = new Scheduler(8, classes);
	
	 assertEquals(1, scheduler.permutateSchedules().size());
	 }
	
	 @Test
	 public void testScheduleTwoClassesWithOneHoursSectionEach() {
	
	 ArrayList<ClassDay> days = WeekSchedule.create7DayArrayList();
	 ArrayList<Integer> hours = new ArrayList<Integer>();
	 hours.add(2);
	 ClassDay day = new ClassDay(hours);
	 days.set(0, day);
	 WeekSchedule week = new WeekSchedule(days);
	 ArrayList<WeekSchedule> sections = new ArrayList<WeekSchedule>();
	 sections.add(week);
	 ClassSection sectionHolder = new ClassSection(sections);
	
	 SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man",
	 sectionHolder);
	
	 ArrayList<ClassDay> days2 = WeekSchedule.create7DayArrayList();
	 ArrayList<Integer> hours2 = new ArrayList<Integer>();
	 hours2.add(3);
	 ClassDay day2 = new ClassDay(hours2);
	 days2.set(0, day2);
	 WeekSchedule week2 = new WeekSchedule(days2);
	 ArrayList<WeekSchedule> sections2 = new ArrayList<WeekSchedule>();
	 sections2.add(week2);
	 ClassSection sectionHolder2 = new ClassSection(sections2);
	
	 SchedulerCourse class2 = new SchedulerCourse("Science", "Mr. Foley",
	 sectionHolder2);
	
	 ArrayList<SchedulerCourse> classes = new ArrayList<SchedulerCourse>();
	 classes.add(class1);
	 classes.add(class2);
	
	 Scheduler scheduler = new Scheduler(8, classes);
	
	 assertEquals(1, scheduler.permutateSchedules().size());
	 }
	
	 @Test
	 public void testScheduleOneClassWithTwoSectionsOfOneHour() {
	
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
	
	 @Test
	 public void testScheduleTwoClassesWithTwoSectionEach() {
	
	 // class 1
	 ArrayList<ClassDay> days11 = WeekSchedule.create7DayArrayList();
	 ArrayList<Integer> hours11 = new ArrayList<Integer>();
	 ArrayList<ClassDay> days12 = WeekSchedule.create7DayArrayList();
	 ArrayList<Integer> hours12 = new ArrayList<Integer>();
	 hours11.add(1);
	 hours12.add(2);
	 ClassDay day11 = new ClassDay(hours11);
	 ClassDay day12 = new ClassDay(hours12);
	 days11.set(0, day11);
	 days12.set(0, day12);
	 WeekSchedule week11 = new WeekSchedule(days11);
	 WeekSchedule week12 = new WeekSchedule(days12);
	 ArrayList<WeekSchedule> sections1 = new ArrayList<WeekSchedule>();
	 sections1.add(week11);
	 sections1.add(week12);
	 ClassSection sectionHolder1 = new ClassSection(sections1);
	
	 SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man",
	 sectionHolder1);
	
	 // class 2
	 ArrayList<ClassDay> days21 = WeekSchedule.create7DayArrayList();
	 ArrayList<Integer> hours21 = new ArrayList<Integer>();
	 ArrayList<ClassDay> days22 = WeekSchedule.create7DayArrayList();
	 ArrayList<Integer> hours22 = new ArrayList<Integer>();
	 hours21.add(3);
	 hours22.add(4);
	 ClassDay day21 = new ClassDay(hours21);
	 ClassDay day22 = new ClassDay(hours22);
	 days21.set(0, day21);
	 days22.set(0, day22);
	 WeekSchedule week21 = new WeekSchedule(days21);
	 WeekSchedule week22 = new WeekSchedule(days22);
	 ArrayList<WeekSchedule> sections2 = new ArrayList<WeekSchedule>();
	 sections2.add(week21);
	 sections2.add(week22);
	 ClassSection sectionHolder2 = new ClassSection(sections2);
	
	 SchedulerCourse class2 = new SchedulerCourse("Science", "Mr. Women",
	 sectionHolder2);
	
	 // input classes
	 ArrayList<SchedulerCourse> classes = new ArrayList<SchedulerCourse>();
	 classes.add(class1);
	 classes.add(class2);
	
	 Scheduler scheduler = new Scheduler(8, classes);
	
	 // Scheduler.printSchedules(scheduler.permutateSchedules());
	 ArrayList<Integer> expected = SchedulerTester.createIntegerList(1, 3,
	 1, 4, 2, 3, 2, 4);
	
	 assertEquals(4, scheduler.permutateSchedules().size());
	 assertEquals(expected,
	 Scheduler.getDayHoursLists(scheduler.permutateSchedules()));
	 }
	
	 @Test
	 public void testScheduleFourClassesWithVaryingSectionsNoOverlap() {
	
	 // class 1
	 ArrayList<ClassDay> days11 = WeekSchedule.create7DayArrayList();
	 ArrayList<Integer> hours11 = new ArrayList<Integer>();
	 ArrayList<ClassDay> days12 = WeekSchedule.create7DayArrayList();
	 ArrayList<Integer> hours12 = new ArrayList<Integer>();
	 ArrayList<ClassDay> days13 = WeekSchedule.create7DayArrayList();
	 ArrayList<Integer> hours13 = new ArrayList<Integer>();
	 hours11.add(1);
	 hours12.add(2);
	 hours13.add(3);
	 ClassDay day11 = new ClassDay(hours11);
	 ClassDay day12 = new ClassDay(hours12);
	 ClassDay day13 = new ClassDay(hours13);
	 days11.set(0, day11);
	 days12.set(0, day12);
	 days13.set(0, day13);
	 WeekSchedule week11 = new WeekSchedule(days11);
	 WeekSchedule week12 = new WeekSchedule(days12);
	 WeekSchedule week13 = new WeekSchedule(days13);
	 ArrayList<WeekSchedule> sections1 = new ArrayList<WeekSchedule>();
	 sections1.add(week11);
	 sections1.add(week12);
	 sections1.add(week13);
	 ClassSection sectionHolder1 = new ClassSection(sections1);
	
	 SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man",
	 sectionHolder1);
	
	 // class 2
	 ArrayList<ClassDay> days21 = WeekSchedule.create7DayArrayList();
	 ArrayList<Integer> hours21 = new ArrayList<Integer>();
	 ArrayList<ClassDay> days22 = WeekSchedule.create7DayArrayList();
	 ArrayList<Integer> hours22 = new ArrayList<Integer>();
	 ArrayList<ClassDay> days23 = WeekSchedule.create7DayArrayList();
	 ArrayList<Integer> hours23 = new ArrayList<Integer>();
	 hours21.add(4);
	 hours22.add(5);
	 hours23.add(6);
	 ClassDay day21 = new ClassDay(hours21);
	 ClassDay day22 = new ClassDay(hours22);
	 ClassDay day23 = new ClassDay(hours23);
	 days21.set(0, day21);
	 days22.set(0, day22);
	 days23.set(0, day23);
	 WeekSchedule week21 = new WeekSchedule(days21);
	 WeekSchedule week22 = new WeekSchedule(days22);
	 WeekSchedule week23 = new WeekSchedule(days23);
	 ArrayList<WeekSchedule> sections2 = new ArrayList<WeekSchedule>();
	 sections2.add(week21);
	 sections2.add(week22);
	 sections2.add(week23);
	 ClassSection sectionHolder2 = new ClassSection(sections2);
	
	 SchedulerCourse class2 = new SchedulerCourse("Math", "Mr. Man",
	 sectionHolder2);
	
	 // class 3
	 ArrayList<ClassDay> days31 = WeekSchedule.create7DayArrayList();
	 ArrayList<Integer> hours31 = new ArrayList<Integer>();
	 ArrayList<ClassDay> days32 = WeekSchedule.create7DayArrayList();
	 ArrayList<Integer> hours32 = new ArrayList<Integer>();
	 hours31.add(7);
	 hours32.add(8);
	 ClassDay day31 = new ClassDay(hours31);
	 ClassDay day32 = new ClassDay(hours32);
	 days31.set(0, day31);
	 days32.set(0, day32);
	 WeekSchedule week31 = new WeekSchedule(days31);
	 WeekSchedule week32 = new WeekSchedule(days32);
	 ArrayList<WeekSchedule> sections3 = new ArrayList<WeekSchedule>();
	 sections3.add(week31);
	 sections3.add(week32);
	 ClassSection sectionHolder3 = new ClassSection(sections3);
	
	 SchedulerCourse class3 = new SchedulerCourse("Math", "Mr. Man",
	 sectionHolder3);
	
	 // class 4
	 ArrayList<ClassDay> days41 = WeekSchedule.create7DayArrayList();
	 ArrayList<Integer> hours41 = new ArrayList<Integer>();
	 hours41.add(9);
	 ClassDay day41 = new ClassDay(hours41);
	 days41.set(0, day41);
	 WeekSchedule week41 = new WeekSchedule(days41);
	 ArrayList<WeekSchedule> sections4 = new ArrayList<WeekSchedule>();
	 sections4.add(week41);
	 ClassSection sectionHolder4 = new ClassSection(sections4);
	
	 SchedulerCourse class4 = new SchedulerCourse("Math", "Mr. Man",
	 sectionHolder4);
	
	 // input classes
	 ArrayList<SchedulerCourse> classes = new ArrayList<SchedulerCourse>();
	 classes.add(class1);
	 classes.add(class2);
	 classes.add(class3);
	 classes.add(class4);
	
	 Scheduler scheduler = new Scheduler(8, classes);
	
	 ArrayList<Integer> expected = SchedulerTester.createIntegerList(1, 4,
	 7, 9, 1, 4, 8, 9, 1, 5, 7, 9, 1, 5, 8, 9, 1, 6, 7, 9, 1, 6, 8,
	 9, 2, 4, 7, 9, 2, 4, 8, 9, 2, 5, 7, 9, 2, 5, 8, 9, 2, 6, 7, 9,
	 2, 6, 8, 9, 3, 4, 7, 9, 3, 4, 8, 9, 3, 5, 7, 9, 3, 5, 8, 9, 3,
	 6, 7, 9, 3, 6, 8, 9);
	
	 assertEquals(18, scheduler.permutateSchedules().size());
	 assertEquals(expected,
	 Scheduler.getDayHoursLists(scheduler.permutateSchedules()));
	 }

	 @Test
	 public void
	 testScheduleFourClassesWithVaryingSectionsWithOverlapSameDayWithMultiHour()
	 {
	
	 // class 1
	 ArrayList<ClassDay> days11 = WeekSchedule.create7DayArrayList();
	 ArrayList<Integer> hours11 = new ArrayList<Integer>();
	 ArrayList<ClassDay> days12 = WeekSchedule.create7DayArrayList();
	 ArrayList<Integer> hours12 = new ArrayList<Integer>();
	 ArrayList<ClassDay> days13 = WeekSchedule.create7DayArrayList();
	 ArrayList<Integer> hours13 = new ArrayList<Integer>();
	 hours11.add(1);
	 hours12.add(2);
	 hours13.add(3);
	 hours13.add(4);
	 ClassDay day11 = new ClassDay(hours11);
	 ClassDay day12 = new ClassDay(hours12);
	 ClassDay day13 = new ClassDay(hours13);
	 days11.set(0, day11);
	 days12.set(0, day12);
	 days13.set(0, day13);
	 WeekSchedule week11 = new WeekSchedule(days11);
	 WeekSchedule week12 = new WeekSchedule(days12);
	 WeekSchedule week13 = new WeekSchedule(days13);
	 ArrayList<WeekSchedule> sections1 = new ArrayList<WeekSchedule>();
	 sections1.add(week11);
	 sections1.add(week12);
	 sections1.add(week13);
	 ClassSection sectionHolder1 = new ClassSection(sections1);
	
	 SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man",
	 sectionHolder1);
	
	 // class 2
	 ArrayList<ClassDay> days21 = WeekSchedule.create7DayArrayList();
	 ArrayList<Integer> hours21 = new ArrayList<Integer>();
	 ArrayList<ClassDay> days22 = WeekSchedule.create7DayArrayList();
	 ArrayList<Integer> hours22 = new ArrayList<Integer>();
	 ArrayList<ClassDay> days23 = WeekSchedule.create7DayArrayList();
	 ArrayList<Integer> hours23 = new ArrayList<Integer>();
	 hours21.add(3);
	 hours22.add(4);
	 hours23.add(7);
	 ClassDay day21 = new ClassDay(hours21);
	 ClassDay day22 = new ClassDay(hours22);
	 ClassDay day23 = new ClassDay(hours23);
	 days21.set(0, day21);
	 days22.set(0, day22);
	 days23.set(0, day23);
	 WeekSchedule week21 = new WeekSchedule(days21);
	 WeekSchedule week22 = new WeekSchedule(days22);
	 WeekSchedule week23 = new WeekSchedule(days23);
	 ArrayList<WeekSchedule> sections2 = new ArrayList<WeekSchedule>();
	 sections2.add(week21);
	 sections2.add(week22);
	 sections2.add(week23);
	 ClassSection sectionHolder2 = new ClassSection(sections2);
	
	 SchedulerCourse class2 = new SchedulerCourse("Math", "Mr. Man",
	 sectionHolder2);
	
	 // class 3
	 ArrayList<ClassDay> days31 = WeekSchedule.create7DayArrayList();
	 ArrayList<Integer> hours31 = new ArrayList<Integer>();
	 ArrayList<ClassDay> days32 = WeekSchedule.create7DayArrayList();
	 ArrayList<Integer> hours32 = new ArrayList<Integer>();
	 hours31.add(7);
	 hours32.add(8);
	 ClassDay day31 = new ClassDay(hours31);
	 ClassDay day32 = new ClassDay(hours32);
	 days31.set(0, day31);
	 days32.set(0, day32);
	 WeekSchedule week31 = new WeekSchedule(days31);
	 WeekSchedule week32 = new WeekSchedule(days32);
	 ArrayList<WeekSchedule> sections3 = new ArrayList<WeekSchedule>();
	 sections3.add(week31);
	 sections3.add(week32);
	 ClassSection sectionHolder3 = new ClassSection(sections3);
	
	 SchedulerCourse class3 = new SchedulerCourse("Math", "Mr. Man",
	 sectionHolder3);
	
	 // class 4
	 ArrayList<ClassDay> days41 = WeekSchedule.create7DayArrayList();
	 ArrayList<Integer> hours41 = new ArrayList<Integer>();
	 hours41.add(9);
	 ClassDay day41 = new ClassDay(hours41);
	 days41.set(0, day41);
	 WeekSchedule week41 = new WeekSchedule(days41);
	 ArrayList<WeekSchedule> sections4 = new ArrayList<WeekSchedule>();
	 sections4.add(week41);
	 ClassSection sectionHolder4 = new ClassSection(sections4);
	
	 SchedulerCourse class4 = new SchedulerCourse("Math", "Mr. Man",
	 sectionHolder4);
	
	 // input classes
	 ArrayList<SchedulerCourse> classes = new ArrayList<SchedulerCourse>();
	 classes.add(class1);
	 classes.add(class2);
	 classes.add(class3);
	 classes.add(class4);
	
	 Scheduler scheduler = new Scheduler(8, classes);
	
	 ArrayList<Integer> expected = SchedulerTester.createIntegerList(1, 3,
	 7, 9, 1, 3, 8, 9, 1, 4, 7, 9, 1, 4, 8, 9, 1, 7, 8, 9, 2, 3, 7,
	 9, 2, 3, 8, 9, 2, 4, 7, 9, 2, 4, 8, 9, 2, 7, 8, 9, 3, 4, 7, 8,
	 9);
	
	 assertEquals(11, scheduler.permutateSchedules().size());
	 assertEquals(expected,
	 Scheduler.getDayHoursLists(scheduler.permutateSchedules()));
	 }
	
	 @Test
	 public void
	 testScheduleFourClassesWithVaryingSectionsWithOverlapSameDayNoResults() {
	
	 // class 1
	 ArrayList<ClassDay> days11 = WeekSchedule.create7DayArrayList();
	 ArrayList<Integer> hours11 = new ArrayList<Integer>();
	 hours11.add(1);
	 hours11.add(2);
	 ClassDay day11 = new ClassDay(hours11);
	 days11.set(0, day11);
	 WeekSchedule week11 = new WeekSchedule(days11);
	 ArrayList<WeekSchedule> sections1 = new ArrayList<WeekSchedule>();
	 sections1.add(week11);
	 ClassSection sectionHolder1 = new ClassSection(sections1);
	
	 SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man",
	 sectionHolder1);
	
	 // class 2
	 ArrayList<ClassDay> days21 = WeekSchedule.create7DayArrayList();
	 ArrayList<Integer> hours21 = new ArrayList<Integer>();
	 hours21.add(2);
	 hours21.add(3);
	 ClassDay day21 = new ClassDay(hours21);
	 days21.set(0, day21);
	 WeekSchedule week21 = new WeekSchedule(days21);
	 ArrayList<WeekSchedule> sections2 = new ArrayList<WeekSchedule>();
	 sections2.add(week21);
	 ClassSection sectionHolder2 = new ClassSection(sections2);
	
	 SchedulerCourse class2 = new SchedulerCourse("Math", "Mr. Man",
	 sectionHolder2);
	
	 // class 3
	 ArrayList<ClassDay> days31 = WeekSchedule.create7DayArrayList();
	 ArrayList<Integer> hours31 = new ArrayList<Integer>();
	 hours31.add(6);
	 hours31.add(7);
	 ClassDay day31 = new ClassDay(hours31);
	 days31.set(0, day31);
	 WeekSchedule week31 = new WeekSchedule(days31);
	 ArrayList<WeekSchedule> sections3 = new ArrayList<WeekSchedule>();
	 sections3.add(week31);
	 ClassSection sectionHolder3 = new ClassSection(sections3);
	
	 SchedulerCourse class3 = new SchedulerCourse("Math", "Mr. Man",
	 sectionHolder3);
	
	 // class 4
	 ArrayList<ClassDay> days41 = WeekSchedule.create7DayArrayList();
	 ArrayList<Integer> hours41 = new ArrayList<Integer>();
	 hours41.add(8);
	 ClassDay day41 = new ClassDay(hours41);
	 days41.set(0, day41);
	 WeekSchedule week41 = new WeekSchedule(days41);
	 ArrayList<WeekSchedule> sections4 = new ArrayList<WeekSchedule>();
	 sections4.add(week41);
	 ClassSection sectionHolder4 = new ClassSection(sections4);
	
	 SchedulerCourse class4 = new SchedulerCourse("Math", "Mr. Man",
	 sectionHolder4);
	
	 // input classes
	 ArrayList<SchedulerCourse> classes = new ArrayList<SchedulerCourse>();
	 classes.add(class1);
	 classes.add(class2);
	 classes.add(class3);
	 classes.add(class4);
	
	 Scheduler scheduler = new Scheduler(8, classes);
	
	 assertEquals(0, scheduler.permutateSchedules().size());
	 }

	@Test
	public void testScheduleFourClassesWithVaryingSectionsWithOverlapDifferentDaysWithMultiHour() {

		// class 1
		ArrayList<ClassDay> days11 = WeekSchedule.create7DayArrayList();
		ArrayList<Integer> hours11 = new ArrayList<Integer>();
		ArrayList<ClassDay> days12 = WeekSchedule.create7DayArrayList();
		ArrayList<Integer> hours12 = new ArrayList<Integer>();
		ArrayList<Integer> hours13 = new ArrayList<Integer>();
		hours11.add(1);
		hours12.add(2);
		hours13.add(2);
		hours13.add(3);
		ClassDay day11 = new ClassDay(hours11);
		ClassDay day12 = new ClassDay(hours12);
		ClassDay day13 = new ClassDay(hours13);
		days11.set(0, day11);
		days11.set(1, day11);
		days11.set(3, day11);
		days12.set(0, day12);
		days12.set(1, day12);
		days12.set(3, day12);
		days12.set(2, day13);
		days11.set(2, day13);
		WeekSchedule week11 = new WeekSchedule(days11);
		WeekSchedule week12 = new WeekSchedule(days12);
		ArrayList<WeekSchedule> sections1 = new ArrayList<WeekSchedule>();
		sections1.add(week11);
		sections1.add(week12);
		ClassSection sectionHolder1 = new ClassSection(sections1);

		SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man",
				sectionHolder1);

		// class 2
		ArrayList<ClassDay> days21 = WeekSchedule.create7DayArrayList();
		ArrayList<Integer> hours21 = new ArrayList<Integer>();
		ArrayList<ClassDay> days22 = WeekSchedule.create7DayArrayList();
		ArrayList<Integer> hours22 = new ArrayList<Integer>();
		ArrayList<ClassDay> days23 = WeekSchedule.create7DayArrayList();
		ArrayList<Integer> hours23 = new ArrayList<Integer>();
		hours21.add(1);
		hours22.add(4);
		hours23.add(7);
		ClassDay day21 = new ClassDay(hours21);
		ClassDay day22 = new ClassDay(hours22);
		ClassDay day23 = new ClassDay(hours23);
		days21.set(0, day21);
		days21.set(1, day21);
		days21.set(3, day21);
		days21.set(4, day21);
		days22.set(0, day22);
		days22.set(1, day22);
		days22.set(3, day22);
		days22.set(4, day22);
		days23.set(0, day23);
		days23.set(1, day23);
		days23.set(3, day23);
		days23.set(4, day23);
		WeekSchedule week21 = new WeekSchedule(days21);
		WeekSchedule week22 = new WeekSchedule(days22);
		WeekSchedule week23 = new WeekSchedule(days23);
		ArrayList<WeekSchedule> sections2 = new ArrayList<WeekSchedule>();
		sections2.add(week21);
		sections2.add(week22);
		sections2.add(week23);
		ClassSection sectionHolder2 = new ClassSection(sections2);

		SchedulerCourse class2 = new SchedulerCourse("Math", "Mr. Man",
				sectionHolder2);

		// class 3
		ArrayList<ClassDay> days31 = WeekSchedule.create7DayArrayList();
		ArrayList<Integer> hours31 = new ArrayList<Integer>();
		ArrayList<ClassDay> days32 = WeekSchedule.create7DayArrayList();
		ArrayList<Integer> hours32 = new ArrayList<Integer>();
		hours31.add(7);
		hours31.add(8);
		hours32.add(8);
		hours32.add(9);
		ClassDay day31 = new ClassDay(hours31);
		ClassDay day32 = new ClassDay(hours32);
		days31.set(0, day31);
		days31.set(1, day31);
		days32.set(0, day32);
		days32.set(1, day32);
		WeekSchedule week31 = new WeekSchedule(days31);
		WeekSchedule week32 = new WeekSchedule(days32);
		ArrayList<WeekSchedule> sections3 = new ArrayList<WeekSchedule>();
		sections3.add(week31);
		sections3.add(week32);
		ClassSection sectionHolder3 = new ClassSection(sections3);

		SchedulerCourse class3 = new SchedulerCourse("Math", "Mr. Man",
				sectionHolder3);

		// class 4
		ArrayList<ClassDay> days41 = WeekSchedule.create7DayArrayList();
		ArrayList<Integer> hours41 = new ArrayList<Integer>();
		ArrayList<ClassDay> days42 = WeekSchedule.create7DayArrayList();
		ArrayList<Integer> hours42 = new ArrayList<Integer>();
		hours41.add(1);
		hours41.add(2);
		hours42.add(5);
		hours42.add(6);
		ClassDay day41 = new ClassDay(hours41);
		ClassDay day42 = new ClassDay(hours42);
		days41.set(2, day41);
		days42.set(2, day42);
		WeekSchedule week41 = new WeekSchedule(days41);
		WeekSchedule week42 = new WeekSchedule(days42);
		ArrayList<WeekSchedule> sections4 = new ArrayList<WeekSchedule>();
		sections4.add(week41);
		sections4.add(week42);
		ClassSection sectionHolder4 = new ClassSection(sections4);

		SchedulerCourse class4 = new SchedulerCourse("Math", "Mr. Man",
				sectionHolder4);

		// input classes
		ArrayList<SchedulerCourse> classes = new ArrayList<SchedulerCourse>();
		classes.add(class1);
		classes.add(class2);
		classes.add(class3);
		classes.add(class4);

		Scheduler scheduler = new Scheduler(8, classes);

		ArrayList<Integer> expected = SchedulerTester.createIntegerList(1, 1,
				2, 3, 1, 4, 4, 4, 4, 7, 8, 7, 8, 5, 6, 1, 1, 2, 3, 1, 4, 4, 4,
				4, 8, 9, 8, 9, 5, 6, 1, 1, 2, 3, 1, 7, 7, 7, 7, 8, 9, 8, 9, 5,
				6, 2, 2, 2, 3, 2, 1, 1, 1, 1, 7, 8, 7, 8, 5, 6, 2, 2, 2, 3, 2,
				1, 1, 1, 1, 8, 9, 8, 9, 5, 6, 2, 2, 2, 3, 2, 4, 4, 4, 4, 7, 8,
				7, 8, 5, 6, 2, 2, 2, 3, 2, 4, 4, 4, 4, 8, 9, 8, 9, 5, 6, 2, 2,
				2, 3, 2, 7, 7, 7, 7, 8, 9, 8, 9, 5, 6);

		assertEquals(8, scheduler.permutateSchedules().size());
		assertEquals(expected,
				Scheduler.getDayHoursLists(scheduler.permutateSchedules()));
	}

	public static ArrayList<Integer> createIntegerList(int... ints) {
		ArrayList<Integer> intList = new ArrayList<Integer>();
		for (int i : ints) {
			intList.add(i);
		}
		return intList;

	}
}