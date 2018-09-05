package com.game.src.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Stair {
	private double x;
	private double y;
	private double velY = 2;
	
	private boolean on = false;
	
	BufferedImage image;
	BufferedImage knife;
	
	public Stair(double x, double y, Game game) {
		this.x = x;
		this.y = y;
		
		SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
		
		image = ss.grabImage(0, 64, 120, 4);
		knife  = ss.grabImage(65, 0, 740-72, 40);
	
	}
	public void tick() {
		y -= velY;
		if(y < 103 && on==true) {
			y = 105;
		}
	}
	public void render(Graphics g) {
		g.drawImage(image, (int)x, (int)y, null);
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
	
}
