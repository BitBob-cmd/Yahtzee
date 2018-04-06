package ch.uniteit.yahtzee.logic;


import javax.swing.table.AbstractTableModel;

public class ScoreTableModel extends AbstractTableModel {
	private String[] columnNames = {"Yahtzee",
			"Du", "Gegner","Verspielt"};

	private Object[][] data = {
			{"Einer",new Integer(0),new Integer(0), new Boolean(false)},
			{"Zweier",new Integer(0),new Integer(0),new Boolean(false)},
			{"Dreier",new Integer(0),new Integer(0),new Boolean(false)},
			{"Vierer",new Integer(0),new Integer(0),new Boolean(false)},
			{"Fünfer",new Integer(0),new Integer(0),new Boolean(false)},
			{"Sechser",new Integer(0),new Integer(0),new Boolean(false)},

			//{"Bonus erreicht (62)","Nein","Nein"},
			//{"Zwischensumme Oben",new Integer(0),new Integer(0)},new Boolean(false),

			{"Viererparsch",new Integer(0),new Integer(0),new Boolean(false)},
			{"Full-House",new Integer(0),new Integer(0),new Boolean(false)},
			{"Kleine Strasse",new Integer(0),new Integer(0),new Boolean(false)},
			{"Grosse Strasse",new Integer(0),new Integer(0),new Boolean(false)},
			{"Yahtzee",new Integer(0),new Integer(0),new Boolean(false)},
			{"Chance",new Integer(0),new Integer(0),new Boolean(false)}

			/**,
			{"Zwischensumme Unten",new Integer(0),new Integer(0)},
			{"Gesamtpunktzahl",new Integer(0),new Integer(0)}
			*/
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

