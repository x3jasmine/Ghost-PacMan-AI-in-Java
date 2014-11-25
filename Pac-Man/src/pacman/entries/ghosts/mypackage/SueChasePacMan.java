package pacman.entries.ghosts.mypackage;

//import pacman.game.Constants;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.IAction;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class SueChasePacMan implements IAction, IBinaryNode {

	//MOVE move;
	//boolean pacDown, pacUp, pacLeft, pacRight = false;
	int targetNode;
	int sCurrent, pacCurrent;
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
		//int pCurrent = game.getGhostCurrentNodeIndex(GHOST.PINKY);
		sCurrent = game.getGhostCurrentNodeIndex(GHOST.SUE);
		//checking for PacMan's node
		pacCurrent = game.getPacmanCurrentNodeIndex();
		
		//Sue's target will be Pacman until 8 Euclidean distance
		return game.getApproximateNextMoveTowardsTarget(sCurrent, pacCurrent, game.getGhostLastMoveMade(GHOST.SUE), DM.PATH);

		}
}
