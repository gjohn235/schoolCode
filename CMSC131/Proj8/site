package socialNetworking; //All the inner workings of a social networking site
import java.util.ArrayList;
import java.util.Collections;
public class Site implements SocialNetworkingSite
{
  private ArrayList<User> theNetwork;
  private boolean[][] friendOrNot;
  
  public Site()
  { //Initialize the variables of the website
    theNetwork = new ArrayList<User>();
    friendOrNot = new boolean[0][0];
  }
  
  public User createUser(String firstName, String lastName, int age)
  { //Creates new user in the system
    User newPerson = new User(firstName, lastName, age);
    return newPerson;
  }

  public boolean addUser(User user)
  { //Actually adding the user
    for(int g = 0; g < theNetwork.size(); g++)
    {
      if (user.getFirstName() == theNetwork.get(g).getFirstName() &&
          user.getLastName() == theNetwork.get(g).getLastName() &&
          user.getAge() == theNetwork.get(g).getAge())
      {
        return false;
      }
    }
    boolean[][] bigger =
    new boolean[friendOrNot.length + 1][friendOrNot.length + 1];
    
    theNetwork.add(user);
    friendOrNot = bigger;
    return true;
  }

  public boolean sendFriendRequest(User fromUser, User toUser)
  {
    for(int g = 0; g < theNetwork.size(); g++)
    {
      if (fromUser.getFirstName() == theNetwork.get(g).getFirstName() &&
          fromUser.getLastName() == theNetwork.get(g).getLastName() &&
          fromUser.getAge() == theNetwork.get(g).getAge())
      {
        for(int j = 0; j < theNetwork.size(); j++)
        {
          if (toUser.getFirstName() == theNetwork.get(g).getFirstName() &&
              toUser.getLastName() == theNetwork.get(g).getLastName() &&
              toUser.getAge() == theNetwork.get(g).getAge())
          {
            if ((fromUser.getAge() >= 18 && toUser.getAge() >= 18) ||
               (fromUser.getAge() < 18 && toUser.getAge() < 18) ||
               (fromUser.getAge() < 18 && toUser.getAge() >= 18))
            {
              friendOrNot[g][j] = true;
              friendOrNot[j][g] = true; 
              return true;
            } //If both people exist and its not an adult sending to a minor
          }   //they become friends
        }
      }
    }
    return false;
  }

  public boolean areFriends(User user1, User user2)
  {
    for(int g = 0; g < theNetwork.size(); g++)
    {
      if(user1.getFirstName() == theNetwork.get(g).getFirstName() &&
         user1.getLastName() == theNetwork.get(g).getLastName() &&
         user1.getAge() == theNetwork.get(g).getAge())
      {
        for(int j = 0; j < theNetwork.size(); j++)
        {
          if(user2.getFirstName() == theNetwork.get(g).getFirstName() &&
             user2.getLastName() == theNetwork.get(g).getLastName() &&
             user2.getAge() == theNetwork.get(g).getAge())
          {
            if(friendOrNot[g][j] == true)
            {
              return true; //Checks if they are firends
            }
          }
        }
      }   
    }
    return false;
  }

  public ArrayList<User> getFriends(User user)
  {
    ArrayList<User> empty = new ArrayList<User>();
    ArrayList<User> names = new ArrayList<User>();
    
    for (int g = 0; g < theNetwork.size(); g++)
    { //Check if person exist
      if (user.getFirstName() == theNetwork.get(g).getFirstName() &&
          user.getLastName() == theNetwork.get(g).getLastName())
      { //Look for friends
        for (int j = 0; j < theNetwork.size(); j++)
        {
          if (friendOrNot[g][j] == true)
          { //If friends, add name to list
            names.add(theNetwork.get(j));
          }
        }
        Collections.sort(names); //Sort names before returning them
        return names;
      }
    }
    return empty;
  }

  public String userListInMembershipOrder()
  {
    String theList;
    StringBuffer list = new StringBuffer();
    for(int g = 0; g < theNetwork.size(); g++)
    {
      if (g < theNetwork.size() - 1)
      {
        list = list.append(theNetwork.get(g).toString() + "\n");
      } //All members EXCEPT the last get the newline character
      else if (g == theNetwork.size() - 1)
      {
        list = list.append(theNetwork.get(g).toString());
      }
    }
    theList = list.toString();
    return theList;
  }

  public String userListInAlphabeticalOrder()
  {
    Collections.sort(theNetwork);
    String theList; //Exact same as previous method, just sorted beforehand
    StringBuffer list = new StringBuffer();
    for(int g = 0; g < theNetwork.size(); g++)
    {
      if (g < theNetwork.size() - 1)
      {
        list = list.append(theNetwork.get(g).toString() + "\n");
      }
      else if (g == theNetwork.size() - 1)
      {
        list = list.append(theNetwork.get(g).toString());
      }
    }
    theList = list.toString();
    return theList;
  }

