import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * QuaterMain is the class that contains the list of all quarters. It allows a
 * user to add, edit and remove quarters.
 * 
 * @author shahdk
 * 
 */
public class QuarterMain {

	/**
	 * List of all Quarters
	 */
	private ArrayList<Quarter> quarterList;
	/**
	 * Delimiter used to separate Quarters, courses, categories and items.
	 */
	private final String objectDelimiter = "\t";
	/**
	 * Delimiter used to separate the details of various objects. For example,
	 * course name, and credit hours in a course.
	 */
	private final String elementDelimiter = ";";

	/**
	 * Constructor to initialize the list of quarters.
	 */
	public QuarterMain() {
		this.quarterList = new ArrayList<Quarter>();
	}

	/**
	 * Returns the list of quarters.
	 * 
	 * @return an array list of quarters
	 */
	public ArrayList<Quarter> getQuarterList() {
		return this.quarterList;
	}

	/**
	 * Removes a quarter from the list of quarters
	 * 
	 * @param name
	 * @return true if successful in removing a quarter
	 */
	public boolean removeQuarter(String name) {
		for (int i = 0; i < this.quarterList.size(); i++) {
			if (this.quarterList.get(i).getName().equals(name)) {
				this.quarterList.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * Adds a quarter to the list of quarters
	 * 
	 * @param q1
	 */
	public void addQuarter(Quarter q1) {
		for (Quarter q : this.quarterList) {
			if (q.getName().equals(q1.getName())) {
				throw new IllegalArgumentException();
			}
		}
		this.quarterList.add(q1);
	}

	/**
	 * Saves all the information in a txt file with a given file name.
	 * 
	 * @param fileName
	 * @throws Exception
	 */
	public void saveFile(String fileName) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		if (fileName.equals("")) {
			throw new IllegalArgumentException();
		}
		File saveFile = new File(fileName);
		PrintWriter writer = new PrintWriter(saveFile);
		for (Quarter q : this.quarterList) {
			writer.println(q.getName());
			for (Course c : q.getCourseList()) {
				writer.print(this.objectDelimiter + c.getCourseName()
						+ this.elementDelimiter + c.getCreditHours()
						+ this.elementDelimiter + sdf.format(c.getStartDate())
						+ this.elementDelimiter + sdf.format(c.getEndDate())
						+ this.elementDelimiter);
				Rubric r = c.getRubric();
				for (String grade : r.getGradeList()) {
					writer.print(grade + this.elementDelimiter);
					writer.print(r.getLowerLimit(grade) + this.elementDelimiter);
					writer.print(r.getUpperLimit(grade) + this.elementDelimiter);
					writer.print(r.getGPA(grade) + this.elementDelimiter);
				}
				writer.print(c.getTargetGrade()+this.elementDelimiter);
				writer.print("\n");

				for (Category cat : c.getCategories()) {
					writer.println(this.objectDelimiter + this.objectDelimiter
							+ cat.getName() + this.elementDelimiter
							+ cat.getWeight());
					for (Item i : cat.getItemList()) {
						String creationDate = new SimpleDateFormat("MM/dd/yyyy")
								.format(i.getUpdateDate());
						writer.println(this.objectDelimiter
								+ this.objectDelimiter + this.objectDelimiter
								+ i.getName() + this.elementDelimiter
								+ i.getEarnedPoints() + this.elementDelimiter
								+ i.getTotalPoints() + this.elementDelimiter
								+ creationDate);
					}
				}
			}
		}
		writer.close();
	}

	/**
	 * Loads the information about the quarters courses, categories, etc. from
	 * the given file.
	 * 
	 * @param fileName
	 * @throws Exception
	 */
	public void loadFile(String fileName) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		if (fileName.equals("")) {
			throw new IllegalArgumentException();
		}
		this.quarterList.clear();
		int qtCount = 0;
		int courseCount = 0;
		int catCount = 0;
		BufferedReader bReader = new BufferedReader(new FileReader(fileName));
		String line;
		while ((line = bReader.readLine()) != null) {
			String data[] = line.split(this.objectDelimiter);
			if (!data[0].equals("")) {
				this.quarterList.add(new Quarter(data[0]));
				courseCount = 0;
				catCount = 0;
				qtCount++;
			}
			if (this.isCourse(data)) {
				String courseData[] = data[1].split(this.elementDelimiter);
				Course c;
				if (courseData[1].equals("")) {
					c = new Course(courseData[0]);
				} else {
					c = new Course(courseData[0],
							Double.parseDouble(courseData[1]));
				}
				c.setStartDate(sdf.parse(courseData[2]));
				c.setEndDate(sdf.parse(courseData[3]));

				c.setRubric(this.populateRubric(courseData));
				double targetGrade = Double.parseDouble(courseData[courseData.length-1]);
				c.setTargetGrade(targetGrade);
				this.quarterList.get(qtCount - 1).addCourse(c);
				catCount = 0;
				courseCount++;
			}
			if (this.isCategory(data)) {
				String categoryData[] = data[2].split(this.elementDelimiter);
				Category cat = new Category(categoryData[0],
						Double.parseDouble(categoryData[1]));
				this.quarterList.get(qtCount - 1).getCourseList()
						.get(courseCount - 1).addCategory(cat);
				catCount++;
			}
			if (this.isItem(data)) {
				String itemData[] = data[3].split(this.elementDelimiter);
				this.quarterList.get(qtCount - 1).getCourseList()
						.get(courseCount - 1).getCategories().get(catCount - 1)
						.addItem(this.populateItems(itemData));
			}
		}
		bReader.close();
	}

	/**
	 * Private method to populate items when a file is loaded
	 * 
	 * @param itemData
	 * @return
	 * @throws Exception
	 */
	private Item populateItems(String itemData[]) throws Exception {
		Item i;
		String date = itemData[3];
		Date creationDate = new SimpleDateFormat("MM/dd/yyyy").parse(date);
		if (itemData[1].equals("") && itemData[2].equals("")) {
			i = new Item(itemData[0], creationDate);

		} else if (itemData[1].equals("") && !itemData[2].equals("")) {
			i = new Item(itemData[0], itemData[2], creationDate);

		} else {
			i = new Item(itemData[0], itemData[1], itemData[2], creationDate);

		}
		return i;
	}

	/**
	 * Populates a rubric
	 * 
	 * @param courseData
	 * @return Rubric
	 */
	private Rubric populateRubric(String courseData[]) {
		Rubric rubric = new Rubric();
		for (int i = 4; i < courseData.length-1; i += 4) {
			rubric.addGrade(courseData[i],
					Double.parseDouble(courseData[i + 1]),
					Double.parseDouble(courseData[i + 2]),
					Double.parseDouble(courseData[i + 3]));
		}
		return rubric;
	}

	/**
	 * Checks to see is the line in the file is information about the course
	 * 
	 * @param data
	 * @return boolean
	 */
	private boolean isCourse(String data[]) {
		return data[0].equals("") && !data[1].equals("");
	}

	/**
	 * Checks to see is the line in the file is information about the category
	 * 
	 * @param data
	 * @return boolean
	 */
	private boolean isCategory(String data[]) {
		return data[0].equals("") && data[1].equals("") && !data[2].equals("");
	}

	/**
	 * Checks to see is the line in the file is information about the item
	 * 
	 * @param data
	 * @return boolean
	 */
	private boolean isItem(String data[]) {
		return data[0].equals("") && data[1].equals("") && data[2].equals("");
	}
}
