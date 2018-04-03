package ch.uniteit.yahtzee.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;
/*
 * Diese Klasse ist für die Visualisierung des spieles zuständig
 * @author Besnik Istrefi & Fernando Maniglio 
 */

public class GUI extends JFrame{
	
	private JPanel tablePanel;
	private JPanel sheetPanel;
	private JPanel playPanel;
	private JPanel userPanel;

	//TODO <Name1 & Name2> durch variabeln ersetzen? Bei Spielbeginn Namen eingeben lassen.
	private String[] spaltenNamen = {"Name1","Name2"};
	private JTable scoreTable = new JTable(null,spaltenNamen);

	public GUI() {
		
		super("Yathzee");

		this.setSize(800,800);
		this.setLayout(new BorderLayout());
		
		this.getContentPane().setBackground(Color.GREEN);
		
		this.setVisible(true);
		
	}
	
}
