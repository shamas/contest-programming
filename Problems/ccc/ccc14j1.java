import java.util.Scanner;


public class ccc14j1 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		if(a + b + c != 180 || a + b <= c | a - b >= c){
			System.out.println("Error");
		}
		else if(a == 60 && b == 60){
			System.out.println("Equilateral");
		}
		else if(a == b || b == c || c == a){
			System.out.println("Isosceles");
		}
		else{
			System.out.println("Scalene");
		}
	}
}
