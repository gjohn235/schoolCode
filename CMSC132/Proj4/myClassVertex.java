package graph;

import java.util.Comparator;
import java.lang.Iterable;
import java.util.Iterator;
import java.lang.IndexOutOfBoundsException;
import java.util.NoSuchElementException;
/*
 * My vertex class that also uses linked list, many of the same methods as
 * MyClassEdge with a few extra methods that are after them at the end.
 */
public class MyClassVertex<V> implements Iterable<V>
{
  protected Comparator<V> comp; //Needed for first constructor
  protected Node<V> head; //Have to make your own head and current
  protected Node<V> currNode;
    
  protected class Node<E>
  {
    V data;
    V before;
    Node<V> next;
    MyClassEdge<V> edge;
    int status;
    int edgeCost;
  }

  public MyClassVertex(Comparator<V> comparator)
  { //Construcor, slightly adapted from Proj2
    this.head = null;
    this.currNode = this.head;
    comp = comparator;
  }
  
  public MyClassVertex(MyClassVertex<V> otherList)
  {
    this.head = otherList.head;
	this.comp = otherList.comp;
	otherList.currNode = otherList.head.next;
	this.currNode = otherList.currNode;

	while(this.currNode != null) //Copy in all node data
	{
	  Node<V> node = new Node<V>();
	  node.data = this.currNode.data;
	  node.edge = otherList.getEdges(node.data);
	  this.currNode = otherList.currNode.next;
	}
  }
  
  public MyClassVertex<V> add(V vertex)
  { //Taken from MyClassEdge
    Node<V> node = new Node<V>();
   	node.data = vertex; //Makes data in new node this new vertex
   	node.next = null;
   	node.edge = new MyClassEdge<V>(comp); //Set edge

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
  { //More copied over methods
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

  public MyClassVertex<V> delete(V element) throws NoSuchElementException
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

  public MyClassVertex<V> reset()
  {
    this.currNode = this.head;
    
    while(currNode != null)
    { //We go until we reach null
      currNode.status = -1;
      currNode.edgeCost = 2147483647; //Puts cost at max
      currNode = currNode.next;
    }
     return this;
  }
 
  public MyClassEdge<V> getEdges(V source)
  {
    if(this.head == null) //Check empty from the start
	{
	  return null;
	}

    this.currNode = this.head;

    while(this.currNode != null)
    {
      if(comp.compare(this.currNode.data, source) == 0)
      {
        return currNode.edge;
      }
      else //If not identical move to next list node
      {
        this.currNode = this.currNode.next;
      }
   	} //If we break the while loop that means no objects were equal
    return null;
  }

  public Node<V> getNode(V element)
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
        return currNode;
      }
      else //If not identical move to next list node
      {
        this.currNode = this.currNode.next;
      }
   	} //If we break the while loop that means no objects were equal
    return null;
  }
 
  public MyClassVertex<V> deleteVertex(V element)
  {
    if(this.head == null) //Check empty from the start
	{
	  return null;
	}

    this.currNode = this.head;
    
    while(this.currNode != null)
    {
      if(this.currNode.edge.contains(element))
      {
        this.currNode.edge.delete(element); //If we find it, delete it
      }
      this.currNode = this.currNode.next;
    }
    return this;
  }
    
  public boolean findCycle(V vertex) throws IllegalArgumentException
  {
    getNode(vertex).status = 0;
    
    for(V ch: getEdges(vertex))
    { //Check every character
      if(getNode(ch).status == 0)
      { //If status is 0 we've found what we're looking for
        return true;
      }
      else
      {
        if(getNode(ch).status != 1 && findCycle(lookup(ch)) == true)
        { //Possibly true if status isn't on and recursive call is true
          return true;
        }
      }
    } //If we escape for each loop, set status as 1 and give false
    getNode(vertex).status = 1;
    return false;    
  }
  
  public V getSmallest()
  {
    if(this.head == null) //Check empty from the start
    {
	  return null;
	}

	this.currNode = this.head;
	V smallest = null;
	
    while(this.currNode != null)
    { //while not null we find the smallest
      if(smallest == null && this.currNode.status == 0 ||
    		  this.currNode.status == 0 && getNode(this.currNode.data).edgeCost
    		  < getNode(smallest).edgeCost)
      { 
        smallest = this.currNode.data;
      }
      this.currNode = this.currNode.next;
    } //If not found keep looking
    return smallest;
  }
  
  public void helpDijkstra(V vertex)
  { //Meat of my Dijkstra's algo
    for(V v: getEdges(vertex))
    { //Check for all generic obj
      int sumCost = getNode(vertex).edgeCost + getEdges(vertex).getCost(v);
      //Sum up the edge cost a.k.a. lengths
      if(sumCost < getNode(v).edgeCost)
      { //If sum is less than current edgeCost we set the sum to it here
        getNode(v).edgeCost = sumCost;
        getNode(v).before = vertex;
        getNode(v).status = 0;
      }
    }
    getNode(vertex).status = 1;
    
    if(getSmallest() != null)
    {
      helpDijkstra(getSmallest());
    }
  }

  public MyClassVertex<V> pathFinder(V source, V dest)
  {
    MyClassVertex<V> path = new MyClassVertex<V>(comp);
    //Make a new MyClassVertex obj that will hold the path
    if(dest == source)
    { //If the end and start are the same we add it and leave
      path.add(dest);   
    }
    else
    { //If not we call recursivley back through the list until we can add
      path = pathFinder(source, getNode(dest).before);
      path.add(dest);
    }
    return path;
  }

  public VertexIterator<V> iterator()
  { //Easy from Proj2
    return new VertexIterator<V>(this); 
  }
    
  public class VertexIterator<E> implements Iterator<V>
  {
    private Node<V> currNode;
    V otherData;
    
    public VertexIterator(MyClassVertex<V> list)
    {
      currNode = list.head;
    }

    public boolean hasNext() //Pretty basic because of .next
    {
      if(currNode.next == null) 
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
