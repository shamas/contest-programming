import java.util.*;

public class FlappyPlane {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int base = 20;
		while(true) {
			long n = scanner.nextLong();
			long b = n;
			while(n > 0) {
				long a = n % base;
				n /= base;
				System.out.printf("%10d|%d\n", n, a);
			}
			System.out.println(Long.toString(b, base));
		}
	}
}
