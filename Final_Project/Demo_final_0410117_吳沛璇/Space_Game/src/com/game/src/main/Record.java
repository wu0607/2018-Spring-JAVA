package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Record {
	private Rectangle exitButton = new Rectangle(Game.WIDTH+200, Game.HEIGHT+350, 100, 50);
	private Player p;
	Game game;
	
	public void render(Graphics g, Player p, Game game) {
		this.p = p;
		this.game = game;
		Graphics2D g2d = (Graphics2D)g;
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Ariel", Font.BOLD, 30));
		g2d.draw(exitButton);
		g.drawString("Exit", exitButton.x+20, exitButton.y+33);
		
		g.setFont(new Font("Ariel", Font.BOLD, 28));
		g.drawString("Name", 75, 485);
		g.drawString("Initial", 220, 485);
		g.drawString("Ideal", 350, 485);
		g.drawString("Current", 465, 485);
		
		//g.drawString(p.get_name(), 75, 600);
		//g.drawString(p.get_initial(), 225, 600);
		//g.drawString(p.get_ideal(), 350, 600);
		//g.drawString(p.get_current(), 465, 600);
		
		
		for(int i=0; i<game.full_record.size(); ++i) {
			g.drawString(game.full_record.get(i), 75+140*(i%4), 530+40*(i/4));
			
		}
		
	}
	
}
