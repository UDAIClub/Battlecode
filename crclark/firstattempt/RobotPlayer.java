package crclark.firstattempt;

import java.util.Random;

import battlecode.common.*;

public class RobotPlayer {
  static Direction[] directions = {Direction.NORTH, Direction.NORTH_EAST, Direction.EAST, Direction.SOUTH_EAST,
    Direction.SOUTH, Direction.SOUTH_WEST, Direction.WEST, Direction.NORTH_WEST};
  static RobotType[] robotTypes = {RobotType.SCOUT, RobotType.SOLDIER, RobotType.SOLDIER, RobotType.SOLDIER,
    RobotType.GUARD, RobotType.GUARD, RobotType.VIPER, RobotType.TURRET};
  static Random rand;
  static Team myTeam;
  static Team enemyTeam;

  public static void run(RobotController rc){

    Team myTeam = rc.getTeam();
    Team enemyTeam = myTeam.opponent();
    rand = new Random(rc.getID());
    



    while(true){
    	System.out.println("My Team: " + myTeam);
    	System.out.println("Enemy Team: "+ enemyTeam);
      switch (rc.getType()) {
        case ARCHON: archonMethod(rc);
                     break;
        case GUARD: guardMethod(rc);
                    break;
        case SCOUT: scoutMethod(rc);
                    break;
        case SOLDIER: soldierMethod(rc);
                      break;
        case TURRET: turretMethod(rc);
                     break;
        case TTM: ttmMethod(rc);
                  break;
        case VIPER: viperMethod(rc);
                    break;
        default: soldierMethod(rc);
                 break;
      }

      Clock.yield();
    }

  }
  public static void archonMethod(RobotController rc){
    try {
	  	if(rc.isCoreReady()){
		      int fate = rand.nextInt(1000);
		      RobotType typeToBuild = robotTypes[2];
		      Direction dirToBuild = directions[rand.nextInt(8)];
		      for (int i = 0; i < 8; i++) {
		        // If possible, build in this direction
		        if (rc.canBuild(dirToBuild, typeToBuild)) {
		          rc.build(dirToBuild, typeToBuild);
		          break;
		        } else {
		          // Rotate the direction to try
		          dirToBuild = dirToBuild.rotateLeft();
		        }
		      }
	  	}

    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }

  }
  public static void guardMethod(RobotController rc){

  }
  public static void scoutMethod(RobotController rc){

  }
  public static void soldierMethod(RobotController rc){
    try {
      int myAttackRange = rc.getType().attackRadiusSquared; 
      int fate = rand.nextInt(1000);
      boolean shouldAttack = false;
      RobotInfo target;

      // If this robot type can attack, check for enemies within range and attack one
      if (myAttackRange > 0) {
        RobotInfo[] enemiesWithinRange = rc.senseNearbyRobots(myAttackRange, enemyTeam);
        RobotInfo[] zombiesWithinRange = rc.senseNearbyRobots(myAttackRange, Team.ZOMBIE);
        RobotInfo[] hostilesWithinRange = rc.senseHostileRobots(rc.getLocation(), myAttackRange);
        if (hostilesWithinRange.length > 0){
          shouldAttack = true;
          if (rc.isCoreReady()){
          	//Check if weapon is ready
	        if (enemiesWithinRange.length > 0) {
	          shouldAttack = true;
	          // Check if weapon is ready
	          if (rc.isWeaponReady()) {
	            rc.attackLocation(enemiesWithinRange[rand.nextInt(enemiesWithinRange.length)].location);
	          }
	        } else if (zombiesWithinRange.length > 0) {
	          shouldAttack = true;
	          // Check if weapon is ready
	          if (rc.isWeaponReady()) {
	            rc.attackLocation(zombiesWithinRange[rand.nextInt(zombiesWithinRange.length)].location);
	          }
          	}
          }
        }
      }

      if (!shouldAttack) {
        if (rc.isCoreReady()) {
          if (fate < 600) {
            // Choose a random direction to try to move in
            Direction dirToMove = directions[fate % 8];
            // Check the rubble in that direction
            if (rc.senseRubble(rc.getLocation().add(dirToMove)) >= GameConstants.RUBBLE_OBSTRUCTION_THRESH) {
              // Too much rubble, so I should clear it
              rc.clearRubble(dirToMove);
              // Check if I can move in this direction
            } else if (rc.canMove(dirToMove)) {
              // Move
              rc.move(dirToMove);
            }
          }
        }
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }	
  }
  public static void turretMethod(RobotController rc){

  }
  public static void ttmMethod(RobotController rc){

  }
  public static void viperMethod(RobotController rc){

  }
}
