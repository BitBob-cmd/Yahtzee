/**
 * In dieser Klasse wird das Würfeln abgearbeitet
 * @autor: Fernando Maniglio
 * @autor: Besnik Istrefi
 * @version: 2018.01
 */
package ch.uniteit.yahtzee.logic;

import java.util.Objects;
import java.util.Random;

//TODO: Wenn fertig - Säubern aller auskommentierten dingers
//TODO: Das ganze würfeln Logik
public class Dice {
	protected int rollScore, augen;
	protected Random rnd;

	/**
	 * Konstruktor: default,
	 * Initialisiert vorgegebene Wüfelanzahl und instanziert RandomClass
	 */
	public Dice() {
		this.rollScore = 0;
		this.augen = 7;
		this.rnd = new Random();
	}
	/**
	 * Konstrukor: custom,
	 * Mit diesem Konstruktor kann man stuern wieviele Augen ein Würfel hat, falls das jemand möchte.
	 *
	 * @param augen definiere wiviel Augen ein Würfel hat
	 */
	public Dice(int augen) {
		this.augen = augen++;
		this.rnd = new Random();
	}

	// Würfeln
	public int roll(){
		while(this.rollScore == 0) this.rollScore = rnd.nextInt(augen);
		return this.rollScore;
	}
	// Gibt das Result des gewürfelten zurück
	public int getRollScore() {
		return rollScore;
	}
	// Resultat des rolls setzen
	public void setRollScore(int rollScore) {
		this.rollScore = rollScore;
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
		if (!(o instanceof Dice)) return false;
		Dice dice = (Dice) o;
		return getRollScore() == dice.getRollScore() &&
				getAugen() == dice.getAugen() &&
				Objects.equals(rnd, dice.rnd);
	}

	@Override
	public int hashCode() {

		return Objects.hash(getRollScore(), getAugen(), rnd);
	}

	@Override
	public String toString() {
		return "Dice{" +
				"rollScore=" + rollScore +
				", augen=" + augen +
				", rnd=" + rnd +
				'}';
	}
}
