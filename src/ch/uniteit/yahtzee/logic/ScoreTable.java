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
	private Rules regeln;


	public ScoreTable() {

		//this.regeln = regeln;

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

				if (!e.getValueIsAdjusting()) {

					int sr = scoreTable.getSelectedRow();
					int sc = scoreTable.getSelectedColumn();
					String selRule = scoreTable.getValueAt(sr, 0).toString();
					String isLocked = (scoreTable.getValueAt(sr, 3)).toString();
					//TODO entfernen ist nur für tests
					System.out.println(isLocked + " " + sr + " " + sc + " " + selRule);
					int punktzahl;
					switch (sc) {
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


					if (isLocked.equals("false")) {
						// es tuet
						scoreTable.setValueAt(punktzahl, sr, sc);

					} else {
						System.out.println(selRule + " ist gesperrt..");
					}


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
}
