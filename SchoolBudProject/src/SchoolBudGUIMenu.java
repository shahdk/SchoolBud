import java.awt.BorderLayout;
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
 * This class is the JMenuBarto be added onto the JFrame
 * 
 * @author padillbt-1. Created Apr 23, 2013.
 */
public class SchoolBudGUIMenu extends JMenuBar {

	/**
	 * Default serial version id
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * This variable is the add tab in the JMenuBar
	 *
	 */
	private JMenu add;
	/**
	 * This variable is the language tab in the JMenuBar
	 *
	 */
	private JMenu language;
	/**
	 * This variable is the file tab in the JMenuBar
	 *
	 */
	private JMenu file;
	/**
	 * This variable is the edit tab in the JMenuBar
	 *
	 */
	private JMenu edit;
	/**
	 * This variable is the view tab in the JMenuBar
	 *
	 */
	private JMenu view;
	/**
	 * This variable is the remove tab in the JMenuBar
	 *
	 */
	private JMenu remove;
	/**
	 * This variable is the current Locale
	 *
	 */
	private Locale currentLocale;
	/**
	 * This variable is the ResourseBunble used for internationalization
	 *
	 */
	private ResourceBundle messages;
	/**
	 * This variable is the course option in the add tab
	 *
	 */
	private JMenuItem course;
	/**
	 * This variable is the quarter option in the add tab
	 *
	 */
	private JMenuItem quarter;
	/**
	 * This variable is the category option in the add tab
	 *
	 */
	private JMenuItem category;
	/**
	 * This variable is the course option in the edit tab
	 *
	 */
	private JMenuItem editCourse;
	/**
	 * This variable is the quarter option in the edit tab
	 *
	 */
	private JMenuItem editQuarter;
	/**
	 * This variable is the category option in the edit tab
	 *
	 */
	private JMenuItem editCategory;
	/**
	 * This variable is the rubric option in the edit tab
	 *
	 */
	private JMenuItem editRubric;
	/**
	 * This variable is the English option in the language tab
	 *
	 */
	private JMenuItem english;
	/**Spanish option in the language tab
	 *
	 */
	private JMenuItem spanish;
	/**
	 * This variable is the save option in the file tab
	 *
	 */
	private JMenuItem save;
	/**
	 * This variable is the load option in the file tab
	 *
	 */
	private JMenuItem load;
	/**
	 * This variable is the exit option in the file tab
	 *
	 */
	private JMenuItem exit;
	/**
	 * This variable is the trending option in the view tab
	 *
	 */
	private JMenuItem trending;
	/**
	 * This variable is the schedule option in the view tab
	 *
	 */
	private JMenuItem schedule;
	/**
	 * This variable is the quarter option in the remove tab
	 *
	 */
	private JMenuItem rmQuarter;
	/**
	 * This variable is the course option in the remove tab
	 *
	 */
	private JMenuItem rmCourse;
	/**
	 * This variable is the category option in the remove tab
	 *
	 */
	private JMenuItem rmCat;
	/**
	 * This variable is the JFrame for the SchoolBudGUI
	 *
	 */
	private JFrame frame;
	/**
	 * This variable is the Object containing the list of quarters
	 *
	 */
	private QuarterMain main;
	/**
	 * This variable is the JPanel for the SchoolBudGUI
	 *
	 */
	private SchoolBudGUIComponent component;
	/**
	 * This variable is the JChooser to load and save files
	 *
	 */
	private final JFileChooser chooser;
	/**
	 * This variable is the JTable used to store Rubric data
	 *
	 */
	private SchoolBudGUITable rubricTable;
	/**
	 * This variable is the default number of rows for JTables
	 *
	 */
	private final int NUM_COLS = 5;

	/**
	 * This constructor initializes variables and the different components in
	 * the JMenuBar
	 * 
	 * @param frame
	 * @param component
	 */
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

