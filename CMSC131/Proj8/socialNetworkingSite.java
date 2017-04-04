package socialNetworking;
import java.util.ArrayList;

public interface SocialNetworkingSite
{
  public User createUser(String firstName, String lastName, int age);
  public boolean addUser(User user);
  public boolean sendFriendRequest(User fromUser, User toUser);
  public boolean areFriends(User user1, User user2);
  public ArrayList<User> getFriends(User user);
  public String userListInMembershipOrder();
  public String userListInAlphabeticalOrder();
  public String getAllMessages(User user);
  public String getPictures(User user);
  public String getWallPosts(User user);
}
