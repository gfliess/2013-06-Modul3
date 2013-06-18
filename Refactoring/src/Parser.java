import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import at.edu.hti.shop.Customer;
import at.edu.hti.shop.OrderLine;
import at.edu.hti.shop.Product;

public class Parser {

	public void handelCustomer(ProductFactory factory, InputStream input,
			Customer customer) {
		customer.startsOrder();

		System.out.print("Willkommen bei YASCLS!\n>");

		BufferedReader in = new BufferedReader(new InputStreamReader(input));

		String line = "";
		try { // read from inputStream
			while ((line = in.readLine()) != null) { // list products
				if ("l".equalsIgnoreCase(line)) {
					System.out.println("Liste der Produkte:");

					factory.listProducts();

					System.out.println("");
				}
				// print order
				if ("o".equalsIgnoreCase(line)) {
					customer.printOrder();
					System.out.println("");
				}
				// exit
				if ("e".endsWith(line)) {
					System.out.println("Auf Wiedersehen");
					break;
				}

				if (line.startsWith("a")) {

					System.out.println("Bestellung:");

					String[] tokens = line.split(" ");
					String id = tokens[1];
					int count = Integer.parseInt(tokens[2]);

					Product temp = factory.getProduct(id);

					OrderLine orderLine = new OrderLine();
					orderLine.setProduct(temp);
					orderLine.setCount(count);
					customer.getOrder().add(orderLine);
					System.out.println(count + " " + temp.getName());
				}
				System.out.print(">");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
