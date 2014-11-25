package pacman.entries.ghosts.mypackage;

import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class GhostChaseCond implements ICondition {

	/*
	int currTime;
	public GhostChaseCond(int currTime){
		this.currTime = currTime;
	}
	 */

	//double distance;
	boolean farFromPill;
	GHOST ghost;
	public GhostChaseCond(GHOST ghost){
	//	this.farFromPill = farFromPill;
		this.ghost = ghost;
	}


	@Override
	public boolean test(Game game) {	
		/*
		int leveltime = 150;
		if (currTime >= leveltime && currTime <= leveltime*3){ //first chase wave
			return true;
		}
		else if (currTime >= leveltime*4 && currTime <= leveltime*6){ //second chase wave
			return true;
		}
		else if (currTime >= leveltime*7 && currTime <= leveltime*8) { //third chase wave
			return true;
		}
		else if (currTime >= leveltime*10) { //forth and final chase wave
			return true;					
		}
		return false;

		 */
		//if (farFromPill){
			
			int PILL_PROXIMITY = 45;
			int pacmanIndex=game.getPacmanCurrentNodeIndex();
			int[] powerPillIndices=game.getActivePowerPillsIndices();
			int ghostNode = game.getGhostCurrentNodeIndex(ghost);

			for(int i=0;i<powerPillIndices.length;i++){
				int distance = game.getShortestPathDistance(pacmanIndex, powerPillIndices[i]);
				int ghostDis = game.getShortestPathDistance(ghostNode, pacmanIndex, game.getGhostLastMoveMade(ghost));
				if(distance>PILL_PROXIMITY){
					//System.out.println("PACMAN IS FAR");
					return true;
				}

			}
			
			//return true;
		//}
		//System.out.println("PACMAN IS CLOSE");
		return false;

	}
}
