package at.edu.hti.shop;

/**
 * @author Gerhard Fliess
 * 
 */
public class Product {
	private double price_;
	private String name_;
	private final String id_;

	public Product(String id_) {
		super();
		this.id_ = id_;
	}

	public double getPrice() {
		return price_;
	}

	public void setPrice(double price) {
		price_ = price;
	}

	public void setName(String name) {
		name_ = name;
	}

	public String getId() {
		return id_;
	}

	public String getName() {
		return name_;
	}

	public double getPrize() {
		return price_;
	}

	public String toString() {
		return id_ + " " + name_ + "," + price_;
	}
}
