package tree;

import java.util.List;
/*
 * This class holds all the methods for representing an BST(Binary Search Tree)
 * with nothing in it. As such, overall this class is pretty simple and bare.
 * Because there is nothing in trees created through this class the methods
 * don't have much to do.
 */
public class EmptyTree<K extends Comparable<K>, V> implements Tree<K, V>
{
  
  @SuppressWarnings("rawtypes")
  private static EmptyTree emptyTree = new EmptyTree(); //My lone emptyTree
  
  private EmptyTree()
  {
    //Java should make default constructor for this, being explicitly empty
	//just to be sure
  }
  
  @SuppressWarnings("unchecked")
  public static <K extends Comparable<K>, V> EmptyTree<K, V> getInstance()
  {
    return emptyTree; //Simply return my one unique emptyTree
  }

  public NonEmptyTree<K, V> add(K key, V value)
  {
    return new NonEmptyTree<K, V>(key, value);
  } //create and return a NonEmptyTree with this single new key and value

  public V lookup(K key)
  {
    return null; //emptyTree has no keys so just give back null
  }

  public int size()
  {
    return 0; //emptyTree is obviously empty
  }

  public K max() throws EmptyTreeException
  {
    throw new EmptyTreeException();
  } //throws exception as mandated, emptyTree has no max or min

  public K min() throws EmptyTreeException
  {
    throw new EmptyTreeException();
  } //throws exception as mandated, emptyTree has no max or min

  public Tree<K, V> delete(K key)
  {
    return this;
  } //empty so it has nothing to delete, just return itself

  public Tree<K, V> removeSubTree(K key)
  {
    return this;
  } //Again, nothing to remove, just return itself

  public boolean haveSameKeys(Tree<K, V> otherTree)
  { // size() == 0 and null check are explicitly outlawed, but not .equals()
    return this.equals(otherTree);
  }

  public void pathFromRoot(K key, List<K> list)
  { //tree is empty and this return type is void so do nothing
  }

  public void pathToRoot(K key, List<K> list)
  { //tree is empty and this return type is void so do nothing
  }

  public String toString()
  {
    return "";
  } //tree is empty, nothing to return but an empty string

  public EmptyTree<K, V> clone()
  {
    return this;
  } //tree is empty so returning it's empty self actually meets requirments
}
