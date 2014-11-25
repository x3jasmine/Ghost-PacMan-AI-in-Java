package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class LevelCount implements ICondition {
	
	int nLevel;
	public LevelCount (int level){
		
		nLevel= level;
		
	}

	@Override
	public boolean test(Game game) {
		// TODO Auto-generated method stub
		//return false;
		return game.getCurrentLevel() == nLevel;
	}

}
