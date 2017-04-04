package socialNetworking;
import junit.framework.TestCase;

public class PublicTests extends TestCase
{
  public void testAddingUsersAndUserLists()
  {
    Site facebook= new Site();
    User sylvester= facebook.createUser("Sylvester", "Cat", 23);
    User tweety= facebook.createUser("Tweety", "Bird", 21);
    User bugs= facebook.createUser("Bugs", "Bunny", 26);
    String output1= "Cat, Sylvester (23)\n" +
                    "Bird, Tweety (21)";
    String output2= "Bird, Tweety (21)\n" +
                    "Cat, Sylvester (23)";

    facebook.addUser(sylvester);
    facebook.addUser(tweety);

    assertEquals(output1, facebook.userListInMembershipOrder());
    assertEquals(output2, facebook.userListInAlphabeticalOrder());
  }
  
  public void testSendingAndGettingMessages()
  {
    Site facebook= new Site();
    User sylvester= facebook.createUser("Sylvester", "Cat", 23);
    User tweety= facebook.createUser("Tweety", "Bird", 21);
    User bugs= facebook.createUser("Bugs", "Bunny", 26);
    String output1= "11-30-2011 Cat, Sylvester (23), wall post " +
                      "\"My first wall post!\"\n" +
                    "12-2-2011 Cat, Sylvester (23), picture size 12500K\n" +
                    "12-2-2011 Cat, Sylvester (23), picture size 2980K\n" +
                    "12-3-2011 Cat, Sylvester (23), wall post " +
                      "\"Thufferin' Thuccotash!\"\n" +
                    "12-5-2011 Cat, Sylvester (23), picture size 2000K";
    String output2= "12-2-2011 Cat, Sylvester (23), picture size 12500K\n" +
                    "12-2-2011 Cat, Sylvester (23), picture size 2980K\n" +
                    "12-5-2011 Cat, Sylvester (23), picture size 2000K";
    String output3= "11-30-2011 Cat, Sylvester (23), wall post " +
                      "\"My first wall post!\"\n" +
                    "12-3-2011 Cat, Sylvester (23), wall post " +
                      "\"Thufferin' Thuccotash!\"";

    facebook.addUser(sylvester);
    facebook.addUser(tweety);

    facebook.sendFriendRequest(tweety, sylvester);

    facebook.sendMessage(sylvester, tweety, "11-30-2011",
                                            "My first wall post!");
    facebook.sendMessage(tweety, sylvester, "12-1-2011", "Hey what's up?");
    facebook.sendMessage(sylvester, tweety, "12-2-2011", 12500);
    facebook.sendMessage(sylvester, tweety, "12-2-2011", 2980);
    facebook.sendMessage(sylvester, tweety, "12-3-2011",
                                            "Thufferin' Thuccotash!");
    facebook.sendMessage(sylvester, tweety, "12-5-2011", 2000);

    System.out.println(tweety.getNumWallPosts());
    System.out.println(tweety.getTotalNumMessages());
    System.out.println(tweety.getNumPictures());
    System.out.println(tweety.numPictures);
    System.out.println(facebook.getPictures(tweety));
    assertEquals(output1, facebook.getAllMessages(tweety));
    assertEquals(output2, facebook.getPictures(tweety));
    assertEquals(output3, facebook.getWallPosts(tweety));
  } 
}
