package edu.ucsc.gameAI;

//import pacman.game.Constants;
import java.util.ArrayList;

import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class EatPills implements IAction, IBinaryNode {

	//MOVE move;
	//Game game;
	private static final int MIN_DISTANCE=30;
	private static final int MIN_PILL_DISTANCE=10;
	int shortestPill = 0;
	@Override
	public void doAction() {
		//move = Constants.MOVE.DOWN;
		
	}
	
	//@Override
	public MOVE getMove(Game game) {
		int current=game.getPacmanCurrentNodeIndex();
		
		/*
		//from PacManStarter
		for(GHOST ghost : GHOST.values()){
			if(game.getGhostEdibleTime(ghost)==0 && game.getGhostLairTime(ghost)==0)
				if(game.getShortestPathDistance(current,game.getGhostCurrentNodeIndex(ghost))<MIN_DISTANCE)
					return game.getNextMoveAwayFromTarget(game.getPacmanCurrentNodeIndex(),game.getGhostCurrentNodeIndex(ghost),DM.PATH);
		}
		*/
		
		//target closest power pill
		int[] pills=game.getPillIndices();
		int[] powerPills=game.getPowerPillIndices();		
		
		ArrayList<Integer> targets=new ArrayList<Integer>();
		
		
		for(int i=0;i<pills.length-1;i++){					//check which pills are available			
			if(game.isPillStillAvailable(i)){
				if (i <= pills.length){
					shortestPill = game.getShortestPathDistance(current,game.getPillIndex(i+1));
					if(game.getShortestPathDistance(current,game.getPillIndex(i))<=shortestPill){
						targets.add(pills[i]);
						//return game.getNextMoveTowardsTarget(current,game.getPillIndex(i),DM.PATH);
					}
					else targets.add(pills[i]);
				
				}
				else if (i == pills.length+1){
					i = 0;					
				}
			}
			//System.out.println("I = " + i + " " + game.getShortestPathDistance(current,game.getPillIndex(i+1)) + " ," + shortestPill );
		}
			
			
		
		for(int i=0;i<powerPills.length;i++){		//check with power pills are available
			if(game.isPowerPillStillAvailable(i)){
				//for(GHOST ghost : GHOST.values()){
					//if (game.getGhostLairTime(ghost)==0){
						if(game.getShortestPathDistance(current,game.getPowerPillIndex(i))<MIN_PILL_DISTANCE){
							targets.add(powerPills[i]);
							//return game.getNextMoveTowardsTarget(current,game.getPowerPillIndex(i),DM.PATH);
							}
						//}	
					//}
				}
			}
			
			
		
		int[] targetsArray=new int[targets.size()];		//convert from ArrayList to array
		
		for(int i=0;i<targetsArray.length;i++)
			targetsArray[i]=targets.get(i);
		
		//return the next direction once the closest target has been identified
		System.out.println("targetsArray: " + targetsArray.length);
		return game.getNextMoveTowardsTarget(current,game.getClosestNodeIndexFromNodeIndex(current,targetsArray,DM.PATH),DM.PATH);
		//return MOVE.NEUTRAL;
	
	}
	
		@Override
	public IAction makeDecision(Game game) {
		return this;
	}

		@Override
		public MOVE getMove() {
			// TODO Auto-generated method stub
			return null;
		}
}
