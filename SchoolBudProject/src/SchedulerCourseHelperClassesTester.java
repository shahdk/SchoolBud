import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * 
 */

/**
 * @author John
 *
 */
public class SchedulerCourseHelperClassesTester {

	@Test
	public void testClassDayGetterSetter() {
		ArrayList<Integer> hours = new ArrayList<Integer>();
		hours.add(1);
		hours.add(5);
		ClassDay day = new ClassDay(hours);
		
		assertEquals(hours, day.getHourSlots());
		
		hours.add(7);
		hours.add(9);
		day.setHourSlots(hours);
		
		assertEquals(hours, day.getHourSlots());
	}
	
	@Test
	public void testSection7DayExceptionLength() {
		ArrayList<ClassDay> days = new ArrayList<ClassDay>();
		ArrayList<Integer> hours = new ArrayList<Integer>();
		hours.add(1);
		hours.add(5);
		ClassDay day = new ClassDay(hours);
		days.add(day);
		boolean caught = false;
		try {
			new ClassSection("Mrs. Healy", days);
		}
		catch (InstantiationError e){
			caught = true;
		}
		assertTrue(caught);
	
	}
	
	@Test
	public void testClassSectionGetterSetter() {
		ArrayList<ClassDay> days = ClassSection.create7DayArrayList();
		ArrayList<Integer> hours = new ArrayList<Integer>();
		hours.add(1);
		hours.add(5);
		ClassDay day = new ClassDay(hours);
		days.set(0, day);
		
		ClassSection section = new ClassSection("Mr. Taylor", days);
		assertEquals(days, section.getClassDays());
		
		hours.add(7);
		hours.add(9);
		day.setHourSlots(hours);
		days.add(day);
		section.setClassDays(days);
		
		assertEquals(days, section.getClassDays());
	}
}
