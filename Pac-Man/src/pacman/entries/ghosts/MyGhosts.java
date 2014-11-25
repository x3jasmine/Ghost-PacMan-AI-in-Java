package pacman.entries.ghosts;

import java.util.EnumMap;
import java.util.LinkedList;

import pacman.controllers.Controller;
import pacman.entries.ghosts.mypackage.*;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.conditions.IsEdible;
import edu.ucsc.gameAI.fsm.ITransition;
import edu.ucsc.gameAI.fsm.State;
import edu.ucsc.gameAI.fsm.StateMachine;
import edu.ucsc.gameAI.fsm.Transition;

/*
 * This is the class you need to modify for your entry. In particular, you need to
 * fill in the getActions() method. Any additional classes you write should either
 * be placed in this package or sub-packages (e.g., game.entries.ghosts.mypackage).
 */
public class MyGhosts extends Controller<EnumMap<GHOST,MOVE>>
{
	private EnumMap<GHOST, MOVE> myMoves=new EnumMap<GHOST, MOVE>(GHOST.class);
	int PILL_PROXIMITY = 50;
	StateMachine fsmBlinky;
	State stateScatter;
	State stateChase;
	State stateFrightened;
	Transition transScatter;
	Transition transScatterEdible;
	Transition transCool ;
	Transition transCloserToPill;
	Transition transFrighten;
	LinkedList<ITransition> listtscatter ;
	LinkedList<ITransition> listtcool ;
	LinkedList<ITransition> listtfrighten ;

	StateMachine fsmInky;
	State stateScatterInky;
	State stateChaseInky;
	State stateFrightenedInky;
	Transition transScatterInky;
	Transition transScatterCrowdedInky;
	Transition transChaseInky ;
	Transition transFrightenInky;
	LinkedList<ITransition> listtscatterInky ;
	LinkedList<ITransition> listtchaseInky ;
	LinkedList<ITransition> listtfrightenInky ;

	StateMachine fsmPinky;
	State stateScatterPinky;
	State stateChasePinky;
	State stateFrightenedPinky;
	Transition transScatterPinky;
	Transition transScatterCrowdedPinky;
	Transition transEdiblePinky;
	Transition transChasePinky ;
	Transition transFrightenPinky;
	LinkedList<ITransition> listtscatterPinky ;
	LinkedList<ITransition> listtchasePinky ;
	LinkedList<ITransition> listtfrightenPinky ;
	
	StateMachine fsmSue;
	State stateScatterSue;
	State stateChaseSue;
	State stateFrightenedSue;
	Transition transScatterSue;
	Transition transScatterCrowdedSue;
	Transition transChaseSue ;
	Transition transFrightenSue;
	LinkedList<ITransition> listtscatterSue;
	LinkedList<ITransition> listtchaseSue ;
	LinkedList<ITransition> listtfrightenSue;

