import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class is the JPanel that contains all the components to be added onto
 * the JFrame
 * 
 * @author padillbt-1. Created Apr 18, 2013.
 */
public class SchoolBudGUIComponent extends JPanel implements ActionListener {

	/**
	 * Default serial version unique id.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Dropdown list of quarters
	 */
	private JComboBox quarterList;
	/**
	 * Dropdown list of courses
	 */
	private JComboBox classList;
	/**
	 * Dropdown list of categories
	 */
	private JComboBox categoryList;
	/**
	 * Panel encapsulating the quarter, category and courses panel
	 */
	private JPanel comboPanel;
	/**
	 * Panel encapsulating the drop down list and label for quarters.
	 */
	private JPanel quarterPanel;
	/**
	 * Panel encapsulating the drop down list and label for courses.
	 */
	private JPanel coursePanel;
	/**
	 * Panel encapsulating the drop down list and label for category.
	 */
	private JPanel categoryPanel;
	/**
	 * Panel encapsulating the labels for displaying grades.
	 */
	private JPanel bottomPanel;
	/**
	 * List of quarters
	 */
	private ArrayList<Quarter> quarters;
	/**
	 * Number of columns for table displaying items.
	 */
	private final int NUM_COLS = 6;
	/**
	 * The table for displaying items
	 */
	private SchoolBudGUITable table;
	/**
	 * Textfield to display course grade in %.
	 */
	private JTextField courseGrade;
	/**
	 * Textfield to display course letter grade.
	 */
	private JTextField letterGrade;
	/**
	 * Textfield to display the target grade for course.
	 */
	private JTextField targetGrade;
	/**
	 * Textfield to display the needed grade for the course.
	 */
	private JTextField neededGrade;
	/**
	 * Textfield to display quarter gpa.
	 */
	private JTextField quarterGPA;
	/**
	 * Textfield to display the total gpa of all quarters..
	 */
	private JTextField overAllGPA;
	/**
	 * Button to calculate the grades
	 */
	private JButton calculate;
	/**
	 * Label for course grade.
	 */
	private JLabel courseGradeLabel;
	/**
	 * Label for letter course grade.
	 */
	private JLabel letterGradeLabel;
	/**
	 * Label for target course grade.
	 */
	private JLabel targetGradeLabel;
	/**
	 * Label for needed course grade.
	 */
	private JLabel neededGradeLabel;
	/**
	 * Label for quarter gpa
	 */
	private JLabel quarterGPALabel;
	/**
	 * Label for overall gpa
	 */
	private JLabel overAllGPALabel;
	/**
	 * Label for Quarter
	 */
	private JLabel qt;
	/**
	 * Label for category
	 */
	private JLabel ct;
	/**
	 * Label for Courses
	 */
	private JLabel cr;

