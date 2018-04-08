/**
 * PlayTisch ist der Spieltisch im Backend/in der Logik.
 * Es wird gewürfelt mit allen Würfeln im Spiel im Bezug auf Klasse Dice, danach Resultat zusammengerechnen.
 * Vorbereiten für Übergabe an GUI.
 *
 * @autor Fernando Maniglio
 * @autor Besnik Istrefi
 * @version 2018.01
 */
package ch.uniteit.yahtzee.logic;


import ch.uniteit.yahtzee.gui.GUI;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import java.util.ArrayList;


//TODO würfeln und befüllen und so
public class PlayTable extends ScoreTable implements ListSelectionListener{
	private int wuerfelAnzahl;
	private ArrayList<Dices> dieWuerfel;
	private int wuerfelScore;
	private int spielerZug; // hält den Spaltenindex des Spieler der gerade dran ist
	private Rules regeln;
	private JTable tabelle;

	/**
	 * Konstruktor default.
	 * Setzt die Anzahl Würfel die im Spiel sind, und generiert diese in einem array..
	 */
	public PlayTable() {
		super(new Rules());
		this.wuerfelAnzahl = 5;
		this.dieWuerfel = new ArrayList<>();
		this.spielerZug = 1;
		int i = 0;
		while (i < wuerfelAnzahl) {
			dieWuerfel.add(new Dices(i));
			i++;
		}
		this.tabelle = scoreTable;
		this.regeln = rl;
		addSelectionListener();
	}

	/**
	 * Konstrukor custom
	 * Ermöglicht das Definieren der Anzahl Würfel die im Spiel sind..
	 *
	 * @param wuerfelAnzahl
	 */
	public PlayTable(int wuerfelAnzahl, int index) throws Exception {
		super(new Rules());

		if (wuerfelAnzahl <= 0) {
			//TODO GUI handling?
			String expStr = "Sie wollen ohne Würfel spielen? Like magic, haa? Leider nicht möglich.";
			throw new Exception(expStr);
		} else {
			this.wuerfelAnzahl = wuerfelAnzahl;
		}

		int i = 0;
		while (i <= wuerfelAnzahl) {
			dieWuerfel.add(new Dices(index));
			i++;
		}
	}

	// Würfeln, für jeden gespielten Würfel. Alle Würfel als ArrayList zurückliefert
	public ArrayList<Dices> gibWuerfel() {
		if (dieWuerfel != null) return dieWuerfel;
		else return null;
	}

	public void alleWuerfeln() {

		for (Dices d : dieWuerfel) {
			if (d.getOnHold() == false) {
				d.roll();
				d.repaint();
			}
		}

	}

	// Rechnet alle Würfel zusammen
	public void berechneTisch() {
		for (Dices d : dieWuerfel) {

			this.wuerfelScore = this.wuerfelScore + d.getRollScore();


		}

	}

	public void addSelectionListener() {


		this.cellSelectionModel.addListSelectionListener(this);
		
	}
			@Override
			public void valueChanged(ListSelectionEvent e) {
			
				if (!e.getValueIsAdjusting()) {
				//int sc = scoreTable.getSelected();
				//sc = scoreTable.getSelectedColumn(); //
				//String selRule = scoreTable.getValueAt(sr, 0).toString();
				//String isLocked;
				//isLocked = (scoreTable.getValueAt(sr, sc)).toString();
				//getSelectedColumn();
				//getSelectedRow();
				wertEinfuellenTabelle(tabelle.getSelectedRow());
				}
			}

