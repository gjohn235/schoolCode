package GUI;

import framework.Controller;

public class Driver {

  private final static String RED_TEAM= "FightingRock";
  private final static String BLUE_TEAM= "Smart";
  private final static int ROWS= 14;
  private final static int COLS= 28;
  private final static int TEAM_SIZE= 50;
  private final static int OBSTACLES= 30;

  public static void main(String[] args) {
    new Controller(RED_TEAM, BLUE_TEAM, ROWS, COLS, TEAM_SIZE, OBSTACLES);
  }

}
