package pacman.entries.ghosts.mypackage;

import pacman.game.Constants.GHOST;
import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class Crowded implements ICondition {

	GHOST ghost;
	public Crowded(GHOST ghost){
		this.ghost = ghost;
	}
	 
	/*
	double distance;
	public GhostChaseCond(){
	}
	*/

	@Override
	public boolean test(Game game) {	
		GHOST[] ghosts=GHOST.values();
		int CROWDED_DISTANCE=30;
        float distance=0;
        
        for (int i=0;i<ghosts.length-1;i++)
        	distance+=game.getShortestPathDistance(game.getGhostCurrentNodeIndex(ghosts[i]),game.getGhostCurrentNodeIndex(ghost));
        
        return (distance/6)<CROWDED_DISTANCE ? true : false;
	}
}
