public class AlphaList
{
  public String[][] list;  // leave this field public for testing purposes

  public AlphaList()
  {
    list = new String[26][0];
  }
  public void insert(String value)
  {
    int g, start = value.charAt(0), index = start - 65;
    String[] oneBigger = new String [list[index].length + 1];
    
    for (g = 0; g < list[index].length; g++)
    {
      oneBigger[g] = list[index][g];
    }
    oneBigger[oneBigger.length - 1] = value;
    list[index] = oneBigger;
  }
  public int count()
  {
    int g, summed = 0;
    
    for (g = 0; g < 26; g++)
    {
      summed += list[g].length;
    }
    return summed;
  }
  public void remove(String value)
  {
    int g, j, start = value.charAt(0), index = start - 65;;
    String[] oneSmaller = new String[list[index].length - 1];
    
    for (j = 0, g = 0; g < list[index].length; j++, g++)
    {
      if (value.equals(list[index][g]))
      {
        g++;
      }
      oneSmaller[j] = list[index][g];
    }
    list[index] = oneSmaller;
  }
}
