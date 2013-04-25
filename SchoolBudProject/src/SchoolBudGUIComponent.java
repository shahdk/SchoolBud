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
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * TODO Put here a description of what this class does.
 * 
 * @author padillbt-1. Created Apr 18, 2013.
 */
public class SchoolBudGUIComponent extends JPanel implements ActionListener {

	private JLabel picture;
	private JComboBox quarterList, classList;

	public SchoolBudGUIComponent() {
		super(new BorderLayout());

		String[] quarterStrings = { "----", "Summer", "Fall",
				"Winter", "Spring" };

		this.quarterList = new JComboBox(quarterStrings);
		this.quarterList.setSelectedIndex(0);
		this.quarterList.addActionListener(this);

		this.classList = new JComboBox();
		this.classList.setPrototypeDisplayValue("XXXXXXXXXX");

		String[] columnNames = { "Item Name", "Course Name", "S",
				"# of Years", "Vegetarian" };

		Object[][] data = {
				{ "Kathy", "Smith", "Snowboarding", new Integer(5),
						new Boolean(false) },
				{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
				{ "Sue", "Black", "Knitting", new Integer(2),
						new Boolean(false) },
				{ "Jane", "White", "Speed reading", new Integer(20),
						new Boolean(true) },
				{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) } };

		final JTable table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(500, 300));
		table.setFillsViewportHeight(true);
		JScrollPane tableSP = new JScrollPane(table);
        tableSP.setPreferredSize(new Dimension(500, 400));

		add(this.quarterList, BorderLayout.PAGE_START);
		add(this.classList, BorderLayout.CENTER);
		add(tableSP, BorderLayout.PAGE_END);
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

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
		String summer[] = { "CSSE230", "MA112" };
		String empty[] = { "N/A" };

		String picName = "";
		if (name.equals("Spring")) {
			// picName = "elephant.gif";
			this.classList.setModel(new DefaultComboBoxModel(spring));
		} else if (name.equals("Fall")) {
			// picName = "tiger.gif";
			this.classList.setModel(new DefaultComboBoxModel(fall));
		} else if (name.equals("Winter")) {
			// picName = "whale.gif";
			this.classList.setModel(new DefaultComboBoxModel(winter));
		} else if (name.equals("Summer")) {
			// picName = "whaleRider.gif";
			this.classList.setModel(new DefaultComboBoxModel(summer));
		} else {
			// picName = "rose.gif";
			this.classList.setModel(new DefaultComboBoxModel(empty));
		}

//		ImageIcon icon = new ImageIcon(picName);
//		this.picture.setIcon(icon);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		JComboBox box = (JComboBox) arg0.getSource();
		String quarterName = (String) box.getSelectedItem();
		updateLabel(quarterName);
	}

}
