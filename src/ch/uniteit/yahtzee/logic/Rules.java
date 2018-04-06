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

	public int einerPruefung() {

		int[] x = new int[6];
		x[0] = 0;

		for (Dices d : gibWuerfel()){

			if(d.getRollScore() == 1) {

				x[0] += d.getRollScore();
			}
		}
		this.einerResultat = x[0];
		return x[0];

	}




	// Prüft ob die ausgewählten Würfel 2er sind.

	public int zweierPruefung() {

		int[] x = new int[6];
		x[1] = 0;

		for (Dices d : gibWuerfel()){

			if(d.getRollScore() == 2) {

				x[1] += d.getRollScore();
			}
		}
		this.zweierResultat = x[1];
		return x[1];

	}



	// Prüft ob die ausgewählten Würfel 3er sind.

	public int dreierPruefung() {

		int[] x = new int[6];

		x[2] = 0;

		for (Dices d : gibWuerfel()){

			if(d.getRollScore() == 3) {

				x[2] += d.getRollScore();
			}
		}
		this.dreierResultat = x[2];
		return x[2];

	}


	// Prüft ob die ausgewählten Würfel 4er sind.

	public int viererPruefung() {

		int[] x = new int[6];

		x[3] = 0;

		for (Dices d : gibWuerfel()){

			if(d.getRollScore() == 4) {

				x[3] += d.getRollScore();
			}
		}
		this.viererResultat = x[3];
		return x[3];

	}

	// Prüft ob die ausgewählten Würfel 5er sind.

	public int fuenferPruefung() {

		int[] x = new int[6];

		x[4] = 0;
		for (Dices d : gibWuerfel()){

			if(d.getRollScore() == 5) {

				x[4] += d.getRollScore();
			}
		}
		this.fuenferResultat = x[4];
		return x[4];

	}

	// Prüft ob die ausgewählten Würfel 6er sind.

	public int sechserPruefung() {

		int[] x = new int[6];

		x[5] = 0;

		for (Dices d : gibWuerfel()){

			if(d.getRollScore() == 6) {

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


	public int ruleCheck(String prüfe){

		int[] dices = new int[7];
		for(Dices d: gibWuerfel()){
			int score = d.getRollScore();
			switch (score){
				case 1:
					dices[1] = dices[1]++;
					break;
				case 2:
					dices[2] = dices[2]++;
					break;
				case 3:
					dices[3] = dices[3]++;
					break;
				case 4:
					dices[4] = dices[4]++;
					break;
				case 5:
					dices[5] = dices[5]++;
					break;
				case 6:
					dices[6] = dices[6]++;
				default:
					dices[0] = 0;
					break;
			}
		}
		// prüfe die verschiednen Spezialfälle sie equals String für ref.
		if(prüfe.equals("Dreierpasch")){
			if(dices[3] == 3) return 3*3;
			return 0;
		}
		if(prüfe.equals("Vierpasch")){
			if(dices[4] ==4) return 4*4;
			return 0;
		}
		boolean two = false;
		boolean three = false;
		if(prüfe.equals("FullHouse")){
			for(int d: dices){
				if(d == 2) two = true;
				if(d == 3) three = true;
			}
			if(two == true && three == true) return 25;
			else return 0;
		}
		int str = 0;
		if(prüfe.equals("KleineStrasse")){
			for(int d: dices) {
				if(d != 0) str++;
			}
			if(str == 4) return 30;
			else return 0;
		}

		int str5 = 0;
		if(prüfe.equals("GrosseStrasse")){
			for(int d: dices) {
				if(d != 0) str++;
			}
			if(str == 5) return 40;
			else return 0;
		}

		if(prüfe.equals("Kniffel")){
			int ref = dices[1];
			boolean chk = true;
			for(int d: dices){
				if(d != ref) chk = false;
			}
			if(chk == true) return 50;
			else return 0;
		}

		if(prüfe.equals("Chance")){
			int c = 0;
			for(int d: dices){
				c += d;
			}
			return c;
		}
		return 0;
	}

}
