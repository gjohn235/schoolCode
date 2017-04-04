public interface Worker
{

  // should return the person's name
  public String getName();

  // should return the person's annual salary
  public int getSalary();

  // should increase this person's salary by the amount of the parameter
  public void acceptRaise(int amount);

}
