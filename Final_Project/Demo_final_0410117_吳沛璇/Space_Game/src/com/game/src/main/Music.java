package com.game.src.main;

import javax.sound.sampled.*;
import java.io.File;

public class Music {

	static void playMusic(File music){
		try{
			AudioInputStream sound = AudioSystem.getAudioInputStream(music);
			Clip clip = AudioSystem.getClip();
			clip.open(sound);
			clip.setFramePosition(0);
			clip.start();
			
			Thread.sleep(clip.getMicrosecondLength()/1000);
		}catch(Exception e){
			System.out.println("Failed. ("+e.getMessage()+")");
		}
	}
	
	
	
}
