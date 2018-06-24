import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.* ;
import javax.swing.event.*;

public class MyFrame extends JFrame implements ActionListener
{
		private JFrame frame;
		private JButton enter;
		private JTextField inputBox;
		private int degree;
		private DrawPanel panel;
		
		public MyFrame()
		{
			//
			super("MyFrame.");
			setLayout(new FlowLayout());
			
			enter = new JButton("enter");
			enter.addActionListener(this);
			this.add(enter);
			
			inputBox = new JTextField("", 10);
			inputBox.addActionListener(this);
			this.add(inputBox);
		}

		public void actionPerformed(ActionEvent e)
		{
			//
			if(e.getSource() == enter){
				degree = Integer.parseInt(inputBox.getText());
				JFrame frame = new JFrame();
				DrawPanel panel = new DrawPanel(degree, frame);
				frame.add(panel);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(300, 300);
				frame.setVisible(true);	
	
			}
			
			
		}
}