	public MyGhosts() {
		/*********** BLINKY FSM --START*********************/
		stateScatter = new State();
		stateScatter.setAction(new BlinkyScatter());
		stateScatter.setName("Scatter");

		stateChase = new State();
		stateChase.setAction(new BlinkyChasePacMan());
		stateChase.setName("Chase");

		/*
		stateFrightened = new State();
		stateFrightened.setAction(new BlinkyFrightened());
		stateFrightened.setName("Frightened");
		*/

		transScatter = new Transition();
		transScatter.setCondition(new GhostScatterCond(GHOST.BLINKY)); // checks if pacman is close to power pill
		transScatter.setTargetState(stateScatter);			
		transScatterEdible = new Transition();
		transScatterEdible.setCondition(new IsEdible(GHOST.BLINKY)); // checks if pacman is close to power pill
		transScatterEdible.setTargetState(stateScatter);	
		

		listtscatter = new LinkedList<ITransition>();
		listtscatter.add(transScatter);	
		listtscatter.add(transScatterEdible);	

		transCool = new Transition();
		transCool.setCondition(new GhostChaseCond(GHOST.BLINKY)); // 
		transCool.setTargetState(stateChase);
		transCloserToPill = new Transition();
		transCloserToPill.setCondition(new GhostIsCloserToPowerPill(GHOST.BLINKY)); // 
		transCloserToPill.setTargetState(stateChase);

		listtcool = new LinkedList<ITransition>();
		listtcool.add(transCool);	
		listtcool.add(transCloserToPill);
		
		/*
		transFrighten = new Transition();
		transFrighten.setCondition(new IsEdible(GHOST.BLINKY)); // if blinky is edible
		transFrighten.setTargetState(stateFrightened);	
*/
		listtfrighten = new LinkedList<ITransition>();
		listtfrighten.add(transFrighten);	

		stateScatter.setTransitions(listtcool);
		//stateScatter.setTransitions(listtfrighten);
		stateChase.setTransitions(listtscatter);
		//stateChase.setTransitions(listtfrighten);
		//stateFrightened.setTransitions(listtscatter);	
		//stateFrightened.setTransitions(listtcool);

		fsmBlinky = new StateMachine();
		fsmBlinky.setCurrentState(stateChase);
		
		/*********** BLINKY FSM --END*********************/
		
		/*********** INKY FSM --START*********************/
		
		stateScatterInky = new State();
		stateScatterInky.setAction(new InkyScatter());	
		stateScatterInky.setName("ScatterInky");

		stateChaseInky = new State();
		stateChaseInky.setAction(new InkyChasePacMan());
		stateChaseInky.setName("ChaseInky");

		/*
		stateFrightenedInky = new State();
		stateFrightenedInky.setAction(new InkyFrightened());
		stateFrightenedInky.setName("FrightenedInky");
*/
		transScatterInky = new Transition();
		transScatterInky.setCondition(new GhostScatterCond(GHOST.INKY)); // check if Sue is at > 8 Euclidean distance
		transScatterInky.setTargetState(stateScatterInky);
		
		transScatterCrowdedInky = new Transition();
		transScatterCrowdedInky.setCondition(new IsEdible(GHOST.INKY)); // checks if pacman is close to power pill
		transScatterCrowdedInky.setTargetState(stateScatterInky);	

		listtscatterInky = new LinkedList<ITransition>();
		listtscatterInky.add(transScatterInky);	
		listtscatterInky.add(transScatterCrowdedInky);	

		transChaseInky = new Transition();
		transChaseInky.setCondition(new GhostChaseCond(GHOST.INKY)); // check if Sue is < 8 Euclidean distance
		transChaseInky.setTargetState(stateChaseInky);

		listtchaseInky = new LinkedList<ITransition>();
		listtchaseInky.add(transChaseInky);	

		/*
		transFrightenInky = new Transition();
		transFrightenInky.setCondition(new IsEdible(GHOST.INKY)); // check if sue is edible
		transFrightenInky.setTargetState(stateFrightenedInky);	

		listtfrightenInky = new LinkedList<ITransition>();
		listtfrightenInky.add(transFrightenInky);	
*/
		stateScatterInky.setTransitions(listtchaseInky);
		stateChaseInky.setTransitions(listtscatterInky);
		//stateFrightenedInky.setTransitions(listtchaseInky);

		fsmInky = new StateMachine();
		fsmInky.setCurrentState(stateChaseInky);
		
		/*********** INKY FSM --END*********************/
		
		/*********** PINKY FSM --START*********************/
		
		stateScatterPinky = new State();
		stateScatterPinky.setAction(new PinkyScatter());	

		stateChasePinky = new State();
		stateChasePinky.setAction(new PinkyChasePacMan());

		stateFrightenedPinky = new State();
		stateFrightenedPinky.setAction(new PinkyFrightened());

		transScatterPinky = new Transition();
		transScatterPinky.setCondition(new GhostScatterCond(GHOST.PINKY));
		transScatterPinky.setTargetState(stateScatterPinky);
		
		transScatterCrowdedPinky = new Transition();
		transScatterCrowdedPinky.setCondition(new Crowded(GHOST.PINKY)); // checks if pacman is close to power pill
		transScatterCrowdedPinky.setTargetState(stateScatterPinky);	
		
		transEdiblePinky = new Transition();
		transEdiblePinky.setCondition(new IsEdible(GHOST.PINKY)); // checks if pacman is close to power pill
		transEdiblePinky.setTargetState(stateScatterPinky);
		

		listtscatterPinky = new LinkedList<ITransition>();
		listtscatterPinky.add(transScatterPinky);	
		listtscatterPinky.add(transScatterCrowdedPinky);
		listtscatterPinky.add(transEdiblePinky);

		transChasePinky = new Transition();
		transChasePinky.setCondition(new GhostChaseCond(GHOST.PINKY));
		transChasePinky.setTargetState(stateChasePinky);

		listtchasePinky = new LinkedList<ITransition>();
		listtchasePinky.add(transChasePinky);	

		/*
		transFrightenPinky = new Transition();
		transFrightenPinky.setCondition(new IsEdible(GHOST.PINKY));
		transFrightenPinky.setTargetState(stateFrightenedPinky);	

		listtfrightenPinky = new LinkedList<ITransition>();
		listtfrightenPinky.add(transFrightenPinky);	

*/
		stateScatterPinky.setTransitions(listtchasePinky);
		stateChasePinky.setTransitions(listtscatterPinky);
		//stateFrightenedPinky.setTransitions(listtchasePinky);

		fsmPinky = new StateMachine();
		fsmPinky.setCurrentState(stateChasePinky);
		
		/*********** PINKY FSM --END*********************/
		
		/*********** SUE FSM --START*********************/
		
		stateScatterSue = new State();
		stateScatterSue.setAction(new SueScatter());	
		stateScatterSue.setName("ScatterSue");

		stateChaseSue = new State();
		stateChaseSue.setAction(new SueChasePacMan());
		stateChaseSue.setName("ChaseSue");
		/*
		stateFrightenedSue = new State();
		stateFrightenedSue.setAction(new SueFrightened());
		*/

		transScatterSue = new Transition();
		transScatterSue.setCondition(new GhostScatterCond(GHOST.SUE)); // check if Sue is at > 8 Euclidean distance
		transScatterSue.setTargetState(stateScatterSue);
		
		transScatterCrowdedSue = new Transition();
		transScatterCrowdedSue.setCondition(new IsEdible(GHOST.SUE)); // checks if pacman is close to power pill
		transScatterCrowdedSue.setTargetState(stateScatterSue);	

		listtscatterSue = new LinkedList<ITransition>();
		listtscatterSue.add(transScatterSue);	
		listtscatterSue.add(transScatterCrowdedSue);	

		transChaseSue = new Transition();
		transChaseSue.setCondition(new GhostChaseCond(GHOST.SUE)); // check if Sue is < 8 Euclidean distance
		transChaseSue.setTargetState(stateChaseSue);

		listtchaseSue = new LinkedList<ITransition>();
		listtchaseSue.add(transChaseSue);	

		/*
		transFrightenSue = new Transition();
		transFrightenSue.setCondition(new IsEdible(GHOST.SUE)); // check if sue is edible
		transFrightenSue.setTargetState(stateFrightenedSue);	

		listtfrightenSue = new LinkedList<ITransition>();
		listtfrightenSue.add(transFrightenSue);	
		*/

		stateScatterSue.setTransitions(listtchaseSue);
		stateChaseSue.setTransitions(listtscatterSue);
		//stateFrightenedSue.setTransitions(listtchaseSue);

		fsmSue = new StateMachine();
		fsmSue.setCurrentState(stateChaseSue);
		
		/*********** SUE FSM --END*********************/
	}
	
	
	public EnumMap<GHOST, MOVE> getMove(Game game, long timeDue)
	{
		myMoves.clear();
		/*
		for(GHOST ghost : GHOST.values())	//for each ghost
		{
			//System.out.println("Pacman: RIGHT");
			BinaryDecision edibleBinaryDecision = new BinaryDecision();
			edibleBinaryDecision.setCondition(new IsEdible(ghost));
			edibleBinaryDecision.setTrueBranch(new GoLeftAction());
			edibleBinaryDecision.setFalseBranch(new GoRightAction());	

			if(game.doesGhostRequireAction(ghost))		//if ghost requires an action
			{
				if (edibleBinaryDecision.makeDecision(game).getClass() == GoLeftAction.class)
					myMoves.put(ghost,MOVE.LEFT);
				else
					myMoves.put(ghost,MOVE.RIGHT);
			}

			//System.out.println(ghost);		
		}				
		BLINKYDecision = new BinaryDecision();
		BLINKYDecision.setCondition(new IsEdible(GHOST.BLINKY));
		BLINKYDecision.setTrueBranch(new GoRightAction());
		BLINKYDecision.setFalseBranch(new BlinkyChasePacMan());
		myMoves.put(GHOST.BLINKY, BLINKYDecision.makeDecision(game).getMove(game));

		BinaryDecision INKYDecision = new BinaryDecision();
		INKYDecision.setCondition(new IsEdible(GHOST.INKY));
		INKYDecision.setTrueBranch(new GoRightAction());
		INKYDecision.setFalseBranch(new InkyChasePacMan());
		myMoves.put(GHOST.INKY, INKYDecision.makeDecision(game).getMove(game));

		//myMoves.put(GHOST.BLINKY, BLINKYDecision.makeDecision(game).getMove(game));
		 */
		
		for(GHOST ghost : GHOST.values())	//for each ghost
		{
			//if(game.doesGhostRequireAction(ghost))		//if ghost requires an action
			//{
				if (ghost == GHOST.BLINKY) {
					fsmBlinky.update(game);
					MOVE move = fsmBlinky.getCurrentState().getAction().getMove(game);
					myMoves.put(GHOST.BLINKY, move);
					//System.out.println("Blinky State is " + ((State)fsmBlinky.getCurrentState()).getName());
				}
				if (ghost == GHOST.PINKY){
					fsmPinky.update(game);
					MOVE move2 = fsmPinky.getCurrentState().getAction().getMove(game);
					myMoves.put(GHOST.PINKY, move2);
					//System.out.println("Pinky State");
				}
				if (ghost == GHOST.INKY){
					fsmInky.update(game);
					MOVE move3 = fsmInky.getCurrentState().getAction().getMove(game);
					myMoves.put(GHOST.INKY, move3);
					//System.out.println("Inky State is " + ((State)fsmInky.getCurrentState()).getName());
				}
				if (ghost == GHOST.SUE){
					fsmSue.update(game);
					MOVE move4 = fsmSue.getCurrentState().getAction().getMove(game);
					myMoves.put(GHOST.SUE, move4);	
					//System.out.println("Sue State is " + ((State)fsmSue.getCurrentState()).getName());
				}
			//}
						
		}
		return myMoves;
		/*
		int[] powerPillIndices=game.getActivePowerPillsIndices();
		for(int i=0;i<powerPillIndices.length;i++){
			//double distance = game.getDistance(pacmanIndex, powerPillIndices[i], DM.PATH);
			if(game.getDistance(pacman, powerPillIndices[i], DM.PATH)<29){
				System.out.println("PACMAN IS CLOSE");
			}
			else {System.out.println("PACMAN IS FAR");}
			System.out.println("DISTANCE: " + game.getDistance(pacman, powerPillIndices[i], DM.PATH));
		}
		*/


		//System.out.println("TIME: " + game.getCurrentLevelTime() + " : " + game.getCurrentLevel());

		//System.out.println("Actionlist size: " + actionListSUE);
	}

