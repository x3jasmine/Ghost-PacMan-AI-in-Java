package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class TotalTime implements ICondition {
	
	int nMin;
	int nMax;
	public TotalTime(int min, int max){
		nMin = min;
		nMax = max;
	}

	@Override
	public boolean test(Game game) {
		return (game.getTotalTime()> nMin && game.getTotalTime()< nMax);
	}

}
