package com.game.src.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class MouseInput implements MouseListener{

	private String init_string="", ideal_string=""; 
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
		Music play = new Music();
		File effect = new File("res/Button.wav");
		File typing = new File("res/type.wav");
		File help = new File("res/help.wav");
		
		int mx = e.getX();
		int my = e.getY();
		
		//One/Two Player
		if(Game.state==Game.STATE.Choose_Mode && mx>=Game.WIDTH/2+80 && mx<=Game.WIDTH/2+260) {
			play.playMusic(effect);
			if(my>=250 && my<=300) {
				Game.state = Game.STATE.MENU;
			}else if(my>=350 && my<=400) {
				Game.two_player = true;
				Game.state = Game.STATE.MENU;
			}
		}
		//Play Button
		if(Game.state==Game.STATE.MENU && mx>=Game.WIDTH/2+120 && mx<=Game.WIDTH/2+220) {
			play.playMusic(effect);
			if(my>=200 && my<=250) {
				Game.state = Game.STATE.GAME;
			} 
		}
		//HELP Button
		if(Game.state==Game.STATE.MENU && mx>=Game.WIDTH/2+120 && mx<=Game.WIDTH/2+220) {
			if(my>=300 && my<=350) {
				System.out.println("HELP");
				Game.state = Game.STATE.HELP;
			}
			//play.playMusic(help);
			
		}//Understand Button
		if(Game.state==Game.STATE.HELP && mx>=Game.WIDTH/2+35 && mx<=Game.WIDTH/2+255) {
			if(my>=750 && my<=800) {
				System.out.println("HELP");
				Game.state = Game.STATE.MENU;
				play.playMusic(help);
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
			play.playMusic(effect);
			if(my>=200 && my<=250) {
				Game.state = Game.STATE.RECORD;
				
			}
		}
		//Restart Button
		if(Game.state==Game.STATE.DEATH && mx>=Game.WIDTH/2+100 && mx<=Game.WIDTH/2+240) {
			if(my>=300 && my<=350) {
				//Pressed Play Button
				Game.state = Game.STATE.PREPARE;
				
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
		if(Game.state==Game.STATE.RECORD && mx>=Game.WIDTH+200 && mx<=Game.WIDTH+300) {
			play.playMusic(effect);
			if(my>=Game.HEIGHT+350 && my<=Game.HEIGHT+400) {
				//System.exit(1);
				Game.state = Game.STATE.DEATH;
			}
		}
		//New Information
		if(Game.state==Game.STATE.PREPARE && my>=125 && my<=165) {
			play.playMusic(typing);
			if(mx>=50 && mx<=90) {
				Game.p.set_name(Game.p.get_name() + "A");
			}else if(mx>=100 && mx<=140) {
				Game.p.set_name(Game.p.get_name() + "B");
			}else if(mx>=150 && mx<=190) {
				Game.p.set_name(Game.p.get_name() + "C");
			}else if(mx>=200 && mx<=240) {
				Game.p.set_name(Game.p.get_name() + "D");
			}else if(mx>=250 && mx<=290) {
				Game.p.set_name(Game.p.get_name() + "E");
			}else if(mx>=300 && mx<=340) {
				Game.p.set_name(Game.p.get_name() + "F");
			}else if(mx>=350 && mx<=390) {
				Game.p.set_name(Game.p.get_name() + "G");
			}else if(mx>=400 && mx<=440) {
				Game.p.set_name(Game.p.get_name() + "H");
			}else if(mx>=450 && mx<=490) {
				Game.p.set_name(Game.p.get_name() + "I");
			}else if(mx>=500 && mx<=540) {
				Game.p.set_name(Game.p.get_name() + "J");
			}else if(mx>=550 && mx<=590) {
				Game.p.set_name(Game.p.get_name() + "K");
			}
		}
		if(Game.state==Game.STATE.PREPARE && my>=175 && my<=215) {
			play.playMusic(typing);
			if(mx>=50 && mx<=90) {
				Game.p.set_name(Game.p.get_name() + "L");
			}else if(mx>=100 && mx<=140) {
				Game.p.set_name(Game.p.get_name() + "M");
			}else if(mx>=150 && mx<=190) {
				Game.p.set_name(Game.p.get_name() + "N");
			}else if(mx>=200 && mx<=240) {
				Game.p.set_name(Game.p.get_name() + "O");
			}else if(mx>=250 && mx<=290) {
				Game.p.set_name(Game.p.get_name() + "P");
			}else if(mx>=300 && mx<=340) {
				Game.p.set_name(Game.p.get_name() + "Q");
			}else if(mx>=350 && mx<=390) {
				Game.p.set_name(Game.p.get_name() + "R");
			}else if(mx>=400 && mx<=440) {
				Game.p.set_name(Game.p.get_name() + "S");
			}else if(mx>=450 && mx<=490) {
				Game.p.set_name(Game.p.get_name() + "T");
			}else if(mx>=500 && mx<=540) {
				Game.p.set_name(Game.p.get_name() + "U");
			}else if(mx>=550 && mx<=590) {
				Game.p.set_name(Game.p.get_name() + "V");
			}
		}
		if(Game.state==Game.STATE.PREPARE && my>=225 && my<=265) {
			play.playMusic(typing);
			if(mx>=50 && mx<=90) {
				Game.p.set_name(Game.p.get_name() + "W");
			}else if(mx>=100 && mx<=140) {
				Game.p.set_name(Game.p.get_name() + "X");
			}else if(mx>=150 && mx<=190) {
				Game.p.set_name(Game.p.get_name() + "Y");
			}else if(mx>=200 && mx<=240) {
				Game.p.set_name(Game.p.get_name() + "Z");
			}else if(mx>=250 && mx<=350) {
				Game.p.set_name("");
			}
		}
		if(Game.state==Game.STATE.PREPARE && my>=410 && my<=450) {
			play.playMusic(typing);
			if(mx>=30 && mx<=70) {
				init_string += "0";
				Game.p.set_initial(init_string);Game.p.set_current(init_string);
			}else if(mx>=80 && mx<=130) {
				System.out.println("1");
				init_string += "1";
				Game.p.set_initial(init_string);Game.p.set_current(init_string);
			}else if(mx>=130 && mx<=170) {
				init_string += "2";
				Game.p.set_initial(init_string);Game.p.set_current(init_string);
			}else if(mx>=180 && mx<=220) {
				init_string += "3";
				Game.p.set_initial(init_string);Game.p.set_current(init_string);
			}else if(mx>=230 && mx<=270) {
				init_string += "4";
				Game.p.set_initial(init_string);Game.p.set_current(init_string);
			}else if(mx>=280 && mx<=320) {
				init_string += "5";
				Game.p.set_initial(init_string);Game.p.set_current(init_string);
			}else if(mx>=330 && mx<=370) {
				init_string += "6";
				Game.p.set_initial(init_string);Game.p.set_current(init_string);
			}else if(mx>=380 && mx<=420) {
				init_string += "7";
				Game.p.set_initial(init_string);Game.p.set_current(init_string);
			}else if(mx>=430 && mx<=470) {
				init_string += "8";
				Game.p.set_initial(init_string);Game.p.set_current(init_string);
			}else if(mx>=480 && mx<=520) {
				init_string += "9";
				Game.p.set_initial(init_string);Game.p.set_current(init_string);
			}else if(mx>=490 && mx<=570) {
				init_string += ".";
				Game.p.set_initial(init_string);Game.p.set_current(init_string);
			}else if(mx>=580 && mx<=620) {
				init_string = "";
				Game.p.set_initial("0");
			}
		}
		if(Game.state==Game.STATE.PREPARE && my>=580 && my<=620) {
			play.playMusic(typing);
			if(mx>=30 && mx<=70) {
				ideal_string += "0";
				Game.p.set_ideal(ideal_string);
			}else if(mx>=80 && mx<=130) {
				System.out.println("1");
				ideal_string += "1";
				Game.p.set_ideal(ideal_string);
			}else if(mx>=130 && mx<=170) {
				ideal_string += "2";
				Game.p.set_ideal(ideal_string);
			}else if(mx>=180 && mx<=220) {
				ideal_string += "3";
				Game.p.set_ideal(ideal_string);
			}else if(mx>=230 && mx<=270) {
				ideal_string += "4";
				Game.p.set_ideal(ideal_string);
			}else if(mx>=280 && mx<=320) {
				ideal_string += "5";
				Game.p.set_ideal(ideal_string);
			}else if(mx>=330 && mx<=370) {
				ideal_string += "6";
				Game.p.set_ideal(ideal_string);
			}else if(mx>=380 && mx<=420) {
				ideal_string += "7";
				Game.p.set_ideal(ideal_string);
			}else if(mx>=430 && mx<=470) {
				ideal_string += "8";
				Game.p.set_ideal(ideal_string);
			}else if(mx>=480 && mx<=520) {
				ideal_string += "9";
				Game.p.set_ideal(ideal_string);
			}else if(mx>=490 && mx<=570) {
				ideal_string += ".";
				Game.p.set_ideal(ideal_string);
			}else if(mx>=580 && mx<=620) {
				ideal_string = "";
				Game.p.set_ideal("0");
			}
		}
		//start
		if(Game.state==Game.STATE.PREPARE && my>=780 && my<=820) {
			play.playMusic(effect);
			if(mx>=120 && mx<=300) {
				Game.two_player = false;
				Game.state = Game.STATE.RESTART;
			}else if(mx>=320 && mx<=500) {
				Game.two_player = true;
				Game.state = Game.STATE.RESTART;
			}
		}
		if(Game.state==Game.STATE.WIN && my>=250 && my<=330) {
			play.playMusic(effect);
			if(mx>=70 && mx<=270) {
				Game.state = Game.STATE.DEATH;
			}
		}
			
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
