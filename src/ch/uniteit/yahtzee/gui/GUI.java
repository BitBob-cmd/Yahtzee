package ch.uniteit.yahtzee.gui;
import ch.uniteit.yahtzee.logic.*;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

/*
 * Diese Klasse ist für die Visualisierung des spieles zuständig
 * @author Besnik Istrefi & Fernando Maniglio 
 */

public class GUI extends JFrame implements MouseListener {

	// JPanel Attribute hallo
	private JPanel panelCenter;
	private JPanel panelEast;
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

	// Dices Attribute

	private ArrayList<Dices> wuerfelAkt;
	
	// Attribut für Playtabel
	
	private PlayTable spielTisch;

	
	

	
	

	public GUI() throws Exception {
		// Defaultkonstruktor für erst Initialiseriung

		super("Yathzee");
		this.setSize(500, 500);
		this.setLayout(new BorderLayout());
		this.getContentPane().setBackground(Color.GREEN);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.panelCenter = new JPanel();
		this.panelCenter.setLayout(new FlowLayout());
		this.panelCenter.setBackground(Color.GREEN);

		this.panelEast = new JPanel();
		this.panelEast.setLayout(new BorderLayout());
		this.panelEast.setBackground(Color.GREEN);

		this.panelWuerfelAktiv = new JPanel();
		this.panelWuerfelAktiv.setLayout(new GridLayout(5, 1));
		this.panelWuerfelAktiv.setBackground(Color.GREEN);

		this.panelWuerfelAktivFlow = new JPanel[5];
		this.panelWuerfelDeaktivFlow = new JPanel[5];

		this.panelWuerfelDeaktiv = new JPanel();
		this.panelWuerfelDeaktiv.setLayout(new GridLayout(5, 1));
		this.panelWuerfelDeaktiv.setBackground(Color.GREEN);

		this.buttons = new JPanel();
		this.buttons.setLayout(new GridLayout(3, 1));
		this.buttons.setBackground(Color.GREEN);

		this.wuerfeln = new JButton("Würfeln");
		this.neuesSpiel = new JButton("Neues Spiel");
		this.besteListe = new JButton("Bestenliste");

		this.tabelle = new JTable(20, 4);
		this.tabelle.setGridColor(Color.black);

		this.wuerfelAkt = new ArrayList<>();
		this.spielTisch = new PlayTable(-1);
		
		
		
		
		
		initGui();

		
		
		this.setVisible(true);

	}

	// Positioniert alle Elemente auf dem JFrame und setzt den Layoutmgr

	public void initGui() {

		this.add(panelCenter, BorderLayout.CENTER);
		this.add(panelEast, BorderLayout.EAST);

		panelCenter.add(tabelle);

		panelEast.add(buttons, BorderLayout.SOUTH);
		panelEast.add(panelWuerfelAktiv, BorderLayout.WEST);
		panelEast.add(panelWuerfelDeaktiv, BorderLayout.CENTER);
		
		
		
		deaktivePanelErstellen();
		aktivePanelErstelle();
		wuerfelErstellen();

		buttons.add(wuerfeln);
		buttons.add(neuesSpiel);
		buttons.add(besteListe);
		
		//ActionListener Buttons 
		
		wuerfeln.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				for(Dices d : wuerfelAkt) {
					
					d.roll();
					repaint();

				}

			}
		});
	
	
	
		neuesSpiel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	
	
		
		
		besteListe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	
		
		this.spielTisch.alleWuerfeln();
	}
	
		
		
		
	// Diese Methode erstellt neue JPanel für den Deaktiven Bereich der Würfel
	
	public void deaktivePanelErstellen() {
		
		for (int count = 0; count < panelWuerfelDeaktivFlow.length; count++) {

			panelWuerfelDeaktivFlow[count] = new JPanel();
			panelWuerfelDeaktivFlow[count].setLayout(new FlowLayout());
			panelWuerfelDeaktivFlow[count].setBackground(Color.GREEN);

			panelWuerfelDeaktiv.add(panelWuerfelDeaktivFlow[count]);

		}
		
	}
	
	
	// Diese Methode erstellt neue JPanel für den Aktiven Bereich der Würfel
	
	public void aktivePanelErstelle() {
		
		for (int count = 0; count < panelWuerfelAktivFlow.length; count++) {

			panelWuerfelAktivFlow[count] = new JPanel();
			panelWuerfelAktivFlow[count].setLayout(new FlowLayout());
			panelWuerfelAktivFlow[count].setBackground(Color.GREEN);
			
			panelWuerfelAktiv.add(panelWuerfelAktivFlow[count]);

		}
		
	}
	
	// Würfel erstellen und MouseListener Hinzufügen
	
	public void wuerfelErstellen() {
		
		for(Dices d : spielTisch.gibWuerfel()) {
			
			wuerfelAkt.add(d);
			
		}
		
		int index = 0;
		while (index < spielTisch.getWuerfelAnzahl()) {
 

			panelWuerfelAktivFlow[index].add(wuerfelAkt.get(index));

			wuerfelAkt.get(index).addMouseListener(this); 

			index++;
		}

	}
		
	
	
	

	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		Dices x = ((Dices)e.getSource());
		
		
		
		if(panelWuerfelAktivFlow[x.getFlowIndex()] == x.getParent()) {
			x.getParent().remove(x);
			panelWuerfelDeaktivFlow[x.getFlowIndex()].add(x);
			
		}
		else if(panelWuerfelDeaktivFlow[x.getFlowIndex()] == x.getParent()) {
			x.getParent().remove(x);
			panelWuerfelAktivFlow[x.getFlowIndex()].add(x);
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

	

