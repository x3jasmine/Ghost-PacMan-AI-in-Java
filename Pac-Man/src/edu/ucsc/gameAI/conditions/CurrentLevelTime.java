package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class CurrentLevelTime implements ICondition {
	
	
	int nMin;
	int nMax;
	public CurrentLevelTime (int min, int max){
		nMin = min;
		nMax = max;
	}

	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		return ((game.getCurrentLevelTime() > nMin) &&  
				(game.getCurrentLevelTime() < nMax));
	}
	

}
