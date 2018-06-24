import java.util.Scanner;

public class hw3{
	public static double F(double x, int[] a, int[] b, int[] c, int n){
		double ans = a[0]*x*x+b[0]*x+c[0];
		for(int i = 1; i < n; i++){
			ans = Math.max(ans, a[i]*x*x+b[i]*x+c[i]);
		}
		return ans;	
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int T, n, count=0;
		int[]a, b, c;
		double[] output; 
		
		System.out.print("Please type your input:\n");
		T = input.nextInt();
		a = new int[T];
		b = new int[T];
		c = new int[T];
		output = new double[T];
		
		while(count<T){
			n = input.nextInt();
			for(int i=0 ; i<n; i++){
				a[i] = input.nextInt();
				b[i] = input.nextInt();
				c[i] = input.nextInt();				
			}
			double L=0.0, R=1000.0;
			for(int i=0; i<100; i++){
				double m1 = L+(R-L)/3;
				double m2 = R-(R-L)/3;
				if(F(m1,a,b,c,n)<F(m2,a,b,c,n)){
					R = m2;
				}else{
					L = m1;
				}
			}
			output[count] = F(L,a,b,c,n);
						
			++count;		
		}	
		System.out.printf("Output:\n");
		for(int i=0 ; i<T ; ++i){
			System.out.printf("The Max is %.4f\n", output[i]);			
		}
	}
}