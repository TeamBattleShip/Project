package graphicaluserinterface.gamelabels;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GameLabelLetter extends JLabel implements GameLabelStrategy {

	private static final long serialVersionUID = 2989886154017134765L;

	public GameLabelLetter(String text) {
		paintLabel(text);
	}

	@Override
	public void paintLabel(String text) {
		if (text.charAt(0) != '-')
			setText("" + text.charAt(0));
		setBackground(color);
		setOpaque(true);
		setHorizontalAlignment(SwingConstants.CENTER);
		setBounds(0, 0, 10, 10);
		setBounds(0, 0, 10, 10);
	}

}
