package pacman.entries.ghosts.mypackage;

import pacman.game.Constants.GHOST;
import pacman.game.Game;
import pacman.game.Constants.DM;
import edu.ucsc.gameAI.ICondition;

public class GhostScatterCond implements ICondition {

	/*
	int currTime;
	public GhostScatterCond(int currTime){
		this.currTime = currTime;
	}
	 */

	/*
	double minDistance;
	public GhostScatterCond(double minDistance){
		this.minDistance = minDistance;
	}
	 */
	boolean closeToPill;
	GHOST ghost;
	public GhostScatterCond(GHOST ghost){
		//this.closeToPill = closeToPill;
		this.ghost = ghost;
	}


	@Override
	public boolean test(Game game) {
		/*
		int leveltime = 150;
		if (currTime > leveltime*3 && currTime < leveltime*4){ //second scatter wave
			return true;
		}
		else if (currTime > leveltime*6 && currTime < leveltime*7) { //third scatter wave
			return true;
		}
		else if (currTime > leveltime*9 && currTime < leveltime*10) { //forth scatter wave
			return true;
		}				

		return false;
		 */

		//if (closeToPill){
			
			int PILL_PROXIMITY = 40;
			int pacmanIndex=game.getPacmanCurrentNodeIndex();
			int[] powerPillIndices=game.getActivePowerPillsIndices();
			int ghostNode = game.getGhostCurrentNodeIndex(ghost);
			//System.out.println("SCATTER~~~~~~~~~~~~~~");

			for(int i=0;i<powerPillIndices.length;i++){
				//double distance = game.getDistance(pacmanIndex, powerPillIndices[i], DM.PATH);
				//if(game.getDistance(pacmanIndex, powerPillIndices[i], DM.PATH)<minDistance){
				int ghostDis = game.getShortestPathDistance(ghostNode, powerPillIndices[i], game.getGhostLastMoveMade(ghost));
				if(game.getShortestPathDistance(pacmanIndex, powerPillIndices[i])<=PILL_PROXIMITY){

					//System.out.println("PACMAN IS CLOSE");
					return true;
				}
			}
			
			//return true;
		//}
		return false;

	}

}
