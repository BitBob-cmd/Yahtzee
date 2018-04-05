package ch.uniteit.yahtzee.logic;


import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {
	protected  String[] columnNames = {"Oberer Teil",
			"Du", "Gegner"};

	protected  Object[][] data = {
			{"","Spieler1","Spieler2"},
			{"Einer",new Integer(0),new Integer(0)},
			{"Zweier",new Integer(0),new Integer(0)},
			{"Dreier",new Integer(0),new Integer(0)},
			{"Vierer",new Integer(0),new Integer(0)},
			{"Fünfer",new Integer(0),new Integer(0)},
			{"Sechser",new Integer(0),new Integer(0)},
			{"Bonus erreicht (62)","Nein","Nein"},
			{"Zwischensumme Oben",new Integer(0),new Integer(0)},
			{"-","-","-"},
			{"Viererparsch",new Integer(0),new Integer(0)},
			{"Full-House",new Integer(0),new Integer(0)},
			{"Kleine Strasse",new Integer(0),new Integer(0)},
			{"Grosse Strasse",new Integer(0),new Integer(0)},
			{"Yahtzee",new Integer(0),new Integer(0)},
			{"Chance",new Integer(0),new Integer(0)},
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

