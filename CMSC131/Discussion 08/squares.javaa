import java.util.Scanner;

public class Exercise
{

  public static void main(String[] args)
  {

    String squareType;
    Scanner scan = new Scanner (System.in);


    System.out.print("Enter square type ");
    squareType = scan.next ();

    System.out.print("Enter size: "); 
    int squareSize = scan.nextInt ();

    if (squareType.equals("solid"))
    {
      for (int g=0; g < squareSize; g++) //Outer loop gives length of column
      {
        for (int j=0; j < squareSize; j++) //Inner loop gives length of row
        {
          System.out.print("#"); //Gives a pound until "j" equals input size
        }
        System.out.println(); //Blank starts new row
      }
    }
    else if (squareType.equals("alternating"))
    {
      for (int g=0; g < squareSize; g++) //Outer loop gives length of column
      {
        if (g%2 == 0) //When "g" is even first character will be a pound
        {
          for (int j=0; j < squareSize; j++) //Inner loop gives length of row
          {
            if (j%2 == 0)            //When "j" is even         
              System.out.print("#"); //Print out a pound            
            else                     //When "j" is not even            
              System.out.print("-"); //Print out a dash 
          }
        }
        else //When "g" is not even first character will be a dash
        {
          for (int j=0; j < squareSize; j++)
          {
            if (j%2 == 0)
              System.out.print("-");            
            else                                
              System.out.print("#");         
          }
        }
        System.out.println();
      }
    }
    else if (squareType.equals("hollow"))
    {
      for (int g=0; g < squareSize; g++) //Gives top line of square solid pounds
      {
        System.out.print("#");
      }
      System.out.println(); //Blank line allows hollow part to start after solid top
      for (int j=0; j < squareSize-2; j++) //This loop has the squareSize-2 to allow space at beginning of line and end for solid pound
      {
        System.out.print("#"); //Starts line with a pound
        for (int d=0; d < squareSize-2; d++) //Gives hollow spaces
        {
          System.out.print (" ");
        }
        System.out.print ("#"); //Prints a pound to end line after final blank space
        System.out.println(); //Blank line allows new line to begin
      }

      if (squareSize != 1) //Debug Fix: When squareSize was 1 bottom line executed when its not supposed to 
        for (int g=0; g < squareSize; g++) //Gives bottom line of square solid pounds
        {
          System.out.print("#");
        }
    }

  }

}
