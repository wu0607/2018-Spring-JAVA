import javax.swing.*;

// public class DrawSortTest{
	// public static void main(String args[]){		
		// SortPanel p = new SortPanel();
		// JFrame w = new JFrame();
		// w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// w.add(p);
		// w.setSize(500,600);
		// w.setVisible(true);		
	// }
// }
public class DrawSortTest extends JApplet{
	public void init(){
		SortPanel p = new SortPanel();
		add(p);
		setSize(500,600);
	}
}