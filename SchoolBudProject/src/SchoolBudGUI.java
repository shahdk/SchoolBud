import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

/**
 * TODO Put here a description of what this class does.
 *
 * @author padillbt-1.
 *         Created Apr 17, 2013.
 */
public class SchoolBudGUI extends JFrame{
	
	/**
	 * TODO Put here a description of what this constructor does.
	 *
	 */
	public SchoolBudGUI(){
		initialize();
	}

	/**
	 * TODO Put here a description of what this method does.
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
