package edu.ucsc.gameAI.fsm;

import java.util.Collection;

import pacman.game.Game;
import edu.ucsc.gameAI.IAction;
import java.util.LinkedList;
//import edu.ucsc.gameAI.fsm.Transition;

public class StateMachine implements IStateMachine {
	
	//pg 311
	//holds initial state
	IState initialState;
	//hold current state
	IState currentState;
	//ITransition trigAction;
	
	public StateMachine(){
		
	}

	@Override
	public Collection<IAction> update(Game game) {
		//ITransition trigAction = null;
		final LinkedList<IAction> actions = new LinkedList<IAction>();
		boolean isTriggeredTransition = false;
		ITransition triggeredTransition = null;
		if (currentState.getTransitions() != null){
			for (ITransition transition : currentState.getTransitions()){
				if (transition.isTriggered(game)){
					isTriggeredTransition = true;
					if (currentState.getAction() != null){
						triggeredTransition = transition;
						}
					break;
					}
				}
		}
		// Check if we have a transition to fire.
		if (isTriggeredTransition){
			 // Find the target state.
			 IState targetState = triggeredTransition.getTargetState();
			//Add the exit action of the old state...
			if (currentState.getExitAction() != null)
				actions.add(currentState.getExitAction());
			// the transition action...
			if (triggeredTransition.getAction() != null)
				actions.add(triggeredTransition.getAction());
			// and the new state.
			if (targetState.getEntryAction() != null)
				actions.add(targetState.getEntryAction());
			 //Complete the transition and return the action list.
			currentState = targetState;
			return actions;
		}
		else {
			//Otherwise just return the current state's actions	
			final LinkedList<IAction> action = new LinkedList<IAction>();
			if (currentState.getAction() != null)
				action.add(currentState.getAction());
			//return currentState.getAction();
			return action;
		}
	}

	@Override
	public IState getCurrentState() {
		return currentState;
	}

	@Override
	public void setCurrentState(IState state) {
		currentState = state;
		
	}

}
