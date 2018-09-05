package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Death {
	public Rectangle recordButton = new Rectangle(Game.WIDTH/2+100, 200, 140, 50);
	public Rectangle restartButton = new Rectangle(Game.WIDTH/2+100, 300, 140, 50);
	public Rectangle quitButton = new Rectangle(Game.WIDTH/2+100, 400, 140, 50);
					
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
}
