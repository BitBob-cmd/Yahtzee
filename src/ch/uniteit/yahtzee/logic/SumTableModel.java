package ch.uniteit.yahtzee.logic;


import javax.swing.table.AbstractTableModel;

public class SumTableModel extends AbstractTableModel {
	private String[] columnNames = {"Spielpunkte",
			"Du", "Gegner"};

	private Object[][] data = {
			{"Bonus erhalten (62)",new Integer(0),new Integer(0)},
			{"Zwischensumme Oben",new Integer(0),new Integer(0)},
			{"Zwischensumme Unten",new Integer(0),new Integer(0)},
			{"Gesamtpunktzahl",new Integer(0),new Integer(0)}
	};


	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return data.length;
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {
		return data[row][col];
	}

	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
	// definiert welche Spalten editiert werden dürfen
	public boolean isCellEditable(int row, int col) {
		return false;
	}
	// Wert setzen in Tabelle
	public void setValueAt(Object value, int row, int col) {
		data[row][col] = value;
		fireTableCellUpdated(row, col);
	}
}

