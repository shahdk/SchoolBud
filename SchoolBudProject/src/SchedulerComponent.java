import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;


/**
 * TODO Put here a description of what this class does.
 *
 * @author padillbt-1.
 *         Created May 8, 2013.
 */
public class SchedulerComponent extends JPanel{
	private JComboBox courseList;
	private JComboBox classList;
	private JButton scheduleButton;
	private JPanel topPanel;
	private ArrayList<SchedulerCourse> courses;

	public SchedulerComponent(){
		super(new BorderLayout());
		this.courses = new ArrayList<SchedulerCourse>();

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
		
		this.scheduleButton = new JButton("Schedule");
		this.scheduleButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent event) {
				Scheduler scheduler = new Scheduler(8, courses);
				System.out.println(scheduler.permutateSchedules().size());
			}
		});
		
		this.topPanel = new JPanel(new BorderLayout());
		
		this.topPanel.add(this.courseList, BorderLayout.NORTH);
		this.topPanel.add(this.classList, BorderLayout.CENTER);
		this.topPanel.add(this.scheduleButton, BorderLayout.SOUTH);
		
		add(this.topPanel, BorderLayout.NORTH);
	}
	
	public void addCourse(SchedulerCourse course){
		this.courses.add(course);
		String[] newCourses = new String[this.courses.size()];

		for (int i = 0; i < this.courses.size(); i++) {
			newCourses[i] = this.courses.get(i).getName();
		}
		this.courseList.setModel(new DefaultComboBoxModel(newCourses));
	}
	
	public void addSection(ClassSection newClass){
		for (SchedulerCourse current : this.courses) {
			if (current.getName().equals(this.courseList.getSelectedItem())) {
				current.addSections(newClass);
				String[] newClasses = new String[current.getSections().size()];
				for (int i = 0; i < current.getSections().size(); i++) {
					newClasses[i] = current.getSections().get(i).getTeacher();
				}

				this.classList.setModel(new DefaultComboBoxModel(
						newClasses));
				break;
			}
		}
	}
	
	public void updateSection(){
		for (SchedulerCourse current : this.courses) {
			if (current.getName().equals(this.courseList.getSelectedItem())) {
				
				String[] newClasses = new String[current.getSections().size()];
				
				for (int i = 0; i < current.getSections().size(); i++) {
					newClasses[i] = current.getSections().get(i).getTeacher();
				}

				this.classList.setModel(new DefaultComboBoxModel(
						newClasses));
				break;
			}
		}
	}
	
	public void updateCourse(){
		String[] newCourses = new String[this.courses.size()];

		for (int i = 0; i < this.courses.size(); i++) {
			newCourses[i] = this.courses.get(i).getName();
		}
		this.courseList.setModel(new DefaultComboBoxModel(newCourses));
	}

}
