package ch.uniteit.yahtzee;

import ch.uniteit.yahtzee.gui.GUI;
import ch.uniteit.yahtzee.logic.PlayTable;

public class Main {

	public static void main(String[] args) throws Exception {
		GUI temp = new GUI();
		
		
		new PlayTable().wuerfeln();
	}
}
