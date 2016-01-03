import java.util.Scanner;


public class dmopcSandTriangle {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextInt();
		long a = (long)Math.ceil((-1 + Math.sqrt(1.0 + 8.0 * n)) / 2);
		System.out.println(a);
		long min = (a - 1) * a / 2 + 1;
		long max = (a + 1) * a / 2;
		System.out.println((min + max) * (max - min + 1) / 2);
	}
}
