package ch.uniteit.yahtzee.logic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Shape;
import java.util.Objects;
import java.util.Random;


public class Dices extends Canvas {

	private static final long serialVersionUID = 1L;


	protected int rollScore, augen;
	protected Random rnd;

	private int height;
	private int width;
	private int eyeSize;
	private int flowIndex;
	private boolean onHold;
	
	

	
	public Dices(int flowIndex) {
			
			

			this.augen = 7;
			this.rnd = new Random();
			this.height = 50;
			this.width = 50;
			this.eyeSize = height / 5;
			this.flowIndex = flowIndex;
			this.onHold = false;
			
			
			
			setSize(this.width, this.height);
			
			
			setBackground(Color.WHITE);


	
	}
	
	
	
	
	public Dices(){
		this.rollScore = 0;
		this.augen = 7;
		this.rnd = new Random();
		this.height = 50;
		this.width = 50;
		this.eyeSize = height / 5;
		
		
		setSize(this.width, this.height);

		setBackground(Color.WHITE);
		
	}

	// Würfeln
	public int roll() {
		
		this.rollScore = rnd.nextInt(augen-1)+1;
		return this.rollScore;
	
	}

	// Gibt das Result des gewürfelten zurück
	public int getRollScore() {
		return rollScore;
	}

	// Resultat des rolls setzen || cheat ;P
	public void setRollScore(int rollScore) {
		this.rollScore = rollScore;
	}

	// Gibt zürck wiviel Augen ein Würfel hat
	public int getAugen() {
		return augen;
	}

	// Setzt wiviel Augen ein Würfel haben soll || cheat
	public void setAugen(int augen) {
		this.augen = augen;
	}


		
		// Setzt den würfel onHold 
		
		public void setHoldDice() {
			
			this.onHold = true;
			
		}
		
		public void setNoHoldDice() {
			
			this.onHold = false;
		}
		
		public boolean getOnHold() {
			
			return onHold;
		}
		

	@Override
	public int hashCode() {


		return Objects.hash(getRollScore(), getAugen(), rnd);
	}

	public int getFlowIndex() {
		return flowIndex;
	}


		@Override
		public void paint(Graphics g) {
			// Setzen der Zeichnungsfarbe
			g.setColor(Color.RED);
			// Zeichne ein Oval (also auch einen Kreis)
			//TODO wieso nöd eifach immer de glich Würfel zeige?
			
			switch (this.rollScore) {
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