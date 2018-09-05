package com.game.src.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Controller {

	private LinkedList<Stair> s = new LinkedList<Stair>();
	
	Stair TempStair;
	Game game;
	
	private final int HAPPY_TIME = 1;
	private final int RECOVER_TIME = 10;
	
	public Controller(Game game) {
		this.game = game;
		
		for(int i=0 ; i<5 ; ++i) {
			addStair(new Stair(Math.random()*550, 400+80*i, game));
		}
	}
	
	public void tick(Player p, Health h, int passtime) {
		if(passtime % HAPPY_TIME == 0) {
			p.subweight();		
		}
		if(passtime % RECOVER_TIME == 0) {
			h.addHealth();
		}
		if(s.size()<6) {
			addStair(new Stair(Math.random()*550, 840, game));
		}
		
		boolean still_on=false;
		for(int i=0 ; i<s.size() ; i++) {			
			TempStair = s.get(i);
			if(TempStair.getY()<0)
				removeStair(TempStair);
			
			if( ((TempStair.getX()-p.getX()>0) && (TempStair.getX()-p.getX()<32) 
					&& (TempStair.getY()-p.getY()<65) && (TempStair.getY()-p.getY()>50))
				|| ((p.getX()-TempStair.getX()>0) && (p.getX()-TempStair.getX()<92) 
					&& (TempStair.getY()-p.getY()<65) && (TempStair.getY()-p.getY()>50)) )
			{
				still_on = true;
				TempStair.set_on(true);
				p.setVelY(-TempStair.getVelY());
			}
				
			TempStair.tick();
		}	
		if(still_on==false) {
			for(int i=0 ; i<s.size() ; i++) {
				TempStair.set_on(false);
				TempStair = s.get(i);
				TempStair.setVelY(4);
			}
			p.setVelY(TempStair.getVelY());
		}else {
			for(int i=0 ; i<s.size() ; i++) {
				TempStair = s.get(i);
				if(TempStair.get_on()==true && p.getY()<45) { //kill
					h.subHealth();			
				}else {
					TempStair.setVelY(2.5);
				}
			}
		}
	}
	
	public void render(Graphics g) {
		for(int i=0 ; i<s.size() ; i++) {
			
			TempStair = s.get(i);
			
			TempStair.render(g);
		}		
	}
	
	public void addStair(Stair block) {
		s.add(block);
	}
	public void removeStair(Stair block) {
		s.remove(block);
	}
	//public void clear() {
	//	for(int i=0; i)
	//}
	
	
}
