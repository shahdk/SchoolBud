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
	
	public SchoolBudGUI(){
		initialize();
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	private final void initialize() {
        
        JComponent newContentPane = new SchoolBudGUIComponent();
        newContentPane.setOpaque(true);
        setContentPane(newContentPane);
        
        JMenuBar menubar = new SchoolBudGUIMenu(this);  
        setJMenuBar(menubar);
        
        setTitle("SchoolBud");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
