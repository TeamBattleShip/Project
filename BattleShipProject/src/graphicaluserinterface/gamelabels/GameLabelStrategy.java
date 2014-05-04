package graphicaluserinterface.gamelabels;

import java.awt.Color;

public interface GameLabelStrategy {
	final Color color = new Color(0, 214, 253, 0x50);

	public void paintLabel(String text);
}
