package edu.ucsc.gameAI.conditions;

import pacman.game.Constants.GHOST;
import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class LairTime implements ICondition {
	
	GHOST gghost;
	int nMin;
	int nMax;
	public LairTime (GHOST ghost, int min, int max){
		gghost = ghost;
		nMin = min;
		nMax = max;	
	}

	@Override
	public boolean test(Game game) {
		return game.getGhostLairTime(gghost) > nMin && 
				game.getGhostLairTime(gghost) < nMax;
	}

}
