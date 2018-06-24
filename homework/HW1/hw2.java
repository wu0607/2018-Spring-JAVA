import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class hw2 extends JApplet{
	public void paint(Graphics g){
		super.paint(g);
		g.drawOval(8,8,12,12);
		g.drawLine(15,30,35,15);
		g.drawLine(35,15,50,30);
		g.drawLine(15,30,50,30);
		g.drawRect(20,30,25,40);
		g.drawRect(25,40,15,30);
		g.drawOval(35,50,2,2);
		
		g.drawOval(10,80,20,40);
		g.drawLine(20,100,20,130);
		g.drawOval(40,80,20,40);
		g.drawLine(50,100,50,130);
		g.drawOval(70,80,20,40);
		g.drawLine(80,100,80,130);
	}
}