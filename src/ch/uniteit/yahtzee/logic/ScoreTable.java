package ch.uniteit.yahtzee.logic;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;

import com.sun.nio.file.SensitivityWatchEventModifier;

import ch.uniteit.yahtzee.gui.GUI;

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
					int sc = scoreTable.getSelectedColumn(); //
					//String selRule = scoreTable.getValueAt(sr, 0).toString();
					//String isLocked;
					//isLocked = (scoreTable.getValueAt(sr, sc)).toString();

					//TODO entfernen ist nur für tests
					//System.out.println(isLocked + " " + sr + " " + sc + " " + selRule);

					//System.out.println(isLocked + " " + sr + " " + sc + " " + selRule);
					int punktzahl;

					switch (sr) {
						case 0:
							
							punktzahl = einerPruefung();
							scoreTable.setValueAt(new Boolean(true), 0, getSpielerZug()+1);
							if(getSpielerZug() == 1) setSpielerZug(3);
							else if(getSpielerZug() == 3) setSpielerZug(1);
							GUI.resetCounterAnzahlWuerfel();
							System.out.println(getSpielerZug());

							break;
						case 1:

							punktzahl = zweierPruefung();
							scoreTable.setValueAt(new Boolean(true), 1, getSpielerZug()+1);
							if(getSpielerZug() == 1) setSpielerZug(3);
							else if(getSpielerZug() == 3) setSpielerZug(1);
							GUI.resetCounterAnzahlWuerfel();
							System.out.println(getSpielerZug());
							

							break;
						case 2:

							punktzahl = dreierPruefung();
							scoreTable.setValueAt(new Boolean(true), 2, getSpielerZug()+1);
							if(getSpielerZug() == 1) setSpielerZug(3);
							else if(getSpielerZug() == 3) setSpielerZug(1);
							GUI.resetCounterAnzahlWuerfel();
							System.out.println(getSpielerZug());

							break;
						case 3:

							punktzahl = viererPruefung();
							scoreTable.setValueAt(new Boolean(true), 3, getSpielerZug()+1);
							if(getSpielerZug() == 1) setSpielerZug(3);
							else if(getSpielerZug() == 3) setSpielerZug(1);
							GUI.resetCounterAnzahlWuerfel();
							System.out.println(getSpielerZug());

							break;
						case 4:

							punktzahl = fuenferPruefung();
							scoreTable.setValueAt(new Boolean(true), 4, getSpielerZug()+1);
							if(getSpielerZug() == 1) setSpielerZug(3);
							else if(getSpielerZug() == 3) setSpielerZug(1);
							GUI.resetCounterAnzahlWuerfel();
							System.out.println(getSpielerZug());

							break;
						case 5:

							punktzahl = sechserPruefung();
							scoreTable.setValueAt(new Boolean(true), 5, getSpielerZug()+1);
							if(getSpielerZug() == 1) setSpielerZug(3);
							else if(getSpielerZug() == 3) setSpielerZug(1);
							GUI.resetCounterAnzahlWuerfel();
							System.out.println(getSpielerZug());

							break;
						case 6:
							punktzahl = ruleCheck("Dreierpasch");
							scoreTable.setValueAt(new Boolean(true), 6, getSpielerZug()+1);
							if(getSpielerZug() == 1) setSpielerZug(3);
							else if(getSpielerZug() == 3) setSpielerZug(1);
							GUI.resetCounterAnzahlWuerfel();
							System.out.println(getSpielerZug());
							break;
						case 7:
							punktzahl = ruleCheck("Vierpasch");
							scoreTable.setValueAt(new Boolean(true), 7, getSpielerZug()+1);
							if(getSpielerZug() == 1) setSpielerZug(3);
							else if(getSpielerZug() == 3) setSpielerZug(1);
							GUI.resetCounterAnzahlWuerfel();
							System.out.println(getSpielerZug());
							break;
						case 8:
							punktzahl = ruleCheck("FullHouse");
							scoreTable.setValueAt(new Boolean(true), 8, getSpielerZug()+1);
							if(getSpielerZug() == 1) setSpielerZug(3);
							else if(getSpielerZug() == 3) setSpielerZug(1);
							GUI.resetCounterAnzahlWuerfel();
							System.out.println(getSpielerZug());
							break;
						case 9:
							punktzahl = ruleCheck("KleineStrasse");
							scoreTable.setValueAt(new Boolean(true), 9, getSpielerZug()+1);
							if(getSpielerZug() == 1) setSpielerZug(3);
							else if(getSpielerZug() == 3) setSpielerZug(1);
							GUI.resetCounterAnzahlWuerfel();
							System.out.println(getSpielerZug());

							break;
						case 10:
							punktzahl = ruleCheck("GrosseStrasse");
							scoreTable.setValueAt(new Boolean(true), 10, getSpielerZug()+1);
							//if(getSpielerZug() == 1) setSpielerZug(3);
							//else if(getSpielerZug() == 3) setSpielerZug(1);
							GUI.resetCounterAnzahlWuerfel();
							System.out.println(getSpielerZug());
							break;
						case 11:
							punktzahl = ruleCheck("Kniffel");
							scoreTable.setValueAt(new Boolean(true), 11, getSpielerZug()+1);
							//if(getSpielerZug() == 1) setSpielerZug(3);
							//else if(getSpielerZug() == 3) setSpielerZug(1);
							GUI.resetCounterAnzahlWuerfel();
							System.out.println(getSpielerZug());
							break;
							
						case 12:
							punktzahl =	ruleCheck("Chance");
							scoreTable.setValueAt(new Boolean(true), 12, getSpielerZug()+1);
							//if(getSpielerZug() == 1) setSpielerZug(3);
							//else if(getSpielerZug() == 3) setSpielerZug(1);
							GUI.resetCounterAnzahlWuerfel();
							System.out.println(getSpielerZug());
							break;
						default:
							punktzahl = 0;
							break;
					}
					
				
					
					if(getSpielerZug() ==1) {
						
						
						sumTable.setValueAt(bonus(), 0, 1);
						sumTable.setValueAt(summeOben(), 1, 1);
						sumTable.setValueAt(summeUnten(), 1, 2);
						
					
						
					}
					else {
						sumTable.setValueAt(bonus(), 1, 1);
						sumTable.setValueAt(summeOben(), 1, 2);
						sumTable.setValueAt(summeUnten(), 1, 3);
					}

					System.out.println("Rules liefert " + punktzahl);
					
					
					if(sc != 0) {
						scoreTable.setValueAt(punktzahl, sr, sc);
					}
					
					String isLocked = (scoreTable.getValueAt(sr, getSpielerZug()).toString());
					String selRule = (scoreTable.getValueAt(sr, 0)).toString();
					if (isLocked.equals("false")) {
						scoreTable.setValueAt(punktzahl, sr, sc);
						//scoreTable.setValueAt(new Boolean(true), getSpielerZug(), sc);

					} else {
						System.out.println(selRule + " ist gesperrt..");
					}

					//if(getSpielerZug() == 1) setSpielerZug(3);
					//else if(getSpielerZug() == 3) setSpielerZug(1);
					
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

