package pacman.entries.ghosts.mypackage;

//import pacman.game.Constants;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.IAction;
import edu.ucsc.gameAI.conditions.IsEdible;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class BlinkyScatter implements IAction, IBinaryNode {

	//MOVE move;
	//boolean pacDown, pacUp, pacLeft, pacRight = false;
	int targetNode;
	int bCurrent, pacCurrent;
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
		bCurrent = game.getGhostCurrentNodeIndex(GHOST.BLINKY); 
		targetNode = game.getPowerPillIndices()[3];	//sets target to the top right corner
		//checking for PacMan's node
		pacCurrent = game.getPacmanCurrentNodeIndex();
		int distance = game.getShortestPathDistance(bCurrent, pacCurrent);
		int distancefromTarget = game.getShortestPathDistance(bCurrent, targetNode);

		if (distance <= distancefromTarget){
			return game.getNextMoveAwayFromTarget(bCurrent, pacCurrent, game.getGhostLastMoveMade(GHOST.BLINKY), DM.PATH);
		}
		
		return game.getApproximateNextMoveTowardsTarget(bCurrent, targetNode, game.getGhostLastMoveMade(GHOST.BLINKY), DM.PATH);

		}
}
