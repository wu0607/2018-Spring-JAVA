package com.game.src.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.security.SecureRandom;

public class Bullet {
	private double x;
	private double y=80;
	private double velY = 5;
	
	
	SecureRandom random = new SecureRandom();
	
	Game game;
	BufferedImage bullet;
		
	public Bullet(double x, Game game) {
		this.x = x;
		this.game = game;
		
		SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
		
		bullet = ss.grabImage(100, 130, 20, 55);
	
	}
	public void tick() {
		y += velY;
	}
	public void render(Graphics g) {
		g.drawImage(bullet, (int)x, (int)y, null);
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
	
	
}
