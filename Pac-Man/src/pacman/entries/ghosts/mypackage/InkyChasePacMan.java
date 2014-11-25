package pacman.entries.ghosts.mypackage;

//import pacman.game.Constants;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.IAction;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class InkyChasePacMan implements IAction, IBinaryNode {

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
		int gCurrent = game.getGhostCurrentNodeIndex(GHOST.BLINKY);
		iCurrent = game.getGhostCurrentNodeIndex(GHOST.INKY);
		//int pCurrent = game.getGhostCurrentNodeIndex(GHOST.PINKY);
		//int sCurrent = game.getGhostCurrentNodeIndex(GHOST.SUE);
		//checking for PacMan's node
		pacCurrent = game.getPacmanCurrentNodeIndex();
		MOVE pacMove = game.getPacmanLastMoveMade();
		int[] pacmanNeighborNodes = game.getNeighbouringNodes(pacCurrent, pacMove);
		targetNode = game.getFarthestNodeIndexFromNodeIndex(gCurrent, pacmanNeighborNodes, DM.PATH);
		
		double blinkyDistance = game.getDistance(gCurrent, pacCurrent, game.getGhostLastMoveMade(GHOST.BLINKY), DM.PATH);
		//System.out.println("blinkyDistance: " + blinkyDistance);
		
		int inkyX = game.getNodeXCood(iCurrent);
		int inkyY = game.getNodeYCood(iCurrent);
		int pacx = game.getNodeXCood(pacCurrent);
		int pacy = game.getNodeYCood(pacCurrent);
		int targetX = game.getNodeXCood(targetNode);
		int targetY = game.getNodeYCood(targetNode);
		
		/*
		if (pacMove == MOVE.DOWN) {
			System.out.println("PACMAN LAST MOVE: DOWN");
			//targetNode.
		}
		else if (pacMove == MOVE.UP) {
			System.out.println("PACMAN LAST MOVE: UP");
		}
		else if (pacMove == MOVE.LEFT) {
			System.out.println("PACMAN LAST MOVE: LEFT");
		}
		else if (pacMove == MOVE.RIGHT) {
			System.out.println("PACMAN LAST MOVE: RIGHT");
		}
		
		

		//System.out.println("PACMAN LAST MOVE: " + pacMove);
		System.out.println("inky node: " + inkyX + ", " + inkyY);
		System.out.println("blinky node: " + game.getNodeXCood(gCurrent) + ", " + game.getNodeYCood(gCurrent));
		System.out.println("pacman node: " + pacx + ", " + pacy);
		System.out.println("targetNode node: " + targetX + ", " + targetY);
		*/
		//Inky's target is twice the length of Blinky's
		return game.getApproximateNextMoveTowardsTarget(iCurrent, targetNode, game.getGhostLastMoveMade(GHOST.INKY), DM.PATH);

		}
}
