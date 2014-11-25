package pacman.entries.pacman;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import edu.ucsc.gameAI.*;
import edu.ucsc.gameAI.conditions.*;
import edu.ucsc.gameAI.fsm.ITransition;
import edu.ucsc.gameAI.fsm.State;
import edu.ucsc.gameAI.fsm.StateMachine;
import edu.ucsc.gameAI.fsm.Transition;
import pacman.controllers.Controller;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;

/*
 * This is the class you need to modify for your entry. In particular, you need to
 * fill in the getAction() method. Any additional classes you write should either
 * be placed in this package or sub-packages (e.g., game.entries.pacman.mypackage).
 */
public class MyPacMan extends Controller<MOVE>
{
	private MOVE myMove=MOVE.NEUTRAL;
	int ix1 = 0;
	int ix2 = 110;
	int iy1 = 0;
	int iy2 = 60;
	int iy3 = 120;
	State stateRun;
	State stateChase;
	Transition transScared;
	LinkedList<ITransition> listtscared ;
	Transition transCool ;
	LinkedList<ITransition> listtcool ;
	StateMachine fsm ;
	Game game;
	//GHOST ghost;
	private static final int MIN_DISTANCE=20;
	
	public MOVE getMove(Game game, long timeDue) 
	{

		for (GHOST ghost : GHOST.values()){
			int i = 0;
			if (game.wasPowerPillEaten() == true)
				if (game.isGhostEdible(ghost)){
					i++;
			}
		}
		
		int pacmanNode=game.getPacmanCurrentNodeIndex();
		int pacx = game.getNodeXCood(pacmanNode);
		int pacy = game.getNodeYCood(pacmanNode);
		this.game = game;
		//Place your game logic here to play the game as Ms Pac-Man
		//create fsm		
		stateRun = new State();
		stateRun.setAction(new RunAway());	
		
		stateChase = new State();
		stateChase.setAction(new EatPills());
		
		transScared = new Transition();
		transScared.setCondition(new GhostInRegion(pacx-2, pacy-2, pacx+2, pacy+2)); // top half of the screen
		transScared.setTargetState(stateChase);		
		
		listtscared = new LinkedList<ITransition>();
		listtscared.add(transScared);	
		
		transCool = new Transition();
		//transCool.setCondition(new GhostLocationFromPacMan(pacx-1, pacy-1, pacx+1, pacy+1)); // bottom of screen (screen is (4,4) to (104,116))
		transCool.setTargetState(stateRun);	
		
		listtcool = new LinkedList<ITransition>();
		listtcool.add(transCool);	
		
		stateRun.setTransitions(listtcool);
		stateChase.setTransitions(listtscared);
		
		
		
		
		fsm = new StateMachine();
		fsm.setCurrentState(stateChase);
		//everytime pacman can move somewhere
		//is a neutral action being returned
		fsm.update(game);
		System.out.println("ARRAY SIZE:" + fsm.update(game).size());

		Collection<IAction> actionList = new LinkedList<IAction>();
		actionList.add(fsm.getCurrentState().getAction());
		System.out.println("ActionList Size: " + actionList.size());
		MOVE move = fsm.getCurrentState().getAction().getMove();
		MOVE move2 = fsm.getCurrentState().getAction().getMove(game);
		//System.out.println("PowerPillEaten?: " + game.wasPowerPillEaten());
		
		if (fsm.getCurrentState() == stateChase){
			System.out.println("In STATECHASE");
			return move2;
		}
		else {
			System.out.println("In Other");
			return move2;
			}
	}
	
	MOVE lookForPills(Game game) {
		int current=game.getPacmanCurrentNodeIndex();
		this.game = game;
		int[] pills=game.getPillIndices();
		int[] powerPills=game.getPowerPillIndices();		
		
		ArrayList<Integer> targets=new ArrayList<Integer>();
		
		for(int i=0;i<pills.length;i++)					//check which pills are available			
			if(game.isPillStillAvailable(i))
				targets.add(pills[i]);
		
		for(int i=0;i<powerPills.length;i++)			//check with power pills are available
			if(game.isPowerPillStillAvailable(i))
				targets.add(powerPills[i]);				
		
		int[] targetsArray=new int[targets.size()];		//convert from ArrayList to array
		
		for(int i=0;i<targetsArray.length;i++)
			targetsArray[i]=targets.get(i);
		
		//return the next direction once the closest target has been identified
		return game.getNextMoveTowardsTarget(current,game.getClosestNodeIndexFromNodeIndex(current,targetsArray,DM.PATH),DM.PATH);
	}
	
}