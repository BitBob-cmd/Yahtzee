package ch.uniteit.yahtzee.logic;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class ScoreTable extends JPanel {
	protected JTable scoreTable;
	protected JTable sumTable;
	protected JTable rankTable;
	private ListSelectionModel cellSelectionModel;
	private Rules regeln;
	private AbstractTableModel stModel;
	private AbstractTableModel suModel;
	private AbstractTableModel raModel;
	private int col;
	private int row;


	public ScoreTable(Rules regeln) {
		this.regeln = regeln;
		this.col = 0;
		this.row = 0;
		this.stModel = new ScoreTableModel();
		this.suModel = new SumTableModel();
		this.raModel = new RankingTableModel();
		this.scoreTable = new JTable(stModel);
		this.scoreTable.setCellSelectionEnabled(true);
		this.cellSelectionModel = scoreTable.getSelectionModel();
		this.cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.addSelectionListener();

		this.scoreTable.setFillsViewportHeight(true);

		// für was isch das??
		// this.scoreTable.setSelectionMode(1);

		Dimension td = new Dimension(600, 300);
		this.scoreTable.setPreferredSize(td);
		this.scoreTable.setRowHeight(30);


		this.sumTable = new JTable(suModel);
		this.sumTable.setColumnSelectionAllowed(false);
		this.sumTable.setRowSelectionAllowed(false);
		this.sumTable.setCellSelectionEnabled(false);
		this.sumTable.setShowVerticalLines(false);
		Dimension tdd = new Dimension(600, 150);
		this.sumTable.setPreferredSize(tdd);

		this.rankTable = new JTable(raModel);
		this.rankTable.setColumnSelectionAllowed(false);
		this.rankTable.setRowSelectionAllowed(false);
		this.rankTable.setCellSelectionEnabled(false);
		this.rankTable.setShowVerticalLines(false);
		Dimension tddd = new Dimension(100, 150);
		this.rankTable.setPreferredSize(tddd);

		scoreTable.setValueAt(22, 0, 1);
		scoreTable.setValueAt(true, 0, 3);
	}


	public void addSelectionListener() {

		this.cellSelectionModel.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				if(!e.getValueIsAdjusting()) {



					int selectedData = 0;

					int[] selectedRow = scoreTable.getSelectedRows();
					int[] selectedColumns = scoreTable.getSelectedColumns();

					for (int i = 0; i < selectedRow.length; i++) {
						for (int j = 0; j < selectedColumns.length; j++) {
							selectedData = (int) scoreTable.getValueAt(selectedRow[i], selectedColumns[j]);
						}
					}
					System.out.println("Selected: " + selectedData);

					int sr = scoreTable.getSelectedRow();
					int sc = scoreTable.getSelectedColumn();
//					String selRule = scoreTable.getValueAt(sr, 0).toString();
					boolean isLocked = (boolean) scoreTable.getValueAt(row, 3);
					System.out.println(isLocked + " " + row + " " + col);
					int punktzahl;
					switch (sc) {
						case 0:
							punktzahl = regeln.einerResultat();
							System.out.println(regeln.einerResultat());
							break;
						case 1:
							//punktzahl = regeln.zweierResultat();
							System.out.println(regeln.einerResultat());
							break;
						case 2:
							punktzahl = regeln.dreierResultat();
							break;
						case 3:
							punktzahl = regeln.viererResultat();
							break;
						case 4:
							punktzahl = regeln.fuenferResultat();
							break;
						case 5:
							punktzahl = regeln.sechserResultat();
							break;
						case 6:
							punktzahl = regeln.resultatViererPasch();
							break;
						case 7:
							punktzahl = regeln.fullhouseResultat();
							break;
						case 8:
							punktzahl = regeln.kleineStrasseResultat();
							break;
						case 9:
							punktzahl = regeln.grosseStrasseResultat();
							break;
						case 10:
							punktzahl = regeln.yathzeeKniffelResultat();
							break;
						case 11:
							punktzahl = 999;
							break;
						default:
							punktzahl = 0;
							break;
					}
					//System.out.println("Rules liefert " + punktzahl);

					if (isLocked != false) {
						scoreTable.setValueAt(100, 1, 2);

					} else {
						System.out.println("selRule" + " ist gesperrt..");
					}
				}

			}});

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

	public void test(){
		System.out.println(regeln.dreierResultat());
	}
}
