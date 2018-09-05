package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Death {
	
	private boolean get = false;
	private Game game;
	private Player p;
	
	public Rectangle recordButton = new Rectangle(Game.WIDTH/2+100, 200, 140, 50);
	public Rectangle restartButton = new Rectangle(Game.WIDTH/2+100, 300, 140, 50);
	public Rectangle quitButton = new Rectangle(Game.WIDTH/2+100, 400, 140, 50);
		
	public Death(Game game, Player p) {
		this.game = game;
		this.p = p;
	}
	public void tick(Game game, Player p) {
		if(get == false) {
			game.full_record.add(p.get_name());
			game.full_record.add(String.valueOf(p.get_initial()));
			game.full_record.add(String.valueOf(p.get_ideal()));
			game.full_record.add(String.valueOf(p.get_current()));
			get = true;
		}
		
	}
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		g.setColor(Color.white);
		g.setFont(new Font("Ariel", Font.BOLD, 30));
		g2d.draw(recordButton);
		g.drawString("Record", recordButton.x+20, recordButton.y+33);
		g2d.draw(restartButton);
		g.drawString("Restart", restartButton.x+20, restartButton.y+33);		
		g2d.draw(quitButton);
		g.drawString("  Quit", quitButton.x+20, quitButton.y+33);	
	}
	public void reset_get() {
		this.get = false;
	}
}
