package division;

import java.io.*;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Division
{
  public static void main(String args[])
  {
	Scanner scan= new Scanner(System.in);
	String desiredNum;
	boolean isIdiotOrDope;
	int oneThreeTwo = 132, number = 0, answer = 0;
	
	System.out.print("Enter number: ");
	
	do
	{
	  try
	  {
		desiredNum = scan.next();
		isIdiotOrDope = false;
	    number = Integer.parseInt(desiredNum);
	    answer = oneThreeTwo / number;
	  }
	  catch(NumberFormatException g)
	  {
		System.out.print("Invalid number- try again.  Enter number: ");
		isIdiotOrDope = true;
	  }
	  catch(ArithmeticException j)
	  {
        System.out.print("Division by zero- try again.  Enter number: ");
        isIdiotOrDope = true;
	  }
	} while(isIdiotOrDope == true);
	//Not sure how to make work in a straight while loop, do while seems easy
	System.out.println("The whole number of times 132 can be divided by "
			   + number + " is " + answer + ".");
  }
}
