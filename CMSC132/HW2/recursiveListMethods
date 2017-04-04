package recursiveListMethods;

import java.util.*;

public class RecursiveListMethods
{
  public static <T> void duplicateFirst(List<T> list)
  {
	if(list == null)
	{ //Directions say this might should happen automatically, just to be safe
	  throw new NullPointerException("Object null");
	}
	else
	{
	list = duplicateFirst(list, 0);
	} //Here we call helper method which has same name, different parameters
  }
	
  //Prohibiting the use of field variables made utilizing position counter very
  //challenging. Helper method makes things easier. Just like class examples, I
  //give the user a simple input while creating my own overriding method which
  //can use position counter.
  private static <T> List<T> duplicateFirst(List<T> list, int pos)
  {
    if(pos < list.size())
    {
      list.set(pos, list.get(0));
      return duplicateFirst(list, pos + 1);
    } //The recusrsion where I can continuously increment pos just like in class
    else
    {
      return list;
    }
  }
  
  //These two methods have same exact principle of the two before them, only
  //difference is we copy in the last element
  public static <T> void duplicateLast(List<T> list)
  {
    if(list == null)
	{
	  throw new NullPointerException("Object null");
	}
    else
    {
    list = duplicateLast(list, 0);
    }
  }
  
  private static <T> List<T> duplicateLast(List<T> list, int pos)
  {
    if(pos < list.size())
    {
      list.set(pos, list.get(list.size() - 1));
      return duplicateLast(list, pos + 1);
    }
    else
    {
      return list;
    }
  }

  //Again an overriding help method does the main job
  public static <T> boolean anyDuplicates(List<T> list)
  {
	if(list.isEmpty() == true)
	{ //Pretty sure if Linked List is empty it's the same as being null...
	  return false;
	}
	else
	{
	  return anyDuplicates(list, 0);
	}
  }
  
  private static <T> boolean anyDuplicates(List<T> list, int pos)
  {
    if(pos < list.size())
    {
      ArrayList<T> newFormat = new ArrayList<T>();
      newFormat.addAll(list); //addAll method allows workaround of banned loops
      newFormat.remove(list.get(pos));
      //Take out ArrayList element that corresponds to original list
      if(newFormat.contains(list.get(pos)))
      { //.contains is my implicit call of the equals method
        return true;
      } //If a matching element still exist within arrayList, must be duplicate
      else
      {
        return anyDuplicates(list, pos + 1);
      }
    }
    else
    {
      return false;
    } //Reaching this point means we ran through entire list and never found
  }   //a duplicate

  //Yet again overriding helper method does the job. Notice this time I have an
  //extra third parameter. Loop restriction requires this be how I store the
  //largest element
  public static <T extends Comparable<T>> T findLargest(List<T> list)
  {
	if(list.isEmpty())
	{
	  throw new NoSuchElementException("Object empty");
	}
	else
	{
	  return findLargest(list, 0, list.get(0));
	}
  }
  
  private static <T extends Comparable<T>> T findLargest(List<T> list, int pos,
		                                                              T largest)
  {
    if(pos < list.size())
    {
      if(list.get(pos).compareTo(largest) > 0)
      { //If bigger we have our new largest
    	largest = list.get(pos);
        return findLargest(list, pos + 1, largest);
      }
      else
      { //Else largest never changes
        return findLargest(list, pos + 1, largest);
      }
    }
    else
    {
    return largest;
    }
  }
}
