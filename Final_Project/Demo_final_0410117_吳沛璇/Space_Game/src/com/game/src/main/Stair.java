package com.game.src.main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.security.SecureRandom;

public class Stair {
	private double x;
	private double y;
	private double velY = 2;
	
	private boolean on = false;
	
	SecureRandom random = new SecureRandom();
	private int ID;
	private int fruit_ID;
	private boolean is_fruit=false;
	private boolean is_meat=false;

	
	BufferedImage image;
	BufferedImage right;
	BufferedImage left;
	BufferedImage knife;
	BufferedImage hamberger;
	BufferedImage fruit[];
	BufferedImage spring;
	
	public Stair(double x, double y, Game game) {
		this.x = x;
		this.y = y;
		
		SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
		ID = 0;
		int seed = random.nextInt(10);
		if(seed == 1) { //right
			ID = 1;
		}else if(seed == 2){ //left
			ID = 2;
		}else if(seed == 3){ //Spring
			ID = 3;
		}else if(seed == 5) {
			is_meat = true;
		}else if(seed == 6 || seed == 7) {
			is_fruit = true;
		}
		image = ss.grabImage(0, 64, 120, 4);
		right = ss.grabImage(10, 68, 120, 20);
		left = ss.grabImage(2, 95, 120, 20);
		knife  = ss.grabImage(65, 0, 740-72, 40);
		hamberger = ss.grabImage(0, 125, 60, 45);
		fruit_ID = random.nextInt(3);
		fruit = new BufferedImage[6];
		fruit[0] = ss.grabImage(0, 170, 60, 64);
		fruit[1] = ss.grabImage(0, 235, 60, 65);
		fruit[2] = ss.grabImage(0, 305, 60, 55);
		spring = ss.grabImage(100, 260, 120, 26);
	
	}
	public void tick() {
		y -= velY;
		if(y < 103 && on==true) {
			y = 105;
		}
	}
	public void render(Graphics g) {
		if(is_meat) {
			g.drawImage(hamberger, (int)x, (int)y, null);
		}else if(is_fruit) {
			g.drawImage(fruit[fruit_ID], (int)x, (int)y, null);
		}else {
			if(ID==0) {
				g.drawImage(image, (int)x, (int)y, null);
			}else if(ID==1) {
				g.drawImage(right, (int)x, (int)y, null);
			}else if(ID==2) {
				g.drawImage(left, (int)x, (int)y, null);
			}else if(ID==3) {
				//Graphics2D g2 = (Graphics2D) g;
                //g2.setStroke(new BasicStroke(5));
                //g2.setColor(Color.RED);
                //g2.drawLine((int)x, (int)y, (int)(x+120), (int)(y));
				g.drawImage(spring, (int)x, (int)y, null);
			}
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
	public boolean is_meat() {
		return this.is_meat;
	}
	public boolean is_fruit() {
		return this.is_fruit;
	}
	public boolean is_stair() {
		if(!is_meat && !is_fruit) {
			return true;
		}else {
			return false;
		}		
	}
	
}
