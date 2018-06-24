import java.util.*;
import java.math.BigDecimal;

public class p2{
	public static class point{
		double x, y;
		public point(double x, double y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		double min_dis=100000;
		point p1 = new point(0, 0); 
		point p2 = new point(0, 0); 
		
		System.out.println("Start enter your points:");
		
		List<point> list = new ArrayList<point>();
		while(input.hasNext()){			//change line and type ^Z will break
			double x = input.nextDouble();
			double y = input.nextDouble();
			point in = new point(x, y);
			list.add(in);
		}
		int num_points = list.size();
		System.out.println(num_points);
		
		for(int i=0 ; i<num_points-1 ; ++i){
			for(int j=i+1 ; j<num_points ; ++j){
				double curr_dis = Math.pow((list.get(i).x - list.get(j).x), 2) + Math.pow((list.get(i).y - list.get(j).y), 2);
				curr_dis = Math.pow(curr_dis, 0.5);
				if(curr_dis < min_dis){
					min_dis = curr_dis;
					p1.x = list.get(i).x; p1.y = list.get(i).y;
					p2.x = list.get(j).x; p2.y = list.get(j).y;
				}
			}
		}
		
		System.out.println("min_dis: " + min_dis);
		System.out.println("p1: " + p1.x +" "+ p1.y + "  p2: " + p2.x +" "+ p2.y);
		//Strip zero digit. Make output prettier.
		System.out.print("The points (");
		System.out.print(new BigDecimal(p1.x).setScale(3, BigDecimal.ROUND_HALF_UP).stripTrailingZeros());
		System.out.print(", "+new BigDecimal(p1.y).setScale(3, BigDecimal.ROUND_HALF_UP).stripTrailingZeros());
		System.out.print(") and ("+new BigDecimal(p2.x).setScale(3, BigDecimal.ROUND_HALF_UP).stripTrailingZeros());
		System.out.print(", "+new BigDecimal(p2.y).setScale(3, BigDecimal.ROUND_HALF_UP).stripTrailingZeros());
		System.out.println(") are closest to each other.");
		
	}
}