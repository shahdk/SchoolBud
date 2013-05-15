import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * This class is the JPanel that contains all the components to be added onto
 * the SchedulerFrame
 * 
 * @author padillbt-1. Created May 8, 2013.
 */
public class SchedulerComponent extends JPanel {
	/**
	 * This variable is the JOptionBox containing a list of courses
	 *
	 */
	private JComboBox courseList;
	/**
	 * This variable is the JOptionBox containing a list of sections
	 *
	 */
	private JComboBox sectionList;
	/**
	 * This variable is the JButton that calls the function to schedule classes
	 *
	 */
	private JButton scheduleButton;
	/**
	 * This variable is the JButton that calls the function to check section data
	 *
	 */
	private JButton sectionButton;
	/**
	 * This variable is the JButton that calls the JFrame to input data for the hour filter
	 *
	 */
	private JButton hourButton;
	/**
	 * This variable is the JButton that calls the JFrame to input data for the gap filter
	 *
	 */
	private JButton gapButton;
	/**
	 * This variable is the outermost JPanel 
	 *
	 */
	private JPanel topPanel;
	/**
	 * This variable is the JPanel containing components relevant to courses 
	 *
	 */
	private JPanel coursePanel;
	/**
	 * This variable is the JPanel containing components relevant to sections 
	 *
	 */
	private JPanel classPanel;
	/**
	 * This variable is the JPanel containing JButtons
	 *
	 */
	private JPanel buttonPanel;
	/**
	 * This variable is the JPanel containing the JTables
	 *
	 */
	private JPanel schedulePanel;
	/**
	 * This variable is the JPanel containing components relevant to gap filter 
	 *
	 */
	private JPanel gapPanel;
	/**
	 * This variable is the JPanel containing components relevant to hour filter
	 *
	 */
	private JPanel hourPanel;
	/**
	 * This variable is the JScrollPanel containing JTables
	 *
	 */
	private JScrollPane scheduleScrollPane;
	/**
	 * This variable is the ArrayList containing all Course objects that have been created
	 *
	 */
	private ArrayList<SchedulerCourse> courses;
	/**
	 * This variable is the current Locale
	 *
	 */
	private Locale locale;
	/**
	 * This variable is the ResourceBundle used for internationalization
	 *
	 */
	private ResourceBundle messages;
	/**
	 * This variable is the JCheckBox enabling the hour filter
	 *
	 */
	private JCheckBox hourCheckBox;
	/**
	 * This variable is the JCheckBox enabling the gap filter
	 *
	 */
	private JCheckBox gapCheckBox;
	/**
	 * This variable is an Integer denoting the minimum start hour
	 *
	 */
	private int minStartHour;
	/**
	 * This variable is an Integer denoting the maximum start hour
	 *
	 */
	private int maxEndHour;
	/**
	 * This variable is an ArrayList of days to ignore for hour filter
	 *
	 */
	private ArrayList<Integer> hourIgnoreDays;
	/**
	 * This variable is an ArrayList of days to ignore for gap filter
	 *
	 */
	private ArrayList<Integer> gapIgnoreDays;
	/**
	 * This variable is an Integer denoting the maximum hours per gap
	 *
	 */
	private int maxHoursPerGap;
	/**
	 * This variable is an Integer denoting the maximum hours per gap
	 *
	 */
	private int minHoursPerGap;
	/**
	 * This variable is an Integer denoting the minimum number of filter occurrences
	 *
	 */
	private int minOccurences;
	/**
	 * This variable is an Integer denoting the average number of filter occurrences
	 *
	 */
	private int midOccurences;
	/**
	 * This variable is an Integer denoting the maximum number of filter occurrences
	 *
	 */
	private int maxOccurences;
	/**
	 * This variable is an Integer denoting the maximum number of filter exceptions
	 *
	 */
	private int maxExceptions;

