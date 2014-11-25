package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class IsPillStillAvailable implements ICondition{
	
	int pIndex;
	public IsPillStillAvailable(int pillIndex){	
		pIndex= pillIndex;
	}

	@Override
	public boolean test(Game game) {
		return game.isPillStillAvailable(pIndex);
	}

}