  public String getAllMessages(User user)
  {
    StringBuffer thosePosts = new StringBuffer();
    String thePosts;
    
    for(int g = 0; g < theNetwork.size(); g++)
    {
      if(user.getFirstName() == theNetwork.get(g).getFirstName() &&
         user.getLastName() == theNetwork.get(g).getLastName() &&
         user.getAge() == theNetwork.get(g).getAge())
      { //Check if the user is in the system
        
        for(int j = 0; j < user.getTotalNumMessages(); g++)
        {
          if (j < user.getTotalNumMessages() - 1)
          {
            thosePosts =
         thosePosts.append(theNetwork.get(g).allPosts.get(j).toString() + "\n");
          } //All messages EXCEPT the last get the newline character
          else if (j == user.getTotalNumMessages() - 1)
          {
            thosePosts =
                thosePosts.append(theNetwork.get(g).allPosts.get(j).toString());
          }
        }
      }
    }
    thePosts = thosePosts.toString();
    return thePosts;
  }

  public String getPictures(User user)
  { //Same as previous method, only worried about pictures
    StringBuffer thosePictures = new StringBuffer();
    String thePictures;
    
    for(int g = 0; g < theNetwork.size(); g++)
    {
      if(user.getFirstName() == theNetwork.get(g).getFirstName() &&
         user.getLastName() == theNetwork.get(g).getLastName() &&
         user.getAge() == theNetwork.get(g).getAge())
      {

        for(int j = 0; j < theNetwork.get(g).getNumPictures(); j++)
        {
          if (j < theNetwork.get(g).getNumPictures() - 1)
          {
              thosePictures =
   thosePictures.append(theNetwork.get(g).picMessages.get(j).toString() + "\n");
          }
          else if (j == theNetwork.get(g).getNumPictures() - 1)
          {
            thosePictures =
          thosePictures.append(theNetwork.get(g).picMessages.get(j).toString());
          }
        }
      }
    }
    thePictures = thosePictures.toString();
    return thePictures;
  }

  public String getWallPosts(User user)
  { //Same as previous method only worried about picture-less wall posts
    StringBuffer thoseWallPosts = new StringBuffer();
    String theWallPosts;
    
    for(int g = 0; g < theNetwork.size(); g++)
    {
      if(user.getFirstName() == theNetwork.get(g).getFirstName() &&
         user.getLastName() == theNetwork.get(g).getLastName() &&
         user.getAge() == theNetwork.get(g).getAge())
      {

        for(int j = 0; j < theNetwork.get(g).getNumWallPosts(); j++)
        {
          if (j < theNetwork.get(g).getNumWallPosts() - 1)
          {
              thoseWallPosts = 
     thoseWallPosts.append(theNetwork.get(g).messages.get(j).toString() + "\n");
          }
          else if (j == theNetwork.get(g).getNumWallPosts() - 1)
          {
              thoseWallPosts =
            thoseWallPosts.append(theNetwork.get(g).messages.get(j).toString());
          }
        }
      }
    }
    theWallPosts = thoseWallPosts.toString();
    return theWallPosts;
  }
  
  public boolean sendMessage(User user1, User user2, String date,
                             String messageText)
  {
    for(int g = 0; g < theNetwork.size(); g++)
    {
      if(user1.getFirstName() == theNetwork.get(g).getFirstName() &&
         user1.getLastName() == theNetwork.get(g).getLastName() &&
         user1.getAge() == theNetwork.get(g).getAge())
      {
        for(int j = 0; j < theNetwork.size(); j++)
        {
          if(user2.getFirstName() == theNetwork.get(g).getFirstName() &&
             user2.getLastName() == theNetwork.get(g).getLastName() &&
             user2.getAge() == theNetwork.get(g).getAge())
          {
            if(friendOrNot[g][j] == true)
            { //Check if both users exist and are friends
              WallPosts yourMessage = new WallPosts(date, messageText, user1);
              theNetwork.get(j).addTotalNumMessages();
              theNetwork.get(j).addNumWallPosts(); //Add 1 to the users variable
              theNetwork.get(j).addMessage(yourMessage); //Adds the message
              theNetwork.get(j).allPosts.add(yourMessage);
              return true;
            }
          }
        }
      }
    }
    return false;
  }
  
  public boolean sendMessage(User user1, User user2, String date,
                             int pictureSize)
  {
    for(int g = 0; g < theNetwork.size(); g++)
    {
      if(user1.getFirstName() == theNetwork.get(g).getFirstName() &&
         user1.getLastName() == theNetwork.get(g).getLastName() &&
         user1.getAge() == theNetwork.get(g).getAge())
      {
        for(int j = 0; j < theNetwork.size(); j++)
        {
          if(user2.getFirstName() == theNetwork.get(g).getFirstName() &&
             user2.getLastName() == theNetwork.get(g).getLastName() &&
             user2.getAge() == theNetwork.get(g).getAge())
          {
            if(friendOrNot[g][j] == true)
            { //Checks if both users exist and are friends
              Pictures yourMessage = new Pictures(date, user1, pictureSize);
              theNetwork.get(j).addTotalNumMessages();
              theNetwork.get(j).addNumPictures(); //Same as previous method
              theNetwork.get(j).picMessages.add(yourMessage);
              theNetwork.get(j).allPosts.add(yourMessage);
              return true;
            }
          }
        }
      }
    }
    return false;
  }
}
