import javax.swing.JOptionPane;

public class hw4{
	public static void main(String args[]){
		String whole;
		
		whole = JOptionPane.showInputDialog("Type your input file name:");
		String[] parts = whole.split("\\.");
		if(parts.length>1){
			String part1 = parts[0];
			String part2 = parts[1];
		
			JOptionPane.showMessageDialog(null, "Your file extension is "+part2);
		}else{
			JOptionPane.showMessageDialog(null, "Wrong input format.");
		}
	}
}