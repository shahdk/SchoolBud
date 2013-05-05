import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.Box;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * TODO Put here a description of what this class does.
 * 
 * @author padillbt-1. Created Apr 23, 2013.
 */
public class SchoolBudGUIMenu extends JMenuBar {

	private JMenu add;
	private JMenu language;
	private JMenu file;
	private JMenu edit;
	private JMenu view;
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
	private JFrame frame;
	private QuarterMain main;
	private SchoolBudGUIComponent component;
	private final JFileChooser chooser;
	private SchoolBudGUITable table;

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
						// do nothing
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
					String name = nameField.getText();
					Quarter newCourse = new Quarter(name);
					SchoolBudGUIMenu.this.main.addQuarter(newCourse);
					SchoolBudGUIMenu.this.component
							.addNewQuarter(SchoolBudGUIMenu.this.main
									.getQuarterList());
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
					if (numItemField.getText().equals("")) {
						Category newCategory = new Category(
								nameField.getText(), Double
										.parseDouble(weightField.getText()));
						component.addNewCategory(newCategory);
					} else {
						Category newCategory = new Category(
								nameField.getText(), Integer
										.parseInt(numItemField.getText()),
								Double.parseDouble(weightField.getText()));
						component.addNewCategory(newCategory);
					}
				}
			}

		});

		this.add.add(this.course);
		this.add.add(this.quarter);
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
						component.editCourse(name, creditHours, start, end);
					} catch (Exception exp) {
						// do nothing
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
					String name = nameField.getText();
					component.editQuarter(name);
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
					String name = nameField.getText();
					double weight = Double.parseDouble(weightField.getText());
					component.editCategory(name, weight);
				}
			}

		});

		this.editRubric = new JMenuItem(this.messages.getString("rubric"));
		this.editRubric.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {

				JPanel myPanel = new JPanel();
				String[] names = { "Grade", "Points" };

				table = new SchoolBudGUITable(names);

				myPanel.add(table.getJScrollPane());

				int result = JOptionPane.showConfirmDialog(null, myPanel,
						SchoolBudGUIMenu.this.messages.getString("editRubric"),
						JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					System.out.println("working rubric");
				}
			}

		});

		this.edit.add(this.editCourse);
		this.edit.add(this.editQuarter);
		this.edit.add(this.editCategory);
		this.edit.add(this.editRubric);

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
				if (chooser.showOpenDialog(component) != JFileChooser.APPROVE_OPTION) {
					return;
				}
				String filePath = chooser.getSelectedFile().getPath();

				try {
					main.saveFile(filePath);
				} catch (Exception exception) {
					// TODO Auto-generated catch-block stub.
					exception.printStackTrace();
				}

			}

		});

		this.load = new JMenuItem(this.messages.getString("load"));
		this.load.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {

				if (chooser.showOpenDialog(component) != JFileChooser.APPROVE_OPTION) {
					return;
				}

				String filePath = chooser.getSelectedFile().getPath();
				try {
					main.loadFile(filePath);
				} catch (Exception exception) {
					// TODO Auto-generated catch-block stub.
					exception.printStackTrace();
				}

				SchoolBudGUIMenu.this.component
						.addNewQuarter(SchoolBudGUIMenu.this.main
								.getQuarterList());
				SchoolBudGUIMenu.this.component.calculateGrades();

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

				int result = JOptionPane
						.showConfirmDialog(null, myPanel,
								SchoolBudGUIMenu.this.messages
										.getString("editQuarter"),
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
				JPanel myPanel = new JPanel();

				int result = JOptionPane
						.showConfirmDialog(null, myPanel,
								SchoolBudGUIMenu.this.messages
										.getString("editQuarter"),
								JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					//
				}
			}

		});

		this.view.add(this.trending);
		this.view.add(this.schedule);

		add(this.file);
		add(this.add);
		add(this.edit);
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

		this.english.setText(this.messages.getString("english"));
		this.spanish.setText(this.messages.getString("spanish"));

		this.save.setText(this.messages.getString("save"));
		this.load.setText(this.messages.getString("load"));
		this.exit.setText(this.messages.getString("exit"));

		this.view.setText(this.messages.getString("view"));
		this.trending.setText(this.messages.getString("trending"));
		this.schedule.setText(this.messages.getString("schedule"));

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

}
