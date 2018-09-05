package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Explain {
	public Rectangle understandButton = new Rectangle(Game.WIDTH/2+35, 750, 220, 50);
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		g.setFont(new Font("Ariel", Font.BOLD, 50));
		g.setColor(Color.white);
		
		g.setFont(new Font("Ariel", Font.BOLD, 30));
		g2d.draw(understandButton);
		g.drawString("I understand !", understandButton.x+10, understandButton.y+33);
		g2d.draw(understandButton);
		
	}
	
}
