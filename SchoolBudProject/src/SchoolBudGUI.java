import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JFrame;
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
 *         Created Apr 17, 2013.
 */
public class SchoolBudGUI extends JFrame{
	
	public SchoolBudGUI(){
		initialize();
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	private final void initialize() {
		JMenuBar menubar = new JMenuBar();
        JMenu add = new JMenu("Add");
        JMenu language = new JMenu("Language");
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        
        JComponent newContentPane = new SchoolBudGUIComponent();
        newContentPane.setOpaque(true);
        setContentPane(newContentPane);
        
        JMenuItem course = new JMenuItem("Course");
        course.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent event) {
            	JTextField nameField = new JTextField(10);
                JPanel myPanel = new JPanel();
                myPanel.add(new JLabel("Name:"));
                myPanel.add(nameField);
            	
                int result = JOptionPane.showConfirmDialog(null, myPanel, 
                        "New Course", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
            	String name = nameField.getText();
            	Course newCourse = new Course(name);
                }
            }

        });
        
        JMenuItem quarter = new JMenuItem("Quarter");
        
        JMenuItem category = new JMenuItem("Category");
        category.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent event) {
            	JTextField nameField = new JTextField(10);
                JTextField weightField = new JTextField(5);

                JPanel myPanel = new JPanel();
                myPanel.add(new JLabel("Name:"));
                myPanel.add(nameField);
                myPanel.add(Box.createHorizontalStrut(15));
                myPanel.add(new JLabel("Weight:"));
                myPanel.add(weightField);

                int result = JOptionPane.showConfirmDialog(null, myPanel, 
                         "New Category", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                	Category newCategory = new Category(nameField.getText(), Integer.parseInt(weightField.getText()));
                }
            }

        });
        
        JMenuItem item = new JMenuItem("Item");
        item.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent event) {
            	JTextField nameField = new JTextField(10);
                JTextField weightField = new JTextField(5);

                JPanel myPanel = new JPanel();
                myPanel.add(new JLabel("Name:"));
                myPanel.add(nameField);
                myPanel.add(Box.createHorizontalStrut(15));
                myPanel.add(new JLabel("Weight:"));
                myPanel.add(weightField);

                int result = JOptionPane.showConfirmDialog(null, myPanel, 
                         "New Item", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                	Item newItem = new Item(nameField.getText(), Integer.parseInt(weightField.getText()));
                }
            }

        });
        
        JMenuItem rubric = new JMenuItem("Rubric");
        
        add.add(course);
        add.add(quarter);
        add.add(category);
        add.add(item);
        add.add(rubric);
        
        JMenuItem editCourse = new JMenuItem("Course");
        JMenuItem editQuarter = new JMenuItem("Quarter");
        JMenuItem editCategory = new JMenuItem("Category");
        JMenuItem editItem = new JMenuItem("Item");
        JMenuItem editRubric = new JMenuItem("Rubric");
        
        edit.add(editCourse);
        edit.add(editQuarter);
        edit.add(editCategory);
        edit.add(editItem);
        edit.add(editRubric);
        
        JMenuItem english = new JMenuItem("English");
        JMenuItem spanish = new JMenuItem("Spanish");
        
        language.add(english);
        language.add(spanish);
        
        JMenuItem save = new JMenuItem("Save");
        JMenuItem load = new JMenuItem("Load");
        JMenuItem exit = new JMenuItem("Exit");
        
        file.add(save);
        file.add(load);
        file.add(exit);
        
        exit.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent event) {
            	setVisible(false);
            	dispose();
            }

        });
        
        menubar.add(file);
        menubar.add(add);
        menubar.add(edit);
        menubar.add(language);
        
        setJMenuBar(menubar);
        
        setTitle("SchoolBud by Reverse Oreo");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		SchoolBudGUI gui = new SchoolBudGUI();
		gui.setVisible(true);

	}

}
