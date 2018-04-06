package ch.uniteit.yahtzee.logic;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;
import java.awt.*;
/*
 * Diese Klasse ist für das Auswerten und einfüllen der Tabelle zuständig
 */

public class ScoreTable extends Rules {

	protected JTable scoreTable;
	protected JTable sumTable;
	protected JTable rankTable;
	private ListSelectionModel cellSelectionModel;


	public ScoreTable() {

		ScoreTableModel tm = new ScoreTableModel();
		this.scoreTable = new JTable(tm);
		this.scoreTable.setCellSelectionEnabled(true);
		this.cellSelectionModel = scoreTable.getSelectionModel();
		this.cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		addSelectionListener();

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

	public void addSelectionListener() {

		this.cellSelectionModel.addListSelectionListener(new ListSelectionListener() {


			@Override
			public void valueChanged(ListSelectionEvent e) {

				if (!e.getValueIsAdjusting()) {

					int sr = scoreTable.getSelectedRow();
					//int sc = scoreTable.getSelectedColumn();
					int sc = getSpielerZug(); //
					String selRule = scoreTable.getValueAt(sr, 0).toString();
					String isLocked;
					if(getSpielerZug() == 2) {isLocked = (scoreTable.getValueAt(sr, 1)).toString();}
					else {isLocked = (scoreTable.getValueAt(sr, 4)).toString();}



					//TODO entfernen ist nur für tests
					System.out.println(isLocked + " " + sr + " " + sc + " " + selRule);
					int punktzahl;
					//einerPruefung();
					switch (sr) {
						case 0:
							punktzahl = einerResultat();
							break;
						case 1:
							punktzahl = zweierResultat();
							break;
						case 2:
							punktzahl = dreierResultat();
							break;
						case 3:
							punktzahl = viererResultat();
							break;
						case 4:
							punktzahl = fuenferResultat();
							break;
						case 5:
							punktzahl = sechserResultat();
							break;
						case 6:
							punktzahl = resultatViererPasch();
							break;
						case 7:
							punktzahl = fullhouseResultat();
							break;
						case 8:
							punktzahl = kleineStrasseResultat();
							break;
						case 9:
							punktzahl = grosseStrasseResultat();
							break;
						case 10:
							punktzahl = yathzeeKniffelResultat();
							break;
						case 11:
							punktzahl = resultatChance();
							break;
						default:
							punktzahl = 0;
							break;
					}
					System.out.println("Rules liefert " + punktzahl);
					scoreTable.setValueAt(punktzahl, sr, sc);

					if (isLocked.equals("false")) {
						scoreTable.setValueAt(punktzahl, sr, sc);
						//scoreTable.setValueAt(new Boolean(true), getSpielerZug(), sc);

					} else {
						System.out.println(selRule + " ist gesperrt..");
					}

					setSpielerZug(3);
				}

			}
		});

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
	public void neuesSpiel(){
		int numRows = scoreTable.getRowCount()-1;
		int numCols = scoreTable.getColumnCount()-1;
		System.out.println(numRows);
		while(numRows >= 0){
			scoreTable.setValueAt(0, numRows, 1);
			scoreTable.setValueAt(new Boolean(false), numRows, 2);
			scoreTable.setValueAt(0, numRows, 3);
			scoreTable.setValueAt(new Boolean(false), numRows, 4);
			numRows--;
		}
	}
}
