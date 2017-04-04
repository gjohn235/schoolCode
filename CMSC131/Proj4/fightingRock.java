package fighters;

import framework.BattleField;

public class FightingRock  //Warrior exists and attacks
{
  public final static int INITIAL_HEALTH = 20;
  public final static int ARMOR = 10;
  public final static int STRENGTH = 39;
  public final static int SKILL = 31;
  public final BattleField battleField;
  public int row, col;
  public int g, j, same, above, right, below, left;
  public int health;
  public final int team;
  

  public FightingRock(BattleField battleFieldIn, int teamIn, int rowIn,
      int colIn)
  { //Tells Warrior what he is
    health = INITIAL_HEALTH;
    team = teamIn;
    battleField = battleFieldIn;
    row = rowIn;
    col = colIn;
  }
  public void scanBattleField() //Looks over battleField
  { //Use LOWERCASE "b" for "battleField" ignore CMSC class web page
     g = battleField.getRows();
     j = battleField.getCols();
  }
  public void lookAroundYou() //Warrior looks around his immediate area
  {
    same = battleField.get(row, col);
    above = battleField.get(row - 1, col);
    right = battleField.get(row, col + 1);
    below = battleField.get(row + 1, col);
    left = battleField.get(row, col - 1);
  }
  public void killKommand() //Warrior attacks in clockwise motion
  {
    if ((team == BattleField.BLUE_TEAM && above == BattleField.RED_TEAM) ||
        (team == BattleField.RED_TEAM && above == BattleField.BLUE_TEAM))
    {
      battleField.attack(row -1, col);
    }
    else
      
      if ((team == BattleField.BLUE_TEAM && right == BattleField.RED_TEAM) ||
        (team == BattleField.RED_TEAM && right == BattleField.BLUE_TEAM))
      {
        battleField.attack(row, col + 1);
      }
    else
      
      if ((team == BattleField.BLUE_TEAM && below == BattleField.RED_TEAM) ||
        (team == BattleField.RED_TEAM && below == BattleField.BLUE_TEAM))
      {
        battleField.attack(row + 1, col);
      }
    else
      
      if ((team == BattleField.BLUE_TEAM && left == BattleField.RED_TEAM) ||
        (team == BattleField.RED_TEAM && left == BattleField.BLUE_TEAM))
      {
        battleField.attack(row, col - 1);
      }
  }
  public void performMyTurn() //SUCCESS! Warrior scans, gathers immediate
  {                           //surroundings and attacks, in that order
    scanBattleField();
    lookAroundYou();
    killKommand();
  }
  
}
