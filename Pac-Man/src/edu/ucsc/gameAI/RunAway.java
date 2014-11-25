package edu.ucsc.gameAI;

//import pacman.game.Constants;
//import java.util.ArrayList;

import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class RunAway implements IAction, IBinaryNode {

	private static final int MIN_DISTANCE=20;
	@Override
	public void doAction() {
		//move = Constants.MOVE.DOWN;
		
	}
	
	//@Override
	public MOVE getMove(Game game) {
		int current=game.getPacmanCurrentNodeIndex();
		for(GHOST ghost : GHOST.values()){
			if(game.getGhostEdibleTime(ghost)==0 && game.getGhostLairTime(ghost)==0)
				if(game.getShortestPathDistance(current,game.getGhostCurrentNodeIndex(ghost))<MIN_DISTANCE)
					return game.getNextMoveAwayFromTarget(game.getPacmanCurrentNodeIndex(),game.getGhostCurrentNodeIndex(ghost),DM.PATH);
		}
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
