import java.util.ArrayList;


public class GPACalculator {
	
	private ArrayList<double[]> gpaList;

	public GPACalculator(ArrayList<double[]> val) {
		gpaList = val;
	}

	public static double TotalGradePoints(ArrayList<double[]> list) {
		
		double sum = 0;
		
		for(double[] val: list){
			if(val[0] < 0 || val[1] < 0){
				throw new IllegalArgumentException();
			}
			double product = val[0] * val[1];
			sum+=product;
		}
		
		return sum;
	}

	public static double TotalGPA(ArrayList<double[]> list) {
		
		double gradePoints = TotalGradePoints(list);
		double totalCreditHours = 0;
		for(double[] val: list){
			totalCreditHours+=val[0];
		}
		
		if(totalCreditHours == 0){
			throw new ArithmeticException(); 
		}
		
		double gpa = (Math.round(gradePoints * 100.0 / totalCreditHours)) / 100.00;
		
		return gpa;
	}

}
