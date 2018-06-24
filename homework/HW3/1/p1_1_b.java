import java.awt.Graphics;
import javax.swing.*;

public class p1_1_b extends JPanel{
	// public p1_1_b(){
		// setVisible(true);
		// setSize(200,200);
	// }
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int width = getWidth();
		int height = getHeight();
		for(int i=1 ; i<15 ; ++i){
			g.drawLine(0, 0, width/15*i, height-height/15*i);
			g.drawLine(width, 0, width/15*i, height/15*i);			  //b
			g.drawLine(0, height, width/15*i, height/15*i);			  //b
			g.drawLine(width, height, width/15*i, height-height/15*i);//b
		}
		
	}
	public static void main(String[] args){
		JFrame f = new JFrame();
		f.setSize(300, 300);
		p1_1_b p = new p1_1_b();
		f.add(p);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}