package bag;

// you can add more imports if you need
import java.util.HashMap;
import java.util.Set;

public class Bag
{
  HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
  
  public void add(int elt)
  {
    if(hashMap.containsKey(elt))
    {
      int oldValue = hashMap.get(elt);
      int newValue = oldValue + 1; 
      hashMap.put(elt, newValue);
    }
    else
    {
      hashMap.put(elt, 1);
    }
  }

  public boolean contains(int elt)
  {
    return hashMap.containsKey(elt);
  }

  public int getCount(int elt)
  {
	if(hashMap.containsKey(elt))
	{
      return hashMap.get(elt);
	}
	else
	{
	 return 0;
	}
    
  }

  public int size()
  {
	int number = 0;
	
    for(Integer key : hashMap.keySet())
    {
      number += hashMap.get(key);
    }
    return number;
  }

  public Set<Integer> uniqueElements()
  {
    return hashMap.keySet();
  }

  public void remove(int elt)
  {
    if(hashMap.containsKey(elt))
    {
      if(hashMap.get(elt) == 1)
      {
        hashMap.remove(elt);
      }
      else
      {
        int oldValue = hashMap.get(elt);
        int newValue = oldValue--;
        hashMap.put(elt, newValue);
      }
    }
  }
}
