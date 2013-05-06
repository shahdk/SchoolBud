import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * TODO Put here a description of what this class does.
 * 
 * @author padillbt-1. Created Apr 18, 2013.
 */
public class SchoolBudGUIComponent extends JPanel implements ActionListener {

	/**
	 * Default serial version unique id.
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> quarterList;
	private JComboBox<String> classList;
	private JComboBox<String> categoryList;
	private JPanel comboPanel;
	private JPanel quarterPanel;
	private JPanel coursePanel;
	private JPanel categoryPanel;
	private JPanel bottomPanel;
	private ArrayList<Quarter> quarters;
	private final int NUM_COLS = 6;
	private SchoolBudGUITable table;
	private JTextField courseGrade;
	private JTextField letterGrade;
	private JTextField targetGrade;
	private JTextField neededGrade;
	private JTextField quarterGPA;
	private JTextField overAllGPA;
	private JButton calculate;

	public SchoolBudGUIComponent() {
		super(new BorderLayout());
		this.quarters = new ArrayList<Quarter>();

		String[] quarterStrings = { "----" };

		String[] names = { "Item Name", "Earned Points", "Total Points",
				"Update Date", "Category", "Remove" };
		this.table = new SchoolBudGUITable(names, "item");

		this.quarterList = new JComboBox<String>(quarterStrings);
		this.quarterList.setSelectedIndex(0);
		this.quarterList.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent event) {
				JComboBox<String> box = (JComboBox<String>) event.getSource();
				String quarterName = (String) box.getSelectedItem();
				updateLabel(quarterName);
			}

		});

		this.classList = new JComboBox<String>();
		this.classList.setPrototypeDisplayValue("XXXXXXXXXX");
		this.classList.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent event) {
				JComboBox<String> box = (JComboBox<String>) event.getSource();
				String courseName = (String) box.getSelectedItem();
				updateTable(courseName);
				updateCategoryList(courseName);
			}
		});

		this.categoryList = new JComboBox<String>();
		this.classList.setPrototypeDisplayValue("XXXXXXXXXX");

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
				double target = Double.parseDouble(targetGrade.getText());
				for (Quarter q : quarters) {
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

		JLabel courseGradeLabel = new JLabel("  Course Grade:");
		JLabel letterGradeLabel = new JLabel("  Letter Grade:");
		JLabel targetGradeLabel = new JLabel("  Target Grade:");
		JLabel neededGradeLabel = new JLabel("  Needed Grade:");
		JLabel quarterGPALabel = new JLabel("  Quarter GPA:");
		JLabel overAllGPALabel = new JLabel("  Overall GPA:");
		Font f = new Font("Times New Roman", Font.BOLD, 12);
		courseGradeLabel.setFont(f);
		letterGradeLabel.setFont(f);
		targetGradeLabel.setFont(f);
		neededGradeLabel.setFont(f);
		quarterGPALabel.setFont(f);
		overAllGPALabel.setFont(f);

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

		courseGradePanel.add(courseGradeLabel);
		courseGradePanel.add(this.courseGrade);

		letterGradePanel.add(letterGradeLabel);
		letterGradePanel.add(this.letterGrade);

		targetGradePanel.add(targetGradeLabel);
		targetGradePanel.add(this.targetGrade);

		neededGradePanel.add(neededGradeLabel);
		neededGradePanel.add(this.neededGrade);

		quarterGPAPanel.add(quarterGPALabel);
		quarterGPAPanel.add(this.quarterGPA);

		overAllGPAPanel.add(overAllGPALabel);
		overAllGPAPanel.add(this.overAllGPA);

		this.calculate = new JButton("Calculate Grades");
		this.calculate.addActionListener(this);

		JLabel qt = new JLabel("Quarter");
		JLabel cr = new JLabel("Course");
		JLabel ct = new JLabel("Category");
		Font f1 = new Font("Times New Roman", Font.BOLD, 17);
		qt.setFont(f1);
		cr.setFont(f1);
		ct.setFont(f1);

		this.quarterPanel.add(qt, BorderLayout.NORTH);
		this.quarterPanel.add(this.quarterList, BorderLayout.SOUTH);

		this.coursePanel.add(cr, BorderLayout.NORTH);
		this.coursePanel.add(this.classList, BorderLayout.SOUTH);

		this.categoryPanel.add(ct, BorderLayout.NORTH);
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

	public void updateQuarters(ArrayList<Quarter> updatedQuarters) {
		this.quarters = updatedQuarters;
		String[] newQuarters = new String[this.quarters.size()];

		for (int i = 0; i < this.quarters.size(); i++) {
			newQuarters[i] = this.quarters.get(i).getName();
		}

		this.quarterList
				.setModel(new DefaultComboBoxModel<String>(newQuarters));
	}

	public void updateLabel(String name) {
		for (Quarter current : this.quarters) {
			if (current.getName().equals(name)) {
				String[] newCourses = new String[current.getCourseList().size()];

				for (int i = 0; i < current.getCourseList().size(); i++) {
					newCourses[i] = current.getCourseList().get(i)
							.getCourseName();
				}

				this.classList.setModel(new DefaultComboBoxModel<String>(
						newCourses));
				break;
			}
		}
	}

	public void updateCategoryList(String name) {
		for (Quarter current : this.quarters) {
			if (current.getName().equals(this.getSelectedQuarter())) {
				for (Course course : current.getCourseList()) {
					if (course.getCourseName().equals(name)) {
						String[] newCat = new String[course.getCategories()
								.size()];
						for (int i = 0; i < course.getCategories().size(); i++) {
							newCat[i] = course.getCategories().get(i).getName();
						}
						this.categoryList
								.setModel(new DefaultComboBoxModel<String>(
										newCat));
						return;
					}
				}
			}
		}
	}

	public void updateTable(String name) {
		this.table.reset();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		for (Quarter current : this.quarters) {
			for (Course course : current.getCourseList()) {
				if (course.getCourseName().equals(name)) {
					for (Category cat : course.getCategories()) {
						int numItems = cat.getItemList().size();

						if(numItems == 0){
							continue;
						}
						Object[][] newItems = new Object[numItems][this.NUM_COLS];

						for (int i = 0; i < numItems; i++) {

							Object[] info = new Object[this.NUM_COLS];
							info[0] = (cat.getItemList().get(i).getName());
							info[1] = cat.getItemList().get(i)
									.getEarnedPoints();
							info[2] = cat.getItemList().get(i).getTotalPoints();
							info[3] = sdf.format(cat.getItemList().get(i)
									.getUpdateDate());
							info[4] = cat.getName();
							info[5] = false;
							newItems[i] = info;
						}

						this.table.addInitialItems(newItems, numItems);
					}
					this.table.addEmptyRow();
					this.table.setQuarters(quarters, getSelectedQuarter(),
							getSelectedCourse());
					return;
				}
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource().equals(this.calculate)) {
			double target = Double.parseDouble(targetGrade.getText());
			for (Quarter q : quarters) {
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

	public void calculateGrades() {
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

	public String getSelectedQuarter() {
		return (String) this.quarterList.getSelectedItem();
	}

	public String getSelectedCourse() {
		return (String) this.classList.getSelectedItem();
	}

	public String getSelectedCategory() {
		return (String) this.categoryList.getSelectedItem();
	}

	public void addNewQuarter(ArrayList<Quarter> newQuarters) {
		updateQuarters(newQuarters);
		updateLabel(getSelectedQuarter());
		updateCategoryList(this.getSelectedCourse());
		updateTable(this.getSelectedCourse());
	}

	public void addNewCourse(Course newCourse) {
		for (Quarter current : this.quarters) {
			if (current.getName().equals(getSelectedQuarter())) {
				current.addCourse(newCourse);
				updateLabel(getSelectedQuarter());
				updateCategoryList(this.getSelectedCourse());
				break;
			}
		}
	}

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

	public void editQuarter(String name) {
		for (Quarter current : this.quarters) {
			if (current.getName().equals(getSelectedQuarter())) {
				current.setName(name);
				addNewQuarter(this.quarters);
			}
			break;
		}
	}

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
						updateLabel(getSelectedQuarter());
					}
				}
			}
		}
	}

	public void updateHeadings(ArrayList<String> headings) {
		String[] newHeadings = new String[headings.size()];
		for (int i = 0; i < headings.size(); i++) {
			newHeadings[i] = headings.get(i);
		}
		this.table.changeHeaderValues(newHeadings);
	}

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
