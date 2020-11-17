package application;

import java.util.ArrayList;


/**
 * Chicken, a subclass of the Sandwich class
 * @author Christian Rodriguez,  Yazhini Shanmugam
 *
 */
public class Chicken extends Sandwich {

	/**
	 * Default constructor for Chicken
	 */
	public Chicken() {
		// TODO Auto-generated constructor stub
		this.extras = new ArrayList<Extra>(MAX_EXTRAS);

	}

	/**
	 * Return price for Chicken
	 * @return Double price of Chicken Sandwich
	 */
	@Override
	public double price() {
		// TODO Auto-generated method stub
		return 8.99;
	}
	
	/**
	 * Chicken to string
	 * @return String returns Chicken Sandwich to String
	 */
	@Override
	public String toString() {
		return "Chicken Sandwich: Fried Chicken, Spicy Sauce, Pickles, Extra: " + this.extras.toString() + " Price $" + String.format("%.2f",(this.price() + this.extras.size() * 1.99))  + "\n";
	}
	
	/**
	 * Gets sandwich type
	 * @return String sandwich type to string
	 */
	@Override
	public String getSandwichType() {
		return "Chicken";
	}
	
	

}
