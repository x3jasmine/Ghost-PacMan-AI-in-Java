package edu.ucsc.gameAI.conditions;

import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class PacmanLastMove implements ICondition {

	MOVE mmove;
	public PacmanLastMove (MOVE move){
		mmove = move;
	}
	
	@Override
	public boolean test(Game game) {
		return game.getPacmanLastMoveMade() == mmove;
	}

}
