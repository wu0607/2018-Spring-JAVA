package com.game.src.main;

import java.awt.Graphics;
import java.io.File;
import java.util.LinkedList;

public class Controller {

	private LinkedList<Stair> s = new LinkedList<Stair>();
	
	
	Stair TempStair;
	Game game;
	
	private final int HAPPY_TIME = 1;
	private final int RECOVER_TIME = 10;
	//private final int addStairTime = 1;
	
	public Controller(Game game) {	
		this.game = game;
		
		for(int i=0 ; i<18 ; ++i) {
			double shift = Math.random()*30;
			addStair(new Stair(Math.random()*550, 400+80*i+shift, game));
		}
	}
	private boolean addnew = false;
	public void tick(Player p, Health h, int passtime) {
		if(passtime % HAPPY_TIME == 0) {
			p.subweight(0.01);		
		}
		if(passtime % RECOVER_TIME == 0) {
			h.addHealth(0.02);
		}
		/*if(passtime % addStairTime == 0 && addnew == false) {
			double shift = Math.random()*200;
			addStair(new Stair(Math.random()*550, 800+shift, game));
			addnew = true;
			System.out.print("addddddddd");
		}else if(passtime % addStairTime != 0){
			addnew = false;
		}*/
		if(s.size()<15) {
			//double shift = Math.random()*30;
			//double shift = 0;
			addStair(new Stair(Math.random()*550, 880, game));
		}
		
		boolean still_on=false;
		for(int i=0 ; i<s.size() ; i++) {			
			TempStair = s.get(i);
			if(TempStair.getY()<0)
				removeStair(TempStair);
			
			if(TempStair.is_stair() && 
					(
				((TempStair.getX()-p.getX()>0) && (TempStair.getX()-p.getX()<32) 
					&& (TempStair.getY()-p.getY()<65) && (TempStair.getY()-p.getY()>50))
				|| ((p.getX()-TempStair.getX()>0) && (p.getX()-TempStair.getX()<92) 
					&& (TempStair.getY()-p.getY()<65) && (TempStair.getY()-p.getY()>50)) 
					)
				)
			{
				still_on = true;
				TempStair.set_on(true);
				p.setVelY(-TempStair.getVelY());
				
				if(TempStair.get_ID()==1) {p.setVelX(1);}
				else if(TempStair.get_ID()==2) {p.setVelX(-1);}
				else if(TempStair.get_ID() == 3) { //Spring
					p.setY(p.getY()-130);
					p.setVelY(-1.05*TempStair.getVelY());
				}
			}else if(TempStair.is_meat() && 
					(
				((TempStair.getX()-p.getX()>0) && (TempStair.getX()-p.getX()<70) 
					&& (TempStair.getY()-p.getY()<70) && (TempStair.getY()-p.getY()>50))
				|| ((p.getX()-TempStair.getX()>0) && (p.getX()-TempStair.getX()<70) 
					&& (TempStair.getY()-p.getY()<70) && (TempStair.getY()-p.getY()>50)) 
					)
				)
			{
				System.out.print("MEAT!");
				removeStair(TempStair);
				h.subHealth(20);	
				p.addweight(10);
				
			}else if(TempStair.is_fruit() && 
					(
				((TempStair.getX()-p.getX()>0) && (TempStair.getX()-p.getX()<70) 
					&& Math.abs(TempStair.getY()-p.getY())<70 && Math.abs(TempStair.getY()-p.getY())>50)
				|| ((p.getX()-TempStair.getX()>0) && (p.getX()-TempStair.getX()<70) 
					&& Math.abs(TempStair.getY()-p.getY())<70 && Math.abs(TempStair.getY()-p.getY())>50) 
					)
				)
			{
				System.out.print("FRUIT!");
				removeStair(TempStair);
				h.addHealth(10);	
				p.subweight(5);
				
			}
				
			TempStair.tick();
		}	
		if(still_on==false) {
			for(int i=0 ; i<s.size() ; i++) {
				TempStair = s.get(i);
				TempStair.set_on(false);
				TempStair.setVelY(4);
			}
			p.setVelY(TempStair.getVelY());
		}else {
			for(int i=0 ; i<s.size() ; i++) {
				TempStair = s.get(i);
				if(TempStair.get_on()==true && p.getY()<45) { //kill
					h.subHealth(1);			
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
