import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import at.edu.hti.shop.Customer;
import at.edu.hti.shop.OrderLine;
import at.edu.hti.shop.Product;
import at.edu.hti.shop.Session;

/**
 * @author Gerhard Fliess
 */
public class Main
{

  public static void main(String[] args)
  {
    Properties products = null;
    Customer customer = new Customer();
    Session session = new Session();
    customer.startsOrder();

    System.out.print("Willkommen bei YASCLS!\n>");
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line = "";
    try
    { // read from inputStream
      while ((line = in.readLine()) != null)
      { // list products
        if ("l".equalsIgnoreCase(line))
        {
          System.out.println("Liste der Produkte:");
          if (products == null)// Produkte initialisiert?
          {
            products = new Properties();
            products.load(new FileInputStream("products.properties"));
          }
          int count = 1;
          while (products.containsKey(count + ".name"))
          {
            System.out.println(count + ": "
                + products.getProperty(count + ".name"));
            count++;
          }
          System.out.println("");
        }
        // print order
        if ("o".equalsIgnoreCase(line))
        {
          session.printOrder(customer);
          System.out.println("");
        }
        // exit
        if ("e".endsWith(line))
        {
          System.out.println("Auf Wiedersehen");
          break;
        }

        if (line.startsWith("a"))
        {

          System.out.println("Bestellung:");

          String[] tokens = line.split(" ");
          String id = tokens[1];
          int count = Integer.parseInt(tokens[2]);

          if (products == null)// Produkte initialisiert?
          {
            products = new Properties();
            products.load(new FileInputStream("products.properties"));
          }
          Product temp = null;
          if (products.containsKey(id + ".name"))
          {
            temp = new Product();
            temp.setId(id);
            temp.setName(products.getProperty(id + ".name"));
            temp
                .setPrice(Float.parseFloat(products.getProperty(id + ".prize")));
          } else
          {
            System.out.println("Produkt nicht verfügbar");
          }

          OrderLine orderLine = new OrderLine();
          orderLine.setProduct(temp);
          orderLine.setCount(count);
          customer.getOrder().getOrderLines().add(orderLine);
          System.out.println(count + " " + temp.getName());
        }
        System.out.print(">");
      }

    } catch (IOException e)
    {
      e.printStackTrace();
    }

  }
}
