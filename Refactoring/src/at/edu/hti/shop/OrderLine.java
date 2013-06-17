package at.edu.hti.shop;

/**
 * @author Gerhard Fliess
 *
 */
public class OrderLine
{
  private Product product_;
  private int count_;

  public int getCount()
  {
    return count_;
  }

  public void setCount(int count)
  {
    count_ = count;
  }

  public Product getProduct()
  {
    return product_;
  }

  public void setProduct(Product product)
  {
    product_ = product;
  }


}
