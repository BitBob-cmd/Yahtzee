package ch.uniteit.yahtzee.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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
	private JPanel userPanel;
	
	
	public GUI() {
		
		super("Yathzee");

		this.setSize(800,800);
		this.setLayout(new BorderLayout());
		
		this.getContentPane().setBackground(Color.GREEN);
		
		this.setVisible(true);
		
	}
	
}
