import javax.swing.JOptionPane;

public class hw1_1{
	public static void main(String args[]){
		int x, y, z;
		int sum, pro, smallest, largest;
		double avg;
		String xVal, yVal, zVal;
		
		xVal = JOptionPane.showInputDialog("Enter first int:");
		yVal = JOptionPane.showInputDialog("Enter second int:");
		zVal = JOptionPane.showInputDialog("Enter third int:");
	
		x = Integer.parseInt(xVal);
		y = Integer.parseInt(yVal);
		z = Integer.parseInt(zVal);
		
		sum = x + y + z;
		smallest = x;
		if(y < x){
			smallest = y;
		}
		if(z < x && z < y){
			smallest = z;
		}
		largest = x;
		if(y > x){
			largest = y;
		}
		if(z > x && z > y){
			largest = z;
		}
		avg = (x+y+z) / 3.0;
		pro = x*y*z;
		
		JOptionPane.showMessageDialog(null, "The sum is " + sum);
		JOptionPane.showMessageDialog(null, "The average is " + avg);
		JOptionPane.showMessageDialog(null, "The product is " + pro);
		JOptionPane.showMessageDialog(null, "The smallest is " + smallest);
		JOptionPane.showMessageDialog(null, "The largest is " + largest);
	}
}