package pacman.entries.ghosts.mypackage;

//import pacman.game.Constants;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.IAction;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class InkyScatter implements IAction, IBinaryNode {

	//MOVE move;
	//boolean pacDown, pacUp, pacLeft, pacRight = false;
	int targetNode;
	int iCurrent, pacCurrent;
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
		iCurrent = game.getGhostCurrentNodeIndex(GHOST.INKY);
		targetNode = game.getPowerPillIndices()[1]; 	//sets target to bottom left corner
		//checking for PacMan's node
		pacCurrent = game.getPacmanCurrentNodeIndex();
		double distance = game.getDistance(iCurrent, pacCurrent, game.getGhostLastMoveMade(GHOST.INKY), DM.PATH);
		double distancefromTarget = game.getDistance(iCurrent, targetNode, game.getGhostLastMoveMade(GHOST.INKY), DM.PATH);

		if (distance < 15 || distance <= distancefromTarget){
			return game.getNextMoveAwayFromTarget(iCurrent, pacCurrent, game.getGhostLastMoveMade(GHOST.INKY), DM.PATH);
		}
		return game.getApproximateNextMoveTowardsTarget(iCurrent, targetNode, game.getGhostLastMoveMade(GHOST.INKY), DM.PATH);

		}
}
