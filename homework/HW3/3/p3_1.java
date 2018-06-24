import java.math.*;
import java.util.*;

public class p3_1{
	public static String getRandomBigDecimal() {
		String rand = new String();
		for(int i=0 ; i<15 ; ++i){
			rand += Integer.toString(( int)(Math.random()*10.0) );
		}
		rand += ".";
		for(int i=0 ; i<15 ; ++i){
			rand += Integer.toString(( int)(Math.random()*10.0) );
		}
		return rand;
	}

	public static void main(String[] argcs){
		BigDecimal d1 = new BigDecimal(getRandomBigDecimal());
		BigDecimal d2 = new BigDecimal(getRandomBigDecimal());
		
		System.out.println("Start create Bignumber randomly ...");
		System.out.println("num_1   : " + d1);
		System.out.println("num_2   : " + d2);
		
		BigDecimal add_result = d1.add(d2);
		BigDecimal sub_result = d1.subtract(d2);
		BigDecimal mul_result = d1.multiply(d2);
		BigDecimal div_result = d1.divide(d2, 30, BigDecimal.ROUND_HALF_UP);
		System.out.println("add     : " + add_result );
		System.out.println("subtract: " + sub_result );
		System.out.println("multiply: " + mul_result );
		System.out.println("divide  : " + div_result );				
	
	}
}