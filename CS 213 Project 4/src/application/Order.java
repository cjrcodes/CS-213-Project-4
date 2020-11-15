package application;

import java.util.ArrayList;

public class Order implements Customizable {
	public static int lineNumber; //reset for each new order;
	private ArrayList<OrderLine> orderlines;

	public Order() {
		// TODO Auto-generated constructor stub
		this.lineNumber = 0;
		this.orderlines = null;
		
	}
	
	public Order(OrderLine orderLine) {
		this.lineNumber = 0;
		this.orderlines.add(orderLine);
	}
	
	int getLineNumber() {
		if(this.lineNumber == 0) {
			return lineNumber;
		}
		this.lineNumber++;
		return lineNumber;
	}
	
	

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
