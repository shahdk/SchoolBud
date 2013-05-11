import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.Box;
import javax.swing.JCheckBox;
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
 * @author padillbt-1. Created May 8, 2013.
 */
public class SchedulerMenu extends JMenuBar {
	/**
	 * Defualt serial version id
	 */
	private static final long serialVersionUID = 1L;
	private JMenu add;
	private JMenu remove;
	private Locale currentLocale;
	private ResourceBundle messages;
	private JMenuItem course;
	private JMenuItem section;
	private JMenuItem rmCourse;
	private JMenuItem rmSection;
	private SchedulerComponent component;

	SchedulerMenu(Locale locale, SchedulerComponent component) {
		this.currentLocale = locale;
		this.messages = ResourceBundle.getBundle("MessagesBundle",
				this.currentLocale);
		this.component = component;
		this.initialize();
	}

	public final void initialize() {
		this.add = new JMenu(this.messages.getString("add"));
		this.course = new JMenuItem(this.messages.getString("course"));
		this.course.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JPanel myPanel = new JPanel();
				JTextField nameField = new JTextField(15);
				JCheckBox optional = new JCheckBox(messages
						.getString("optional"), false);

				myPanel.add(new JLabel(SchedulerMenu.this.messages
						.getString("name")));
				myPanel.add(nameField);
				myPanel.add(Box.createHorizontalStrut(10));
				myPanel.add(optional);

				int result = JOptionPane.showConfirmDialog(null, myPanel,
						SchedulerMenu.this.messages.getString("course"),
						JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					SchedulerCourse course = new SchedulerCourse(nameField
							.getText(), new ArrayList<ClassSection>(), optional
							.isSelected());
					SchedulerMenu.this.component.addCourse(course);
				}
			}

		});

		this.section = new JMenuItem(this.messages.getString("section"));
		this.section.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				ArrayList<ClassDay> week = ClassSection.create7DayArrayList();
				JPanel topPanel = new JPanel(new GridLayout(3, 3));

				JPanel teacherPanel = new JPanel(new GridLayout(1, 2));
				JPanel mondayPanel = new JPanel(new GridLayout(1, 2));
				JPanel tuesdayPanel = new JPanel(new GridLayout(1, 2));
				JPanel wednesdayPanel = new JPanel(new GridLayout(1, 2));
				JPanel thursdayPanel = new JPanel(new GridLayout(1, 2));
				JPanel fridayPanel = new JPanel(new GridLayout(1, 2));
				JPanel saturdayPanel = new JPanel(new GridLayout(1, 2));
				JPanel sundayPanel = new JPanel(new GridLayout(1, 2));
				JPanel sectionPanel = new JPanel(new GridLayout(1, 2));

				JTextField nameField = new JTextField(10);
				JTextField sectionField = new JTextField(10);
				JTextField sectionField1 = new JTextField(10);
				JTextField sectionField2 = new JTextField(10);
				JTextField sectionField3 = new JTextField(10);
				JTextField sectionField4 = new JTextField(10);
				JTextField sectionField5 = new JTextField(10);
				JTextField sectionField6 = new JTextField(10);
				JTextField sectionField7 = new JTextField(10);

				teacherPanel.add(new JLabel(messages.getString("teacherName")));
				teacherPanel.add(nameField);

				mondayPanel.add(new JLabel(messages.getString("mondayHours")));
				mondayPanel.add(sectionField);

				tuesdayPanel.add(new JLabel(messages.getString("tuesdayHours")));
				tuesdayPanel.add(sectionField1);

				wednesdayPanel.add(new JLabel(messages
						.getString("wednesdayHours")));
				wednesdayPanel.add(sectionField2);

				thursdayPanel.add(new JLabel(messages
						.getString("thursdayHours")));
				thursdayPanel.add(sectionField3);

				fridayPanel.add(new JLabel(messages.getString("fridayHours")));
				fridayPanel.add(sectionField4);

				saturdayPanel.add(new JLabel(messages
						.getString("saturdayHours")));
				saturdayPanel.add(sectionField5);

				sundayPanel.add(new JLabel(messages.getString("sundayHours")));
				sundayPanel.add(sectionField6);

				sectionPanel.add(new JLabel(messages.getString("section")
						+ " #"));
				sectionPanel.add(sectionField7);

				topPanel.add(teacherPanel);
				topPanel.add(mondayPanel);
				topPanel.add(tuesdayPanel);
				topPanel.add(wednesdayPanel);
				topPanel.add(thursdayPanel);
				topPanel.add(fridayPanel);
				topPanel.add(saturdayPanel);
				topPanel.add(sundayPanel);
				topPanel.add(sectionPanel);

				if (component.getCourseSize() > 0) {
					if (!component.getSelectedCourse().equals("----")) {
						int result = JOptionPane.showConfirmDialog(null,
								topPanel, messages.getString("section"),
								JOptionPane.OK_CANCEL_OPTION);

						if (result == JOptionPane.OK_OPTION) {

							if (!sectionField.getText().isEmpty()) {
								ArrayList<Integer> hours = getNumbers(sectionField
										.getText());
								ClassDay days = new ClassDay(hours);
								week.set(0, days);
							}

							if (!sectionField1.getText().isEmpty()) {
								ArrayList<Integer> hours1 = getNumbers(sectionField1
										.getText());
								ClassDay days1 = new ClassDay(hours1);
								week.set(1, days1);
							}

							if (!sectionField2.getText().isEmpty()) {
								ArrayList<Integer> hours2 = getNumbers(sectionField2
										.getText());
								ClassDay days2 = new ClassDay(hours2);
								week.set(2, days2);
							}

							if (!sectionField3.getText().isEmpty()) {
								ArrayList<Integer> hours3 = getNumbers(sectionField3
										.getText());
								ClassDay days3 = new ClassDay(hours3);
								week.set(3, days3);
							}

							if (!sectionField4.getText().isEmpty()) {
								ArrayList<Integer> hours4 = getNumbers(sectionField4
										.getText());
								ClassDay days4 = new ClassDay(hours4);
								week.set(4, days4);
							}

							if (!sectionField5.getText().isEmpty()) {
								ArrayList<Integer> hours5 = getNumbers(sectionField5
										.getText());
								ClassDay days5 = new ClassDay(hours5);
								week.set(5, days5);
							}

							if (!sectionField6.getText().isEmpty()) {
								ArrayList<Integer> hours6 = getNumbers(sectionField6
										.getText());
								ClassDay days6 = new ClassDay(hours6);
								week.set(6, days6);
							}

							ClassSection section = new ClassSection(nameField
									.getText(), week);
							section.setSection(sectionField7.getText());
							SchedulerMenu.this.component.addSection(section);
						}
					}
				}

			}

		});

		this.add.add(this.course);
		this.add.add(this.section);

		this.remove = new JMenu(this.messages.getString("remove"));

		this.rmCourse = new JMenuItem(this.messages.getString("course"));
		this.rmCourse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if (component.getCourseSize() > 0) {
					System.out.println("hi");
					component.removeCourse();
				}
			}

		});

		this.rmSection = new JMenuItem(this.messages.getString("section"));
		this.rmSection.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if (component.getSectionSize() > 0) {
					component.removeSection();
				}
			}

		});

		this.remove.add(this.rmCourse);
		this.remove.add(this.rmSection);

		add(this.add);
		add(this.remove);
	}

	public ArrayList<Integer> getNumbers(String nums) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		String[] temp = nums.split(" ");
		int sum = 0;
		for (int i = 0; i < temp.length; i++) {
			numbers.add(Integer.parseInt(temp[i]));
		}
		return numbers;

	}
}
