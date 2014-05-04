package graphicaluserinterface.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class StartGameListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		button.setIcon(new ImageIcon("Pictures//buttonGreen.gif"));
		
	}

}
