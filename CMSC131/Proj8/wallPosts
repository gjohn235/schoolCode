package socialNetworking;
public class WallPosts //WallPosts with text no picture
{
  protected String date, message;
  protected User writer;
  
  public WallPosts(String date, String message, User writer)
  { //Initialize these variables
    this.date = date;
    this.message = message;
    this.writer = writer;
  }
  
  public WallPosts(String date, User writer)
  { //For the pictures class
    this.date = date;
    this.writer = writer;
  }
  
  public String getDate()
  { // simple getters
    return date;
  }
  
  public String getMessage()
  {
    return message;
  }
  
  public User getWriter()
  {
    return writer;
  }
  
  public String toString()
  { //Strings the correct format
    String correctFormat;
    correctFormat = date + " " + writer.toString() + ", wall post " +
                    '\"' + message + '\"';
    return correctFormat;
  }
}
