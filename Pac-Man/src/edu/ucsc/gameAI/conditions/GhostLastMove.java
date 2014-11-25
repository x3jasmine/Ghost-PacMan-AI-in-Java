package edu.ucsc.gameAI.conditions;

import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class GhostLastMove implements ICondition {
	
	GHOST gghost;
	MOVE mmove;
	public GhostLastMove(GHOST ghost, MOVE move){
		gghost = ghost;
		mmove= move;
	}

	@Override
	public boolean test(Game game) {
		return game.getGhostLastMoveMade(gghost) == mmove;
	}

}
