package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class MazeIndex implements ICondition {
	
	int nIndex;
	public MazeIndex (int index){
		nIndex = index;
	}

	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		//return false;
		return game.getMazeIndex() == nIndex;
	}

}
