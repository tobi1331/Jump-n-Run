package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;



public class GamePanel extends JPanel{

	private MouseInputs mouseInputs;
	private float xDelta = 50,yDelta = 100;
	private BufferedImage img;
	private BufferedImage [] idleAnimation;
	private int aniTick, aniIndex, aniSpeed = 20;


	
	
	public GamePanel() {
		
		mouseInputs=new MouseInputs(this);
		
		importImg();
		loadAnimations();
		
		setPanelSize();
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
	}
	
	
	
	
	private void loadAnimations() {
		idleAnimation = new BufferedImage[3];

		for (int i = 0; i < idleAnimation.length; i++) {
			idleAnimation[i] = img.getSubimage(i * 32, 0, 32, 32);
		}

	}




	private void importImg() {
		
		InputStream is = getClass().getResourceAsStream("/knight.png");
		
		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close(); 
			} catch(IOException e) {
				e.printStackTrace();
			}
			
			
			
		}
		
	}




	private void setPanelSize() {
		Dimension size = new Dimension(1280,800);
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
		
	}




	public void changeXDelta(int value) {
		this.xDelta += value;
		repaint();
	}
	
	public void changeYDelta(int value) {
		this.yDelta += value;
		repaint();
	}
	
	public void setRectPosition(int x, int y) {
		this.xDelta = x;
		this.yDelta = y;
		repaint();
	}
	
	
	private void updateAnimationTick() {
		
		aniTick++;
		if(aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex++;
			if(aniIndex >= idleAnimation.length) {
				aniIndex = 0;
			}
		}
		
		
	}

	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		updateAnimationTick();
		
//		g.drawImage(img.getSubimage(0, 0, 32, 32),0,0,64,64,null);
		
		g.drawImage(idleAnimation[aniIndex],(int)xDelta,(int)yDelta,96,96,null);
		
		
		
		
	}




	

	
}
