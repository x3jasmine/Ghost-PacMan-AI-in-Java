package pacman.entries.ghosts.mypackage;

//import pacman.game.Constants;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.IAction;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class PinkyFrightened implements IAction, IBinaryNode {

	//MOVE move;
	//boolean pacDown, pacUp, pacLeft, pacRight = false;
	int targetNode;
	int pCurrent, pacCurrent;
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
		pCurrent = game.getGhostCurrentNodeIndex(GHOST.PINKY); 
		targetNode = game.getPowerPillIndices()[2];	//sets target to the top right corner
		//checking for PacMan's node
		pacCurrent = game.getPacmanCurrentNodeIndex();
		//double distance = game.getDistance(pCurrent, pacCurrent, game.getGhostLastMoveMade(GHOST.PINKY), DM.PATH);
		double distancefromTarget = game.getDistance(pCurrent, targetNode, game.getGhostLastMoveMade(GHOST.PINKY), DM.PATH);

		/*
		if (distance <= distancefromTarget){
			//return game.getNextMoveAwayFromTarget(pCurrent, pacCurrent, game.getGhostLastMoveMade(GHOST.PINKY), DM.PATH);
		}
		*/
		
		int[] pills = game.getActivePillsIndices();
		//for(int i=0;i<pills.length;i++)
			 distance = game.getFarthestNodeIndexFromNodeIndex(pacCurrent, pills, DM.PATH);
		
		return game.getApproximateNextMoveAwayFromTarget(pCurrent, targetNode, game.getGhostLastMoveMade(GHOST.PINKY), DM.PATH);

		}
}
