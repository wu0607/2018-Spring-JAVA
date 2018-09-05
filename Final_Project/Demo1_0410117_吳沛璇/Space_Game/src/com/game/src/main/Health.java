package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

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
		g.setColor(Color.GREEN);
		g.fillRect(5,50,(int)HEALTH,38);
		g.setColor(Color.WHITE);
		g.drawRect(5,50,100,38);
		
	}
	public void subHealth() {
		HEALTH -= 1;
		if(HEALTH < -8) {
			HEALTH = 0;
			game.state = STATE.DEATH;
		}
	}
	public void addHealth() {
		HEALTH += 0.2;
		if(HEALTH > 100) {
			HEALTH = 100;
		}
	}
	public void setHealth(int HEALTH) {
		this.HEALTH = HEALTH;
	}
}
