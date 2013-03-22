import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

public class SchedulerTester {

	@Test
	public void test() {
		assertTrue(true);
	}

	@Test
	public void testInitialize() {
		ArrayList<Integer> hours1 = new ArrayList<Integer>();
		ArrayList<Class> classes = new ArrayList<Class>();

		hours1.add(1);
		hours1.add(3);
		hours1.add(6);

		Class class1 = new Class("Math", "Mr. Man", hours1);
		classes.add(class1);
		
		assertNotNull(new Scheduler(5, classes));
	}
	
	
	@Test
	public void testScheduleNullClasses() {
		
		Scheduler scheduler = new Scheduler(5, null);
		
		
		assertEquals(new ArrayList<Class[]>(), scheduler.permutateSchedules());
	}
	
	
	@Test
	public void testScheduleOneClassZeroHours() {
		
		ArrayList<Integer> hours1 = new ArrayList<Integer>();
		Class class1 = new Class("Math", "Mr. Man", hours1);
		ArrayList<Class> classes = new ArrayList<Class>();
		classes.add(class1);
		
		Scheduler scheduler = new Scheduler(10, classes);
		
		
		assertEquals(new ArrayList<Class[]>(), scheduler.permutateSchedules());
	}
	
	
	@Test
	public void testScheduleOneClassOneHour() {
		
		ArrayList<Integer> hours1 = new ArrayList<Integer>();
		hours1.add(3);
		Class class1 = new Class("Math", "Mr. Man", hours1);
		ArrayList<Class> classes = new ArrayList<Class>();
		classes.add(class1);
		
		Scheduler scheduler = new Scheduler(10, classes);	
		
		assertEquals(class1, scheduler.permutateSchedules().get(0)[3]);
	}
	
	
	@Test
	public void testScheduleOneClassTwoHours() {
		
		ArrayList<Integer> hours1 = new ArrayList<Integer>();
		hours1.add(3);
		hours1.add(6);
		Class class1 = new Class("Math", "Mr. Man", hours1);
		ArrayList<Class> classes = new ArrayList<Class>();
		classes.add(class1);
		
		Scheduler scheduler = new Scheduler(10, classes);	
		
		assertEquals(class1, scheduler.permutateSchedules().get(0)[3]);
		assertEquals(class1, scheduler.permutateSchedules().get(1)[6]);
	}
	
	
	
	@Test
	public void testScheduleOneClassFiveHoursWithMaxHourAndMinHourUsed() {
		
		ArrayList<Integer> hours1 = new ArrayList<Integer>();
		
		hours1.add(1);
		hours1.add(6);
		hours1.add(7);
		hours1.add(9);
		hours1.add(10);
		
		Class class1 = new Class("Math", "Mr. Man", hours1);
		ArrayList<Class> classes = new ArrayList<Class>();
		classes.add(class1);
		
		Scheduler scheduler = new Scheduler(10, classes);	
		
		assertEquals(class1, scheduler.permutateSchedules().get(0)[1]);
		assertEquals(class1, scheduler.permutateSchedules().get(1)[6]);
		assertEquals(class1, scheduler.permutateSchedules().get(2)[7]);
		assertEquals(class1, scheduler.permutateSchedules().get(3)[9]);
		assertEquals(class1, scheduler.permutateSchedules().get(4)[10]);
	}
	
	
	@Test
	public void testScheduleTwoClassesOneHourOnly() {
		
		ArrayList<Integer> hours1 = new ArrayList<Integer>();
		ArrayList<Integer> hours2 = new ArrayList<Integer>();
		
		hours1.add(2);
		
		Class class1 = new Class("Math", "Mr. Man", hours1);
		Class class2 = new Class("Physics", "Mr. Nam", hours2);
		ArrayList<Class> classes = new ArrayList<Class>();
		classes.add(class1);
		classes.add(class2);
		
		Scheduler scheduler = new Scheduler(4, classes);	
		
		assertEquals(new ArrayList<Class[]>(), scheduler.permutateSchedules());
	}
	
	
	@Test
	public void testScheduleTwoClassesOneHourEach() {
		
		ArrayList<Integer> hours1 = new ArrayList<Integer>();
		ArrayList<Integer> hours2 = new ArrayList<Integer>();
		
		hours1.add(2);
		hours2.add(7);
		
		Class class1 = new Class("Math", "Mr. Man", hours1);
		Class class2 = new Class("Physics", "Mr. Nam", hours2);
		ArrayList<Class> classes = new ArrayList<Class>();
		classes.add(class1);
		classes.add(class2);
		
		Scheduler scheduler = new Scheduler(7, classes);	
		
		
		
		assertEquals(class1, scheduler.permutateSchedules().get(0)[2]);
		assertEquals(class2, scheduler.permutateSchedules().get(0)[7]);
	}
	
	
	@Test
	public void testScheduleTwoClassesEachHaveSameTwoHours() {
		
		ArrayList<Integer> hours1 = new ArrayList<Integer>();
		ArrayList<Integer> hours2 = new ArrayList<Integer>();
		
		hours1.add(2);
		hours1.add(7);
		hours2.add(2);
		hours2.add(7);
		
		Class class1 = new Class("Math", "Mr. Man", hours1);
		Class class2 = new Class("Physics", "Mr. Nam", hours2);
		ArrayList<Class> classes = new ArrayList<Class>();
		classes.add(class1);
		classes.add(class2);
		
		Scheduler scheduler = new Scheduler(7, classes);	
		
		assertEquals(class1, scheduler.permutateSchedules().get(0)[2]);
		assertEquals(class2, scheduler.permutateSchedules().get(0)[7]);
		assertEquals(class1, scheduler.permutateSchedules().get(1)[7]);
		assertEquals(class2, scheduler.permutateSchedules().get(1)[2]);
	}
	
