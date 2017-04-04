public class NumberList
{
  public int[] values;
	
  public NumberList()
  {
    values = new int[0];
  }
  public NumberList(int[] a)
  {
    values = new int[a.length];
    for (int g = 0; g < a.length; g++)
    {
      values[g] = a[g];
    }
  }
  public int getSize()
  {
    return values.length;
  }
  public int getAt(int position)
  {
    if(position > 0 || position <= values.length)
    {
      return values[position];
    }
    else
    {
      throw new IndexOutOfBoundsException ("You done goofed!");
    }
  }
  public int getTotal()
  {
    int summed = 0;
    for (int g = 0; g < values.length; g++)
    {
      summed = summed + values[g];
    }
    return summed;
  }
  public boolean contains(int number)
  {
    int g;
    for (g = 0; g < values.length; g++)
    {
      if (number == values[g])
      {
        return true;
      }
    }
    return false;
  }
  public void add(int number)
  {
    int bigger = values.length + 1;
    int[] oneBigger = new int[bigger];
    for (int g = 0; g < values.length; g++)
    {
      oneBigger[g] = values[g];
    }
    oneBigger[values.length] = number;
    values = oneBigger;
  }
}
