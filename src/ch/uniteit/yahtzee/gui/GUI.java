package ch.uniteit.yahtzee.gui;


import ch.uniteit.yahtzee.logic.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.MouseInputListener;

import static java.awt.Font.BOLD;


/*
 * Diese Klasse ist für die Visualisierung des spieles zuständig
 * @author Besnik Istrefi & Fernando Maniglio
 */

public class GUI extends JFrame implements MouseListener {

	// JFrame Attribute

	private JFrame mainFrame;

	// JPanel Attribute 

	private JPanel panelCenter;
	private JPanel panelTabelle;

	private JPanel panelEastFrame;
	private JPanel panelEast;
	private JPanel panelEastNorthplatzhalter;
	private JPanel panelNorth;
	private JPanel panelSouth;

	private JPanel[] panelWuerfelAktivFlow;
	private JPanel[] panelWuerfelDeaktivFlow;
	private JPanel panelWuerfelAktiv;
	private JPanel panelWuerfelDeaktiv;

	private JPanel wuerfel;
	private JPanel buttons;

	// JButton Attribute

	private JButton wuerfeln;
	private JButton neuesSpiel;
	private JButton besteListe;

	// JTable Attribute

	private JTable tabelle;
	private JTable sumTabelle;
	private JTable rankTabelle;
	private JScrollPane spTabelle;
	private JScrollPane spSumTabelle;
	private JScrollPane spRankTabelle;
	// JLabel Attribute für Bilder

	private JLabel spieler1;
	private JLabel spieler2;
	private Icon iconSpieler1;
	private Icon iconSpieler2;
	
	private JLabel aktuellerSpieler;


	// Attribut für Playtabel

	private ScoreTable spielTisch;

	// Attribut für Würfel Counter


	private int counterAnzahlWuerfeln;


	public GUI() {
		// Defaultkonstruktor für erst Initialiseriung
		// GUI elemente und Buttons und Listener
		super("Yathzee");
		this.setSize(1024, 768);
		this.setLayout(new BorderLayout());
		this.getContentPane().setBackground(new Color(28, 124, 11));

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.spielTisch = new ScoreTable();

		this.panelCenter = new JPanel();
		this.panelCenter.setLayout(new BorderLayout());

		this.panelEastFrame = new JPanel();
		this.panelEastFrame.setLayout(new BorderLayout());

		this.panelCenter.setBackground(new Color(28, 124, 11));
		this.panelCenter.setOpaque(true);


		this.panelEast = new JPanel();
		this.panelEast.setLayout(new FlowLayout());
		this.panelEast.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		this.panelEast.setBackground(new Color(98, 69, 11));

		this.panelEastNorthplatzhalter = new JPanel();
		this.panelEastNorthplatzhalter.setLayout(new FlowLayout());
		this.panelEastNorthplatzhalter.setBackground(new Color(98, 69, 11));


		this.panelNorth = new JPanel();
		this.panelNorth.setLayout(new FlowLayout());


		this.panelSouth = new JPanel();
		this.panelSouth.setLayout(new FlowLayout());




		this.panelTabelle = new JPanel();
		this.panelTabelle.setLayout(new FlowLayout());

		this.wuerfel = new JPanel();
		this.wuerfel.setLayout(new GridLayout(1, 2));
		this.wuerfel.setBorder(BorderFactory.createLineBorder(Color.BLACK));


		this.panelTabelle.setBackground(new Color(28, 124, 11));

		this.tabelle = spielTisch.gibScoreTable();
		this.sumTabelle = spielTisch.gibSumTable();
		this.rankTabelle = spielTisch.gibRankingTable();
		this.tabelle.setFillsViewportHeight(true);
		this.spTabelle = new JScrollPane(this.tabelle);
		this.sumTabelle.setFillsViewportHeight(true);
		this.spSumTabelle = new JScrollPane(this.sumTabelle);
		this.rankTabelle.setFillsViewportHeight(true);
		this.spRankTabelle = new JScrollPane(this.rankTabelle);


		this.panelWuerfelAktiv = new JPanel();
		this.panelWuerfelAktiv.setLayout(new GridLayout(5, 1));

		this.panelWuerfelAktivFlow = new JPanel[5];
		this.panelWuerfelDeaktivFlow = new JPanel[5];

		this.panelWuerfelDeaktiv = new JPanel();
		this.panelWuerfelDeaktiv.setLayout(new GridLayout(5, 1));


		this.iconSpieler1 = new ImageIcon(getClass().getResource("spieler1.png"));
		this.spieler1 = new JLabel(iconSpieler1);
		spieler1.setLayout(new FlowLayout());


		this.iconSpieler2 = new ImageIcon(getClass().getResource("spieler2.png"));
		this.spieler2 = new JLabel(iconSpieler2);
		spieler2.setLayout(new FlowLayout());
		
		this.aktuellerSpieler = new JLabel("Legen Wir Loos!!");
		aktuellerSpieler.setLayout(new FlowLayout());


		this.buttons = new JPanel();
		this.buttons.setLayout(new GridLayout(3, 1));
		this.buttons.setBackground(new Color(98, 69, 11));

		this.wuerfeln = new JButton("Würfeln");
		this.neuesSpiel = new JButton("Neues Spiel");
		this.besteListe = new JButton("Bestenliste");


		this.counterAnzahlWuerfeln = 0;


		initGui();
// top

		this.setVisible(true);

	}