	/**
	 * This constructor initializes and adds the components onto the JPanel to
	 * be added onto the JFrame. It also places action listeners on the
	 * JOptionBoxes and JButtons
	 * 
	 */
	public SchoolBudGUIComponent() {
		super(new BorderLayout());
		this.quarters = new ArrayList<Quarter>();

		String[] quarterStrings = { "----" };

		String[] names = { "Item Name", "Earned Points", "Total Points",
				"Update Date", "Category", "Remove" };
		this.table = new SchoolBudGUITable(names, "item");

		this.quarterList = new JComboBox(quarterStrings);
		this.quarterList.setSelectedIndex(0);
		this.quarterList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JComboBox box = (JComboBox) event.getSource();
				String quarterName = (String) box.getSelectedItem();
				updateCourses(quarterName);
				updateCategoryList(getSelectedCourse());
				updateTable(getSelectedCourse());
				calculateGrades();
			}

		});

		this.classList = new JComboBox();
		this.classList.setPrototypeDisplayValue("XXXXXXXXXX");
		this.classList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JComboBox box = (JComboBox) event.getSource();
				String courseName = (String) box.getSelectedItem();
				updateTable(courseName);
				updateCategoryList(courseName);
				calculateGrades();
			}
		});

		this.categoryList = new JComboBox();
		this.categoryList.setPrototypeDisplayValue("XXXXXXXXXX");

		this.comboPanel = new JPanel();
		this.comboPanel.setLayout(new BorderLayout());

		this.quarterPanel = new JPanel();
		this.quarterPanel.setLayout(new BorderLayout());

		this.coursePanel = new JPanel();
		this.coursePanel.setLayout(new BorderLayout());

		this.categoryPanel = new JPanel();
		this.categoryPanel.setLayout(new BorderLayout());

		this.bottomPanel = new JPanel();
		this.bottomPanel.setLayout(new GridLayout(4, 2));

		this.courseGrade = new JTextField("0.0");
		this.courseGrade.setEditable(false);
		this.letterGrade = new JTextField("0.0");
		this.letterGrade.setEditable(false);
		this.targetGrade = new JTextField("0.0");
		this.targetGrade.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				double target = Double
						.parseDouble(SchoolBudGUIComponent.this.targetGrade
								.getText());
				for (Quarter q : SchoolBudGUIComponent.this.quarters) {
					if (q.getName().equals(getSelectedQuarter())) {
						for (int i = 0; i < q.getCourseList().size(); i++) {
							if (q.getCourseList().get(i).getCourseName()
									.equals(getSelectedCourse())) {
								q.getCourseList().get(i).setTargetGrade(target);
							}
						}
					}
				}
			}

		});
		this.neededGrade = new JTextField("0.0");
		this.neededGrade.setEditable(false);
		this.quarterGPA = new JTextField("0.0");
		this.quarterGPA.setEditable(false);
		this.overAllGPA = new JTextField("0.0");
		this.overAllGPA.setEditable(false);

		this.courseGradeLabel = new JLabel("  Course Grade:");
		this.letterGradeLabel = new JLabel("  Letter Grade:");
		this.targetGradeLabel = new JLabel("  Target Grade:");
		this.neededGradeLabel = new JLabel("  Needed Grade:");
		this.quarterGPALabel = new JLabel("  Quarter GPA:");
		this.overAllGPALabel = new JLabel("  Overall GPA:");
		Font f = new Font("Times New Roman", Font.BOLD, 12);
		this.courseGradeLabel.setFont(f);
		this.letterGradeLabel.setFont(f);
		this.targetGradeLabel.setFont(f);
		this.neededGradeLabel.setFont(f);
		this.quarterGPALabel.setFont(f);
		this.overAllGPALabel.setFont(f);

		JPanel courseGradePanel = new JPanel();
		JPanel letterGradePanel = new JPanel();
		JPanel targetGradePanel = new JPanel();
		JPanel neededGradePanel = new JPanel();
		JPanel quarterGPAPanel = new JPanel();
		JPanel overAllGPAPanel = new JPanel();
		courseGradePanel.setLayout(new GridLayout(1, 2));
		letterGradePanel.setLayout(new GridLayout(1, 2));
		targetGradePanel.setLayout(new GridLayout(1, 2));
		neededGradePanel.setLayout(new GridLayout(1, 2));
		quarterGPAPanel.setLayout(new GridLayout(1, 2));
		overAllGPAPanel.setLayout(new GridLayout(1, 2));

		courseGradePanel.add(this.courseGradeLabel);
		courseGradePanel.add(this.courseGrade);

		letterGradePanel.add(this.letterGradeLabel);
		letterGradePanel.add(this.letterGrade);

		targetGradePanel.add(this.targetGradeLabel);
		targetGradePanel.add(this.targetGrade);

		neededGradePanel.add(this.neededGradeLabel);
		neededGradePanel.add(this.neededGrade);

		quarterGPAPanel.add(this.quarterGPALabel);
		quarterGPAPanel.add(this.quarterGPA);

		overAllGPAPanel.add(this.overAllGPALabel);
		overAllGPAPanel.add(this.overAllGPA);

		this.calculate = new JButton("Calculate Grades");
		this.calculate.addActionListener(this);

		this.qt = new JLabel("Quarter");
		this.cr = new JLabel("Course");
		this.ct = new JLabel("Category");
		Font f1 = new Font("Times New Roman", Font.BOLD, 17);
		this.qt.setFont(f1);
		this.cr.setFont(f1);
		this.ct.setFont(f1);

		this.quarterPanel.add(this.qt, BorderLayout.NORTH);
		this.quarterPanel.add(this.quarterList, BorderLayout.SOUTH);

		this.coursePanel.add(this.cr, BorderLayout.NORTH);
		this.coursePanel.add(this.classList, BorderLayout.SOUTH);

		this.categoryPanel.add(this.ct, BorderLayout.NORTH);
		this.categoryPanel.add(this.categoryList, BorderLayout.SOUTH);

		this.comboPanel.add(this.quarterPanel, BorderLayout.NORTH);
		this.comboPanel.add(this.coursePanel, BorderLayout.CENTER);
		this.comboPanel.add(this.categoryPanel, BorderLayout.SOUTH);

		this.bottomPanel.add(courseGradePanel);
		this.bottomPanel.add(letterGradePanel);
		this.bottomPanel.add(targetGradePanel);
		this.bottomPanel.add(neededGradePanel);
		this.bottomPanel.add(quarterGPAPanel);
		this.bottomPanel.add(overAllGPAPanel);
		this.bottomPanel.add(this.calculate);

		add(this.comboPanel, BorderLayout.PAGE_START);
		add(this.table.getJScrollPane(), BorderLayout.CENTER);
		add(this.bottomPanel, BorderLayout.SOUTH);
		this.classList.setSize(this.quarterList.getSize());
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		repaint();
	}

	/**
	 * This method updates the list of quarters depending on the quarters that
	 * exist in the ArrayList passed in.
	 * 
	 * @param updatedQuarters
	 */
	public void updateQuarters(ArrayList<Quarter> updatedQuarters) {
		this.quarters = updatedQuarters;
		String[] newQuarters = new String[this.quarters.size()];

		for (int i = 0; i < this.quarters.size(); i++) {
			newQuarters[i] = this.quarters.get(i).getName();
		}

		this.quarterList.setModel(new DefaultComboBoxModel(newQuarters));
	}

	/**
	 * This method updates the text throughout the component depending on the
	 * inputted Locale
	 * 
	 * @param locale
	 */
	public void updateTitles(Locale locale) {
		ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle",
				locale);
		this.courseGradeLabel.setText(messages.getString("courseGrade"));
		this.letterGradeLabel.setText(messages.getString("letterGrade"));
		this.targetGradeLabel.setText(messages.getString("targetGrade"));
		this.neededGradeLabel.setText(messages.getString("neededGrade"));
		this.quarterGPALabel.setText(messages.getString("quarterGPA"));
		this.overAllGPALabel.setText(messages.getString("overallGPA"));

		Font f = new Font("Times New Roman", Font.BOLD, 12);
		this.courseGradeLabel.setFont(f);
		this.letterGradeLabel.setFont(f);
		this.targetGradeLabel.setFont(f);
		this.neededGradeLabel.setFont(f);
		this.quarterGPALabel.setFont(f);
		this.overAllGPALabel.setFont(f);

		this.qt.setText(messages.getString("quarter"));
		this.ct.setText(messages.getString("category"));
		this.cr.setText(messages.getString("course"));

		Font f1 = new Font("Times New Roman", Font.BOLD, 17);
		this.qt.setFont(f1);
		this.cr.setFont(f1);
		this.ct.setFont(f1);

		this.calculate.setText(messages.getString("calculateGrades"));

	}

	/**
	 * This method updates the list of courses depending upon the inputted
	 * quarter name
	 * 
	 * @param name
	 */
	public void updateCourses(String name) {
		if (name == null) {
			this.classList.setModel(new DefaultComboBoxModel());
			return;
		}
		for (Quarter current : this.quarters) {
			if (current.getName().equals(name)) {
				String[] newCourses = new String[current.getCourseList().size()];

				for (int i = 0; i < current.getCourseList().size(); i++) {
					newCourses[i] = current.getCourseList().get(i)
							.getCourseName();
				}

				this.classList.setModel(new DefaultComboBoxModel(newCourses));
				return;
			}
		}
	}

	/**
	 * This method updates the list of available categories depending upon the
	 * inputted course name
	 * 
	 * @param name
	 */
	public void updateCategoryList(String name) {
		if (name == null) {
			this.categoryList.setModel(new DefaultComboBoxModel());
			return;
		}
		for (Quarter current : this.quarters) {
			if (current.getName().equals(this.getSelectedQuarter())) {
				for (Course course : current.getCourseList()) {
					if (course.getCourseName().equals(name)) {
						String[] newCat = new String[course.getCategories()
								.size()];
						for (int i = 0; i < course.getCategories().size(); i++) {
							newCat[i] = course.getCategories().get(i).getName();
						}
						this.categoryList.setModel(new DefaultComboBoxModel(
								newCat));
						return;
					}
				}
			}
		}
	}

	/**
	 * This method updates the data in the table depending upon the current
	 * quarter and inputted course name
	 * 
	 * @param name
	 */
	public void updateTable(String name) {
		this.table.reset();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		for (Quarter current : this.quarters) {
			if (current.getName().equals(this.getSelectedQuarter())) {
				for (Course course : current.getCourseList()) {
					if (course.getCourseName().equals(name)) {
						int pos = 0;
						for (Category cat : course.getCategories()) {

							if (pos == 3) {
								pos = 0;
							}

							int numItems = cat.getItemList().size();

							if (numItems == 0) {
								continue;
							}
							Object[][] newItems = new Object[numItems][this.NUM_COLS];

							for (int i = 0; i < numItems; i++) {

								Object[] info = new Object[this.NUM_COLS];
								info[0] = (cat.getItemList().get(i).getName());
								info[1] = cat.getItemList().get(i)
										.getEarnedPoints();
								info[2] = cat.getItemList().get(i)
										.getTotalPoints();
								info[3] = sdf.format(cat.getItemList().get(i)
										.getUpdateDate());
								info[4] = cat.getName();
								info[5] = false;
								newItems[i] = info;
							}

							this.table.setTableColor(cat.getName(), pos);
							pos++;
							this.table.addInitialItems(newItems, numItems);
						}
						this.table.addEmptyRow();
						this.table.setQuarters(this.quarters,
								getSelectedQuarter(), getSelectedCourse());
						return;
					}
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource().equals(this.calculate)) {
			double target = Double.parseDouble(this.targetGrade.getText());
			for (Quarter q : this.quarters) {
				if (q.getName().equals(getSelectedQuarter())) {
					for (int i = 0; i < q.getCourseList().size(); i++) {
						if (q.getCourseList().get(i).getCourseName()
								.equals(getSelectedCourse())) {
							q.getCourseList().get(i).setTargetGrade(target);
						}
					}
				}
			}
			this.calculateGrades();
		}
	}

	/**
	 * This method calculates the GPA of the selected quarter
	 * 
	 */
	public void calculateGrades() {
		this.courseGrade.setText("0.0");
		this.letterGrade.setText("0.0");
		this.targetGrade.setText("0.0");
		this.neededGrade.setText("0.0");
		this.quarterGPA.setText("0.0");
		this.overAllGPA.setText("0.0");
		double totalGPA = 0;
		double quarterCount = 0;
		for (Quarter q : this.quarters) {
			totalGPA += q.getQuarterGPA();
			if (q.getCourseList().size() > 0) {
				quarterCount++;
				if (q.getName().equals(this.getSelectedQuarter())) {
					this.quarterGPA.setText(q.getQuarterGPA() + "");
					for (Course c : q.getCourseList()) {
						if (c.getCourseName().equals(this.getSelectedCourse())) {
							this.courseGrade.setText(c.getCourseGrade() + "");
							this.letterGrade.setText(c.getLetterGrade());
							this.targetGrade.setText(c.getTargetGrade() + "");
							this.neededGrade.setText(c.getNeededCourseGrade()
									+ "");
						}
					}
				}
			}
		}
		double avgGPA = Math.round((totalGPA / quarterCount) * 100.0);
		this.overAllGPA.setText((avgGPA / 100) + "");

	}

	/**
	 * This method returns the selected quarter's name
	 * 
	 * @return quarter name
	 */
	public String getSelectedQuarter() {
		return (String) this.quarterList.getSelectedItem();
	}

	/**
	 * This method returns the selected course's name
	 * 
	 * @return course name
	 */
	public String getSelectedCourse() {
		return (String) this.classList.getSelectedItem();
	}

	/**
	 * This method returns the selected category's name
	 * 
	 * @return category name
	 */
	public String getSelectedCategory() {
		return (String) this.categoryList.getSelectedItem();
	}

	/**
	 * This method adds a new quarter
	 * 
	 * @param newQuarters
	 */
	public void addNewQuarter(ArrayList<Quarter> newQuarters) {
		updateQuarters(newQuarters);
		updateCourses(getSelectedQuarter());
		updateCategoryList(this.getSelectedCourse());
		updateTable(this.getSelectedCourse());
	}

	/**
	 * This method adds a new course
	 * 
	 * @param newCourse
	 */
	public void addNewCourse(Course newCourse) {
		for (Quarter current : this.quarters) {
			if (current.getName().equals(getSelectedQuarter())) {
				current.addCourse(newCourse);
				updateCourses(getSelectedQuarter());
				updateCategoryList(this.getSelectedCourse());
				break;
			}
		}
	}

	/**
	 * This method adds a new Category
	 * 
	 * @param newCategory
	 */
	public void addNewCategory(Category newCategory) {
		for (Quarter current : this.quarters) {
			if (current.getName().equals(getSelectedQuarter())) {
				ArrayList<Course> currentCourses = current.getCourseList();

				for (int i = 0; i < currentCourses.size(); i++) {
					if (currentCourses.get(i).getCourseName()
							.equals(getSelectedCourse())) {
						currentCourses.get(i).addCategory(newCategory);
						updateCategoryList(this.getSelectedCourse());
						return;
					}
				}
			}
		}
	}

	/**
	 * This method changes the name of the selected quarter with the name given
	 * as a parameter
	 * 
	 * @param name
	 */
	public void editQuarter(String name) {
		for (Quarter current : this.quarters) {
			if (current.getName().equals(getSelectedQuarter())) {
				current.setName(name);
				addNewQuarter(this.quarters);
			}
			break;
		}
	}

	/**
	 * This method replaces the information of the selected course with the
	 * information given as parameters
	 * 
	 * @param name
	 * @param creditHours
	 * @param start
	 * @param end
	 */
	public void editCourse(String name, double creditHours, Date start, Date end) {
		for (Quarter current : this.quarters) {
			if (current.getName().equals(getSelectedQuarter())) {
				for (int i = 0; i < current.getCourseList().size(); i++) {
					if (current.getCourseList().get(i).getCourseName()
							.equals(getSelectedCourse())) {
						current.getCourseList().get(i).setName(name);
						current.getCourseList().get(i)
								.setCreditHours(creditHours);
						current.getCourseList().get(i).setStartDate(start);
						current.getCourseList().get(i).setEndDate(end);
						updateCourses(getSelectedQuarter());
					}
				}
			}
		}
	}

	/**
	 * This method updates the table headings for internationalization
	 * 
	 * @param headings
	 */
	public void updateHeadings(ArrayList<String> headings) {
		String[] newHeadings = new String[headings.size()];
		for (int i = 0; i < headings.size(); i++) {
			newHeadings[i] = headings.get(i);
		}
		this.table.changeHeaderValues(newHeadings);
	}

	/**
	 * This method edits the information of the category whose name is given as
	 * a parameter
	 * 
	 * @param name
	 * @param weight
	 */
	public void editCategory(String name, double weight) {
		for (Quarter current : this.quarters) {
			if (current.getName().equals(getSelectedQuarter())) {
				for (Course c : current.getCourseList()) {
					if (c.getCourseName().equals(getSelectedCourse())) {
						for (int i = 0; i < c.getCategories().size(); i++) {
							if (c.getCategories().get(i).getName()
									.equals(this.getSelectedCategory())) {
								c.getCategories().get(i).setName(name);
								c.getCategories().get(i).setWeight(weight);
								updateCategoryList(getSelectedCourse());
								updateTable(getSelectedCourse());
								return;
							}
						}
					}
				}
			}
		}
	}

	/**
	 * This method edits the information of the category whose name is given as
	 * a parameter
	 * 
	 * @param name
	 * @param weight
	 * @param numOfItems
	 */
	public void editCategory(String name, double weight, int numOfItems) {
		for (Quarter current : this.quarters) {
			if (current.getName().equals(getSelectedQuarter())) {
				for (Course c : current.getCourseList()) {
					if (c.getCourseName().equals(getSelectedCourse())) {
						for (int i = 0; i < c.getCategories().size(); i++) {
							if (c.getCategories().get(i).getName()
									.equals(this.getSelectedCategory())) {
								c.getCategories().get(i).setName(name);
								c.getCategories().get(i).setWeight(weight);
								updateCategoryList(name);
								return;
							}
						}
					}
				}
			}
		}
	}

}
