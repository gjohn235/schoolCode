package factorial;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Factorial implements Iterable<Integer>
{
  private int lowerLim, upperLim;
  
  public Factorial(int lowerLimit, int upperLimit)
  {
    lowerLim = lowerLimit;
    upperLim = upperLimit;
  }
  
  public class MyIterator implements Iterator<Integer>
  {
    public boolean hasNext()
    {
      if(lowerLim <= upperLim)
      {
        return true;
      }
      else
      {
        return false;
      }
    }
    
    public Integer next()
    {
      if(hasNext() == true)
      {
    	int fact = 1;
    	
    	for(int g = lowerLim; g > 1; g--)
    	{
          fact *= g;
    	}
    	lowerLim += 1;
    	return fact;
      }
      else
      {
        throw new NoSuchElementException();
      }
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }

  public String toString()
  {
	String factString = "";
	MyIterator iter = new MyIterator();
	
	while(iter.hasNext() == true)
	{
	  factString += iter.next() + " ";
	}
    return factString;
  }

  public static void main(String args[])
  {
    Factorial f= new Factorial(2, 5);
    System.out.println(f);  // calls toString()
  }

  @Override
  public Iterator<Integer> iterator()
  {
	return new MyIterator();
  }
}
