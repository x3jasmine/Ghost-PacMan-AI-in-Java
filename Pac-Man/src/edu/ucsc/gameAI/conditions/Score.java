package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class Score implements ICondition {

	int nMin;
	int nMax;
	public Score (int min, int max){
		nMin = min;
		nMax = max;
	}
	
	@Override
	public boolean test(Game game) {
		return game.getScore() > nMin && game.getScore() < nMax;
	}

}
