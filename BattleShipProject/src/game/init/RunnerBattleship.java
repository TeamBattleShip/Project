package game.init;

import graphicaluserinterface.MainGui;

import java.awt.EventQueue;

public class RunnerBattleship {
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new MainGui();					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
