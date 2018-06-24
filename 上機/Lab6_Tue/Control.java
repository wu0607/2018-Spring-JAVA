
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
import java.security.SecureRandom;


public class Control extends JFrame implements ActionListener, MouseListener, MouseMotionListener{
    
	JButton b[];
	JPanel p[][];
	JPanel s[];
	JPanel dragPanel;
	public static ImageIcon images[];
	SecureRandom sr;
	public int x,y,tx,ty;
	
	
	public Control(){
	    
		super("LAB6");
		sr = new SecureRandom();
		images = new ImageIcon[6];
		images[0] = new ImageIcon("images\\dark.png");
		images[1] = new ImageIcon("images\\light.png");
		images[2] = new ImageIcon("images\\wood.png");
		images[3] = new ImageIcon("images\\fire.png");
		images[4] = new ImageIcon("images\\water.png");
		images[5] = new ImageIcon("images\\heart.png");
		//Just an example...
		int i,j;
		b = new JButton[2];
		s = new JPanel[2];
		// p = new JPanel[3][3];
		
		// GridLayout grid = new GridLayout(3,3,2,2);
         
		// s[0] = new JPanel();
		// s[0].setLayout(grid);
        // for (i=0;i<3; i++){
			// for (j=0;j<3; j++){
			 // p[i][j] = new JPanel();
			 // p[i][j].setLayout(new BorderLayout());
			 // p[i][j].add(new JLabel(images[sr.nextInt(3)]),BorderLayout.CENTER);
			 // s[0].add(p[i][j]);
			// }
		// }
		p = new JPanel[6][6];
		
		GridLayout grid = new GridLayout(6,6,2,2);
         
		s[0] = new JPanel();
		s[0].setLayout(grid);
        for (i=0;i<6; i++){
			for (j=0;j<6; j++){
			 p[i][j] = new JPanel();
			 p[i][j].setLayout(new BorderLayout());
			 p[i][j].add(new JLabel(images[sr.nextInt(6)]),BorderLayout.CENTER);
			 s[0].add(p[i][j]);
			}
		}
		
		s[1] = new JPanel();
		s[1].setLayout(new GridLayout(1, 2));
		b[0] = new JButton("left shift");
		b[0].addActionListener(this);
		b[1] = new JButton("random");
		b[1].addActionListener(this);
		s[1].add(b[0]);
		s[1].add(b[1]);
		
		dragPanel = new JPanel();
		// dragPanel.setLayout(new BorderLayout());
		// dragPanel.add(s[0], BorderLayout.CENTER);
		// dragPanel.add(s[1], BorderLayout.SOUTH);
		Container container = this.getContentPane();
		container.add(s[0], BorderLayout.CENTER);
		container.add(s[1], BorderLayout.SOUTH);
		
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	
	//MouseListener
	public void mousePressed(MouseEvent event){
		//Point sp = event.getPoint();
		//how to find the panel where the mouse is??
		//p[x][y] ... x = ??, y = ??
		//dragPanel = ??
	}
	public void mouseReleased(MouseEvent event){}
    public void mouseClicked(MouseEvent event){}
    public void mouseEntered(MouseEvent event){}
    public void mouseExited(MouseEvent event){}
	
	//MouseMotionListener
	public void mouseMoved( MouseEvent event ){}
	public void mouseDragged( MouseEvent event ){
		//find panel again...
		//p[tx][ty] ... tx = ??, ty = ??
		//switch dragPanel to current panel
		//p[tx][ty] = dragPanel;
		//p[x][y] = currentPanel;
		
		//remove all panel in p
		//update x and y
	
	}
    

	public void actionPerformed(ActionEvent e){
		//e.getSource() == ??
		if(e.getSource() == b[0]){
			System.out.print("b0");
		}else if(e.getSource() == b[1]){
			
		}
	}

}