/**
 * In dieser Klasse wird das Würfeln abgearbeitet
 * @autor: Fernando Maniglio
 * @autor: Besnik Istrefi
 * @version: 2018.01
 */
package ch.uniteit.yahtzee.logic;

import java.util.Objects;
import java.util.Random;

//TODO: Wenn fertig - Säubern aller kommentierten dingern
//TODO: Das ganze würfeln Logik
public class Dice {
	protected int score, wuerfelAnzahl, augen;
	protected Random rnd;

	/** Konstruktor: default,
	 * Initialisiert vorgegebene Wüfelanzahl und instanziert RandomClass
	 */
	public Dice() {
		this.score = 0;
		this.augen = 7;
		this.wuerfelAnzahl = 5;
		this.rnd = new Random();
	}
	/**
	 * Konstrukor: spezifisch,
	 * Mit diesem Konstruktor kann man die Anzahl der Würfel und wieviele Augen ein Würfel hat steuern, falls das
	 * jemand will.
	 *
	 * @param augen
	 * @param wuerfelAnzahl
	 */
	public Dice(int augen, int wuerfelAnzahl) {
		this.augen = augen++;
		this.wuerfelAnzahl = wuerfelAnzahl;
		this.rnd = new Random();
	}
	// Würfeln
	public int roll(){
		while(this.score == 0) this.score = rnd.nextInt(augen);
		//TODO: delete sysout
		System.out.println(this.score);
		return this.score;
	}
	// Gibt das Result des gewürfelten zurück
	public int getScore() {
		return score;
	}
	// Resultat des rolls setzen
	public void setScore(int score) {
		this.score = score;
	}
	// Gibt zurück mit wiviel Würfel gewürfelt werden
	public int getWuerfelAnzahl() {
		return wuerfelAnzahl;
	}
	// Setze die Anzahl Würfel
	public void setWuerfelAnzahl(int wuerfelAnzahl) {
		this.wuerfelAnzahl = wuerfelAnzahl;
	}
	// Gibt zürck wiviel Augen ein Würfel hat
	public int getAugen() {
		return augen;
	}
	// Setzt wiviel Augen ein Wüfel haben soll
	public void setAugen(int augen) {
		this.augen = augen;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Dice dice = (Dice) o;
		return score == dice.score &&
				wuerfelAnzahl == dice.wuerfelAnzahl &&
				augen == dice.augen &&
				Objects.equals(rnd, dice.rnd);
	}

	@Override
	public int hashCode() {

		return Objects.hash(score, wuerfelAnzahl, augen, rnd);
	}

	@Override
	public String toString() {
		return "Dice{" +
				"score=" + score +
				", wuerfelAnzahl=" + wuerfelAnzahl +
				", augen=" + augen +
				", rnd=" + rnd +
				'}';
	}
}