	@Test
	public void testScheduleThreeClassesThreeDifferentPeriodsEach() {
		
		ArrayList<Integer> hours1 = new ArrayList<Integer>();
		ArrayList<Integer> hours2 = new ArrayList<Integer>();
		ArrayList<Integer> hours3 = new ArrayList<Integer>();
		
		hours1.add(1);
		hours1.add(2);
		hours1.add(3);
		hours2.add(4);
		hours2.add(5);
		hours2.add(6);
		hours3.add(7);
		hours3.add(8);
		hours3.add(9);
		
		Class class1 = new Class("Math", "Mr. Man", hours1);
		Class class2 = new Class("Physics", "Mr. Nam", hours2);
		Class class3 = new Class("Social Studies", "Mohan", hours3);
		ArrayList<Class> classes = new ArrayList<Class>();
		classes.add(class1);
		classes.add(class2);
		classes.add(class3);
		
		Scheduler scheduler = new Scheduler(10, classes);	
		
		
		
		assertEquals(class1, scheduler.permutateSchedules().get(0)[1]);
		assertEquals(class2, scheduler.permutateSchedules().get(0)[4]);
		assertEquals(class3, scheduler.permutateSchedules().get(0)[7]);
		assertEquals(null, scheduler.permutateSchedules().get(0)[10]);
		
		assertEquals(class1, scheduler.permutateSchedules().get(1)[2]);
		assertEquals(class2, scheduler.permutateSchedules().get(1)[5]);
		assertEquals(class3, scheduler.permutateSchedules().get(1)[8]);
		assertEquals(null, scheduler.permutateSchedules().get(1)[10]);
		
		assertEquals(class1, scheduler.permutateSchedules().get(2)[3]);
		assertEquals(class2, scheduler.permutateSchedules().get(2)[6]);
		assertEquals(class3, scheduler.permutateSchedules().get(2)[9]);
		assertEquals(null, scheduler.permutateSchedules().get(2)[10]);
		
		
		int size = scheduler.permutateSchedules().size();
		assertEquals(9, size);

		
	}
	
//	
//	for (int i = 0; i < size; i++){
//		assertEquals(3, this.countArrayItems(scheduler.permutateSchedules().get(i)));
//	}
	
//		private int countArrayItems (Class[] list){
//			int count = 0;
//			for (Class i : list){
//				if (i != null) {
//					count++;
//				}
//			}
//			return count;
//		}
}