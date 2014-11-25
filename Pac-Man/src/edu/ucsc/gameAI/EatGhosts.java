package edu.ucsc.gameAI;

//import pacman.game.Constants;
//import java.util.ArrayList;

import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class EatGhosts implements IAction, IBinaryNode {

	@Override
	public void doAction() {
		//move = Constants.MOVE.DOWN;
		
	}
	
	//@Override
	public MOVE getMove(Game game) {
		int current=game.getPacmanCurrentNodeIndex();
		int minDistance=Integer.MAX_VALUE;
		GHOST minGhost=null;		
		
		for(GHOST ghost : GHOST.values())
			if(game.getGhostEdibleTime(ghost)>0)
			{
				int distance=game.getShortestPathDistance(current,game.getGhostCurrentNodeIndex(ghost));
				
				if(distance<minDistance)
				{
					minDistance=distance;
					minGhost=ghost;
				}
			}
		
		if(minGhost!=null)	//we found an edible ghost
			return game.getNextMoveTowardsTarget(game.getPacmanCurrentNodeIndex(),game.getGhostCurrentNodeIndex(minGhost),DM.PATH);
		return MOVE.NEUTRAL;
	}
	
		@Override
	public IAction makeDecision(Game game) {
		return this;
	}

		@Override
		public MOVE getMove() {
			// TODO Auto-generated method stub
			return null;
		}
}