	boolean PacmanFarToPill(Game game) {
    	int pacmanIndex=game.getPacmanCurrentNodeIndex();
    	int[] powerPillIndices=game.getActivePowerPillsIndices();
    	
    	for(int i=0;i<powerPillIndices.length;i++){
			//double distance = game.getDistance(pacmanIndex, powerPillIndices[i], DM.PATH);
			//if(game.getDistance(pacmanIndex, powerPillIndices[i], DM.PATH)<minDistance){
    		if(game.getShortestPathDistance(pacmanIndex, powerPillIndices[i])>PILL_PROXIMITY){
				return true;
			}
		}
        return false;
	}
	
	boolean PacmanCloseToPill(Game game) {
    	int pacmanIndex=game.getPacmanCurrentNodeIndex();
    	int[] powerPillIndices=game.getActivePowerPillsIndices();
    	
    	for(int i=0;i<powerPillIndices.length;i++){
			//double distance = game.getDistance(pacmanIndex, powerPillIndices[i], DM.PATH);
			//if(game.getDistance(pacmanIndex, powerPillIndices[i], DM.PATH)<minDistance){
    		if(game.getShortestPathDistance(pacmanIndex, powerPillIndices[i])<=PILL_PROXIMITY){
    			//System.out.println("PACMAN IS CLOSE");
				return true;
			}
		}
        return false;
	}
	
	

}