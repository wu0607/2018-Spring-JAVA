
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// import ...
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

public class MyPanel extends JPanel implements KeyListener {

	private int x, y, xx, yy, dir;	//dir = up.down.left.right
	private int sec, count=0, index=0;
	private Image[] images;
	private Timer timer;
	boolean change = false;

	public MyPanel() {
		this.setBackground(Color.BLACK);
		// add KeyListener
		this.addKeyListener(this);
		
		// init variables
		x = 50;
		y = 50;
		xx =  (int)(Math.random()*500);
		yy =  (int)(Math.random()*500);
		
		// read images
		images = new Image[3];
		for(int i=0 ; i<=2 ; ++i){
			images[i] = (new ImageIcon("images/" + i + ".png")).getImage();		
		}
		// set timer
		timer = new Timer();
		int sleep_time = 100;	//update every 0.1s
		timer.schedule(new TimerTask() {
			
			public void run() {
			// code...
				sec += sleep_time;
				repaint();
			}
			
		}, 0, sleep_time);
		
	}

	public void keyPressed(KeyEvent e) {
		// key pressed
		if(e.getKeyChar() == 'w' || e.getKeyCode() == e.VK_UP){
			dir = 0;
		}else if(e.getKeyChar() == 's' || e.getKeyCode() == e.VK_DOWN){
			dir = 1;
		}else if(e.getKeyChar() == 'a' || e.getKeyCode() == e.VK_LEFT){
			dir = 2;
		}else if(e.getKeyChar() == 'd' || e.getKeyCode() == e.VK_RIGHT){
			dir = 3;
		}
		
	}

	public void keyTyped(KeyEvent e) { }
	public void keyReleased(KeyEvent e) { }

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		
		if(dir == 0 && y!=0){
			y -= 50;
		}else if(dir == 1 && y!=400){
			y += 50;
		}else if(dir == 2 && x!=0){
			x -= 50;
		}else if(dir == 3 && x!=400){
			x += 50;
		}
		// draw 
		
		if(xx>x && xx<x+100 && yy>y && yy<y+100){
			count ++;
			xx =  (int)(Math.random()*400)+20;
			yy =  (int)(Math.random()*400)+20;
		}
		
		if(sec % 3000 == 0){
			index = (index+1)%3;
		}
		
		g.setFont(new Font("Ariel", Font.PLAIN, 30));
		g.setColor(Color.RED);
		g.fillOval(xx,yy,20,20);
		g.drawString("["+(String.valueOf(sec/1000))+"."+(String.valueOf((sec/100)%10))+"]", 15,30);
		g.drawString("["+(String.valueOf(count))+"]", 120,30);
		g.drawImage(images[index], x, y, 100, 100, this);
	
	}

}


