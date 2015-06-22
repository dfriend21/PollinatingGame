package game;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class Driver {

	JFrame frame;
	CornPanel cornPanel;
	public static void main(String[] args) {
		/*JFrame frame;
		CornPanel cornPanel;
		PanelInfo panelInfo = new PanelInfo();
		
		panelInfo.bottomImage = "leftShoot";
		panelInfo.middleImage = "rightShootbag";
		panelInfo.topImage = "leftSilkedShoot";
		frame = new JFrame();
		frame.setSize(1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(new Color(98, 249, 255));
		
		cornPanel = new CornPanel(panelInfo);

		frame.getContentPane().add(BorderLayout.CENTER, cornPanel);
	    frame.setVisible(true);*/
		Game game = new Game();
	}
}
