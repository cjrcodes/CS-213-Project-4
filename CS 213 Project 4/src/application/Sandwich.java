package application;

import java.util.ArrayList;

/**
 * Sandwich, the parent class for all sandwich types.
 * @author Christian Rodriguez,  Yazhini Shanmugam
 *
 */

public abstract class Sandwich implements Customizable {
	static final int MAX_EXTRAS = 6;
	static final double PER_EXTRA = 1.99;
	protected ArrayList<Extra> extras;
	public abstract double price();

	/**
	 * Default constructor for sandwich
	 */
	public Sandwich() {
		// TODO Auto-generated constructor stub
		this.extras = new ArrayList<Extra>(MAX_EXTRAS);
		
	}

	/**
	 * Sandwich to string
	 * @return Sandwich in string format
	 */
	public String toString() {
		String string = "Sandwich: " + this.extras.toString() + "\n";
		

		return string; }
	
	public String getSandwichType() {
		return "Sandwich";
	}
	
	/**
	 * Adds extra to sandwich.
	 * @return true if item was added, false if not
	 */
	@Override
	public boolean add(Object obj) {
		if (!(obj instanceof Extra)) {
			return false;
		}
		Extra extra = (Extra) obj;
		this.extras.add(extra);
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Removes extra to sandwich
	 * @return true if item was removed, false if not
	 */
	@Override
	public boolean remove(Object obj) {
		// TODO Auto-generated method stub
		if (!(obj instanceof Extra)) {
			return false;
		}
		Extra extra = (Extra) obj;
		if(this.extras.contains(extra)) {
			this.extras.remove(extra);
			// TODO Auto-generated method stub
			return true;
		}
		return false;
	}

}
