import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;


/* Tests the CLASS class */

public class SchedulerCourseTester {
	
	@Test
	public void testClassInitializationEcceptionForInvalidArrayListLength() {
		
		boolean caught = false;
		ArrayList<ArrayList<ClassDay>> temp = new ArrayList<ArrayList<ClassDay>>();
		temp.add(new ArrayList<ClassDay>());
		try {
			new SchedulerCourse("name", "teacher", temp);
		}
		catch (InstantiationError e) {
			caught = true;
		}
		
		assertTrue(caught);
	}
	
	@Test
	public void testName() {
		ArrayList<ArrayList<ClassDay>> scheds = new ArrayList<ArrayList<ClassDay>>();
		ArrayList<Integer> hours1 = new ArrayList<Integer>();
		hours1.add(1);
		ClassDay day = new ClassDay(hours1);
		
		ArrayList<ClassDay> sched = SchedulerCourseTester.createInitialized7DayList();
		sched.set(2, day);

		scheds.add(sched);
		SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man", scheds);
		
		assertEquals(class1.getCourseName(), "Math");
		class1.setName("Physics");
		assertEquals(class1.getCourseName(), "Physics");
		
	}
	
	@Test
	public void testSetGetScheduleHours() {
		ArrayList<ArrayList<ClassDay>> scheds = new ArrayList<ArrayList<ClassDay>>();
		ArrayList<Integer> hours1 = new ArrayList<Integer>();
		hours1.add(1);
		ClassDay day = new ClassDay(hours1);
		
		//test getting day hour slots
		assertEquals(hours1, day.getHourSlots());
		
		ArrayList<ClassDay> sched = SchedulerCourseTester.createInitialized7DayList();
		sched.set(2, day);

		scheds.add(sched);
		SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man", scheds);
		
		assertEquals(class1.getScheduleHours(), scheds);
		
		ArrayList<ArrayList<ClassDay>> scheds2 = new ArrayList<ArrayList<ClassDay>>();
		ArrayList<Integer> hours2 = new ArrayList<Integer>();
		hours1.add(3);
		ClassDay day2 = new ClassDay(hours2);
		
		ArrayList<ClassDay> sched2 = SchedulerCourseTester.createInitialized7DayList();
		sched2.set(5, day);

		scheds2.add(sched);
		class1.setScheduleHours(scheds2);
		
		assertEquals(class1.getScheduleHours(), scheds2);
		
		
	}
	
	@Test
	public void testTeacher() {
		ArrayList<ArrayList<ClassDay>> scheds = new ArrayList<ArrayList<ClassDay>>();
		ArrayList<Integer> hours1 = new ArrayList<Integer>();
		hours1.add(1);
		ClassDay day = new ClassDay(hours1);
		
		ArrayList<ClassDay> sched = SchedulerCourseTester.createInitialized7DayList();
		sched.set(2, day);

		scheds.add(sched);
		SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man", scheds);
		
		assertEquals(class1.getTeacher(), "Mr. Man");
		class1.setTeacher("Mrs. Lady");
		assertEquals(class1.getTeacher(), "Mrs. Lady");
		
	}
	
	@Test
	public void testThrownErrorForNon7DaysEntry(){
		boolean caught = false;
		ArrayList<ArrayList<ClassDay>> scheds = new ArrayList<ArrayList<ClassDay>>();
		ArrayList<Integer> hours1 = new ArrayList<Integer>();
		hours1.add(1);
		ClassDay day = new ClassDay(hours1);
		
		ArrayList<ClassDay> sched = SchedulerCourseTester.createInitialized7DayList();
		sched.set(2, day);

		scheds.add(sched);
		scheds.add(new ArrayList<ClassDay>());

		try {
			SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man", scheds);
		}
		catch (InstantiationError e) {
			caught = true;
		}
		
		assertTrue(caught);
	}
	
	@Test
	public void testHours() {
		
		//section 1
		ArrayList<ArrayList<ClassDay>> scheds = new ArrayList<ArrayList<ClassDay>>();
		
		//create the hours for days
		ArrayList<Integer> hours1 = new ArrayList<Integer>();
		hours1.add(1);
		hours1.add(2);
		ClassDay day = new ClassDay(hours1);
		
		ArrayList<ClassDay> sched = SchedulerCourseTester.createInitialized7DayList();
		sched.set(2, day);

		//add section1 to the class' section list
		scheds.add(sched);
		
		//create class
		SchedulerCourse class1 = new SchedulerCourse("Math", "Mr. Man", scheds);
		
		//check to see if class got the schedule section1
		assertEquals(class1.getScheduleHours().get(0), sched);
		
		//START section2
		ArrayList<Integer> hours2 = new ArrayList<Integer>();
		hours2.add(4);
		hours2.add(5);
		ClassDay day2 = new ClassDay(hours2);
		
		//create hours for days for section2
		ArrayList<ClassDay> sched2 = SchedulerCourseTester.createInitialized7DayList();
		sched2.set(5, day2);

		//add section2 to class' section list
		scheds.add(sched2);
		SchedulerCourse class2 = new SchedulerCourse("Math2", "Mr. Man2", scheds);
		
		assertEquals(class1.getScheduleHours().get(0), sched);
		assertEquals(class2.getScheduleHours().get(0), sched);
		assertEquals(class2.getScheduleHours().get(1), sched2);

	}
	
	public static ArrayList<ClassDay> createInitialized7DayList() {
		ArrayList<ClassDay> list = new ArrayList<ClassDay>();
		
		for (int i = 0;  i < 7; i++) {
			list.add(new ClassDay(new ArrayList<Integer>()));
		}
		
		return list;
	}

}
