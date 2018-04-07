package ch.uniteit.yahtzee.logic;


import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class ScoreTableModel extends AbstractTableModel {
	protected String[] columnNames = {"Yahtzee",
			"Du","Verspielt","Gegner","Verspielt"};

	protected Object[][] data = {
			{"Einer",new Integer(0),new Boolean(false),new Integer(0), new Boolean(false)}, //0
			{"Zweier",new Integer(0),new Boolean(false),new Integer(0),new Boolean(false)}, //1
			{"Dreier",new Integer(0),new Boolean(false),new Integer(0),new Boolean(false)}, //2
			{"Vierer",new Integer(0),new Boolean(false),new Integer(0),new Boolean(false)}, //3
			{"Fünfer",new Integer(0),new Boolean(false),new Integer(0),new Boolean(false)}, //4
			{"Sechser",new Integer(0),new Boolean(false),new Integer(0),new Boolean(false)}, //5

			//{"Bonus erreicht (62)","Nein","Nein"},
			//{"Zwischensumme Oben",new Integer(0),new Integer(0)},new Boolean(false),

			{"Viererparsch",new Integer(0),new Boolean(false),new Integer(0),new Boolean(false)}, //6
			{"Full-House",new Integer(0),new Boolean(false),new Integer(0),new Boolean(false)}, //7
			{"Kleine Strasse",new Integer(0),new Boolean(false),new Integer(0),new Boolean(false)}, //8
			{"Grosse Strasse",new Integer(0),new Boolean(false),new Integer(0),new Boolean(false)}, //9
			{"Yahtzee",new Integer(0),new Boolean(false),new Integer(0),new Boolean(false)}, //10
			{"Chance",new Integer(0),new Boolean(false),new Integer(0),new Boolean(false)} //11

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
		//if(col < 1){
			//return false;
		//}
		//else { return true; }
		 
		return false;
	}
	// Wert setzen in Tabelle
	public void setValueAt(Object value, int row, int col) {
		data[row][col] = value;
		fireTableCellUpdated(row, col);
	}
	
	 
	
}

