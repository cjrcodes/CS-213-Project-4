package application;

import java.util.ArrayList;

/**
 * Beef, a subclass of the Sandwich class
 * @author Christian Rodriguez,  Yazhini Shanmugam
 *
 */

public class Beef extends Sandwich {

	/**
	 * Default constructor for Beef
	 */
	public Beef() {
		// TODO Auto-generated constructor stub
		this.extras = new ArrayList<Extra>(MAX_EXTRAS);

	}

	
	/**
	 * Return price for Beef
	 * @return Double price of Beef Sandwich
	 */
	@Override
	public double price() {
		// TODO Auto-generated method stub
		return 10.99;
	}
	
	/**
	 *Beef to string
	 * @return String returns Beef Sandwich to String
	 */
	@Override
	public String toString() {
		return "Beef: Roast Beef, Provolone Cheese, Mustard, Extra: " + this.extras.toString() + " Price $" + String.format("%.2f",(this.price() + this.extras.size() * 1.99))  + "\n";
	}
	
	/**
	 * Gets sandwich type
	 * @return String sandwich type to string
	 */
	@Override
	public String getSandwichType() {
		return "Beef";
	}

}
