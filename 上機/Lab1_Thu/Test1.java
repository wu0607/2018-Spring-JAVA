
import javax.swing.*;
import java.awt.Graphics;
import java.awt.*;
//import ...
import java.net.URL;
import javax.imageio.ImageIO;
import java.io.*;

public class Test1 extends JApplet {
	int x, y;
	String xVal, yVal;
	Image img;
	public void init() {
		// Input-Dialog
		xVal = JOptionPane.showInputDialog("x =");
		yVal = JOptionPane.showInputDialog("y =");		
		x = Integer.parseInt(xVal);
		y = Integer.parseInt(yVal);
		
		// Read image
		try {//relates to IO, force try catch for fear that the system will crash
		// Here set the path to your image
			img = ImageIO.read(new File("logo.png"));			
		} catch (IOException e) {}
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);

		// Sample
		g.setFont(new Font("Courier", 1, 20));
		
		
		// Draw Message
		g.drawString("x=" + x + ", y=" + y + ", (x*y) ="+ (x*y), 50, 50);
		
		// Draw Image
		//g.drawImage(img, 100, 100, 200, 200, this);
		for(int i=0;i<y;++i){
			for(int j=0 ; j<x ; ++j){
				g.drawImage(img, 100+50*j, 100+50*i, 50, 50, this);
			}
		}
	}
}

