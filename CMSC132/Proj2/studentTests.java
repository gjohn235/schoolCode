package tests;

import list.IntegerComparator;
import list.List;

import org.junit.*;

import static org.junit.Assert.*;

public class StudentTests
{
  //Test my replace on special case head
  @Test public void testPublic01()
  {
    List<Integer> multEltList= new List<Integer>(new IntegerComparator());

    multEltList.add(6);
    multEltList.add(2);
    multEltList.add(9);
    multEltList.add(3);
    multEltList.add(7);
    
    multEltList.replace(6, 1);
    assertEquals("1 2 9 3 7", multEltList.toString());
  }
  
  //Test replace on special case last elt
  @Test public void testPublic02()
  {
    List<Integer> multEltList= new List<Integer>(new IntegerComparator());

    multEltList.add(6);
    multEltList.add(2);
    multEltList.add(9);
    multEltList.add(3);
    multEltList.add(7);
    
    multEltList.replace(7, 5);
    assertEquals("6 2 9 3 5", multEltList.toString());
  }
  
  //Test my delete on special case head
  @Test public void testPublic03()
  {
    List<Integer> multEltList= new List<Integer>(new IntegerComparator());

    multEltList.add(6);
    multEltList.add(2);
    multEltList.add(9);
    multEltList.add(3);
    multEltList.add(7);
    
    multEltList.delete(6);
    assertEquals("2 9 3 7", multEltList.toString());
  }
  
  //Test my delete on special case last
  @Test public void testPublic04()
  {
    List<Integer> multEltList= new List<Integer>(new IntegerComparator());

    multEltList.add(6);
    multEltList.add(2);
    multEltList.add(9);
    multEltList.add(3);
    multEltList.add(7);
    
    multEltList.delete(7);
    assertEquals("6 2 9 3", multEltList.toString());
  }
  
  //Test my clear and isEmpty
  @Test public void testPublic05()
  {
    List<Integer> multEltList= new List<Integer>(new IntegerComparator());

    multEltList.add(6);
    multEltList.add(2);
    multEltList.add(9);
    multEltList.add(3);
    multEltList.add(7);
    
    multEltList.clear();
    assertEquals("", multEltList.toString());
    
    multEltList.isEmpty();
    assertEquals(true, multEltList.isEmpty());
  }
}
