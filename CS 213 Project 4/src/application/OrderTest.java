package application;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;


/**
 * OrderTest JUnit Test, tests the Order class and it's public methods
 * @author Christian Rodriguez,  Yazhini Shanmugam
 *
 */
class OrderTest {

	@Test
	void testOrder() {
		
		Order order = new Order();
		
		
		assertEquals(order.lineNumber, 0);
		assertEquals(order.getOrderLines().size(), 0);

	}

	@Test
	void testOrderOrderLine() {
		Order order = new Order();
		
		Sandwich sandwich = new Chicken();
		
		Double price = 8.99;
		
		OrderLine orderLine = new OrderLine(order.addLineNumber(), sandwich, price);
		
		order.add(orderLine);
		
		assertEquals(order.getOrderLines().size(), 1);
		
	}

	@Test
	void testAddLineNumber() {
		Order order = new Order();
		
		Order.addLineNumber();
		
		assertEquals(Order.lineNumber, 1);
	}

	@Test
	void testGetOrderLines() {
		Order order = new Order();
		
		Sandwich sandwich = new Chicken();
		
		Double price = 8.99;
		
		OrderLine orderLine = new OrderLine(order.addLineNumber(), sandwich, price);
		
		ArrayList<OrderLine> orderLines = new ArrayList<OrderLine>(5);
		orderLines.add(orderLine);
		
		order.add(orderLine);
		//System.out.println(order.getOrderLines());
		assertEquals(order.getOrderLines(), orderLines);
		
	}

	@Test
	void testToString() {
		Order order = new Order();
		
		Sandwich sandwich = new Chicken();
		
		Double price = 8.99;
		
		OrderLine orderLine = new OrderLine(order.addLineNumber(), sandwich, price);
		
		ArrayList<OrderLine> orderLines = new ArrayList<OrderLine>(5);
		orderLines.add(orderLine);
		
		order.add(orderLine);

		assertEquals(order.toString(), orderLines.toString());
	}

	@Test
	void testAdd() {
		Order order = new Order();
		
		Sandwich sandwich = new Chicken();
		
		Double price = 8.99;
		
		OrderLine orderLine = new OrderLine(order.addLineNumber(), sandwich, price);
		
		ArrayList<OrderLine> orderLines = new ArrayList<OrderLine>(5);
		orderLines.add(orderLine);
		
		order.add(orderLine);
		//System.out.println(order.getOrderLines());
		assertEquals(order.add(orderLine), orderLines.add(orderLine));	}

	@Test
	void testRemove() {
		Order order = new Order();
		
		Sandwich sandwich = new Chicken();
		
		Double price = 8.99;
		
		OrderLine orderLine = new OrderLine(order.addLineNumber(), sandwich, price);
		
		ArrayList<OrderLine> orderLines = new ArrayList<OrderLine>(5);
		orderLines.add(orderLine);
		
		
		
		order.add(orderLine);
		//System.out.println(order.getOrderLines());
		assertEquals(order.remove(orderLine), orderLines.remove(orderLine));	
	}

}
