package at.edu.hti.shop;

import java.util.Collection;
import java.util.Iterator;

/**
 * Verwaltet einen Session in einem Shop
 * 
 * @author Gerhard Fliess
 */
public class Session
{
  public void printOrder(Customer customer)
  {
    System.out.println("Bestellung:");
    // ^^^ eigentlich eine globale Variable ...
    // Was machen sie mit einem Singleton??

    // Sie müssen relativ viel über Kunden, Produkte und
    // Bestellungen wissen
    Collection<OrderLine> orderLines = customer.getOrder().getOrderLines();
    // ok ^
    float sum = 0;
    for (Iterator<OrderLine> iter = orderLines.iterator(); iter.hasNext();)
    {
      OrderLine temp = (OrderLine) iter.next();
      sum += temp.getProduct().getPrize() * temp.getCount();
    }

    StringBuffer result = new StringBuffer();
    for (Iterator<OrderLine> iter = orderLines.iterator(); iter.hasNext();)
    {
      OrderLine temp = (OrderLine) iter.next();
      result.append(temp.getCount());
      result.append(" ");
      result.append(temp.getProduct().getName());
      result.append(" ");
    }

    String outResult = result.toString() + "\n Preis:" + sum;

    System.out.println(outResult);

  }

  public void printAsXML(Customer customer)
  {
    System.out.println("Order");

    Collection<OrderLine> orderLines = customer.getOrder().getOrderLines();

    float sum = 0;
    for (Iterator<OrderLine> iter = orderLines.iterator(); iter.hasNext();)
    {
      OrderLine temp = (OrderLine) iter.next();
      sum += temp.getProduct().getPrize() * temp.getCount();
    }

    StringBuffer result = new StringBuffer();
    result.append("<order>");
    for (Iterator<OrderLine> iter = orderLines.iterator(); iter.hasNext();)
    {
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

}
