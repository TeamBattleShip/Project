package graphicaluserinterface.listeners;

import game.api.GameState;
import game.impl.BoardLocation;
import game.impl.GamePiece;
import game.impl.Move;
import graphicaluserinterface.gamelabels.GameLabelBlank;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Stack;

public class PlayerLabelClicked implements MouseListener {

	private GameLabelBlank label;
	private static Stack<Integer> boatsTobeplaced;


	public PlayerLabelClicked(GameLabelBlank label) {
		if (boatsTobeplaced == null) {
			boatsTobeplaced = new Stack<Integer>();
			boatsTobeplaced.add(2);
			boatsTobeplaced.add(3);
			boatsTobeplaced.add(3);
			boatsTobeplaced.add(4);
			boatsTobeplaced.add(5);
		}
		
		this.label = label;
	}

	@Override
	public void mouseClicked(MouseEvent obj) {

	}

	@Override
	public void mouseEntered(MouseEvent obj) {

		Color color = new Color(255, 255, 255, 0x50);

		if (!label.hasClicked()) {
			label.setOpaque(true);
			label.changeColor(color);
			label.getParent().repaint();
		}
	}

	@Override
	public void mouseExited(MouseEvent obj) {
		if (!label.hasClicked()) {
			label.setOpaque(false);
		}
	}

	@Override
	public void mousePressed(MouseEvent obj) {
		Color colorNew = new Color(0, 255, 0, 0x50);
		label.click();
		label.setOpaque(true);
		label.changeColor(colorNew);
		label.getParent().repaint();

		
		int i = PlayerLabelClicked.boatsTobeplaced.pop();
		String coordinate;

		for (int x = 0; x < i; x++) {
			int temp = Integer.parseInt("" + label.getCoordinate().charAt(1))
					+ x;
			coordinate = "" + label.getCoordinate().charAt(0) + temp;
//			for (BoardLocation bl : state.getBoard().getLocations()) {
//				if (bl.getId().equalsIgnoreCase(coordinate))
//					state.proposeMove(new Move(state.getPlayers().get(0),
//							new GamePiece("i"), bl));
			}

		}
		
	

	@Override
	public void mouseReleased(MouseEvent obj) {

	}

}
