/**
 * In dieser Klasse wird das Würfeln abgearbeitet
 * @autor: Fernando Maniglio
 * @autor: Besnik Istrefi
 * @version: 2018.01
 */
package ch.uniteit.yahtzee.backend;

import java.util.Random;

//TODO: Das ganze würfeln Logik
public class Dice {
	protected int score, augen, wuerfelAnzahl;
	protected Random rnd;

	/** Konstruktor default,
	 * Initialisiert vorgegebene Wüfelanzahl und instanziert RandomClass
	 */
	public Dice() {
		this.score = 0;
		this.augen = 6;
		this.wuerfelAnzahl = 5;
		this.rnd = new Random(augen);
	}

	/**
	 * Konstrukor spezisch,
	 * Mit diesem Konstruktor kann man die Anzahl der Würfel  und wieviele Augen ein Würfel hat steuern, falls das
	 * jemand will.
	 *
	 * @param augen
	 * @param wuerfelAnzahl
	 */
	public Dice(int augen, int wuerfelAnzahl) {
		this.augen = augen;
		this.wuerfelAnzahl = wuerfelAnzahl;
		this.rnd = new Random(augen);
	}

	public int diceIt(){
		this.score = rnd.nextInt();
		System.out.println(this.score);
		return this.score;
	}
}
