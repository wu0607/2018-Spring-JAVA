import java.awt.Graphics;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*; //JApplet, JBotton, JTextField

public class p2 extends JApplet{
	private JLabel label1,label2;
	private JTextField textField;
	private int answer, guess_num;
	
	public void init(){
		this.setLayout(new FlowLayout());
		//this.setSize(300, 300);
		
		label1 = new JLabel("Guess a number between 1 and 1000", 10);
		this.add(label1);
		label2 = new JLabel("", 10);
		this.add(label2);
		textField = new JTextField("", 10);
		this.add(textField);
		
		ButtonHandler handler = new ButtonHandler();
		textField.addActionListener(handler);
		
		answer = (int)(Math.random()*1000);		
		
	}
	// public void paint(Graphics g){
		// super.paint(g);
	// }
	private class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent event){
			String textFieldValue = textField.getText();
			guess_num = Integer.parseInt(textFieldValue);
			
			if(guess_num > answer){
				label2.setText("Too high. Try again.");
				showStatus("Too high. Try again.");
			}else if(guess_num < answer){
				label2.setText("Too low. Try again.");
				showStatus("Too low. Try again.");
			}else{
				String output = String.format("Congratulaions! %d~", answer);
				showStatus("Good!");
				label2.setText(output);
			}
			textField.setText("");
		}
	}
	
}