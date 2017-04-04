package friends;
public class User //Creating a User in our Social Network
{
private String firstName, lastName;

  public User(String firstName, String lastName)
  { //Initializing field variables in constructor
    this.firstName = firstName;
    this.lastName = lastName;
  }
  
  public String getFirstName()
  { //First name getter
    return firstName;
  }
  
  public String getLastName()
  { //Last name getter
    return lastName;
  }
  
  public String toString()
  { //Converting to String in desired format
    String correctFormat;
    correctFormat = (firstName + " " + lastName);
    return correctFormat;
  }
  
  public boolean equals(User otherUser)
  { //Checking if both Users are identical
    if (this.firstName == otherUser.firstName &&
        this.lastName == otherUser.lastName)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
}
