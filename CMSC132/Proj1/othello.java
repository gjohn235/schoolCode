package othello;

import java.util.NoSuchElementException;
import java.lang.IllegalArgumentException;

public class Othello
{
  private Piece[][] oBoard; //2-Dim array to store Piece values
  private int turn; //0 means black next, 1 is for white
  private int blackCount, whiteCount; //Used for last 4 methods
  
  public Othello() //Creating the playing field and who's turn it is
  {
    oBoard = new Piece[8][8]; //8x8 board as instructed
    for(int g = 0; g < oBoard.length; g++)
	{
	  for(int j = 0; j < oBoard[g].length; j++)
	  {
	    oBoard[g][j] = Piece.NONE;
	  } //Assign entire board blank
	}
    turn = 0; //Black turn by default
  }

  public Othello(Othello otherObj) //Simple copy constructor
  {
	oBoard = new Piece[8][8];
    for(int g = 0; g < oBoard.length; g++)
	{
      for(int j = 0; j < oBoard[g].length; j++)
      {
        oBoard[g][j] = otherObj.oBoard[g][j];
      } //Double loop allows values to actualy be copied in as opposed to
    }   //just creating a reference copy
	turn = otherObj.turn; 
  }

  public void restart(Piece color) throws IllegalArgumentException
  { //This method wipes board clean, resets, declares the color's turn
	if(color == Piece.BLACK)
	{
      turn = 0;
	}
	else
	{
	  if(color == Piece.WHITE)
	  {
		turn = 1;
	  }
	  else
	  {
	    if(color == Piece.NONE)
	    {
	      throw new IllegalArgumentException();
	    }
	  }  //If else statements checking who's turn it is
	}
	for(int g = 0; g < oBoard.length; g++)
	{
	  for(int j = 0; j < oBoard[g].length; j++)
	  {
	    oBoard[g][j] = Piece.NONE; //At first, everything gets set to empty
	  }                            //Wipe board clean
	}
	oBoard[3][4] = Piece.BLACK; //Middle 4 squares are now given default peices
	oBoard[4][3] = Piece.BLACK;
	oBoard[3][3] = Piece.WHITE;
	oBoard[4][4] = Piece.WHITE;
  }

  public void setTurn(Piece color) throws IllegalArgumentException
  { //Sets turn based on passed in color
	if(color == Piece.BLACK)
	{
	  turn = 0;
	}
	else
	{
	  if(color == Piece.WHITE)
	  {
	    turn = 1; 
	  }
	  else
	  {
	    if(color == Piece.NONE)
	    {
        throw new IllegalArgumentException();
	    } //Basically does exactly what restart method does
	  }   //except it doesn't have to alter the board
	}
  } //No reason to get this far, but just covering all bases

  public Piece getTurn()
  {
    if(turn == 0) //As stated earlier 0 is for black
    {
      return Piece.BLACK;
    }
    else  //Else it MUST be 1, meanig white
    {
      return Piece.WHITE;
    }
  }

  public void setEntry(Piece color, int row, int col)
              throws NoSuchElementException
  {
    if(row > 7 || row < 0 || col > 7 || col < 0)
    { //If row or col are out of bounds throw the exception
      throw new NoSuchElementException();
    }
    else
    {
      if(color == Piece.BLACK)
      {
        oBoard[row][col] = Piece.BLACK;
      }
      else
      {
        if(color == Piece.WHITE)
        {
          oBoard[row][col] = Piece.WHITE;
        }
        else
        {
          if(color == Piece.NONE)
          {
            oBoard[row][col] = Piece.NONE;
          }
        } //Set place as Black, White, or None
      }
    }
  }

