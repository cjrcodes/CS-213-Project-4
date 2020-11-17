package application;

import java.util.ArrayList;

/**
 * Fish, a subclass of the Sandwich class
 * @author Christian Rodriguez,  Yazhini Shanmugam
 *
 */

public class Fish extends Sandwich {

	
	/**
	 * Default constructor for Fish
	 */
	public Fish() {
		// TODO Auto-generated constructor stub
		this.extras = new ArrayList<Extra>(MAX_EXTRAS);

	}

	
	/**
	 * Return price for Fish
	 * @return Double price of Beef Sandwich
	 */
	@Override
	public double price() {
		// TODO Auto-generated method stub
		return 12.99;
	}
	
	/**
	 *Fish to string
	 * @return String returns Fish Sandwich to String
	 */
	@Override
	public String toString() {
		return "Fish: Grilled Snapper, Cilantro, Lime, Extra: " + this.extras.toString() + " Price $" + String.format("%.2f",(this.price() + this.extras.size() * 1.99)) + "\n";
	}
	
	/**
	 * Gets sandwich type
	 * @return String sandwich type to string
	 */
	@Override
	public String getSandwichType() {
		return "Fish";
	}

}
