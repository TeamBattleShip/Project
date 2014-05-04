package game.io;

import game.api.GameState;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import game.impl.Move;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputUnitBattleship extends InputUnit {
	

	private final BufferedReader inputSourceReader = new BufferedReader(
			new InputStreamReader(System.in));

	
	private Move getNextMove(GameState state) {
		Move result = null;
		
		return result;
	}

	private BoardLocation resolveBoardLocation(GameState state, String code) {
		try {
			for (BoardLocation location : state.getBoard().getLocations()) {
				if (location.getId().equals(code)) {
					return location;
				}
			}
		} catch (Exception ex) {
		}
		return null;
	}

	private GamePiece getFirstUnusedPiece(GameState state) {
		for (GamePiece piece : state.getPlayerInTurn().getPieces()) {
			boolean found = true;
			for (BoardLocation location : state.getBoard().getLocations()) {
				if (location.getPiece() != null
						&& location.getPiece().equals(piece)) {
					found = false;
					break;
				}
			}
			if (found) {
				return piece;
			}
		}
		return null;
	}

	@Override
	public void setup(GameState state) {
		while (!state.hasEnded()) {
			notifyListenersOfMove(getNextMove(state));
		}
		System.exit(0);
	}

}
