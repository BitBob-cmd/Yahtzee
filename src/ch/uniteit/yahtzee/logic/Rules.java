package ch.uniteit.yahtzee.logic;

import java.util.ArrayList;

public class Rules {

	/**
	 * Diese Klasse ist für die Überprüfung der Regel zuständig
	 *
	 * @author Besnik Istrefi & Fernando Maniglio
	 * @version 1.0
	 *
	 */
	private static final long serialVersionUID = 1L;

	// Attribute für Resultate oben
	private int einerResultat;
	private int zweierResultat;
	private int dreierResultat;
	private int viererResultat;
	private int fuenferResultat;
	private int secherResultat;
	private int summeOben;

	// Attribute für Resultate unten

	private int dreierPaschResultat;
	private int viererPaschResultat;
	private int fullHouseResultat;
	private int kleineStrasseResultat;
	private int grosseStrasseResultat;

	private int yathzeeKniffelResultat;
	private boolean isYathzeeTwice;

	private int chanceResulat;
	private int summeUnten;

	// Attribut für Gesamtsumme und Bonus

	private int gesamtsumme;
	private int bonus;

	// Staticfield zu Testzwecke

	public Rules() {

		this.einerResultat = 0;
		this.zweierResultat = 0;
		this.dreierResultat = 0;
		this.viererResultat = 0;
		this.fuenferResultat = 0;
		this.secherResultat = 0;
		this.summeOben = 0;
		this.dreierPaschResultat = 0;
		this.viererPaschResultat = 0;
		this.fullHouseResultat = 0;
		this.kleineStrasseResultat = 0;
		this.grosseStrasseResultat = 0;
		this.yathzeeKniffelResultat = 0;
		this.isYathzeeTwice = false;
		this.gesamtsumme = 0;
		this.bonus = 0;
		this.chanceResulat = 0;
		this.summeUnten = 0;

	}

	// Prüft ob die ausgewählten Würfel 1ner sind.

	public int einerPruefung(ArrayList<Dices> dieWuerfel) {

		int[] x = new int[6];
		x[0] = 0;

		for (Dices d : dieWuerfel) {

			if (d.getRollScore() == 1) {

				x[0] += d.getRollScore();
			}
		}
		this.einerResultat = x[0];
		return x[0];

	}

	// Prüft ob die ausgewählten Würfel 2er sind.

	public int zweierPruefung(ArrayList<Dices> dieWuerfel) {

		int[] x = new int[6];
		x[1] = 0;

		for (Dices d : dieWuerfel) {

			if (d.getRollScore() == 2) {

				x[1] += d.getRollScore();
			}
		}
		this.zweierResultat = x[1];
		return this.zweierResultat;

	}

	// Prüft ob die ausgewählten Würfel 3er sind.

	public int dreierPruefung(ArrayList<Dices> dieWuerfel) {

		int[] x = new int[6];

		x[2] = 0;

		for (Dices d : dieWuerfel) {

			if (d.getRollScore() == 3) {

				x[2] += d.getRollScore();
			}
		}
		this.dreierResultat = x[2];
		return this.dreierPaschResultat;

	}

	// Prüft ob die ausgewählten Würfel 4er sind.

	public int viererPruefung(ArrayList<Dices> dieWuerfel) {

		int[] x = new int[6];

		x[3] = 0;

		for (Dices d : dieWuerfel) {

			if (d.getRollScore() == 4) {

				x[3] += d.getRollScore();
			}
		}
		this.viererResultat = x[3];
		return x[3];

	}

	// Prüft ob die ausgewählten Würfel 5er sind.

	public int fuenferPruefung(ArrayList<Dices> dieWuerfel) {

		int[] x = new int[6];

		x[4] = 0;

		for (Dices d : dieWuerfel) {

			if (d.getRollScore() == 5) {

				x[4] += d.getRollScore();
			}
		}
		this.fuenferResultat = x[4];
		return x[4];

	}

	// Prüft ob die ausgewählten Würfel 6er sind.

