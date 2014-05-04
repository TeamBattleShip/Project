package game.io;

import game.api.GameState;
import game.api.GameStateBattleship;
import game.impl.Move;

public class InputUnitBattleship extends InputUnit {
	private GameStateBattleship state;

	public InputUnitBattleship() {

	}

	private Move getNextMove(GameState state) {
		Move result = null;

		return result;

	}

	@Override
	public void setup(GameState state) {
		if (state == null)
			this.state = (GameStateBattleship) state;
		while (!state.hasEnded()) {
			notifyListenersOfMove(getNextMove(state));
		}
		System.exit(0);
	}

}
