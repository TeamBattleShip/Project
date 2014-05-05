package game.api;

import game.impl.Board;
import game.impl.BoardLocation;
import game.impl.DieRollFactory;
import game.impl.GamePiece;
import game.impl.Move;
import game.impl.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameStateBattleship implements GameState, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5553374248527611351L;
	private List<Player> players;
	private Integer turnCounter = 0;
	private Board board;
	private String message = "";
	private RuleChecker ruleChecker;

	public GameStateBattleship() {

		ArrayList<BoardLocation> locations = new ArrayList<BoardLocation>();
		final String[] coordinates = { "A", "B", "C", "D", "E", "F", "G", "H",
				"I", "J" };
		for (String s : coordinates)
			for (int i = 1; i < 12; i++) {
				locations.add(new BoardLocation(s + i));
			}

		board = new Board(locations);

		players = new ArrayList<Player>();
		ArrayList<GamePiece> pieces = new ArrayList<GamePiece>();
		pieces.add(new GamePiece("" + 2));
		pieces.add(new GamePiece("" + 3));
		pieces.add(new GamePiece("" + 3));
		pieces.add(new GamePiece("" + 4));
		pieces.add(new GamePiece("" + 5));

		players.add(new Player("Player1", pieces));
		players.add(new Player("Player2", pieces));
		ruleChecker = new RuleChecker();
	}

	@Override
	public Board getBoard() {
		return board;
	}

	@Override
	public Player getLastPlayer() {
		return players.get((turnCounter - 1) % 2);
	}

	@Override
	public String getMessage() {

		return message;
	}

	@Override
	public Player getPlayerInTurn() {
		return players.get(turnCounter % 2);
	}

	@Override
	public List<Player> getPlayers() {
		return players;
	}

	@Override
	public Player getWinner() {
		if (hasEnded()) {
			return getLastPlayer();
		}
		return null;
	}

	@Override
	public Boolean hasEnded() {

		return ruleChecker.isGameFinishied(this);
	}

	@Override
	public Boolean proposeMove(Move move) {
		if (ruleChecker.isValidMove(move)) {
			move.execute();
			turnCounter++;
			message = "";
			return true;
		}
		message = "Wrong move dude..!";
		return false;
	}

	@Override
	public void reset() {

	}

	@Override
	public DieRollFactory getDieRollFactory() {
<<<<<<< HEAD
		// TODO Auto-generated method stub
=======
	
>>>>>>> master
		return null;
	}
}
