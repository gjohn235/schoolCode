package tests;

import org.junit.*;

import othello.Othello;
import othello.Piece;
import static org.junit.Assert.*;

public class StudentTests
{ //Reset, Count, toString already tested
	
	@Test public void testPublic00()
	{ //Constructor test
	    Othello othello= new Othello();

	    assertEquals("  0 1 2 3 4 5 6 7\n" +
	                 "0 - - - - - - - -\n" +
	                 "1 - - - - - - - -\n" +
	                 "2 - - - - - - - -\n" +
	                 "3 - - - - - - - -\n" +
	                 "4 - - - - - - - -\n" +
	                 "5 - - - - - - - -\n" +
	                 "6 - - - - - - - -\n" +
	                 "7 - - - - - - - -\n", othello.toString());
	  }
	
	@Test public void testPublic01()
	{ //Copy Constructor
	    Othello othello= new Othello();
	    
	    othello.setEntry(Piece.WHITE, 3, 3);
	    othello.setEntry(Piece.BLACK, 3, 4);
	    
	    Othello oCopy= new Othello(othello);

	    assertEquals("  0 1 2 3 4 5 6 7\n" +
	                 "0 - - - - - - - -\n" +
	                 "1 - - - - - - - -\n" +
	                 "2 - - - - - - - -\n" +
	                 "3 - - - W B - - -\n" +
	                 "4 - - - - - - - -\n" +
	                 "5 - - - - - - - -\n" +
	                 "6 - - - - - - - -\n" +
	                 "7 - - - - - - - -\n", oCopy.toString());
	  }
	
	@Test public void testPublic02() {
	    Othello othello= new Othello();
        //Copied over count test, but also checking morePiece methods
	    othello.setEntry(Piece.BLACK, 5, 2);
	    othello.setEntry(Piece.WHITE, 4, 3);
	    othello.setEntry(Piece.WHITE, 2, 5);
	    othello.setEntry(Piece.BLACK, 1, 6);
	    othello.setEntry(Piece.BLACK, 2, 6);
	    othello.setEntry(Piece.BLACK, 3, 7);

	    
	    assertTrue(othello.moreBlackPieces());
	    assertFalse(othello.moreWhitePieces());
	    assertFalse(othello.equalPieces());
	  }
}
