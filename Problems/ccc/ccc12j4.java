import java.util.Scanner;

public class ccc12j4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int s = scanner.nextInt();
		scanner.nextLine();
		String str = scanner.nextLine();
		for(int i = 0; i < str.length(); ++i) {
			char c = str.charAt(i);
			System.out.print((char)((((((c - 'A') - s - 3 * (i + 1)) % 26) + 26) % 26) + 'A'));
		}
	}
}
