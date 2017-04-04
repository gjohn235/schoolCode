package blackjack;          //More intricate part of program, requires more
public class BestHandFinder //knowledge of the game and interpretation
{
  public static int getMin(int[] arr)
  {
    int min, g;
    min = arr[0];
    
    for (g = 0; g < arr.length; g++)
    {
      if (arr[g] < min) //If next card is less use it
      {
        min = arr[g];
      }
    }
    return min;
  }
  public static int getMax(int[] arr)
  {
    int max, g;
    max = arr[0];
    
    for (g = 0; g < arr.length; g++)
    {
      if (arr[g] > max) //If next card is more use it
      {
        max = arr[g];
      }
    }
    return max;
  }
  public static boolean blackjack(Card[] hand)
  {
    if (hand.length == 2) //Only two cards
    {     
      if (hand[0].getValue() + hand[1].getValue() == 21)
      {
        return true; //BLACKJACK!!!!!!!
      }
      else
      {
        return false;
      }
    }
    else
    {
      return false;
    }
  }
  public static int[] evaluateHand(Card[] hand)
  {
    int aces = 0, g, j;
    int [] baseHand = new int[1]; //Disregarding aces until later
    
    for (j = 0, g = 0; g < hand.length; g++)
    {
      if (hand[g].getValue() >= 10) //All face cards must be 10
      {
        j = hand[g].getValue();
        j = 10;
      }
      else                          //Else let them be default values
      {
        j = hand[g].getValue();
      }
      baseHand[0] += j;             //Base hand with aces read as 1
    }
    for (g = 0; g < hand.length; g++)
    {
      if (hand[g].getValue() == 1) //Count the aces
      {
        aces++;
      }
    }
    int[] flux = new int[aces + 1];
    if (aces == 1) //1 ace possibilities
    {
      flux[0] = baseHand[0];
      flux[1] = baseHand[0] + 10;
    }
    else if (aces == 2) //2 aces possibilities
    {
      flux[0] = baseHand[0];
      flux[1] = baseHand[0] + 10;
      flux[2] = baseHand[0] + 20;
    }
    else if (aces == 3) //3 aces possibilities
    {
      flux[0] = baseHand[0];
      flux[1] = baseHand[0] + 10;
      flux[2] = baseHand[0] + 20;
      flux[3] = baseHand[0] + 30;
    }
    else if (aces == 4) //4 ace possibilities
    {
      flux[0] = baseHand[0];
      flux[1] = baseHand[0] + 10;
      flux[2] = baseHand[0] + 20;
      flux[3] = baseHand[0] + 30;
      flux[4] = baseHand[0] + 40;
    }
    else if (aces == 0) //No ace possibility
    {
      flux[0] = baseHand[0];
    }
    return flux;
  }
  public static boolean bust(Card[] hand)
  {
    int aces = 0, g, j, d = 0;
    int [] baseHand = new int[1]; //Straight copy from previous method
    
    for (j = 0, g = 0; g < hand.length; g++)
    {
      if (hand[g].getValue() >= 10)
      {
        j = hand[g].getValue();
        j = 10;
      }
      else
      {
        j = hand[g].getValue();
      }
      baseHand[0] += j;
    }
    for (g = 0; g < hand.length; g++)
    {
      if (hand[g].getValue() == 1)
      {
        aces++;
      }
    }
    int[] flux = new int[aces + 1];
    if (aces == 1)
    {
      flux[0] = baseHand[0];
      flux[1] = baseHand[0] + 10;
    }
    else if (aces == 2)
    {
      flux[0] = baseHand[0];
      flux[1] = baseHand[0] + 10;
      flux[2] = baseHand[0] + 20;
    }
    else if (aces == 3)
    {
      flux[0] = baseHand[0];
      flux[1] = baseHand[0] + 10;
      flux[2] = baseHand[0] + 20;
      flux[3] = baseHand[0] + 30;
    }
    else if (aces == 4)
    {
      flux[0] = baseHand[0];
      flux[1] = baseHand[0] + 10;
      flux[2] = baseHand[0] + 20;
      flux[3] = baseHand[0] + 30;
      flux[4] = baseHand[0] + 40;
    }
    else if (aces == 0)
    {
      flux[0] = baseHand[0];
    }
    for (g = 0; g < flux.length; g++) //Start of the new stuff
    {
      if (flux[g] <= 21)
      {
        return false; //If anything is less than bust instantly end
      }
      else if (flux[g] > 21) //Check if all values are over 21
      {
        d++;
      }
    }
    if (d == flux.length) //If everything is over 21
    {
      return true;
    }
    return false; //Not really needed, necessary for Java
  }
  public static int getBestValue(int[] values)
  {
    int g, best = 0;
    for (g = 0; g < values.length; g++)
    {
      if (values[g] < 22) //Check if anything is under 21
      {
        best = values[g];
      }
    }
    for (g = 0; g < values.length; g++)
    {
      if (values[g] > best && values[g] < 22)
      {
        best = values[g]; //Same principle as getMin and getMax
      }
    }
    return best;
  }
}
