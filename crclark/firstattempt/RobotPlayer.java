package firstattempt;

import java.util.Random;

import battlecode.common.*;

public class RobotPlayer {
	static Direction[] directions = {Direction.NORTH, Direction.NORTH_EAST, Direction.EAST, Direction.SOUTH_EAST,
            Direction.SOUTH, Direction.SOUTH_WEST, Direction.WEST, Direction.NORTH_WEST};
    static RobotType[] robotTypes = {RobotType.SCOUT, RobotType.SOLDIER, RobotType.SOLDIER, RobotType.SOLDIER,
            RobotType.GUARD, RobotType.GUARD, RobotType.VIPER, RobotType.TURRET};
    static Random rand;
    
	public static void run(RobotController rc){
		
        rand = new Random(rc.getID());
        
		
		
		while(true){
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
	    	if (rc.getType() == RobotType.ARCHON){
				int fate = rand.nextInt(1000);
				RobotType typeToBuild = robotTypes[fate % 8];
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
		
	}
	public static void turretMethod(RobotController rc){
		
	}
	public static void ttmMethod(RobotController rc){
		
	}
	public static void viperMethod(RobotController rc){
		
	}
}
