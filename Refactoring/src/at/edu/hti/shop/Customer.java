package at.edu.hti.shop;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author Gerhard Fliess
 * 
 */
public class Customer {
	private Order order_;
	private String name_;

	public void startsOrder() {
		order_ = new Order();
	}

	public String getName() {
		return name_;
	}

	public void setName(String name) {
		name_ = name;
	}

	public void setOrder(Order order) {
		order_ = order;
	}

	public Order getOrder() {
		return order_;
	}

	public void printAsXML() {
		System.out.println("Order");

		Order order = getOrder();
		Collection<OrderLine> orderLines = order.getOrderLines();

		float sum = order.calcPrice();

		StringBuffer result = new StringBuffer();
		result.append("<order>");
		for (Iterator<OrderLine> iter = orderLines.iterator(); iter.hasNext();) {
			OrderLine temp = (OrderLine) iter.next();
			result.append(temp.getCount());
			result.append("<line><product><name>");
			result.append(temp.getProduct().getName());
			result.append("</name><price>");
			result.append(temp.getProduct().getPrize());
			result.append("</price></product>");
		}
		result.append("<sum>" + sum + "</sum>");
		result.append("</order>");

		String rest = result.toString();

		System.out.println(rest);

	}

	public void printOrder() {
		System.out.println("Bestellung:");
		// ^^^ eigentlich eine globale Variable ...
		// Was machen sie mit einem Singleton??

		// Sie müssen relativ viel über Kunden, Produkte und
		// Bestellungen wissen
		Order order = getOrder();
		Collection<OrderLine> orderLines = order.getOrderLines();
		// ok ^
		float sum = order.calcPrice();

		StringBuffer result = new StringBuffer();
		for (Iterator<OrderLine> iter = orderLines.iterator(); iter.hasNext();) {
			OrderLine temp = (OrderLine) iter.next();
			result.append(temp.getCount());
			result.append(" ");
			result.append(temp.getProduct().getName());
			result.append(" ");
		}

		String outResult = result.toString() + "\n Preis:" + sum;

		System.out.println(outResult);

	}
}
