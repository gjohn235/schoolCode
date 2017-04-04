import java.util.Scanner;

public class Money {

	public static void main (String args[]) {

		          		               //These tell Java to interpret whatever is
		String deadPresident;        //scanned under "deadPresident", "denomination"
		int denomination; 			     //or "presidentOrDenomination" as a String or
		int presidentOrDenomination; //int, things Java will understand.
		Scanner scan= new Scanner(System.in);

		System.out.println ("Type 1 to enter a last name, 2 to enter a " +
		                                                 "denomination: ");
		presidentOrDenomination = scan.nextInt ();

		if (presidentOrDenomination == 1)
		{System.out.println("Enter a name: ");
		deadPresident = scan.next ();

		if (deadPresident.equals("Grant") || deadPresident.equals("Jackson") || deadPresident.equals("Jefferson"))
		{System.out.println("What denomination does " + deadPresident + " appear on? ");
		denomination = scan.nextInt ();

		if (denomination == 2 && deadPresident.equals("Jefferson") || denomination == 20 && deadPresident.equals("Jackson") || denomination == 50 && deadPresident.equals("Grant"))
		{System.out.println("Right!");}
		else {System.out.println("Wrong!");}}

		else {System.out.println("Invalid name!");}}

		else {if (presidentOrDenomination == 2)
		{System.out.println("Enter a denomination: ");
		denomination =scan.nextInt ();

		if (denomination == 2 || denomination == 20 || denomination == 50)
		{System.out.println("Who is on the " + denomination + " dollar bill? ");
		deadPresident = scan.next ();

		if (denomination == 2 && deadPresident.equals("Jefferson") || denomination == 20 && deadPresident.equals("Jackson") || denomination == 50 && deadPresident.equals("Grant"))
		{System.out.println("Right!");}
		else {System.out.println("Wrong!");}}

		else {System.out.println("Invalid Choice!");}}

		else {if (presidentOrDenomination != 1 || presidentOrDenomination != 2)
		{System.out.println("Invalid input value!");}}}

	}

}
