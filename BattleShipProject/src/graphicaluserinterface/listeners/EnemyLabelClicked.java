package graphicaluserinterface.listeners;

import game.io.IoFactoryBattleship;
import graphicaluserinterface.gamelabels.GameLabelBlank;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EnemyLabelClicked implements MouseListener {
	private GameLabelBlank label;
	public EnemyLabelClicked(GameLabelBlank label) {
		this.label = label;
	}

	public EnemyLabelClicked(GameLabelBlank enemy, IoFactoryBattleship factory) {
		// TODO Auto-generated constructor stub
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
		Color colorNew = new Color(255, 0, 0, 0x50);
		label.click();
		label.setOpaque(true);
		label.changeColor(colorNew);
		label.getParent().repaint();

	}

	@Override
	public void mouseReleased(MouseEvent obj) {

	}

}
