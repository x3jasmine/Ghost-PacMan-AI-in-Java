package pacman.entries.ghosts.mypackage;

//import pacman.game.Constants;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.IAction;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class BlinkyChasePacMan implements IAction, IBinaryNode {

	//MOVE move;
	//boolean pacDown, pacUp, pacLeft, pacRight = false;
	int gCurrent, iCurrent, pCurrent, sCurrent, targetNode, pacCurrent, pacx, pacy, increaseX, increaseY, decreaseX, decreaseY, targetX, targetY;
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
		//checking for BLINKY's node
		gCurrent = game.getGhostCurrentNodeIndex(GHOST.BLINKY);
		//iCurrent = game.getGhostCurrentNodeIndex(GHOST.INKY);
		//pCurrent = game.getGhostCurrentNodeIndex(GHOST.PINKY);
		//sCurrent = game.getGhostCurrentNodeIndex(GHOST.SUE);
		//checkin for PacMan's node
		pacCurrent = game.getPacmanCurrentNodeIndex();
		
		/*
		pacx = game.getNodeXCood(pacCurrent);
		pacy = game.getNodeYCood(pacCurrent);
		System.out.println("X, Y: " + pacx + ", " + pacy);

		increaseX = ++pacx;
		increaseY = ++pacy;
		decreaseX = --pacx;
		decreaseY = --pacy;

		System.out.println("increaseX: " + increaseX);
		System.out.println("increaseY: " + increaseY);
		System.out.println("decreaseX: " + decreaseX);
		System.out.println("decreaseY: " + decreaseY);

		if (increaseX == pacx && (pacy == increaseY || pacy == decreaseY)){ //pacman is right down since both X value's are increasing
			targetX = pacx - 1;
			
			//targetNode.
			
			System.out.println("targetX: " + targetX + ", " + increaseX);
			System.out.println("Pacman: RIGHT");
		}
		else if (decreaseX == pacx && pacx < increaseX){ //pacman is going left
			targetX = pacx + 1;
			targetNode = game.getCurrentMaze().graph[targetX].x;
			System.out.println("Pacman: LEFT");
		}
		else if (increaseY == pacy && (pacx == increaseX || pacx == increaseX)){ //pacman is going down
			targetY = pacy - 1;
			targetNode = game.getCurrentMaze().graph[targetY].y;
			System.out.println("Pacman: DOWN");
		}
		else if (decreaseY == pacy && (pacx == increaseX || pacx == increaseX)){ //pacman is going up
			targetY = pacy + 1;
			targetNode = game.getCurrentMaze().graph[targetY].y;
			System.out.println("Pacman: UP");
		}
		else System.out.println("NOTHING");
		
		System.out.println("TARGETNODE: " + game.getNodeXCood(targetNode) + " , " + game.getNodeYCood(targetNode));

		*/
		//Blinky's target is PacMan
		return game.getApproximateNextMoveTowardsTarget(gCurrent, pacCurrent, game.getGhostLastMoveMade(GHOST.BLINKY), DM.PATH);
		

		}
}
