package fighters;

import framework.BattleField;
import framework.Random131;

public class BasicSoldier //Warrior exist, attacks, and traverses battlefield
{
  public final static int INITIAL_HEALTH = 20;
  public final static int ARMOR = 10;
  public final static int STRENGTH = 39;
  public final static int SKILL = 31;
  public final BattleField battleField;
  public int row, col;
  public int g, d, j, same, above, right, below, left;
  public int health;
  public final int team;
  

  public BasicSoldier(BattleField battleFieldIn, int teamIn, int rowIn,
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
    else
      
      move();    
  }
  public void move() //Warrior moves in clockwise direction
  {
    if (above == BattleField.EMPTY)
    {
      row = row - 1;
    }
  else
    
    if (right == BattleField.EMPTY)
    {
      col = col + 1;
    }
  else
    
    if (below == BattleField.EMPTY)
    {
      row = row + 1;
    }
  else
    
    if (left == BattleField.EMPTY)
    {
      col = col - 1;
    }
  }
  public boolean canMove() //Warrior looks for open space to move to
  { //Really serves no purpose in code, strictly to pass public test
    same = battleField.get(row, col);
    above = battleField.get(row - 1, col);
    right = battleField.get(row, col + 1);
    below = battleField.get(row + 1, col);
    left = battleField.get(row, col - 1);
    
    if (above == BattleField.EMPTY || right == BattleField.EMPTY || below ==
        BattleField.EMPTY || left == BattleField.EMPTY)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  public int numberOfEnemiesRemaining() //Counting enemies
  {
    int rowCount, colCount;
    int enemy = 0, enemyCount = 0;
    
    if (team == BattleField.BLUE_TEAM)
    {
      for (rowCount = 0; rowCount < row; rowCount++)
      {
        for (colCount = 0; colCount < col; colCount++)
        {
          if (battleField.get(row, col)  == BattleField.RED_TEAM)
          {
            enemyCount++;
          }
        }
      }
    }
    else
    {
      if (team == BattleField.RED_TEAM)
      {
        for (rowCount = 0; rowCount < row; rowCount++)
        {
          for (colCount = 0; colCount < col; colCount++)
          {
            if (battleField.get(row, col)  == enemy)
            {
              enemyCount++;
            }
          }
        }
      }
    }
    return enemyCount;
  }
  public void performMyTurn() //SUCCESS! Warrior scans, gathers immediate
  {                           //surroundings, and attacks if possible, in that
    scanBattleField();        //order. If attack is not possible, search for 
    lookAroundYou();          //open space and move into it.
    killKommand();
  }
}
