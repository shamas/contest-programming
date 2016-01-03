import java.util.Scanner;

public class TechHw {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			int base = 2;
			String[] l = scanner.nextLine().split("=");
			int n = Integer.parseInt(l[0].trim());
			int a = n;
			System.out.println(n + " =");
			while(true) {
				int rem = n % base;
				n = n / base;
				System.out.printf("%10d | %d\n", n, rem);
				if(n == 0) {
					break;
				}
			}
			System.out.println(Integer.toString(a, base) + "\n");
		}
	}
}