	/**
	 * This constructor initializes the JButtons and JOptionBoxes. Also
	 * implements ActionListeners for the different components
	 * 
	 * @param locale
	 * @param frame
	 */
	public SchedulerComponent(Locale locale) {
		super(new BorderLayout());
		this.courses = new ArrayList<SchedulerCourse>();
		this.locale = locale;
		this.messages = ResourceBundle.getBundle("MessagesBundle", this.locale);

		String[] quarterStrings = { "----" };

		this.courseList = new JComboBox(quarterStrings);
		this.courseList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				updateSection();
			}

		});

		this.sectionList = new JComboBox();
		this.sectionList.setPrototypeDisplayValue("XXXXXXXXXX");

		this.scheduleButton = new JButton(
				this.messages.getString("scheduleCourses"));

		this.scheduleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JPanel myPanel = new JPanel();
				JTextField nameField = new JTextField(10);

				myPanel.add(new JLabel(SchedulerComponent.this.messages
						.getString("classHours")));
				myPanel.add(nameField);

				int result = JOptionPane.showConfirmDialog(null, myPanel,
						SchedulerComponent.this.messages
								.getString("createSchedules"),
						JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {

					int classHours = Integer.parseInt(nameField.getText());
					Scheduler scheduler = new Scheduler(classHours,
							SchedulerComponent.this.courses);
					if (SchedulerComponent.this.hourCheckBox.isSelected()
							&& SchedulerComponent.this.gapCheckBox.isSelected()) {
						scheduler.permutateSchedules();
						scheduler.filterGaps(
								SchedulerComponent.this.maxHoursPerGap,
								SchedulerComponent.this.maxOccurences,
								SchedulerComponent.this.minHoursPerGap,
								SchedulerComponent.this.minOccurences,
								SchedulerComponent.this.midOccurences,
								SchedulerComponent.this.maxExceptions,
								SchedulerComponent.this.gapIgnoreDays);
						createSchedules(scheduler.filterHoursConcentration(
								SchedulerComponent.this.minStartHour,
								SchedulerComponent.this.maxEndHour,
								SchedulerComponent.this.hourIgnoreDays),
								classHours);
					} else if (SchedulerComponent.this.hourCheckBox
							.isSelected()) {
						scheduler.permutateSchedules();
						createSchedules(scheduler.filterHoursConcentration(
								SchedulerComponent.this.minStartHour,
								SchedulerComponent.this.maxEndHour,
								SchedulerComponent.this.hourIgnoreDays),
								classHours);
					} else if (SchedulerComponent.this.gapCheckBox.isSelected()) {
						scheduler.permutateSchedules();
						createSchedules(scheduler.filterGaps(
								SchedulerComponent.this.maxHoursPerGap,
								SchedulerComponent.this.maxOccurences,
								SchedulerComponent.this.minHoursPerGap,
								SchedulerComponent.this.minOccurences,
								SchedulerComponent.this.midOccurences,
								SchedulerComponent.this.maxExceptions,
								SchedulerComponent.this.gapIgnoreDays),
								classHours);
					} else {
						createSchedules(scheduler.permutateSchedules(),
								classHours);
					}

				}
			}

		});

		this.sectionButton = new JButton(this.messages.getString("sectionInfo"));
		this.sectionButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if (getSectionSize() > 0) {
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

					ClassSection currentSection = getCurrentSection();

					JTextField nameField = new JTextField(10);
					nameField.setText(currentSection.getTeacher());
					nameField.setEditable(false);

					JTextField sectionField = new JTextField(10);
					sectionField.setText(makeProperString(currentSection
							.getClassDays().get(0).getHourSlots().toString()));
					sectionField.setEditable(false);

					JTextField sectionField1 = new JTextField(10);
					sectionField1.setText(makeProperString(currentSection
							.getClassDays().get(1).getHourSlots().toString()));
					sectionField1.setEditable(false);

					JTextField sectionField2 = new JTextField(10);
					sectionField2.setText(makeProperString(currentSection
							.getClassDays().get(2).getHourSlots().toString()));
					sectionField2.setEditable(false);

					JTextField sectionField3 = new JTextField(10);
					sectionField3.setText(makeProperString(currentSection
							.getClassDays().get(3).getHourSlots().toString()));
					sectionField3.setEditable(false);

					JTextField sectionField4 = new JTextField(10);
					sectionField4.setText(makeProperString(currentSection
							.getClassDays().get(4).getHourSlots().toString()));
					sectionField4.setEditable(false);

					JTextField sectionField5 = new JTextField(10);
					sectionField5.setText(makeProperString(currentSection
							.getClassDays().get(5).getHourSlots().toString()));
					sectionField5.setEditable(false);

					JTextField sectionField6 = new JTextField(10);
					sectionField6.setText(makeProperString(currentSection
							.getClassDays().get(6).getHourSlots().toString()));
					sectionField6.setEditable(false);

					JTextField sectionField7 = new JTextField(10);
					sectionField7.setText(currentSection.getSection());
					sectionField7.setEditable(false);

					teacherPanel.add(new JLabel(
							SchedulerComponent.this.messages
									.getString("teacherName")));
					teacherPanel.add(nameField);

					mondayPanel.add(new JLabel(SchedulerComponent.this.messages
							.getString("mondayHours")));
					mondayPanel.add(sectionField);

					tuesdayPanel.add(new JLabel(
							SchedulerComponent.this.messages
									.getString("tuesdayHours")));
					tuesdayPanel.add(sectionField1);

					wednesdayPanel.add(new JLabel(
							SchedulerComponent.this.messages
									.getString("wednesdayHours")));
					wednesdayPanel.add(sectionField2);

					thursdayPanel.add(new JLabel(
							SchedulerComponent.this.messages
									.getString("thursdayHours")));
					thursdayPanel.add(sectionField3);

					fridayPanel.add(new JLabel(SchedulerComponent.this.messages
							.getString("fridayHours")));
					fridayPanel.add(sectionField4);

					saturdayPanel.add(new JLabel(
							SchedulerComponent.this.messages
									.getString("saturdayHours")));
					saturdayPanel.add(sectionField5);

					sundayPanel.add(new JLabel(SchedulerComponent.this.messages
							.getString("sundayHours")));
					sundayPanel.add(sectionField6);

					sectionPanel.add(new JLabel(
							SchedulerComponent.this.messages
									.getString("section") + " #"));
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

					Object[] options = { "OK" };
					JOptionPane.showOptionDialog(null, topPanel,
							SchedulerComponent.this.messages
									.getString("course"),
							JOptionPane.PLAIN_MESSAGE,
							JOptionPane.QUESTION_MESSAGE, null, options,
							options[0]);

				}

			}

		});

		this.gapPanel = new JPanel(new BorderLayout());
		this.hourPanel = new JPanel(new BorderLayout());

		this.gapButton = new JButton(this.messages.getString("filterGaps"));
		this.gapButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JPanel topPanel = new JPanel(new GridLayout(2, 4));

				JPanel maxHourPanel = new JPanel(new GridLayout(1, 2));
				JPanel minHourPanel = new JPanel(new GridLayout(1, 2));
				JPanel minOccurencePanel = new JPanel(new GridLayout(1, 2));
				JPanel midOccurencePanel = new JPanel(new GridLayout(1, 2));
				JPanel maxOccurencePanel = new JPanel(new GridLayout(1, 2));
				JPanel maxExceptionPanel = new JPanel(new GridLayout(1, 2));
				JPanel ignoreDaysPanel = new JPanel(new GridLayout(1, 2));

				JTextField nameField = new JTextField(10);
				JTextField sectionField = new JTextField(10);
				JTextField sectionField1 = new JTextField(10);
				JTextField sectionField2 = new JTextField(10);
				JTextField sectionField3 = new JTextField(10);
				JTextField sectionField4 = new JTextField(10);
				JTextField sectionField5 = new JTextField(10);

				maxHourPanel.add(new JLabel(SchedulerComponent.this.messages
						.getString("maxHour")));
				maxHourPanel.add(nameField);

				minHourPanel.add(new JLabel(SchedulerComponent.this.messages
						.getString("minHour")));
				minHourPanel.add(sectionField);

				minOccurencePanel.add(new JLabel(
						SchedulerComponent.this.messages
								.getString("minOccurence")));
				minOccurencePanel.add(sectionField1);

				midOccurencePanel.add(new JLabel(
						SchedulerComponent.this.messages
								.getString("midOccurence")));
				midOccurencePanel.add(sectionField2);

				maxOccurencePanel.add(new JLabel(
						SchedulerComponent.this.messages
								.getString("maxOccurence")));
				maxOccurencePanel.add(sectionField3);

				maxExceptionPanel.add(new JLabel(
						SchedulerComponent.this.messages
								.getString("maxException")));
				maxExceptionPanel.add(sectionField4);

				ignoreDaysPanel.add(new JLabel(SchedulerComponent.this.messages
						.getString("ignoreDays")));
				ignoreDaysPanel.add(sectionField5);

				topPanel.add(maxHourPanel);
				topPanel.add(minHourPanel);
				topPanel.add(minOccurencePanel);
				topPanel.add(midOccurencePanel);
				topPanel.add(maxOccurencePanel);
				topPanel.add(maxExceptionPanel);
				topPanel.add(ignoreDaysPanel);

				int result = JOptionPane.showConfirmDialog(null, topPanel,
						SchedulerComponent.this.messages
								.getString("filterGaps"),
						JOptionPane.OK_CANCEL_OPTION);

				if (result == JOptionPane.OK_OPTION) {
					try {
						SchedulerComponent.this.maxHoursPerGap = Integer
								.parseInt(nameField.getText());
						SchedulerComponent.this.minHoursPerGap = Integer
								.parseInt(sectionField.getText());
						SchedulerComponent.this.minOccurences = Integer
								.parseInt(sectionField1.getText());
						SchedulerComponent.this.midOccurences = Integer
								.parseInt(sectionField2.getText());
						SchedulerComponent.this.maxOccurences = Integer
								.parseInt(sectionField3.getText());
						SchedulerComponent.this.maxExceptions = Integer
								.parseInt(sectionField4.getText());
						SchedulerComponent.this.gapIgnoreDays = SchedulerMenu
								.getNumbers(sectionField5.getText());
						SchedulerComponent.this.gapCheckBox.setEnabled(true);
					} catch (Exception exp) {
						JOptionPane.showMessageDialog(null, "Invalid Input");
					}

				}
			}

		});

		this.hourButton = new JButton(this.messages.getString("filterHours"));
		this.hourButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {

				JTextField ignoreField = new JTextField(5);
				JTextField startField = new JTextField(5);
				JTextField endField = new JTextField(5);

				JPanel myPanel = new JPanel();
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel(SchedulerComponent.this.messages
						.getString("minStartHour")));
				myPanel.add(startField);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel(SchedulerComponent.this.messages
						.getString("maxEndHour")));
				myPanel.add(endField);
				myPanel.add(Box.createHorizontalStrut(15));
				myPanel.add(new JLabel(SchedulerComponent.this.messages
						.getString("ignoreDays")));
				myPanel.add(ignoreField);

				int result = JOptionPane.showConfirmDialog(null, myPanel,
						SchedulerComponent.this.messages
								.getString("filterHours"),
						JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					try {
						String start = startField.getText();
						String end = endField.getText();
						String credit = ignoreField.getText();

						SchedulerComponent.this.minStartHour = Integer
								.parseInt(start);
						SchedulerComponent.this.maxEndHour = Integer
								.parseInt(end);
						SchedulerComponent.this.hourIgnoreDays = SchedulerMenu
								.getNumbers(credit);
						SchedulerComponent.this.hourCheckBox.setEnabled(true);
					} catch (Exception exp) {
						JOptionPane.showMessageDialog(null, "Invalid Input");
					}

				}
			}

		});

		this.gapCheckBox = new JCheckBox();
		this.gapCheckBox.setEnabled(false);

		this.hourCheckBox = new JCheckBox();
		this.hourCheckBox.setEnabled(false);

		this.gapPanel.add(this.gapButton, BorderLayout.WEST);
		this.gapPanel.add(this.gapCheckBox, BorderLayout.EAST);

		this.hourPanel.add(this.hourButton, BorderLayout.WEST);
		this.hourPanel.add(this.hourCheckBox, BorderLayout.EAST);

		this.topPanel = new JPanel(new BorderLayout());
		this.coursePanel = new JPanel(new BorderLayout());
		this.classPanel = new JPanel(new BorderLayout());
		this.buttonPanel = new JPanel(new BorderLayout());
		this.schedulePanel = new JPanel();
		this.schedulePanel.setLayout(new BoxLayout(this.schedulePanel,
				BoxLayout.PAGE_AXIS));

		JLabel courseLabel = new JLabel(this.messages.getString("courses"));
		JLabel classLabel = new JLabel(this.messages.getString("sections"));
		Font f1 = new Font("Times New Roman", Font.BOLD, 17);
		courseLabel.setFont(f1);
		classLabel.setFont(f1);

		this.coursePanel.add(courseLabel, BorderLayout.NORTH);
		this.coursePanel.add(this.courseList, BorderLayout.SOUTH);

		this.classPanel.add(classLabel, BorderLayout.NORTH);
		this.classPanel.add(this.sectionList, BorderLayout.CENTER);
		this.classPanel.add(this.sectionButton, BorderLayout.SOUTH);

		this.buttonPanel.add(this.scheduleButton, BorderLayout.NORTH);
		this.buttonPanel.add(this.gapPanel, BorderLayout.WEST);
		this.buttonPanel.add(this.hourPanel, BorderLayout.EAST);

		this.topPanel.add(this.coursePanel, BorderLayout.NORTH);
		this.topPanel.add(this.classPanel, BorderLayout.CENTER);
		this.topPanel.add(this.buttonPanel, BorderLayout.SOUTH);

		add(this.topPanel, BorderLayout.NORTH);

		JTable table = this.createTables(4);
		table.setEnabled(false);
		this.schedulePanel.add(table.getTableHeader());
		this.schedulePanel.add(table);
		this.scheduleScrollPane = new JScrollPane(this.schedulePanel);
		add(this.scheduleScrollPane, BorderLayout.CENTER);

		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	}

	/**
	 * This method returns the selected course's name
	 * 
	 * @return course name
	 */
	public String getSelectedCourse() {
		return (String) this.courseList.getSelectedItem();
	}

	/**
	 * This method creates an empty JTable with the days of the week included
	 * 
	 * @param numberOfColumns
	 * @return empty JTable
	 */
	public JTable createTables(int numberOfColumns) {
		Object[][] data = { { this.messages.getString("monday") },
				{ this.messages.getString("tuesday") },
				{ this.messages.getString("wednesday") },
				{ this.messages.getString("thursday") },
				{ this.messages.getString("friday") },
				{ this.messages.getString("saturday") },
				{ this.messages.getString("sunday") } };
		String[] columnNames = { "" };
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		JTable table = new JTable(model);
		for (int i = 1; i < numberOfColumns + 1; i++) {
			model.addColumn(i);
		}
		return table;
	}

	/**
	 * This method creates the JTables that contain the data from the created
	 * schedules
	 * 
	 * @param schedules
	 * @param hours
	 */
	public void createSchedules(
			ArrayList<ArrayList<SchedulerCourse>> schedules, int hours) {

		this.schedulePanel.removeAll();
		int count = 0;
		for (ArrayList<SchedulerCourse> schedule : schedules) {
			JTable table = this.createTables(hours);
			for (SchedulerCourse course : schedule) {
				for (ClassSection section : course.getSections()) {
					int dayNum = 0;
					for (ClassDay day : section.getClassDays()) {
						for (Integer hour : day.getHourSlots()) {
							table.setValueAt(
									course.getName() + "-"
											+ section.getSection() + ":"
											+ section.getTeacher(), dayNum,
									hour);
						}
						dayNum++;
					}
				}
			}
			this.schedulePanel.add(new JLabel("  "));
			JLabel countLabel = new JLabel("#" + count);
			Font f1 = new Font("Times New Roman", Font.BOLD, 15);
			countLabel.setFont(f1);
			this.schedulePanel.add(countLabel);
			table.setEnabled(false);
			this.schedulePanel.add(table.getTableHeader());
			this.schedulePanel.add(table);
			table = null;
			count++;
		}

		this.schedulePanel.repaint();
		this.schedulePanel.revalidate();
		this.scheduleScrollPane.repaint();
		this.scheduleScrollPane.revalidate();
	}

	/**
	 * This method adds a course to the JOptionBox
	 * 
	 * @param course
	 */
	public void addCourse(SchedulerCourse course) {
		this.courses.add(course);
		String[] newCourses = new String[this.courses.size()];

		for (int i = 0; i < this.courses.size(); i++) {
			newCourses[i] = this.courses.get(i).getName();
		}
		this.courseList.setModel(new DefaultComboBoxModel(newCourses));
	}

	/**
	 * This method adds a section to the JOptionBox
	 * 
	 * @param newClass
	 */
	public void addSection(ClassSection newClass) {
		for (SchedulerCourse current : this.courses) {
			if (current.getName().equals(this.courseList.getSelectedItem())) {
				current.addSections(newClass);
				String[] newClasses = new String[current.getSections().size()];
				for (int i = 0; i < current.getSections().size(); i++) {
					newClasses[i] = current.getSections().get(i).getTeacher();
				}

				this.sectionList.setModel(new DefaultComboBoxModel(newClasses));
				break;
			}
		}
	}

	/**
	 * This method changes the value within the JOptionBox of courses depending
	 * on the number of courses
	 * 
	 */
	public void updateSection() {
		for (SchedulerCourse current : this.courses) {
			if (current.getName().equals(this.courseList.getSelectedItem())) {

				String[] newClasses = new String[current.getSections().size()];

				for (int i = 0; i < current.getSections().size(); i++) {
					newClasses[i] = current.getSections().get(i).getTeacher();
				}

				this.sectionList.setModel(new DefaultComboBoxModel(newClasses));
				break;
			}
		}
	}

	/**
	 * This method changes the value within the JOptionBox of sections depending
	 * on the course selected
	 *
	 */
	public void updateCourse() {
		String[] newCourses = new String[this.courses.size()];

		for (int i = 0; i < this.courses.size(); i++) {
			newCourses[i] = this.courses.get(i).getName();
		}
		this.courseList.setModel(new DefaultComboBoxModel(newCourses));
	}

	/**
	 * This method removes the current course
	 *
	 */
	public void removeCourse() {
		for (int i = 0; i < this.courses.size(); i++) {
			if (this.courseList.getSelectedItem().equals(
					this.courses.get(i).getName())) {
				this.courses.remove(i);
				break;
			}
		}
		updateCourse();
		updateSection();
	}

	/**
	 * This method removes the current section
	 *
	 */
	public void removeSection() {
		for (int i = 0; i < this.courses.size(); i++) {
			if (this.courseList.getSelectedItem().equals(
					this.courses.get(i).getName())) {
				for (int j = 0; j < this.courses.get(i).getSections().size(); j++) {
					if (this.courses.get(i).getSections().get(j).getTeacher()
							.equals(this.sectionList.getSelectedItem())) {
						this.courses.get(i).getSections().remove(j);
						break;
					}
				}
				break;
			}
		}
		updateSection();
	}

	/**
	 * This methods returns the section that is currently selected
	 *
	 * @return current section
	 */
	@SuppressWarnings("unused")
	public ClassSection getCurrentSection() {
		ClassSection temp = null;
		for (int i = 0; i < this.courses.size(); i++) {
			if (this.courseList.getSelectedItem().equals(
					this.courses.get(i).getName())) {
				for (int j = 0; j < this.courses.get(i).getSections().size(); j++) {
					if (this.courses.get(i).getSections().get(j).getTeacher()
							.equals(this.sectionList.getSelectedItem())) {
						temp = this.courses.get(i).getSections().get(j);
						break;
					}
				}
			}
			break;
		}

		return temp;
	}

	/**
	 * This method returns the number of items in the JOptionBox of courses
	 *
	 * @return number of courses
	 */
	public int getCourseSize() {
		return this.courseList.getItemCount();
	}

	/**
	 * This method returns the number of items in the JOptionBox of sections
	 *
	 * @return number of sections for the selected course
	 */
	public int getSectionSize() {
		return this.sectionList.getItemCount();
	}

	/**
	 * This method removes square brackets from the given String
	 *
	 * @param word
	 * @return without brackets
	 */
	public String makeProperString(String word) {
		word = word.replace('[', '\0');
		word = word.replace(']', '\0');
		return word;
	}

}
