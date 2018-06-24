
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
	JPanel center;
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
		b = new JButton[4];
		
		p = new JPanel[6][6];
		
		GridLayout grid = new GridLayout(6,6,2,2);
         
		center = new JPanel();
		center.setLayout(grid);
        for (i=0;i<6; i++){
			for (j=0;j<6; j++){
				p[i][j] = new JPanel();
				p[i][j].setLayout(new BorderLayout());
				p[i][j].add(new JLabel(images[sr.nextInt(6)]),BorderLayout.CENTER);
				center.add(p[i][j]);
				
			}
		}
		
		
		b[0] = new JButton("shift up");
		b[0].addActionListener(this);
		b[1] = new JButton("shift down");
		b[1].addActionListener(this);
		b[2] = new JButton("shift left");
		b[2].addActionListener(this);
		b[3] = new JButton("shift right");
		b[3].addActionListener(this);
		
		
		
		
		//dragPanel = new JPanel();
		
		Container container = this.getContentPane();
		container.add(center, BorderLayout.CENTER);
		container.add(b[0], BorderLayout.NORTH);
		container.add(b[1], BorderLayout.SOUTH);
		container.add(b[2], BorderLayout.WEST);
		container.add(b[3], BorderLayout.EAST);
		
		
		center.addMouseListener(this);
		center.addMouseMotionListener(this);
	}
	
	//MouseListener
	public void mousePressed(MouseEvent event){
		Point sp = event.getPoint();
		System.out.print("  x:"+ sp.getX()+ ", y:"+ sp.getY());
		x = (int)event.getX();
		y = (int)event.getY();
		
		//how to find the panel where the mouse is??
		//p[x][y] ... x = ??, y = ??
		dragPanel = p[x/52][y/52];
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
		tx = (int)event.getX();
		ty = (int)event.getY();

		JPanel current;
		current = p[ty/52][tx/52];
		p[ty/52][tx/52] = p[y/52][x/52];;
		p[y/52][x/52] = current;
		//p[x][y] = currentPanel;
		
		//remove all panel in p
		//update x and y
		x = tx;
		y = ty;
		
		center.removeAll();
		for(int i=0 ; i<6 ; i++){
			for(int j=0 ; j<6 ; j++){
				center.add(p[i][j]);
			}
		}
		
		this.revalidate();
		this.repaint();
	
	}
    

	public void actionPerformed(ActionEvent e){
		
		center.removeAll();
		if(e.getSource() == b[0]){//up
			JPanel temp[];
			temp = new JPanel[6];
			for (int i=0;i<6; i++){
				temp[i] = p[0][i];
			}
			for(int i=0 ; i<6 ; i++){
				for(int j=0 ; j<6 ; j++){
					if(i == 5){
						p[i][j] = temp[j];
						//center_new.add(p_new[i][j]);
					}else{
						p[i][j] = p[i+1][j];
						//center_new.add(p_new[i][j]);
					}
				}
			}
			
		
				
		}else if(e.getSource() == b[1]){//down
			JPanel temp[];
			temp = new JPanel[6];
			for (int i=0;i<6; i++){
				temp[i] = p[5][i];
			}
			for(int i=5 ; i>=0 ; i--){
				for(int j=0 ; j<6 ; j++){
					if(i == 0){
						p[i][j] = temp[j];
						//center_new.add(p_new[i][j]);
					}else{
						p[i][j] = p[i-1][j];
						//center_new.add(p_new[i][j]);
					}
				}
			}
		}else if(e.getSource() == b[2]){//left
			JPanel temp[];
			temp = new JPanel[6];
			for (int i=0;i<6; i++){
				temp[i] = p[i][0];
			}
			for(int i=0 ; i<6 ; i++){
				for(int j=0 ; j<6 ; j++){
					if(j == 5){
						p[i][j] = temp[i];
						//center_new.add(p_new[i][j]);
					}else{
						p[i][j] = p[i][j+1];
						//center_new.add(p_new[i][j]);
					}
				}
			}
		}else if(e.getSource() == b[3]){//right
			JPanel temp[];
			temp = new JPanel[6];
			for (int i=0;i<6; i++){
				temp[i] = p[i][5];
			}
			for(int i=0 ; i<6 ; i++){
				for(int j=5 ; j>=0 ; j--){
					if(j == 0){
						p[i][j] = temp[i];
						//center_new.add(p_new[i][j]);
					}else{
						p[i][j] = p[i][j-1];
						//center_new.add(p_new[i][j]);
					}
				}
			}
		}
		
		for(int i=0 ; i<6 ; i++){
			for(int j=0 ; j<6 ; j++){
				center.add(p[i][j]);
			}
		}
		
		this.revalidate();
		this.repaint();
	}

}