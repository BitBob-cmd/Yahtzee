package ch.uniteit.yahtzee.logic;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import ch.uniteit.yahtzee.gui.GUI;

import java.awt.*;
import java.awt.event.ActionListener;
/*
 * Diese Klasse ist für das Auswerten und einfüllen der Tabelle zuständig
 */

public class ScoreTable {

	protected JTable scoreTable;
	protected JTable sumTable;
	protected JTable rankTable;
	protected ListSelectionModel cellSelectionModel;
	protected int sr; // selected row
	protected int sc; // selected column
	protected Rules rl;


	public ScoreTable(Rules rl) {
		this.rl = rl;
		ScoreTableModel tm = new ScoreTableModel();

		this.scoreTable = new JTable(tm);
		this.scoreTable.setCellSelectionEnabled(true);
		this.cellSelectionModel = scoreTable.getSelectionModel();
		this.cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		

		this.scoreTable.setFillsViewportHeight(true);

		Dimension td = new Dimension(600, 300);
		this.scoreTable.setPreferredSize(td);
		this.scoreTable.setRowHeight(30);

		this.sumTable = new JTable(new SumTableModel());
		this.sumTable.setColumnSelectionAllowed(false);
		this.sumTable.setRowSelectionAllowed(false);
		this.sumTable.setCellSelectionEnabled(false);
		this.sumTable.setShowVerticalLines(false);
		Dimension tdd = new Dimension(600, 150);
		this.sumTable.setPreferredSize(tdd);

		this.rankTable = new JTable(new RankingTableModel());
		this.rankTable.setColumnSelectionAllowed(false);
		this.rankTable.setRowSelectionAllowed(false);
		this.rankTable.setCellSelectionEnabled(false);
		this.rankTable.setShowVerticalLines(false);
		Dimension tddd = new Dimension(100, 150);
		this.rankTable.setPreferredSize(tddd);
	}

	

	public JTable gibScoreTable() {
		if (scoreTable != null)
			return scoreTable;
		else
			return null;

	}

	public JTable gibSumTable() {
		if (sumTable != null)
			return sumTable;
		else
			return null;

	}

	public JTable gibRankingTable() {
		if (rankTable != null)
			return rankTable;
		else
			return null;

	}

	// reset methode
	public void neuesSpiel() {
		int numRows = scoreTable.getRowCount() - 1;
		int numCols = scoreTable.getColumnCount() - 1;
		System.out.println(numRows);
		while (numRows >= 0) {
			scoreTable.setValueAt(0, numRows, 1);
			scoreTable.setValueAt(new Boolean(false), numRows, 2);
			scoreTable.setValueAt(0, numRows, 3);
			scoreTable.setValueAt(new Boolean(false), numRows, 4);
			numRows--;
		}
	}

	public Rules gibRegeln() throws Exception{
		if(rl != null) return this.rl;
		else{
			throw new Exception("Es konnte kein Rules-Objekt erstellt werden in der Klasse ScoreTable");
		}
	}

}