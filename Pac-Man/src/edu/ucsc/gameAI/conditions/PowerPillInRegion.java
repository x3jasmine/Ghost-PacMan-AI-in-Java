package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class PowerPillInRegion implements ICondition {
	
	int nx1, ny1, nx2, ny2;
	public PowerPillInRegion(int x1, int y1, int x2, int y2){
		nx1 = x1;
		ny1 = y1;
		nx2 = x2;
		ny2 = y2;
	}

	@Override
	public boolean test(Game game) {
		for (int ppill : game.getActivePowerPillsIndices())
		{
			int px = game.getNodeXCood(ppill);
			int py = game.getNodeYCood(ppill);
			if ((px >= nx1 && px <= nx2) && (py >= ny1 && py <= ny2))
				return true;
		}
		return false;
	}

}
