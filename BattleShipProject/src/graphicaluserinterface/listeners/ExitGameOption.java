package graphicaluserinterface.listeners;

import graphicaluserinterface.MainGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ExitGameOption implements ActionListener {
	private JFrame frame;

	public ExitGameOption(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int answ = JOptionPane.showConfirmDialog(frame, "Do you want to quit?");
		if (answ == JOptionPane.YES_OPTION) {
			frame.dispose();
			new MainGui();
		}

	}

}