  public Piece getEntry(int row, int col) throws NoSuchElementException
  {
	if(row > 7 || row < 0 || col > 7 || col < 0)
	{ //If row or col are out of bounds throw the exception
	  throw new NoSuchElementException();
	}
	else
	{
      if(oBoard[row][col] == Piece.BLACK)
      {
        return Piece.BLACK;
      } //If black, return black etc...
      else
      {
        if(oBoard[row][col] == Piece.WHITE)
        {
          return Piece.WHITE;
        }
        else
        {
          if(oBoard[row][col] == Piece.NONE)
          {
            return Piece.NONE;
          }
        }
      }
	}
    throw new NoSuchElementException();
  } //Never should reach this point, make compiler happy

  public boolean validMove(Piece color, int row, int col)
  {
    if(row > 7 || row < 0 || col > 7 || col < 0 ||
    		oBoard[row][col] == Piece.BLACK || oBoard[row][col] == Piece.WHITE)
    {
      return false;
    } //Check for all invalidity's at the start
    
	if(row - 1 > 0)
	{//Look up, must be at least two up spaces available
	  if(oBoard[row - 1][col] != color && oBoard[row - 1][col] != Piece.NONE)
	  {//Piece MUST oppisite color, NONE is not an option
	    for(int g = row - 1; g > 0; g--)
	    {//Now we skip a spot and search for a matching color so we can trap
		  if(oBoard[g][col] == color)
		  {//If ALL this is true, you have a valid move
		    return true;
		  }
	    }
	  }
	}//Else statements not needed since method ends at return
	if(row + 2 < oBoard.length)
	{//Look down, must be at least two down spaces available
	  if(oBoard[row + 1][col] != color && oBoard[row + 1][col] != Piece.NONE)
	  {
		for(int g = row + 1; g < oBoard.length; g++)
		{
		  if(oBoard[g][col] == color)
		  {//Same concept as previous if statement
		    return true;
		  }
		}
	  }
	}
	if(col + 2 < oBoard.length)
	{//Look right, same concept
	  if(oBoard[row][col + 1] != color && oBoard[row][col + 1] != Piece.NONE)
	  {
	    for(int g = col + 1; g < oBoard.length; g++)
	    {
		  if(oBoard[row][g] == color)
		  {
		    return true;
		  }
	    }
	  }
	}
	if(col - 1 > 0)
	{//Look left
	  if(oBoard[row][col - 1] != color && oBoard[row][col - 1] != Piece.NONE)
	  {
	    for(int g = col + 1; g > 0; g--)
	    {
		  if(oBoard[row][g] == color)
		  {
		    return true;
		  }
	    }
	  }
	}
	if(row + 2 < oBoard.length && col + 1 < oBoard.length)
	{//Look down and to the right
      if(oBoard[row + 1][col + 1] != color &&
    		  oBoard[row + 1][col + 1] != Piece.NONE)
      {
	    for(int g = row + 1, j = col + 1; g < oBoard.length
	    		&& j < oBoard.length; g++, j++)
	    {//Two variables needed since we're looking in two directions, DownRight
		  if(oBoard[g][j] == color)
		  {//Same basic concept though
		    return true;
		  }
		}
      }
	}
	if(row + 2 < oBoard.length && col - 1 > 0)
	{//Look down and to the left
	  if(oBoard[row + 1][col - 1] != color &&
			  oBoard[row + 1][col - 1] != Piece.NONE)
	  {
	    for(int g = row + 1, j = col - 1; g < oBoard.length && j > 0; g++, j--)
	    {
		  if(oBoard[g][j] == color)
		  {//Same concept
		    return true;
		  }
	    }
	  }
	}
	if(row - 1 > 0 && col - 1 > 0)
	{//Look up and to the left
	  if(oBoard[row - 1][col - 1] != color &&
			  oBoard[row - 1][col - 1] != Piece.NONE)
	  {
	    for(int g = row - 1, j = col - 1; g > 0 && j > 0; g--, j--)
	    {
		  if(oBoard[g][j] == color)
		  {//Same concept
		    return true;
		  }
	    }
	  }
	}
	if(row - 2 > 0 && col + 2 < oBoard.length)
	{//Look up and to the right
	  if(oBoard[row - 1][col + 1] != color &&
			  oBoard[row - 1][col + 1] != Piece.NONE)
	  {
	    for(int g = row - 1, j = col + 1; g > 0 && j < oBoard.length; g--, j++)
	    {
		  if(oBoard[g][j] == color)
		  {//Same concept
		    return true;
		  }
		}
      }
	}
    return false;
  }//If it does make it down here for God knows what reason, return false

