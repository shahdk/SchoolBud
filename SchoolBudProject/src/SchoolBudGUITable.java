import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
	private final int NUM_RUBRIC_COLS = 5;
	private String oldGrade = "";
	private Color[] backColor = {new Color(13496723), new Color(10543814), new Color(16776092)};
	private Color[] foreColor = {Color.BLACK, Color.BLACK, Color.BLACK};
	private HashMap<String, Integer> colorCode = new HashMap<String, Integer>();

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

			this.table.setDefaultRenderer(String.class,
					new MyItemTableCellRenderer());
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
			this.table.setDefaultRenderer(String.class,
					new MyTableCellRenderer());
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
						try{
							removeItem(row, column);
						}catch (Exception exp){
							
						}
					}
				}

			});
		} else {
			this.table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {

					int row = table.getSelectedRow();
					int column = table.getSelectedColumn();
					if (column == 4) {
						removeRubric(row, column);
					}
					oldGrade = (String) table.getValueAt(row, 0);
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
						itemEdit(row, col);
					}
					return;

				}
				if (col < 4) {
					if (!table.isEditing()) {
						rubricEditing(row, col);
					} else {
						if (row >= 0 && col >= 0) {
							checkRubricEditing(row, col);
						}
					}
				}

			}
		}

		public void itemEdit(int row, int col) {
			if (!table.isEditing()) {
				itemEditing(row, col);
			} else {
				if (row >= 0 && col >= 0) {
					checkEditing(row, col);
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
				try {
					if (!data[0].equals("") && !data[3].equals("")
							&& !data[4].equals("")) {
						addItem(data, row);
						addEmptyRow();
					}
				} catch (Exception e) {
					reset();
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame, "Invalid Input");
				}
			} else {
				try {
					if (!table.getValueAt(row, col).equals(""))
						editItems(row, col);
					newAdd = true;
				} catch (Exception e) {
					reset();
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame, "Invalid Input");
				}
			}
		}

		public void rubricEditing(int row, int col) {
			if (newAdd) {
				Object[] data = new Object[NUM_RUBRIC_COLS];
				data[0] = table.getValueAt(row, 0);
				data[1] = table.getValueAt(row, 1);
				data[2] = table.getValueAt(row, 2);
				data[3] = table.getValueAt(row, 3);
				data[4] = false;
				if (!data[0].equals("") && !data[1].equals("")
						&& !data[2].equals("") && !data.equals("")) {
					addRubric(data, row);
					addEmptyRowRubric();
				}
			} else {
				if (!table.getValueAt(row, col).equals(""))
					editRubric(row, col);
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

		public void checkRubricEditing(int row, int col) {
			if (table.getValueAt(row, 0).equals("")
					|| table.getValueAt(row, 1).equals("")
					|| table.getValueAt(row, 2).equals("")
					|| table.getValueAt(row, 3).equals("")) {
				newAdd = true;
			} else {
				newAdd = false;
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
							int it = -1;
							;
							int curr = -1;
							int newCat = -1;
							for (int i = 0; i < c.getCategories().size(); i++) {
								if (c.getCategories().get(i).getName()
										.equals(catName)) {
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
							if (newCat == -1) {
								table.setValueAt(c.getCategories().get(curr)
										.getName(), row, col);
								return;
							} else {
								c.getCategories()
										.get(newCat)
										.addItem(
												c.getCategories().get(curr)
														.getItemList().get(it));
								c.getCategories().get(curr)
										.removeItem(itemName);
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

	public void editRubric(int row, int col) {
		for (Quarter current : quarters) {
			if (current.getName().equals(selectedQuarter)) {
				ArrayList<Course> currentCourses = current.getCourseList();
				for (Course c : currentCourses) {
					if (c.getCourseName().equals(selectedCourse)) {
						if (col == 0) {
							String newGrade = (String) this.tableModel
									.getValueAt(row, col);
							c.getRubric().setLetterGrade(oldGrade, newGrade);
						} else if (col == 1) {
							String lower = (String) this.tableModel.getValueAt(
									row, col);
							String grade = (String) this.tableModel.getValueAt(
									row, 0);
							c.getRubric().setLowerLimit(grade,
									Double.parseDouble(lower));
						} else if (col == 2) {
							String upper = (String) this.tableModel.getValueAt(
									row, col);
							String grade = (String) this.tableModel.getValueAt(
									row, 0);
							c.getRubric().setUpperLimit(grade,
									Double.parseDouble(upper));
						} else if (col == 3) {
							String gpa = (String) this.tableModel.getValueAt(
									row, col);
							String grade = (String) this.tableModel.getValueAt(
									row, 0);
							c.getRubric()
									.setGPA(grade, Double.parseDouble(gpa));
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

	public void removeRubric(int row, int column) {

		for (Quarter current : quarters) {
			if (current.getName().equals(selectedQuarter)) {
				ArrayList<Course> currentCourses = current.getCourseList();

				for (Course c : currentCourses) {
					if (c.getCourseName().equals(selectedCourse)) {
						String letterGrade = (String) this.table.getValueAt(
								row, 0);
						if (letterGrade.equals("")) {
							return;
						}
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
		for (int i = 0; i < headings.length; i++) {
			this.table.getTableHeader().getColumnModel().getColumn(i)
					.setHeaderValue(headings[i]);
			this.table.repaint();
		}
	}

	public void addEmptyRow() {
		Object[] emptyRow = { "", "", "", "", "", false };
		this.tableModel.addRow(emptyRow);
		this.table.setModel(this.tableModel);
		this.table.setDefaultRenderer(String.class,
				new MyItemTableCellRenderer());
		this.table.repaint();
	}

	public void addEmptyRowRubric() {
		Object[] emptyRow = { "", "", "", "", false };
		this.tableModel.addRow(emptyRow);
		this.table.setModel(this.tableModel);
		this.table.setDefaultRenderer(String.class, new MyTableCellRenderer());
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

	public void addRubric(Object[] rubric, int row) {
		for (Quarter current : quarters) {
			if (current.getName().equals(selectedQuarter)) {
				ArrayList<Course> currentCourses = current.getCourseList();

				for (Course c : currentCourses) {
					if (c.getCourseName().equals(selectedCourse)) {
						String letter = (String) rubric[0];
						String lower = (String) rubric[1];
						String upper = (String) rubric[2];
						String gpa = (String) rubric[3];
						try {
							c.getRubric().addGrade(letter,
									Double.parseDouble(lower),
									Double.parseDouble(upper),
									Double.parseDouble(gpa));
							return;
						} catch (Exception exp) {
							
						}
					}
				}
			}
		}
	}

	public void addInitialItems(Object[][] names, int numItems) {
		
		if (this.type.equals("rubric")) {
			this.tableModel = new DefaultTableModel(names, this.columnNames) {
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

			this.table.setModel(tableModel);
			this.table.setDefaultRenderer(String.class,
					new MyTableCellRenderer());
		}else{
			if (this.tableModel.getValueAt(0, 0).equals("")) {
				this.tableModel.removeRow(0);
			}

			for (int i = 0; i < numItems; i++) {
				this.tableModel.addRow(names[i]);
			}

			this.table.setModel(this.tableModel);
		}

	}

	public void reset() {
		Object[][] data = { { "", "", "", "", "", false } };
		this.tableModel = new DefaultTableModel(data, this.columnNames);
		this.table.setModel(this.tableModel);
	}

	public JTable getTable() {
		return this.table;
	}
	
	public void setTableColor(String catName, int pos){
		this.colorCode.put(catName, pos);
	}

	class MyTableCellRenderer extends
			javax.swing.table.DefaultTableCellRenderer {
		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			// component will actually be this.
			Component component = super.getTableCellRendererComponent(table,
					value, isSelected, hasFocus, row, column);
			component.setBackground(row % 2 == 0 ? Color.BLUE : Color.CYAN);
			component.setForeground(row % 2 == 0 ? Color.white : Color.BLACK);
			return component;
		}
	}

	class MyItemTableCellRenderer extends
			javax.swing.table.DefaultTableCellRenderer {
		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			int pos = 0;
			try{
				pos = colorCode.get((String)table.getValueAt(row, 4));
			}catch (Exception exp){
				
			}
			// component will actually be this.
			Component component = super.getTableCellRendererComponent(table,
					value, isSelected, hasFocus, row, column);
			component.setBackground(backColor[pos]);
			component.setForeground(foreColor[pos]);
			return component;
		}
	}
}
