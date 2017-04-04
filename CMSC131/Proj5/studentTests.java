import junit.framework.TestCase;

public class StudentTests extends TestCase
{
  public void testAdd()
  {
    MyDouble g = new MyDouble(5.0), j = new MyDouble(6.0);
    MyDouble t = new MyDouble(5.0), c = new MyDouble(6.0);
    MyDouble ten = new MyDouble(10.0), twelve = new MyDouble(12.0);
    ComplexNumber d = new ComplexNumber(g, j);
    ComplexNumber x = new ComplexNumber(t, c);
    ComplexNumber v = new ComplexNumber(ten, twelve);
    assertTrue((d.add(x)).equals(v));
  }
  public void testSubtract()
  {
    MyDouble g = new MyDouble(10.0), j = new MyDouble(12.0);
    MyDouble t = new MyDouble(5.0), c = new MyDouble(6.0);
    MyDouble five = new MyDouble(5.0), six = new MyDouble(6.0);
    ComplexNumber d = new ComplexNumber(g, j);
    ComplexNumber x = new ComplexNumber(t, c);
    ComplexNumber v = new ComplexNumber(five, six);
    assertTrue((d.subtract(x)).equals(v));
  }
  public void testMult()
  {
    MyDouble g = new MyDouble(-2.0), j = new MyDouble(5.0);
    MyDouble t = new MyDouble(9.0), c = new MyDouble(-4.0);
    MyDouble two = new MyDouble(2.0), fiftyThree = new MyDouble(53.0);
    ComplexNumber d = new ComplexNumber(g, j);
    ComplexNumber x = new ComplexNumber(t, c);
    ComplexNumber v = new ComplexNumber(two, fiftyThree);
    assertTrue((d.multiply(x)).equals(v));
  }
  public void testDiv()
  {
    MyDouble g = new MyDouble(16.0), j = new MyDouble(-2.0);
    MyDouble t = new MyDouble(3.0), c = new MyDouble(-2.0);
    MyDouble four = new MyDouble(4.0), two = new MyDouble(2.0);
    ComplexNumber d = new ComplexNumber(g, j);
    ComplexNumber x = new ComplexNumber(t, c);
    ComplexNumber v = new ComplexNumber(four, two);
    assertTrue((d.divide(x)).equals(v));
  }
  public void testString()
  {
    MyDouble g = new MyDouble(-5.0), j = new MyDouble(-6.0);
    ComplexNumber d = new ComplexNumber(g, j);
    assertEquals(d.toString(),"-5.0-6.0i");
  }
  public void testEqComp()
  {
    MyDouble g = new MyDouble(5.0), j = new MyDouble(6.0);
    MyDouble t = new MyDouble(5.0), c = new MyDouble(6.0);
    MyDouble ten = new MyDouble(10.0), twelve = new MyDouble(12.0);
    ComplexNumber d = new ComplexNumber(g, j);
    ComplexNumber x = new ComplexNumber(t, c);
    ComplexNumber v = new ComplexNumber(ten, twelve);
    assertTrue((d.add(x)).equals(v));
  }
  public void testNorm()
  {
    MyDouble g = new MyDouble(5.0), j = new MyDouble(6.0);
    MyDouble t = new MyDouble(5.0), c = new MyDouble(6.0);
    MyDouble ten = new MyDouble(10.0), twelve = new MyDouble(12.0);
    ComplexNumber d = new ComplexNumber(g, j);
    ComplexNumber x = new ComplexNumber(t, c);
    ComplexNumber v = new ComplexNumber(ten, twelve);
    assertTrue((d.add(x)).equals(v));
  }
  public void testParse()
  {
    MyDouble g = new MyDouble(5.0), j = new MyDouble(6.0);
    MyDouble t = new MyDouble(5.0), c = new MyDouble(6.0);
    MyDouble ten = new MyDouble(10.0), twelve = new MyDouble(12.0);
    ComplexNumber d = new ComplexNumber(g, j);
    ComplexNumber x = new ComplexNumber(t, c);
    ComplexNumber v = new ComplexNumber(ten, twelve);
    assertTrue((d.add(x)).equals(v));
  }
}
