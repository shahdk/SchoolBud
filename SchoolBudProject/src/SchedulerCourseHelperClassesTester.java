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

}
