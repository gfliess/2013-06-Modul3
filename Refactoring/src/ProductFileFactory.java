import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import at.edu.hti.shop.Product;

public class ProductFileFactory implements ProductFactory {

	private Properties products;

	public ProductFileFactory() throws FileNotFoundException, IOException {
		loadProducts();
	}

	/* (non-Javadoc)
	 * @see ProductFactory#getProduct(java.lang.String)
	 */
	@Override
	public Product getProduct(String id) throws IOException,
			FileNotFoundException {
		Properties products;
		products = loadProducts();
		Product temp = null;
		if (products.containsKey(id + ".name")) {
			temp = new Product(id);

			temp.setName(products.getProperty(id + ".name"));
			temp.setPrice(Float.parseFloat(products.getProperty(id + ".prize")));
		} else {
			System.out.println("Produkt nicht verfügbar");
		}
		return temp;
	}

	/* (non-Javadoc)
	 * @see ProductFactory#listProducts()
	 */
	@Override
	public void listProducts() {
		int count = 1;
		while (products.containsKey(count + ".name")) {
			System.out.println(count + ": "
					+ products.getProperty(count + ".name"));
			count++;
		}
	}

	private Properties loadProducts() throws IOException, FileNotFoundException {

		products = new Properties();
		products.load(new FileInputStream("products.properties"));

		return products;
	}

}
