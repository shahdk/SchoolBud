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
 * Displays the JTable for the program.
 * 
 * @author padillbt-1. Created May 1, 2013.
 */
public class SchoolBudGUITable {
	/**
	 * The table being used.
	 */
	private JTable table;
	/**
	 * Scrollpane for the table
	 */
	private JScrollPane tableSP;
	/**
	 * TableModel to construct the table
	 */
	private DefaultTableModel tableModel;
	/**
	 * Stores the column headers
	 */
	private String[] columnNames;
	/**
	 * List of quarters
	 */
	private ArrayList<Quarter> quarters;
	/**
	 * Current quarter
	 */
	private String selectedQuarter;
	/**
	 * Current course
	 */
	private String selectedCourse;
	/**
	 * Stores the type of table, that is, table used for display rubric or items
	 */
	private String type;
	/**
	 * Indicates whether the table row is being edited or a new row is to be
	 * added
	 */
	private boolean newAdd = false;
	/**
	 * Number of columns for displaying items
	 */
	private final int NUM_COLS = 6;
	/**
	 * Number of columns for displaying rubric
	 */
	private final int NUM_RUBRIC_COLS = 5;
	/**
	 * Stores the old grade before replacing the grade with a new one
	 */
	private String oldGrade = "";
	/**
	 * background color for table rows.
	 */
	private Color[] backColor = { new Color(13496723), new Color(10543814),
			new Color(16776092) };
	/**
	 * text color for table.
	 */
	private Color[] foreColor = { Color.BLACK, Color.BLACK, Color.BLACK };
	/**
	 * maps category to specific colors.
	 */
	private HashMap<String, Integer> colorCode = new HashMap<String, Integer>();

	/**
	 * Constructor initialize the table with the given column headers and the
	 * type of table to be initialized.
	 * 
	 * @param names
	 * @param type
	 */
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
		this.tableSP = new JScrollPane(this.table);
		this.tableSP.setPreferredSize(new Dimension(500, 400));

