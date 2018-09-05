package com.game.src.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class P_Mode {
	public Rectangle oneButton = new Rectangle(Game.WIDTH/2+80, 250, 180, 50);
	public Rectangle twoButton = new Rectangle(Game.WIDTH/2+80, 350, 180, 50);
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		g.setFont(new Font("Ariel", Font.BOLD, 50));
		g.setColor(Color.white);
		
		g.setFont(new Font("Ariel", Font.BOLD, 30));
		g2d.draw(oneButton);
		g.drawString("One Player", oneButton.x+12, oneButton.y+33);
		g2d.draw(twoButton);
		g.drawString("Two Player", twoButton.x+12, twoButton.y+33);		
		
	}
}