	public int sechserPruefung(ArrayList<Dices> dieWuerfel) {

		int[] x = new int[6];

		x[5] = 0;

		for (Dices d : dieWuerfel) {

			if (d.getRollScore() == 6) {

				x[5] += d.getRollScore();
			}
		}
		this.secherResultat = x[5];
		return x[5];

	}

	// Summe oben addiert alle Resultate von 1-6 und liefert das Resultat als
	// Integer zurück

	public int summeOben() {

		this.summeOben = einerResultat + zweierResultat + dreierResultat + viererResultat + fuenferResultat
				+ secherResultat;
		return summeOben;
	}

	// Summe unten addiert alle Resultate ab dreierpasch und liefert das Resultat
	// als Integer zurück

	public int summeUnten() {

		this.summeUnten = dreierPaschResultat + viererPaschResultat + fullHouseResultat + kleineStrasseResultat
				+ grosseStrasseResultat + yathzeeKniffelResultat + chanceResulat;
		bonus();
		return this.summeUnten;

	}

	// Methode für den Bonus falls die Summe aller Resultate von 1-6 grösser ist als
	// 63 returniert sie 35 Punkte Bonus;
	public int bonus() {

		if (this.summeOben >= 63) {

			this.bonus = 35;
			return 35;
		}
		return 0;
	}

	public int ruleCheck(String prüfe, ArrayList<Dices> dieWuerfel) {

		int[] dices = new int[7];

		for (Dices d : dieWuerfel) {

			int score = d.getRollScore();
			System.out.println(d.getRollScore());
			switch (score) {
			case 1:
				dices[0]++;
				break;
			case 2:
				dices[1]++;
				break;
			case 3:
				dices[2]++;
				break;
			case 4:
				dices[3]++;
				break;
			case 5:
				dices[4]++;
				break;
			case 6:
				dices[5]++;
			default:
				dices[6]++;
				break;

			}
		}
		// prüfe die verschiednen Spezialfälle sie equals String für ref.
		if (prüfe.equals("Dreierpasch")) {

			int temp1 = 0;
			int temp2 = 0;

			for (int counter = 0; counter < dices.length; counter++) {

				if (dices[counter] == 3) {

					temp1 = dices[counter] * 3;
				}
				if (dices[counter] != 3) {

					temp2 += dices[counter];
				}

			}

			this.dreierPaschResultat = temp1 + temp2;
			return this.dreierPaschResultat;
		}

		if (prüfe.equals("Vierpasch")) {

			int temp1 = 0;
			int temp2 = 0;

			for (int counter = 0; counter < dices.length; counter++) {

				if (dices[counter] == 4) {

					temp1 = dices[counter] * 4;
				}
				if (dices[counter] != 4) {

					temp2 += dices[counter];
				}

			}

			this.viererPaschResultat = temp1 + temp2;
			return this.viererPaschResultat;

		}

		boolean two = false;
		boolean three = false;

		if (prüfe.equals("FullHouse")) {
			for (int d : dices) {
				if (d == 2)
					two = true;
				if (d == 3)
					three = true;
			}
			if (two == true && three == true)
				return 25;
			else
				return 0;
		}
		int str = 0;
		if (prüfe.equals("KleineStrasse")) {
			for (int d : dices) {
				if (d != 0)
					str++;
			}
			if (str == 4)
				return 30;
			else
				return 0;
		}

		int str2 = 0;
		if (prüfe.equals("GrosseStrasse")) {
			for (int d : dices) {
				if (d != 0)
					str2++;
			}
			if (str2 == 5)
				return 40;
			else
				return 0;
		}

		if (prüfe.equals("Kniffel")) {
			int ref = dices[1];
			boolean chk = true;
			for (int d : dices) {
				if (d != ref)
					chk = false;
			}
			if (chk == true && isYathzeeTwice == false)
				return 50;

			this.isYathzeeTwice = true;

			if (chk == true && isYathzeeTwice == true) {

				return 150;
			}
			return 0;


		}

		if (prüfe.equals("Chance")) {

			// int c =// berechneTisch();

			// int c = 0;//berechneTisch();

			return 0;

		}

		return 0;
	}

}