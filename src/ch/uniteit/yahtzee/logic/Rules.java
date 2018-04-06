package ch.uniteit.yahtzee.logic;


public class Rules extends PlayTable {

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

	// Attribute counter für Dreier und Viererpasch

	private int counterWuerfelOnHoldDreierpasch;
	private int counterWuerfelOnHoldViererpasch;
	
	//Attribut für Gesamtsumme und Bonus
	
	private int gesamtsumme;
	private int bonus;

	//Staticfield zu Testzwecke
	
	
	
	public Rules(){


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
		this.counterWuerfelOnHoldDreierpasch = 0;
		this.counterWuerfelOnHoldViererpasch = 0;

	}

	

	// Prüft ob die ausgewählten Würfel 1ner sind.

	public boolean einerPruefung() {

		boolean x = false;

		for (Dices d : gibWuerfel()) {
			
			if (d.getRollScore() == 1 && d.getOnHold() == true) {

				x = true;
			}

		}
		return x;
	}

	// Liefert die Summer aller aktiven Würfel zurück nach der Prüfung.

	public int einerResultat() {

		this.einerResultat = 0;

		if (einerPruefung() == true) {

			for (Dices d : gibWuerfel()) {

				if (d.getOnHold() == true) {

					this.einerResultat += d.getRollScore();
				}
			}
		}
		return this.einerResultat;
	}

	// Prüft ob die ausgewählten Würfel 2er sind.

	public boolean zweierPruefung() {

		boolean x = false;

		for (Dices d : gibWuerfel()) {

			if (d.getRollScore() == 2 && d.getOnHold() == true) {

				x = true;
			}

		}
		return x;
	}

	// Liefert die Summer aller aktiven Würfel zurück nach der Prüfung.

	public int zweierResultat() {

		this.zweierResultat = 0;

		if (zweierPruefung() == true) {

			for (Dices d : gibWuerfel()) {

				if (d.getOnHold() == true) {

					this.zweierResultat += d.getRollScore();
				}
			}
		}
		return this.zweierResultat;
	}

	// Prüft ob die ausgewählten Würfel 3er sind.

	public boolean dreierPruefung() {

		boolean x = false;

		for (Dices d : gibWuerfel()) {

			if (d.getRollScore() == 3 && d.getOnHold() == true) {

				x = true;
			}

		}
		return x;
	}

	// Liefert die Summer aller aktiven Würfel zurück nach der Prüfung.

	public int dreierResultat() {

		this.dreierResultat = 0;

		if (dreierPruefung() == true) {

			for (Dices d : gibWuerfel()) {

				if (d.getOnHold() == true) {

					this.dreierResultat += d.getRollScore();
				}
			}
		}
		return this.dreierResultat;
	}

	// Prüft ob die ausgewählten Würfel 4er sind.

	public boolean viererPruefung() {

		boolean x = false;

		for (Dices d : gibWuerfel()) {

			if (d.getRollScore() == 4 && d.getOnHold() == true) {

				x = true;
			}

		}
		return x;
	}

	// Liefert die Summer aller aktiven Würfel zurück nach der Prüfung.

	public int viererResultat() {

		this.viererResultat = 0;

		if (viererPruefung() == true) {

			for (Dices d : gibWuerfel()) {

				if (d.getOnHold() == true) {

					this.viererResultat += d.getRollScore();
				}
			}
		}
		return this.viererResultat;
	}

	// Prüft ob die ausgewählten Würfel 5er sind.

	public boolean fuenferPruefung() {

		boolean x = false;

		for (Dices d : gibWuerfel()) {

			if (d.getRollScore() == 5 && d.getOnHold() == true) {

				x = true;
			}

		}
		return x;
	}

	// Liefert die Summer aller aktiven Würfel zurück nach der Prüfung.

	public int fuenferResultat() {

		this.fuenferResultat = 0;

		if (fuenferPruefung() == true) {

			for (Dices d : gibWuerfel()) {

				if (d.getOnHold() == true) {

					this.fuenferResultat += d.getRollScore();
				}
			}
		}
		return this.fuenferResultat;
	}

