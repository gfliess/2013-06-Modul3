package at.edu.hti.shop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProductTest {

	@Test
	public void testSetting() throws Exception {
		Product temp = new Product();
		temp.setId("1");
		temp.setName("name");
		temp.setPrice(2.0);

		assertEquals("1", temp.getId());
		assertEquals("name", temp.getName());
		assertEquals(2.0, temp.getPrize(), 0.0);
	}
}