	// Positioniert alle Elemente auf dem JFrame und setzt den Layoutmgr

	public void initGui() {


		this.add(panelCenter, BorderLayout.CENTER);
		this.add(panelEastFrame, BorderLayout.EAST);

		panelCenter.add(panelNorth, BorderLayout.NORTH);
		panelCenter.add(panelSouth, BorderLayout.SOUTH);



		panelSouth.add(spieler2);
		panelSouth.add(aktuellerSpieler);


		panelCenter.add(panelTabelle);


		panelEastNorthplatzhalter.add(spieler1);
		panelEastFrame.add(panelEastNorthplatzhalter, BorderLayout.NORTH);


		panelEastFrame.add(buttons, BorderLayout.SOUTH);
		panelEast.add(wuerfel);
		panelEastFrame.add(panelEast, BorderLayout.EAST);

		panelTabelle.setOpaque(true);
		JSplitPane jspR = new JSplitPane(JSplitPane.VERTICAL_SPLIT, spSumTabelle, spRankTabelle);
		JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, spTabelle, jspR);
		spTabelle.setMinimumSize(new Dimension(500, 350));
		tabelle.setBackground(new Color(69, 165, 53));
		tabelle.setForeground(Color.WHITE);
		tabelle.setGridColor(Color.GREEN);
		sumTabelle.setPreferredScrollableViewportSize(new Dimension(300, 80));
		jspR.setDividerLocation(180);
		sumTabelle.setGridColor(Color.WHITE);
		sumTabelle.setBackground(new Color(69, 165, 53));
		rankTabelle.setBackground(new Color(69, 165, 53));
		sumTabelle.setForeground(Color.WHITE);
		rankTabelle.setForeground(Color.WHITE);
		sumTabelle.setGridColor(Color.GREEN);
		rankTabelle.setGridColor(Color.GREEN);
		panelTabelle.add(jsp);
		panelCenter.add(jsp);


		wuerfel.add(panelWuerfelAktiv);
		wuerfel.add(panelWuerfelDeaktiv);


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


				if (counterAnzahlWuerfeln < 2) {

					spielTisch.alleWuerfeln();
					spielTisch.berechneTisch();
					counterAnzahlWuerfeln++;

				} else {
					((JButton) e.getSource()).setEnabled(false);
					if (getSpielTisch().getSpielerZug() == 1) {
						
						aktuellerSpieler.setText("Dein Gegner ist an der Reihe");
						
						getSpielTisch().setSpielerZug(3);
						
					} 
					else {
						getSpielTisch().setSpielerZug(1);
						aktuellerSpieler.setText("Du bist an der Reihe");
					}
					
					
				}

				for (Dices d : spielTisch.gibWuerfel()) {

					
					d.repaint();
				}

			}
		});

		neuesSpiel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				counterAnzahlWuerfeln = 0;
				wuerfeln.setEnabled(true);
				spielTisch.neuesSpiel();

			}
		});


		besteListe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});


	}

	public void spielNeustarten() {

		for (Dices d : spielTisch.gibWuerfel()) {
			System.out.println(d.getFlowIndex());
			panelWuerfelAktivFlow[d.getFlowIndex()].getParent().remove(d);
			panelWuerfelDeaktivFlow[d.getFlowIndex()].getParent().add(d);
		}

		// togle button enabled
		if (this.wuerfeln.isEnabled()) this.wuerfeln.setEnabled(false);
		else this.wuerfeln.setEnabled(true);
	}


	// Methode die den Aktiven Spieltisch retournieret

	public PlayTable getSpielTisch() {

		if (spielTisch != null) {

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

		Dices x = ((Dices) e.getSource());

		if (counterAnzahlWuerfeln < 3) {

			if (panelWuerfelAktivFlow[x.getFlowIndex()] == x.getParent()) {
				x.getParent().remove(x);
				panelWuerfelDeaktivFlow[x.getFlowIndex()].add(x);
				x.setHoldDice();


			} else if (panelWuerfelDeaktivFlow[x.getFlowIndex()] == x.getParent()) {
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


	public static void main(String[] args) throws Exception {

		new GUI();


	}
}

	

