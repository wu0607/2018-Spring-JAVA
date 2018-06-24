import java.awt.*;
import javax.swing.*;

public class Demo2_4_panel extends JPanel
{	 
    int number;
	JFrame f;
	int radius;
	
	//constructor
	public Demo2_4_panel(JFrame w, int number){
		radius = (int)(Math.random()*130) + 20;
		setSize(500, 600);
		setVisible(true);
		f = w;
		this.number = number;
	}
	
	public void paintComponent(Graphics g)
    {  
        super.paintComponent(g);
		int red = (int)(Math.random()*255);
		int green = (int)(Math.random()*255);
		int blue = (int)(Math.random()*255);
		g.setColor(new Color(red, green, blue));

		// your code
		int x = getWidth() / 2;
		Point pt = SwingUtilities.convertPoint(f, 0, f.getHeight()/2, this);
		int y = pt.y;
		//Read JFrame size from JPanel
		//https://stackoverflow.com/questions/7484137/read-jframe-size-from-jpanel
		//int y = getParent().getHeight() / 2;
		if(number == 0){
			g.fillRect(x-radius/2, y-radius/2, radius, radius);

		}else if(number == 1){
			g.fillOval(x-radius/2, y-radius/2, radius, radius);
		}
		
    }      

}
