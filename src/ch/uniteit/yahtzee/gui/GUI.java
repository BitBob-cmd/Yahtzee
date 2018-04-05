package ch.uniteit.yahtzee.gui;
import ch.uniteit.yahtzee.logic.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.MouseInputListener;

/*
 * Diese Klasse ist für die Visualisierung des spieles zuständig
 * @author Besnik Istrefi & Fernando Maniglio 
 */

public class GUI extends JFrame implements MouseListener {

	// JPanel Attribute 
	
	private JPanel panelCenter;
	private JPanel panelTabelle;
	
	private JPanel panelEast;
	private JPanel panelNorth;
	private JPanel panelSouth;
	
	private JPanel[] panelWuerfelAktivFlow;
	private JPanel[] panelWuerfelDeaktivFlow;
	private JPanel panelWuerfelAktiv;
	private JPanel panelWuerfelDeaktiv;
	private JPanel buttons;

	// JButton Attribute

	private JButton wuerfeln;
	private JButton neuesSpiel;
	private JButton besteListe;

	// JTable Attribute

	private JTable tabelle;
	
	
	// JLabel Attribute für Bilder
	
	private JLabel spieler1;
	private JLabel spieler2;
	private Icon iconSpieler1;
	private Icon iconSpieler2;


	// Attribut für Playtabel
	
	private Rules spielTisch;
	
	// Attribut für Würfel Counter
	
	private int counterAnzahlWuerfeln;
	
	

	
	

	
	

	public GUI() {
		// Defaultkonstruktor für erst Initialiseriung

		super("Yathzee");
		this.setSize(1024, 768);
		this.setLayout(new BorderLayout());
		this.getContentPane().setBackground(new Color(28, 124, 11));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.panelCenter = new JPanel();
		this.panelCenter.setLayout(new BorderLayout());
		this.panelCenter.setBackground(new Color(28, 124, 11));
		
		this.panelEast = new JPanel();
		this.panelEast.setLayout(new BorderLayout());
		this.panelEast.setBackground(new Color(28, 124, 11));
		
		
		this.panelNorth = new JPanel();
		this.panelNorth.setLayout(new FlowLayout());
		this.panelNorth.setBackground(new Color(28, 124, 11));
		
		this.panelSouth = new JPanel();
		this.panelSouth.setLayout(new FlowLayout());
		this.panelSouth.setBackground(new Color(28, 124, 11));
		
		
		
		this.panelTabelle = new JPanel();
		this.panelTabelle.setLayout(new FlowLayout());
		this.panelTabelle.setBackground(new Color(28, 124, 11));
		



		this.panelWuerfelAktiv = new JPanel();
		this.panelWuerfelAktiv.setLayout(new GridLayout(5, 1));
		this.panelWuerfelAktiv.setBackground(new Color(28, 124, 11));

		this.panelWuerfelAktivFlow = new JPanel[5];
		this.panelWuerfelDeaktivFlow = new JPanel[5];

		this.panelWuerfelDeaktiv = new JPanel();
		this.panelWuerfelDeaktiv.setLayout(new GridLayout(5, 1));
		this.panelWuerfelDeaktiv.setBackground(new Color(28,124,11));
		
		this.iconSpieler1 = new ImageIcon(getClass().getResource("spieler1.png"));
		this.spieler1 = new JLabel(iconSpieler1);
		spieler1.setLayout(new FlowLayout());
		
		spieler1.setSize(200,200);
		
		
		this.iconSpieler2 = new ImageIcon(getClass().getResource("spieler2.png"));
		this.spieler2 = new JLabel(iconSpieler2);
		spieler2.setLayout(new FlowLayout());
		spieler2.setSize(200,200);
		

		this.buttons = new JPanel();
		this.buttons.setLayout(new GridLayout(3, 1));
		this.buttons.setBackground(new Color(28, 124, 11));

		this.wuerfeln = new JButton("Würfeln");
		this.neuesSpiel = new JButton("Neues Spiel");
		this.besteListe = new JButton("Bestenliste");




		
		this.spielTisch = new Rules();
		
		// tabellen zeugs
		this.tabelle = new ScoreTable(this.spielTisch).gibTabelle();




		this.counterAnzahlWuerfeln = 0;

		
		initGui();

		
		
		this.setVisible(true);

	}

	// Positioniert alle Elemente auf dem JFrame und setzt den Layoutmgr

