package studentCode;

import gridTools.MyGrid;

import java.util.Scanner;

/**
 *  THIS CLASS IS PROVDED FOR YOU.  USE IT TO TEST THE FlagMaker
 *  CLASS THAT YOU ARE WRITING.
 *
 *  This driver relies on the drawFlag method of the FlagMaker class.  It
 *  prompts the user to enter information about what flag he/she would like
 *  to see and in what size it should be created.  Then it creates a MyGrid
 *  object, and calls the drawFlag method of the FlagMaker class to actually
 *  draw the Flag in the grid this driver creates.
 */

public class ExampleDriver {
	
  public static void main(String[] args) {
    Scanner scanner= new Scanner(System.in);
    int choice, width, height;
		
    // get input from user about what flag to draw
    System.out.println("Flags are: ");
    System.out.println("1- Italy");
    System.out.println("2- Chile");
    System.out.println("3- Dominican Republic");
    System.out.println("4- Switzerland");
    System.out.println("5- Congo");
    System.out.print("Choose a flag: ");
    choice= scanner.nextInt();

    System.out.print("Enter flag height and width: ");
    height= scanner.nextInt();
    width= scanner.nextInt();

    if (height < 4 || height > 60 || width < 4 || width > 60) {
      height= width= 4;
      choice= 99;
    }
		
    // create drawing grid of the height requested
    MyGrid grid= new MyGrid(height, width);
    
    // draw the chosen flag on the grid
    FlagMaker.drawFlag(grid, choice);
  }

}
