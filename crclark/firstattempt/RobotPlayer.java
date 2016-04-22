package firstattempt;

import battlecode.common.*;

public class RobotPlayer {
	public static void run(RobotController rc){
		if (rc.getType() == RobotType.ARCHON){
			RobotInfo[] nearby = rc.senseNearbyRobots(1);
			Boolean[][] bordering = new Boolean[3][3];
			for (RobotInfo robot: nearby){
				if (robot.location.x == rc.getLocation().x){
					
				}
				if (robot.location.y == rc.getLocation().y){
					
				}
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
