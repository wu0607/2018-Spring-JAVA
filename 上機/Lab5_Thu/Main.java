import java.awt.*;
import javax.swing.*;

public class Main {
	public static void main(String[] args){
		MyPanel p = new MyPanel();
		JFrame f = new JFrame();
		p.setFocusable(true);
		f.add(p);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500, 500);
		f.setVisible(true);
	}
}
