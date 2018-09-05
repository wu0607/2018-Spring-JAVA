package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;

import com.game.src.main.Game.STATE;


public class Health {

	Game game;
	
	private double HEALTH = 100;
	
	public Health(Game game) {
		this.game = game;
	}
	public void tick() {	
		
	}
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(5,50,100,38);
		if((int)HEALTH > 60) {
			g.setColor(Color.GREEN);
		}else if((int)HEALTH > 40){
			g.setColor(Color.ORANGE);
		}else {
			g.setColor(Color.RED);
		}
		g.fillRect(5,50,(int)HEALTH,38);
		g.setColor(Color.WHITE);
		g.drawRect(5,50,100,38);
		
	}
	public void subHealth(double quantity) {
		HEALTH -= quantity;
		if(HEALTH < -5) {
			HEALTH = 0;
			Music play = new Music();
			File effect = new File("res/Die.wav");
			play.playMusic(effect);
			game.state = STATE.DEATH;
		}
	}
	public void addHealth(double quantity) {
		HEALTH += quantity;
		if(HEALTH > 100) {
			HEALTH = 100;
		}
	}
	public void setHealth(int HEALTH) {
		this.HEALTH = HEALTH;
	}
	
}
