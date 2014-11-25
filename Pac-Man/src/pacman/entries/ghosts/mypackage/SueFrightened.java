package pacman.entries.ghosts.mypackage;

//import pacman.game.Constants;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.IAction;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class SueFrightened implements IAction, IBinaryNode {

	//MOVE move;
	//boolean pacDown, pacUp, pacLeft, pacRight = false;
	int targetNode;
	int sCurrent, pacCurrent, distance;
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
		//double distance = game.getDistance(sCurrent, pacCurrent, game.getGhostLastMoveMade(GHOST.SUE), DM.PATH);
		double distancefromTarget = game.getDistance(sCurrent, targetNode, game.getGhostLastMoveMade(GHOST.SUE), DM.PATH);

		/*
		if (distance <= distancefromTarget){
			//return game.getNextMoveAwayFromTarget(sCurrent, pacCurrent, game.getGhostLastMoveMade(GHOST.SUE), DM.PATH);
		}
		*/
		
		int[] pills = game.getActivePillsIndices();
		//for(int i=0;i<pills.length;i++)
			 distance = game.getFarthestNodeIndexFromNodeIndex(pacCurrent, pills, DM.PATH);
		
		//Sue's target will be Pacman until 8 Euclidean distance
		return game.getApproximateNextMoveTowardsTarget(sCurrent, targetNode, game.getGhostLastMoveMade(GHOST.SUE), DM.PATH);

		}
}
