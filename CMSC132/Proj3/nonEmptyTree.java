package tree;

import java.util.ArrayList;
import java.util.List;
/*
 * This class is the more complex of the two, it holds all methods for a BST
 * (Binary Search Tree) that actually contains keys and values in it. We cover
 * all the basic functions any BST class should have such as being able to add
 * and remove keys, lookup values to specific keys, find the largest and
 * smallest keys of any given tree and so on.
 */
public class NonEmptyTree<K extends Comparable<K>, V> implements Tree<K, V>
{

  private K root; //My generic field variables
  private V value;
  private Tree<K, V> leftSub;  //Similar concept to the head and curr Nodes of
  private Tree<K, V> rightSub; //the previous project. All trees have left and
                               //right sub trees for the constuctor
  public NonEmptyTree(K root, V value)
  {
    this.root = root; //Simple constructor actions
    this.value = value;
    this.leftSub = EmptyTree.getInstance();  //Initially there should be no
    this.rightSub = EmptyTree.getInstance(); //leaves, just return emptyTrees
  }
  
  public NonEmptyTree<K, V> add(K key, V value)
  { //If this new key is the same as initial root, we just swap out its value
    if(key.compareTo(root) == 0)
    {
      this.value = value;
    }
    else
    { //if new key is smaller...
      if(key.compareTo(root) < 0)
      { //we get some recursive calls down the left side of the tree
        leftSub = leftSub.add(key, value);
      } //since we have a BST smaller keys always end up on left of root
      else
      { //if new key is bigger...
        if(key.compareTo(root) > 0)
        { //we get some recursive calls down the right side of the tree
          rightSub = rightSub.add(key, value);
        } //since we have a BST larger keys always end up on the right of root
      }
    }
    return this;
  } //Finally exit recursive calls, we return the tree again, only updated

  public V lookup(K key)
  { //If the key is equal to the root, we've found our match
    if(key.compareTo(root) == 0)
    {
      return this.value;
    }
    else
    { //If the key is smaller than the root...
      if(key.compareTo(root) < 0)
      { //recursive to the left
        return leftSub.lookup(key);
      }
      else
      { //If the key is larger than the root...
        if(key.compareTo(root) > 0)
        { //recursive to the right
          return rightSub.lookup(key);
        }
      }
    }
    return null;
  } //If we make it down here that means the key isn't there, return null

  public int size()
  { //recursive calls will throw in 1 for every new root it finds down each
    return 1 + leftSub.size() + rightSub.size();
  } //side of our BST

  public K max() throws EmptyTreeException
  { //In this method we actually WANT the exception to be thrown
    try
    { //Since the largest value MUST be on the right in a BST that's where we go
      return rightSub.max();
    }
    catch(EmptyTreeException e)
    { //When we reach the point where there are no more leaves we get an
      return root;
    } //exception, this means we've found the largest key
  }

  public K min() throws EmptyTreeException
  { //In this method we actually WANT the exception to be thrown
    try
    { //Since the largest value MUST be on the left in a BST that's where we go
      return leftSub.min();
    }
    catch(EmptyTreeException e)
    { //When we reach the point where there are no more leaves we get an
      return root;
    } //exception, this means we've found the smallest key
  }

  public Tree<K, V> delete(K key)
  { //Using algorthim taught in class, replace with either with smallest in
	//rightSub, or largest in leftSub
	if(key.compareTo(this.root) == 0)
	{ //If we found the key we first try the largest in leftSub
	  try
	  {
	    K biggestOfSmall = leftSub.max(); //Find the largest in the left
	    this.root = biggestOfSmall;
	    this.value = leftSub.lookup(biggestOfSmall);
	    leftSub = leftSub.delete(biggestOfSmall); //Wipeout the thing we just
	  }                                           //key with
	  catch(EmptyTreeException e) //This exception means we need to check the
	  {                           //rightSub now
		try
		{
	      K smallestOfBig = rightSub.min(); //Same concept as leftSub search
	      this.root = smallestOfBig;
	      this.value = rightSub.lookup(smallestOfBig);
	      rightSub = rightSub.delete(smallestOfBig);
		}
		catch(EmptyTreeException ee) //This exception means the key was never
		{                            //found so we don't change the tree
		  return EmptyTree.getInstance();
		}
	  }
	}
	else
	{
	  if(key.compareTo(this.root) < 0)
	  { //If the key is smaller we recursivley go left
	    leftSub = leftSub.delete(key);
	    return this;
	  }
	  else
	  {
	    if(key.compareTo(this.root) > 0)
	    { //If key is larger we recursively go right
	      rightSub = rightSub.delete(key);
	      return this;
	    }
	  }
	}
	return this;
  }

