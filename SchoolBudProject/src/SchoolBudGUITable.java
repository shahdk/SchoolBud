import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 * TODO Put here a description of what this class does.
 * 
 * @author padillbt-1. Created May 1, 2013.
 */
public class SchoolBudGUITable{
	private JTable table;
	private JScrollPane tableSP;

	public SchoolBudGUITable(String[] names) {
		String[] columnNames = names;

		Object[][] data = {};

		this.table = new JTable(data, columnNames);

		table.setPreferredScrollableViewportSize(new Dimension(500, 300));
		table.setFillsViewportHeight(true);
		this.tableSP = new JScrollPane(table);
		tableSP.setPreferredSize(new Dimension(500, 400));
	}
	
	public JScrollPane getJScrollPane(){
		return this.tableSP;
	}
	
	public void changeHeaderValues(String[] headings){
		for(int i = 0; i <this.table.getColumnCount(); i++){
			this.table.getTableHeader().getColumnModel().getColumn(i).setHeaderValue(headings[i]);
			this.table.repaint();
		}
//		((AbstractTableModel) table.getModel()).fireTableStructureChanged() ;
	}

}
