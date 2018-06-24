import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.util.*;

public class Demo2_4
{
    
	public static void main(String args[ ])
    {	
    	int number;
    	Scanner input = new Scanner(System.in);
	  	do
		{
	 		System.out.print("Please Input the number to select the shape (0,1): ");
	 		number = input.nextInt();
	 	} while (number > 1);	
		
		//new JFrame and JPanel	
		JFrame w = new JFrame();
		Demo2_4_panel p1 = new Demo2_4_panel(w, number);		
		Demo2_4_panel p2 = new Demo2_4_panel(w, number);
		JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p1, p2);
		split.setResizeWeight(0.5);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		w.add(split);
		w.setSize(500, 600);
		w.setVisible(true);
		
		
		
		
		
	}	
}
