package graph;

import java.util.Comparator;
import java.lang.Iterable;
import java.util.Iterator;
import java.lang.IndexOutOfBoundsException;
import java.util.NoSuchElementException;
/*
 * My data structure of choice was a basic linked list. Methods traverse list as
 * needed, basically copied over from Proj2
 */
public class MyClassEdge<V> implements Iterable<V>
{
  protected Comparator<V> comp; //Needed for first constructor
  protected Node<V> head; //Have to make your own head and current
  protected Node<V> currNode;
  
  protected class Node<E> //Taken from Proj2, just added edgeCost
  {
    V data;
	Node<V> next;
	int edgeCost;
  }

  public MyClassEdge(Comparator<V> comparator)
  { //Construcor, slightly adapted from Proj2
	this.head = null;
	this.currNode = this.head;
    comp = comparator;
  }
  
  public MyClassEdge(MyClassEdge<V> otherList)
  { //Copy Constructor taken from Proj2
    this.head = otherList.head;
	this.comp = otherList.comp;
	otherList.currNode = otherList.head.next;
	this.currNode = otherList.currNode;
	 
	while(this.currNode != null) //Copy in all node data
	{
	  Node<V> node = new Node<V>();
	  node.data = this.currNode.data;
	  node.edgeCost = this.currNode.edgeCost;
	  this.currNode = otherList.currNode.next;
	}
  }

  public MyClassEdge<V> add(V vertex, int length)
  { //More stuff from Proj2, more adaptations
    Node<V> node = new Node<V>();
	node.data = vertex; //Makes data in new node this new vertex
	node.next = null;
	node.edgeCost = length; //The length is now the "cost" of the edge
	
	if(contains(vertex) == false)
	{ //First we check if the vertex is already present
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
    	    this.currNode = this.currNode.next;//Finally reach end of list where
    	    return this;                        //new node is added
    	  }
    	}
	  }
	}
	return this;
  }
  
  public V get(int index) throws IndexOutOfBoundsException
  { //Again Proj2
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
  
  public V lookup(V element)
  { //Continue to utilize Proj2
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

  public MyClassEdge<V> delete(V element) throws NoSuchElementException
  { //Proj2 helps again
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
  
  public int getCost(V edge)
  { //More Proj2 (adapted from lookUp)
    if(this.head == null) //Check empty from the start
	{
	  return -1; //Can't return null, so a negative value will have to do
	}

	this.currNode = this.head;

	while(this.currNode != null)
	{
	  if(comp.compare(this.currNode.data, edge) == 0)
      {
        return currNode.edgeCost;
      }
      else //If not identical move to next list node
      {
        this.currNode = this.currNode.next;
      }
   	} //If we break the while loop that means no objects were equal
    return -1;
  }

  public boolean contains(V element)
  { //More Proj2 (adapted from lookUp)
    if(this.head == null) //Check empty from the start
	{
	  return false;
	}

	this.currNode = this.head;

	while(this.currNode != null)
	{
	  if(comp.compare(this.currNode.data, element) == 0)
      {
        return true;
      }
      else //If not identical move to next list node
      {
        this.currNode = this.currNode.next;
      }
   	} //If we break the while loop that means no objects were equal
    return false;
  }
	    
  public EdgeIterator<V> iterator()
  { //Easy from Proj2
    return new EdgeIterator<V>(this); 
  }

  public class EdgeIterator<E> implements Iterator<V>
  {
    protected Node<V> currNode;
    V otherData;
    
    public EdgeIterator(MyClassEdge<V> list)
    {
      currNode = list.head;
    }
    
    public boolean hasNext()
    {
      if(this.currNode == null)
      {
        return false;
      }
      else
      {
        return true;
      }
    }

    public V next() throws NoSuchElementException
    {
      if(hasNext() == true) //hasNext does all the work
      {
        otherData = currNode.data;
        currNode = currNode.next;
        return otherData;
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
