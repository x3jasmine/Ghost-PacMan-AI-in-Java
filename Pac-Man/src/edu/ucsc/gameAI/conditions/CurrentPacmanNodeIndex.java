package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class CurrentPacmanNodeIndex implements ICondition {
	
	int nIndex;
	public CurrentPacmanNodeIndex (int index){
		nIndex = index;
	}

	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		return game.getPacmanCurrentNodeIndex() == nIndex;
	}

}
