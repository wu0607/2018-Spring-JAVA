import javax.sound.sampled.*;
import java.io.File;


public class GamePlay{
	
	public GamePlay(){
		// File effect = new File("Die.wav");
		// playMusic(effect);
		
		// if(music_no == 0){
			// File music = new File("music/Boku_no_Hero_Academia_OP1.wav");
			// playMusic(music);
		// }
		// else if(music_no == 1){
			// File music = new File("music/Attack_on_Titan_OP1.wav");
			// playMusic(music);
		// }
		
	}
	
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