		if (type.equals("item")) {
			this.table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {

					int row = SchoolBudGUITable.this.table.getSelectedRow();
					int column = SchoolBudGUITable.this.table
							.getSelectedColumn();
					if (column == 5) {
						try {
							removeItem(row, column);
						} catch (Exception exp) {
							//
						}
					}
				}

			});
		} else {
			this.table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {

					int row = SchoolBudGUITable.this.table.getSelectedRow();
					int column = SchoolBudGUITable.this.table
							.getSelectedColumn();
					if (column == 4) {
						removeRubric(row, column);
					}
					SchoolBudGUITable.this.oldGrade = (String) SchoolBudGUITable.this.table
							.getValueAt(row, 0);
				}

			});
		}

		TableCellListener tcl = new TableCellListener();
		this.table.addPropertyChangeListener(tcl);
	}

	/**
	 * Inner class to check for changes made to a table cell.
	 * 
	 * @author shahdk
	 * 
	 */
	private class TableCellListener implements PropertyChangeListener {

		@Override
		public void propertyChange(PropertyChangeEvent e) {

			if ("tableCellEditor".equals(e.getPropertyName())) {
				int row = SchoolBudGUITable.this.table.getSelectedRow();
				int col = SchoolBudGUITable.this.table.getSelectedColumn();

				if (SchoolBudGUITable.this.type.equals("item")) {
					if (col < 5) {
						itemEdit(row, col);
					}
					return;

				}
				if (col < 4) {
					if (!SchoolBudGUITable.this.table.isEditing()) {
						rubricEditing(row, col);
					} else {
						if (row >= 0 && col >= 0) {
							checkRubricEditing(row, col);
						}
					}
				}

			}
		}

		/**
		 * Checks to see if a table cell is being edited
		 * 
		 * @param row
		 * @param col
		 */
		public void itemEdit(int row, int col) {
			if (!SchoolBudGUITable.this.table.isEditing()) {
				itemEditing(row, col);
			} else {
				if (row >= 0 && col >= 0) {
					checkEditing(row);
				}
			}
		}

		/**
		 * Adds or edits the table cell based on the values entered and the
		 * cells updated
		 * 
		 * @param row
		 * @param col
		 */
		public void itemEditing(int row, int col) {
			if (SchoolBudGUITable.this.newAdd) {
				Object[] data = new Object[SchoolBudGUITable.this.NUM_COLS];
				data[0] = SchoolBudGUITable.this.table.getValueAt(row, 0);
				data[1] = SchoolBudGUITable.this.table.getValueAt(row, 1);
				data[2] = SchoolBudGUITable.this.table.getValueAt(row, 2);
				data[3] = SchoolBudGUITable.this.table.getValueAt(row, 3);
				data[4] = SchoolBudGUITable.this.table.getValueAt(row, 4);
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
					if (!SchoolBudGUITable.this.table.getValueAt(row, col)
							.equals(""))
						editItems(row, col);
					SchoolBudGUITable.this.newAdd = true;
				} catch (Exception e) {
					reset();
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame, "Invalid Input");
				}
			}
		}

		/**
		 * Adds or edits the table cell based on the values entered and the
		 * cells updated
		 * 
		 * @param row
		 * @param col
		 */
		public void rubricEditing(int row, int col) {
			if (SchoolBudGUITable.this.newAdd) {
				Object[] data = new Object[SchoolBudGUITable.this.NUM_RUBRIC_COLS];
				data[0] = SchoolBudGUITable.this.table.getValueAt(row, 0);
				data[1] = SchoolBudGUITable.this.table.getValueAt(row, 1);
				data[2] = SchoolBudGUITable.this.table.getValueAt(row, 2);
				data[3] = SchoolBudGUITable.this.table.getValueAt(row, 3);
				data[4] = false;
				if (!data[0].equals("") && !data[1].equals("")
						&& !data[2].equals("") && !data[3].equals("")) {
					addRubric(data, row);
					addEmptyRowRubric();
				}
			} else {
				if (!SchoolBudGUITable.this.table.getValueAt(row, col).equals(
						""))
					editRubric(row, col);
				SchoolBudGUITable.this.newAdd = true;
			}
		}

		/**
		 * Checks to see if a row is being edited or a new row is being created.
		 * 
		 * @param row
		 */
		public void checkEditing(int row) {
			if (SchoolBudGUITable.this.table.getValueAt(row, 0).equals("")) {
				SchoolBudGUITable.this.newAdd = true;
			} else {
				if (SchoolBudGUITable.this.table.getValueAt(row, 3).equals("")) {
					SchoolBudGUITable.this.newAdd = true;
				} else if (SchoolBudGUITable.this.table.getValueAt(row, 4)
						.equals("")) {
					SchoolBudGUITable.this.newAdd = true;
				} else {
					SchoolBudGUITable.this.newAdd = false;
				}
			}
		}

		/**
		 * Checks to see if a row is being edited or a new row is being created.
		 * 
		 * @param row
		 * @param col
		 */
		public void checkRubricEditing(int row, int col) {
			if (SchoolBudGUITable.this.table.getValueAt(row, 0).equals("")
					|| SchoolBudGUITable.this.table.getValueAt(row, 1).equals(
							"")
					|| SchoolBudGUITable.this.table.getValueAt(row, 2).equals(
							"")
					|| SchoolBudGUITable.this.table.getValueAt(row, 3).equals(
							"")) {
				SchoolBudGUITable.this.newAdd = true;
			} else {
				SchoolBudGUITable.this.newAdd = false;
			}
		}
	}

	/**
	 * Edit the item based on the row that was just updated
	 * 
	 * @param row
	 * @param col
	 */
	public void editItems(int row, int col) {
		for (Quarter current : this.quarters) {
			if (current.getName().equals(this.selectedQuarter)) {
				ArrayList<Course> currentCourses = current.getCourseList();
				for (Course c : currentCourses) {
					if (c.getCourseName().equals(this.selectedCourse)) {
						String catName = (String) this.table.getValueAt(row, 4);
						String itemName = (String) this.table
								.getValueAt(row, 0);

						if (col == 4) {
							int it = -1;
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
								this.table.setValueAt(
										c.getCategories().get(curr).getName(),
										row, col);
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
																(String) this.table
																		.getValueAt(
																				row,
																				col));
											} else if (col == 1) {
												c.getCategories()
														.get(i)
														.getItemList()
														.get(j)
														.setEarnedPoints(
																(String) this.table
																		.getValueAt(
																				row,
																				col));
											} else if (col == 2) {
												c.getCategories()
														.get(i)
														.getItemList()
														.get(j)
														.setTotalPoints(
																(String) this.table
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
																	sdf.parse((String) this.table
																			.getValueAt(
																					row,
																					col)));
													c.getCategories()
															.get(i)
															.checkItemUpdateDate();
													this.table
															.setValueAt(
																	sdf.format(c
																			.getCategories()
																			.get(i)
																			.getItemList()
																			.get(j)
																			.getUpdateDate()),
																	row, col);
													this.table.repaint();
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

	/**
	 * Edit the rubric based on the row that was just updated
	 * 
	 * @param row
	 * @param col
	 */
	public void editRubric(int row, int col) {
		for (Quarter current : this.quarters) {
			if (current.getName().equals(this.selectedQuarter)) {
				ArrayList<Course> currentCourses = current.getCourseList();
				for (Course c : currentCourses) {
					if (c.getCourseName().equals(this.selectedCourse)) {
						if (col == 0) {
							String newGrade = (String) this.tableModel
									.getValueAt(row, col);
							c.getRubric().setLetterGrade(this.oldGrade,
									newGrade);
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

	/**
	 * Sets the list of quarters, the current quarter and the current course
	 * 
	 * @param quarters
	 * @param qt
	 * @param course
	 */
	public void setQuarters(ArrayList<Quarter> quarters, String qt,
			String course) {
		this.quarters = quarters;
		this.selectedCourse = course;
		this.selectedQuarter = qt;
	}

	/**
	 * Returns the scrollpane of the table
	 * 
	 * @return JScrollPane
	 */
	public JScrollPane getJScrollPane() {
		return this.tableSP;
	}

	/**
	 * Removes the selected item.
	 * 
	 * @param row
	 * @param column
	 */
	public void removeItem(int row, int column) {

		for (Quarter current : this.quarters) {
			if (current.getName().equals(this.selectedQuarter)) {
				ArrayList<Course> currentCourses = current.getCourseList();

				for (Course c : currentCourses) {
					if (c.getCourseName().equals(this.selectedCourse)) {
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
										this.table.setModel(this.tableModel);
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

	/**
	 * Removes the selected rubric grade from Rubric.
	 * 
	 * @param row
	 * @param column
	 */
	public void removeRubric(int row, int column) {

		for (Quarter current : this.quarters) {
			if (current.getName().equals(this.selectedQuarter)) {
				ArrayList<Course> currentCourses = current.getCourseList();

				for (Course c : currentCourses) {
					if (c.getCourseName().equals(this.selectedCourse)) {
						String letterGrade = (String) this.table.getValueAt(
								row, 0);
						if (letterGrade.equals("")) {
							return;
						}
						c.getRubric().removeGrade(letterGrade);
						this.tableModel.removeRow(row);
						this.table.setModel(this.tableModel);
						this.table.repaint();
						return;
					}
				}
			}
		}
	}

	/**
	 * Changes the header values for internationalization.
	 * 
	 * @param headings
	 */
	public void changeHeaderValues(String[] headings) {
		for (int i = 0; i < headings.length; i++) {
			this.table.getTableHeader().getColumnModel().getColumn(i)
					.setHeaderValue(headings[i]);
			this.table.repaint();
		}
	}

	/**
	 * Adds an empty row to the item table
	 */
	public void addEmptyRow() {
		Object[] emptyRow = { "", "", "", "", "", false };
		this.tableModel.addRow(emptyRow);
		this.table.setModel(this.tableModel);
		this.table.setDefaultRenderer(String.class,
				new MyItemTableCellRenderer());
		this.table.repaint();
	}

	/**
	 * Adds an empty row to the rubric table
	 */
	public void addEmptyRowRubric() {
		Object[] emptyRow = { "", "", "", "", false };
		this.tableModel.addRow(emptyRow);
		this.table.setModel(this.tableModel);
		this.table.setDefaultRenderer(String.class, new MyTableCellRenderer());
		this.table.repaint();
	}

	/**
	 * Creates a new item based on the values from the table row
	 * 
	 * @param item
	 * @param row
	 */
	public void addItem(Object[] item, int row) {
		for (Quarter current : this.quarters) {
			if (current.getName().equals(this.selectedQuarter)) {
				ArrayList<Course> currentCourses = current.getCourseList();

				for (Course c : currentCourses) {
					if (c.getCourseName().equals(this.selectedCourse)) {
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
										this.table.setValueAt(
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
										this.table.setValueAt(
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
										this.table.setValueAt(
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

	/**
	 * Creates a new letter grade based on the values from the table row
	 * 
	 * @param rubric
	 * @param row
	 */
	public void addRubric(Object[] rubric, int row) {
		for (Quarter current : this.quarters) {
			if (current.getName().equals(this.selectedQuarter)) {
				ArrayList<Course> currentCourses = current.getCourseList();

				for (Course c : currentCourses) {
					if (c.getCourseName().equals(this.selectedCourse)) {
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

	/**
	 * Initializes the table when loading a file.
	 * 
	 * @param names
	 * @param numItems
	 */
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

			this.table.setModel(this.tableModel);
			this.table.setDefaultRenderer(String.class,
					new MyTableCellRenderer());
		} else {
			if (this.tableModel.getValueAt(0, 0).equals("")) {
				this.tableModel.removeRow(0);
			}

			for (int i = 0; i < numItems; i++) {
				this.tableModel.addRow(names[i]);
			}

			this.table.setModel(this.tableModel);
		}

	}

	/**
	 * Resets the table
	 */
	public void reset() {
		Object[][] data = { { "", "", "", "", "", false } };
		this.tableModel = new DefaultTableModel(data, this.columnNames);
		this.table.setModel(this.tableModel);
	}

	/**
	 * Returns the table
	 * 
	 * @return JTable
	 */
	public JTable getTable() {
		return this.table;
	}

	/**
	 * Maps the category with a color
	 * 
	 * @param catName
	 * @param pos
	 */
	public void setTableColor(String catName, int pos) {
		this.colorCode.put(catName, pos);
	}

	/**
	 * Inner class to color the items table
	 * 
	 * @author shahdk
	 * 
	 */
	class MyTableCellRenderer extends
			javax.swing.table.DefaultTableCellRenderer {
		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			Component component = super.getTableCellRendererComponent(table,
					value, isSelected, hasFocus, row, column);
			component.setBackground(row % 2 == 0 ? new Color(13496723) : new Color(10543814));
			return component;
		}
	}

	/**
	 * Inner class to color the rubric table
	 * 
	 * @author shahdk
	 * 
	 */
	class MyItemTableCellRenderer extends
			javax.swing.table.DefaultTableCellRenderer {
		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			int pos = 0;
			try {
				pos = SchoolBudGUITable.this.colorCode.get(table.getValueAt(
						row, 4));
			} catch (Exception exp) {
				// ignore
			}
			Component component = super.getTableCellRendererComponent(table,
					value, isSelected, hasFocus, row, column);
			component.setBackground(SchoolBudGUITable.this.backColor[pos]);
			component.setForeground(SchoolBudGUITable.this.foreColor[pos]);
			return component;
		}
	}
}
