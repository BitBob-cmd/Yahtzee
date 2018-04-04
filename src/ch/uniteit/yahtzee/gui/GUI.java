package ch.uniteit.yahtzee.gui;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import javafx.geometry.Insets;
import javafx.scene.shape.Box;
/*
 * Diese Klasse ist für die Visualisierung des spieles zuständig
 * @author Besnik Istrefi & Fernando Maniglio 
 */

public class GUI extends JFrame{
	
	// Attribute für JPanels
	private JPanel table;
	
	private JPanel sheetPanel;
	
	private JPanel playPanel;
	private JPanel buttonPanel;
	private JPanel playAll;
	private JPanel userPanel1;
	private JPanel userPanel2;
	
	// Attribute für JButtons
	
	private JButton wuerfeln;
	private JButton neuesSpiel;
	private JButton besteListe;
	
	// Attribute für die Tabelle
	
	private JTable tabelle;

	//Dices Array und Panel
	
	private JPanel dicesPanel;
	
	private Dice[] wuerfel;
	
	
	

	public GUI() {
		
		/*
		 * Erstellt ein JFrame und setzt den Layoutmanager
		 */
		
		super("Yathzee");
		this.setSize(800,800);
		this.setLayout(new BorderLayout());
		
	
		this.getContentPane().setBackground(Color.GREEN);
		
		// Instanziert neue JPanel 
		
		
		this.sheetPanel = new JPanel();
		this.sheetPanel.setLayout(new BorderLayout());
		this.sheetPanel.setBackground(Color.black);
		
		this.playPanel =  new JPanel();
		this.playPanel.setLayout(new BorderLayout());
		this.playPanel.setBackground(Color.RED);
		
		this.playAll = new JPanel();
		this.playAll.setBackground(Color.gray);
		this.playAll.setLayout(new BorderLayout());
		
		this.buttonPanel = new JPanel();
		this.buttonPanel.setBackground(Color.CYAN);
		this.buttonPanel.setLayout(new GridLayout(3, 1));
		

		
		
		

		this.userPanel1 =  new JPanel();
		this.userPanel1.setBackground(Color.WHITE);
		
		this.userPanel2 = new JPanel();
		this.userPanel2.setBackground(Color.blue);
		
		// Erstellt die Buttons fürs Spiel
		
		this.neuesSpiel = new JButton("Würfeln");
		this.wuerfeln = new JButton("Neues Spiel");
		this.besteListe = new JButton("Bestenliste");
		
		// Erstellt die Tabelle 
		
		this.tabelle = new JTable(20,4);

		this.tabelle.setGridColor(Color.BLACK);
		
		// Erstellt das Array für die Wüerfel und das Panel für das Canvas
		
		
		this.dicesPanel = new JPanel();
		this.dicesPanel.setLayout(new GridLayout(5, 2));
		
		this.wuerfel = new Dice[5];
		
		// Fühgt alle Panel an das JFrame an
		
		initGui();
		
	

	
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	

	public void initGui() {
		
		playAll.add(playPanel, BorderLayout.CENTER);
		playAll.add(buttonPanel, BorderLayout.SOUTH);
		
		this.add(playAll, BorderLayout.EAST);
		this.add(sheetPanel, BorderLayout.CENTER);
		this.add(userPanel1, BorderLayout.NORTH);
		this.add(userPanel2, BorderLayout.SOUTH);
		
		
		playPanel.add(besteListe);
		buttonPanel.add(wuerfeln);
	    buttonPanel.add(neuesSpiel);
	    buttonPanel.add(besteListe);
	    
	   for(int count = 0; count < wuerfel.length ; count++) {
		   
		   wuerfel[count] = new Dice();
		   dicesPanel.add(wuerfel[count]);
	   }
	    
	    
	   	playAll.add(dicesPanel, BorderLayout.WEST);
	    sheetPanel.add(tabelle, BorderLayout.CENTER);

		
	}
		

		
		
	public class Dice extends Canvas {

		private static final long serialVersionUID = 1L;
		private int value;
		private Random r;
		private int height;
		private int width;
		private int eyeSize;

		public Dice() {
			this.r = new Random();
			this.height = 100;
			this.width = 100;
			this.eyeSize = height / 5;
			this.value = this.generateRandomValue();

			setSize(this.width, this.height);

			setBackground(Color.BLUE);

			addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					value = generateRandomValue();
					repaint();
				}
			});
		}

		private int generateRandomValue() {
			return this.r.nextInt(6) + 1;
		}

		@Override
		public void paint(Graphics g) {
			// Setzen der Zeichnungsfarbe
			g.setColor(Color.WHITE);
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
				g.fillOval(this.width - this.eyeSize - this.eyeSize / 2, this.height / 2 - this.eyeSize / 2, this.eyeSize,
						this.eyeSize);
				g.fillOval(this.width - this.eyeSize - this.eyeSize / 2, this.eyeSize / 2, this.eyeSize, this.eyeSize);
				g.fillOval(this.eyeSize / 2, this.height - this.eyeSize - this.eyeSize / 2, this.eyeSize, this.eyeSize);
				g.fillOval(this.width - this.eyeSize - this.eyeSize / 2, this.height - this.eyeSize - this.eyeSize / 2,
						this.eyeSize, this.eyeSize);
				break;
			}
		}
	}	
		
		

		
	}
	

