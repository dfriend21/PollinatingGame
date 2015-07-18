package game;

import java.util.Random;

public class CornPanelBuilder implements Runnable {

	@Override
	public void run(){
		while(true){
			createCornPanel();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void createCornPanel(){
		PanelInfo panelInfo = new PanelInfo();
		Random randomDouble = new Random();
		double number;

		panelInfo.topImage = "leftShoot";
		
		for(int i = 0; i<=3; i++){
			number = randomDouble.nextDouble();
			if(number < Game.SHOOT_PROB){
				if(i == 0){
					panelInfo.topImage = "leftShoot";
				} else if(i == 1){
					panelInfo.middleImage = "rightShoot";
				} else if( i == 2){
					panelInfo.bottomImage = "leftShoot";
				}
			} else if(number > Game.SHOOT_PROB && number <Game.SHOOT_PROB + Game.SILKED_SHOOT_PROB){
				if(i == 0){
					panelInfo.topImage = "leftSilkedShoot";
				} else if(i == 1){
					panelInfo.middleImage = "rightSilkedShoot";
				} else if( i == 2){
					panelInfo.bottomImage = "leftSilkedShoot";
				}
			} else if(number > Game.SHOOT_PROB + Game.SILKED_SHOOT_PROB && number <Game.SHOOT_PROB + Game.SILKED_SHOOT_PROB + Game.SHOOTBAG_PROB){
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
        Game.frame.add(cornPanel);
        if(!Game.cornPanels.isEmpty()){
        	cornPanel.setLocation(Game.cornPanels.get(Game.cornPanels.size()-1).getX() + Game.PLANT_GAP_WIDTH, Game.frame.getHeight()/4);
        	//cornPanel.setLocation(Game.frame.getWidth(), Game.frame.getHeight()/4);
        }
        cornPanel.setVisible(true);
        Game.cornPanels.add(cornPanel);
	}

}
