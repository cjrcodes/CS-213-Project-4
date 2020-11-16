package application;

import java.util.ArrayList;

public class Chicken extends Sandwich {

	public Chicken() {
		// TODO Auto-generated constructor stub
		this.extras = new ArrayList<Extra>(MAX_EXTRAS);

	}

	@Override
	public double price() {
		// TODO Auto-generated method stub
		return 8.99;
	}
	
	@Override
	public String toString() {
		return "Chicken Sandwich: Fried Chicken, Spicy Sauce, Pickles, Extra: " + this.extras.toString() + " Price $" + String.format("%.2f",(this.price() + this.extras.size() * 1.99))  + "\n";
	}
	
	@Override
	public String getSandwichType() {
		return "Chicken";
	}
	
	

}
