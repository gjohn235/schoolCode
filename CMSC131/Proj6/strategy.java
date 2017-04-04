package blackjack;

public class Strategy
{

  /*
   * Blackjack strategy.  Has access to the player's cards, the face-up card
   * of the dealer, and all cards seen so far (perfect memory).
   *
   * Returns "true" for hit and "false" for stand.
   * 
   * This simple version follows the default hit for hand values of 17 or
   * less, stand otherwise.
   */
  public static boolean blackjackStrategy(Card[] playerCards,
                                          Card dealerFaceUpCard,
                                          Card[] seenCards) {
    int bestVal= BestHandFinder.getBestValue(
                                  BestHandFinder.evaluateHand(playerCards));

    if (bestVal <= 17)
      return true;
    else return false;
  }
}