  public Tree<K, V> removeSubTree(K key)
  {
    if(key.compareTo(this.root) == 0)
    { //If we've found the key, just give back an emptyTree, effectively
      //removing the key itself and EVERYTHING under it
      return EmptyTree.getInstance();
    }
    else
    {
      if(key.compareTo(this.root) < 0)
      { //If key is smaller we recursively check to the left
        leftSub = this.leftSub.removeSubTree(key);
      }
      else
      {
        if(key.compareTo(this.root) > 0)
        { //If key is larger we recursively check to the right
          rightSub = this.rightSub.removeSubTree(key);
        }
      }
    }
    return this;
  }

  public boolean haveSameKeys(Tree<K, V> otherTree)
  { //Can't access otherTree.root so just call generic equals method like
    return this.equals(otherTree);
  } //we did with the empty tree
  
  public void pathFromRoot(K key, List<K> list)
  { //Instructions says something about emptying current list, but the initial
	//list should be empty, so no need to call .clear()
    if(key.compareTo(this.root) == 0)
	{ //If we find the root just add it to the list
	  list.add(this.root);
	}
	else
	{
	  if(key.compareTo(this.root) < 0)
	  { //If key is smaller we recursivley go left
	    list.add(this.root);
	    leftSub.pathFromRoot(key, list);
	  }
	  else
	  {
	    if(key.compareTo(this.root) > 0)
	    { //If key is larger we recursivley go right
	      list.add(this.root);
	      rightSub.pathFromRoot(key, list);
	    }
	  }
	}
  }

  public void pathToRoot(K key, List<K> list)
  { //Same exact code as FromRoot except for one difference
    if(key.compareTo(this.root) == 0)
	{
	  list.add(this.root);
	}
	else
	{
	  if(key.compareTo(this.root) < 0)
	  {
		leftSub.pathToRoot(key, list); //Notice these statements are flipped
	    list.add(this.root);           //from previous method since we are now
	  }                                //going in reverese order up to the root
	  else
	  {
	    if(key.compareTo(this.root) > 0)
	    {
	      rightSub.pathToRoot(key, list);
	      list.add(this.root);
	    }
	  }
	}
  }
  
  public String toString()
  {//Recursively calls itself down the leftSub, back to the root, then down
   //any rightSub tree present to create increasing order of toString. Notice
   //the extra empty space after the leftSub, but NOT rightSub. This is what
   //prevents the largest and subsequently final value from having a space
   //after it.
    return (leftSub.toString().equals("") ? "": leftSub.toString() + " ")
    		+ root.toString() + "=>" + value.toString()
    		+ (rightSub.toString().equals("") ? "": " "
    		   + rightSub.toString());
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public NonEmptyTree<K, V> clone()
  { //Using a brandnew constructor we create a new tree that will take in all
	//subTrees of what it's being cloned from
	NonEmptyTree<K, V> newTree =
    		new NonEmptyTree(root, value, leftSub, rightSub);
    newTree.leftSub = leftSub.clone();   //Recursive calls to each subTree give
    newTree.rightSub = rightSub.clone(); //desired independent clone
    return newTree;
  }
  
  public NonEmptyTree(K root, V value,
			Tree<K, V> leftSub, Tree<K, V> rightSub)
  { //This constructor only exist to make clone method easy. It will be called
	//ONLY by the clone method in my class
    this.root = root;
	this.value = value;
	this.leftSub = leftSub;
	this.rightSub = rightSub;
  }
}
