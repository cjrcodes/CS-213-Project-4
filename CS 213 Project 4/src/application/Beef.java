package application;

import java.util.ArrayList;

public class Beef extends Sandwich {

	public Beef() {
		// TODO Auto-generated constructor stub
		this.extras = new ArrayList<Extra>(MAX_EXTRAS);

	}

	@Override
	public double price() {
		// TODO Auto-generated method stub
		return 10.99;
	}
	
	@Override
	public String toString() {
		return "Beef: Roast Beef, Provolone Cheese, Mustard, Extra: " + this.extras.toString() + " Price $" + String.format("%.2f",(this.price() + this.extras.size() * 1.99))  + "\n";
	}
	
	@Override
	public String getSandwichType() {
		return "Beef";
	}

}
