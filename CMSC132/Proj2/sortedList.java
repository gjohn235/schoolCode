package list;

import java.util.Comparator;
import java.lang.IndexOutOfBoundsException;
import java.util.NoSuchElementException;
/*
 * This is the sorted list class. Same exact code as the unsorted, with the
 * exception of the add metod which needed various tweaks to achieve desired
 * results. These changes are described in the add method itself.
 * Other than that the code is identical, everything works as it should,
 * with methods like isEmpty and clear not being needed to be overridden.
 * The more important things like toString were copied over.
 */
import list.List.Node;

public class SortedList<T> extends List<T>
{

  public SortedList(Comparator<T> comparator)
  {
    super(comparator);
  }

  public List<T> add(T newElt)
  {
    Node<T> node = new Node<T>();
    Node<T> backNode = null;   //This is important for sorting correctly,
    this.currNode = this.head; //Like a doubly linked list
    
    if(this.head == null)
    {
      node.data = newElt;
      this.head = node;
      this.head.next = null; //If this is the first element, set it to head
    }
    else
    { 
      while(this.currNode != null)
      {
    	if(comp.compare(this.currNode.data, newElt) < 0)
    	{ //When current is less than what's added keep moving foward
    	  backNode = this.currNode;
          this.currNode = this.currNode.next;
    	}
    	else
    	{
    	  if(comp.compare(currNode.data, newElt) >= 0)
    	  { //If greater or equal run through here
    	    if(backNode == null)
    	    { //If back has yet to be assigned we set head to the new elt
    	      this.head = node;
    	    }
    	    else
    	    { //Otherwise we set it to the node behind it's next
    	      backNode.next = node;
    	    }
    	    node.data = newElt;
    	    node.next = this.currNode;
    	    return this;
    	  }
    	}
      } //Finally break the while loop and assign everything in order
      node.data = newElt;
      node.next = null;
      backNode.next = node;
    }
    return this;                
  }
  
  public T get(int index) throws IndexOutOfBoundsException
  {
	if(this.head == null) //Check for empty right off the top
	{
	  return null;
	}
	
	if(index < 0) //Special case if negative
	{
      throw new IndexOutOfBoundsException("IndexOutOfBounds");
	}
	
	if(index == 0) //Special case if zero
	{
      return this.head.data;
	}
	
	this.currNode = this.head;
 
    for(int g = 1; g <= index; g++) //Keep updating current node until we reach
    {                               //the index wanted
      this.currNode = this.currNode.next;
      
      if(this.currNode == null) //If we ever reach null index was too big
      {
        throw new IndexOutOfBoundsException("IndexOutOfBounds");
      }
    } //If we reach this point, we have desired index
    return this.currNode.data;
  }
  
  public T lookup(T element)
  {
    if(this.head == null) //Check empty from the start
    {
      return null;
    }
   
    this.currNode = this.head;
   
    while(this.currNode != null)
    {
      if(comp.compare(this.currNode.data, element) == 0)
      {
        return currNode.data;
      }
      else //If not identical move to next list node
      {
        this.currNode = this.currNode.next;
      }
   	} //If we break the while loop that means no objects were equal
    return null;
  }
 
  public List<T> delete(T element) throws NoSuchElementException
  { //Slight adaptation from copied lookUp method
    if(this.head == null) //Check empty from the start
    {
      return this;
    }
   
    this.currNode = this.head;
    boolean firstEltFound = false;
    
    if(comp.compare(this.head.data, element) == 0) //Special case delete head
    {
      this.head = this.head.next;
    }
   
    while(this.currNode.next != null && firstEltFound == false)
    {
      if(comp.compare(this.currNode.next.data, element) == 0)
      {
        this.currNode.next = this.currNode.next.next;
        firstEltFound = true; //Exit after first match is found
      }
      else //If not identical move to next list node
      {
        this.currNode = this.currNode.next;
      }
   	} //No matter if anything is removed or not return the list
    return this;
  }

  public void replace(T oldElt, T newElt) throws NoSuchElementException
  { //Slight adaptation from delete
    if(this.head == null) //Check empty from the start
    {
	  throw new NoSuchElementException("NoSuchElement");
    }
   
    this.currNode = this.head;
    boolean firstEltFound = false;
    
    if(this.currNode.data.equals(oldElt)) //Special case replace head
    {
      this.head.data = newElt;
      firstEltFound = true;
    }
       
    while(this.currNode.next != null && firstEltFound == false)
    {
      if(this.currNode.next.data.equals(oldElt))
      {
        this.currNode.next.data = newElt;
        firstEltFound = true; //Exit after first replacement
      }                       //I don't throw in a new node, just swap out data
      else //If not identical move to next list node
      {
        this.currNode = this.currNode.next;
      }
   	}
    if(firstEltFound == false) //Upon exit check if replacement occured
    {                          //If not throw the exception
      throw new NoSuchElementException("NoSuchElement");
    }
  }

  public T getLargest() throws NoSuchElementException
  { //Slight adaptation from replace
    if(this.head == null) //Check empty from the start
    {
	  throw new NoSuchElementException("NoSuchElement");
    }
    
    this.currNode = this.head;
    Node<T> largest = new Node<T>();
    largest.data = this.currNode.data;
       
    while(this.currNode.next != null)
    {
      if(comp.compare(this.currNode.next.data, largest.data) > 0)
      { //Call comparator and check if positive return
        largest.data = this.currNode.next.data;
        this.currNode = this.currNode.next;
      } //If true make this bigger node largest's data
      else //If not bigger move to next list node
      {
        this.currNode = this.currNode.next;
      }
   	}
    return largest.data;
  }

  public T getSmallest() throws NoSuchElementException
  { //Carbon copy of get largest, changed a variable name and flipped sign
    if(this.head == null) //Check empty from the start
    {
	  throw new NoSuchElementException("NoSuchElement");
    }
    
    this.currNode = this.head;
    Node<T> smallest = new Node<T>();
    smallest.data = this.currNode.data;
       
    while(this.currNode.next != null)
    {
      if(comp.compare(this.currNode.next.data, smallest.data) < 0)
      { //Call comparator and check if negative return
        smallest.data = this.currNode.next.data;
        this.currNode = this.currNode.next;
      } //If true make this smaller node largest's data
      else //If not smaller move to next list node
      {
        this.currNode = this.currNode.next;
      }
   	}
    return smallest.data;
  }

  public String toString()
  {
    String listString = "";
    if(this.head == null) //If empty return empty string
    {
      return listString;
    }
    else
    { 
      this.currNode = this.head;
      
      listString += this.currNode.data.toString(); //toString the head NO space
      
      while(this.currNode.next != null)
      {
    	this.currNode = this.currNode.next;
        listString += " " + this.currNode.data.toString();
      } //Everything else prints a space before, never after
    }
    return listString;
  }
}
