package application;

import java.util.ArrayList;

public abstract class Sandwich implements Customizable {
	static final int MAX_EXTRAS = 6;
	static final double PER_EXTRA = 1.99;
	protected ArrayList<Extra> extras;
	public abstract double price();

	public Sandwich() {
		// TODO Auto-generated constructor stub
		this.extras = new ArrayList<Extra>(MAX_EXTRAS);
		
	}

	
	public String toString() {
		String string = "Sandwich: " + this.extras.toString() + "\n";
		

		return string; }
	
	public String getSandwichType() {
		return "Sandwich";
	}
	
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
