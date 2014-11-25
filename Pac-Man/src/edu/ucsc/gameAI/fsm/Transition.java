package edu.ucsc.gameAI.fsm;

import pacman.game.Game;
import edu.ucsc.gameAI.IAction;
import edu.ucsc.gameAI.ICondition;

public class Transition implements ITransition {	
	
	IAction currentAction;
	IState targetState;
	IState currentState;
	ICondition currentCond;

	@Override
	public IState getTargetState() {
		// TODO Auto-generated method stub
		return targetState;
	}

	@Override
	public void setTargetState(IState targetState) {
		this.targetState = targetState;
		
	}

	@Override
	public IAction getAction() {
		return currentAction;
	}

	@Override
	public void setAction(IAction action) {
		currentAction = action;
		
	}

	@Override
	public void setCondition(ICondition condition) {
		currentCond = condition;
		
	}

	@Override
	public boolean isTriggered(Game game) {
		return currentCond.test(game);
	}

}
