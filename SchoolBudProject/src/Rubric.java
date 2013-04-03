import java.util.ArrayList;
import java.util.HashMap;


public class Rubric {
	
	HashMap<String, ArrayList<Double>> grades;
	
	public Rubric(){
		this.grades = new HashMap<String, ArrayList<Double>>();
		this.addGrade("A", 90, 100, 4.0);
		this.addGrade("B+", 85, 89, 3.50);
		this.addGrade("B", 80, 84, 3.0);
		this.addGrade("C+", 75, 79, 2.50);
		this.addGrade("C", 70, 74, 2.0);
		this.addGrade("D+", 65, 69, 1.50);
		this.addGrade("D", 60, 64, 1.00);
		this.addGrade("F", 0, 59, 0.0);
	}

	public void addGrade(String letterGrade, double lowerLimit, double upperLimit, double gpa) {
		ArrayList<Double> temp = new ArrayList<Double>();
		temp.add(lowerLimit);
		temp.add(upperLimit);
		temp.add(gpa);
		this.grades.put(letterGrade, temp);
	}

	public double getLowerLimit(String letterGrade) {
		ArrayList<Double> temp = this.grades.get(letterGrade);
		return temp.get(0);
	}

	public double getUpperLimit(String letterGrade) {
		ArrayList<Double> temp = this.grades.get(letterGrade);
		return temp.get(1);
	}

	public double getGPA(String letterGrade) {
		ArrayList<Double> temp = this.grades.get(letterGrade);
		return temp.get(2);
	}

}
