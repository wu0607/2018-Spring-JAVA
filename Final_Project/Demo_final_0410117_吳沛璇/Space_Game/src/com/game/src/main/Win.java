package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Win {
	private Rectangle hahaButton = new Rectangle(70, 250, 200, 80);
	Game game;
	
	public void render(Graphics g, Game game) {
		this.game = game;
		Graphics2D g2d = (Graphics2D)g;
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Ariel", Font.BOLD, 40));
		g2d.draw(hahaButton);
		g.drawString("HA~HA~", hahaButton.x+25, hahaButton.y+52);
		
	}

	
		
}
