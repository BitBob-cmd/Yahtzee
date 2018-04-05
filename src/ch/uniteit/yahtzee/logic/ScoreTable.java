package ch.uniteit.yahtzee.logic;

import javax.swing.*;

public class ScoreTable {
	protected String[] tableHeader;
	protected Object[][] tableData;
	protected JTable table;
	public ScoreTable() {
		String[] tableHeader = {"Oberer Teil",
				"Du", "Gegner"};
		this.tableHeader = tableHeader;

		Object[][] data = {
				{"Einer",new Integer(-1),new Integer(-1)},
				{"Zweier",new Integer(-1),new Integer(-1)},
				{"Dreier",new Integer(-1),new Integer(-1)},
				{"Vierer",new Integer(-1),new Integer(-1)},
				{"Fünfer",new Integer(-1),new Integer(-1)},
				{"Sechser",new Integer(-1),new Integer(-1)},
				{"Bonus (62)",new Integer(-1),new Integer(-1)},
				{"Zwischensumme Oben",new Integer(-1),new Integer(-1)},
				{"Unterer Teil",new Integer(-1),new Integer(-1)},
				{"Viererparsch",new Integer(-1),new Integer(-1)},
				{"Full-House",new Integer(-1),new Integer(-1)},
				{"Kleine Strasse",new Integer(-1),new Integer(-1)},
				{"Grosse Strasse",new Integer(-1),new Integer(-1)},
				{"Yahtzee",new Integer(-1),new Integer(-1)},
				{"Chance",new Integer(-1),new Integer(-1)},
				{"Zwischensumme Unten",new Integer(-1),new Integer(-1)},
				{"Gesamtpunktzahl",new Integer(0),new Integer(0)}
		};
		this.tableData = data;

		this.table = new JTable(tableData, tableHeader);
	}

	public JTable gibTabelle(){
		if(table != null) return table;
		else return null;
	}
}
