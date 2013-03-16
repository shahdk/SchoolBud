import java.util.ArrayList;


public class GPACalculator {

	public static double TotalGrapdePoints(ArrayList<double[]> list) {
		
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

}
