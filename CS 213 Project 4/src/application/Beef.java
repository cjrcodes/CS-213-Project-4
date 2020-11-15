package application;

public class Beef extends Sandwich {

	public Beef() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double price() {
		// TODO Auto-generated method stub
		return 10.99;
	}
	
	@Override
	public String toString() {
		return "Beef: Roast Beef, Provolone Cheese, Mustard, " + this.extras.toString() + " " + this.price() +  "\n";
	}

}
