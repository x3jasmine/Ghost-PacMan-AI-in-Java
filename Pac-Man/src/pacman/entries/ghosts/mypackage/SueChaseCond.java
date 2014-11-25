package pacman.entries.ghosts.mypackage;

import pacman.game.Constants.GHOST;
import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class SueChaseCond implements ICondition {

	GHOST ghost;
	public SueChaseCond(GHOST ghost){
		this.ghost = ghost;
	}

	@Override
	public boolean test(Game game) {	
		int sueNode = game.getGhostCurrentNodeIndex(ghost);
		int pacman = game.getPacmanCurrentNodeIndex();
		double distance = game.getEuclideanDistance(sueNode, pacman);
		
		if (distance > 10)
			return true;		
		return false;
	}
}
