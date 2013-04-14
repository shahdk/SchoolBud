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

	@Test
	public void testSetGetScheduleHours() {
 
		ArrayList<ClassDay> days = ClassSection.create7DayArrayList();
		ArrayList<Integer> hours = new ArrayList<Integer>();
		hours.add(1);
		hours.add(5);
		ClassDay day = new ClassDay(hours);
		days.set(0, day);
		ClassSection section = new ClassSection("Mr. John", days);
		ArrayList<ClassSection> sections = new ArrayList<ClassSection>();
		sections.add(section);

		SchedulerCourse class1 = new SchedulerCourse("Math", sections, false);
		assertEquals(class1.getSections(), sections);

		SchedulerCourse class2 = new SchedulerCourse("Physics", null, false);
		class2.setSections(class1.getSections());
		assertEquals(class2.getSections(), sections);

	}

	@Test
	public void testTeacher() {

		ArrayList<ClassDay> days = ClassSection.create7DayArrayList();
		ArrayList<Integer> hours = new ArrayList<Integer>();
		hours.add(1);
		hours.add(5);
		ClassDay day = new ClassDay(hours);
		days.set(0, day);
		ClassSection section = new ClassSection("Mr. Mackey", days);
		ArrayList<ClassSection> sections = new ArrayList<ClassSection>();
		sections.add(section);

		SchedulerCourse class1 = new SchedulerCourse("Math", sections, false);
		
		assertEquals(class1.getSections().get(0).getTeacher(), "Mr. Mackey");
		class1.getSections().get(0).setTeacher("Mrs. Lady");
		assertEquals(class1.getSections().get(0).getTeacher(), "Mrs. Lady");

	}
}