	// Prüft ob die ausgewählten Würfel 6er sind.

	public boolean sechserPruefung() {

		boolean x = false;

		for (Dices d : gibWuerfel()) {

			if (d.getRollScore() == 6 && d.getOnHold() == true) {

				x = true;
			}

		}
		return x;
	}

	// Liefert die Summer aller aktiven Würfel zurück nach der Prüfung.

	public int sechserResultat() {

		this.secherResultat = 0;

		if (sechserPruefung() == true) {

			for (Dices d : gibWuerfel()) {

				if (d.getOnHold() == true) {

					this.secherResultat += d.getRollScore();
				}
			}
		}
		return this.secherResultat;
	}

	// Summe oben addiert alle Resultate von 1-6 und liefert das Resultat als
	// Integer zurück

	public int summeOben() {

		this.summeOben = einerResultat + zweierResultat + dreierResultat + viererResultat + fuenferResultat
				+ secherResultat;
		return summeOben;
	}
	
	// Summe unten addiert alle Resultate ab dreierpasch und liefert das Resultat als Integer zurück
	
	public int summeUnten() {
		
		this.summeUnten = dreierPaschResultat+viererPaschResultat+fullHouseResultat+kleineStrasseResultat+grosseStrasseResultat+
				yathzeeKniffelResultat+chanceResulat;
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

	// Prüft ob es sich um ein Dreierpasch handelt.

	public boolean dreierPaschPruefung() {

		boolean x = false;

		for (Dices d : gibWuerfel()) {

			int tempScore;

			if (d.getOnHold() == true) {
				counterWuerfelOnHoldDreierpasch++;
				tempScore = d.getRollScore();

				if (counterWuerfelOnHoldDreierpasch == 3 && d.getRollScore() == tempScore) {

					x = true;
				}

			}

		}
		return x;
	}

	// Liefert das Resultat des DreierPaschs

	public int resultatdreierPasch() {

		int resultat = 0;

		if (dreierPaschPruefung() == true) {

			for (Dices d : gibWuerfel()) {

				if (d.getOnHold() == true) {

					this.dreierPaschResultat = resultat + d.getRollScore();
				}
			}
		}
		return this.dreierPaschResultat;
	}

	// Prüft ob es sich um ein Viererpasch handelt.

	public boolean viererPaschPruefung() {

		boolean x = false;

		for (Dices d : gibWuerfel()) {

			int tempScore;

			if (d.getOnHold() == true) {
				counterWuerfelOnHoldViererpasch++;
				tempScore = d.getRollScore();

				if (counterWuerfelOnHoldViererpasch == 4 && d.getRollScore() == tempScore) {

					x = true;
				}

			}

		}
		return x;
	}

	// Liefert das Resultat des Viererpaschs

	public int resultatViererPasch() {

		int resultat = 0;

		if (viererPaschPruefung() == true) {

			for (Dices d : gibWuerfel()) {

				if (d.getOnHold() == true) {

					this.viererPaschResultat = resultat + d.getRollScore();
				}
			}
		}
		return this.viererPaschResultat;
	}

	// Prüft ob es sich um ein Full House handelt

	public boolean fullHousePruefung() {

		boolean x = false;

		int[] temp = new int[6];

		for (Dices d : gibWuerfel()) {

			if (d.getOnHold() == true) {
				int s = d.getRollScore();

				temp[s]++;

			}

		}

		boolean zweier = false;
		boolean dreier = false;

		for (int i : temp) {

			if (i == 2) {
				zweier = true;
			}

			if (i == 3) {

				dreier = true;
			}

		}

		if (zweier == true && dreier == true) {

			x = true;
		}

		return x;
	}

	// Liefert das Resultat des Fullhouses

	public int fullhouseResultat() {

		if (fullHousePruefung() == true) {

			this.fullHouseResultat = 25;
		}

		return this.fullHouseResultat;
	}

	// Prüft ob es sich um eine Kleine Strasse handelt

	public boolean kleineStrassePruefung() {

		boolean x = false;

		int[] temp = new int[6];

		for (Dices d : gibWuerfel()) {

			if (d.getOnHold() == true) {
				int s = d.getRollScore();

				temp[s]++;

			}

		}

		boolean einer = false;
		boolean zweier = false;
		boolean dreier = false;
		boolean vierer = false;
		boolean fuenfer = false;
		boolean sechser = false;

		for (int i : temp) {

			if (i == 1 && i == 2 && i == 3 && i == 4) {

				einer = true;
				zweier = true;
				dreier = true;
				vierer = true;

			}
			if (i == 2 && i == 3 && i == 4 && i == 5) {

				zweier = true;
				dreier = true;
				vierer = true;
				fuenfer = true;

			}

			if (i == 3 && i == 4 && i == 5 && i == 6) {

				dreier = true;
				vierer = true;
				fuenfer = true;
				sechser = true;
			}

		}
		if (einer == true && zweier == true && dreier == true && vierer == true
				|| zweier == true && dreier == true && vierer == true && fuenfer == true
				|| dreier == true && vierer == true && fuenfer == true && sechser == true) {

			x = true;
		}

		return x;
	}

	// Liefert das Resultat des Fullhouses

	public int kleineStrasseResultat() {

		if (kleineStrassePruefung() == true) {

			this.kleineStrasseResultat = 30;
		}

		return this.kleineStrasseResultat;
	}

	// Prüft ob es sich um eine Grosse Strasse handelt

	public boolean grosseStrassePruefung() {

		boolean x = false;

		int[] temp = new int[6];

		for (Dices d : gibWuerfel()) {

			if (d.getOnHold() == true) {
				int s = d.getRollScore();

				temp[s]++;

			}

		}

		boolean einer = false;
		boolean zweier = false;
		boolean dreier = false;
		boolean vierer = false;
		boolean fuenfer = false;
		boolean sechser = false;

		for (int i : temp) {

			if (i == 1 && i == 2 && i == 3 && i == 4 && i == 5) {

				einer = true;
				zweier = true;
				dreier = true;
				vierer = true;
				fuenfer = true;

			}
			if (i == 2 && i == 3 && i == 4 && i == 5 && i == 6) {

				zweier = true;
				dreier = true;
				vierer = true;
				fuenfer = true;
				sechser = true;

			}

		}
		if (einer == true && zweier == true && dreier == true && vierer == true && fuenfer == true
				|| zweier == true && dreier == true && vierer == true && fuenfer == true && sechser == true) {

			x = true;
		}

		return x;
	}

	// Liefert das Resultat der grossen Strasse

	public int grosseStrasseResultat() {

		if (grosseStrassePruefung() == true) {

			this.grosseStrasseResultat = 40;
		}

		return this.grosseStrasseResultat;
	}

	// Prüft ob es sich um ein Yathzee/Kniffel handelt
	
	public boolean yathzeeKniffelPruefung() {

		boolean x = true;
		int tempDice = gibWuerfel().get(0).getRollScore();
		
		for (Dices d : gibWuerfel()) {
			
			if (d.getOnHold() == true) {
				
				if (d.getRollScore() != tempDice) {

					x = false;
				}

			}

		}
		return x;
	}

	// Liefert das Resultat des Yathzee/Kniffel
	
	public int yathzeeKniffelResultat() {
		
		 if(yathzeeKniffelPruefung() == true && isYathzeeTwice == false) {
			 
			 this.isYathzeeTwice = true;
			 this.yathzeeKniffelResultat = 50;
		 }
		
		 else {
			 
			 this.yathzeeKniffelResultat = yathzeeKniffelResultat+100;
		 }
		 
		 return this.yathzeeKniffelResultat;
	}
	
	// Liefert das Resultat der Chance

	public int resultatChance() {

		int resultat = 0;

		for (Dices d : gibWuerfel()) {

			this.chanceResulat = resultat + d.getRollScore();

		}
		return this.chanceResulat;
	}
	
	// Liefert die gesamtsumme Oben Bonus und Unten als Integer zurück
	
	public int gesamtsumme() {
		
		this.gesamtsumme = summeOben+summeUnten+bonus;
		return this.gesamtsumme;
	}
	
	

}
