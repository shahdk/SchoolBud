import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class SchedulerTester {

	// @Test
	// public void test() {
	// assertTrue(true);
	// }
	//
	// @Test
	// public void testInitialize() {
	//
	// ArrayList<ClassDay> days = ClassSection.create7DayArrayList();
	// ArrayList<Integer> hours = new ArrayList<Integer>();
	// hours.add(1);
	// hours.add(5);
	// ClassDay day = new ClassDay(hours);
	// days.set(0, day);
	// ClassSection section = new ClassSection("Mr. Man", days);
	// ArrayList<ClassSection> sections = new ArrayList<ClassSection>();
	// sections.add(section);
	//
	// SchedulerCourse class1 = new SchedulerCourse("Math", sections, false);
	//
	// ArrayList<SchedulerCourse> classes = new ArrayList<SchedulerCourse>();
	// classes.add(class1);
	//
	// Scheduler sched = new Scheduler(5, classes);
	// assertNotNull(sched);
	//
	// // test filtering is not null
	// assertNotNull(sched.getFilteredSchedules());
	// assertNotNull(sched.filterGaps(2, 2, true, null));
	// }
	//
	// @Test
	// public void testScheduleEmptyClasses() {
	//
	// Scheduler scheduler = new Scheduler(5, new ArrayList<SchedulerCourse>());
	//
	// assertEquals(new ArrayList<ArrayList<ArrayList<SchedulerCourse>>>(),
	// scheduler.permutateSchedules());
	//
	// // test empty filtering schedules
	// assertEquals(new ArrayList<ArrayList<ArrayList<SchedulerCourse>>>(),
	// scheduler.filterGaps(2, 2, true, null));
	// }
	//
	// @Test
	// public void testScheduleOneClassZeroHours() {
	//
	// ArrayList<ClassDay> days = ClassSection.create7DayArrayList();
	// ArrayList<Integer> hours = new ArrayList<Integer>();
	// ClassDay day = new ClassDay(hours);
	// days.set(0, day);
	// ClassSection section = new ClassSection("Mr. Man", days);
	// ArrayList<ClassSection> sections = new ArrayList<ClassSection>();
	// sections.add(section);
	//
	// SchedulerCourse class1 = new SchedulerCourse("Math", sections, false);
	//
	// ArrayList<SchedulerCourse> classes = new ArrayList<SchedulerCourse>();
	// classes.add(class1);
	//
	// Scheduler scheduler = new Scheduler(8, classes);
	//
	// assertEquals(0, scheduler.permutateSchedules().size());
	//
	// // test filters
	// assertEquals(0, scheduler.filterGaps(2, 2, true, null).size());
	// }
	//
	// @Test
	// public void testScheduleOneClassOneHour() {
	// ArrayList<ClassDay> days = ClassSection.create7DayArrayList();
	// ArrayList<Integer> hours = new ArrayList<Integer>();
	// hours.add(2);
	// ClassDay day = new ClassDay(hours);
	// days.set(0, day);
	// ClassSection section = new ClassSection("Mr. Man", days);
	// ArrayList<ClassSection> sections = new ArrayList<ClassSection>();
	// sections.add(section);
	//
	// SchedulerCourse class1 = new SchedulerCourse("Math", sections, false);
	//
	// ArrayList<SchedulerCourse> classes = new ArrayList<SchedulerCourse>();
	// classes.add(class1);
	//
	// Scheduler scheduler = new Scheduler(8, classes);
	//
	// assertEquals(1, scheduler.permutateSchedules().size());
	//
	// // test filters
	//
	// // test gaps filter - should not be able to filter anything with just
	// // one class
	// assertEquals(1, scheduler.filterGaps(2, 2, true, null).size());
	// }
	//
	// @Test
	// public void testScheduleOneClassTwoHoursOneSection() {
	//
	// ArrayList<ClassDay> days = ClassSection.create7DayArrayList();
	// ArrayList<Integer> hours = new ArrayList<Integer>();
	// hours.add(2);
	// hours.add(5);
	// ClassDay day = new ClassDay(hours);
	// days.set(0, day);
	// ClassSection section = new ClassSection("Mr. Man", days);
	// ArrayList<ClassSection> sections = new ArrayList<ClassSection>();
	// sections.add(section);
	//
	// SchedulerCourse class1 = new SchedulerCourse("Math", sections, false);
	//
	// ArrayList<SchedulerCourse> classes = new ArrayList<SchedulerCourse>();
	// classes.add(class1);
	//
	// Scheduler scheduler = new Scheduler(8, classes);
	//
	// assertEquals(1, scheduler.permutateSchedules().size());
	//
	// // test filters
	//
	// // test gaps filter - with only 2 Gaps allowed (exact) --> 1 answer
	// assertEquals(1, scheduler.filterGaps(2, 1, false, null).size());
	// // test gaps filter - with 4 Gaps max but less allowed) --> 1 answer
	// assertEquals(1, scheduler.filterGaps(4, 1, true, null).size());
	// // test gaps filter - with 4 Gaps Only) --> 0 answers
	// assertEquals(0, scheduler.filterGaps(4, 1, false, null).size());
	//
	// }
	//
	// @Test
	// public void testScheduleTwoClassesWithOneHoursSectionEach() {
	//
	// ArrayList<ClassDay> days = ClassSection.create7DayArrayList();
	// ArrayList<Integer> hours = new ArrayList<Integer>();
	// hours.add(2);
	// ClassDay day = new ClassDay(hours);
	// days.set(0, day);
	// ClassSection section = new ClassSection("Mr. Man", days);
	// ArrayList<ClassSection> sections = new ArrayList<ClassSection>();
	// sections.add(section);
	//
	// SchedulerCourse class1 = new SchedulerCourse("Math", sections, false);
	//
	// ArrayList<ClassDay> days2 = ClassSection.create7DayArrayList();
	// ArrayList<Integer> hours2 = new ArrayList<Integer>();
	// hours2.add(3);
	// ClassDay day2 = new ClassDay(hours2);
	// days2.set(0, day2);
	// ClassSection section2 = new ClassSection("Mr. Moon", days2);
	// ArrayList<ClassSection> sections2 = new ArrayList<ClassSection>();
	// sections2.add(section2);
	//
	// SchedulerCourse class2 = new SchedulerCourse("Science", sections2,
	// false);
	//
	// ArrayList<SchedulerCourse> classes = new ArrayList<SchedulerCourse>();
	// classes.add(class1);
	// classes.add(class2);
	//
	// Scheduler scheduler = new Scheduler(8, classes);
	//
	// assertEquals(1, scheduler.permutateSchedules().size());
	// }
	//
	// @Test
	// public void testScheduleOneClassWithTwoSectionsOfOneHour() {
	//
	// ArrayList<ClassDay> days = ClassSection.create7DayArrayList();
	// ArrayList<Integer> hours = new ArrayList<Integer>();
	// ArrayList<ClassDay> days2 = ClassSection.create7DayArrayList();
	// ArrayList<Integer> hours2 = new ArrayList<Integer>();
	// hours.add(2);
	// hours2.add(4);
	// ClassDay day = new ClassDay(hours);
	// ClassDay day2 = new ClassDay(hours2);
	// days.set(0, day);
	// days2.set(0, day2);
	// ClassSection section = new ClassSection("Mr. Man", days);
	// ClassSection section2 = new ClassSection("Mr. Moose", days2);
	// ArrayList<ClassSection> sections = new ArrayList<ClassSection>();
	// sections.add(section);
	// sections.add(section2);
	//
	// SchedulerCourse class1 = new SchedulerCourse("Math", sections, false);
	//
	// ArrayList<SchedulerCourse> classes = new ArrayList<SchedulerCourse>();
	// classes.add(class1);
	//
	// Scheduler scheduler = new Scheduler(8, classes);
	//
	// assertEquals(2, scheduler.permutateSchedules().size());
	// assertEquals(1, scheduler.permutateSchedules().get(0).size());
	// assertEquals(1, scheduler.permutateSchedules().get(1).size());
	// assertEquals(hours, scheduler.permutateSchedules().get(0).get(0)
	// .getSections().get(0).getClassDays().get(0).getHourSlots());
	// }

	@Test
	public void testScheduleTwoClassesWithTwoSectionEach() {

		// class 1
		ArrayList<ClassDay> days11 = ClassSection.create7DayArrayList();
		ArrayList<Integer> hours11 = new ArrayList<Integer>();
		ArrayList<ClassDay> days12 = ClassSection.create7DayArrayList();
		ArrayList<Integer> hours12 = new ArrayList<Integer>();
		hours11.add(1);
		hours12.add(4);
		ClassDay day11 = new ClassDay(hours11);
		ClassDay day12 = new ClassDay(hours12);
		days11.set(0, day11);
		days12.set(0, day12);
		ClassSection section11 = new ClassSection("Mr. Man", days11);
		ClassSection section12 = new ClassSection("Mr. Moose", days12);
		ArrayList<ClassSection> sections1 = new ArrayList<ClassSection>();
		sections1.add(section11);
		sections1.add(section12);

		SchedulerCourse class1 = new SchedulerCourse("Math", sections1, false);

		// class 2
		ArrayList<ClassDay> days21 = ClassSection.create7DayArrayList();
		ArrayList<Integer> hours21 = new ArrayList<Integer>();
		ArrayList<ClassDay> days22 = ClassSection.create7DayArrayList();
		ArrayList<Integer> hours22 = new ArrayList<Integer>();
		hours21.add(6);
		hours22.add(8);
		ClassDay day21 = new ClassDay(hours21);
		ClassDay day22 = new ClassDay(hours22);
		days21.set(0, day21);
		days22.set(0, day22);
		ClassSection section21 = new ClassSection("Mr. Manny", days21);
		ClassSection section22 = new ClassSection("Mr. Maoon", days22);
		ArrayList<ClassSection> sections2 = new ArrayList<ClassSection>();
		sections2.add(section21);
		sections2.add(section22);

		SchedulerCourse class2 = new SchedulerCourse("Science", sections2,
				false);

		// input classes
		ArrayList<SchedulerCourse> classes = new ArrayList<SchedulerCourse>();
		classes.add(class1);
		classes.add(class2);

		Scheduler scheduler = new Scheduler(8, classes);

		ArrayList<Integer> expected = SchedulerTester.createIntegerList(1, 6,
				1, 8, 4, 6, 4, 8);

		assertEquals(4, scheduler.permutateSchedules().size());
		assertEquals(expected,
				Scheduler.getDayHoursLists(scheduler.permutateSchedules()));

		// test filters

		// test gaps filter - with only 1 Gaps allowed (exact) --> 1 answer
		assertEquals(1, scheduler.filterGaps(1, 1, false, null).size());
		// test gaps filter - with 4 Gaps max but less allowed) --> 3 answer
		scheduler.permutateSchedules();
		assertEquals(3, scheduler.filterGaps(4, 1, true, null).size());
		// test gaps filter - with 3 Gaps Only) --> 1 answers
		scheduler.permutateSchedules();
		assertEquals(1, scheduler.filterGaps(3, 1, false, null).size());
		assertEquals(SchedulerTester.createIntegerList(4, 8),
				Scheduler.getDayHoursLists(scheduler.getFilteredSchedules()));
	}

	@Test
	public void testScheduleFourClassesWithVaryingSectionsNoOverlap() {

		// class 1
		ArrayList<ClassDay> days11 = ClassSection.create7DayArrayList();
		ArrayList<Integer> hours11 = new ArrayList<Integer>();
		ArrayList<ClassDay> days12 = ClassSection.create7DayArrayList();
		ArrayList<Integer> hours12 = new ArrayList<Integer>();
		ArrayList<ClassDay> days13 = ClassSection.create7DayArrayList();
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
		ClassSection section11 = new ClassSection("Mr. Man", days11);
		ClassSection section12 = new ClassSection("Mr. Moon", days12);
		ClassSection section13 = new ClassSection("Mr. Mice", days13);
		ArrayList<ClassSection> sections1 = new ArrayList<ClassSection>();
		sections1.add(section11);
		sections1.add(section12);
		sections1.add(section13);

		SchedulerCourse class1 = new SchedulerCourse("Math", sections1, false);

		// class 2
		ArrayList<ClassDay> days21 = ClassSection.create7DayArrayList();
		ArrayList<Integer> hours21 = new ArrayList<Integer>();
		ArrayList<ClassDay> days22 = ClassSection.create7DayArrayList();
		ArrayList<Integer> hours22 = new ArrayList<Integer>();
		ArrayList<ClassDay> days23 = ClassSection.create7DayArrayList();
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
		ClassSection section21 = new ClassSection("Mr. Marn", days21);
		ClassSection section22 = new ClassSection("Mr. Maun", days22);
		ClassSection section23 = new ClassSection("Mr. Man", days23);
		ArrayList<ClassSection> sections2 = new ArrayList<ClassSection>();
		sections2.add(section21);
		sections2.add(section22);
		sections2.add(section23);

		SchedulerCourse class2 = new SchedulerCourse("Math", sections2, false);

		// class 3
		ArrayList<ClassDay> days31 = ClassSection.create7DayArrayList();
		ArrayList<Integer> hours31 = new ArrayList<Integer>();
		ArrayList<ClassDay> days32 = ClassSection.create7DayArrayList();
		ArrayList<Integer> hours32 = new ArrayList<Integer>();
		hours31.add(7);
		hours32.add(8);
		ClassDay day31 = new ClassDay(hours31);
		ClassDay day32 = new ClassDay(hours32);
		days31.set(0, day31);
		days32.set(0, day32);
		ClassSection section31 = new ClassSection("Mr. Mask", days31);
		ClassSection section32 = new ClassSection("Mr. Face", days32);
		ArrayList<ClassSection> sections3 = new ArrayList<ClassSection>();
		sections3.add(section31);
		sections3.add(section32);

		SchedulerCourse class3 = new SchedulerCourse("Math", sections3, false);

		// class 4
		ArrayList<ClassDay> days41 = ClassSection.create7DayArrayList();
		ArrayList<Integer> hours41 = new ArrayList<Integer>();
		hours41.add(9);
		ClassDay day41 = new ClassDay(hours41);
		days41.set(0, day41);
		ClassSection section41 = new ClassSection("Mr. Jack", days41);
		ArrayList<ClassSection> sections4 = new ArrayList<ClassSection>();
		sections4.add(section41);

		SchedulerCourse class4 = new SchedulerCourse("Math", sections4, false);

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
	public void testScheduleFourClassesWithVaryingSectionsWithOverlapSameDayWithMultiHour() {

		// class 1
		ArrayList<ClassDay> days11 = ClassSection.create7DayArrayList();
		ArrayList<Integer> hours11 = new ArrayList<Integer>();
		ArrayList<ClassDay> days12 = ClassSection.create7DayArrayList();
		ArrayList<Integer> hours12 = new ArrayList<Integer>();
		ArrayList<ClassDay> days13 = ClassSection.create7DayArrayList();
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
		ClassSection section11 = new ClassSection("Mr. Man", days11);
		ClassSection section12 = new ClassSection("Mr. Mark", days12);
		ClassSection section13 = new ClassSection("Mr. Manny", days13);
		ArrayList<ClassSection> sections1 = new ArrayList<ClassSection>();
		sections1.add(section11);
		sections1.add(section12);
		sections1.add(section13);

		SchedulerCourse class1 = new SchedulerCourse("Math", sections1, false);

		// class 2
		ArrayList<ClassDay> days21 = ClassSection.create7DayArrayList();
		ArrayList<Integer> hours21 = new ArrayList<Integer>();
		ArrayList<ClassDay> days22 = ClassSection.create7DayArrayList();
		ArrayList<Integer> hours22 = new ArrayList<Integer>();
		ArrayList<ClassDay> days23 = ClassSection.create7DayArrayList();
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
		ClassSection section21 = new ClassSection("Mr. Man", days21);
		ClassSection section22 = new ClassSection("Mr. Mike", days22);
		ClassSection section23 = new ClassSection("Mr. John", days23);
		ArrayList<ClassSection> sections2 = new ArrayList<ClassSection>();
		sections2.add(section21);
		sections2.add(section22);
		sections2.add(section23);

		SchedulerCourse class2 = new SchedulerCourse("Math", sections2, false);

		// class 3
		ArrayList<ClassDay> days31 = ClassSection.create7DayArrayList();
		ArrayList<Integer> hours31 = new ArrayList<Integer>();
		ArrayList<ClassDay> days32 = ClassSection.create7DayArrayList();
		ArrayList<Integer> hours32 = new ArrayList<Integer>();
		hours31.add(7);
		hours32.add(8);
		ClassDay day31 = new ClassDay(hours31);
		ClassDay day32 = new ClassDay(hours32);
		days31.set(0, day31);
		days32.set(0, day32);
		ClassSection section31 = new ClassSection("Mr. Mask", days31);
		ClassSection section32 = new ClassSection("Mr. Faces", days32);
		ArrayList<ClassSection> sections3 = new ArrayList<ClassSection>();
		sections3.add(section31);
		sections3.add(section32);

		SchedulerCourse class3 = new SchedulerCourse("Math", sections3, false);

		// class 4
		ArrayList<ClassDay> days41 = ClassSection.create7DayArrayList();
		ArrayList<Integer> hours41 = new ArrayList<Integer>();
		hours41.add(9);
		ClassDay day41 = new ClassDay(hours41);
		days41.set(0, day41);
		ClassSection section41 = new ClassSection("Mr. Mark", days41);
		ArrayList<ClassSection> sections4 = new ArrayList<ClassSection>();
		sections4.add(section41);

		SchedulerCourse class4 = new SchedulerCourse("Math", sections4, false);

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
	public void testScheduleFourClassesWithVaryingSectionsWithOverlapSameDayNoResults() {

		// class 1
		ArrayList<ClassDay> days11 = ClassSection.create7DayArrayList();
		ArrayList<Integer> hours11 = new ArrayList<Integer>();
		hours11.add(1);
		hours11.add(2);
		ClassDay day11 = new ClassDay(hours11);
		days11.set(0, day11);
		ClassSection section11 = new ClassSection("Mr. Man", days11);
		ArrayList<ClassSection> sections1 = new ArrayList<ClassSection>();
		sections1.add(section11);

		SchedulerCourse class1 = new SchedulerCourse("Math", sections1, false);

		// class 2
		ArrayList<ClassDay> days21 = ClassSection.create7DayArrayList();
		ArrayList<Integer> hours21 = new ArrayList<Integer>();
		hours21.add(2);
		hours21.add(3);
		ClassDay day21 = new ClassDay(hours21);
		days21.set(0, day21);
		ClassSection section21 = new ClassSection("Mr. Ike", days21);
		ArrayList<ClassSection> sections2 = new ArrayList<ClassSection>();
		sections2.add(section21);

		SchedulerCourse class2 = new SchedulerCourse("Math", sections2, false);

		// class 3
		ArrayList<ClassDay> days31 = ClassSection.create7DayArrayList();
		ArrayList<Integer> hours31 = new ArrayList<Integer>();
		hours31.add(6);
		hours31.add(7);
		ClassDay day31 = new ClassDay(hours31);
		days31.set(0, day31);
		ClassSection section31 = new ClassSection("Mr. Mad", days31);
		ArrayList<ClassSection> sections3 = new ArrayList<ClassSection>();
		sections3.add(section31);

		SchedulerCourse class3 = new SchedulerCourse("Math", sections3, false);

		// class 4
		ArrayList<ClassDay> days41 = ClassSection.create7DayArrayList();
		ArrayList<Integer> hours41 = new ArrayList<Integer>();
		hours41.add(8);
		ClassDay day41 = new ClassDay(hours41);
		days41.set(0, day41);
		ClassSection section41 = new ClassSection("Mr. Much", days41);
		ArrayList<ClassSection> sections4 = new ArrayList<ClassSection>();
		sections4.add(section41);

		SchedulerCourse class4 = new SchedulerCourse("Math", sections4, false);

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
		ArrayList<ClassDay> days11 = ClassSection.create7DayArrayList();
		ArrayList<Integer> hours11 = new ArrayList<Integer>();
		ArrayList<ClassDay> days12 = ClassSection.create7DayArrayList();
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
		ClassSection section11 = new ClassSection("Mr. Man", days11);
		ClassSection section12 = new ClassSection("Mr. Manny", days12);
		ArrayList<ClassSection> sections1 = new ArrayList<ClassSection>();
		sections1.add(section11);
		sections1.add(section12);

		SchedulerCourse class1 = new SchedulerCourse("Math", sections1, false);

		// class 2
		ArrayList<ClassDay> days21 = ClassSection.create7DayArrayList();
		ArrayList<Integer> hours21 = new ArrayList<Integer>();
		ArrayList<ClassDay> days22 = ClassSection.create7DayArrayList();
		ArrayList<Integer> hours22 = new ArrayList<Integer>();
		ArrayList<ClassDay> days23 = ClassSection.create7DayArrayList();
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
		ClassSection section21 = new ClassSection("Mr. Moose", days21);
		ClassSection section22 = new ClassSection("Mr. Mucher", days22);
		ClassSection section23 = new ClassSection("Mr. Moocher", days23);
		ArrayList<ClassSection> sections2 = new ArrayList<ClassSection>();
		sections2.add(section21);
		sections2.add(section22);
		sections2.add(section23);

		SchedulerCourse class2 = new SchedulerCourse("Math", sections2, false);

		// class 3
		ArrayList<ClassDay> days31 = ClassSection.create7DayArrayList();
		ArrayList<Integer> hours31 = new ArrayList<Integer>();
		ArrayList<ClassDay> days32 = ClassSection.create7DayArrayList();
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
		ClassSection section31 = new ClassSection("Mr. Mike", days31);
		ClassSection section32 = new ClassSection("Mr. Sike", days32);
		ArrayList<ClassSection> sections3 = new ArrayList<ClassSection>();
		sections3.add(section31);
		sections3.add(section32);

		SchedulerCourse class3 = new SchedulerCourse("Math", sections3, false);

		// class 4
		ArrayList<ClassDay> days41 = ClassSection.create7DayArrayList();
		ArrayList<Integer> hours41 = new ArrayList<Integer>();
		ArrayList<ClassDay> days42 = ClassSection.create7DayArrayList();
		ArrayList<Integer> hours42 = new ArrayList<Integer>();
		hours41.add(1);
		hours41.add(2);
		hours42.add(5);
		hours42.add(6);
		ClassDay day41 = new ClassDay(hours41);
		ClassDay day42 = new ClassDay(hours42);
		days41.set(2, day41);
		days42.set(2, day42);
		ClassSection section41 = new ClassSection("Mr. Bike", days41);
		ClassSection section42 = new ClassSection("Mr. Like", days42);
		ArrayList<ClassSection> sections4 = new ArrayList<ClassSection>();
		sections4.add(section41);
		sections4.add(section42);

		SchedulerCourse class4 = new SchedulerCourse("Math", sections4, false);

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