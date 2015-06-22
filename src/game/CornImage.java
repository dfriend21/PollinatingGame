package game;

import java.awt.image.BufferedImage;

public class CornImage{
	
	BufferedImage image;
	
	public CornImage(BufferedImage bi){
		image = bi;
	}
	
	public BufferedImage getImage(){
		return image;
	}
	int topX;
	int topY;
	int middleX;
	int middleY;
	int bottomX;
	int bottomY;
}
