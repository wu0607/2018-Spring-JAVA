import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class MyPanel extends JPanel implements MouseListener, MouseMotionListener{
	
	int x, y, px, py;
	boolean canPaint;
	float penWidth = 4.0f;
	Color penColor;
	
	//myself
	boolean increase, decrease;
	// Advanced
	boolean isButton1Pressed;
	boolean canPaintRect;
	int count;
	int rectX, rectY, rectWidth, rectHeight;
	int dx, dy;

	public MyPanel()
	{
		// ... add...
		addMouseListener(this);
		addMouseMotionListener(this);
		// Advanced
		isButton1Pressed = false;
		count = 0;
	}
	
	//MouseListener
	//mousePressed
	public void mousePressed(MouseEvent event){
		//System.out.println("press");
	}
	//mouseReleased
	public void mouseReleased(MouseEvent event){
		isButton1Pressed = false;
		//System.out.println("release");
	}
    // mouseClicked
	public void mouseClicked(MouseEvent event)
    {
    	//System.out.println("click");
		int cx, cy;
    	// get x, y from event and save into cx, cy
		cx = event.getX();
		cy = event.getY();
		
    	if (event.getButton() == MouseEvent.BUTTON1)
    	{
    		// reset		
			if(20<=cy && cy<=40 && 20<=cx && cx<=40){// BLACK (20, 20)
				penColor = Color.BLACK;
				System.out.println("black");				
			}else if(20<=cy && cy<=40 && 60<=cx && cx<=80){// RED (60, 20)
				//penColor = Color.RED;
				canPaint = false;
				increase = true;
				repaint();
				System.out.println("red");
			}else if(20<=cy && cy<=40 && 100<=cx && cx<=120){// BLUE (100, 20)
				//penColor = Color.BLUE;
				canPaint = false;
				decrease = true;
				repaint();
				System.out.println("blue");
			}
			else if(20<=cy && cy<=40 && 140<=cx && cx<=160){// Eraser (140, 20)
				penColor = this.getBackground();
				System.out.println("eraser");
	    	}
	    }
		// Advance
		if(event.getButton() == MouseEvent.BUTTON3){
			if(count == 0){
				System.out.println("0");
				x = event.getX();//original coordinate first click
				y = event.getY();
				count = 1;
			}else if(count == 1){
				System.out.println("1");
				px = event.getX();//second click
				py = event.getY();
				count = 2;
				calculateCoord();
				dx = 0;
				dy = 0;
				canPaintRect = true;
				repaint();
				count = 0;
			}
			else if(count == 2){
				System.out.println("2");
				
				//dx = event.getX() - rectX;
				//dy = event.getY() - rectY;//rectY - y;
				
				count = 0;
			}
			
		}
		
    	
    }
	
	//MouseMotionListener
	//mouseDragged
	public void mouseDragged( MouseEvent event ){
		//System.out.println("Drag");
		if(isButton1Pressed == false){
			x = event.getX();
			y = event.getY();
			px = event.getX();
			py = event.getY();
			isButton1Pressed = true;
		}
		if(isButton1Pressed)
		{
			x = px;
			y = py;
			px = event.getX();
			py = event.getY();

			canPaint = true;
			// force to repaint this panel
			repaint();		
		}
	}
	public void mouseMoved( MouseEvent event ){}
	public void mouseEntered(MouseEvent event){}
	public void mouseExited(MouseEvent event){}
    // Advanced
    public void calculateCoord()
    {
    	rectWidth = (int)Math.abs(x - px);
    	rectHeight = (int)Math.abs(y - py);
    	rectX = px < x ? px : x;
    	rectY = py < y ? py : y;
    }

    public void paintComponent(Graphics g)
    {
		//super.paintComponent(g);

		// draw option buttons
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		g2.fillRect(20, 20, 20, 20);
		g2.drawRect(60, 20, 20, 20);
		g2.fillOval(60, 20, 20, 20);
		g2.drawRect(100, 20, 20, 20);
		g2.drawOval(100, 20, 20, 20);
		g2.drawRect(140, 20, 20, 20);

		g2.setColor(penColor);
		if(increase == true && penWidth<24.0f){
			penWidth += 4.0f;
			System.out.println("increase to "+penWidth);			
			increase = false;
		}
		if(decrease == true && penWidth>4.0f){
			penWidth -= 4.0f;
			System.out.println("decrease to "+penWidth);			
			decrease = false;
		}
		// if(penColor == this.getBackground()){
			// g2.setStroke(new BasicStroke(4.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		// }
		g2.setStroke(new BasicStroke(penWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));	
		
		if(canPaint == true && canPaintRect!=true){			
			g2.drawLine(x, y, px, py);		
		}
		if(canPaintRect == true){
			System.out.println("COPY!");
			//System.out.println(rectX+" "+rectY+" "+rectWidth+" "+rectHeight+" "+dx+" "+dy);
			
			g2.setXORMode(Color.WHITE);
			g2.fillRect(rectX, rectY, rectWidth, rectHeight);
			
			//g2.copyArea(rectX, rectY, rectWidth, rectHeight, dx, dy);
			
			
			canPaintRect = false;
			count = 0;			
		}
	}	
		

}