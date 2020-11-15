package application;

public class OrderLine {
	
	private int lineNumber; //a serial number created when a sandwich is added to the order
	private Sandwich sandwich;
	private double price;

	public OrderLine() {
		// TODO Auto-generated constructor stub
		
		this.lineNumber = 0;
		this.sandwich = null;
		this.price = 0;
	}

	public OrderLine(int lineNumber, Sandwich sandwich, double price) {
		// TODO Auto-generated constructor stub
		
		this.lineNumber = lineNumber;
		this.sandwich = sandwich;
		this.price = price;
	}
	
}
