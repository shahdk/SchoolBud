import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;


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
	
//	@Test
//	public void testName() {
//		ArrayList<Integer> hours1 = new ArrayList<Integer>();
//		
//		hours1.add(1);
//		hours1.add(3);
//		hours1.add(6);
//		
//		ArrayList<ArrayList<Integer>> sched = SchedulerCourseTester.createInitialized7DayList();
//		sched.set(2, hours1);
//
//		SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man", sched);
//		
//		assertEquals(class1.getCourseName(), "Math");
//		class1.setName("Physics");
//		assertEquals(class1.getCourseName(), "Physics");
//		
//	}
//	
//	@Test
//	public void testTeacher() {
//		ArrayList<Integer> hours1 = new ArrayList<Integer>();
//		 
//		hours1.add(1);
//		hours1.add(3);
//		hours1.add(6);
//		
//		ArrayList<ArrayList<Integer>> sched = SchedulerCourseTester.createInitialized7DayList();
//		sched.set(2, hours1);
//
//		SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man", sched);
//		
//		assertEquals(class1.getTeacher(), "Mr. Man");
//		class1.setTeacher("Mrs. Lady");
//		assertEquals(class1.getTeacher(), "Mrs. Lady");
//		
//	}
//	
//	@Test
//	public void testHours() {
//ArrayList<Integer> hours1 = new ArrayList<Integer>();
//		
//		hours1.add(1);
//		hours1.add(3);
//		hours1.add(6);
//		
//		ArrayList<ArrayList<Integer>> sched = SchedulerCourseTester.createInitialized7DayList();
//		sched.set(2, hours1);
//
//		SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man", sched);
//		
//		assertEquals(class1.getScheduleHours(), sched);
//		assertEquals(class1.getScheduleHours().get(2), hours1);
//		
//		ArrayList<Integer> hours2 = new ArrayList<Integer>();
//		hours2.add(9);
//		hours2.add(12);
//	
//		sched.set(3,hours2);
//		
//		SchedulerCourse class2 = new SchedulerCourse("Physics", "Mr. Mown", sched);
//		
//		assertEquals(class2.getScheduleHours(), sched);
//		assertEquals(class2.getScheduleHours().get(2), hours1);
//		assertEquals(class2.getScheduleHours().get(3), hours2);
//
//	}
//	
//	public static ArrayList<ArrayList<Integer>> createInitialized7DayList() {
//		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
//		
//		for (int i = 0;  i < 7; i++) {
//			list.add(new ArrayList<Integer>());
//		}
//		
//		return list;
//	}

}
