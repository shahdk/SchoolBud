import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Java object to store information about a rubric associated with a particular
 * course.
 * 
 * @author shahdk
 * 
 */
public class Rubric {

	/**
	 * Stores the lower limit, upper limit and gpa associated with a particular
	 * letter grade.
	 */
	private HashMap<String, ArrayList<Double>> grades;

	/**
	 * Constructor to initialize the Rubric object.
	 */
	public Rubric() {
		this.grades = new HashMap<String, ArrayList<Double>>();
	}

	/**
	 * Uses the Rose-Hulman rubric as a default rubric for a course.
	 */
	public void setDefaults() {
		this.grades.clear();
		this.addGrade("A", 90, 100, 4.0);
		this.addGrade("B+", 85, 89, 3.50);
		this.addGrade("B", 80, 84, 3.0);
		this.addGrade("C+", 75, 79, 2.50);
		this.addGrade("C", 70, 74, 2.0);
		this.addGrade("D+", 65, 69, 1.50);
		this.addGrade("D", 60, 64, 1.00);
		this.addGrade("F", 0, 59, 0.0);
	}

	/**
	 * adds the given grade along with its lower limit, upper limit and gpa to
	 * the rubric.
	 * 
	 * @param letterGrade
	 * @param lowerLimit
	 * @param upperLimit
	 * @param gpa
	 */
	public void addGrade(String letterGrade, double lowerLimit,
			double upperLimit, double gpa) {
		if (lowerLimit > upperLimit || lowerLimit < 0 || lowerLimit > 100
				|| upperLimit < 0 || upperLimit > 100
				|| this.grades.containsKey(letterGrade)) {
			throw new IllegalArgumentException();
		}

		for (ArrayList<Double> x : this.grades.values()) {
			if ((lowerLimit > x.get(0) && lowerLimit < x.get(1))
					|| lowerLimit == x.get(0)) {
				throw new IllegalArgumentException();
			}
			if ((upperLimit > x.get(0) && upperLimit < x.get(1))
					|| upperLimit == x.get(1)) {
				throw new IllegalArgumentException();
			}
			if (gpa == x.get(2) || gpa < 0) {
				throw new IllegalArgumentException();
			}
		}

		ArrayList<Double> temp = new ArrayList<Double>();
		temp.add(lowerLimit);
		temp.add(upperLimit);
		temp.add(gpa);
		this.grades.put(letterGrade, temp);
	}

	/**
	 * Returns the lower limit for the specified letter grade.
	 * 
	 * @param letterGrade
	 * @return double lower limit
	 */
	public double getLowerLimit(String letterGrade) {
		ArrayList<Double> temp = this.grades.get(letterGrade);
		return temp.get(0);
	}

	/**
	 * Returns the upper limit for the specified letter grade
	 * 
	 * @param letterGrade
	 * @return double upper limit
	 */
	public double getUpperLimit(String letterGrade) {
		ArrayList<Double> temp = this.grades.get(letterGrade);
		return temp.get(1);
	}

	/**
	 * Returns the GPA for the specified letter grade
	 * 
	 * @param letterGrade
	 * @return double gpa
	 */
	public double getGPA(String letterGrade) {
		ArrayList<Double> temp = this.grades.get(letterGrade);
		return temp.get(2);
	}

	/**
	 * Sets the gpa for the given letter grade to the specified gpa
	 * 
	 * @param grade
	 * @param gpa
	 */
	public void setGPA(String grade, double gpa) {
		for (ArrayList<Double> x : this.grades.values()) {
			if (gpa == x.get(2) || gpa < 0) {
				throw new IllegalArgumentException();
			}
		}
		this.grades.get(grade).set(2, gpa);
	}

	/**
	 * Sets the lower limit for the given letter grade to the specified lower
	 * limit
	 * 
	 * @param grade
	 * @param lowerLimit
	 */
	public void setLowerLimit(String grade, double lowerLimit) {
		if (lowerLimit < 0 || lowerLimit > 100) {
			throw new IllegalArgumentException();
		}

		for (String s : this.grades.keySet()) {
			if (!s.equals(grade)) {
				ArrayList<Double> x = this.grades.get(s);
				if ((lowerLimit > x.get(0) && lowerLimit < x.get(1))
						|| lowerLimit == x.get(0)) {
					throw new IllegalArgumentException();
				}
			}
		}

		this.grades.get(grade).set(0, lowerLimit);
	}

	/**
	 * Sets the upper limit for the given letter grade to the specified upper
	 * limit
	 * 
	 * @param grade
	 * @param upperLimit
	 */
	public void setUpperLimit(String grade, double upperLimit) {
		if (upperLimit < 0 || upperLimit > 100) {
			throw new IllegalArgumentException();
		}

		for (String s : this.grades.keySet()) {
			if (!s.equals(grade)) {
				ArrayList<Double> x = this.grades.get(s);
				if ((upperLimit > x.get(0) && upperLimit < x.get(1))
						|| upperLimit == x.get(1) || upperLimit > x.get(0)) {
					throw new IllegalArgumentException();
				}
			}
		}

		this.grades.get(grade).set(1, upperLimit);
	}

	/**
	 * Replaces the old letter grade with the new letter grade
	 * 
	 * @param old
	 * @param newGrade
	 */
	public void setLetterGrade(String old, String newGrade) {
		if (this.grades.containsKey(newGrade) || newGrade.length() == 0) {
			throw new IllegalArgumentException();
		}

		ArrayList<Double> temp = this.grades.get(old);
		this.grades.remove(old);
		this.grades.put(newGrade, temp);
	}

	/**
	 * Removes the specified letter grade from the list of grades in the rubric
	 * 
	 * @param letterGrade
	 * @return true if successful in removing
	 */
	public boolean removeGrade(String letterGrade) {
		if (!this.grades.containsKey(letterGrade)) {
			return false;
		}
		this.grades.remove(letterGrade);
		return true;
	}

	/**
	 * Returns a list of letter grades in the rubric.
	 * 
	 * @return Set<String> of letter grades.
	 */
	public Set<String> getGradeList() {
		return this.grades.keySet();
	}

}
