import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import javax.swing.Box;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * TODO Put here a description of what this class does.
 * 
 * @author padillbt-1. Created Apr 23, 2013.
 */
public class SchoolBudGUIMenu extends JMenuBar {

	/**
	 * Default serial version id
	 */
	private static final long serialVersionUID = 1L;
	private JMenu add;
	private JMenu language;
	private JMenu file;
	private JMenu edit;
	private JMenu view;
	private JMenu remove;
	private Locale currentLocale;
	private ResourceBundle messages;
	private JMenuItem course;
	private JMenuItem quarter;
	private JMenuItem category;
	private JMenuItem editCourse;
	private JMenuItem editQuarter;
	private JMenuItem editCategory;
	private JMenuItem editRubric;
	private JMenuItem english;
	private JMenuItem spanish;
	private JMenuItem save;
	private JMenuItem load;
	private JMenuItem exit;
	private JMenuItem trending;
	private JMenuItem schedule;
	private JMenuItem rmQuarter;
	private JMenuItem rmCourse;
	private JMenuItem rmCat;
	private JFrame frame;
	private QuarterMain main;
	private SchoolBudGUIComponent component;
	private final JFileChooser chooser;
	private SchoolBudGUITable rubricTable;
	private final int NUM_COLS = 5;

	public SchoolBudGUIMenu(JFrame frame, SchoolBudGUIComponent component) {
		this.frame = frame;
		this.currentLocale = new Locale("en", "US");
		this.messages = ResourceBundle.getBundle("MessagesBundle",
				this.currentLocale);
		this.main = new QuarterMain();
		this.component = component;
		this.chooser = new JFileChooser();
		this.initialize();

	}

