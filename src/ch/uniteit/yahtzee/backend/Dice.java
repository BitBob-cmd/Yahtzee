/**
 * In dieser Klasse wird das Würfeln abgearbeitet
 * @autor: Fernando Maniglio
 * @autor: Besnik Istrefi
 * @version: 2018.01
 */
package ch.uniteit.yahtzee.backend;

import java.util.Random;
import java.util.stream.IntStream;
//TODO: Wenn fertig - Säubern aller kommentierten dingern
//TODO: Das ganze würfeln Logik
public class Dice {
	protected int score, wuerfelAnzahl, augen;
	protected IntStream wuerfelGroesse;
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
	 * Konstrukor: spezisch,
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

	public int roll(){
		while(this.score == 0) this.score = rnd.nextInt(augen);
		//TODO: delete sysout
		System.out.println(this.score);
		return this.score;
	}
}
