import javax.swing.JOptionPane;

public class hw3{
	public static void main(String args[]){
		int input, charge, quarter, dime, nickle, penny;
		String inVal;
		
		inVal = JOptionPane.showInputDialog("Enter price of item:\n(from 25 cents to one dollar, in 5-cent increments):");
		input = Integer.parseInt(inVal);
		
		charge = 100 - input;
		quarter = charge / 25;
		charge -= quarter * 25;
		dime = charge / 10;
		charge -= dime * 10;
		nickle = charge / 5;
		charge -= nickle * 5;
		penny = charge;
		
		JOptionPane.showMessageDialog(null, "You bought an item for " + input + " cents and gave me one dollar.\nSo your change is\n"+quarter + " quarters,\n"+dime + " dime\n"+nickle + " nickle, and\n"+penny + " penny");
		
		System.out.println("You bought an item for " + input + " cents and gave me one dollar.");
		System.out.println("So your change is");
		System.out.println(quarter + " quarters,");
		System.out.println(dime + " dime");
		System.out.println(nickle + " nickle, and");
		System.out.println(penny + " penny");
		
	}
}