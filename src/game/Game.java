package game;

import java.awt.Color;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Game implements Runnable{
	
	final double SHOOT_PROB = .33;
	final double SILKED_SHOOT_PROB = .33;
	final double SHOOTBAG_PROB = .34;
	
	JFrame frame;
	JPanel gameContainer;

	ArrayList<CornPanel> cornPanels;
	
	public Game(){
		frame = new JFrame();
		cornPanels = new ArrayList<CornPanel>();
		//gameContainer = new JPanel();
		//gameContainer.setSize(1000, 1000);
		//gameContainer.setLayout(null);
		//gameContainer.setLayout(new BorderLayout());
		//gameContainer.setBackground(new Color(214, 76, 123));
		//frame.setSize(1000, 1000);
		Toolkit tk = Toolkit.getDefaultToolkit();
		int xSize = ((int) tk.getScreenSize().getWidth());
		int ySize = ((int) tk.getScreenSize().getHeight());
		frame.setSize(xSize,ySize);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		//frame.setLayout(new BorderLayout());
		frame.setBackground(new Color(98, 249, 255));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //frame.getContentPane().add(gameContainer);
        //gameContainer.setVisible(true);
        
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
		cornPanel.setSize(1000,1000);
		cornPanels.add(cornPanel);
		//cornPanel.setBackground(new Color(231, 176, 156));
        //gameContainer.add(cornPanel);
        //gameContainer.setBackground(new Color(215,2,65));
		frame.add(cornPanel);
		cornPanel.setLocation(frame.getWidth(),frame.getHeight()/4);
        cornPanel.setVisible(true);
		frame.getContentPane().repaint();
		frame.repaint();
	}
	
	public void animateGame(){
		for(int i = 0; i<cornPanels.size(); i++){
			if(cornPanels.get(i).getX()<0-cornPanels.get(i).imageWidth){
				cornPanels.remove(i);
			} else{
				cornPanels.get(i).setLocation(cornPanels.get(i).getX()-1, cornPanels.get(i).getY());
			}
			frame.getContentPane().repaint();
		}
	}
	
	public void runGame(){
		
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		Thread t = new Thread(game);
		t.start();
	}

	@Override
	public void run() {
		int counter = 0;
		while(true){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(counter == 0){
				addCornPanel();
			} 
			counter++;
			if(counter == 500){
				counter = 0;
			}

			frame.setBackground(new Color(98, 249, 255));
			animateGame();
		}
	}
}
