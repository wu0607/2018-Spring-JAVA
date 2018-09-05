package com.game.src.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.security.SecureRandom;

public class Stair {
	private double x;
	private double y;
	private double velY = 2;
	
	private boolean on = false;
	
	SecureRandom random = new SecureRandom();
	private int ID;
	
	BufferedImage image;
	BufferedImage right;
	BufferedImage left;
	BufferedImage knife;
	
	public Stair(double x, double y, Game game) {
		this.x = x;
		this.y = y;
		
		SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
		
		ID = random.nextInt(4)%3;//0123
		image = ss.grabImage(0, 64, 120, 4);
		right = ss.grabImage(10, 68, 120, 20);
		left = ss.grabImage(2, 95, 120, 20);
		knife  = ss.grabImage(65, 0, 740-72, 40);
	
	}
	public void tick() {
		y -= velY;
		if(y < 103 && on==true) {
			y = 105;
		}
	}
	public void render(Graphics g) {
		if(ID==0) {
			g.drawImage(image, (int)x, (int)y, null);
		}else if(ID==1) {
			g.drawImage(right, (int)x, (int)y, null);
		}else if(ID==2) {
			g.drawImage(left, (int)x, (int)y, null);
		}
		g.drawImage(knife, 0, 0, null);
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	
	public void setVelY(double velY) {
		this.velY = velY;
	}
	public double getVelY() {
		return this.velY;
	}
	public void set_on(boolean on) {
		this.on = on;
	}
	public boolean get_on() {
		return this.on;
	}
	public int get_ID() {
		return this.ID;
	}
	
}
