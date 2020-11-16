package application;

import java.util.ArrayList;

public class Fish extends Sandwich {

	public Fish() {
		// TODO Auto-generated constructor stub
		this.extras = new ArrayList<Extra>(MAX_EXTRAS);

	}

	@Override
	public double price() {
		// TODO Auto-generated method stub
		return 12.99;
	}
	
	@Override
	public String toString() {
		return "Fish: Grilled Snapper, Cilantro, Lime, Extra: " + this.extras.toString() + " Price $" + String.format("%.2f",(this.price() + this.extras.size() * 1.99)) + "\n";
	}
	
	@Override
	public String getSandwichType() {
		return "Fish";
	}

}
