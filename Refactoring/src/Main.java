import java.io.FileNotFoundException;
import java.io.IOException;

import at.edu.hti.shop.Customer;

/**
 * @author Gerhard Fliess
 */
public class Main {

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		
		Customer customer = new Customer();
		ProductFactory factory = new ProductFileFactory();

		Parser parser = new Parser();
		parser.handelCustomer(factory, System.in, customer);

	}
}
