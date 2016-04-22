package firstattempt;

import battlecode.common.*;

public class RobotPlayer {
	public static void run(RobotController rc){
		if (rc.getType() == RobotType.ARCHON){
			RobotInfo[] nearby = rc.senseNearbyRobots(1);
			Boolean[][] bordering = new Boolean[3][3];
			MapLocation myLocation = rc.getLocation();
			for (RobotInfo robot: nearby){
				int relativeX = (robot.location.x - myLocation.x + 1);
				int relativeY = (robot.location.y - myLocation.y - 1);
				bordering[relativeX][relativeY] = true;
			}
		}
		
		while(true){
			switch (rc.getType()) {
			case ARCHON: archonMethod();
				break;
			case GUARD: guardMethod();
				break;
			case SCOUT: scoutMethod();
				break;
			case SOLDIER: soldierMethod();
				break;
			case TURRET: turretMethod();
				break;
			case TTM: ttmMethod();
				break;
			case VIPER: viperMethod();
				break;
			default: soldierMethod();
				break;
			}
			
			Clock.yield();
		}
		
	}
	public static void archonMethod(){
		
	}
	public static void guardMethod(){
		
	}
	public static void scoutMethod(){
		
	}
	public static void soldierMethod(){
		
	}
	public static void turretMethod(){
		
	}
	public static void ttmMethod(){
		
	}
	public static void viperMethod(){
		
	}
}
