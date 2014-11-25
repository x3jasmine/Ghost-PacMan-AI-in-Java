package edu.ucsc.gameAI;

import pacman.game.Constants.MOVE;
//import pacman.game.Constants;
import pacman.game.Game;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class GoUpAction implements IAction, IBinaryNode {
	//MOVE move;
	@Override
	public void doAction() {
		//move = Constants.MOVE.UP;
		
	}
	
	@Override
	public MOVE getMove() {
		//doAction();
		return MOVE.UP;
	}
	@Override
	public IAction makeDecision(Game game) {
		return this;
	}

	@Override
	public MOVE getMove(Game game) {
		// TODO Auto-generated method stub
		return null;
	}

}
