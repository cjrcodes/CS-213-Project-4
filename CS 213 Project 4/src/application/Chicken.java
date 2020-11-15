package application;

public class Chicken extends Sandwich {

	public Chicken() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double price() {
		// TODO Auto-generated method stub
		return 8.99;
	}
	
	@Override
	public String toString() {
		return "Chicken Sandwich: Fried Chicken, Spicy Sauce, Pickles, " + this.extras.toString() + " " + this.price() + "\n";
	}

}
