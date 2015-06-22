package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

final public class Test2 {

	JFrame frame;
	MyPanel mp;
	
	
	public static void main(String[] args) {
		Test2 t2 = new Test2();
		t2.run();
	}
	
	class MyPanel extends JPanel implements MouseListener{
		boolean isGreen = true;
		Color brightGreen = new Color(123, 234, 67);
		Color darkBlue = new Color(57, 23, 215);
		Color lightBlue = new Color(23,213,187);
		int movingBarWidth = 75;
		int targetY = 150;
		int targetHeight = 30;
		int crosshairsWidth = 5;
		int crosshairsXCenter = 103;

		int currentX = 0;
		public MyPanel(){
			addMouseListener(this);
		}
		public void paintComponent(Graphics g){
			//g.drawRect(0, 20, this.getWidth(), 20);
			g.fillRect(0, this.getHeight() - 50, this.getWidth(), 30);
			
			//Moving Bar
			g.fillRect(currentX, 0, movingBarWidth, this.getHeight() - 50);
			
			//Target on Bar
			if(isGreen){
				g.setColor(brightGreen);
			} else{
				g.setColor(darkBlue);
			}
			g.fillRect(currentX, targetY, movingBarWidth, targetHeight);
			
			//Cross-hairs
			g.setColor(lightBlue);
			g.fillRect(crosshairsXCenter - crosshairsWidth/2, 0, crosshairsWidth, this.getHeight());
			g.fillRect(80, 163, 45, crosshairsWidth);
		}
		
		public void animate(){
			while(true){
				if(currentX<0){
					currentX = this.getWidth();
				} else {
					currentX-=2;
				}
				frame.repaint();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			if(currentX <= crosshairsXCenter && currentX >= crosshairsXCenter-movingBarWidth){
				isGreen = !isGreen;
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}

	public void run(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 1000);
		frame.setLocationByPlatform(true);
		mp = new MyPanel();

        frame.getContentPane().add(BorderLayout.CENTER, mp);
        frame.setVisible(true);
        
        mp.animate();
	}
}
