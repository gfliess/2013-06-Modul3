package at.edu.hti.shop;

/**
 * @author Gerhard Fliess
 *
 */
public class Customer
{
  private Order order_;
  private String name_;

  public void startsOrder()
  {
    order_ = new Order();
  }

  public String getName()
  {
    return name_;
  }


  public void setName(String name)
  {
    name_ = name;
  }


  public void setOrder(Order order)
  {
    order_ = order;
  }


  public Order getOrder()
  {
    return order_;
  }
}
