public class Instructor implements Worker
{
  private String name;
  private int salary;
  private int numStudents;

  public Instructor(String name, int numStudents)
  {
    this.name = name;
    this.numStudents = numStudents;
    salary = 10000;
  }
  
  public String getName()
  {
    return name;
  }
  
  public int getSalary()
  {
    return salary;
  }
  
  public int getNumStudents()
  {
    return numStudents;
  }
  
  public void acceptRaise(int amount)
  {
    salary += amount;
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj)
    {
      return true;
    }
    else if (!(obj instanceof Instructor))
    {
      return false;
    }
    else
    {
      Instructor teacher = (Instructor)(obj);
      if (teacher.name.equals(name) && teacher.numStudents == numStudents &&
          teacher.salary == salary)
      {
        return true;
      }
      else
      {
        return false;
      }
    }
  }
}
