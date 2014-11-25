package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class TimeOfLastGlobalReversal implements ICondition {
	
	int nMin;
	int nMax;
	public TimeOfLastGlobalReversal(int min, int max){
		nMin = min;
		nMax = max;
	}

	@Override
	public boolean test(Game game) {
		return game.getTimeOfLastGlobalReversal() > nMin && 
				game.getTimeOfLastGlobalReversal() < nMax;
	}

}
