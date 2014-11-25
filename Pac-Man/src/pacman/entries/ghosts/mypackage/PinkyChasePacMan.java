package pacman.entries.ghosts.mypackage;

//import pacman.game.Constants;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.IAction;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class PinkyChasePacMan implements IAction, IBinaryNode {

	//MOVE move;
	//boolean pacDown, pacUp, pacLeft, pacRight = false;
	int pCurrent, pacCurrent;
	@Override
	public void doAction() {
	
	}
	
	@Override
	public MOVE getMove() {
		
		return MOVE.NEUTRAL;
	}
	
		@Override
	public IAction makeDecision(Game game) {
		return this;
	}

	@Override
	public MOVE getMove(Game game) {
		//int gCurrent = game.getGhostCurrentNodeIndex(GHOST.BLINKY);
		//iCurrent = game.getGhostCurrentNodeIndex(GHOST.INKY);
		pCurrent = game.getGhostCurrentNodeIndex(GHOST.PINKY);
		//int sCurrent = game.getGhostCurrentNodeIndex(GHOST.SUE);
		//checking for PacMan's node
		pacCurrent = game.getPacmanCurrentNodeIndex();

		//Inky's target is twice the length of Blinky's
		return game.getApproximateNextMoveTowardsTarget(pCurrent, pacCurrent, game.getGhostLastMoveMade(GHOST.PINKY), DM.PATH);

		}
}
