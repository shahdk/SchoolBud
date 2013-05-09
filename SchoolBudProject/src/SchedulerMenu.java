import java.awt.BorderLayout;
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
				}
			}

		});
		
		this.section = new JMenuItem("Section");
		this.section.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				ArrayList<ClassDay> week = ClassSection.create7DayArrayList();
				JPanel topPanel = new JPanel(new BorderLayout());
				JPanel myPanel = new JPanel();
				JPanel myClassDays = new JPanel();
				
				JTextField nameField = new JTextField(10);
				JTextField sectionField = new JTextField(10);
				JTextField sectionField1 = new JTextField(10);
				JTextField sectionField2 = new JTextField(10);
				JTextField sectionField3 = new JTextField(10);
				JTextField sectionField4 = new JTextField(10);
				JTextField sectionField5 = new JTextField(10);
				JTextField sectionField6 = new JTextField(10);
				JTextField sectionField7 = new JTextField(10);
				
				myPanel.add(new JLabel("Teacher Name"));
				myPanel.add(nameField);
				myPanel.add(Box.createHorizontalStrut(10));
	
				myPanel.add(new JLabel("Day1 Hours"));
				myPanel.add(sectionField);
				myPanel.add(Box.createHorizontalStrut(10));
				
				myPanel.add(new JLabel("Day2 Hours"));
				myPanel.add(sectionField1);
				myPanel.add(Box.createHorizontalStrut(10));
				
				myPanel.add(new JLabel("Day3 Hours"));
				myPanel.add(sectionField2);
				myPanel.add(Box.createHorizontalStrut(10));
				
				myClassDays.add(new JLabel("Day4 Hours"));
				myClassDays.add(sectionField3);
				myClassDays.add(Box.createHorizontalStrut(10));
				
				myClassDays.add(new JLabel("Day5 Hours"));
				myClassDays.add(sectionField4);
				myClassDays.add(Box.createHorizontalStrut(10));
				
				myClassDays.add(new JLabel("Day6 Hours"));
				myClassDays.add(sectionField5);
				myClassDays.add(Box.createHorizontalStrut(10));
				
				myClassDays.add(new JLabel("Day7 Hours"));
				myClassDays.add(sectionField6);
				myClassDays.add(Box.createHorizontalStrut(10));
				
				topPanel.add(myPanel, BorderLayout.PAGE_START);
				topPanel.add(myClassDays, BorderLayout.PAGE_END);
				
				int result = JOptionPane
						.showConfirmDialog(null, topPanel, "Section",
								JOptionPane.OK_CANCEL_OPTION);
				
				if (result == JOptionPane.OK_OPTION) {
					
					if(!sectionField.getText().isEmpty()){
					ArrayList<Integer> hours = getNumbers(sectionField.getText());
					ClassDay days = new ClassDay(hours);
					week.set(0, days);
					}
					
					if(!sectionField1.getText().isEmpty()){
					ArrayList<Integer> hours1 = getNumbers(sectionField1.getText());
					ClassDay days1 = new ClassDay(hours1);
					week.set(1, days1);
					}
					
					if(!sectionField2.getText().isEmpty()){
					ArrayList<Integer> hours2 = getNumbers(sectionField2.getText());
					ClassDay days2 = new ClassDay(hours2);
					week.set(2, days2);
					}
					
					if(!sectionField3.getText().isEmpty()){
					ArrayList<Integer> hours3 = getNumbers(sectionField3.getText());
					ClassDay days3 = new ClassDay(hours3);
					week.set(3, days3);
					}
					
					if(!sectionField4.getText().isEmpty()){
					ArrayList<Integer> hours4 = getNumbers(sectionField4.getText());
					ClassDay days4 = new ClassDay(hours4);
					week.set(4, days4);
					}
					
					if(!sectionField5.getText().isEmpty()){
					ArrayList<Integer> hours5 = getNumbers(sectionField5.getText());
					ClassDay days5 = new ClassDay(hours5);
					week.set(5, days5);
					}
					
					if(!sectionField6.getText().isEmpty()){
					ArrayList<Integer> hours6 = getNumbers(sectionField6.getText());
					ClassDay days6 = new ClassDay(hours6);
					week.set(6, days6);
					}
					
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
