import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*; //JFrame, JBotton, JTextField

public class coin_toss extends JFrame{
	private final JButton tossButton;
	private JTextField textField;
	private int num_head=0, num_tail=0;
	
	public coin_toss(){
		super("Testing Button.");
		setLayout(new FlowLayout());
		
		tossButton = new JButton("toss");//button with text
		textField = new JTextField("heads:0 tails:0", 10);
		add(tossButton);//add tossButton to JFrame
		add(textField);
		
		//create new ButtonHandler for button event handling
		ButtonHandler handler = new ButtonHandler();
		tossButton.addActionListener(handler);			
	}
	public static boolean flip(){
		if(Math.random() < 0.5){
			return false;
		}else{
			return true;
		}
	}
	//inner class for button event handling
	private class ButtonHandler implements ActionListener{
		//handle button event
		public void actionPerformed(ActionEvent event){
			if(flip() == true){
				num_head += 1;
			}else{
				num_tail += 1;
			}
			String output = String.format("heads: %d tails: %d", num_head, num_tail );
			textField.setText(output);
		}
	}
	public static void main(String[]args){
		coin_toss tossFrame = new coin_toss();
		tossFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tossFrame.setSize(50, 200);
		tossFrame.setVisible(true);
	}
	
}