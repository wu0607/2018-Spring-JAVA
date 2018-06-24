import java.awt.*;
import javax.swing.*;
import java.awt.Color;

public class SortFrame2 extends JFrame{
	int numbers[] = new int[100];
	
	public SortFrame2(){
		super("SortJFrame");
		for(int j=0 ; j<numbers.length ; ++j)
			numbers[j] = (int)(Math.random()*101);
		setSize(500,600);
		setVisible(true);		//automatically call paint()method
	}
	
	public void paint(Graphics g){
		int i,j;
		
		super.paint(g);
		g.setColor(Color.magenta);		
		
		for(j=0 ; j<numbers.length ; ++j)
			g.drawLine(10, 20+3*j, 10+numbers[j], 20+3*j);
		
		g.drawString("The original array", 10, 350);
		
		bubblesort();
		
		for(j=0 ; j<numbers.length ; ++j)
			g.drawLine(225, 20+3*j, 225+numbers[j], 20+3*j);
		
		g.drawString("The sorted array", 225, 350);
	}
	
	public void bubblesort(){
		int size = numbers.length;
		int x,y,temp;
		for(x=0 ; x<size-1 ; ++x){
			for(y=0 ; y<size-1-x ; ++y){
				if(numbers[y] > numbers[y+1]){
					temp = numbers[y];
					numbers[y] = numbers[y+1];
					numbers[y+1] = temp;
				}
			}
		}		
	}
	
	public static void main(String args[]){
		SortFrame2 f1 = new SortFrame2();
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}