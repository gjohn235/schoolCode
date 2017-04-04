public class ComplexNumber //Arithmetic with imaginary numbers
{
  private final MyDouble real; //to be initialized in the constructors
  private final MyDouble imag; //to be initialized in the constructors

  public ComplexNumber(MyDouble real, MyDouble imag)
  {
    this.real = real; //Initializing my instance variables
    this.imag = imag; //with two parameter constructor
  }
  public ComplexNumber(MyDouble real)
  {
    MyDouble imagZero = new MyDouble(0.0); //MyDouble not compatible with
    this.real = real;                      //a double number variable
    imag = imagZero;                       //new MyDouble needed
  }
  public ComplexNumber(ComplexNumber c)
  {
    real = c.real; // Simple copy constructor on immutable variables
    imag = c.imag;
  }
  public MyDouble getReal()
  {
    return real; // Easy getter for real portion of complex number
  }
  public MyDouble getImag()
  {
    return imag; // Easy getter for imaginary portion of complex number
  }
  public ComplexNumber add(ComplexNumber x) {
    ComplexNumber added = new ComplexNumber(real.add(x.real), imag.add(x.imag));
    return added; //Little more complicated, although x itself was a single
  }               //needed both parts of a complex number
  public ComplexNumber subtract(ComplexNumber x)
  {
    ComplexNumber subtracted = new ComplexNumber(real.subtract(x.real),
        imag.subtract(x.imag));
    return subtracted; //Same as add method
  }
  public ComplexNumber multiply(ComplexNumber x)
  { //Just following the examples Project 5 gave me
    ComplexNumber multiplied = new ComplexNumber(real.multiply(x.real)
        .subtract((imag.multiply(x.imag))), (real.multiply(x.imag)).add(imag
        .multiply(x.real)));
    return multiplied;
  }
  public ComplexNumber divide(ComplexNumber x){
    ComplexNumber divided = new ComplexNumber((real.multiply(x.real).add(imag
        .multiply(x.imag))).divide(((x.real).multiply(x.real)).add((x.imag)
        .multiply(x.imag))), (((imag.multiply(x.real)).subtract(real
        .multiply(x.imag))).divide(((x.real).multiply(x.real)).add((x.imag)
        .multiply(x.imag)))));
    return divided; //Dividing with "i" truly is a pain, important part is that
  }                 //it all shakes out and works
  public boolean equals(ComplexNumber c)
  {
    if (real.equals(c.real) && imag.equals(c.imag)) //Simple equals check
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  public static MyDouble norm(ComplexNumber c)
  {
    MyDouble squared = new MyDouble(c.real.multiply(c.real).add
                                   (c.imag.multiply(c.imag)));
    MyDouble norm = new MyDouble(squared.sqrt());
    return norm;
  } //Multiply each part by itself then take square root for norm
  public int compareTo(ComplexNumber c)
  { // Calling compareTo for my compareTo
    ComplexNumber object = new ComplexNumber(real, imag);
    if (norm(object).compareTo(norm(c)) == 0)
    {
      return 0;
    }
    else if (norm(object).compareTo(norm(c)) == -1)
    {
      return -1;
    }
    else
    {
      return 1;
    }
  }
  public static ComplexNumber parseComplexNumber(String s) {
    int g, endOfReal;
    String realS, imagS;
    String y = s.replace(" ", "");

    for (g = 0; g < y.length(); g++) {
      if (y.charAt(g) == '-' || y.charAt(g) == '+') {
        endOfReal = g;
      }
    }
    endOfReal = g;
    realS = y.substring(0, endOfReal);

    if (y.charAt(endOfReal) == '-') {
      imagS = y.substring(endOfReal, y.length() - 1);
    } else {
      imagS = y.substring(endOfReal + 1, y.length() - 1);
    }
    Double realDouble = Double.parseDouble(realS);
    Double imagDouble = Double.parseDouble(imagS);
    MyDouble realMyDouble = new MyDouble(realDouble);
    MyDouble imagMyDouble = new MyDouble(imagDouble);
    ComplexNumber what = new ComplexNumber(realMyDouble, imagMyDouble);
    return what;
  }

  public String toString()
  { // One output for all possible sign values
    MyDouble zero = new MyDouble(0.0);
    if ((real.compareTo(zero) > 0) && imag.compareTo(zero) > 0)
    {
      return real.toString() + "+" + imag.toString() + "i";
    }
    else if ((real.compareTo(zero) < 0) && imag.compareTo(zero) > 0)
    {
      return real.toString() + "+" + imag.toString() + "i";
    }
    else if ((real.compareTo(zero) > 0) && imag.compareTo(zero) < 0)
    {
      return real.toString() + imag.toString() + "i";
    }
    else if ((real.compareTo(zero) < 0) && imag.compareTo(zero) < 0)
    {
      return real.toString() + imag.toString() + "i";
    }
    else
    {
      return "";
    }
  }
}
