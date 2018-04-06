package ch.uniteit.yahtzee.logic;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class ScoreTable extends JPanel {
	protected JTable scoreTable;
	protected JTable sumTable;
	protected JTable rankTable;
	private ListSelectionModel cellSelectionModel;
	private Rules regeln;


	public ScoreTable(Rules regeln) {
		this.regeln = regeln;

		ScoreTableModel tm = new ScoreTableModel();
		this.scoreTable = new JTable(tm);
		this.scoreTable.setCellSelectionEnabled(true);
		this.cellSelectionModel = scoreTable.getSelectionModel();
		this.cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		addSelectionListener();

		this.scoreTable.setFillsViewportHeight(true);

		// für was isch das??
		// this.scoreTable.setSelectionMode(1);

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

	public void addSelectionListener() {

		this.cellSelectionModel.addListSelectionListener(new ListSelectionListener() {



			@Override
			public void valueChanged(ListSelectionEvent e) {



				if(!e.getValueIsAdjusting()) {
					
					
				
				int selectedData = 0;

		        int sr = scoreTable.getSelectedRow();
		        int sc = scoreTable.getSelectedColumn();
				String selRule = scoreTable.getValueAt(sr,0 ).toString();
				boolean isLocked = (boolean) scoreTable.getValueAt(sr,3);
					System.out.println(isLocked + " " + sr + " " + sc);
				int punktzahl;
				switch (sc){
					case 0:
						punktzahl = regeln.einerResultat();
						break;
					case 1:
						punktzahl = regeln.zweierResultat();
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
						punktzahl= regeln.grosseStrasseResultat();
						break;
					case 10:
						punktzahl = regeln.yathzeeKniffelResultat();
						break;
					case 11:
						punktzahl = 999;
						break;
					default: punktzahl = 0;
					break;
				}
					System.out.println("Rules liefert " + punktzahl);

				if(isLocked != false) {
					scoreTable.setValueAt(punktzahl, sr, 1);

				}
				else {System.out.println(selRule + " ist gesperrt..");}


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
}
