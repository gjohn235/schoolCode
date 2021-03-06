package friends;
public class Index //Adding Users into our social network
{
private User[] index;

  public Index()
  {
    index = new User[0];
  }
  
  public boolean add(String firstName, String lastName)
  { 
    for (int g = 0; g < index.length; g++)
    {
      if (firstName == index[g].getFirstName() &&
          lastName == index[g].getLastName())
      {
        return false;
      }
    }
    
    User[] oneBigger = new User[index.length + 1];
    User newPerson = new User(firstName, lastName);
    
    for (int g = 0; g < index.length; g++)
    {
      oneBigger[g] = index[g];
    }
    
    oneBigger[index.length] = newPerson;
    index = oneBigger;
    return true;
  }
  
  public User get(int pos)
  {
    if ((pos >= index.length || pos < 0) || (index[pos] == null))
    {
      return null;
    }
    else
    {
      return index[pos];
    }
  }
  
  public int find(String firstName, String lastName)
  { 
    for (int g = 0; g < index.length; g++)
    {
      if (firstName == index[g].getFirstName() &&
          lastName == index[g].getLastName())
      {
        return g; 
      }
    }
    return - 1;
  }
}
