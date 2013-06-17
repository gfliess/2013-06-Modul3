package at.edu.hti.shop;

import org.junit.Test;

import at.edu.hti.shop.Customer;
import junit.framework.TestCase;

public class CustomerTest extends TestCase {
	@Test
	public void testConstructor() throws Exception {
		Customer temp = new Customer();
		assertNull(temp.getOrder());
		temp.startsOrder();
		assertNotNull(temp.getOrder());
	}
}
