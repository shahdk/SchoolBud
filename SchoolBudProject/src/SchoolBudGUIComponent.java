import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * TODO Put here a description of what this class does.
 *
 * @author padillbt-1.
 *         Created Apr 18, 2013.
 */
public class SchoolBudGUIComponent extends JPanel implements ActionListener{
	
	JLabel picture;
	JComboBox quarterList, classList;

	
	public SchoolBudGUIComponent(){
		super(new BorderLayout());
		
		String[] quarterStrings = { "Select Quarter", "Summer", "Fall", "Winter", "Spring"};
		
		quarterList = new JComboBox(quarterStrings);
        quarterList.setSelectedIndex(0);
        quarterList.addActionListener(this);
        
        classList = new JComboBox();
        classList.setPrototypeDisplayValue("XXXXXXXXXX");
        
        this.picture = new JLabel();
        this.picture.setFont(this.picture.getFont().deriveFont(Font.ITALIC));
        this.picture.setHorizontalAlignment(JLabel.CENTER);
        updateLabel(quarterStrings[quarterList.getSelectedIndex()]);
        this.picture.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        
        this.picture.setPreferredSize(new Dimension(300, 310));
        
        add(quarterList, BorderLayout.PAGE_START);
        add(classList, BorderLayout.CENTER);
        add(this.picture, BorderLayout.PAGE_END);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
	}
	
	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param string
	 */
	private void updateLabel(String name) {
		String fall[] = { "CSSE120", "MA112" };  
        String winter[] = { "CSSE333", "MA275", "MA375", "IA351" };  
        String spring[] = { "CSSE376", "CSSE304", "CSSE132", "PH111", "SV151" };  
        String summer[] = { "CSSE230", "MA112"};
        String empty[] = {"N/A"};
		
		String picName = "";
		if(name.equals("Spring")){
			picName = "elephant.gif";
			classList.setModel(new DefaultComboBoxModel(spring));
		}
		else if(name.equals("Fall")){
			picName = "tiger.gif";
			classList.setModel(new DefaultComboBoxModel(fall));
		}
		else if(name.equals("Winter")){
			picName = "whale.gif";
			classList.setModel(new DefaultComboBoxModel(winter));
		}
		else if(name.equals("Summer")){
			picName = "whaleRider.gif";
			classList.setModel(new DefaultComboBoxModel(summer));
		}
		else{
			picName = "rose.gif";
			classList.setModel(new DefaultComboBoxModel(empty));
		}
		
		ImageIcon icon = new ImageIcon(picName);
        this.picture.setIcon(icon);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		JComboBox box = (JComboBox) arg0.getSource();
        String quarterName = (String) box.getSelectedItem();
        updateLabel(quarterName);
	}

}
