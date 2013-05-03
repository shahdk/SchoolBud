import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 * TODO Put here a description of what this class does.
 * 
 * @author padillbt-1. Created May 1, 2013.
 */
public class SchoolBudGUITable {
	private JTable table;
	private JScrollPane tableSP;
	private DefaultTableModel tableModel;
	private String[] columnNames;

	public SchoolBudGUITable(String[] names) {
		this.columnNames = names;

		Object[][] data = {};

		this.tableModel = new DefaultTableModel(data, this.columnNames);

		this.table = new JTable(this.tableModel){
			private static final long serialVersionUID = 1L;
			@Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }
		};
		table.setPreferredScrollableViewportSize(new Dimension(500, 300));
		table.setFillsViewportHeight(true);
		this.tableSP = new JScrollPane(table);
		tableSP.setPreferredSize(new Dimension(500, 400));
	}

	public JScrollPane getJScrollPane() {
		return this.tableSP;
	}

	public void changeHeaderValues(String[] headings) {
		for (int i = 0; i < this.table.getColumnCount(); i++) {
			this.table.getTableHeader().getColumnModel().getColumn(i)
					.setHeaderValue(headings[i]);
			this.table.repaint();
		}
	}

	public void addItems(Object[][] names, int numItems) {
		for (int i = 0; i < numItems; i++) {
			this.tableModel.addRow(names[i]);
		}
		
		this.table.setModel(this.tableModel);
	}

	public void reset() {
		Object[][] data = {};
		this.tableModel = new DefaultTableModel(data, this.columnNames);
		this.table.setModel(this.tableModel);
	}

	class ButtonRenderer extends JButton implements TableCellRenderer {

		public ButtonRenderer() {
			setOpaque(true);
		}

		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			if (isSelected) {
				setForeground(table.getSelectionForeground());
				setBackground(table.getSelectionBackground());
			} else {
				setForeground(table.getForeground());
				setBackground(UIManager.getColor("Button.background"));
			}
			setText("Remove");
			return this;
		}
	}

	/**
	 * @version 1.0 11/09/98
	 */

	class ButtonEditor extends DefaultCellEditor {
		protected JButton button;

		private String label;

		private boolean isPushed;

		public ButtonEditor(JCheckBox checkBox) {
			super(checkBox);
			button = new JButton();
			button.setOpaque(true);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fireEditingStopped();
				}
			});
		}

		public Component getTableCellEditorComponent(JTable table,
				Object value, boolean isSelected, int row, int column) {
			if (isSelected) {
				button.setForeground(table.getSelectionForeground());
				button.setBackground(table.getSelectionBackground());
			} else {
				button.setForeground(table.getForeground());
				button.setBackground(table.getBackground());
			}
			label = "Remove";
			button.setText(label);
			isPushed = true;
			return button;
		}

		public Object getCellEditorValue() {
			isPushed = false;
			return new String(label);
		}

		public boolean stopCellEditing() {
			isPushed = false;
			return super.stopCellEditing();
		}

		protected void fireEditingStopped() {
			super.fireEditingStopped();
		}
	}
}
