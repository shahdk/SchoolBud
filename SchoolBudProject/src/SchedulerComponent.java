import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * TODO Put here a description of what this class does.
 * 
 * @author padillbt-1. Created May 8, 2013.
 */
public class SchedulerComponent extends JPanel {
	private JComboBox courseList;
	private JComboBox classList;
	private JButton scheduleButton;
	private JButton sectionButton;
	private JPanel topPanel;
	private JPanel coursePanel;
	private JPanel classPanel;
	private JPanel buttonPanel;
	private JPanel schedulePanel;
	private JScrollPane scheduleScrollPane;
	private ArrayList<SchedulerCourse> courses;
	private Locale locale;
	private ResourceBundle messages;

	public SchedulerComponent(Locale locale) {
		super(new BorderLayout());
		this.courses = new ArrayList<SchedulerCourse>();
		this.locale = locale;
		this.messages = ResourceBundle.getBundle("MessagesBundle", this.locale);

		String[] quarterStrings = { "----" };

		this.courseList = new JComboBox(quarterStrings);
		this.courseList.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent event) {
				JComboBox box = (JComboBox) event.getSource();
				String quarterName = (String) box.getSelectedItem();
				updateSection();
			}

		});

		this.classList = new JComboBox();
		this.classList.setPrototypeDisplayValue("XXXXXXXXXX");
		this.classList.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent event) {
				JComboBox box = (JComboBox) event.getSource();
				String courseName = (String) box.getSelectedItem();
			}
		});

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
					createSchedules(scheduler.permutateSchedules(), classHours);

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

					JTextField sectionField = new JTextField(10);
					sectionField.setText(currentSection.getClassDays().get(0).getHourSlots().toString());

					JTextField sectionField1 = new JTextField(10);
					sectionField1.setText(currentSection.getClassDays().get(1).getHourSlots().toString());


					JTextField sectionField2 = new JTextField(10);
					sectionField2.setText(currentSection.getClassDays().get(2).getHourSlots().toString());


					JTextField sectionField3 = new JTextField(10);
					sectionField3.setText(currentSection.getClassDays().get(3).getHourSlots().toString());


					JTextField sectionField4 = new JTextField(10);
					sectionField4.setText(currentSection.getClassDays().get(4).getHourSlots().toString());

					JTextField sectionField5 = new JTextField(10);
					sectionField5.setText(currentSection.getClassDays().get(5).getHourSlots().toString());

					JTextField sectionField6 = new JTextField(10);
					sectionField6.setText(currentSection.getClassDays().get(6).getHourSlots().toString());

					JTextField sectionField7 = new JTextField(10);
					sectionField7.setText(currentSection.getSection());

					teacherPanel.add(new JLabel(messages
							.getString("teacherName")));
					teacherPanel.add(nameField);

					mondayPanel.add(new JLabel(messages
							.getString("mondayHours")));
					mondayPanel.add(sectionField);

					tuesdayPanel.add(new JLabel(messages
							.getString("tuesdayHours")));
					tuesdayPanel.add(sectionField1);

					wednesdayPanel.add(new JLabel(messages
							.getString("wednesdayHours")));
					wednesdayPanel.add(sectionField2);

					thursdayPanel.add(new JLabel(messages
							.getString("thursdayHours")));
					thursdayPanel.add(sectionField3);

					fridayPanel.add(new JLabel(messages
							.getString("fridayHours")));
					fridayPanel.add(sectionField4);

					saturdayPanel.add(new JLabel(messages
							.getString("saturdayHours")));
					saturdayPanel.add(sectionField5);

					sundayPanel.add(new JLabel(messages
							.getString("sundayHours")));
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
					
					int result = JOptionPane.showConfirmDialog(null, topPanel,
							messages.getString("course"),
							JOptionPane.OK_CANCEL_OPTION);
				}

			}

		});

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
		this.classPanel.add(this.classList, BorderLayout.SOUTH);

		this.buttonPanel.add(this.sectionButton, BorderLayout.NORTH);
		this.buttonPanel.add(this.scheduleButton, BorderLayout.SOUTH);

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

	public String getSelectedCourse() {
		return (String) this.courseList.getSelectedItem();
	}

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

	public void addCourse(SchedulerCourse course) {
		this.courses.add(course);
		String[] newCourses = new String[this.courses.size()];

		for (int i = 0; i < this.courses.size(); i++) {
			newCourses[i] = this.courses.get(i).getName();
		}
		this.courseList.setModel(new DefaultComboBoxModel(newCourses));
	}

	public void addSection(ClassSection newClass) {
		for (SchedulerCourse current : this.courses) {
			if (current.getName().equals(this.courseList.getSelectedItem())) {
				current.addSections(newClass);
				String[] newClasses = new String[current.getSections().size()];
				for (int i = 0; i < current.getSections().size(); i++) {
					newClasses[i] = current.getSections().get(i).getTeacher();
				}

				this.classList.setModel(new DefaultComboBoxModel(newClasses));
				break;
			}
		}
	}

	public void updateSection() {
		for (SchedulerCourse current : this.courses) {
			if (current.getName().equals(this.courseList.getSelectedItem())) {

				String[] newClasses = new String[current.getSections().size()];

				for (int i = 0; i < current.getSections().size(); i++) {
					newClasses[i] = current.getSections().get(i).getTeacher();
				}

				this.classList.setModel(new DefaultComboBoxModel(newClasses));
				break;
			}
		}
	}

	public void updateCourse() {
		String[] newCourses = new String[this.courses.size()];

		for (int i = 0; i < this.courses.size(); i++) {
			newCourses[i] = this.courses.get(i).getName();
		}
		this.courseList.setModel(new DefaultComboBoxModel(newCourses));
	}

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

	public void removeSection() {
		for (int i = 0; i < this.courses.size(); i++) {
			if (this.courseList.getSelectedItem().equals(
					this.courses.get(i).getName())) {
				for (int j = 0; j < this.courses.get(i).getSections().size(); j++) {
					if (this.courses.get(i).getSections().get(j).getTeacher()
							.equals(this.classList.getSelectedItem())) {
						this.courses.get(i).getSections().remove(j);
						break;
					}
				}
				break;
			}
		}
		updateSection();
	}

	public ClassSection getCurrentSection() {
		ClassSection temp = null;
		for (int i = 0; i < this.courses.size(); i++) {
			if (this.courseList.getSelectedItem().equals(
					this.courses.get(i).getName())) {
				for (int j = 0; j < this.courses.get(i).getSections().size(); j++) {
					if (this.courses.get(i).getSections().get(j).getTeacher()
							.equals(this.classList.getSelectedItem())) {
						temp = this.courses.get(i).getSections().get(j);
						break;
					}
				}
			}
			break;
		}

		return temp;
	}

	public int getCourseSize() {
		return this.courseList.getItemCount();
	}

	public int getSectionSize() {
		return this.classList.getItemCount();
	}

	public JComboBox getCourseList() {
		return this.courseList;
	}

}
