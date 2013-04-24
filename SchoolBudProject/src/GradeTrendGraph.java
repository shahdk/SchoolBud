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
	private DataPoint dataPoints;

	// Evaluated Trends (list of points)
	// (X Y) points purely for graphing
	private ArrayList<ArrayList<Integer>> bestGradePredictionCurvePoints;
	private ArrayList<ArrayList<Integer>> worstGradePredictionCurvePoints;
	private ArrayList<ArrayList<Integer>> gradePredictionCurvePoints;

	// User personally entered variables
	private int classDifficulty_1_5;
	private int futureWorkRate_neg5_pos5;

	public GradeTrendGraph(int classDifficulty_1_5, int futureWorkRate_neg5_pos5)
			throws InstantiationError {

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

	}

}
