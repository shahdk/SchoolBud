import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * TODO Put here a description of what this class does.
 * 
 * @author padillbt-1. Created Apr 18, 2013.
 */
public class SchoolBudGUIComponent extends JPanel implements ActionListener {

	private JLabel picture;
	private JComboBox quarterList, classList;
	private ArrayList<Quarter> quarters;

	private SchoolBudGUITable table;

	public SchoolBudGUIComponent() {
		super(new BorderLayout());
		this.quarters = new ArrayList<Quarter>();

		String[] quarterStrings = { "----" };

		this.quarterList = new JComboBox(quarterStrings);
		this.quarterList.setSelectedIndex(0);
		this.quarterList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JComboBox box = (JComboBox) event.getSource();
				String quarterName = (String) box.getSelectedItem();
				updateLabel(quarterName);
			}

		});

		this.classList = new JComboBox();
		this.classList.setPrototypeDisplayValue("XXXXXXXXXX");

		String[] names = {"Item Name", "Earned Points", "Total Points", "Update Date", "Category", "Remove"};
		this.table = new SchoolBudGUITable(names);
		
		add(this.quarterList, BorderLayout.PAGE_START);
		add(this.classList, BorderLayout.CENTER);
		add(this.table.getJScrollPane(), BorderLayout.PAGE_END);
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

	}

	public void updateQuarters(ArrayList<Quarter> updatedQuarters) {
		this.quarters = updatedQuarters;
		String[] newQuarters = new String[this.quarters.size()];

		for (int i = 0; i < this.quarters.size(); i++) {
			newQuarters[i] = this.quarters.get(i).getName();
		}

		this.quarterList.setModel(new DefaultComboBoxModel(newQuarters));
	}

	/**
	 * TODO Put here a description of what this method does.
	 * 
	 * @param string
	 */
	public void updateLabel(String name) {
		for (Quarter current : this.quarters) {
			if (current.getName().equals(name)) {
				String[] newCourses = new String[current.getCourseList().size()];

				for (int i = 0; i < current.getCourseList().size(); i++) {
					newCourses[i] = current.getCourseList().get(i)
							.getCourseName();
				}

				this.classList.setModel(new DefaultComboBoxModel(newCourses));
				break;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		JComboBox box = (JComboBox) arg0.getSource();
		String quarterName = (String) box.getSelectedItem();
		updateLabel(quarterName);
	}

	public String getSelectedQuarter() {
		return (String) this.quarterList.getSelectedItem();
	}

	public String getSelectedCourse() {
		return (String) this.classList.getSelectedItem();
	}

	public void addNewQuarter(ArrayList<Quarter> newQuarters) {
		updateQuarters(newQuarters);
		updateLabel(getSelectedQuarter());
	}

	public void addNewCourse(Course newCourse) {
		for (Quarter current : this.quarters) {
			if (current.getName().equals(getSelectedQuarter())) {
				current.addCourse(newCourse);
				updateLabel(getSelectedQuarter());
				break;
			}
		}
	}

	public void addNewCategory(Category newCategory) {
		for (Quarter current : this.quarters) {
			if (current.getName().equals(getSelectedQuarter())) {
				ArrayList<Course> currentCourses = current.getCourseList();

				for (int i = 0; i < currentCourses.size(); i++) {
					if (currentCourses.get(i).equals(getSelectedCourse())) {
						currentCourses.get(i).addCategory(newCategory);
					}
				}

				break;
			}
		}
	}
	
	public void editQuarter(String name){
		for (Quarter current : this.quarters) {
			if (current.getName().equals(getSelectedQuarter())) {
				current.setName(name);
				addNewQuarter(this.quarters);
			}
			break;
		}
	}
	
	public void updateHeadings(ArrayList<String> headings){
		String[] newHeadings = new String[headings.size()];
		for(int i = 0; i<headings.size(); i++){
			newHeadings[i] = headings.get(i);
		}
		this.table.changeHeaderValues(newHeadings);
	}

}
