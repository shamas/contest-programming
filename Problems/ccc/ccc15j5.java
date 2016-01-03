import java.util.Scanner;

public class ccc15j5 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		System.out.println(go(n, k, n - (k - 1)));
	}
	public static int go(int n, int k, int lim){
		if(n == k || k == 1) {
			return 1;
		}
		int way = 0;
		for(int cur = n / k; cur <= n - (k - 1) && cur <= lim; cur++) {
			way += go(n - lim, k - 1, cur);
		}
		return way;
	}
}
