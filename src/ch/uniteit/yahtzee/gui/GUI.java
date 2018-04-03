package ch.uniteit.yahtzee.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * Diese Klasse ist für die Visualisierung des spieles zuständig
 * @author Besnik Istrefi & Fernando Maniglio 
 */

public class GUI extends JFrame{
	
	private JPanel table;
	private JPanel sheetPanel;
	private JPanel playPanel;
	private JPanel userPanel1;
	private JPanel userPanel2;
	
	
	public GUI() {
		
		/*
		 * Erstellt ein JFrame und setzt den Layoutmanager
		 */
		
		super("Yathzee");
		this.setSize(800,800);
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		this.getContentPane().setBackground(Color.GREEN);
		
		// Instanziert neue JPanel 
		
		this.table = new JPanel();
		this.sheetPanel = new JPanel();
		this.playPanel =  new JPanel();
		this.userPanel1 =  new JPanel();
		this.userPanel2 = new JPanel();
		

		initGui();
		
		
		this.setVisible(true);
		
	}
	
	public void initGui() {
		
		this.add(table, BorderLayout.CENTER);
		this.add(sheetPanel, BorderLayout.EAST);
		this.add(playPanel, BorderLayout.CENTER);
		this.add(userPanel1, BorderLayout.NORTH);
		this.add(userPanel2, BorderLayout.SOUTH);
		
	}
	
}
