import java.util.Scanner;
import java.math.*;

public class p3_2{
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Type your n (n should be >= 45):");
		System.out.print("n = ");
		int n = input.nextInt();
		BigInteger factorial = new BigInteger("1");
		
		for(int i=1 ; i<=n ; ++i){
			BigInteger m = new BigInteger(Integer.toString(i));
			factorial = factorial.multiply(m);
	
		}
		
		System.out.println(factorial);
	}
}