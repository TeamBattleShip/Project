package game.io;

import game.api.GameState;
import graphicaluserinterface.GameGUI;

public class OutputUnitBattleship implements OutputUnit{

	@Override
	public void publish(GameState state) {
	new GameGUI(state);		
	}

}
