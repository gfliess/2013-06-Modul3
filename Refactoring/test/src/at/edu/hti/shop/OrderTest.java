package at.edu.hti.shop;

import static org.junit.Assert.*;

import org.junit.Test;

import at.edu.hti.shop.Order;
import at.edu.hti.shop.OrderLine;
import at.edu.hti.shop.Product;

public class OrderTest {
	@Test
	public void testConstructor() throws Exception {
		Order test = new Order();
		assertEquals(0, test.getOrderLines().size());
	}

	@Test
	public void testAddOrder() throws Exception {
		Order test = new Order();
		OrderLine line = new OrderLine();
		Product p = new Product();

		line.setProduct(p);
		line.setCount(1);
		test.getOrderLines().add(line);

	}

}
