package ch.uniteit.yahtzee.logic;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class ScoreTable extends JPanel {
	protected JTable table;
	protected JTableHeader tableHeader;
	public ScoreTable() {
		super(new GridLayout(1, 0));
		this.tableHeader = new JTableHeader();

		TableModel tm = new TableModel();
		this.table = new JTable(tm);
		this.table.setFillsViewportHeight(true);
		this.table.setSelectionMode(1);
		Dimension td = new Dimension(600,540);
		this.table.setPreferredSize(td);
		this.table.setRowHeight(30);
		//this.table.setShowGrid(false);
		System.out.println(table.getSelectedRow());
	}

	public JTable gibTabelle() {
		if (table != null) return table;
		else return null;
	}

}
