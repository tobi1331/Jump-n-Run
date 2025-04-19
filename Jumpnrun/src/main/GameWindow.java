package main;

import javax.swing.JFrame;

public class GameWindow {

	public GameWindow(GamePanel gamePanel) {
		JFrame jframe;
		jframe= new JFrame();
		
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.add(gamePanel);
		jframe.pack();
		jframe.setLocationRelativeTo(null);
		jframe.setResizable(false);
		jframe.setVisible(true);
	}
	
	
	
	
	
}