  public void move(int row, int col)
  {
	int j;
	boolean moveDone = false;
    if(this.turn == 0) //Black's move
    {
      if(this.validMove(Piece.BLACK, row, col) == true)
      {
        oBoard[row][col] = Piece.BLACK;
        
        while(moveDone == false)
        {
          for(int g = row - 1; g < 0; g--)
          {//Look up
            if(oBoard[g][col] == Piece.BLACK)
            {//If you find a same color...
              for(j = g; j != row; j ++)
              {//... Everything in between gets flipped
                oBoard[j][col] = Piece.BLACK;
              }
              if(j == row)
              {
                moveDone = true; //Ensures loop exits after it finds first
              }                  //same colored piece
            }
          }
        }
        moveDone = false;
        while(moveDone == false)
        {
          for(int g = row + 1; g < 0; g++)
          {//Look down
            if(oBoard[g][col] == Piece.BLACK)
            {//If you find a same color...
              for(j = g; j != row; j --)
              {//... Everything in between gets flipped
                oBoard[j][col] = Piece.BLACK;
              }
              if(j == row)
              {
                moveDone = true; //Ensures loop exits after it finds first
              }                  //same colored piece
            }
          }
        }
        moveDone = false;
        while(moveDone == false)
        {
          for(int g = col - 1; g < 0; g--)
          {//Look left
            if(oBoard[row][g] == Piece.BLACK)
            {//If you find a same color...
              for(j = g; j != col; j ++)
              {//... Everything in between gets flipped
                oBoard[row][j] = Piece.BLACK;
              }
              if(j == col)
              {
                moveDone = true; //Ensures loop exits after it finds first
              }                  //same colored piece
            }
          }
        }
        moveDone = false;
        while(moveDone == false)
        {
          for(int g = col + 1; g < 0; g++)
          {//Look right
            if(oBoard[row][g] == Piece.BLACK)
            {//If you find a same color...
              for(j = g; j != col; j --)
              {//... Everything in between gets flipped
                oBoard[row][j] = Piece.BLACK;
              }
              if(j == col)
              {
                moveDone = true; //Ensures loop exits after it finds first
              }                  //same colored piece
            }
          }
        }
      }
    }
    if(this.turn == 1) //White's move
    {
      if(this.validMove(Piece.WHITE, row, col) == true)
      {
        oBoard[row][col] = Piece.WHITE;
        
        while(moveDone == false)
        {
          for(int g = row - 1; g < 0; g--)
          {//Look up
            if(oBoard[g][col] == Piece.WHITE)
            {//If you find a same color...
              for(j = g; j != row; j ++)
              {//... Everything in between gets flipped
                oBoard[j][col] = Piece.WHITE;
              }
              if(j == row)
              {
                moveDone = true; //Ensures loop exits after it finds first
              }                  //same colored piece
            }
          }
        }
        moveDone = false;
        while(moveDone == false)
        {
          for(int g = row + 1; g < 0; g++)
          {//Look down
            if(oBoard[g][col] == Piece.WHITE)
            {//If you find a same color...
              for(j = g; j != row; j --)
              {//... Everything in between gets flipped
                oBoard[j][col] = Piece.WHITE;
              }
              if(j == row)
              {
                moveDone = true; //Ensures loop exits after it finds first
              }                  //same colored piece
            }
          }
        }
        moveDone = false;
        while(moveDone == false)
        {
          for(int g = col - 1; g < 0; g--)
          {//Look left
            if(oBoard[row][g] == Piece.WHITE)
            {//If you find a same color...
              for(j = g; j != col; j ++)
              {//... Everything in between gets flipped
                oBoard[row][j] = Piece.WHITE;
              }
              if(j == col)
              {
                moveDone = true; //Ensures loop exits after it finds first
              }                  //same colored piece
            }
          }
        }
        moveDone = false;
        while(moveDone == false)
        {
          for(int g = col + 1; g < 0; g++)
          {//Look right
            if(oBoard[row][g] == Piece.WHITE)
            {//If you find a same color...
              for(j = g; j != col; j --)
              {//... Everything in between gets flipped
                oBoard[row][j] = Piece.WHITE;
              }
              if(j == col)
              {
                moveDone = true; //Ensures loop exits after it finds first
              }                  //same colored piece
            }
          }
        }
      }
    }
  }

