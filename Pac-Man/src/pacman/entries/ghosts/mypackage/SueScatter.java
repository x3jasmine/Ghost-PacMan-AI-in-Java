package pacman.entries.ghosts.mypackage;

//import pacman.game.Constants;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.IAction;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class SueScatter implements IAction, IBinaryNode {

	//MOVE move;
	//boolean pacDown, pacUp, pacLeft, pacRight = false;
	int targetNode;
	int sCurrent, pacCurrent;
	int distance;
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
		sCurrent = game.getGhostCurrentNodeIndex(GHOST.SUE);
		targetNode = game.getPowerPillIndices()[3]; 	//sets target to bottom left corner
		//checking for PacMan's node
		pacCurrent = game.getPacmanCurrentNodeIndex();
		//Sue's target will be Pacman until 8 Euclidean distance
		
		int[] pills = game.getActivePillsIndices();
			 distance = game.getFarthestNodeIndexFromNodeIndex(pacCurrent, pills, DM.PATH);
		
		return game.getApproximateNextMoveTowardsTarget(sCurrent, distance, game.getGhostLastMoveMade(GHOST.SUE), DM.PATH);

		}
}
