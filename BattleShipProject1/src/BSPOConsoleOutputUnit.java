import game.api.GameState;
import game.impl.BoardLocation;
import game.io.OutputUnit;


public class BSPOConsoleOutputUnit implements OutputUnit{
	
    private String [] letterArray = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    private int pieceCounter = 0;
    private String[] infoArray = {"Type of Ships: ", "","Cruiser (2) = C", "Submarine (3) = S", "Destroyer (3) = D", "Battleship (4) = B", "Aircraft Carrier (5) = A", "", "Horizontal = H", "Vertical = V"};

	@Override
    public void publish(GameState gameState) {
		
        userBoard(gameState);
        markBoard(gameState);
        if (gameState.hasEnded()) {
            System.out.println(gameState.getWinner().getName() + " har vunnit!");
        } else {
            System.out.println(gameState.getMessage());
            if (pieceCounter > 4){
            	System.out.print("Shoot (Position): " + gameState.getPlayerInTurn().getName() + "> ");
            }
            else {
            	System.out.print("Put ship on board(Position, Shiptype, Horizontal/Vertical): " + gameState.getPlayerInTurn().getName() + "> ");
            }
        }
        pieceCounter++;
    }

	private void userBoard(GameState gameState) {
		System.out.println("  1  2  3  4  5  6  7  8  9  10");
        for (Integer i = 0; i < letterArray.length; i++) {
            System.out.print(letterArray[i] + getRow(i, gameState, true));
            System.out.println("                                " + infoArray[i]);
        }
	}
	
	private void markBoard(GameState gameState) {
		System.out.println("\n  1  2  3  4  5  6  7  8  9  10");
        for (Integer i = 0; i < letterArray.length; i++) {
            System.out.println(letterArray[i] + getRow(i, gameState, false));
        }
	}
	
    private String getRow(Integer index, GameState state, boolean userBoard) {
        return getLocationAsString(state.getBoard().getLocations().get(index * 10), userBoard)
                + getLocationAsString(state.getBoard().getLocations().get(index * 10 + 1), userBoard)
                + getLocationAsString(state.getBoard().getLocations().get(index * 10 + 2), userBoard)
        		+ getLocationAsString(state.getBoard().getLocations().get(index * 10 + 3), userBoard)
        		+ getLocationAsString(state.getBoard().getLocations().get(index * 10 + 4), userBoard)
        		+ getLocationAsString(state.getBoard().getLocations().get(index * 10 + 5), userBoard)
        		+ getLocationAsString(state.getBoard().getLocations().get(index * 10 + 6), userBoard)
        		+ getLocationAsString(state.getBoard().getLocations().get(index * 10 + 7), userBoard)
        		+ getLocationAsString(state.getBoard().getLocations().get(index * 10 + 9), userBoard);
    }

    String getLocationAsString(BoardLocation location,  boolean userBoard) {
    	
    	if (userBoard == true){
    		String result = "  ";
    		if (location.getPiece() != null){
    			if (location.getPiece().getId() == "X" || location.getPiece().getId() == "O"){
    				result = "  ";
    			}
    			else {
    				result = location.getPiece().getId();
    			}
    		}
    		return " " + result;
    	}
    	else {
    		String result = "  ";
    		if (location.getPiece() != null){
    			if (location.getPiece().getId() != "X" && location.getPiece().getId() != "O"){
    				result = "  ";
    			}
    			else {
    				result = location.getPiece().getId();
    			}
    		}
    		return " " + result;
    	}
    }
}