	/**
	 * This method creates the JMenus and JMenuItems for the JMenuBar and adds
	 * the ActionListeners for them
	 * 
	 */
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
						.getString("creditHours")));
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
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");

				nameField.setText(component.getSelectedCourse());
				creditField.setText(getCourse(component.getSelectedCourse()).getCreditHours()+"");
				startField.setText(sdf.format(getCourse(component.getSelectedCourse()).getStartDate()));
				endField.setText(sdf.format(getCourse(component.getSelectedCourse()).getEndDate()));
				
				JPanel myPanel = new JPanel();
				myPanel.add(new JLabel(SchoolBudGUIMenu.this.messages
						.getString("name")));
				myPanel.add(nameField);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel(SchoolBudGUIMenu.this.messages
						.getString("creditHours")));
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
				nameField.setText(component.getSelectedQuarter());
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

				nameField.setText(component.getSelectedCategory());
				weightField.setText(getCategory(component.getSelectedCategory()).getWeight()+"");
				
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
				String[] names = {
						SchoolBudGUIMenu.this.messages.getString("letgrade"),
						SchoolBudGUIMenu.this.messages.getString("lowerlimit"),
						SchoolBudGUIMenu.this.messages.getString("upperlimit"),
						SchoolBudGUIMenu.this.messages.getString("gpa"),
						SchoolBudGUIMenu.this.messages.getString("remove") };

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
				SchoolBudGUIMenu.this.main
						.removeQuarter(SchoolBudGUIMenu.this.component
								.getSelectedQuarter());
				SchoolBudGUIMenu.this.component
						.updateQuarters(SchoolBudGUIMenu.this.main
								.getQuarterList());
				SchoolBudGUIMenu.this.component
						.updateCourses(SchoolBudGUIMenu.this.component
								.getSelectedQuarter());
				SchoolBudGUIMenu.this.component
						.updateTable(SchoolBudGUIMenu.this.component
								.getSelectedCourse());
				SchoolBudGUIMenu.this.component
						.updateCategoryList(SchoolBudGUIMenu.this.component
								.getSelectedCourse());
				SchoolBudGUIMenu.this.component.calculateGrades();
				return;
			}

		});

		this.rmCourse = new JMenuItem(this.messages.getString("course"));
		this.rmCourse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (Quarter q : SchoolBudGUIMenu.this.main.getQuarterList()) {
					if (q.getName().equals(
							SchoolBudGUIMenu.this.component
									.getSelectedQuarter())) {
						for (int i = 0; i < q.getCourseList().size(); i++) {
							if (q.getCourseList()
									.get(i)
									.getCourseName()
									.equals(SchoolBudGUIMenu.this.component
											.getSelectedCourse())) {
								q.removeCourse(q.getCourseList().get(i));
								SchoolBudGUIMenu.this.component
										.updateCourses(SchoolBudGUIMenu.this.component
												.getSelectedQuarter());
								SchoolBudGUIMenu.this.component
										.updateCategoryList(SchoolBudGUIMenu.this.component
												.getSelectedCourse());
								SchoolBudGUIMenu.this.component
										.updateTable(SchoolBudGUIMenu.this.component
												.getSelectedCourse());
								SchoolBudGUIMenu.this.component
										.calculateGrades();
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
				for (Quarter q : SchoolBudGUIMenu.this.main.getQuarterList()) {
					if (q.getName().equals(
							SchoolBudGUIMenu.this.component
									.getSelectedQuarter())) {
						for (Course c : q.getCourseList()) {
							if (c.getCourseName().equals(
									SchoolBudGUIMenu.this.component
											.getSelectedCourse())) {
								for (int i = 0; i < c.getCategories().size(); i++) {
									if (c.getCategories()
											.get(i)
											.getName()
											.equals(SchoolBudGUIMenu.this.component
													.getSelectedCategory())) {
										c.removeCategory(SchoolBudGUIMenu.this.component
												.getSelectedCategory());
										SchoolBudGUIMenu.this.component
												.updateCategoryList(SchoolBudGUIMenu.this.component
														.getSelectedCourse());
										SchoolBudGUIMenu.this.component
												.updateTable(SchoolBudGUIMenu.this.component
														.getSelectedCourse());
										SchoolBudGUIMenu.this.component
												.calculateGrades();
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
						SchoolBudGUIMenu.this.messages.getString("save")) != JFileChooser.APPROVE_OPTION) {
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
						SchoolBudGUIMenu.this.messages.getString("load")) != JFileChooser.APPROVE_OPTION) {
					return;
				}

				String filePath = SchoolBudGUIMenu.this.chooser
						.getSelectedFile().getPath();
				try {
					SchoolBudGUIMenu.this.main.loadFile(filePath);
					SchoolBudGUIMenu.this.component
							.addNewQuarter(SchoolBudGUIMenu.this.main
									.getQuarterList());
					translateHeadings();
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
				
				JFrame graphFrame = new JFrame("Trends Graph");
				graphFrame.setLayout(new BorderLayout());
				
				JPanel pane1 = new JPanel();
				JPanel pane2 = new JPanel();
				JPanel pane3 = new JPanel();
				
				TrendsGraphGUI best = new TrendsGraphGUI(getCourse(component.getSelectedCourse()), 3, 0, 0);
				TrendsGraphGUI worst = new TrendsGraphGUI(getCourse(component.getSelectedCourse()), 3, 0, 1);
				TrendsGraphGUI medium = new TrendsGraphGUI(getCourse(component.getSelectedCourse()), 3, 0, 2);
				
				
				pane1.add(best.showGraph());
				pane2.add(medium.showGraph());
				pane2.add(worst.showGraph());
				
				graphFrame.add(pane1, BorderLayout.NORTH);
				graphFrame.add(pane2, BorderLayout.CENTER);
				graphFrame.add(pane3, BorderLayout.SOUTH);
				graphFrame.pack();
				graphFrame.setVisible(true);
				
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
	
	public Course getCourse(String name){
		for(Quarter q: main.getQuarterList()){
			if(q.getName().equals(component.getSelectedQuarter())){
				for(Course c: q.getCourseList()){
					if(c.getCourseName().equals(name)){
						return c;
					}
				}
			}
		}
			
		return null;
	}
	
	public Category getCategory(String name){
		for(Quarter q: main.getQuarterList()){
			if(q.getName().equals(component.getSelectedQuarter())){
				for(Course c: q.getCourseList()){
					if(c.getCourseName().equals(component.getSelectedCourse())){
						for(Category cat: c.getCategories()){
							if(cat.getName().equals(name)){
								return cat;
							}
						}
					}
				}
			}
		}
			
		return null;
	}

	/**
	 * This method changes the Locale and updates the text in the JMenuBar
	 * 
	 * @param language
	 * @param country
	 */
	public void updateText(String language, String country) {
		this.currentLocale = new Locale(language, country);
		this.messages = ResourceBundle.getBundle("MessagesBundle",
				this.currentLocale);

		this.add.setText(this.messages.getString("add"));
		this.language.setText(this.messages.getString("language"));
		this.file.setText(this.messages.getString("file"));
		this.remove.setText(this.messages.getString("remove"));
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

	/**
	 * This translates the text within the JTable headings
	 * 
	 */
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

	/**
	 * This method places the values within the Rubric
	 * 
	 */
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

	/**
	 * This method chnages the values in the given String[]
	 * 
	 * @param A
	 */
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
