package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class GhostEatScore implements ICondition {

	int nMin;
	int nMax;
	public GhostEatScore (int min, int max){
		nMin = min;
		nMax = max;
	}
	
	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		return game.getGhostCurrentEdibleScore() > nMin && 
				game.getGhostCurrentEdibleScore() < nMax;
	}

}
