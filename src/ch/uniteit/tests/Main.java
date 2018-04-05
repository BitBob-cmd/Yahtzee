package ch.uniteit.yahtzee;

import ch.uniteit.yahtzee.gui.GUI;
import ch.uniteit.yahtzee.logic.Dices;
import ch.uniteit.yahtzee.logic.PlayTable;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {
		GUI temp = new GUI();


		ArrayList<Dices> d = new PlayTable(-1).wuerfeln();
		for(Dices c: d){
			System.out.println(c.getRollScore());
		}
	}
}
