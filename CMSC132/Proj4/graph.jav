package graph;

import java.lang.Iterable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Comparator;   //As stipulated in instructions, gives a natural
import graph.MyClassEdge.Node; //ordering on it's compareTo method
/*
 * Graph class that is the actual being tested on Submit server. Most of these
 * methods are actually pretty short for the most part thanks to the Vertex and
 * Edge classes that were written. It is those classes that do most of the heavy
 * lifting, this class just ends up calling on methods in those classes more
 * often than not. In actuality, those two classes are really just many methods
 * brought over from project 2 since it's pretty effective to use linked list
 * in this situation.
 */
public class Graph<V extends Comparable<V>> implements Iterable<V>
{
  private MyClassVertex<V> graph;
  
  protected Comparator<V> comparator()
  { 
    return new Comparator<V>()
    { //Inner Class uilizing comparator
      public int compare(V start, V end)
      {
        return start.compareTo(end);
      }
    };
  }
  
  public Graph()
  { //Simple constructor, my graph is a linked list
    graph = new MyClassVertex<V>(comparator());
  }

  public void addVertex(V vertex) throws IllegalArgumentException
  {
    if(graph.contains(vertex))
    { //First we check if the vertex is already there
      throw new IllegalArgumentException("No duplicates allowed");
    }
    else
    { //If not we add it to our graph, vertex class does the actual work
      graph.add(vertex);
    }
  }

  public void addEdge(V source, V dest, int cost)
		 throws IllegalArgumentException
  {
    if(cost < 0)
    { //Check special case if edgeCost is negative for whatever reason
      throw new IllegalArgumentException("Negative cost");
    }
    //Next we check if the source or destination are already present
    if(graph.contains(source) == false)
    {
      addVertex(source);
    }
    //If not, they get added
    if(graph.contains(dest) == false)
    {
      addVertex(dest);
    }
    //If they already connected...
    if(graph.getEdges(source).contains(dest))
    { //We utilize methods from my other two classes and delete and swap in
      graph.getEdges(source).delete(dest);
      graph.getEdges(source).add(dest, cost);
    } //the new edgeCost
    else
    { //Or if they weren't already connected we can just add the new edge
      graph.getEdges(source).add(dest, cost);
    }
  }

  public int getEdge(V source, V dest)
  {
    if(graph.contains(source) == true && graph.contains(dest) == true)
    { //If they both are in the graph, go and grab the cost
      return graph.getEdges(source).getCost(dest);
    }
    else
    { //If they aren't there, just give back -1
      return -1;
    }
  }

  public Iterable<V> getNeighbors(V vertex) throws IllegalArgumentException
  {
    if(graph.contains(vertex))
    { //If the vertex is here return the edges
      return graph.getEdges(vertex);
    }
    else
    { //If not, toss the exception
      throw new IllegalArgumentException("vertex not present");
    }
  }

  public void removeEdge(V source, V dest) throws NoSuchElementException
  {
    if(graph.contains(source) && graph.contains(dest) &&
    		graph.getEdges(source).contains(dest))
    { //If both vertices are present and an edge exist between them, delete it
      graph.getEdges(source).delete(dest);
    }
    else
    {
      throw new NoSuchElementException("No edge exist to delete");
    }
  }

  public void removeVertex(V vertex) throws NoSuchElementException
  {
    if(graph.contains(vertex))
    { //If the vertex does infact exist we sever its edges then remove it
      graph.deleteVertex(vertex);
      graph.delete(vertex);
    }
    else
    {
      throw new NoSuchElementException("element not there to delete");
    }
  }

  public Iterator<V> iterator()
  { //Easy money returning iterartor
    return graph.iterator();
  }

  public boolean isInCycle(V vertex) throws IllegalArgumentException
  {
    if(graph.contains(vertex))
    { //If found we nuke the entire graph
      graph = graph.reset();
      return graph.findCycle(vertex);
    }
    else
    {
      throw new IllegalArgumentException("vertex not in graph");
    }
  }

  public ShortestPath<V> Dijkstra(V source, V dest)
         throws IllegalArgumentException
  {
    ShortestPath<V> pathShort = new ShortestPath<V>();
    
    if(graph.contains(source) && graph.contains(dest))
    { //If both are here we utilize multiple methods from MyClassVertex
      graph.reset();
      graph.getNode(source).edgeCost = 0;
      graph.helpDijkstra(source); //Head to MyClassVertex to see my Dijkstra's
      pathShort.setCost(graph.getNode(dest).edgeCost);
      pathShort.setPath(graph.pathFinder(source, dest));
      return pathShort;
    }
    else
    { //If not we toss the exception
      throw new IllegalArgumentException("Vertices not present");
    }
  }
}
