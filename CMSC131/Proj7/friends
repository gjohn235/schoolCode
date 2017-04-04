package friends;
import java.util.ArrayList;
public class Friends //Actual goings on of the network, friending and such
{
public boolean[][] networkFriends;
public User[] index;
  
  public Friends() //Initialize my field variables
  {
    networkFriends = new boolean[0][0];
    index = new User[0]; 
  }
  
  public boolean addPerson(String firstName, String lastName)
  { 
    for (int g = 0; g < index.length; g++)
    {
      if (firstName == index[g].getFirstName() &&
          lastName == index[g].getLastName())
      {
        return false; //If they already exist stop right now
      }
    }
    
    User newPerson = new User(firstName, lastName); 
    User [] oneBiggerSingle = new User[index.length + 1];
    boolean[][] oneBiggerDual =
    new boolean[networkFriends.length + 1][networkFriends.length + 1];
    //If they don't already exist, create the person and arrays that are one
    //size larger
    
    for (int g = 0; g < index.length; g++)
    {
      oneBiggerSingle[g] = index[g];
    } //Copy in all the old people
    
    oneBiggerSingle[index.length] = newPerson; //Add final new person
    index = oneBiggerSingle;
    networkFriends = oneBiggerDual;
    return true; //Reassign field variables
  }
  
  public int numPeople()
  {
    return index.length; //Simple get length
  }
  
  public boolean addFriend(String firstName1, String lastName1,
                           String firstName2, String lastName2)
  { 
    for (int g = 0; g < index.length; g++)
    { //Check if first person exist
      if (firstName1 == index[g].getFirstName() &&
          lastName1 == index[g].getLastName())
      {
        for (int j = 0; j < index.length; j++)
        { //Check if second person exist
          if (firstName2 == index[j].getFirstName() &&
              lastName2 == index[j].getLastName())
          {
            networkFriends[g][j] = true; //Make them friends
            networkFriends[j][g] = true;
            return true;
          }
        }
      }
    }
    return false;  
  }
  
  public boolean isFriend(String firstName1, String lastName1,
                          String firstName2, String lastName2)
  {
    for (int g = 0; g < index.length; g++)
    { //Check if first person exist
      if (firstName1 == index[g].getFirstName() &&
          lastName1 == index[g].getLastName())
      {
        for (int j = 0; j < index.length; j++)
        { //Check if second person exist
          if (firstName2 == index[j].getFirstName() &&
              lastName2 == index[j].getLastName())
          {
            if(networkFriends[g][j] == true) //God forsaken equals sign...
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
    }
    return false;
  }
  
  public boolean unFriend(String firstName1, String lastName1,
                          String firstName2, String lastName2)
  {
    for (int g = 0; g < index.length; g++)
    { //Check if first person exist
      if (firstName1 == index[g].getFirstName() &&
          lastName1 == index[g].getLastName())
      {
        for (int j = 0; j < index.length; j++)
        { //Check if second person exist
          if (firstName2 == index[j].getFirstName() &&
              lastName2 == index[j].getLastName())
          {
            if (networkFriends[g][j] == true)
            { //If friends make it no more
              networkFriends[g][j] = false;
              networkFriends[j][g] = false;
              return true;
            }
            else
            {
              return false;
            }
          }
        }
      }
    }
    return false;
  }
  
  public User mostPopular()
  {
    int popular = 0, friendly = 0;
    if (index[0] == null)
    {
      return null; //If nobody exist return nothing
    }
    else
    {
      for (int j = 0; j < networkFriends.length; j++)
      { //Check person
        for (int friends = 0, g = 0; g < networkFriends[j].length; g++)
        { //Check who they are friends with
          if (networkFriends[j][g] == true)
          {
            friends++;
          }
          if (friends > friendly)
          {
            friendly = friends;
            popular = j; //Assign most popular to specific person
          }
        }
      }
    }
    return index[popular];
  }
  
  public ArrayList<String> getFriends(String firstName, String lastName)
  {
    ArrayList<String> empty = new ArrayList<String>();
    ArrayList<String> names = new ArrayList<String>();
    
    for (int g = 0; g < index.length; g++)
    { //Check if person exist
      if (firstName == index[g].getFirstName() &&
          lastName == index[g].getLastName())
      { //Look for friends
        for (int j = 0; j < networkFriends[g].length; j++)
        {
          if (networkFriends[g][j] == true)
          { //If friends, add name to list
            names.add(index[j].getFirstName() + " " + index[j].getLastName());
          }
        }
        return names;
      }
    }
    return empty;
  }
}
