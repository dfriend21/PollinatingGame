package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class CornPanel extends JPanel implements MouseListener {

	/*CornImage cornImage;
	BufferedImage topImage;
	BufferedImage middleImage;
	BufferedImage bottomImage;*/
	
	String topImage;
	String middleImage;
	String bottomImage;
	HashMap<String, BufferedImage> images;
	CornImage cornImage;
	int imageWidth;
	int imageHeight;
	
	public CornPanel(PanelInfo panelInfo){
		images = new HashMap<String, BufferedImage>();
		
		topImage = panelInfo.topImage;
		middleImage = panelInfo.middleImage;
		bottomImage = panelInfo.bottomImage;
		
		loadImages();
	}
	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(1000,1000);
	}
	
	public void loadImages(){
		try{
			images.put("leftShootbag", ImageIO.read(new File("src\\shootBagLeft.png")));
			images.put("rightShootbag", ImageIO.read(new File("src\\shootBagRight.png")));
			images.put("leftShoot", ImageIO.read(new File("src\\shootLeft.png")));
			images.put("rightShoot", ImageIO.read(new File("src\\shootRight.png")));
			images.put("leftSilkedShoot", ImageIO.read(new File("src\\silksLeft.png")));
			images.put("rightSilkedShoot", ImageIO.read(new File("src\\silksRight.png")));
			
			
			cornImage = new CornImage(ImageIO.read(new File("src\\cornBasic.png")));
			cornImage.topX = 236;
			cornImage.topY = 301;
			cornImage.middleX = 251;
			cornImage.middleY = 484;
			cornImage.bottomX = 247;
			cornImage.bottomY = 646;
			
			imageWidth = cornImage.getImage().getWidth();
			imageHeight = cornImage.getImage().getHeight();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void setTopImage(String imageName){
		topImage = imageName;
		repaint();
	}
	public void setMiddleImage(String imageName){
		middleImage = imageName;
		repaint();
	}
	public void setBottomImage(String imageName){
		bottomImage = imageName;
		repaint();
	}
	
	protected void paintComponent(Graphics g){
		BufferedImage image = cornImage.getImage();
		g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), this);
		if(topImage != "none"){
			g.drawImage(images.get(topImage), cornImage.topX - images.get(topImage).getWidth(), cornImage.topY - images.get(topImage).getHeight(), this);
		}
		if(middleImage != "none"){
			g.drawImage(images.get(middleImage), cornImage.middleX, cornImage.middleY - images.get(middleImage).getHeight(), this);
		}
		if(bottomImage != "none"){
			g.drawImage(images.get(bottomImage), cornImage.bottomX - images.get(bottomImage).getWidth(), cornImage.bottomY - images.get(bottomImage).getHeight(), this);
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

}
