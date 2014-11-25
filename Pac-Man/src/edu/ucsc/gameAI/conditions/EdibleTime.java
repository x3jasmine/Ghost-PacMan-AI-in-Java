package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Constants.GHOST;
import pacman.game.Game;

public class EdibleTime implements ICondition {
	
	GHOST gghost;
	int nMin;
	int nMax;
	public EdibleTime (GHOST ghost, int min, int max){
		gghost = ghost;
		nMin = min;
		nMax = max;	
	}

	@Override
	public boolean test(Game game) {
		return (game.getGhostEdibleTime(gghost) > nMin && 
				game.getGhostEdibleTime(gghost) < nMax);
	}

}
