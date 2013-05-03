import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;

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
	private ArrayList<Quarter> quarters;
	private String selectedQuarter;
	private String selectedCourse;

	public SchoolBudGUITable(String[] names) {
		this.columnNames = names;

		Object[][] data = {};

		this.tableModel = new DefaultTableModel(data, this.columnNames);

		this.table = new JTable(this.tableModel) {
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

		this.table.setPreferredScrollableViewportSize(new Dimension(500, 300));
		this.table.setFillsViewportHeight(true);
		this.tableSP = new JScrollPane(table);
		this.tableSP.setPreferredSize(new Dimension(500, 400));

		this.table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				JTable target = (JTable) e.getSource();
				int row = target.getSelectedRow();
				int column = target.getSelectedColumn();
				if (column == 5) {
					removeItem(row, column);
				}
			}

		});
		
		TableCellListener tcl = new TableCellListener();
		this.table.addPropertyChangeListener(tcl);
	}

	private class TableCellListener implements PropertyChangeListener{

		@Override
		public void propertyChange(PropertyChangeEvent e) {
			
			if ("tableCellEditor".equals(e.getPropertyName()))
			{
				if (!table.isEditing()){
					int row = table.getSelectedRow();
					int col = table.getSelectedColumn();
					for (Quarter current : quarters) {
						if (current.getName().equals(selectedQuarter)) {
							ArrayList<Course> currentCourses = current.getCourseList();
							for (Course c : currentCourses) {
								if (c.getCourseName().equals(selectedCourse)) {
									String catName = (String) table.getValueAt(row, 4);
									String itemName = (String) table
											.getValueAt(row, 0);

									for (int i = 0; i < c.getCategories().size(); i++) {
										if (c.getCategories().get(i).getName()
												.equals(catName)) {
											for (int j = 0; j < c.getCategories().get(i)
													.getItemList().size(); j++) {
												if (c.getCategories().get(i).getItemList()
														.get(j).getName().equals(itemName)) {
													if(col == 0){
														c.getCategories().get(i).getItemList().get(j).setName((String)table.getValueAt(row, col));
													}else if(col == 1){
														c.getCategories().get(i).getItemList().get(j).setEarnedPoints((String)table.getValueAt(row, col));
													}else if(col == 2){
														c.getCategories().get(i).getItemList().get(j).setTotalPoints((String)table.getValueAt(row, col));
													}else if(col == 3){
														try{
															SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
															c.getCategories().get(i).getItemList().get(j).setUpdateDate(sdf.parse((String)table.getValueAt(row, col)));
															c.getCategories().get(i).checkItemUpdateDate();
															table.setValueAt(sdf.format(c.getCategories().get(i).getItemList().get(j).getUpdateDate()), row, col);
															table.repaint();
														}catch(Exception exp){
															
														}
													}else if(col == 4){
														c.getCategories().get(i).setName((String)table.getValueAt(row, col));
													}
													return;
												}
											}
										}
									}
								}
							}

						}
					}
				}
			}
		}
		
	}
	public void setQuarters(ArrayList<Quarter> quarters, String qt,
			String course) {
		this.quarters = quarters;
		this.selectedCourse = course;
		this.selectedQuarter = qt;
	}

	public JScrollPane getJScrollPane() {
		return this.tableSP;
	}

	public void removeItem(int row, int column) {
		for (Quarter current : quarters) {
			if (current.getName().equals(selectedQuarter)) {
				ArrayList<Course> currentCourses = current.getCourseList();

				for (Course c : currentCourses) {
					if (c.getCourseName().equals(selectedCourse)) {
						String catName = (String) this.table.getValueAt(row, 4);
						String itemName = (String) this.table
								.getValueAt(row, 0);

						for (int i = 0; i < c.getCategories().size(); i++) {
							if (c.getCategories().get(i).getName()
									.equals(catName)) {
								for (int j = 0; j < c.getCategories().get(i)
										.getItemList().size(); j++) {
									if (c.getCategories().get(i).getItemList()
											.get(j).getName().equals(itemName)) {
										c.getCategories().get(i)
												.removeItem(itemName);
										this.tableModel.removeRow(row);
										this.table.setModel(tableModel);
										this.table.repaint();
										return;
									}
								}
							}
						}
					}
				}

			}
		}
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

	public JTable getTable() {
		return this.table;
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
