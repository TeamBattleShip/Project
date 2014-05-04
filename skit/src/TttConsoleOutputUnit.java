
import game.api.GameState;
import game.impl.BoardLocation;
import game.io.OutputUnit;

/**
 *
 * @author thomas
 */
public class TttConsoleOutputUnit implements OutputUnit {

    @Override
    public void publish(GameState gameState) {
        System.out.println("  1  2  3 ");
        for (Integer i = 0; i < 3; i++) {
            System.out.println((i + 1) + getRow(i, gameState));
        }
        if (gameState.hasEnded()) {
            System.out.println(gameState.getWinner().getName() + " har vunnit!");
        } else {
            System.out.println(gameState.getMessage());
            System.out.print("Spelare " + gameState.getPlayerInTurn().getName() + "> ");
        }
    }

    private String getRow(Integer index, GameState state) {
        return getLocationAsString(state.getBoard().getLocations().get(index * 3))
                + getLocationAsString(state.getBoard().getLocations().get(index * 3 + 1))
                + getLocationAsString(state.getBoard().getLocations().get(index * 3 + 2));
    }

    String getLocationAsString(BoardLocation location) {
        return " " + (location.getPiece() != null ? location.getPiece().getId() : " ") + " ";
    }
}
