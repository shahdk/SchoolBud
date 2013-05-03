import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

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
	private HashMap<String, Integer> itemFrequencies;

	// Evaluated Trends (list of points)
	// (X Y) points purely for graphing
	private ArrayList<DataPoint> bestGradePredictionCurvePoints;
	private ArrayList<DataPoint> worstGradePredictionCurvePoints;
	private ArrayList<DataPoint> gradePredictionCurvePoints;

	// User personally entered variables
	private int classDifficulty_1_5;
	private int futureWorkRate_neg5_pos5;
	private Course course;
	private Date startDate;
	private Date endDate;

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
		this.dateOrderedItemList = new ArrayList<Item>();

	}

	// Updates all instance variables, averages, predictions, data points
	// and trends in accordance with the most up to date course items.
	// Takes in various factors which will all be used to decide the
	// Steepness Factor ==> which is the overall neg or pos variation between
	// data points, STARTING at the actual current average as the initial fixed
	// point
	public void updateGraph() {

		// update current average
		this.currentAverage = this.course.getCourseGrade();

		// update and sort item list by date
		this.updateAndOrganizeItemListByDate();

		// update item frequencies up to current date
		this.itemFrequencies = this.course.getItemFrequency(this.startDate,
				this.endDate);

		// take shorter half of item grades towards
		// current date compared to average for trend adjustment

		// take into account user given class difficulty to affect
		// the steepness factor

		// take into account user given future work rate to affect
		// the steepness factor

		// use item frequencies to predict max / min variations
		// for POSSIBLE EXTREMES for best / worst / average grade cases
		this.updateExtremeGrades();

		// Update trends and create their respective data points
		// ---Data points X and Y are affected by an overall steepness factor
		// (determined by ALL of these calculated and given factors)
		// which will be used to determine the rise / run variations of each
		// point separation

		// use updated trends to update PREDICTED best / worst / average grades

	}

	public void updateExtremeGrades() {
		Set<String> categories = this.itemFrequencies.keySet();

		boolean isZero = true;
		
		int daysPassed = (int) ((this.endDate.getTime() - this.startDate
				.getTime()) / (1000 * 60 * 60 * 24));
		if(daysPassed == 0){
			daysPassed = 1;
		}

		int daysRemaining = (int) ((this.course.getEndDate().getTime() - this.endDate
				.getTime()) / (1000 * 60 * 60 * 24));
		
		Course tempMinCourse = new Course("tempCourse");
		Course tempMaxCourse = new Course("tempMaxCourse");
		ArrayList<Category> cats = this.course.getCategories();
		
		for (String cat : categories) {
			int freq = this.itemFrequencies.get(cat);
			double currentRatio = (freq+0.0) / daysPassed;
			int predictedItems = (int) ((currentRatio * daysRemaining) + 0.5);
			if(predictedItems > 0){
				isZero = false;
			}
			double weight = this.getCategoryWeight(cats, cat);
			ArrayList<Item> currItems = this.getCategoryItems(cats, cat);
			
			Category newMinCat = new Category(cat, predictedItems, weight);
			for(int i=0; i<newMinCat.getItemList().size(); i++){
				newMinCat.getItemList().get(i).setEarnedPoints("0");
				newMinCat.getItemList().get(i).setTotalPoints("100");
			}			
			for(Item i: currItems){
				i.setName(i.getName()+"temppppp");
				newMinCat.addItem(i);
			}
			tempMinCourse.addCategory(newMinCat);
			
			Category newMaxCat = new Category(cat, predictedItems, weight);
			for(int i=0; i<newMaxCat.getItemList().size(); i++){
				newMaxCat.getItemList().get(i).setEarnedPoints("100");
				newMaxCat.getItemList().get(i).setTotalPoints("100");
			}
			for(Item i: currItems){
				newMaxCat.addItem(i);
			}
			tempMaxCourse.addCategory(newMaxCat);
			
		}
		
		if(isZero){
			this.worstCaseGrade = 0;
			this.bestCaseGrade = 100;
		} else{
			this.worstCaseGrade = (int) (tempMinCourse.getCourseGrade() + 0.5);
			this.bestCaseGrade = (int) (tempMaxCourse.getCourseGrade() + 0.5);
		}
		
	}

	public double getCategoryWeight(ArrayList<Category> cats, String cat){
		for(Category c: cats){
			if(c.getName().equals(cat)){
				return c.getWeight();
			}
		}
		return 0;
	}
	
	public ArrayList<Item> getCategoryItems(ArrayList<Category> cats, String cat){
		for(Category c: cats){
			if(c.getName().equals(cat)){
				return c.getItemList();
			}
		}
		return new ArrayList<Item>();
	}
	
	// Recursively find place to insert item
	public void insertItemIntoItemDateList(Item item, int minIndex, int index) {

		// check for empty list
		if (this.dateOrderedItemList.isEmpty()) {
			this.dateOrderedItemList.add(item);
			return;
		}

		int newIndex;
		int offset;
		int compared = item.getUpdateDate().compareTo(
				this.dateOrderedItemList.get(index).getUpdateDate());

		if (compared == 0) {
			this.dateOrderedItemList.add(index, item);
		} else if (compared > 0) {
			if (minIndex == index) {
				this.dateOrderedItemList.add(index + 1, item);
			} else {
				offset = this.dateOrderedItemList.size() - index - 1;
				newIndex = (offset / 2) + (offset % 2) + index;
				this.insertItemIntoItemDateList(item, index, newIndex);
			}
		} else {
			if (minIndex == index) {
				this.dateOrderedItemList.add(index, item);
			} else {
				offset = index - minIndex;
				newIndex = (offset / 2) + minIndex;
				this.insertItemIntoItemDateList(item, minIndex, newIndex);
			}

		}
	}

	// Abstracts ALL current items (assignments) out of the given
	// course into once big list ordered by date
	public void updateAndOrganizeItemListByDate() {
		this.dateOrderedItemList.clear();

		// go through each category
		for (Category category : this.course.getCategories()) {

			// go through each item
			for (Item item : category.getItemList()) {

				// insert into item list by date
				this.insertItemIntoItemDateList(item, 0,
						this.dateOrderedItemList.size() / 2);
			}
		}

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

	/**
	 * 
	 * get
	 */
	public ArrayList<Item> getDateOrderedItemsList() {
		return this.dateOrderedItemList;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public double getWorstCaseGrade(){
		return this.worstCaseGrade;
	}
	
	public double getBestCaseGrade(){
		return this.bestCaseGrade;
	}

}
