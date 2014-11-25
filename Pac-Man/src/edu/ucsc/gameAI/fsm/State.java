package edu.ucsc.gameAI.fsm;

import java.util.Collection;
import java.util.LinkedList;

import edu.ucsc.gameAI.IAction;

public class State implements IState {
	
	private Collection<ITransition> stateTrans;
	private IAction entryAction;
	private IAction exitAction;
	private IAction currentAction;
	private String name;
	
	public State(){
		this.stateTrans = new LinkedList<ITransition>();
	}

	public void setName(String n){
		name = n;
	}
	public String getName(){
		return name;
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
	public IAction getEntryAction() {
		return entryAction;
	}

	@Override
	public void setEntryAction(IAction action) {
		entryAction = action;
		
	}

	@Override
	public IAction getExitAction() {
		return exitAction;
	}

	@Override
	public void setExitAction(IAction action) {
		exitAction = action;
		
	}

	@Override
	public Collection<ITransition> getTransitions() {
		return stateTrans;
	}

	@Override
	public void setTransitions(Collection<ITransition> trans) {
		//idk what goes here
		stateTrans = trans;
	}

}
