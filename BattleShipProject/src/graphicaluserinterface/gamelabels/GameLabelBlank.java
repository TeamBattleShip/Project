package graphicaluserinterface.gamelabels;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class GameLabelBlank extends JLabel implements GameLabelStrategy {

	private static final long serialVersionUID = 5002183950510310806L;
	private boolean clicked = false;
	private Color currentColor = null;
	private String coordinate;

	public GameLabelBlank(String text) {
		paintLabel(text);
	}

	@Override
	public void paintLabel(String text) {
		coordinate = text;
		setBackground(currentColor);
		Color boarderColor = new Color(204, 0, 187, 0x50);
		Color boarderColor2 = new Color(0, 0, 0);
		setBorder(BorderFactory.createEtchedBorder(boarderColor, boarderColor2));
		setBounds(0, 0, 10, 10);
	}

	public boolean hasClicked() {
		return clicked;
	}

	public void click() {
		clicked = true;
	}

	public void changeColor(Color c) {
		currentColor = c;
		setBackground(currentColor);
	}

	public Color getColor() {
		return currentColor;
	}

	public String getCoordinate() {
		return coordinate;
	}

}
