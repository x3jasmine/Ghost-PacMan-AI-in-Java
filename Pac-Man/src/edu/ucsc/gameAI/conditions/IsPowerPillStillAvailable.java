package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class IsPowerPillStillAvailable implements ICondition {

	int pIndex;
	public IsPowerPillStillAvailable(int pillIndex){
		pIndex = pillIndex;
	}
	
	@Override
	public boolean test(Game game) {
		return game.isPowerPillStillAvailable(pIndex);
	}

}
