import java.text.DecimalFormat;
import java.util.Scanner;


public class ccc05j1 {
	public static DecimalFormat format = new DecimalFormat("0.00");
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int daytime = scanner.nextInt();
		int evening = scanner.nextInt();
		int weekend = scanner.nextInt();
		int costA = 0;
		int costB = 0;
		if(daytime > 100){
			costA += (daytime - 100) * 25;
		}
		if(daytime > 250){
			costB += (daytime - 250) * 45;
		}
		costA += 15 * evening;
		costB += 35 * evening;
		costA += 20 * weekend;
		costB += 25 * weekend;
		System.out.println("Plan A costs " + format.format(costA / 100.0));
		System.out.println("Plan B costs " + format.format(costB / 100.0));
		if(costA < costB){
			System.out.println("Plan A is cheapest.");
		}
		else if(costA == costB){
			System.out.println("Plan A and B are the same price.");
		}
		else{
			System.out.println("Plan B is cheapest.");
		}
	}
}
