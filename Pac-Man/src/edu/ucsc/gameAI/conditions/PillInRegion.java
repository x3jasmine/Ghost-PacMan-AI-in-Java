package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class PillInRegion implements ICondition {
	
	int nx1, ny1, nx2, ny2;
	public PillInRegion(int x1, int y1, int x2, int y2){
		nx1 = x1;
		ny1 = y1;
		nx2 = x2;
		ny2 = y2;
	}

	//check each pill?
	@Override
	public boolean test(Game game) {
		for (int pill : game.getActivePillsIndices())
		{
			int px = game.getNodeXCood(pill);
			int py = game.getNodeYCood(pill);
			if ((px >= nx1 && px <= nx2) && (py >= ny1 && py <= ny2))
				return true;
		}
		return false;
	}

}
