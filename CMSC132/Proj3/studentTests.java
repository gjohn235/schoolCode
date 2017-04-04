package tests;

import java.util.ArrayList;

import org.junit.*;

import tree.EmptyTree;
import tree.Tree;
import static org.junit.Assert.*;
/*
 * Here we cover what the public test did not, path methods, clone, and sameKeys
 */
public class StudentTests
{
  private static Tree<Integer, Character> mainTree()
  { //Main tree copied over from public test
    Tree<Integer, Character> tree= EmptyTree.getInstance();

	tree= tree.add(1, 'a');
	tree= tree.add(2, 'b');
	tree= tree.add(3, 'c');
	tree= tree.add(4, 'd');
	tree= tree.add(5, 'e');

	return tree;
  }
  
  private static Tree<Integer, Character> otherTree()
  {//Same, just missing key 5
    Tree<Integer, Character> tree= EmptyTree.getInstance();

	tree= tree.add(1, 'a');
	tree= tree.add(2, 'b');
	tree= tree.add(3, 'c');
	tree= tree.add(4, 'd');

	return tree;
  }
  
  @Test public void testStudent01()
  { //Clone test
    Tree<Integer, Character> nonEmptyTree= mainTree();
    Tree<Integer, Character> otherNonEmptyTree = mainTree().clone();
    
    assertEquals(nonEmptyTree.toString(), otherNonEmptyTree.toString());
  }
  
  @Test public void testStudent02()
  { //FromRoot test
    Tree<Integer, Character> nonEmptyTree= mainTree();
    ArrayList<Integer> arrList = new ArrayList<Integer>();
    
    nonEmptyTree.pathFromRoot(5, arrList);
    
    assertEquals(arrList.toString(), "[1, 2, 3, 4, 5]");
  }
  
  @Test public void testStudent03()
  { //ToRoot test
    Tree<Integer, Character> nonEmptyTree= mainTree();
    ArrayList<Integer> arrList = new ArrayList<Integer>();
    
    nonEmptyTree.pathToRoot(5, arrList);
    
    assertEquals(arrList.toString(), "[5, 4, 3, 2, 1]");
  }
  
  @Test public void testStudent04()
  { //haveSameKeys test
    Tree<Integer, Character> nonEmptyTree= mainTree();
    Tree<Integer, Character> otherNonEmptyTree = otherTree();
    
    assertFalse(nonEmptyTree.haveSameKeys(otherNonEmptyTree));
    assertTrue(nonEmptyTree.haveSameKeys(nonEmptyTree));
  }
}
