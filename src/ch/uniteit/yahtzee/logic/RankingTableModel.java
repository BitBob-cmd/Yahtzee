package ch.uniteit.yahtzee.logic;


import javax.swing.table.AbstractTableModel;

public class RankingTableModel extends AbstractTableModel {
	private String[] columnNames = {"Rangliste",
			"Score", "Ranking"};

	private Object[][] data = {
			{"Spieler",new Integer(0),new Integer(1)},
			{"Spieler",new Integer(0),new Integer(2)},
			{"Speiler",new Integer(0),new Integer(3)},
			{"Spieler",new Integer(0),new Integer(4)},
			{"Spieler",new Integer(0),new Integer(5)},
			{"Spieler",new Integer(0),new Integer(6)},
			{"Spieler",new Integer(0),new Integer(7)},
			{"Spieler",new Integer(0),new Integer(8)},
			{"Spieler",new Integer(0),new Integer(9)},
			{"Spieler",new Integer(0),new Integer(10)}
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

