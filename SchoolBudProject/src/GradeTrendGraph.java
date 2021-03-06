import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
	private Date currentDate = new Date();
	private Date testCurrentDate = new Date();

	// Evaluated Trends (list of points)
	// (X Y) points purely for graphing
	private ArrayList<DataPoint> bestGradePredictionCurvePoints = new ArrayList<DataPoint>();
	private ArrayList<DataPoint> worstGradePredictionCurvePoints = new ArrayList<DataPoint>();
	private ArrayList<DataPoint> gradePredictionCurvePoints = new ArrayList<DataPoint>();

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
		// 5 easiest === 1 hardest
		if (!(classDifficulty_1_5 <= 5 && classDifficulty_1_5 >= 1)) {
			throw new InstantiationError(
					"Class Difficulty must be and integer 1 to 5");
		}
		// check future work rate between -5 and 5
		if (!(futureWorkRate_neg5_pos5 <= 5 && futureWorkRate_neg5_pos5 >= -5)) {
			throw new InstantiationError(
					"Future work rate must be and integer -5 to 5");
		}

		// check non null course
		if (course == null) {
			throw new InstantiationError("Must Enter Valid Course");
		}

		this.classDifficulty_1_5 = classDifficulty_1_5;
		this.futureWorkRate_neg5_pos5 = futureWorkRate_neg5_pos5;
		this.course = course;
		this.dateOrderedItemList = new ArrayList<Item>();
		this.startDate = this.course.getStartDate();
		this.endDate = this.course.getEndDate();
		this.currentDate = new Date();
		this.currentAverage = this.course.getCourseGrade();

	}

	public void updateAll() {

		// update - check for a supplied test date
		if (this.testCurrentDate == null) {
			this.updateCurrentDate();
		} else {
			this.currentDate = this.testCurrentDate;
		}

		// clear previous data points
		this.gradePredictionCurvePoints.clear();
		this.bestGradePredictionCurvePoints.clear();
		this.worstGradePredictionCurvePoints.clear();

		// add CURRENT - ORGINAL grade data points
		this.gradePredictionCurvePoints.add(new DataPoint(this.currentDate,
				this.currentAverage));
		this.bestGradePredictionCurvePoints.add(new DataPoint(this.currentDate,
				this.currentAverage));
		this.worstGradePredictionCurvePoints.add(new DataPoint(
				this.currentDate, this.currentAverage));

		// find time periods --- get number of weeks --- and left over days
		int numDays = GradeTrendGraph.getDateDiffDays(this.currentDate,
				this.endDate);
		int numWeeks = numDays / 7;
		int remainDays = numDays % 7;

		// initialize calendar
		Calendar c = Calendar.getInstance();
		c.setTime(this.currentDate);

		// loop through num weeks and calculate data point for each week
		for (int i = 0; i < numWeeks; i++) {

			// update the graph to find next weeks's values
			this.updateGraph();

			// update necessary calculated value for next update
			this.currentAverage = this.predictedGrade;

			// increment current date a week
			c.add(Calendar.DATE, 7);
			this.setCurrentDate(c.getTime());

		}

		// check for remaining days
		if (remainDays != 0) {
			c.add(Calendar.DATE, remainDays);
			this.setCurrentDate(c.getTime());
			this.updateGraph();
		}

	}

	// Updates all instance variables, averages, predictions, data points
	// and trends in accordance with the most up to date course items.
	// Takes in various factors which will all be used to decide the
	// Steepness Factor ==> which is the overall neg or pos variation between
	// data points, STARTING at the actual current average as the initial fixed
	// point
	public void updateGraph() {

		// update and sort item list by date and date scope
		this.updateAndOrganizeItemListByDate();

		// update item frequencies according to date scope
		this.itemFrequencies = this.course.getItemFrequency(this.startDate,
				this.endDate);

		// take shorter half of item grades towards
		// current date compared to average for trend adjustment
		// by evaluating to a steepness factor adjustment
		double varAvg = this.getRecentGradeVariation();

		// take into account user given class difficulty to affect
		// the steepness factor
		System.out.println(varAvg);
		varAvg *= GradeTrendGraph.getPercentChangeValue(3,
				this.classDifficulty_1_5);
		System.out.println("var1 --- " + varAvg);

		// take into account user given future work rate to affect
		// the steepness factor
		varAvg *= GradeTrendGraph.getPercentChangeValue(0,
				this.futureWorkRate_neg5_pos5);

		// use item frequencies to predict max / min variations
		// for POSSIBLE EXTREMES for best / worst / average grade cases
		this.updateExtremeGrades();

		// Take into account time remaining for flexibility of curve
		double percentDaysRemaining = GradeTrendGraph.getPercenDaysRemaining(
				this.currentDate, this.endDate,
				GradeTrendGraph.getDateDiffDays(this.startDate, this.endDate));
		double avgChange = varAvg - this.currentAverage;
		// find percent average change to keep based off of remaining time
		// disregard at > 50% time left
		if (percentDaysRemaining < 0.5) {
			avgChange *= percentDaysRemaining;
		}
		// add the final calculated change to the original average and set as
		// nominal grade prediction
		this.predictedGrade = this.currentAverage + avgChange;

		// use updated nominal prediction to update PREDICTED best / worst
		this.predictedBestCaseGrade = (this.predictedGrade
				+ this.currentAverage + this.bestCaseGrade) / 3;
		this.predictedWorstCaseGrade = (this.predictedGrade
				+ this.currentAverage + this.worstCaseGrade) / 3;

		// Update trends and create their respective data points
		// ---Data points X and Y are affected by an overall steepness factor
		// (determined by ALL of these calculated and given factors)
		// which will be used to determine the rise / run variations of each
		// point separation

		// incremented date the next weeks prediction
		Calendar c = Calendar.getInstance();
		c.setTime(this.currentDate);
		c.add(Calendar.DATE, 7);
		Date date = c.getTime();
		
		if (date.compareTo(this.endDate) > 0) {
			date = this.endDate;
		}

		this.gradePredictionCurvePoints.add(new DataPoint(date,
				this.predictedGrade));
		this.bestGradePredictionCurvePoints.add(new DataPoint(date,
				this.predictedBestCaseGrade));
		this.worstGradePredictionCurvePoints.add(new DataPoint(date,
				this.predictedWorstCaseGrade));

	}

	public static double getPercenDaysRemaining(Date start, Date end, int total) {
		int daysRemain = GradeTrendGraph.getDateDiffDays(start, end);
		return ((double) daysRemain) / total;
	}

	public static int getDateDiffDays(Date start, Date end) {
		return (int) ((end.getTime() - start.getTime()) / (1000 * 60 * 60 * 24));
	}

	public static double getPercentChangeValue(int midPoint, int value) {
		double change = 1;

		// can influence grade up to 25% + or - for Work Rate
		// and 10% + or - for class difficulty
		double diffVal = Math.abs(midPoint - value) * 0.05;

		if (value < midPoint) {
			change -= diffVal;
		} else {
			change += diffVal;
		}
		return change;
	}

	public int findCategoryIndex(Category c, ArrayList<Category> cats) {
		int i = -1;
		for (int j = 0; j < cats.size(); j++) {
			if (cats.get(j).getName() == c.getName()
					&& cats.get(j).getWeight() == c.getWeight()) {
				i = j;
			}
		}
		return i;
	}

	public double getRecentGradeVariation() {

		int size = this.dateOrderedItemList.size();
		int midIndex = (size / 2) + (size % 2);

		// adjustMidIndex to include all grades from last overlapping day
		while (midIndex > 0
				&& this.dateOrderedItemList
						.get(midIndex)
						.getUpdateDate()
						.equals(this.dateOrderedItemList.get(midIndex - 1)
								.getUpdateDate())) {
			midIndex--;
		}

		List<Item> list = this.dateOrderedItemList.subList(midIndex, size);

		// create new temp course to calculate weighted avg
		Course courseTemp = new Course("temp");

		// go through upper items date list
		for (Item item : list) {

			// got through current courses categories to find respective weight
			for (Category cat : this.course.getCategories()) {

				if (cat.getItemList().contains(item)) {

					// check to see if category already exists
					int index = this.findCategoryIndex(cat,
							courseTemp.getCategories());
					if (index >= 0) {
						courseTemp.getCategories().get(index).addItem(item);
					} else {
						Category newCat = new Category(cat.getName(),
								cat.getWeight());
						newCat.addItem(item);
						courseTemp.addCategory(newCat);
					}

					break;
				}
			}

		}

		return (courseTemp.getCourseGrade() + this.currentAverage) / 2;

	}

	public void updateExtremeGrades() {
		Set<String> categories = this.itemFrequencies.keySet();

		boolean isZero = true;

		int daysPassed = GradeTrendGraph.getDateDiffDays(this.startDate, this.currentDate);
		if (daysPassed == 0) {
			daysPassed = 1;
		}

		int daysRemaining = GradeTrendGraph.getDateDiffDays(this.currentDate, this.endDate);

		Course tempMinCourse = new Course("tempCourse");
		Course tempMaxCourse = new Course("tempMaxCourse");
		ArrayList<Category> cats = this.course.getCategories();

		for (String cat : categories) {
			int freq = this.itemFrequencies.get(cat);
			double currentRatio = (freq + 0.0) / daysPassed;
			int predictedItems = (int) ((currentRatio * daysRemaining) + 0.5);
			if (predictedItems > 0) {
				isZero = false;
			}
			double weight = this.getCategoryWeight(cats, cat);
			ArrayList<Item> currItems = this.getCategoryItems(cats, cat);
			Category newMinCat = new Category(cat, predictedItems, weight);
			for (int i = 0; i < newMinCat.getItemList().size(); i++) {
				newMinCat.getItemList().get(i).setEarnedPoints("0");
				newMinCat.getItemList().get(i).setTotalPoints("100");
			}
			for (Item i : currItems) {
				i.setName(i.getName() + "temppppp");
				newMinCat.addItem(i);
			}

			tempMinCourse.addCategory(newMinCat);

			Category newMaxCat = new Category(cat, predictedItems, weight);
			for (int i = 0; i < newMaxCat.getItemList().size(); i++) {
				newMaxCat.getItemList().get(i).setEarnedPoints("100");
				newMaxCat.getItemList().get(i).setTotalPoints("100");
			}
			for (Item i : currItems) {
				newMaxCat.addItem(i);
			}
			tempMaxCourse.addCategory(newMaxCat);
		}

		if (isZero) {
			this.worstCaseGrade = 0;
			this.bestCaseGrade = 100;
		} else {
			this.worstCaseGrade = (int) (tempMinCourse.getCourseGrade() + 0.5);
			this.bestCaseGrade = (int) (tempMaxCourse.getCourseGrade() + 0.5);
		}

	}

	public double getCategoryWeight(ArrayList<Category> cats, String cat) {
		double weight = 0;
		for (Category c : cats) {
			if (c.getName().equals(cat)) {
				weight = c.getWeight();
				break;
			}
		}
		return weight;
	}

	public ArrayList<Item> getCategoryItems(ArrayList<Category> cats, String cat) {
		for (Category c : cats) {
			if (c.getName().equals(cat)) {
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

				// check to make sure each item is within user given date scope
				if (!(item.getUpdateDate().compareTo(this.startDate) < 0 || item
						.getUpdateDate().compareTo(this.endDate) > 0)) {

					// insert into item list by date
					this.insertItemIntoItemDateList(item, 0,
							this.dateOrderedItemList.size() / 2);
				}
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
		return this.endDate;
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
		return this.startDate;
	}

	/**
	 * @param currentDate
	 * 
	 */
	public void updateCurrentDate() {

		// check for possible lower current date than new start date

		if (this.currentDate.compareTo(this.startDate) < 0) {
			this.currentDate = this.startDate;
		} else if (this.currentDate.compareTo(this.endDate) > 0) {
			this.currentDate = this.endDate;
		} else {
			this.currentDate = new Date();
		}
	}

	/**
	 * @param currentDate
	 *            the current Date to set
	 */
	public void setCurrentDate(Date date) {

		this.currentDate = date;

		if (this.currentDate.compareTo(this.startDate) < 0) {
			this.currentDate = this.startDate;
		} else if (this.currentDate.compareTo(this.endDate) > 0) {
			this.currentDate = this.endDate;
		}
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {

		this.startDate = startDate;
	}

	public double getWorstCaseGrade() {
		return this.worstCaseGrade;
	}

	public double getBestCaseGrade() {
		return this.bestCaseGrade;
	}

	/**
	 * @return the bestGradePredictionCurvePoints
	 */
	public ArrayList<DataPoint> getBestGradePredictionCurvePoints() {
		return bestGradePredictionCurvePoints;
	}

	/**
	 * @return the worstGradePredictionCurvePoints
	 */
	public ArrayList<DataPoint> getWorstGradePredictionCurvePoints() {
		return worstGradePredictionCurvePoints;
	}

	/**
	 * @return the gradePredictionCurvePoints
	 */
	public ArrayList<DataPoint> getGradePredictionCurvePoints() {
		return gradePredictionCurvePoints;
	}

	/**
	 * @return the predictedBestCaseGrade
	 */
	public double getPredictedBestCaseGrade() {
		return this.predictedBestCaseGrade;
	}

	/**
	 * @return the predictedWorstCaseGrade
	 */
	public double getPredictedWorstCaseGrade() {
		return this.predictedWorstCaseGrade;
	}

	/**
	 * @return the predictedGrade
	 */
	public double getPredictedGrade() {
		return this.predictedGrade;
	}

	/**
	 * Sets the current date, for test purposes
	 */
	public void setTestCurrentDate(Date date) {
		this.testCurrentDate = date;
	}

}
