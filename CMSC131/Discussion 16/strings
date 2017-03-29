public class StringMethods
{
  public static int count(String str, char ch)
  {
    int letterCount = 0;
    for(int g = 0; g < str.length(); g++)
    {
      if (ch == str.charAt(g))
      {
        letterCount++;
      }
    }
    return letterCount;
  }
  public static String reverse(String str)
  {
    String reverse = "";
    for (int g = 1; g <= str.length(); g++)
    {
      char j = str.charAt(str.length() - 1 - (g-1));
      reverse = reverse + j;
    }
    return reverse;
  }
  public static String expand(String str)
  {
    String expanded = "";
    for (int g = 0; g < str.length(); g++)
    {
      for (int f = -1; f < g; f++)
      {
      char j = str.charAt(g);
      expanded = expanded + j;
      }
    }
    return expanded;
  }
  public static String substring(String str, int begin, int end)
  {
    String subString = "";
    for (int g = begin; g < end; g++)
    {
      char j = str.charAt(g);
      subString = subString + j;
    }
    return subString;
  }
  public static boolean search(String str, String str2)
  {
    if (str.contains(str2))
    {
      return true;
    }
    return false;  
  }
  public static void main(String[] args)
  {
    System.out.println(count("mississippi", 'i'));
    System.out.println(count("mississippi", 'q'));
    System.out.println(reverse("SIXAXIS RACECAR SIXAXIS"));
    System.out.println(expand("Grant"));
    System.out.println(substring("Kaplowey", 2, 6));
    System.out.println(search("TRANSYLVANIA", "VAN"));
    System.out.println(search("Unrelated", "ck"));
  }
}
