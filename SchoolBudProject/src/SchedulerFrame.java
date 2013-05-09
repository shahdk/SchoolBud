import java.awt.Dimension;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JMenuBar;


/**
 * TODO Put here a description of what this class does.
 *
 * @author padillbt-1.
 *         Created May 8, 2013.
 */
public class SchedulerFrame extends JFrame{
	private Locale locale;
	
	SchedulerFrame(Locale locale){
		this.locale = locale;
		initialize();
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 */
	private final void initialize() {
        
		SchedulerComponent newContentPane = new SchedulerComponent(this.locale);
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
