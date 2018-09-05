package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.game.src.main.Game.STATE;

public class Enemy {
	Game game;

	private double x = 260;
	private double y = 50;
	
	private double velX = 0;
	
	private String name;
	private double initial_weight, curr_weight, ideal_weight;
	
	private BufferedImage enemy;
	
	private LinkedList<Bullet> bullet = new LinkedList<Bullet>();
	private Bullet TempBullet;
		
	public Enemy(Game game) {
		this.game = game;	
		
		SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
		
		enemy = ss.grabImage(100, 200, 68, 48);
		
		
	}
	public void tick(Player p, Health h) {
		//System.out.print("  bulletsize: " + bullet.size());
		x+=velX;
		
		if(x < 0) 
			x = 0;
		if(x > 640-50)
			x = 640-50;
		
		for(int i=0 ; i<bullet.size() ; i++) {
			
			TempBullet = bullet.get(i);
			
			if(TempBullet.getY()>1000) {
				removeBullet(TempBullet);
			}
			
			if( (p.getX()-TempBullet.getX()>-60  &&  p.getX()-TempBullet.getX()<15 //bullet is at the left-up of the player
					&& p.getY()-TempBullet.getY()>-60 && p.getY()-TempBullet.getY()<40 ) ||
				((p.getX()-TempBullet.getX()>-60  &&  p.getX()-TempBullet.getX()<15 //bullet is at the left-lower of the player
						&& TempBullet.getY()-p.getY()>-60 && TempBullet.getY()-p.getY()<40 ))   )
			
			{
				h.subHealth(10);
				removeBullet(TempBullet);
			}
			
			TempBullet.tick();
			
		}	
		
	}
	public void render(Graphics g) {
		g.drawImage(enemy, (int)x, (int)y, null);
		for(int i=0 ; i<bullet.size() ; i++) {
			
			TempBullet = bullet.get(i);
			
			TempBullet.render(g);
		}		
		
		
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void setVelX(double velX) {
		this.velX = velX;
	}
	
	public void addBullet(Bullet block) {
		bullet.add(block);
	}
	public void removeBullet(Bullet block) {
		bullet.remove(block);
	}
	public void removeAllBullet() {
		for(int i=0 ; i<bullet.size(); ++i) {
			removeBullet(bullet.get(i));
		}
	}

}
