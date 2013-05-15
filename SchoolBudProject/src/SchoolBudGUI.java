import javax.swing.JFrame;
import javax.swing.JMenuBar;

/**
 * This class is the JFrame that contains all the SchoolBudGUI components
 *
 * @author padillbt-1.
 *         Created Apr 17, 2013.
 */
public class SchoolBudGUI extends JFrame{
	
	/**
	 * This constructor initializes all the values to be added to the JFrame
	 *
	 */
	public SchoolBudGUI(){
		initialize();
	}

	/**
	 * This method adds all the components onto the JFrame
	 *
	 */
	private final void initialize() {
        
		SchoolBudGUIComponent newContentPane = new SchoolBudGUIComponent();
        newContentPane.setOpaque(true);
        setContentPane(newContentPane);
      
        JMenuBar menubar = new SchoolBudGUIMenu(this, newContentPane);  
        setJMenuBar(menubar);
        
        setTitle("SchoolBud by ReverseOreo\u00a9");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