  public void move(Piece color, int row, int col)
  {
    if(this.turn == 0 && color == Piece.BLACK)
    {//Turn and color must match for something to happen
      this.move(row, col); //No need to copy and paste the code
    }                      //Just call the method
    else
    {
      if(this.turn == 1 && color == Piece.WHITE)
      {
        this.move(row, col);
      }
    }
  }

  public String toString() //Really long String
  { //This method creates upwards of 100 seperate Strings before returning final
	String oneSixTwo = "";
	oneSixTwo += "  0 1 2 3 4 5 6 7\n"; //Opening line Note TWO spaces at start
	
	for(int g = 0; g < oBoard.length; g++)
	{
	  oneSixTwo += g; //Each line begins with a new number
	  
	  for(int j = 0; j < oBoard.length; j++)
	  {
	    if(oBoard[g][j] == Piece.BLACK)
	    {
	      oneSixTwo += " B"; //Notice the space always BEFORE not after
	    }
	    else
	    {
	      if(oBoard[g][j] == Piece.WHITE)
	      {
	        oneSixTwo += " W";
	      }
	      else
	      {
	        if(oBoard[g][j] == Piece.NONE)
	        {
	          oneSixTwo += " -";
	        }
	      }
	    }
	  }
	  oneSixTwo += "\n"; //Only after everything else does the new line start
	}
	return oneSixTwo;
  }

  public int count(Piece color)
  {
	whiteCount = 0;
	blackCount = 0;
    for(int g = 0; g < oBoard.length; g++)
	{ //My now signature double loop to scan entire 2-Dim array
	  for(int j = 0; j < oBoard[g].length; j++)
      {
	    if(oBoard[g][j] == Piece.BLACK)
	    {
	      blackCount ++;
	    }    //Depending on color variable either black or white count 
	    else //is incremented
	    {
	      if(oBoard[g][j] == Piece.WHITE)
	      {
	        whiteCount ++;
	      } //if piece is nothing... do nothing
	    }
	  }
	}
    if(color == Piece.BLACK)
    {
      return blackCount;
    }
    else
    { //After entire loop finishes return the approiate count based on color
      if(color == Piece.WHITE)
      {
        return whiteCount;
      }
    }
    return 0;
  } //Again no reason to get this far, just to make compiler happy

  public boolean moreBlackPieces() //Checks the score
  { //If black has more, true, else its false
    if(this.count(Piece.BLACK) > this.count(Piece.WHITE))
	{
	  return true;
	}
	else
	{
	  return false;
	}
  }

  public boolean moreWhitePieces() //Checks the score
  { //Same as moreBlackPieces
    if(this.count(Piece.BLACK) < this.count(Piece.WHITE))
	{
	  return true;
	}
	else
	{
	  return false;
	}
  }

  public boolean equalPieces() //Checks the score
  { //Same as last two methods
    if(this.count(Piece.BLACK) == this.count(Piece.WHITE))
    { //Only the "greater than/less than sign is now equals
	  return true;
	}
	else
	{
	  return false;
	}
  }
}
