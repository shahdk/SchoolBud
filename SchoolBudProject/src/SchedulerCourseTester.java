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
	public void testClassInitialization() {
		//assertNotNull(new SchedulerCourse("name", "teacher", new Array<ArrayList<Integer>>()));
	}
	
	@Test
	public void testName() {
		ArrayList<Integer> hours1 = new ArrayList<Integer>();
		
		hours1.add(1);
		hours1.add(3);
		hours1.add(6);
		
		ArrayList<ArrayList<Integer>> sched = new ArrayList<ArrayList<Integer>>();
		sched.add(hours1);
		
		SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man", sched);
		
		assertEquals(class1.getCourseName(), "Math");
		class1.setName("Physics");
		assertEquals(class1.getCourseName(), "Physics");
		
	}
	
//	@Test
//	public void testTeacher() {
//		ArrayList<Integer> hours1 = new ArrayList<Integer>();
//		
//		hours1.add(1);
//		hours1.add(7);
//		hours1.add(5);
//		
//		Class class1 = new Class("Math", "Mr. Man", hours1);
//		
//		assertEquals(class1.getTeacher(), "Mr. Man");
//		class1.setTeacher("Mrs. Lady");
//		assertEquals(class1.getTeacher(), "Mrs. Lady");
//		
//	}
//	
//	@Test
//	public void testHours() {
//		ArrayList<Integer> hours1 = new ArrayList<Integer>();
//		
//		hours1.add(1);
//		hours1.add(7);
//		hours1.add(5);
//		
//		Class class1 = new Class("Math", "Mr. Man", hours1);
//		
//		assertEquals(class1.getHours(), hours1);
//		
//		hours1.add(9);
//		hours1.add(12);
//		
//		class1.setHours(hours1);
//		assertEquals(class1.getHours(), hours1);
//		
//	}

}
