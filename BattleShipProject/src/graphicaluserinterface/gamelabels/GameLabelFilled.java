package graphicaluserinterface.gamelabels;

import javax.swing.JLabel;

public class GameLabelFilled extends JLabel implements GameLabelStrategy {

	private static final long serialVersionUID = -29477876791308896L;

	public GameLabelFilled(String text) {
		paintLabel(text);
	}

	@Override
	public void paintLabel(String text) {
		setBounds(0, 0, 10, 10);
		setBounds(0, 0, 10, 10);
		setBackground(color);
		setOpaque(true);
	}

}
