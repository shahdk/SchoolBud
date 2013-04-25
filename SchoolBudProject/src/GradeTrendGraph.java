import java.util.ArrayList;

/**
 * 
 */

/**
 * This class holds an instance of the entirety of entered data points (grades
 * vs. time) that make up the various grade trends
 * 
 * @author John
 * 
 */
public class GradeTrendGraph {

	// Evaluated Instance Variables
	private double currentAverage;
	private double bestCaseGrade;
	private double worstCaseGrade;
	private double predictedGrade;
	private double predictedBestCaseGrade;
	private double predictedWorstCaseGrade;
	private ArrayList<Item> dateOrderedItemList;

	// Evaluated Trends (list of points)
	// (X Y) points purely for graphing
	private ArrayList<DataPoint> bestGradePredictionCurvePoints;
	private ArrayList<DataPoint> worstGradePredictionCurvePoints;
	private ArrayList<DataPoint> gradePredictionCurvePoints;

	// User personally entered variables
	private int classDifficulty_1_5;
	private int futureWorkRate_neg5_pos5;
	private Course course;

	public GradeTrendGraph(Course course, int classDifficulty_1_5,
			int futureWorkRate_neg5_pos5) throws InstantiationError {

		// check for valid parameter entries
		// check class difficulty between 1 and 5
		if (!(classDifficulty_1_5 <= 5 && classDifficulty_1_5 >= 1)) {
			throw new InstantiationError(
					"Class Difficulty must be and integer 1 to 5");
		}
		// check future work rate between -5 and 5
		if (!(futureWorkRate_neg5_pos5 <= 5 && futureWorkRate_neg5_pos5 >= -5)) {
			throw new InstantiationError(
					"Future work rate must be and integer -5 to 5");
		}

		this.classDifficulty_1_5 = classDifficulty_1_5;
		this.futureWorkRate_neg5_pos5 = futureWorkRate_neg5_pos5;
		this.course = course;

	}

	// Updates all instance variables, averages, predictions, data points
	// and trends in accordance with the most up to date course items
	public void updateGraph() {

		// first update the Item List
		this.updateAndOrganizeItemListByDate();

	}

	// Abstracts ALL current items (assignments) out of the given
	// course into once big list ordered by date
	public void updateAndOrganizeItemListByDate() {

	}

	/**
	 * @return the classDifficulty_1_5
	 */
	public int getClassDifficulty_1_5() {
		return classDifficulty_1_5;
	}

	/**
	 * @param classDifficulty_1_5
	 *            the classDifficulty_1_5 to set
	 */
	public void setClassDifficulty_1_5(int classDifficulty_1_5) {
		this.classDifficulty_1_5 = classDifficulty_1_5;
	}

	/**
	 * @return the futureWorkRate_neg5_pos5
	 */
	public int getFutureWorkRate_neg5_pos5() {
		return futureWorkRate_neg5_pos5;
	}

	/**
	 * @param futureWorkRate_neg5_pos5
	 *            the futureWorkRate_neg5_pos5 to set
	 */
	public void setFutureWorkRate_neg5_pos5(int futureWorkRate_neg5_pos5) {
		this.futureWorkRate_neg5_pos5 = futureWorkRate_neg5_pos5;
	}

	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * @param course
	 *            the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

}
