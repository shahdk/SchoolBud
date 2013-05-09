import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
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
 * @author padillbt-1.
 *         Created May 8, 2013.
 */
public class SchedulerMenu extends JMenuBar{
	private JMenu add;
	private Locale currentLocale;
	private ResourceBundle messages;
	private JMenuItem course;
	private JMenuItem section;
	private SchedulerComponent component;
	
	SchedulerMenu(Locale locale, SchedulerComponent component){
		this.currentLocale = locale;
		this.messages = ResourceBundle.getBundle("MessagesBundle",
				this.currentLocale);
		this.component = component;
		this.initialize();
	}

	public final void initialize(){
		this.add = new JMenu(this.messages.getString("add"));
		this.course = new JMenuItem(this.messages.getString("course"));
		this.course.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JPanel myPanel = new JPanel();
				JTextField nameField = new JTextField(15);
				JCheckBox optional = new JCheckBox("Optional", false);
				
				myPanel.add(new JLabel(SchedulerMenu.this.messages
						.getString("name")));
				myPanel.add(nameField);
				myPanel.add(Box.createHorizontalStrut(10));
				myPanel.add(optional);
				
				int result = JOptionPane
						.showConfirmDialog(null, myPanel, SchedulerMenu.this.messages
										.getString("course"),
								JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					SchedulerCourse course = new SchedulerCourse(nameField.getText(), new ArrayList<ClassSection>(), optional.isSelected());
					SchedulerMenu.this.component.addCourse(course);
					System.out.println(optional.isSelected());
				}
			}

		});
		
		this.section = new JMenuItem("Section");
		this.section.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				ArrayList<ClassDay> week = ClassSection.create7DayArrayList();
				JPanel myPanel = new JPanel();
				JTextField nameField = new JTextField(10);
				JTextField sectionField = new JTextField(10);
				
				myPanel.add(new JLabel("Teacher Name"));
				myPanel.add(nameField);
				myPanel.add(Box.createHorizontalStrut(10));
				
				myPanel.add(new JLabel("Hours"));
				myPanel.add(sectionField);
				
				int result = JOptionPane
						.showConfirmDialog(null, myPanel, "Section",
								JOptionPane.OK_CANCEL_OPTION);
				
				if (result == JOptionPane.OK_OPTION) {
					ArrayList<Integer> hours = getNumbers(sectionField.getText());
					ClassDay days = new ClassDay(hours);
					week.set(0, days);
					ClassSection section = new ClassSection(nameField.getText(), week);
					SchedulerMenu.this.component.addSection(section);
				}
			}

		});
		
		this.add.add(this.course);
		this.add.add(this.section);
		
		add(this.add);
	}
	
	public ArrayList<Integer> getNumbers(String nums){
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		String[] temp = nums.split(" ");
		int sum = 0;
		for(int i = 0; i < temp.length; i++){
			numbers.add(Integer.parseInt(temp[i]));
		}
		return numbers;
		
	}
}
