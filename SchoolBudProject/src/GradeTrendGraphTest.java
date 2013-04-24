import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * @author John
 *
 */
public class GradeTrendGraphTest {

	
	//Test DataPoint Helper Class
	@Test
	public void testDataPointHelperClass() {
		
		DataPoint point = new DataPoint(5, 8);
		
		//test getters
		 assertEquals(5, point.getX());
		 assertEquals(8, point.getY());
		 
		//test setters
		 point.setX(6);
		 point.setY(0);
		 
		 assertEquals(6, point.getX());
		 assertEquals(0, point.getY());
		 
	}
	
	@Test
	public void testAllUserEnteredVariablesGettersAndSetters() {
		
		GradeTrendGraph graph = new GradeTrendGraph(null, 1, 5);
		
		//test getters
		assertNull(graph.getCourse());
		assertEquals(1, graph.getClassDifficulty_1_5());
		assertEquals(5, graph.getFutureWorkRate_neg5_pos5());
		
		//test setters
		graph.setClassDifficulty_1_5(3);
		graph.setFutureWorkRate_neg5_pos5(-3);
		graph.setCourse(new Course("science"));
		
		assertNotNull(graph.getCourse());
		assertEquals(3, graph.getClassDifficulty_1_5());
		assertEquals(-3, graph.getFutureWorkRate_neg5_pos5());
		
	}

}
