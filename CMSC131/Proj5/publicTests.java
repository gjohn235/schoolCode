import junit.framework.TestCase;

public class PublicTests extends TestCase
{
  public void testBasicConstructorsAndGetters()
  {
    MyDouble a= new MyDouble(5.7), b= new MyDouble(-3.7), 
             d= new MyDouble(555.729);
    ComplexNumber x= new ComplexNumber(a, b), z= new ComplexNumber(d);

    assertTrue(x.getReal().compareTo(a) == 0 && x.getImag().compareTo(b) == 0);
    assertTrue(z.getReal().compareTo(d) == 0 &&
               z.getImag().compareTo(new MyDouble(0)) == 0);
  }
  public void testCopyConstructor()
  {
    MyDouble a= new MyDouble(5.7), b= new MyDouble(-3.7);
    ComplexNumber x= new ComplexNumber(a, b), y= new ComplexNumber(x);

    assertTrue(x != y);  // check to be sure they are not aliased!
    assertTrue(y.getReal().compareTo(a) == 0 && y.getImag().compareTo(b) == 0);
  }
}
