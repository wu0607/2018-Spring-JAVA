package com.game.src.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Spring {
	private double x;
	private double y;
	
	BufferedImage image;
	
	public Spring(double x, double y, Game game) {
		this.x = x;
		this.y = y;
		SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
		image = ss.grabImage(0, 68, 120, 4);	
	}
	public void tick() {
		y -= 1;
	}
	public void render(Graphics g) {
		g.drawImage(image, (int)x, (int)y, null);
		
	}
	public double getY() {
		return y;
	}
}
