package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {
	
	public Rectangle playButton = new Rectangle(Game.WIDTH/2+120, 200, 100, 50);
	public Rectangle helpButton = new Rectangle(Game.WIDTH/2+120, 300, 100, 50);
	public Rectangle quitButton = new Rectangle(Game.WIDTH/2+120, 400, 100, 50);
					
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		g.setFont(new Font("Ariel", Font.BOLD, 50));
		g.setColor(Color.white);
		g.drawString("NS-SHAFT", Game.WIDTH/2+30, 150);
		
		g.setFont(new Font("Ariel", Font.BOLD, 30));
		g2d.draw(playButton);
		g.drawString("Play", playButton.x+20, playButton.y+33);
		g2d.draw(helpButton);
		g.drawString("Help", helpButton.x+20, helpButton.y+33);		
		g2d.draw(quitButton);
		g.drawString("Quit", quitButton.x+20, quitButton.y+33);	
	}
	
}
