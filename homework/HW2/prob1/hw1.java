import java.util.Scanner;

public class hw1{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int radius;
		double diameter, circum, area;
		
		System.out.print("Please enter radius(integer):");
		radius = input.nextInt();
		
		diameter = radius * 2.0;
		circum = 2 * Math.PI * radius;
		area = radius*radius * Math.PI;
		
		String message = String.format("diameter:%.2f circum:%.2f area:%.2f", diameter, circum, area);
		System.out.printf("Diameter:%.2f,  Circumference:%.2f,  Area:%.2f", diameter, circum, area);
		
	}
}