	public final void initialize() {
		this.add = new JMenu(this.messages.getString("add"));
		this.language = new JMenu(this.messages.getString("language"));
		this.file = new JMenu(this.messages.getString("file"));
		this.edit = new JMenu(this.messages.getString("edit"));
		this.view = new JMenu(this.messages.getString("view"));
		this.remove = new JMenu(this.messages.getString("remove"));

		this.course = new JMenuItem(this.messages.getString("course"));
		this.course.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JTextField nameField = new JTextField(10);
				JTextField creditField = new JTextField(5);
				JTextField startField = new JTextField(5);
				JTextField endField = new JTextField(5);

				JPanel myPanel = new JPanel();
				myPanel.add(new JLabel(SchoolBudGUIMenu.this.messages
						.getString("name")));
				myPanel.add(nameField);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel(SchoolBudGUIMenu.this.messages
						.getString("weight")));
				myPanel.add(creditField);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel(SchoolBudGUIMenu.this.messages
						.getString("startDate")));
				myPanel.add(startField);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel(SchoolBudGUIMenu.this.messages
						.getString("endDate")));
				myPanel.add(endField);

				int result = JOptionPane.showConfirmDialog(null, myPanel,
						SchoolBudGUIMenu.this.messages.getString("newCourse"),
						JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					String name = nameField.getText();
					String start = startField.getText();
					String end = endField.getText();
					String credit = creditField.getText();
					SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

					try {
						Course newCourse = new Course(name, Double
								.parseDouble(credit), sdf.parse(start), sdf
								.parse(end));
						SchoolBudGUIMenu.this.component.addNewCourse(newCourse);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(
								SchoolBudGUIMenu.this.frame, "Invalid Input");
					}
				}
			}

		});

		this.quarter = new JMenuItem(this.messages.getString("quarter"));
		this.quarter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JTextField nameField = new JTextField(10);
				JPanel myPanel = new JPanel();
				myPanel.add(new JLabel(SchoolBudGUIMenu.this.messages
						.getString("name")));
				myPanel.add(nameField);

				int result = JOptionPane.showConfirmDialog(null, myPanel,
						SchoolBudGUIMenu.this.messages.getString("newQuarter"),
						JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					try {
						String name = nameField.getText();
						Quarter newCourse = new Quarter(name);
						SchoolBudGUIMenu.this.main.addQuarter(newCourse);
						SchoolBudGUIMenu.this.component
								.addNewQuarter(SchoolBudGUIMenu.this.main
										.getQuarterList());
					} catch (Exception exp) {
						JOptionPane.showMessageDialog(
								SchoolBudGUIMenu.this.frame, "Invalid Input");
					}
				}
			}

		});

		this.category = new JMenuItem(this.messages.getString("category"));
		this.category.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JTextField nameField = new JTextField(10);
				JTextField weightField = new JTextField(5);
				JTextField numItemField = new JTextField(5);

				JPanel myPanel = new JPanel();
				myPanel.add(new JLabel(SchoolBudGUIMenu.this.messages
						.getString("name")));
				myPanel.add(nameField);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel(SchoolBudGUIMenu.this.messages
						.getString("weight")));
				myPanel.add(weightField);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel(SchoolBudGUIMenu.this.messages
						.getString("numItem")));
				myPanel.add(numItemField);

				int result = JOptionPane
						.showConfirmDialog(null, myPanel,
								SchoolBudGUIMenu.this.messages
										.getString("newCategory"),
								JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					try {
						if (numItemField.getText().equals("")) {
							Category newCategory = new Category(nameField
									.getText(), Double.parseDouble(weightField
									.getText()));
							SchoolBudGUIMenu.this.component
									.addNewCategory(newCategory);
						} else {
							Category newCategory = new Category(nameField
									.getText(), Integer.parseInt(numItemField
									.getText()), Double.parseDouble(weightField
									.getText()));
							SchoolBudGUIMenu.this.component
									.addNewCategory(newCategory);
							SchoolBudGUIMenu.this.component
									.updateTable(SchoolBudGUIMenu.this.component
											.getSelectedCourse());
						}
					} catch (Exception exp) {
						JOptionPane.showMessageDialog(
								SchoolBudGUIMenu.this.frame, "Invalid Input");
					}
				}
			}

		});

		this.add.add(this.quarter);
		this.add.add(this.course);
		this.add.add(this.category);

		this.editCourse = new JMenuItem(this.messages.getString("course"));
		this.editCourse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JTextField nameField = new JTextField(10);
				JTextField creditField = new JTextField(5);
				JTextField startField = new JTextField(5);
				JTextField endField = new JTextField(5);

				JPanel myPanel = new JPanel();
				myPanel.add(new JLabel(SchoolBudGUIMenu.this.messages
						.getString("name")));
				myPanel.add(nameField);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel(SchoolBudGUIMenu.this.messages
						.getString("weight")));
				myPanel.add(creditField);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel(SchoolBudGUIMenu.this.messages
						.getString("startDate")));
				myPanel.add(startField);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel(SchoolBudGUIMenu.this.messages
						.getString("endDate")));
				myPanel.add(endField);

				int result = JOptionPane.showConfirmDialog(null, myPanel,
						SchoolBudGUIMenu.this.messages.getString("editCourse"),
						JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					try {
						String name = nameField.getText();
						double creditHours = Double.parseDouble(creditField
								.getText());
						SimpleDateFormat sdf = new SimpleDateFormat(
								"MM/dd/yyyy");
						Date start = sdf.parse(startField.getText());
						Date end = sdf.parse(endField.getText());
						SchoolBudGUIMenu.this.component.editCourse(name,
								creditHours, start, end);
					} catch (Exception exp) {
						JOptionPane.showMessageDialog(
								SchoolBudGUIMenu.this.frame, "Invalid Input");
					}
				}
			}

		});

		this.editQuarter = new JMenuItem(this.messages.getString("quarter"));
		this.editQuarter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JTextField nameField = new JTextField(10);
				JPanel myPanel = new JPanel();
				myPanel.add(new JLabel(SchoolBudGUIMenu.this.messages
						.getString("name")));
				myPanel.add(nameField);

				int result = JOptionPane
						.showConfirmDialog(null, myPanel,
								SchoolBudGUIMenu.this.messages
										.getString("editQuarter"),
								JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					try {
						String name = nameField.getText();
						SchoolBudGUIMenu.this.component.editQuarter(name);
					} catch (Exception exp) {
						JOptionPane.showMessageDialog(
								SchoolBudGUIMenu.this.frame, "Invalid Input");
					}
				}
			}

		});

		this.editCategory = new JMenuItem(this.messages.getString("category"));
		this.editCategory.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JTextField nameField = new JTextField(10);
				JTextField weightField = new JTextField(5);

				JPanel myPanel = new JPanel();
				myPanel.add(new JLabel(SchoolBudGUIMenu.this.messages
						.getString("name")));
				myPanel.add(nameField);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel(SchoolBudGUIMenu.this.messages
						.getString("weight")));
				myPanel.add(weightField);
				myPanel.add(Box.createHorizontalStrut(15));

				int result = JOptionPane.showConfirmDialog(null, myPanel,
						SchoolBudGUIMenu.this.messages
								.getString("editCategory"),
						JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					try {
						String name = nameField.getText();
						double weight = Double.parseDouble(weightField
								.getText());
						SchoolBudGUIMenu.this.component.editCategory(name,
								weight);
					} catch (Exception exp) {
						JOptionPane.showMessageDialog(
								SchoolBudGUIMenu.this.frame, "Invalid Input");
					}
				}
			}

		});

		this.editRubric = new JMenuItem(this.messages.getString("rubric"));
		this.editRubric.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {

				JPanel myPanel = new JPanel();
				String[] names = { SchoolBudGUIMenu.this.messages.getString("letgrade") , SchoolBudGUIMenu.this.messages.getString("lowerlimit"),
						SchoolBudGUIMenu.this.messages.getString("upperlimit"), SchoolBudGUIMenu.this.messages.getString("gpa"), SchoolBudGUIMenu.this.messages.getString("remove") };

				try {
					SchoolBudGUIMenu.this.rubricTable = new SchoolBudGUITable(
							names, "rubric");
					SchoolBudGUIMenu.this.rubricTable.setQuarters(
							SchoolBudGUIMenu.this.main.getQuarterList(),
							SchoolBudGUIMenu.this.component
									.getSelectedQuarter(),
							SchoolBudGUIMenu.this.component.getSelectedCourse());

					populateRubric();
					myPanel.add(SchoolBudGUIMenu.this.rubricTable
							.getJScrollPane());

					JOptionPane.showConfirmDialog(null, myPanel,
							SchoolBudGUIMenu.this.messages
									.getString("editRubric"),
							JOptionPane.DEFAULT_OPTION);
				} catch (Exception exp) {
					JOptionPane.showMessageDialog(SchoolBudGUIMenu.this.frame,
							"Invalid Input");
				}
			}

		});

		this.edit.add(this.editQuarter);
		this.edit.add(this.editCourse);
		this.edit.add(this.editCategory);
		this.edit.add(this.editRubric);

		this.rmQuarter = new JMenuItem(this.messages.getString("quarter"));
		this.rmQuarter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				main.removeQuarter(component.getSelectedQuarter());
				component.updateQuarters(main.getQuarterList());
				component.updateCourses(component.getSelectedQuarter());
				component.updateTable(component.getSelectedCourse());
				component.updateCategoryList(component.getSelectedCourse());
				component.calculateGrades();
				return;
			}

		});

		this.rmCourse = new JMenuItem(this.messages.getString("course"));
		this.rmCourse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (Quarter q : main.getQuarterList()) {
					if (q.getName().equals(component.getSelectedQuarter())) {
						for (int i = 0; i < q.getCourseList().size(); i++) {
							if (q.getCourseList().get(i).getCourseName()
									.equals(component.getSelectedCourse())) {
								q.removeCourse(q.getCourseList().get(i));
								component.updateCourses(component
										.getSelectedQuarter());
								component.updateCategoryList(component
										.getSelectedCourse());
								component.updateTable(component
										.getSelectedCourse());
								component.calculateGrades();
								return;
							}
						}
					}
				}
			}
		});

		this.rmCat = new JMenuItem(this.messages.getString("category"));
		this.rmCat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (Quarter q : main.getQuarterList()) {
					if (q.getName().equals(component.getSelectedQuarter())) {
						for (Course c : q.getCourseList()) {
							if (c.getCourseName().equals(
									component.getSelectedCourse())) {
								for (int i = 0; i < c.getCategories().size(); i++) {
									if (c.getCategories()
											.get(i)
											.getName()
											.equals(component
													.getSelectedCategory())) {
										c.removeCategory(component
												.getSelectedCategory());
										component.updateCategoryList(component
												.getSelectedCourse());
										component.updateTable(component
												.getSelectedCourse());
										component.calculateGrades();
										return;
									}
								}
							}
						}
					}
				}
			}

		});

		this.remove.add(this.rmQuarter);
		this.remove.add(this.rmCourse);
		this.remove.add(this.rmCat);

		this.english = new JMenuItem(this.messages.getString("english"));
		this.english.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				updateText("en", "US");
			}

		});

		this.spanish = new JMenuItem(this.messages.getString("spanish"));
		this.spanish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				updateText("ca", "ES");
			}

		});

		this.language.add(this.english);
		this.language.add(this.spanish);

		this.save = new JMenuItem(this.messages.getString("save"));
		this.save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if (SchoolBudGUIMenu.this.chooser.showDialog(
						SchoolBudGUIMenu.this.component,
						messages.getString("save")) != JFileChooser.APPROVE_OPTION) {
					return;
				}
				String filePath = SchoolBudGUIMenu.this.chooser
						.getSelectedFile().getPath();

				try {
					SchoolBudGUIMenu.this.main.saveFile(filePath);
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(SchoolBudGUIMenu.this.frame,
							"Invalid Input");
				}

			}

		});

		this.load = new JMenuItem(this.messages.getString("load"));
		this.load.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {

				if (SchoolBudGUIMenu.this.chooser.showDialog(
						SchoolBudGUIMenu.this.component,
						messages.getString("load")) != JFileChooser.APPROVE_OPTION) {
					return;
				}

				String filePath = SchoolBudGUIMenu.this.chooser
						.getSelectedFile().getPath();
				try {
					SchoolBudGUIMenu.this.main.loadFile(filePath);
					SchoolBudGUIMenu.this.component
							.addNewQuarter(SchoolBudGUIMenu.this.main
									.getQuarterList());
					SchoolBudGUIMenu.this.component.calculateGrades();
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(SchoolBudGUIMenu.this.frame,
							"Invalid Input");
				}
			}

		});

		this.exit = new JMenuItem(this.messages.getString("exit"));
		this.exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				SchoolBudGUIMenu.this.frame.setVisible(false);
				SchoolBudGUIMenu.this.frame.dispose();
			}

		});

		this.file.add(this.save);
		this.file.add(this.load);
		this.file.add(this.exit);

		this.trending = new JMenuItem(this.messages.getString("trending"));
		this.trending.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JPanel myPanel = new JPanel();

				int result = JOptionPane.showConfirmDialog(null, myPanel,
						SchoolBudGUIMenu.this.messages.getString("trending"),
						JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					//
				}
			}

		});

		this.schedule = new JMenuItem(this.messages.getString("schedule"));
		this.schedule.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				SchedulerFrame frame = new SchedulerFrame(
						SchoolBudGUIMenu.this.currentLocale);
				frame.setVisible(true);

			}

		});

		this.view.add(this.trending);
		this.view.add(this.schedule);

		add(this.file);
		add(this.add);
		add(this.edit);
		add(this.remove);
		add(this.view);
		add(this.language);

	}

	public void updateText(String language, String country) {
		this.currentLocale = new Locale(language, country);
		this.messages = ResourceBundle.getBundle("MessagesBundle",
				this.currentLocale);

		this.add.setText(this.messages.getString("add"));
		this.language.setText(this.messages.getString("language"));
		this.file.setText(this.messages.getString("file"));
		this.edit.setText(this.messages.getString("edit"));

		this.course.setText(this.messages.getString("course"));
		this.quarter.setText(this.messages.getString("quarter"));
		this.category.setText(this.messages.getString("category"));

		this.editCourse.setText(this.messages.getString("course"));
		this.editQuarter.setText(this.messages.getString("quarter"));
		this.editCategory.setText(this.messages.getString("category"));
		this.editRubric.setText(this.messages.getString("rubric"));
		
		this.rmQuarter.setText(this.messages.getString("quarter"));
		this.rmCourse.setText(this.messages.getString("course"));
		this.rmCat.setText(this.messages.getString("category"));

		this.english.setText(this.messages.getString("english"));
		this.spanish.setText(this.messages.getString("spanish"));

		this.save.setText(this.messages.getString("save"));
		this.load.setText(this.messages.getString("load"));
		this.exit.setText(this.messages.getString("exit"));

		this.view.setText(this.messages.getString("view"));
		this.trending.setText(this.messages.getString("trending"));
		this.schedule.setText(this.messages.getString("schedule"));

		this.component.updateTitles(this.currentLocale);

		translateHeadings();
	}

	public void translateHeadings() {
		ArrayList<String> headings = new ArrayList<String>();
		headings.add(this.messages.getString("itemName"));
		headings.add(this.messages.getString("earnedPoints"));
		headings.add(this.messages.getString("totalPoints"));
		headings.add(this.messages.getString("updateDate"));
		headings.add(this.messages.getString("category"));
		headings.add(this.messages.getString("remove"));
		this.component.updateHeadings(headings);
	}
	
	public void populateRubric() {
		for (Quarter q : this.main.getQuarterList()) {
			if (q.getName().equals(this.component.getSelectedQuarter())) {
				for (Course c : q.getCourseList()) {
					if (c.getCourseName().equals(
							this.component.getSelectedCourse())) {
						Rubric r = c.getRubric();
						Set<String> letterGrades = r.getGradeList();
						String[] gr = new String[letterGrades.size()];
						int i = 0;
						for (String x : letterGrades) {
							gr[i] = x;
							i++;
						}
						insertSort(gr);
						Object data[][] = new Object[gr.length][this.NUM_COLS];
						for (int j = 0; j < gr.length; j++) {
							data[j][0] = gr[j];
							data[j][1] = r.getLowerLimit(gr[j]) + "";
							data[j][2] = r.getUpperLimit(gr[j]) + "";
							data[j][3] = r.getGPA(gr[j]) + "";
							data[j][4] = false;
						}
						this.rubricTable.addInitialItems(data, i);
						this.rubricTable.addEmptyRowRubric();
						return;
					}
				}
			}
		}
	}

	public void insertSort(String[] A) {
		for (int i = 1; i < A.length; i++) {
			String value = A[i];
			int j = i - 1;
			while (j >= 0 && A[j].compareTo(value) > 0) {
				A[j + 1] = A[j];
				j = j - 1;
			}
			A[j + 1] = value;
		}
	}
}
