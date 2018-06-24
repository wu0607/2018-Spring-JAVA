import java.awt.*;
import javax.swing.*;
import java.awt.Color;

public class SortPanel extends JPanel{
	int numbers[] = new int[100];
	
	public void paintComponent(Graphics g){
		int i,j;
		
		super.paintComponent(g);
		g.setColor(Color.magenta);
		
		for(j=0 ; j<numbers.length ; ++j)
			numbers[j] = (int)(Math.random()*101);
		
		for(j=0 ; j<numbers.length ; ++j)
			g.drawLine(10, 20+3*j, 10+numbers[j], 20+3*j);
		
		g.drawString("The original array", 10, 350);
		System.out.println("Original");
		bubblesort();
		
		for(j=0 ; j<numbers.length ; ++j)
			g.drawLine(225, 20+3*j, 225+numbers[j], 20+3*j);
		
		g.drawString("The sorted array", 225, 350);
		System.out.println(" After sort");
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
	
	
	
}