	public void wertEinfuellenTabelle(int sr) {


		int punktzahl;

		switch (sr) {

			case 0:
				System.out.println("halloichbinderswitch");
				punktzahl = regeln.einerPruefung();

				scoreTable.setValueAt(new Boolean(true), 0, this.spielerZug+1);
				if (this.spielerZug == 1) spielerZug = 3;
				else if (this.spielerZug == 3) spielerZug = 1;
				GUI.resetCounterAnzahlWuerfel();
				System.out.println(this.spielerZug);

/*
				break;
			case 1:

				punktzahl = regeln.zweierPruefung();
				scoreTable.setValueAt(new Boolean(true), 1, this.spielerZug + 1);
				if (this.spielerZug == 1) setSpielerZug(3);
				else if (this.spielerZug == 3) setSpielerZug(1);
				GUI.resetCounterAnzahlWuerfel();
				System.out.println(this.spielerZug);


				break;
			case 2:

				punktzahl = dreierPruefung();
				scoreTable.setValueAt(new Boolean(true), 2, this.spielerZug + 1);
				if (this.spielerZug == 1) setSpielerZug(3);
				else if (this.spielerZug == 3) setSpielerZug(1);
				GUI.resetCounterAnzahlWuerfel();
				System.out.println(this.spielerZug);

				break;
			case 3:

				punktzahl = viererPruefung();
				scoreTable.setValueAt(new Boolean(true), 3, this.spielerZug + 1);
				if (this.spielerZug == 1) setSpielerZug(3);
				else if (this.spielerZug == 3) setSpielerZug(1);
				GUI.resetCounterAnzahlWuerfel();
				System.out.println(this.spielerZug);

				break;
			case 4:

				punktzahl = fuenferPruefung();
				scoreTable.setValueAt(new Boolean(true), 4, this.spielerZug + 1);
				if (this.spielerZug == 1) setSpielerZug(3);
				else if (this.spielerZug == 3) setSpielerZug(1);
				GUI.resetCounterAnzahlWuerfel();
				System.out.println(this.spielerZug);

				break;
			case 5:

				punktzahl = sechserPruefung();
				scoreTable.setValueAt(new Boolean(true), 5, this.spielerZug + 1);
				if (this.spielerZug == 1) setSpielerZug(3);
				else if (this.spielerZug == 3) setSpielerZug(1);
				GUI.resetCounterAnzahlWuerfel();
				System.out.println(this.spielerZug);

				break;
			case 6:
				punktzahl = ruleCheck("Dreierpasch");
				scoreTable.setValueAt(new Boolean(true), 6, this.spielerZug + 1);
				if (this.spielerZug == 1) setSpielerZug(3);
				else if (this.spielerZug == 3) setSpielerZug(1);
				GUI.resetCounterAnzahlWuerfel();
				System.out.println(this.spielerZug);
				break;
			case 7:
				punktzahl = ruleCheck("Vierpasch");
				scoreTable.setValueAt(new Boolean(true), 7, this.spielerZug + 1);
				if (this.spielerZug == 1) setSpielerZug(3);
				else if (this.spielerZug == 3) setSpielerZug(1);
				GUI.resetCounterAnzahlWuerfel();
				System.out.println(this.spielerZug);
				break;
			case 8:
				punktzahl = ruleCheck("FullHouse");
				scoreTable.setValueAt(new Boolean(true), 8, this.spielerZug + 1);
				if (this.spielerZug == 1) setSpielerZug(3);
				else if (this.spielerZug == 3) setSpielerZug(1);
				GUI.resetCounterAnzahlWuerfel();
				System.out.println(this.spielerZug);
				break;
			case 9:
				punktzahl = ruleCheck("KleineStrasse");
				scoreTable.setValueAt(new Boolean(true), 9, this.spielerZug + 1);
				if (this.spielerZug == 1) setSpielerZug(3);
				else if (this.spielerZug == 3) setSpielerZug(1);
				GUI.resetCounterAnzahlWuerfel();
				System.out.println(this.spielerZug);

				break;
			case 10:
				punktzahl = ruleCheck("GrosseStrasse");
				scoreTable.setValueAt(new Boolean(true), 10, this.spielerZug + 1);
				//if(this.spielerZug == 1) setSpielerZug(3);
				//else if(this.spielerZug == 3) setSpielerZug(1);
				GUI.resetCounterAnzahlWuerfel();
				System.out.println(this.spielerZug);
				break;
			case 11:
				punktzahl = ruleCheck("Kniffel");
				scoreTable.setValueAt(new Boolean(true), 11, this.spielerZug + 1);
				//if(this.spielerZug == 1) setSpielerZug(3);
				//else if(this.spielerZug == 3) setSpielerZug(1);
				GUI.resetCounterAnzahlWuerfel();
				System.out.println(this.spielerZug);
				break;

			case 12:
				punktzahl = ruleCheck("Chance");
				scoreTable.setValueAt(new Boolean(true), 12, this.spielerZug + 1);
				//if(this.spielerZug == 1) setSpielerZug(3);
				//else if(this.spielerZug == 3) setSpielerZug(1);
				GUI.resetCounterAnzahlWuerfel();
				System.out.println(this.spielerZug);
				break;
				*/
			default:
				punktzahl = 0;
				break;
		}

	}

		/*if(scoreTable.getSpielTisch().getSpielerZug() ==1) {


			scoreTable.getSpielTisch().gibScoreTable().setValueAt(bonus(), 0, 1);
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

	=======
		getSelectedColumn();
		getSelectedRow();






	}*/

	// commong methods and functions
	public int getWuerfelAnzahl() {
		return wuerfelAnzahl;
	}

	public void setWuerfelAnzahl(int wuerfelAnzahl) {
		this.wuerfelAnzahl = wuerfelAnzahl;
	}

	public int getWuerfelScore() {
		return wuerfelScore;
	}

	public void setWuerfelScore(int wuerfelScore) {
		this.wuerfelScore = wuerfelScore;
	}

	public int getSpielerZug() {
		return spielerZug;
	}

	public void setSpielerZug(int spieler) {
		this.spielerZug = spielerZug;
	}
}