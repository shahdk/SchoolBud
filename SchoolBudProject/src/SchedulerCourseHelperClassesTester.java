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
	public void testWeekSchedule7DayExceptionLength() {
		ArrayList<ClassDay> days = new ArrayList<ClassDay>();
		ArrayList<Integer> hours = new ArrayList<Integer>();
		hours.add(1);
		hours.add(5);
		ClassDay day = new ClassDay(hours);
		days.add(day);
		boolean caught = false;
		try {
			WeekSchedule week = new WeekSchedule(days);
		}
		catch (InstantiationError e){
			caught = true;
		}
		assertTrue(caught);
	
	}
	
	@Test
	public void testWeekScheduleGetterSetter() {
		ArrayList<ClassDay> days = WeekSchedule.create7DayArrayList();
		ArrayList<Integer> hours = new ArrayList<Integer>();
		hours.add(1);
		hours.add(5);
		ClassDay day = new ClassDay(hours);
		days.set(0, day);
		
		WeekSchedule week = new WeekSchedule(days);
		assertEquals(days, week.getScheduleHours());
		
		hours.add(7);
		hours.add(9);
		day.setHourSlots(hours);
		days.add(day);
		week.setScheduleHours(days);
		
		assertEquals(days, week.getScheduleHours());
	}
	
	@Test
	public void testClassSectionGetterSetter() {
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
		assertEquals(sections, sectionHolder.getSections());
		
		sectionHolder.setSections(null);
		assertNull(sectionHolder.getSections());
	}

}
