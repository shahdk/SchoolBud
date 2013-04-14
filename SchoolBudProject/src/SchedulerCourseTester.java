import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

/* Tests the CLASS class */

public class SchedulerCourseTester {

	@Test
	public void testName() {
		ArrayList<ClassDay> days = ClassSection.create7DayArrayList();
		ArrayList<Integer> hours = new ArrayList<Integer>();
		hours.add(1);
		hours.add(5);
		ClassDay day = new ClassDay(hours);
		days.set(0, day);
		ClassSection section = new ClassSection("Mr. Davis", days);
		ArrayList<ClassSection> sections = new ArrayList<ClassSection>();
		sections.add(section);

		SchedulerCourse class1 = new SchedulerCourse("Math", sections, false);

		assertEquals(class1.getCourseName(), "Math");
		class1.setName("Physics");
		assertEquals(class1.getCourseName(), "Physics");

	}

//	@Test
//	public void testSetGetScheduleHours() {
// 
//		ArrayList<ClassDay> days = WeekSchedule.create7DayArrayList();
//		ArrayList<Integer> hours = new ArrayList<Integer>();
//		hours.add(1);
//		hours.add(5);
//		ClassDay day = new ClassDay(hours);
//		days.set(0, day);
//		WeekSchedule week = new WeekSchedule(days);
//		ArrayList<WeekSchedule> sections = new ArrayList<WeekSchedule>();
//		sections.add(week);
//		ClassSection sectionHolder = new ClassSection(sections);
//
//		SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man",
//				sectionHolder);
//		assertEquals(class1.getSections(), sectionHolder);
//
//		SchedulerCourse class2 = new SchedulerCourse("Physics", "Mr. Much",
//				null);
//		class2.setSections(class1.getSections());
//		assertEquals(class2.getSections(), sectionHolder);
//
//	}
//
//	@Test
//	public void testTeacher() {
//
//		ArrayList<ClassDay> days = WeekSchedule.create7DayArrayList();
//		ArrayList<Integer> hours = new ArrayList<Integer>();
//		hours.add(1);
//		hours.add(5);
//		ClassDay day = new ClassDay(hours);
//		days.set(0, day);
//		WeekSchedule week = new WeekSchedule(days);
//		ArrayList<WeekSchedule> sections = new ArrayList<WeekSchedule>();
//		sections.add(week);
//		ClassSection sectionHolder = new ClassSection(sections);
//
//		SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man", sectionHolder);
//		assertEquals(class1.getTeacher(), "Mr. Man");
//		class1.setTeacher("Mrs. Lady");
//		assertEquals(class1.getTeacher(), "Mrs. Lady");
//
//	}
}
