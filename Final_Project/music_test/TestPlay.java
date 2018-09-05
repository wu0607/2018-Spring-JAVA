import java.io.File;

public class TestPlay{
	public static void main(String[] args){
		GamePlay play = new GamePlay();
		File effect = new File("Die.wav");
		play.playMusic(effect);
		
	}
}