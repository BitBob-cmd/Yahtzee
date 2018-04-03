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

import java.util.ArrayList;

//TODO würfeln und befüllen und so
public class PlayTable {
	protected int wuerfelAnzahl;
	protected ArrayList<Dice> dieWuerfel;
	protected int wuerfelScore;
	/**
	 * Konstruktor default.
	 * Setzt die Anzahl Würfel die im Spiel sind, und generiert diese in einem array..
	 */
	public PlayTable() {
		this.wuerfelAnzahl = 5;
		this.dieWuerfel = new ArrayList<>();
		//TODO prüfen ob 0 oder 1 richtig ist
		int i = 0;
		while(i <= wuerfelAnzahl){
			dieWuerfel.add(new Dice());
			i++;
		}
	}

	/**
	 * Konstrukor custom
	 * Ermöglicht das Definieren der Anzahl Würfel die im Spiel sind..
	 * @param wuerfelAnzahl
	 */
	public PlayTable(int wuerfelAnzahl) throws Exception {
		if(wuerfelAnzahl <= 0){
			throw new Exception("Sie wollen ohne Würfel spielen? Like magic, haa? Leider nicht möglich.");
		}
		else {	this.wuerfelAnzahl = wuerfelAnzahl; }
	}
	// Würfeln, für jeden gespielten Würfel einmal würfeln
	public void wuerfeln () {
		for(Dice d: dieWuerfel) d.roll();
		this.berechneTisch();
	}
	// Rechnet alle Würfel zusammen
	public void berechneTisch(){
		for(Dice d: dieWuerfel){
			this.wuerfelScore = this.wuerfelScore + d.getRollScore();
		}
		System.out.println("Ergebnis ist " + this.wuerfelScore);
	}
}
