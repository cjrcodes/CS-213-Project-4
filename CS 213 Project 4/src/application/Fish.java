package application;

public class Fish extends Sandwich {

	public Fish() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double price() {
		// TODO Auto-generated method stub
		return 12.99;
	}
	
	@Override
	public String toString() {
		return "Fish: Grilled Snapper, Cilantro, Lime,  " + this.extras.toString() + " " + this.price() +  "\n";
	}

}
