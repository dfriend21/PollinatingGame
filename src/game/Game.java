package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Game {
	
	final double SHOOT_PROB = .33;
	final double SILKED_SHOOT_PROB = .33;
	final double SHOOTBAG_PROB = .34;
	
	JFrame frame;
	JPanel gameContainer;

	ArrayList<CornPanel> cornPanels;
	
	public Game(){
		frame = new JFrame();
		cornPanels = new ArrayList<CornPanel>();
		gameContainer = new JPanel();
		frame.setSize(1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(new Color(98, 249, 255));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frame.getContentPane().add(BorderLayout.CENTER, gameContainer);
        gameContainer.setVisible(true);
        frame.setVisible(true);
        
	    addCornPanel();
	    frame.setVisible(true);
	}
	
	public void addCornPanel(){

		PanelInfo panelInfo = new PanelInfo();
		Random randomDouble = new Random();
		double number;

		panelInfo.topImage = "leftShoot";
		
		for(int i = 0; i<=3; i++){
			number = randomDouble.nextDouble();
			if(number < SHOOT_PROB){
				if(i == 0){
					panelInfo.topImage = "leftShoot";
				} else if(i == 1){
					panelInfo.middleImage = "rightShoot";
				} else if( i == 2){
					panelInfo.bottomImage = "leftShoot";
				}
			} else if(number > SHOOT_PROB && number <SHOOT_PROB + SILKED_SHOOT_PROB){
				if(i == 0){
					panelInfo.topImage = "leftSilkedShoot";
				} else if(i == 1){
					panelInfo.middleImage = "rightSilkedShoot";
				} else if( i == 2){
					panelInfo.bottomImage = "leftSilkedShoot";
				}
			} else if(number > SHOOT_PROB + SILKED_SHOOT_PROB && number <SHOOT_PROB + SILKED_SHOOT_PROB + SHOOTBAG_PROB){
				if(i == 0){
					panelInfo.topImage = "leftShootbag";
				} else if(i == 1){
					panelInfo.middleImage = "rightShootbag";
				} else if( i == 2){
					panelInfo.bottomImage = "leftShootbag";
				}
			} else{
				if(i == 0){
					panelInfo.topImage = "none";
				} else if(i == 1){
					panelInfo.middleImage = "none";
				} else if( i == 2){
					panelInfo.bottomImage = "none";
				}
			}
		}
		
		CornPanel cornPanel = new CornPanel(panelInfo);
		cornPanels.add(cornPanel);
		
        gameContainer.add(cornPanel);
		//gameContainer.setLocation(1000,1000);
		//cornPanel.setLocation(1000,1000);
        gameContainer.setVisible(true);
        cornPanel.setVisible(true); 
		gameContainer.repaint();

		frame.getContentPane().repaint();
		frame.repaint();
	}
	
	public static void main(String[] args) {
		Game game = new Game();
	}
}
