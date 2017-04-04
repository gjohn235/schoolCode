package multimap;

// you can add imports if you need
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Multimap
{
  HashMap<Character, ArrayList<Integer>> hashMap =
		  new HashMap<Character, ArrayList<Integer>>();
  
  public void put(Character key, Integer value)
  {
    ArrayList<Integer> values = new ArrayList<Integer>();
	if(hashMap.containsKey(key))
	{
	  hashMap.get(key).add(value);
	}
	else
	{
	  values.add(value);
	  hashMap.put(key, values);
	}
  }

  public List<Integer> get(Object key)
  {
    if(hashMap.containsKey(key))
	{
	  return hashMap.get(key);
	}
    else
    {
	  return null;
	}
  }

  public int size()
  {
    int count = 0;
	for(ArrayList<Integer> x: hashMap.values())
	{
	  count += x.size();
	}
	return count;
  }

  public void remove(Character key, Integer value)
  {
    if(hashMap.containsKey(key) && hashMap.get(key).contains(value))
    {
	  if(hashMap.get(key).size() == 1)
	  {
	    hashMap.remove(key);
	  }
	  else
	  {
	    hashMap.get(key).remove(value);
	  }
	}
  }
}
