package friends;
import junit.framework.TestCase;
public class PublicTests extends TestCase
{
  public void testIndexAddAndFind()
  {
    Index index= new Index();

    assertTrue(index.add("Minnie", "Mouse"));
    assertTrue(index.add("Tweety", "Bird"));
    assertTrue(index.add("Bugs", "Bunny"));
    assertTrue(index.add("Porky", "Pig"));
    assertTrue(index.add("Elmer", "Fudd"));

    assertEquals(0, index.find("Minnie", "Mouse"));
    assertEquals(1, index.find("Tweety", "Bird"));
    assertEquals(2, index.find("Bugs", "Bunny"));
    assertEquals(3, index.find("Porky", "Pig"));
    assertEquals(4, index.find("Elmer", "Fudd"));

    assertEquals(-1, index.find("Daffy", "Duck"));
    assertEquals(-1, index.find("Tweety", "Fudd"));
  }
  
  public void testIsFriendTrue()
  {
    Friends facebook= new Friends();

    facebook.addPerson("Minnie", "Mouse");
    facebook.addPerson("Daffy", "Duck");

    facebook.addFriend("Minnie", "Mouse", "Daffy", "Duck");

    assertTrue(facebook.isFriend("Minnie", "Mouse", "Daffy", "Duck"));
    assertTrue(facebook.isFriend("Daffy", "Duck", "Minnie", "Mouse"));
  }
}
