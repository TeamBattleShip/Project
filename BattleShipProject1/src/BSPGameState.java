import game.api.GameState;
import game.impl.Board;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import game.impl.Move;
import game.impl.Player;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class BSPGameState implements GameState {
	
	private final List<Player> players;
    private final Board board;
    private final BSPRuleChecker ruleChecker;
    private String message = "";
    private Integer turnCounter = 0;
    private boolean gameStarted = false;
    private String [] letterArray = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    private ArrayList<BoardLocation> locationList = new ArrayList<BoardLocation>();
    
    public BSPGameState(){
    	
    	
    	
        ArrayList<GamePiece> pieceList = new ArrayList<GamePiece>();
        
        pieceList.add(new GamePiece("X"));
        pieceList.add(new GamePiece("O"));
        pieceList.add(new GamePiece("C"));
        pieceList.add(new GamePiece("S"));
        pieceList.add(new GamePiece("D"));
        pieceList.add(new GamePiece("B"));
        pieceList.add(new GamePiece("A"));

    	
    	players = Arrays.asList(new Player("A", pieceList)); 
    	
    	
        for (int i = 0; i < letterArray.length; i++){
        	
        	for (int j = 1; j < 11; j++){
        		locationList.add(new BoardLocation(letterArray[i] + j));
        	}
        	
        }
       
        board = new Board(locationList);
     
        
		this.ruleChecker = new BSPRuleChecker();
    }
    
    public BSPGameState(List<Player> players, Board board){
    	this.players = players;
    	this.board = board;
    	this.ruleChecker = new BSPRuleChecker();
    }

	@Override
	public Board getBoard() {
        return board;
	}

	@Override
	public Player getLastPlayer() {
		return players.get(1 - turnCounter % 2);
	}

	@Override
	public String getMessage() {
		return message;
	}
	
	public List<BoardLocation> getLocationList(){
		return locationList;
	}
	
private void boardPlacement(GamePiece piece, BoardLocation location){
		
	// Tillfällig metod som ska lägga i inputUnit. Skall tas bort.
		
		for (int i = 0; i < locationList.size(); i++){
			if (location.equals(locationList.get(i))){
				if (piece.getId().equals("C")){
					locationList.get(i + 1).setPiece(piece);
				}
				else if (piece.getId().equals("S") || piece.getId().equals("D")){
					locationList.get(i + 1).setPiece(piece);
					locationList.get(i + 2).setPiece(piece);
				}
				else if (piece.getId().equals("B")){
					locationList.get(i + 1).setPiece(piece);
					locationList.get(i + 2).setPiece(piece);
					locationList.get(i + 3).setPiece(piece);
				}
				else if (piece.getId().equals("A")){
					locationList.get(i + 1).setPiece(piece);
					locationList.get(i + 2).setPiece(piece);
					locationList.get(i + 3).setPiece(piece);
					locationList.get(i + 4).setPiece(piece);
				}
			}
		}
	}

	@Override
	public Player getPlayerInTurn() {
		// TODO Auto-generated method stub
		return players.get(0); //players.get(turnCounter % 2);
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
	
    public void startGame (){
    	gameStarted = true;
    }
    
    public Boolean gameStarted(){
    	return gameStarted;
    }

	@Override
	public Boolean hasEnded() {
		return ruleChecker.isGameFinished(this);
	}

	@Override
	public Boolean proposeMove(Move move) {
        if (ruleChecker.isValidMove(move)) {
            move.execute();
            boardPlacement(move.getPiece(), move.getDestination());
            turnCounter++;
            message = "";
            return Boolean.TRUE;
        }
        message = "Ogiltigt drag";
        return Boolean.FALSE;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}//, Serializable {


}
