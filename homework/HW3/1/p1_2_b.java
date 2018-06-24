import java.awt.Graphics;
import javax.swing.*;

public class p1_2_b extends JPanel{
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int width = getWidth();
		int height = getHeight();
		for(int i=0 ; i<15 ; ++i){
			g.drawLine(0, height/15*i, width/15*(i+1), height);
			g.drawLine(width/15*i, 0, width, height/15*(i+1));				//b
			g.drawLine(0, height/15*(i+1), width-width/15*i, 0);			//b
			g.drawLine(width/15*i, height, width, height-height/15*(i+1));	//b
		}
		
	}
	public static void main(String[] args){
		JFrame f = new JFrame();
		f.setSize(300, 300);
		p1_2_b p = new p1_2_b();
		f.add(p);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}