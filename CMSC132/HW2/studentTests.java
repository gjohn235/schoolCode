package tests;

import java.util.ArrayList;
import java.util.List;
import recursiveListMethods.RecursiveListMethods;

import org.junit.*;
import static org.junit.Assert.*;

public class StudentTests
{
  @Test public void testPublic01()
  {
    ArrayList<Integer> multEltList= new ArrayList<Integer>();
    
    multEltList.add(7);
    multEltList.add(2);
    multEltList.add(9);
    multEltList.add(3);
    multEltList.add(5);
    
    RecursiveListMethods.duplicateFirst(multEltList);
    assertEquals("[7, 7, 7, 7, 7]", multEltList.toString());
  }
  
  @Test public void testPublic02()
  {
    ArrayList<Integer> multEltList= new ArrayList<Integer>();
    
    multEltList.add(7);
    multEltList.add(2);
    multEltList.add(9);
    multEltList.add(3);
    multEltList.add(5);
    
    RecursiveListMethods.duplicateLast(multEltList);
    assertEquals("[5, 5, 5, 5, 5]", multEltList.toString());
  }
  
  @Test public void testPublic03()
  {
    ArrayList<Integer> multEltList= new ArrayList<Integer>();
    
    multEltList.add(7);
    multEltList.add(2);
    multEltList.add(9);
    multEltList.add(3);
    multEltList.add(5);
    
    assertFalse(RecursiveListMethods.anyDuplicates(multEltList));
    
    multEltList.add(3);
    
    assertTrue(RecursiveListMethods.anyDuplicates(multEltList));
  }
  
  @Test public void testPublic04()
  {
    ArrayList<Integer> multEltList= new ArrayList<Integer>();
    
    multEltList.add(7);
    multEltList.add(2);
    multEltList.add(9);
    multEltList.add(3);
    multEltList.add(5);
    
    assertEquals("9", RecursiveListMethods.findLargest(multEltList).toString());
  }
}
