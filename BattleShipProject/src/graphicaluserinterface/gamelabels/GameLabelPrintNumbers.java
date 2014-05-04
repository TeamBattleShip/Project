package graphicaluserinterface.gamelabels;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GameLabelPrintNumbers extends JLabel implements GameLabelStrategy {

	private static final long serialVersionUID = -6144426468526434839L;

	public GameLabelPrintNumbers(String text) {
		paintLabel(text);
	}

	@Override
	public void paintLabel(String text) {
		setBounds(0, 0, 10, 10);
		setBounds(0, 0, 10, 10);
		if (!(text.equals(" 0") || text.equals(" 11"))) {
			setText(text.substring(1));
		}
		setBackground(color);
		setOpaque(true);
		setHorizontalAlignment(SwingConstants.CENTER);

	}

}
