package fighters;

import framework.BattleField;

public class CannonFodder //Warrior simply exist on battlefield to die
{
  public final static int INITIAL_HEALTH = 75;
  public final static int ARMOR = 23;
  public final static int STRENGTH = 1;
  public final static int SKILL = 1;
  public final BattleField battleField;
  public int row, col;
  public int health;
  public final int team;

  public CannonFodder(BattleField battleFieldIn, int teamIn, int rowIn,
      int colIn)
  { //Tells Warrior what he is
    health = INITIAL_HEALTH;
    team = teamIn;
    battleField = battleFieldIn;
    row = rowIn;
    col = colIn;
  }
  public void performMyTurn()
  {
    
  }
}
