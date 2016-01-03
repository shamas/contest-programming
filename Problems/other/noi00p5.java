import java.util.Scanner;

public class noi00p5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		System.out.println((int)(Math.pow(2, n) * (m + 1)));
	}
}
