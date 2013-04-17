import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Rubric {

	private HashMap<String, ArrayList<Double>> grades;

	public Rubric() {
		this.grades = new HashMap<String, ArrayList<Double>>();
	}

	public void setDefaults() {
		this.addGrade("A", 90, 100, 4.0);
		this.addGrade("B+", 85, 89, 3.50);
		this.addGrade("B", 80, 84, 3.0);
		this.addGrade("C+", 75, 79, 2.50);
		this.addGrade("C", 70, 74, 2.0);
		this.addGrade("D+", 65, 69, 1.50);
		this.addGrade("D", 60, 64, 1.00);
		this.addGrade("F", 0, 59, 0.0);
	}

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
					|| upperLimit == x.get(1) || upperLimit > x.get(0)) {
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

	public void setGPA(String grade, double gpa) {
		for (ArrayList<Double> x : this.grades.values()) {
			if (gpa == x.get(2) || gpa < 0) {
				throw new IllegalArgumentException();
			}
		}
		this.grades.get(grade).set(2, gpa);
	}

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

	public void setLetterGrade(String old, String newGrade) {
		if(this.grades.containsKey(newGrade) || newGrade.length()==0){
			throw new IllegalArgumentException();
		}
		
		ArrayList<Double> temp = this.grades.get(old);
		this.grades.remove(old);
		this.grades.put(newGrade, temp);
	}

	public boolean removeGrade(String letterGrade) {
		if(!this.grades.containsKey(letterGrade)){
			return false;
		}
		this.grades.remove(letterGrade);
		return true;
	}

	public void saveRubric() throws Exception {
		FileParser rubric = new FileParser();
		ArrayList<String> data = new ArrayList<String>();		
		for(String key: this.grades.keySet()){
			data.add(key);
			ArrayList<Double> temp = this.grades.get(key);
			data.add(temp.get(0)+"");
			data.add(temp.get(1)+"");
			data.add(temp.get(2)+"");
		}
		
		rubric.writeFile("rubric.txt", ";", data, 4);
	}

	public void loadRubric(String fileName) throws Exception {
		this.grades.clear();
		FileParser rubric = new FileParser();
		ArrayList<String> data = rubric.readFile(fileName, ";", 4);
		for(int i=0; i<data.size(); i+=4){
			ArrayList<Double> temp = new ArrayList<Double>();
			temp.add(Double.parseDouble(data.get(i+1)));
			temp.add(Double.parseDouble(data.get(i+2)));
			temp.add(Double.parseDouble(data.get(i+3)));
			this.grades.put(data.get(i), temp);
		}
	}

	public Set<String> getGradeList() {
		return this.grades.keySet();
	}

}
