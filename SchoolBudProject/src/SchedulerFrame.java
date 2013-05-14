import java.awt.Dimension;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

/**
 * This class is the JFrame that contains all the components for the Scheduler
 *
 * @author padillbt-1.
 *         Created May 8, 2013.
 */
public class SchedulerFrame extends JFrame{
	private Locale locale;
	
	/**
	 * The constructor initializes values
	 *
	 * @param locale
	 */
	SchedulerFrame(Locale locale){
		this.locale = locale;
		initialize();
	}

	/**
	 * This method adds on all the Scheduler components onto the Frame
	 *
	 */
	private final void initialize() {
        
		SchedulerComponent newContentPane = new SchedulerComponent(this.locale, this);
        newContentPane.setOpaque(true);
        setContentPane(newContentPane);
      
        JMenuBar menubar = new SchedulerMenu(this.locale, newContentPane);  
        setJMenuBar(menubar);
        
        setTitle("Scheduler by ReverseOreo\u00a9");
        setPreferredSize(new Dimension(500,500));
        pack();
        setLocationRelativeTo(null);
	}

}