	public void initGui() {

		this.add(panelCenter, BorderLayout.CENTER);
		this.add(panelEast, BorderLayout.EAST);
		
		panelCenter.add(panelNorth, BorderLayout.NORTH);
		panelCenter.add(panelSouth, BorderLayout.SOUTH);
	
		
		panelNorth.add(spieler1);
		panelSouth.add(spieler2);
		
		panelTabelle.add(tabelle);
		panelCenter.add(panelTabelle);
		
		
		panelEast.add(buttons, BorderLayout.SOUTH);
		panelEast.add(panelWuerfelAktiv, BorderLayout.WEST);
		panelEast.add(panelWuerfelDeaktiv, BorderLayout.CENTER);
		

		deaktivePanelErstellen();
		aktivePanelErstelle();
		indexUndMouseListenerADD();

		buttons.add(wuerfeln);
		buttons.add(neuesSpiel);
		buttons.add(besteListe);

		//ActionListener für Buttons
		
		wuerfeln.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if(counterAnzahlWuerfeln <3) {
					
					spielTisch.alleWuerfeln();
					spielTisch.berechneTisch();
					counterAnzahlWuerfeln++;
					
				}
				else {
					((JButton)e.getSource()).setEnabled(false);
				}
				
				for(Dices d : spielTisch.gibWuerfel()) {
					
					//System.out.println(d.getRollScore());
					d.repaint();
				}
			
			}
		});
	
	
	
		neuesSpiel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				counterAnzahlWuerfeln = 0;
				wuerfeln.setEnabled(true);
			}
		});
	

		
		
		besteListe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(spielTisch.dreierResultat());
				
			}
		});
	
	
		

	}
	
	
	
	// Methode die den Aktiven Spieltisch retournieret
	
	public PlayTable getSpielTisch() {
		
		if(spielTisch != null) {
			
			return spielTisch;
		}
		return null;
	}
		
		
	// Diese Methode erstellt neue JPanel für den Deaktiven Bereich der Würfel
	
	public void deaktivePanelErstellen() {
		
		
		
		for (int count = 0; count < panelWuerfelDeaktivFlow.length; count++) {

			panelWuerfelDeaktivFlow[count] = new JPanel();
			panelWuerfelDeaktivFlow[count].setLayout(new FlowLayout());
			panelWuerfelDeaktivFlow[count].setBackground(new Color(28, 124, 11));
			
			panelWuerfelDeaktiv.add(panelWuerfelDeaktivFlow[count]);

		}
		
	}
	
	
	// Diese Methode erstellt neue JPanel für den Aktiven Bereich der Würfel
	
	public void aktivePanelErstelle() {
		
		for (int count = 0; count < panelWuerfelAktivFlow.length; count++) {

			panelWuerfelAktivFlow[count] = new JPanel();
			panelWuerfelAktivFlow[count].setLayout(new FlowLayout());
			panelWuerfelAktivFlow[count].setBackground(new Color(28, 124, 11));
			
			panelWuerfelAktiv.add(panelWuerfelAktivFlow[count]);

		}
		
	}
	
	//  MouseListener Hinzufügen und Indexiieren 
	
	public void indexUndMouseListenerADD() {
		
		
		int index = 0;
		while (index < spielTisch.getWuerfelAnzahl()) {
 

			panelWuerfelAktivFlow[index].add(spielTisch.gibWuerfel().get(index));

			spielTisch.gibWuerfel().get(index).addMouseListener(this); 

			index++;
		}

	}
		

	@Override
	public void mouseClicked(MouseEvent e) {
		
		Dices x = ((Dices)e.getSource());
		
		if(counterAnzahlWuerfeln<3) {
			
			if(panelWuerfelAktivFlow[x.getFlowIndex()] == x.getParent()) {
				x.getParent().remove(x);
				panelWuerfelDeaktivFlow[x.getFlowIndex()].add(x);
				x.setHoldDice();
				
				
			}
			else if(panelWuerfelDeaktivFlow[x.getFlowIndex()] == x.getParent()) {
				x.getParent().remove(x);
				panelWuerfelAktivFlow[x.getFlowIndex()].add(x);
				x.setNoHoldDice();
			}
			
			
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	/*
	 * Interne Klasse für die Instanzierung und Zeichnung der Würfel
	 * 
	 * 
	 */

	

	public static void main(String[] args) throws Exception {

		GUI temp = new GUI();
		
		
		
		
	}
}

	

