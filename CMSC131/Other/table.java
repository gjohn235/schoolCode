import java.util.Scanner;
public class Midterm
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner (System.in);
    int row, column;
    int rowCount, columnCount;
    
      System.out.print("Please enter the number of rows desired, then columns desired in table: ");
      row = scan.nextInt();
      column = scan.nextInt();
      
        if (row > 0 && column > 0)
        {
          for (rowCount = 0; rowCount < 1; rowCount++)
          {
            for (columnCount = 0; columnCount < 1; columnCount++)
            {
              System.out.print("| |");
            }
            for (columnCount = 1; columnCount < column; columnCount++)
            {
              System.out.print(" |");
            }
            for (columnCount = column; columnCount == column; columnCount++)
            {  
              System.out.println();
            }
          System.out.print("---");
          }
          for (rowCount = 1; rowCount < row; rowCount++)
          {
            System.out.print("--");
          } 
        }    
  }
}
