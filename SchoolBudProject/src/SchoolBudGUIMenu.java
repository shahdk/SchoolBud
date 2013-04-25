import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.Box;
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
	private JFrame frame;
	private String name;
	private String weight;

	public SchoolBudGUIMenu(JFrame frame) {
		this.frame = frame;
		this.currentLocale = new Locale("en", "US");
		this.messages = ResourceBundle.getBundle("MessagesBundle",
				this.currentLocale);
		this.initialize();

	}

	public final void initialize() {
		this.add = new JMenu(this.messages.getString("add"));
		this.language = new JMenu(this.messages.getString("language"));
		this.file = new JMenu(this.messages.getString("file"));
		this.edit = new JMenu(this.messages.getString("edit"));

		this.course = new JMenuItem(this.messages.getString("course"));
		this.course.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JTextField nameField = new JTextField(10);
				JTextField creditField = new JTextField(5);
				JTextField startField = new JTextField(5);
				JTextField endField = new JTextField(5);

				JPanel myPanel = new JPanel();
				myPanel.add(new JLabel(messages.getString("name")));
				myPanel.add(nameField);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel(messages.getString("weight")));
				myPanel.add(creditField);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel(messages.getString("startDate")));
				myPanel.add(startField);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel(messages.getString("endDate")));
				myPanel.add(endField);

				int result = JOptionPane.showConfirmDialog(null, myPanel,
						messages.getString("newCourse"), JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					String name = nameField.getText();
					Course newCourse = new Course(name);
					System.out.println(name);
				}
			}

		});

		this.quarter = new JMenuItem(this.messages.getString("quarter"));
		this.quarter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JTextField nameField = new JTextField(10);
				JPanel myPanel = new JPanel();
				myPanel.add(new JLabel(messages.getString("name")));
				myPanel.add(nameField);

				int result = JOptionPane.showConfirmDialog(null, myPanel,
						messages.getString("newQuarter"), JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					String name = nameField.getText();
					Quarter newCourse = new Quarter(name);
					System.out.println(name);
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
				myPanel.add(new JLabel(messages.getString("name")));
				myPanel.add(nameField);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel(messages.getString("weight")));
				myPanel.add(weightField);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel(messages.getString("numItem")));
				myPanel.add(numItemField);

				int result = JOptionPane.showConfirmDialog(null, myPanel,
						messages.getString("newCategory"), JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					if(numItemField.getText().equals("")){
						Category newCategory = new Category(nameField.getText(),
								Integer.parseInt(weightField.getText()));
						System.out.println("no # of items");
					}
					else{
					Category newCategory = new Category(nameField.getText(),
							Integer.parseInt(weightField.getText()), Integer.parseInt(numItemField.getText()));
							System.out.println("# of items");
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
				myPanel.add(new JLabel(messages.getString("name")));
				myPanel.add(nameField);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel(messages.getString("weight")));
				myPanel.add(creditField);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel(messages.getString("startDate")));
				myPanel.add(startField);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel(messages.getString("endDate")));
				myPanel.add(endField);

				int result = JOptionPane.showConfirmDialog(null, myPanel,
						messages.getString("editCourse"), JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					String name = nameField.getText();
					Course newCourse = new Course(name);
					System.out.println(name);
				}
			}

		});
		
		this.editQuarter = new JMenuItem(this.messages.getString("quarter"));
		this.editQuarter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JTextField nameField = new JTextField(10);
				JPanel myPanel = new JPanel();
				myPanel.add(new JLabel(messages.getString("name")));
				myPanel.add(nameField);

				int result = JOptionPane.showConfirmDialog(null, myPanel,
						messages.getString("editQuarter"), JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					String name = nameField.getText();
					Quarter newCourse = new Quarter(name);
					System.out.println(name);
				}
			}

		});
		
		this.editCategory = new JMenuItem(this.messages.getString("category"));
		this.editCategory.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JTextField nameField = new JTextField(10);
				JTextField weightField = new JTextField(5);
				JTextField numItemField = new JTextField(5);

				JPanel myPanel = new JPanel();
				myPanel.add(new JLabel(messages.getString("name")));
				myPanel.add(nameField);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel(messages.getString("weight")));
				myPanel.add(weightField);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel(messages.getString("numItem")));
				myPanel.add(numItemField);

				int result = JOptionPane.showConfirmDialog(null, myPanel,
						messages.getString("editCategory"), JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					if(numItemField.getText().equals("")){
						Category newCategory = new Category(nameField.getText(),
								Integer.parseInt(weightField.getText()));
						System.out.println("no # of items");
					}
					else{
					Category newCategory = new Category(nameField.getText(),
							Integer.parseInt(weightField.getText()), Integer.parseInt(numItemField.getText()));
							System.out.println("# of items");
					}
				}
			}

		});
		
		this.editRubric = new JMenuItem(this.messages.getString("rubric"));
		this.editRubric.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {

				JPanel myPanel = new JPanel();
				
				String[] columnNames = { "Item Name", "Course Name", "S",
						"# of Years", "Options" };

				Object[][] data = {
						{ "Kathy", "Smith", "Snowboarding", new Integer(5),
								new Boolean(false) },
						{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
						{ "Sue", "Black", "Knitting", new Integer(2),
								new Boolean(false) },
						{ "Jane", "White", "Speed reading", new Integer(20),
								new Boolean(true) },
						{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) } };

				final JTable table = new JTable(data, columnNames);
				table.setPreferredScrollableViewportSize(new Dimension(500, 300));
				table.setFillsViewportHeight(true);
				JScrollPane tableSP = new JScrollPane(table);
		        tableSP.setPreferredSize(new Dimension(500, 400));
		        
				myPanel.add(table);

				int result = JOptionPane.showConfirmDialog(null, myPanel,
						messages.getString("editRubric"), JOptionPane.OK_CANCEL_OPTION);
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
				System.out.println("save");
			}

		});
		
		this.load = new JMenuItem(this.messages.getString("load"));
		this.load.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println("load");
			}

		});
		
		this.exit = new JMenuItem(this.messages.getString("exit"));
		this.exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				frame.setVisible(false);
				frame.dispose();
			}

		});

		this.file.add(this.save);
		this.file.add(this.load);
		this.file.add(this.exit);

		add(this.file);
		add(this.add);
		add(this.edit);
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
	}
}
