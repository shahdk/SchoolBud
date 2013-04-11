import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;


/* Tests the CLASS class */

public class SchedulerCourseTester {

	@Test
	public void test() {
		assertTrue(true);
	}
	
	@Test
	public void testClassInitializationEcceptionForInvalidArrayListLength() {
		
		boolean caught = false;
		
		try {
			new SchedulerCourse("name", "teacher", new ArrayList<ClassDay>());
		}
		catch (InstantiationError e) {
			caught = true;
		}
		
		assertTrue(caught);
	}
	
	@Test
	public void testName() {
		ArrayList<Integer> hours1 = new ArrayList<Integer>();
		
		hours1.add(1);
		
		ClassDay day = new ClassDay(hours1);
		
		ArrayList<ClassDay> sched = SchedulerCourseTester.createInitialized7DayList();
		sched.set(2, day);

		SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man", sched);
		
		assertEquals(class1.getCourseName(), "Math");
		class1.setName("Physics");
		assertEquals(class1.getCourseName(), "Physics");
		
	}
	
	@Test
	public void testSetScheduleHours() {
		ArrayList<Integer> hours1 = new ArrayList<Integer>();
		hours1.add(1);
		ClassDay day = new ClassDay(hours1);
		ArrayList<ClassDay> sched = SchedulerCourseTester.createInitialized7DayList();
		sched.set(2, day);
		SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man", sched);
		assertEquals(class1.getScheduleHours(), sched);
		
		ArrayList<Integer> hours2 = new ArrayList<Integer>();
		hours1.add(3);
		ClassDay day2 = new ClassDay(hours2);
		
		ArrayList<ClassDay> sched2 = SchedulerCourseTester.createInitialized7DayList();
		sched2.set(3, day2);

		class1.setScheduleHours(sched2);
		
		assertEquals(class1.getScheduleHours(), sched2);
		
		
	}
	
	@Test
	public void testTeacher() {
		ArrayList<Integer> hours1 = new ArrayList<Integer>();
		
		hours1.add(1);
		
		ClassDay day = new ClassDay(hours1);
		
		ArrayList<ClassDay> sched = SchedulerCourseTester.createInitialized7DayList();
		sched.set(2, day);

		SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man", sched);
		
		assertEquals(class1.getTeacher(), "Mr. Man");
		class1.setTeacher("Mrs. Lady");
		assertEquals(class1.getTeacher(), "Mrs. Lady");
		
	}
	
	@Test
	public void testExceptionForNon7DaysEntry(){
		boolean caught = false;
		ArrayList<Integer> hours1 = new ArrayList<Integer>();
		hours1.add(1);

		ClassDay day = new ClassDay(hours1);
		
		ArrayList<ClassDay> sched = new ArrayList<ClassDay>();

		try {
			SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man", sched);
		}
		catch (InstantiationError e) {
			caught = true;
		}
		
		assertTrue(caught);
	}
	
	@Test
	public void testHours() {
		ArrayList<Integer> hours1 = new ArrayList<Integer>();
		hours1.add(1);

		ClassDay day = new ClassDay(hours1);
		
		ArrayList<ClassDay> sched = SchedulerCourseTester.createInitialized7DayList();
		sched.set(2, day);

		SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man", sched);
		
		assertEquals(class1.getScheduleHours(), sched);
		assertEquals(class1.getScheduleHours().get(2), day);
		
		ArrayList<Integer> hours2 = new ArrayList<Integer>();
		hours1.add(3);

		ClassDay day2 = new ClassDay(hours2);
		
		sched.set(3, day2);

		SchedulerCourse class2 = new SchedulerCourse("Math", "Mr. Man", sched);
		
		assertEquals(class2.getScheduleHours(), sched);
		assertEquals(class1.getScheduleHours().get(2), day);
		assertEquals(class2.getScheduleHours().get(3), day2);

	}
	
	public static ArrayList<ClassDay> createInitialized7DayList() {
		ArrayList<ClassDay> list = new ArrayList<ClassDay>();
		
		for (int i = 0;  i < 7; i++) {
			list.add(new ClassDay(new ArrayList<Integer>()));
		}
		
		return list;
	}

}
