package iterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class MyClass implements Iterator<Student>
{
	private int numStudents = 0;
	private ArrayList<Student> studentList;
	
	public MyClass(ArrayList<Student> pupils)
	{ //Pass all your students through
		this.studentList = pupils;
	}
	
	public boolean hasNext()
	{
		if (numStudents < studentList.size())
		{ //If there are more students in the ArrayList, true
			return true;
		}
		else
		{ //If current numStudents is equal to iterator size (or somehow more), false
			return false;
		}
	}

	public Student next()
	{
		if (hasNext() == true)
		{ //BUG: Keep getting an OutOfBoundsException here...
			numStudents++;
			return studentList.get(numStudents - 1);
		} //BUG FIX: numStudents - 1 needed here, ArrayLists first position is ZERO not ONE.
		else
		{
			throw new NoSuchElementException();
		} //If hasNext is false, return null
	}     //Switched from return null to this exception
          //Public test7 expects NoSuchElementException, didn't see that in instructions
	public void remove()
	{
		//You say I need nothing here
	}
}
