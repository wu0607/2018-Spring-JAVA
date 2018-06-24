import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*; //JFrame, JBotton, JTextField

public class Case extends JFrame{
	private final JButton upperButton, lowerButton;
	private JTextField textfield;
	private String output;
	
	public Case(){
		super("Casing.");
		setLayout(new FlowLayout());
		
		textfield = new JTextField(20);
		add(textfield);
		upperButton = new JButton("uppercase");
		add(upperButton);
		lowerButton = new JButton("lowercase");
		add(lowerButton);
		
		ButtonHandler_up handler_up = new ButtonHandler_up();
		upperButton.addActionListener(handler_up);
		ButtonHandler_down handler_down = new ButtonHandler_down();
		lowerButton.addActionListener(handler_down);	
	}
	private class ButtonHandler_up implements ActionListener{
		public void actionPerformed(ActionEvent event){
			output = textfield.getText();
			output = output.toUpperCase();
			textfield.setText(output);
		}
	}
	private class ButtonHandler_down implements ActionListener{
		public void actionPerformed(ActionEvent event){
			output = textfield.getText();
			output = output.toLowerCase();
			textfield.setText(output);
		}
	}
	public static void main(String[] args){
		Case caseFrame = new Case();
		caseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		caseFrame.setSize(300, 120);
		caseFrame.setVisible(true);	
	}
}