package tests;

import index.Index;
import index.InvalidParameterException;
import org.junit.*;

import static org.junit.Assert.*;

public class StudentTests
{ //Most methods already tested thoroughly, concentrating only on uniqueWords, problems arise
	@Test public void testStudent1() throws InvalidParameterException
	{ //uniqueWords not fooled by duplicates added more than once
		assertEquals(1, document1().numUniqueWords());
	}
	
	@Test public void testStudent2() throws InvalidParameterException
	{ //Recognizes difference between capitalization
		assertEquals(2, document2().numUniqueWords());
	}
	
	@Test public void testStudent3() throws InvalidParameterException
	{ //Why an error with odd numbers except 1?????? Out of Bounds?
		assertEquals(3, document3().numUniqueWords());
	} //Fixed
	
	@Test public void testStudent4() throws InvalidParameterException
	{
		assertEquals(6, document4().numUniqueWords());
	}
	
	private Index document1() throws InvalidParameterException
	{
	    Index index= new Index();
	    index.addWord("maryland", new int[]{1});
	    index.addWord("maryland", new int[]{5});
	    return index;
	}
	
	private Index document2() throws InvalidParameterException
	{
	    Index index= new Index();
	    index.addWord("Maryland", new int[]{1});
	    index.addWord("maryland", new int[]{5});	    
	    return index;
	}
	
	private Index document3() throws InvalidParameterException
	{
	    Index index= new Index();
	    index.addWord("Maryland", new int[]{1});
	    index.addWord("maryland", new int[]{5});
	    index.addWord("MAryland", new int[]{3});
	    return index;
	}
	
	private Index document4() throws InvalidParameterException
	{
	    Index index= new Index();
	    index.addWord("college", new int[]{2, 3});
	    index.addWord("maryland", new int[]{1, 2, 3});
	    index.addWord("park", new int[]{2, 4});
	    index.addWord("university", new int[]{1, 4});
	    index.addWord("Stop", new int[]{5});
	    index.addWord("MAryland", new int[]{3});
	    return index;
	 }
}
