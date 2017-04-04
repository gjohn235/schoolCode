package blackjack; //Computer Blackjack (21)
public class Deck
{
  private Card[] cards;

  public Deck()
  {
    int g, j, d = 0;
    cards = new Card[52];
    for (g = 0; g <= 3 ; g++) // Goes through every suit
    {
      for (j = 1; j <= 13; j++, d++) // Values Ace through King
      {
        cards[d] = new Card(j, g); //Assigns all 52 cards
      }
    }
  }
  public Deck(Deck other) //Simple copy
  {
    cards = other.cards;
  }
  public Card getCardAt(int position) //Simple getter
  {
    return cards[position];
  }
  public int getNumCards() // simple getter
  {
    return cards.length;
  }
  public void shuffle()
  {
    int g, j, d;
    Card[] shuffled = new Card[cards.length];
    
    if (cards.length % 2 == 0) // For even
    {
      Card[] topHalf = new Card[cards.length / 2];
      Card[] bottomHalf = new Card[topHalf.length];
      
      for (j = cards.length / 2, g = 0; g < cards.length / 2; g++, j++)
      {
        topHalf[g] = cards[g]; //Notice the need of TWO counters (g, j)
        bottomHalf[g] = cards [j];
      }
      for (d = 0, g = 0, j = 1; g < cards.length; g += 2, j += 2, d++)
      {
        shuffled[g] = topHalf[d];
        shuffled[j] = bottomHalf[d];
      }
      cards = shuffled;
    }
    else if (cards.length % 2 == 1) //For odd
    {
      Card[] topHalf = new Card[(cards.length / 2) + 1]; //Top half must be 
      Card[] bottomHalf = new Card[cards.length /2];     //bigger
      
      for (g = 0; g <= cards.length / 2; g++)
      {
        topHalf[g] = cards[g];
      }
      for (j = (cards.length / 2) + 1, g = 0; g < cards.length / 2; g++, j++)
      {
        bottomHalf[g] = cards[j]; 
      }
      for (g = 0, j = 0; g < cards.length; g += 2, j++)
      {
        shuffled[g] = topHalf[j]; //Notice interval flip
      }
      for (g = 0, j = 1; j < cards.length; j += 2, g++)
      {
        shuffled[j] = bottomHalf[g]; //Notice interval flip
      }
      cards = shuffled;
    }
  }
  public void cut(int position)
  {
    int g, j;
    Card[] aboveCut = new Card[position];
    Card[] cutAndDown = new Card[cards.length - position];
    Card[] deckAfterCut = new Card[cards.length];
    
    for (g = 0; g < position; g++) //Top "half"
    {
      aboveCut[g] = cards[g];
    }
    for (j = position, g = 0; g < cards.length - position; g++, j++)
    {
      cutAndDown[g] = cards[j]; //Bottom "half"
    }
    for (g = 0; g < cards.length - position; g++)
    {
      deckAfterCut[g] = cutAndDown[g];
    }
    for (j = cards.length - position, g = 0; g < position; g++, j++)
    {
      deckAfterCut[j] = aboveCut[g]; //Again TWO counters needed
    }
    cards = deckAfterCut;
  }
  public Card[] deal(int numCards)
  {
    Card[] beingDealt = new Card[numCards];
    Card[] stillInDeck = new Card[cards.length - numCards];
    int g, j;
    
    if (numCards <= cards.length)
    {
      for (g = 0; g < numCards; g++) //Cards out
      {
        beingDealt[g] = cards[g];
      }
      for (g = 0, j = numCards; j < cards.length; g++, j++) //What's left
      {
        stillInDeck[g] = cards[j];
      }
      cards = stillInDeck;
      return beingDealt;
    }
    else
    {
    throw new UnsupportedOperationException("Not enough cards left, sorry.");
    }
  }
}
