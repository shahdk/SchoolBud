import java.util.ArrayList;

/**
 * Java class to calculate the GPA
 * 
 * @author shahdk
 * 
 */
public class GPACalculator {

	/**
	 * Arryalist of an array of doubles. gpaList[0] stores the credit hours and
	 * gpaList[1] stores the gpa.
	 */
	private ArrayList<double[]> gpaList;
	/**
	 * Maximum possible credit hours for a course.
	 */
	private double maxCreditHours;
	/**
	 * Maximum GPA for a course.
	 */
	private double maxGPA;

	/**
	 * Constructor that initializes the GPACalculator object with the arraylist
	 * of credit hours and gpa score, and the maximum possible credit hours and
	 * gpa for a course.
	 * 
	 * @param val
	 * @param maxCreditHours
	 * @param maxGPA
	 */
	public GPACalculator(ArrayList<double[]> val, double maxCreditHours,
			double maxGPA) {
		this.gpaList = val;
		this.maxCreditHours = maxCreditHours;
		this.maxGPA = maxGPA;
	}

	/**
	 * Calculates the total grade points based on the list of credit hours and
	 * gpa.
	 * 
	 * @return double total grade points.
	 */
	public double totalGradePoints() {

		double sum = 0;

		for (double[] val : gpaList) {
			if (val[0] < 0 || val[0] > this.maxCreditHours || val[1] < 0
					|| val[1] > this.maxGPA) {
				throw new IllegalArgumentException();
			}
			double product = val[0] * val[1];
			sum += product;
		}

		sum = (Math.round(sum * 100.0)) / 100.0;

		return sum;
	}

	/**
	 * Calculates the GPA based on the list of credit hours and gpa.
	 * 
	 * @return double GPA
	 */
	public double totalGPA() {

		double gradePoints = this.totalGradePoints();
		double totalCreditHours = 0;
		for (double[] val : gpaList) {
			totalCreditHours += val[0];
		}

		if (totalCreditHours == 0) {
			throw new ArithmeticException();
		}

		double gpa = (Math.floor(gradePoints * 100.0 / totalCreditHours)) / 100.00;

		return gpa;
	}

}
