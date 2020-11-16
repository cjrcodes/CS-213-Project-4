package application;

import java.util.ArrayList;

public class Order implements Customizable {
	public static int lineNumber; //reset for each new order;
	private ArrayList<OrderLine> orderlines;

	public Order() {
		// TODO Auto-generated constructor stub
		this.lineNumber = 0;
		this.orderlines = new ArrayList<OrderLine>(5);
		
	}
	
	public Order(OrderLine orderLine) {
		lineNumber = 0;
		this.orderlines.add(orderLine);
	}
	
	static int addLineNumber() {
		
		lineNumber++;
		return lineNumber;
	}
	
	public ArrayList<OrderLine> getOrderLines() {
		return this.orderlines;
	}
	
	public String toString() {
		return orderlines.toString();
	}
	
	

	@Override
	public boolean add(Object obj) {
		if (!(obj instanceof OrderLine)) {
			return false;
		}
		OrderLine orderLine = (OrderLine) obj;
		//orderLine.setLineNumber(addLineNumber());
		this.getOrderLines().add(orderLine);
		//addLineNumber();
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean remove(Object obj) {
		if (!(obj instanceof OrderLine)) {
			return false;
		}
		OrderLine orderLine = (OrderLine) obj;
		// TODO Auto-generated method stub
		this.getOrderLines().remove(orderLine);

		return false;
	}

}
