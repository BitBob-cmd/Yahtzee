package ch.uniteit.yahtzee.gui;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

/*
 * Diese Klasse ist für die Visualisierung des spieles zuständig
 * @author Besnik Istrefi & Fernando Maniglio 
 */

public class GUI extends JFrame {

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

	private Dice[] wuerfelAkt;
	private Dice[] wuerfelDeakt;

	public GUI() {
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

		this.wuerfelAkt = new Dice[5];

		initGui();

		this.setVisible(true);

	}

	// Positioniert alle Elemente auf dem JFramme und setzt den Layoutmgr

	public void initGui() {

		this.add(panelCenter, BorderLayout.CENTER);
		this.add(panelEast, BorderLayout.EAST);

		panelCenter.add(tabelle);

		panelEast.add(buttons, BorderLayout.SOUTH);
		panelEast.add(panelWuerfelAktiv, BorderLayout.WEST);
		panelEast.add(panelWuerfelDeaktiv, BorderLayout.CENTER);

		buttons.add(wuerfeln);
		buttons.add(neuesSpiel);
		buttons.add(besteListe);

		for (int count = 0; count < panelWuerfelAktivFlow.length; count++) {

			panelWuerfelAktivFlow[count] = new JPanel();
			panelWuerfelAktivFlow[count].setLayout(new FlowLayout());
			panelWuerfelAktivFlow[count].setBackground(Color.GREEN);

			panelWuerfelAktiv.add(panelWuerfelAktivFlow[count]);

		}

		for (int count = 0; count < panelWuerfelDeaktivFlow.length; count++) {

			panelWuerfelDeaktivFlow[count] = new JPanel();
			panelWuerfelDeaktivFlow[count].setLayout(new FlowLayout());
			panelWuerfelDeaktivFlow[count].setBackground(Color.GREEN);

			panelWuerfelDeaktiv.add(panelWuerfelDeaktivFlow[count]);

		}

		
		int index = 0;
		while (index < wuerfelAkt.length) {

			wuerfelAkt[index] = new Dice();

			panelWuerfelAktivFlow[index].add(wuerfelAkt[index]);

			wuerfelAkt[index].addMouseListener(new MouseAdapter() {

				@SuppressWarnings("deprecation")
				@Override
				public void mouseClicked(MouseEvent e) {

					
					Dice x = (Dice) e.getSource();

					panelWuerfelAktivFlow[1].remove(x);
					panelWuerfelDeaktivFlow[0].add(x);

				}
			});
			
			index++;
		}
		

	}

	/*
	 * Interne Klasse für die Instanzierung und Zeichnung der Würfel
	 * 
	 * 
	 */

	public class Dice extends Canvas {

		private static final long serialVersionUID = 1L;
		private int value;
		private Random r;
		private int height;
		private int width;
		private int eyeSize;

		public Dice() {
			this.r = new Random();
			this.height = 50;
			this.width = 50;
			this.eyeSize = height / 5;
			this.value = this.generateRandomValue();

			setSize(this.width, this.height);

			setBackground(Color.WHITE);

		}

		private int generateRandomValue() {
			return this.r.nextInt(6) + 1;
		}

		@Override
		public void paint(Graphics g) {
			// Setzen der Zeichnungsfarbe
			g.setColor(Color.RED);
			// Zeichne ein Oval (also auch einen Kreis)
			switch (this.value) {
			case 1:
				g.fillOval(this.width / 2 - this.eyeSize / 2, this.height / 2 - this.eyeSize / 2, this.eyeSize,
						this.eyeSize);
				break;
			case 2:
				g.fillOval(this.eyeSize / 2, this.eyeSize / 2, this.eyeSize, this.eyeSize);
				g.fillOval(this.width - this.eyeSize - this.eyeSize / 2, this.height - this.eyeSize - this.eyeSize / 2,
						this.eyeSize, this.eyeSize);
				break;
			case 3:
				g.fillOval(this.width / 2 - this.eyeSize / 2, this.height / 2 - this.eyeSize / 2, this.eyeSize,
						this.eyeSize);
				g.fillOval(this.eyeSize / 2, this.eyeSize / 2, this.eyeSize, this.eyeSize);
				g.fillOval(this.width - this.eyeSize - this.eyeSize / 2, this.height - this.eyeSize - this.eyeSize / 2,
						this.eyeSize, this.eyeSize);
				break;
			case 4:
				g.fillOval(this.eyeSize / 2, this.eyeSize / 2, this.eyeSize, this.eyeSize);
				g.fillOval(this.width - this.eyeSize - this.eyeSize / 2, this.eyeSize / 2, this.eyeSize, this.eyeSize);
				g.fillOval(this.eyeSize / 2, this.height - this.eyeSize - this.eyeSize / 2, this.eyeSize, this.eyeSize);
				g.fillOval(this.width - this.eyeSize - this.eyeSize / 2, this.height - this.eyeSize - this.eyeSize / 2,
						this.eyeSize, this.eyeSize);
				break;
			case 5:
				g.fillOval(this.width / 2 - this.eyeSize / 2, this.height / 2 - this.eyeSize / 2, this.eyeSize,
						this.eyeSize);
				g.fillOval(this.eyeSize / 2, this.eyeSize / 2, this.eyeSize, this.eyeSize);
				g.fillOval(this.width - this.eyeSize - this.eyeSize / 2, this.eyeSize / 2, this.eyeSize, this.eyeSize);
				g.fillOval(this.eyeSize / 2, this.height - this.eyeSize - this.eyeSize / 2, this.eyeSize, this.eyeSize);
				g.fillOval(this.width - this.eyeSize - this.eyeSize / 2, this.height - this.eyeSize - this.eyeSize / 2,
						this.eyeSize, this.eyeSize);
				break;
			case 6:
				g.fillOval(this.eyeSize / 2, this.eyeSize / 2, this.eyeSize, this.eyeSize);
				g.fillOval(this.eyeSize / 2, this.height / 2 - this.eyeSize / 2, this.eyeSize, this.eyeSize);
				g.fillOval(this.width - this.eyeSize - this.eyeSize / 2, this.height / 2 - this.eyeSize / 2,
						this.eyeSize, this.eyeSize);
				g.fillOval(this.width - this.eyeSize - this.eyeSize / 2, this.eyeSize / 2, this.eyeSize, this.eyeSize);
				g.fillOval(this.eyeSize / 2, this.height - this.eyeSize - this.eyeSize / 2, this.eyeSize, this.eyeSize);
				g.fillOval(this.width - this.eyeSize - this.eyeSize / 2, this.height - this.eyeSize - this.eyeSize / 2,
						this.eyeSize, this.eyeSize);
				break;
			}

		}

	}
	public static void main(String[] args) {
		
		GUI temp = new GUI();
	}
}
