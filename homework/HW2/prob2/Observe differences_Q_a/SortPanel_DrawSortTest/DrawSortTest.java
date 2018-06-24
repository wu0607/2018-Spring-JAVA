import javax.swing.JFrame;

public class DrawSortTest{
	public static void main(String args[]){		
		SortPanel p = new SortPanel();
		JFrame w = new JFrame();
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.add(p);
		w.setSize(500,600);
		w.setVisible(true);		
	}
}