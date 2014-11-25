package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import pacman.game.Constants.GHOST;
import edu.ucsc.gameAI.ICondition;

public class GhostInRegion implements ICondition {
	
	int nx1, ny1, nx2, ny2;
	public GhostInRegion (int x1, int y1, int x2, int y2){
		nx1 = x1;
		ny1 = y1;
		nx2 = x2;
		ny2 = y2;
	}

	//iterate through each ghost?
	@Override
	//int ig, gx, gy;
	
	public boolean test(Game game) {
		for (GHOST ghost : GHOST.values())
		{
			int ig = game.getGhostCurrentNodeIndex(ghost);
			int gx = game.getNodeXCood(ig);
			int gy = game.getNodeYCood(ig);	
			if ((gx >= nx1 && gx <= nx2) && (gy >= ny1 && gy <= ny2))
				return true;
			
		}
		return false;
	}

}
