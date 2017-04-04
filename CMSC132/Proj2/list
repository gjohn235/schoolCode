package list;

import java.util.Comparator;
import java.lang.Iterable;
import java.util.Iterator;
import java.lang.IndexOutOfBoundsException;
import java.util.NoSuchElementException;
/*
 * This is the unsorted list class. Pretty straight forward, it handles all the
 * basic functions any linked list class should. We have the ability to add
 * and delete nodes from a list by switching around a couple of references,
 * return values within those nodes etc... The use of inner classes makes
 * implementing iterators much easier, inner class can be found at the end of
 * this class.
 */
public class List<T> implements Iterable<T>, Comparable<List<T>>
{
  protected Comparator<T> comp; //Needed for first constructor
  protected Node<T> head; //Have to make your own head and current
  protected Node<T> currNode;
  // You may not change this inner class! OKAY!
  protected class Node<D>
  {
    D data;
    Node<D> next;
  }

  public List(Comparator<T> comparator) //Simple constructor
  {
	this.head = null;
	this.currNode = this.head;
	comp = comparator;
  }

  public List(List<T> otherList) //Simple Copy constructor
  {
    this.head = otherList.head;
    this.comp = otherList.comp;
    otherList.currNode = otherList.head.next;
    this.currNode = otherList.currNode;
 
    while(this.currNode != null) //Copy in all node data
    {
      Node<T> node = new Node<T>();
      node.data = this.currNode.data;
      this.currNode = otherList.currNode.next;
    }
  }

  public List<T> add(T newElt)
  {
    Node<T> node = new Node<T>();
    node.data = newElt; //Makes the data in the new node the new element
    if(this.head == null)
    {
      this.head = node;
      this.head.next = null; //If this is the first element, set it to head
    }
    else
    {
      this.currNode = this.head;
      
      while(this.currNode != null)
      {
    	if(this.currNode.next != null)
    	{
          this.currNode = this.currNode.next; //This is used to loop to end of
    	}                                     //list
    	else
    	{
    	  this.currNode.next = node;
    	  this.currNode = this.currNode.next; //Finally reach end of list where
    	  return this;                        //new node is added
    	}
      }
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

  public int size()
  {
    int count = 0;
    
    if(this.head == null) //Check empty at start
    {
     return count;
    }
    
    count++; //Make list size 1 
    this.currNode = this.head.next;
    
    while(this.currNode != null)
    {
      count++;
      this.currNode = this.currNode.next;
    } //Add to the count until currNode reaches end of list
    return count;
  }

  public boolean isEmpty()
  {
    if(this.head == null) //Easy money
    {
      return true;
    }
    return false;
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

  public void clear()
  {
    this.head = null; //Easy money, severs head reference, gets job done
  }

  public int compareTo(List<T> otherList)
  { //Just call whatever the generic's toString is and return that int
    return this.toString().compareTo(otherList.toString());
  } //Not much can be done specifically since this is generic coding

  public ListIterator<T> iterator()
  {
    return new ListIterator<T>(); //Easy money
  }

  public class ListIterator<E> implements Iterator<E>
  {
    private Node<E> head;
    private Node<E> currNode;
    
    public boolean hasNext() //Pretty basic because of .next
    {
      this.currNode = this.head;
      
      if(currNode.next == null) 
      {
        return false;
      }
      else
      {
        return true;
      }
    }

    public E next() throws NoSuchElementException
    {
      this.currNode = this.head;
      
      if(hasNext() == true) //hasNext does all the work
      {
        return this.currNode.data;
      }
      else
      {
        throw new NoSuchElementException("NoSuchElement");
      }
    }

    public void remove()
    {
      throw new UnsupportedOperationException("You do NOT need to write " +
                                              "this method (but you can if " +
                                              "you want a challenge).");
    }
  }
}
