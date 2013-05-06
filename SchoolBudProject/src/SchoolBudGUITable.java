import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.*;

/**
 * Put here a description of what this class does.
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
	private String type;
	private boolean newAdd = false;
	private final int NUM_COLS = 6;

	public SchoolBudGUITable(String[] names, String type) {
		this.columnNames = names;
		this.type = type;

		if (type.equals("item")) {
			Object[][] data = { { "", "", "", "", "", false } };
			this.tableModel = new DefaultTableModel(data, this.columnNames);

			this.table = new JTable(this.tableModel) {
				private static final long serialVersionUID = 1L;

				@Override
				public Class<?> getColumnClass(int column) {
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
		} else {
			Object[][] data = { { "", "", "", "", false } };
			this.tableModel = new DefaultTableModel(data, this.columnNames);

			this.table = new JTable(this.tableModel) {
				private static final long serialVersionUID = 1L;

				@Override
				public Class<?> getColumnClass(int column) {
					switch (column) {
					case 0:
					case 1:
					case 2:
					case 3:
						return String.class;
					default:
						return Boolean.class;
					}
				}
			};
		}
		this.table.setPreferredScrollableViewportSize(new Dimension(500, 300));
		this.table.setFillsViewportHeight(true);
		this.tableSP = new JScrollPane(table);
		this.tableSP.setPreferredSize(new Dimension(500, 400));

		if (type.equals("item")) {
			this.table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {

					int row = table.getSelectedRow();
					int column = table.getSelectedColumn();
					if (column == 5) {
						removeItem(row, column);
					}
				}

			});
		} else {
			this.table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {

					int row = table.getSelectedRow();
					int column = table.getSelectedColumn();
					if (column == 4) {
						// removeRubric(row, column);
					}
				}

			});
		}

		TableCellListener tcl = new TableCellListener();
		this.table.addPropertyChangeListener(tcl);
	}

	private class TableCellListener implements PropertyChangeListener {

		@Override
		public void propertyChange(PropertyChangeEvent e) {

			if ("tableCellEditor".equals(e.getPropertyName())) {
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();

				if (type.equals("item")) {
					if (col < 5) {
						if (!table.isEditing()) {
							itemEditing(row, col);
						} else {
							if (row >= 0 && col >= 0) {
								checkEditing(row, col);
							}
						}
					}
				}
			}
		}

		public void itemEditing(int row, int col) {
			if (newAdd) {
				Object[] data = new Object[NUM_COLS];
				data[0] = table.getValueAt(row, 0);
				data[1] = table.getValueAt(row, 1);
				data[2] = table.getValueAt(row, 2);
				data[3] = table.getValueAt(row, 3);
				data[4] = table.getValueAt(row, 4);
				data[5] = false;
				if (!data[0].equals("") && !data[3].equals("")
						&& !data[4].equals("")) {
					addItem(data, row);
					addEmptyRow();
				}
			} else {
				if (!table.getValueAt(row, col).equals(""))
					editItems(row, col);
				newAdd = true;
			}
		}

		public void checkEditing(int row, int col) {
			if (table.getValueAt(row, 0).equals("")) {
				newAdd = true;
			} else {
				if (table.getValueAt(row, 3).equals("")) {
					newAdd = true;
				} else if (table.getValueAt(row, 4).equals("")) {
					newAdd = true;
				} else {
					newAdd = false;
				}
			}
		}
	}

	public void editItems(int row, int col) {
		for (Quarter current : quarters) {
			if (current.getName().equals(selectedQuarter)) {
				ArrayList<Course> currentCourses = current.getCourseList();
				for (Course c : currentCourses) {
					if (c.getCourseName().equals(selectedCourse)) {
						String catName = (String) table.getValueAt(row, 4);
						String itemName = (String) table.getValueAt(row, 0);

						if (col == 4) {
							int it = -1;;
							int curr = -1;
							int newCat = -1;
							for (int i = 0; i < c.getCategories().size(); i++) {
								if(c.getCategories().get(i).getName().equals(catName)){
									newCat = i;
								}
								for (int j = 0; j < c.getCategories().get(i)
										.getItemList().size(); j++) {
									if (c.getCategories().get(i).getItemList()
											.get(j).getName().equals(itemName)) {
										curr = i;
										it = j;
										
									}
								}
							}
							if(newCat == -1){
								table.setValueAt(c.getCategories().get(curr).getName(), row, col);
								return;
							}else{
								c.getCategories().get(newCat).addItem(c.getCategories().get(curr).getItemList().get(it));
								c.getCategories().get(curr).removeItem(itemName);
								return;
							}
						} else {
							for (int i = 0; i < c.getCategories().size(); i++) {
								if (c.getCategories().get(i).getName()
										.equals(catName)) {
									for (int j = 0; j < c.getCategories()
											.get(i).getItemList().size(); j++) {
										if (c.getCategories().get(i)
												.getItemList().get(j).getName()
												.equals(itemName)) {
											if (col == 0) {
												c.getCategories()
														.get(i)
														.getItemList()
														.get(j)
														.setName(
																(String) table
																		.getValueAt(
																				row,
																				col));
											} else if (col == 1) {
												c.getCategories()
														.get(i)
														.getItemList()
														.get(j)
														.setEarnedPoints(
																(String) table
																		.getValueAt(
																				row,
																				col));
											} else if (col == 2) {
												c.getCategories()
														.get(i)
														.getItemList()
														.get(j)
														.setTotalPoints(
																(String) table
																		.getValueAt(
																				row,
																				col));
											} else if (col == 3) {
												try {
													SimpleDateFormat sdf = new SimpleDateFormat(
															"MM/dd/yyyy");
													c.getCategories()
															.get(i)
															.getItemList()
															.get(j)
															.setUpdateDate(
																	sdf.parse((String) table
																			.getValueAt(
																					row,
																					col)));
													c.getCategories()
															.get(i)
															.checkItemUpdateDate();
													table.setValueAt(
															sdf.format(c
																	.getCategories()
																	.get(i)
																	.getItemList()
																	.get(j)
																	.getUpdateDate()),
															row, col);
													table.repaint();
												} catch (Exception exp) {

												}
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

	public void setQuarters(ArrayList<Quarter> quarters, String qt,
			String course) {
		this.quarters = quarters;
		this.selectedCourse = course;
		this.selectedQuarter = qt;
	}

	public void setQuarters(String qt, String course) {
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

	public void removeGrade(int row, int column) {

		for (Quarter current : quarters) {
			if (current.getName().equals(selectedQuarter)) {
				ArrayList<Course> currentCourses = current.getCourseList();

				for (Course c : currentCourses) {
					if (c.getCourseName().equals(selectedCourse)) {
						String letterGrade = (String) this.table.getValueAt(
								row, 0);
						c.getRubric().removeGrade(letterGrade);
						this.tableModel.removeRow(row);
						this.table.setModel(tableModel);
						this.table.repaint();
						return;
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

	public void addEmptyRow() {
		Object[] emptyRow = { "", "", "", "", "", false };
		this.tableModel.addRow(emptyRow);
		this.table.setModel(this.tableModel);
		this.table.repaint();
	}

	public void addItem(Object[] item, int row) {
		for (Quarter current : quarters) {
			if (current.getName().equals(selectedQuarter)) {
				ArrayList<Course> currentCourses = current.getCourseList();

				for (Course c : currentCourses) {
					if (c.getCourseName().equals(selectedCourse)) {
						String catName = (String) this.table.getValueAt(row, 4);
						for (int i = 0; i < c.getCategories().size(); i++) {
							if (c.getCategories().get(i).getName()
									.equals(catName)) {
								String itemName = (String) item[0];
								String earnedPoints = (String) item[1];
								String totalPoints = (String) item[2];
								String updateDate = (String) item[3];
								SimpleDateFormat sdf = new SimpleDateFormat(
										"MM/dd/yyyy");
								try {
									Date date = sdf.parse(updateDate);
									if (earnedPoints.equals("")
											&& totalPoints.equals("")) {
										Item newItem = new Item(itemName, date);
										c.getCategories().get(i)
												.addItem(newItem);
										c.getCategories().get(i)
												.checkItemUpdateDate();
										table.setValueAt(
												sdf.format(c
														.getCategories()
														.get(i)
														.getItemList()
														.get(c.getCategories()
																.get(i)
																.getItemList()
																.size() - 1)
														.getUpdateDate()), row,
												3);
									} else if (earnedPoints.equals("")
											&& !totalPoints.equals("")) {
										Item newItem = new Item(itemName,
												totalPoints, date);
										c.getCategories().get(i)
												.addItem(newItem);
										c.getCategories().get(i)
												.checkItemUpdateDate();
										table.setValueAt(
												sdf.format(c
														.getCategories()
														.get(i)
														.getItemList()
														.get(c.getCategories()
																.get(i)
																.getItemList()
																.size() - 1)
														.getUpdateDate()), row,
												3);
									} else {
										Item newItem = new Item(itemName,
												earnedPoints, totalPoints, date);
										c.getCategories().get(i)
												.addItem(newItem);
										c.getCategories().get(i)
												.checkItemUpdateDate();
										table.setValueAt(
												sdf.format(c
														.getCategories()
														.get(i)
														.getItemList()
														.get(c.getCategories()
																.get(i)
																.getItemList()
																.size() - 1)
														.getUpdateDate()), row,
												3);
									}
								} catch (Exception exp) {

								}
							}
						}
					}
				}
			}
		}
	}

	public void addInitialItems(Object[][] names, int numItems) {

		if (this.tableModel.getValueAt(0, 0).equals("")) {
			this.tableModel.removeRow(0);
		}

		for (int i = 0; i < numItems; i++) {
			this.tableModel.addRow(names[i]);
		}

		this.table.setModel(this.tableModel);
	}

	public void reset() {
		Object[][] data = { { "", "", "", "", "", false } };
		this.tableModel = new DefaultTableModel(data, this.columnNames);
		this.table.setModel(this.tableModel);
	}

	public JTable getTable() {
		return this.table;
	}
}
