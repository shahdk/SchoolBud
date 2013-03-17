import java.util.ArrayList;


public class GPACalculator {
	
	private ArrayList<double[]> gpaList;

	public GPACalculator(ArrayList<double[]> val) {
		gpaList = val;
	}

	public double TotalGradePoints() {
		
		double sum = 0;
		
		for(double[] val: gpaList){
			if(val[0] < 0 || val[1] < 0){
				throw new IllegalArgumentException();
			}
			double product = val[0] * val[1];
			sum+=product;
		}
		
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
		
		double gpa = (Math.round(gradePoints * 100.0 / totalCreditHours)) / 100.00;
		
		return gpa;
	}

}