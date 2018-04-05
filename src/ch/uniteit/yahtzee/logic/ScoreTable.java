package ch.uniteit.yahtzee.logic;

import javax.swing.*;
import java.awt.*;

public class ScoreTable extends JPanel {
	protected JTable table;
	public ScoreTable() {
		super(new GridLayout(1,0));
		String[] columnNames = {"Oberer Teil",
				"Du", "Gegner"};

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
				{"Gesamtpunktzahl",new Integer(-1),new Integer(-1)}
		};

		this.table = new JTable(data, columnNames);
		table.setFillsViewportHeight(true);
		table.setSelectionMode(0);
		int rc = table.getRowCount();
	}

	public JTable gibTabelle(){
		if(table != null) return table;
		else return null;
	}

}
