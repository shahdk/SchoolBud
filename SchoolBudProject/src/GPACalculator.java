import java.util.ArrayList;


public class GPACalculator {
	
	private ArrayList<double[]> gpaList;
	private double maxCreditHours, maxGPA;

	public GPACalculator(ArrayList<double[]> val, double maxCreditHours, double maxGPA) {
		this.gpaList = val;
		this.maxCreditHours = maxCreditHours;
		this.maxGPA = maxGPA;
	}

	public double TotalGradePoints() {
		
		double sum = 0;
		
		for(double[] val: gpaList){
			if(val[0] < 0 || val[0] > this.maxCreditHours || val[1] < 0 || val[1] > this.maxGPA){
				throw new IllegalArgumentException();
			}
			double product = val[0] * val[1];
			sum+=product;
		}
		
		sum = (Math.round(sum * 100.0))/100.0;
		
		return sum;
	}

	public double TotalGPA() {
		
		double gradePoints = this.TotalGradePoints();
		double totalCreditHours = 0;
		for(double[] val: gpaList){
			totalCreditHours+=val[0];
		}
		
		if(totalCreditHours == 0){
			throw new ArithmeticException(); 
		}
		
		double gpa = (Math.floor(gradePoints * 100.0 / totalCreditHours)) / 100.00;
		
		return gpa;
	}

}
