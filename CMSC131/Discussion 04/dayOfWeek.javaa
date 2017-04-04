import java.util.Scanner;

public class Exercise {

	public static void main(String[] args)
  {
	  String dayOfTheWeek;
	  Scanner sc= new Scanner(System.in);
	  
	  System.out.println ("What day of the week is it? ");
	  dayOfTheWeek = sc.next();
	  
	  int week;
	  int semesterDay;
	  System.out.println ("Enter the week and day of the semester: ");
	  week = sc.nextInt();
	  semesterDay = sc.nextInt();
	 
	  if (semesterDay == 1)
	  	{System.out.println ("It's Sunday- go home!");}
	  	else {if (semesterDay == 7)
	  			{System.out.println ("It's Saturday- go home");}}
	  int finalAnswer = ((week - 2) * 7) + 4 + semesterDay;
	  int daysLeft = 105 - finalAnswer;
	  System.out.println ("It is day " + finalAnswer + " of the semester and there are " + daysLeft + " days left."); 	
	  	}
}
