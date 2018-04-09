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

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.ArrayList;


//TODO würfeln und befüllen und so
public class PlayTable extends ScoreTable implements ListSelectionListener {
	private int wuerfelAnzahl;
	private ArrayList<Dices> dieWuerfel;
	private int wuerfelScore;
	private int spielerZug; // hält den Spaltenindex des Spieler der gerade dran ist
	private Rules regelnScore;
	private Rules localRules;
	private JTable tabelle;
	private int sr;
	private int sc;
	private boolean wuerfelAktiv;
	private boolean wuerfelDeaktiv;

	/**
	 * Konstruktor default.
	 * Setzt die Anzahl Würfel die im Spiel sind, und generiert diese in einem array..
	 */
	public PlayTable() {
		super();
		this.localRules = new Rules();
		this.wuerfelAnzahl = 5;
		this.dieWuerfel = new ArrayList<>();
		this.spielerZug = 1;
		int i = 0;
		while (i < wuerfelAnzahl) {
			dieWuerfel.add(new Dices(i));
			i++;
		}
		this.tabelle = scoreTable;
		addSelectionListener();
	}

	/**
	 * Konstrukor custom
	 * Ermöglicht das Definieren der Anzahl Würfel die im Spiel sind..
	 *
	 * @param wuerfelAnzahl
	 */
	public PlayTable(int wuerfelAnzahl, int index) throws Exception {
		super();

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
				d.repaint();
			}
		}

	}

	// Rechnet alle Würfel zusammen
	public void berechneTisch() {
		for (Dices d : dieWuerfel) {

			this.wuerfelScore = this.wuerfelScore + d.getRollScore();


		}

	}

	public void addSelectionListener() {


		this.cellSelectionModel.addListSelectionListener(this);

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

		if (!e.getValueIsAdjusting()) {
			this.sc = tabelle.getSelectedColumn();
			this.sr = tabelle.getSelectedRow();
			//sc = scoreTable.getSelectedColumn(); //
			//String selRule = scoreTable.getValueAt(sr, 0).toString();
			//String isLocked;
			//isLocked = (scoreTable.getValueAt(sr, sc)).toString();
			//getSelectedColumn();
			//getSelectedRow();
			wertEinfuellenTabelle(tabelle.getSelectedRow());
			
			
		}
	}

	public void wertEinfuellenTabelle(int sr) {


		int punktzahl = 0;

		switch (sr) {

			case 0:
				System.out.println("regel 1ner");
				System.out.println(rl.einerPruefung(dieWuerfel));
				punktzahl = rl.einerPruefung(dieWuerfel);
				tabelle.setValueAt(punktzahl, sr, this.spielerZug);
				tabelle.setValueAt(new Boolean(true), sr, (this.spielerZug + 1));
				if (this.spielerZug == 1) {
					spielerZug = 3;
					GUI.spieler2Aktiv();
					GUI.resetCounterAnzahlWuerfel();
				} 
				else if (this.spielerZug == 3) {
					
					spielerZug = 1;
					GUI.spieler1Aktiv();
					GUI.resetCounterAnzahlWuerfel();
					
				} 

				
				break;
			case 1:
				System.out.println("regel 2er");
				punktzahl = rl.zweierPruefung(dieWuerfel);
				System.out.println(rl.zweierPruefung(dieWuerfel));

				tabelle.setValueAt(punktzahl, sr, this.spielerZug);
				tabelle.setValueAt(new Boolean(true), sr, (this.spielerZug + 1));
				if (this.spielerZug == 1) {
					spielerZug = 3;
					GUI.spieler2Aktiv();
					GUI.resetCounterAnzahlWuerfel();
					
				} 
				else if (this.spielerZug == 3) {
					
					spielerZug = 1;
					GUI.spieler1Aktiv();
					GUI.resetCounterAnzahlWuerfel();
					
				} 



				break;
			case 2:
				System.out.println("regel 3er");
				punktzahl = rl.dreierPruefung(dieWuerfel);
				tabelle.setValueAt(punktzahl, sr, this.spielerZug);
				tabelle.setValueAt(new Boolean(true), sr, (this.spielerZug + 1));
				if (this.spielerZug == 1) {
					spielerZug = 3;
					GUI.spieler2Aktiv();
					GUI.resetCounterAnzahlWuerfel();
				} 
				else if (this.spielerZug == 3) {
					
					spielerZug = 1;
					GUI.spieler1Aktiv();
					GUI.resetCounterAnzahlWuerfel();
					
				} 



				break;
			case 3:
				System.out.println("regel 4er");
				punktzahl = rl.viererPruefung(dieWuerfel);
				tabelle.setValueAt(punktzahl, sr, this.spielerZug);
				tabelle.setValueAt(new Boolean(true), sr, (this.spielerZug + 1));
				if (this.spielerZug == 1) {
					spielerZug = 3;
					GUI.spieler2Aktiv();
					GUI.resetCounterAnzahlWuerfel();
				} 
				else if (this.spielerZug == 3) {
					
					spielerZug = 1;
					GUI.spieler1Aktiv();
					GUI.resetCounterAnzahlWuerfel();
					
				} 



				break;
			case 4:
				System.out.println("regel 5er");
				punktzahl = rl.fuenferPruefung(dieWuerfel);

				tabelle.setValueAt(punktzahl, sr, this.spielerZug);
				tabelle.setValueAt(new Boolean(true), sr, (this.spielerZug + 1));
				if (this.spielerZug == 1) {
					spielerZug = 3;
					GUI.spieler2Aktiv();
					GUI.resetCounterAnzahlWuerfel();
				} 
				else if (this.spielerZug == 3) {
					
					spielerZug = 1;
					GUI.spieler1Aktiv();
					GUI.resetCounterAnzahlWuerfel();
					
				} 


				break;
			case 5:
				System.out.println("regel 6er");
				punktzahl = rl.sechserPruefung(dieWuerfel);
				tabelle.setValueAt(punktzahl, sr, this.spielerZug);
				tabelle.setValueAt(new Boolean(true), sr, (this.spielerZug + 1));
				if (this.spielerZug == 1) {
					spielerZug = 3;
					GUI.spieler2Aktiv();
					GUI.resetCounterAnzahlWuerfel();
				} 
				else if (this.spielerZug == 3) {
					
					spielerZug = 1;
					GUI.spieler1Aktiv();
					GUI.resetCounterAnzahlWuerfel();
					
				} 
	

				break;
			case 6:
				System.out.println("regel Dreierpasch");
				punktzahl = rl.ruleCheck("Dreierpasch", dieWuerfel);
				tabelle.setValueAt(punktzahl, sr, this.spielerZug);
				tabelle.setValueAt(new Boolean(true), sr, (this.spielerZug + 1));
				if (this.spielerZug == 1) {
					spielerZug = 3;
					GUI.spieler2Aktiv();
					GUI.resetCounterAnzahlWuerfel();
				} 
				else if (this.spielerZug == 3) {
					
					spielerZug = 1;
					GUI.spieler1Aktiv();
					GUI.resetCounterAnzahlWuerfel();
					
				} 
				
				break;
			case 7:
				System.out.println("Rergel Vierpasch");
				punktzahl = rl.ruleCheck("Vierpasch", dieWuerfel);
				tabelle.setValueAt(punktzahl, sr, this.spielerZug);
				tabelle.setValueAt(new Boolean(true), sr, (this.spielerZug + 1));
				if (this.spielerZug == 1) {
					spielerZug = 3;
					GUI.spieler2Aktiv();
					GUI.resetCounterAnzahlWuerfel();
				} 
				else if (this.spielerZug == 3) {
					
					spielerZug = 1;
					GUI.spieler1Aktiv();
					GUI.resetCounterAnzahlWuerfel();
					
				} 
				
				break;
			case 8:
				System.out.println("Regel FullHouse");
				punktzahl = rl.ruleCheck("FullHouse", dieWuerfel);
				tabelle.setValueAt(punktzahl, sr, this.spielerZug);
				tabelle.setValueAt(new Boolean(true), sr, (this.spielerZug + 1));
				if (this.spielerZug == 1) {
					spielerZug = 3;
					GUI.spieler2Aktiv();
					GUI.resetCounterAnzahlWuerfel();
				} 
				else if (this.spielerZug == 3) {
					
					spielerZug = 1;
					GUI.spieler1Aktiv();
					GUI.resetCounterAnzahlWuerfel();
					
				} 
				
				break;
			case 9:
				System.out.println("Regel KleineStrasse");
				punktzahl = rl.ruleCheck("KleineStrasse", dieWuerfel);
				tabelle.setValueAt(punktzahl, sr, this.spielerZug);
				tabelle.setValueAt(new Boolean(true), sr, (this.spielerZug + 1));
				if (this.spielerZug == 1) {
					spielerZug = 3;
					GUI.spieler2Aktiv();
					GUI.resetCounterAnzahlWuerfel();
				} 
				else if (this.spielerZug == 3) {
					
					spielerZug = 1;
					GUI.spieler1Aktiv();
					GUI.resetCounterAnzahlWuerfel();
					
				} 
				
				break;
			case 10:
				System.out.println("Regel GrosseStrasse");
				punktzahl = rl.ruleCheck("GrosseStrasse", dieWuerfel);
				tabelle.setValueAt(punktzahl, sr, this.spielerZug);
				tabelle.setValueAt(new Boolean(true), sr, (this.spielerZug + 1));
				if (this.spielerZug == 1) {
					spielerZug = 3;
					GUI.spieler2Aktiv();
					GUI.resetCounterAnzahlWuerfel();
				} 
				else if (this.spielerZug == 3) {
					
					spielerZug = 1;
					GUI.spieler1Aktiv();
					GUI.resetCounterAnzahlWuerfel();
					
				} 
				
				break;
			case 11:
				System.out.println("Regel Kniffel/Yahtzee");
				punktzahl = rl.ruleCheck("Kniffel", dieWuerfel);
				tabelle.setValueAt(punktzahl, sr, this.spielerZug);
				tabelle.setValueAt(new Boolean(true), sr, (this.spielerZug + 1));
				if (this.spielerZug == 1) {
					spielerZug = 3;
					GUI.spieler2Aktiv();
					GUI.resetCounterAnzahlWuerfel();
				} 
				else if (this.spielerZug == 3) {
					
					spielerZug = 1;
					GUI.spieler1Aktiv();
					GUI.resetCounterAnzahlWuerfel();
					
				}
				
				break;
			case 12:
				System.out.println("Regel Chance");
				punktzahl = rl.ruleCheck("Chance", dieWuerfel);
				tabelle.setValueAt(punktzahl, sr, this.spielerZug);
				tabelle.setValueAt(new Boolean(true), sr, (this.spielerZug + 1));
				if (this.spielerZug == 1) {
					spielerZug = 3;
					GUI.spieler2Aktiv();
					GUI.resetCounterAnzahlWuerfel();
				} 
				else if (this.spielerZug == 3) {
					
					spielerZug = 1;
					GUI.spieler1Aktiv();
					GUI.resetCounterAnzahlWuerfel();
					
				} 
				
				break;
			default:
				punktzahl = 0;
				break;
		}
		
		for(Dices d : gibWuerfel()) {
			
			d.setRollScore(0);
		}

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

	public void setSpielerZug(int spieler) {
		this.spielerZug = spielerZug;
	}

	
	public boolean getWuerfelAktiv() {
		
		return this.wuerfelAktiv;
	}
	
	
}