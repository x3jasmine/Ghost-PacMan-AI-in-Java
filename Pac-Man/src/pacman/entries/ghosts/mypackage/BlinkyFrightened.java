package pacman.entries.ghosts.mypackage;

//import pacman.game.Constants;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.IAction;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class BlinkyFrightened implements IAction, IBinaryNode {

	//MOVE move;
	//boolean pacDown, pacUp, pacLeft, pacRight = false;
	int targetNode;
	int bCurrent, pacCurrent;
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
		bCurrent = game.getGhostCurrentNodeIndex(GHOST.BLINKY); 
		targetNode = game.getPowerPillIndices()[1];	//sets target to the top right corner
		//checking for PacMan's node
		pacCurrent = game.getPacmanCurrentNodeIndex();
		//double distance = game.getDistance(bCurrent, pacCurrent, game.getGhostLastMoveMade(GHOST.BLINKY), DM.PATH);
		//double distancefromTarget = game.getDistance(bCurrent, targetNode, game.getGhostLastMoveMade(GHOST.BLINKY), DM.PATH);

		/*
		if (distance <= distancefromTarget){
			//return game.getNextMoveAwayFromTarget(bCurrent, pacCurrent, game.getGhostLastMoveMade(GHOST.BLINKY), DM.PATH);
		}
		*/
		
		int[] pills = game.getActivePillsIndices();
		//for(int i=0;i<pills.length;i++)
			 distance = game.getFarthestNodeIndexFromNodeIndex(pacCurrent, pills, DM.PATH);
		
		
		return game.getApproximateNextMoveTowardsTarget(bCurrent, distance, game.getGhostLastMoveMade(GHOST.BLINKY), DM.PATH);

		}
}
