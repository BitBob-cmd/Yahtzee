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

import java.util.ArrayList;


//TODO würfeln und befüllen und so
public class PlayTable {
	private int wuerfelAnzahl;
	private ArrayList<Dices> dieWuerfel;
	private int wuerfelScore;
	private int spielerZug; // hält den Spaltenindex des Spieler der gerade dran ist
	private Rules regeln;
	private GUI scoreTable;

	/**
	 * Konstruktor default.
	 * Setzt die Anzahl Würfel die im Spiel sind, und generiert diese in einem array..
	 */
	public PlayTable() {
		this.wuerfelAnzahl = 5;
		this.dieWuerfel = new ArrayList<>();
		this.spielerZug = 1;
		int i = 0;
		while (i <wuerfelAnzahl) {
			dieWuerfel.add(new Dices(i));
			i++;
		}
		this.regeln = new Rules();
		//this.scoreTable = new GUI();
	}

	/**
	 * Konstrukor custom
	 * Ermöglicht das Definieren der Anzahl Würfel die im Spiel sind..
	 *
	 * @param wuerfelAnzahl
	 */
	public PlayTable(int wuerfelAnzahl, int index) throws Exception {
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
			}
		}

	}

	// Rechnet alle Würfel zusammen
	public int berechneTisch() {
		for (Dices d : dieWuerfel) 
		
		{
	
		}
		return this.wuerfelScore;
	}


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

	public void setSpielerZug(int spielerZug) {
		this.spielerZug = spielerZug;
	}

	public static void main(String[] args) {
		new GUI(new ScoreTable());
	}
}
