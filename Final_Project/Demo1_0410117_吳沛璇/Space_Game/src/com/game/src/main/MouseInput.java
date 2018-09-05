package com.game.src.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		//Play Button
		if(Game.state==Game.STATE.MENU && mx>=Game.WIDTH/2+120 && mx<=Game.WIDTH/2+220) {
			if(my>=200 && my<=250) {
				Game.state = Game.STATE.GAME;
			}
		}
		//Quit Button
		if(Game.state==Game.STATE.MENU && mx>=Game.WIDTH/2+120 && mx<=Game.WIDTH/2+220) {
			if(my>=400 && my<=450) {
				System.exit(1);
			}
		}
		//Record Button
		if(Game.state==Game.STATE.DEATH && mx>=Game.WIDTH/2+100 && mx<=Game.WIDTH/2+240) {
			if(my>=200 && my<=250) {
				Game.state = Game.STATE.RECORD;
				
			}
		}
		//Restart Button
		if(Game.state==Game.STATE.DEATH && mx>=Game.WIDTH/2+100 && mx<=Game.WIDTH/2+240) {
			if(my>=300 && my<=350) {
				//Pressed Play Button
				Game.state = Game.STATE.RESTART;
				
			}
		}
		//Quit Button
		if(Game.state==Game.STATE.DEATH && mx>=Game.WIDTH/2+100 && mx<=Game.WIDTH/2+240) {
			if(my>=400 && my<=450) {
				//Pressed Play Button
				System.exit(1);
			}
		}
		//Exit Button
		if(Game.state==Game.STATE.RECORD && mx>=Game.WIDTH+150 && mx<=Game.WIDTH+250) {
			if(my>=Game.HEIGHT+300 && my<=Game.HEIGHT+350) {
				//System.exit(1);
				System.out.println("Exit");
				Game.state = Game.STATE.DEATH;
				
			}
		}
			
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
