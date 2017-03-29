import java.util.Scanner;
public class Fraction
{
  int numerator, denominator;
  Scanner scan = new Scanner(System.in);
  
  public Fraction(int numeratorIn, int denominatorIn)
  {
    numerator = numeratorIn;
    denominator = denominatorIn;
  }
  public Fraction(int numeratorIn)
  {
    numerator = numeratorIn;
    denominator = 1;
  }
  public Fraction()
  { 
  }
  public int getNum()
  {
    return numerator;
  }
  public int getDen()
  {
    return denominator;
  }
  public String toString()
  {
    return numerator + "/" + denominator;
  }
  public Fraction reciprocal()
  {
    Fraction reciprocal = new Fraction(denominator, numerator);
    return reciprocal;
  }
  public Fraction product(Fraction frac)
  {
    int numeratorIn = numerator*frac.getNum();
    int denominatorIn = denominator*frac.getDen();
    Fraction product = new Fraction(numeratorIn, denominatorIn);
    return product;
  }
  public Fraction quotient(Fraction frac)
  {
    int numeratorIn = numerator*frac.getDen();
    int denominatorIn = denominator*frac.getNum();
    Fraction quotient = new Fraction(numeratorIn, denominatorIn);
    return quotient;
  }
  public Fraction sum(Fraction frac)
  {
    int numeratorIn = (numerator*frac.getDen())+(frac.getNum()*denominator);
    int denominatorIn = denominator*frac.getDen();
    Fraction sum = new Fraction(numeratorIn, denominatorIn);
    return sum;
  }
  public boolean equals(Fraction frac)
  {
    if(frac != null)
    {
    if (numerator == frac.getNum() && denominator == frac.getDen())
    return true;
    else  
      return false;
    }
    else
      return false;  
  }
}
