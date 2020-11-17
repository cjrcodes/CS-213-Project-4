package application;

/**
 * OrderLine, contains order details for any added sandwich
 * @author Christian Rodriguez,  Yazhini Shanmugam
 *
 */

public class OrderLine {
	
	private int lineNumber; //a serial number created when a sandwich is added to the order
	private Sandwich sandwich;
	private double price;

	
	/**
	 * Default constructor for OrderLine
	 */
	public OrderLine() {
		// TODO Auto-generated constructor stub
		
		this.lineNumber = 0;
		this.sandwich = null;
		this.price = 0;
	}
	
	/**
	 * Constructor for OrderLine with no lineNumber parameter
	 * @param sandwich to be added to order line
	 * @param price Price of the sandwich
	 */
	public OrderLine(Sandwich sandwich, double price) {
		// TODO Auto-generated constructor stub
		this.lineNumber = 0;
		this.sandwich = sandwich;
		this.price = price;
	}

	/**
	 * OrderLine constructor for all details
	 * @param lineNumber Line number for the order line
	 * @param sandwich to be added to order line
	 * @param price Price of the sandwich
	 */
	public OrderLine(int lineNumber, Sandwich sandwich, double price) {
		// TODO Auto-generated constructor stub
		
		this.lineNumber = lineNumber;
		this.sandwich = sandwich;
		this.price = price;
	}
	
	/**
	 * Order line to string
	 * @return String order line details listed in string format
	 */
	public String toString() {
		return this.lineNumber + " " + this.sandwich.toString();
	}
	
	/**
	 * Get price of the order line
	 * @return Double order line price
	 */
	public Double getPrice() {
		return this.price;
	}
	
	/**
	 * Sets line number, mostly for external use
	 * @param lineNumber sets line number
	 */
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	/**
	 * Gets line number
	 * @return Int returns line number
	 */
	public int getLineNumber() {
		return this.lineNumber;
	}
	
	/**
	 * Gets sandwich in line number
	 * @return Sandwich to be retrieved.
	 */
	public Sandwich getSandwich() {
		return this.sandwich;
	}
	
	
	
}
