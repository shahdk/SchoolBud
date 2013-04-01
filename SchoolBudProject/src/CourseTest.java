import static org.junit.Assert.*;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;


public class CourseTest {

	@Test
	public void testJUnit() {
		assertTrue("JUnit works!", true);
	}
	
	//test cases for initializing Course
	@Test
	public void testInitializeOne(){
		assertNotNull(new Course("CSSE376"));
	}
	
	@Test
	public void testInitializeTwo(){
		assertNotNull(new Course("CSSE376", 4.0));
	}

}
