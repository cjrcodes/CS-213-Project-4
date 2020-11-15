package application;

import java.util.ArrayList;

public abstract class Sandwich implements Customizable {
	static final int MAX_EXTRAS = 6;
	static final double PER_EXTRA = 1.99;
	protected ArrayList<Extra> extras;
	public abstract double price();

	public Sandwich() {
		// TODO Auto-generated constructor stub
	}

	
	public String toString() {
		String string = "Sandwich: ";
		for(int i =0; i < extras.size() ; i++) {
			string += extras.get(i) + " ";
		}
		string += "\n";

		return null; }
	
	@Override
	public boolean add(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
