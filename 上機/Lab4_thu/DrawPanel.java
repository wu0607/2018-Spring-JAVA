import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.* ;
import javax.swing.event.*;

public class DrawPanel extends JPanel implements ActionListener
{
	private JButton clockwise,counterclockwise;
	//private JPanel	myPanel;
	private JFrame 	frame;
	private int degree;
	public DrawPanel( int n, JFrame f)
	{
		frame = f;
		degree= n;	
		
//advance		
		clockwise = new JButton("clockwise");
		counterclockwise = new JButton("counterclockwise");
		clockwise.addActionListener(this);
		counterclockwise.addActionListener(this);
		this.add(clockwise);
		this.add(counterclockwise);
		repaint();
	}
	public void paintComponent(Graphics g)
	{	
		super.paintComponent(g);
		
//your code		
		int radius = 100;
		g.setColor(Color.gray);
		int x1 = getWidth()/2 - radius/2;
		int y1 = getHeight()/2 - radius/2;
		//double scalar = Math.sqrt(x1*x1 + x2*x2) / radius;
		int x2 = x1+radius/2+(int)( (radius/2)*Math.cos(Math.toRadians(degree)) );
		int y2 = y1+radius/2-(int)( (radius/2)*Math.sin(Math.toRadians(degree)) );
		
		
		g.fillOval(x1, y1, radius, radius);
		g.setColor(Color.black);
		g.drawLine(x1+radius/2, y1+radius/2, x2, y2);
	}


//advance
	public void actionPerformed(ActionEvent event){
		System.out.println("hi");
		frame.remove(this);
		if(event.getSource()==clockwise){
			degree -= 10;
			frame.add(new DrawPanel(degree, frame));
		}else if(event.getSource()==counterclockwise){
			degree += 10;		
			frame.add(new DrawPanel(degree, frame));
		}
		frame.revalidate();
		
	}	
		
}