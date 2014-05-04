import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import game.api.GameState;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import game.impl.Move;
import game.io.InputUnit;


public class BSPConsoleInputUnit extends InputUnit{
	
    private final BufferedReader inputSourceReader = new BufferedReader(new InputStreamReader(System.in));
    private int pieceCounter = 0;
    
    private boolean C = false, S = false, D = false, B = false, A = false;
  
    
    
    private Move shootLocation(GameState state){
    	
    	BoardLocation location = null;
    	Move result = null;
    	String input = "";
   
    	try {
    		boolean positionAccepted = false;
    		while (positionAccepted = false){
    			input = inputSourceReader.readLine();
    			positionAccepted = OkPosition(state ,input);
		} 
			location = resolveBoardLocation(state, input);
			result = new Move (state.getPlayerInTurn(), hitOrMiss(state, location), location);
    	}catch (IOException e) {
		}
    	
    	return result ;
    }
    
    
    
    
	private boolean OkPosition(GameState state, String locationId) {
        try {
            for (BoardLocation location : state.getBoard().getLocations()) {
                if (location.getId().equals(locationId)) {
                    return true;
                }
            }
        } catch (Exception ex) {
        }

		return false;
	}


	private Move placePiece(GameState state){
		Move result = null;
	    boolean locationAccepted = false;
	    boolean positionAccepted = false;
	    boolean typeAccepted = false;
	    boolean directionAccepted = false;
        try {
        	List<String> input = null;
        	GamePiece piece = null;
        	BoardLocation location = null;
        		while (locationAccepted == false){
        			while (positionAccepted == false || typeAccepted == false || directionAccepted == false){
        				positionAccepted = false;
        				typeAccepted = false;
        				directionAccepted = false; 
        				input = Arrays.asList(inputSourceReader.readLine().split(" "));
        				positionAccepted = OkPosition(state, input.get(0));
        				if (input.get(1).equals("C") || input.get(1).equals("S") || input.get(1).equals("D") || input.get(1).equals("B") || input.get(1).equals("A")){
        					typeAccepted = true;
        				}
        				if (input.get(2).equals("V") || input.get(2).equals("H")){
        					directionAccepted = true;
        				}
        			}
        			piece = getTypeOfPiece(state, input.get(1));
            		location = resolveBoardLocation(state, input.get(0));
            		locationAccepted = true;
            		//locationAccepted = validLocation(piece, location, vertical);
        		}
                result = new Move(state.getPlayerInTurn(), piece, location);
                //boardPlacement(state, piece, location, input.get(2));
                pieceCounter++;
        } catch (IOException ex) {
        }
        return result;
	}
	
	// Skall kunna implementeras efter uppdatering i API.

	/**
	
	private boolean validLocation(GamePiece piece, BoardLocation location, String vertical){
		
		List<BoardLocation> locationList = state.getLocationList();
		boolean vertical = false;
		
		if (vertical = "V"){
			vertical = true;
		}

		
		for (int i = 0; i < locationList.size; i++){
			
			if (location.equals(locationList.get(i))){
				if (vertical == false){

					if (piece.getId() == "C"){
						int pieceMod = i + 2 % 10;
						if (pieceMod != 1){
							return false;
						}
					}
					if (piece.getId() == "S" || piece.getId() == "D"){
						int pieceMod = i + 3 % 10;
						if (pieceMod < 3){
							return false;
						}
					}
					if (piece.getId() == "B"){
						int pieceMod = i + 4 % 10;
						if (pieceMod < 4){
							return false;
						}
					}
					if (piece.getId() == "A"){
						int pieceMod = i + 5 % 10;
						if (pieceMod < 5){
							return false;
						}
				}
				else {
					
					if (piece.getId() == "C"){
						if (i + 10 > 99){
							return false;
						}
					}
					if (piece.getId() == "S"){
						if (i + 20 > 99){
							return false;
						}
					}
					if (piece.getId() == "D"){
						if (i + 20 > 99){
							return false;
						}
					}
					if (piece.getId() == "B"){
						if (i + 30 > 99){
							return false;
						}
					}
					if (piece.getId() == "A"){
						if (i + 40 > 99){
							return false;
						}
					}
				}
			}
			
			}
		}
		
		
		return true;
	}
	
	*/
	
