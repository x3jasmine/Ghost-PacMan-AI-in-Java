package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class PacmanInRegion implements ICondition {
	
	int nx1, ny1, nx2, ny2;
	public PacmanInRegion (int x1, int y1, int x2, int y2){
		nx1 = x1;
		ny1 = y1;
		nx2 = x2;
		ny2 = y2;
	}

	@Override
	public boolean test(Game game) {
		int ipac = game.getPacmanCurrentNodeIndex();
		int pacx = game.getNodeXCood(ipac);
		int pacy = game.getNodeYCood(ipac);
		if ((pacx >= nx1 && pacx <= nx2) && (pacy >= ny1 && pacy <= ny2))
			return true;
		return false;
	}

}
