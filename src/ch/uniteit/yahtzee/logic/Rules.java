package ch.uniteit.yahtzee.logic;

import ch.uniteit.yahtzee.gui.GUI;

public class Rules extends GUI {

	/**
	 * Diese Klasse ist für die Überprüfung der Regel zuständig
	 * 
	 * @author Besnik Istrefi & Fernando Maniglio
	 * @version 1.0
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int einerResultat;
	private int zweierResultat;
	private int dreierResultat;
	private int viererResultat;
	private int fuenferResultat;
	private int secherResultat;
	private int summeOben;
	

	public Rules() throws Exception{

		
		this.einerResultat = 0;
		this.zweierResultat = 0;
		this.dreierResultat = 0;
		this.viererResultat = 0;
		this.fuenferResultat = 0;
		this.secherResultat = 0;
		this.summeOben = 0 ;
		
	}
	
	// Prüft ob die ausgewählten Würfel 1ner sind.
	
	public boolean einerPruefung() {

		boolean x = false;

		for (Dices d : getSpielTisch().gibWuerfel()) {

			if (d.getRollScore() == 1 && d.getOnHold() == true) {

				x = true;
			}

		}
		return x;
	}
	
	// Liefert die Summer aller aktiven Würfel zurück nach der Prüfung.
	
	public int einerResultat() {

		int resultat = 0;

		if (einerPruefung() == true) {

			for (Dices d : getSpielTisch().gibWuerfel()) {

				if (d.getOnHold() == true) {

					this.einerResultat = resultat + d.getRollScore();
				}
			}
		}
		return this.einerResultat;
	}

	// Prüft ob die ausgewählten Würfel 2er sind.
	
	public boolean zweierPruefung() {

		boolean x = false;

		for (Dices d : getSpielTisch().gibWuerfel()) {

			if (d.getRollScore() == 2 && d.getOnHold() == true) {

				x = true;
			}

		}
		return x;
	}

	// Liefert die Summer aller aktiven Würfel zurück nach der Prüfung.
	
	public int zweierResultat() {

		int resultat = 0;

		if (zweierPruefung() == true) {

			for (Dices d : getSpielTisch().gibWuerfel()) {

				if (d.getOnHold() == true) {

					this.zweierResultat = resultat + d.getRollScore();
				}
			}
		}
		return this.zweierResultat;
	}
	
	// Prüft ob die ausgewählten Würfel 3er sind.
	
	public boolean dreierPruefung() {

		boolean x = false;

		for (Dices d : getSpielTisch().gibWuerfel()) {

			if (d.getRollScore() == 3 && d.getOnHold() == true) {

				x = true;
			}

		}
		return x;
	}

	// Liefert die Summer aller aktiven Würfel zurück nach der Prüfung.
	
	public int dreierResultat() {

		int resultat = 0;

		if (dreierPruefung() == true) {

			for (Dices d : getSpielTisch().gibWuerfel()) {

				if (d.getOnHold() == true) {

					this.dreierResultat = resultat + d.getRollScore();
				}
			}
		}
		return this.dreierResultat;
	}
	
	// Prüft ob die ausgewählten Würfel 4er sind.
	
	public boolean viererPruefung() {

		boolean x = false;

		for (Dices d : getSpielTisch().gibWuerfel()) {

			if (d.getRollScore() == 4 && d.getOnHold() == true) {

				x = true;
			}

		}
		return x;
	}

	// Liefert die Summer aller aktiven Würfel zurück nach der Prüfung.
	
	public int viererResultat() {

		int resultat = 0;

		if (viererPruefung() == true) {

			for (Dices d : getSpielTisch().gibWuerfel()) {

				if (d.getOnHold() == true) {

					this.viererResultat = resultat + d.getRollScore();
				}
			}
		}
		return this.viererResultat;
	}
	
	// Prüft ob die ausgewählten Würfel 5er sind.
	
	public boolean fuenferPruefung() {

		boolean x = false;

		for (Dices d : getSpielTisch().gibWuerfel()) {

			if (d.getRollScore() == 5 && d.getOnHold() == true) {

				x = true;
			}

		}
		return x;
	}

	// Liefert die Summer aller aktiven Würfel zurück nach der Prüfung.
	
	public int fuenferResultat() {

		int resultat = 0;

		if (fuenferPruefung() == true) {

			for (Dices d : getSpielTisch().gibWuerfel()) {

				if (d.getOnHold() == true) {

					this.fuenferResultat = resultat + d.getRollScore();
				}
			}
		}
		return this.fuenferResultat;
	}
	
	// Prüft ob die ausgewählten Würfel 6er sind.
	
	public boolean sechserPruefung() {

		boolean x = false;

		for (Dices d : getSpielTisch().gibWuerfel()) {

			if (d.getRollScore() == 6 && d.getOnHold() == true) {

				x = true;
			}

		}
		return x;
	}

	// Liefert die Summer aller aktiven Würfel zurück nach der Prüfung.
	
	public int sechserResultat() {

		int resultat = 0;

		if (sechserPruefung() == true) {

			for (Dices d : getSpielTisch().gibWuerfel()) {

				if (d.getOnHold() == true) {

					this.secherResultat = resultat + d.getRollScore();
				}
			}
		}
		return this.secherResultat;
	}
	
	// Summe oben addiert alle Resultate von 1-6 und liefert das Resultat als Integer zurück
	
	public int summeOben() {
		
		this.summeOben = einerResultat+zweierResultat+dreierResultat+viererResultat+fuenferResultat+secherResultat;
		return summeOben;
	}
	
	// Methode für den Bonus falls die Summe aller Resultate von 1-6 grösser ist als 63 returniert sie 35 Punkte Bonus;
	public int bonus() {
		
		if(this.summeOben >=63) {
			
			return 35;
		}
		return 0;	
		}
	
	
	// Prüft ob es sich um ein Dreierpasch handelt.
	
	public boolean dreierPasch() {
		
		boolean x = false;

		for (Dices d : getSpielTisch().gibWuerfel()) {

			if (d.getRollScore() == 6 && d.getOnHold() == true) {

				x = true;
			}

		}
		return x;
	}
		
	

}
