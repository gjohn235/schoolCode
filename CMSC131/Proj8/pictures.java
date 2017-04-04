package socialNetworking;
public class Pictures extends WallPosts
{
  private int pictureSize;
  
  public Pictures(String date, User writer, int pictureSize)
  { //Extra variable
    super(date, writer);
    this.pictureSize = pictureSize;
  }
  
  public int getPictureSize()
  { //Simple getter
    return pictureSize;
  }
  
  public String toString()
  { //Format for picture
    String correctFormat;
    correctFormat = date + " " + writer.toString() + ", picture size " +
                    pictureSize + "K";
    return correctFormat;
  }

}
