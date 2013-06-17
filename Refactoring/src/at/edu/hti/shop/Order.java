package at.edu.hti.shop;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Gerhard Fliess
 *
 */
public class Order
{

  private ArrayList<OrderLine> orderLines_ = new ArrayList<OrderLine>();

  public Collection<OrderLine> getOrderLines()
  {
    return orderLines_;
  }
}
