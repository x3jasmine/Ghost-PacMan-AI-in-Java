package edu.ucsc.gameAI;

//import pacman.game.Constants;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class GoDownAction implements IAction, IBinaryNode {

	//MOVE move;
	@Override
	public void doAction() {
		//move = Constants.MOVE.DOWN;
		
	}
	
	@Override
	public MOVE getMove() {
		//doAction();
		return MOVE.DOWN;
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