	private GamePiece hitOrMiss(GameState state, BoardLocation location){
		
		if (location.getPiece() == null){
			return state.getPlayerInTurn().getPieces().get(0);
		}
		else {
			return state.getPlayerInTurn().getPieces().get(1);
		}
	}
	
	/**
	
	private void boardPlacement(GameState state, GamePiece piece, BoardLocation location, boolean vertical){
		
		List<BoardLocation> locationList = state.getLocationList();
		
		if (vertical = false){
		
			for (int i = 0; i < locationList.size(); i++){
				if (location.equals(locationList.get(i))){
					if (piece.getId().equals("C") && C == false){
						locationList.get(i + 1).setPiece(piece);
						C = true;
					}
					else if (piece.getId().equals("S")&& S == false){
						locationList.get(i + 1).setPiece(piece);
						locationList.get(i + 2).setPiece(piece);
						S = true;
					}
					else if (piece.getId()equals("D") && D == false){
						locationList.get(i + 1).setPiece(piece);
						locationList.get(i + 2).setPiece(piece);
						D = true;
					}
					else if (piece.getId().equals("B") && B == false){
						locationList.get(i + 1).setPiece(piece);
						locationList.get(i + 2).setPiece(piece);
						locationList.get(i + 3).setPiece(piece);
						B = true;
					}
					else if (piece.getId().equals("A") && A == false){
						locationList.get(i + 1).setPiece(piece);
						locationList.get(i + 2).setPiece(piece);
						locationList.get(i + 3).setPiece(piece);
						locationList.get(i + 4).setPiece(piece);
						A = true;
					}
				}
			}
		}
		else {
		
					for (int i = 0; i < locationList.size(); i++){
				if (location.equals(locationList.get(i))){
					if (piece.getId().equals("C") && C == false){
						locationList.get(i + 10).setPiece(piece);
						C = true;
					}
					else if (piece.getId().equals("S")&& S == false){
						locationList.get(i + 10).setPiece(piece);
						locationList.get(i + 20).setPiece(piece);
						S = true;
					}
					else if (piece.getId()equals("D") && D == false){
						locationList.get(i + 10).setPiece(piece);
						locationList.get(i + 20).setPiece(piece);
						D = true;
					}
					else if (piece.getId().equals("B") && B == false){
						locationList.get(i + 10).setPiece(piece);
						locationList.get(i + 20).setPiece(piece);
						locationList.get(i + 30).setPiece(piece);
						B = true;
					}
					else if (piece.getId().equals("A") && A == false){
						locationList.get(i + 10).setPiece(piece);
						locationList.get(i + 20).setPiece(piece);
						locationList.get(i + 30).setPiece(piece);
						locationList.get(i + 40).setPiece(piece);
						A = true;
					}
				}
			}
		
		}
	}
	
	*/
	
	private BoardLocation resolveBoardLocation(GameState state, String locationId){
        try {
            for (BoardLocation location : state.getBoard().getLocations()) {
                if (location.getId().equals(locationId)) {
                    return location;
                }
            }
        } catch (Exception ex) {
        }
        return null;
	}
	
    private GamePiece getTypeOfPiece(GameState state, String id) {
    	
    	GamePiece result;
        
    	for (GamePiece piece : state.getPlayerInTurn().getPieces()){
    		
    		for (BoardLocation location : state.getBoard().getLocations()) {
    			if (piece.getId().equals(id)){
    				if (location.getPiece() == piece){
    					return null;
    				}
    				else {
    				return piece;
    				}
    			}
    		}
    	}
		return null;
    }
  
	
    @Override
    public void setup(GameState state) {
        while (!state.hasEnded()) {
        	if (pieceCounter > 4){
        		notifyListenersOfMove(shootLocation(state));
        	}
        	else {
        		notifyListenersOfMove(placePiece(state));
        	}
        }
        System.exit(0);
    }
}
