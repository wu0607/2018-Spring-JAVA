package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.JOptionPane;

public class Player {
	Game game;

	private double x;
	private double y;
	
	private double velX = 0;
	private double velY = 0;
	
	private String name;
	private double initial_weight, curr_weight, ideal_weight;
	
	private BufferedImage player;
	
		
	public Player(double x, double y, Game game) {
		this.game = game;
		this.x = x;
		this.y = y;
		
		
		SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
		
		player = ss.grabImage(0, 0, 64, 64);
		
		name = JOptionPane.showInputDialog("Please enter your name");
		curr_weight = Double.parseDouble(JOptionPane.showInputDialog("Please enter your current weight"));
		initial_weight = curr_weight;
		ideal_weight = Double.parseDouble(JOptionPane.showInputDialog("Please enter your ideal weight"));
		
		
	}
	public void tick() {
		x+=velX;
		y+=velY;
		
		if(x < 0) 
			x = 0;
		if(x > 640-50)
			x = 640-50;
		if(y < 30) 
			y = 38;
		if(y > 850) {
			Music play = new Music();
			//InputStream effect = new FileInputStream(new File(getClass().getResource("Die.wav").toURI()));
			File effect = new File("res/Die.wav");
			play.playMusic(effect);
			game.state = Game.STATE.DEATH;
		}
		
	}
	public void render(Graphics g) {
		g.drawImage(player, (int)x, (int)y, null);
		
		g.setColor(Color.white);
		
		g.setFont(new Font("Ariel", Font.PLAIN, 20));
		g.drawString("Player's name: ", 450, 65);
		
		g.setFont(new Font("Ariel", Font.BOLD+Font.ITALIC, 20));
		g.drawString(name, 585, 65);
		
		g.setFont(new Font("Ariel", Font.PLAIN, 20));
		g.drawString("Current: ", 510, 90);
		
		g.setFont(new Font("Ariel", Font.BOLD+Font.ITALIC, 20));
		g.drawString(String.valueOf(String.format("%.2f",curr_weight)), 585, 90);
		
		g.setFont(new Font("Ariel", Font.PLAIN, 20));
		g.drawString("Ideal: ", 530, 115);
		
		g.setFont(new Font("Ariel", Font.BOLD+Font.ITALIC, 20));
		g.drawString(String.valueOf(ideal_weight), 585, 115);
		
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
	public void setVelY(double velY) {
		this.velY = velY;
	}
	public void subweight() {
		if(curr_weight>0.1 && curr_weight>ideal_weight) {
			this.curr_weight -= 0.01;
		}
	}
	public String get_name() {
		return this.name;
	}
	public String get_initial() {
		return String.valueOf(String.format("%.2f", initial_weight));
	}
	public String get_ideal() {
		return String.valueOf(String.format("%.2f", ideal_weight));
	}
	public String get_current() {
		return String.valueOf(String.format("%.2f", curr_weight));
	}
	
	public void set_name(String name) {
		this.name = name;
	}
	public void set_initial(String initial) {
		this.initial_weight = Double.parseDouble(initial);
	}
	public void set_ideal(String ideal) {
		this.ideal_weight = Double.parseDouble(ideal);
	}
	public void set_current(String current) {
		this.curr_weight = Double.parseDouble(current);
	}
	
}
