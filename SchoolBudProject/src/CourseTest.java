import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;


public class CourseTest {

	@Test
	public void testCourseInitialize() {
		
		HashMap<String, Double> itemWeight = new HashMap<String, Double>();
		Course courseObj = new Course(itemWeight);
		assertNotNull(courseObj);
	}

}
