import java.io.FileNotFoundException;
import java.io.IOException;

import at.edu.hti.shop.Product;

public interface ProductFactory {

	public abstract Product getProduct(String id) throws IOException,
			FileNotFoundException;

	public abstract void listProducts();

}