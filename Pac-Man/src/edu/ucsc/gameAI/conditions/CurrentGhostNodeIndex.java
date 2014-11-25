package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import pacman.game.Constants.GHOST;
import edu.ucsc.gameAI.ICondition;

public class CurrentGhostNodeIndex implements ICondition {
	
	GHOST gghost;
	int nIndex;
	public CurrentGhostNodeIndex (GHOST ghost, int index){
		gghost = ghost;
		nIndex = index;
	}
	
	@Override
	public boolean test(Game game) {
		return game.getGhostCurrentNodeIndex(gghost) == nIndex;
	}

}
