import java.util.Scanner;

public class ccc09s5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[][] bits = new int[m][n + 1];
		for(int i = 0; i < k; ++i) {
			int y = scanner.nextInt() - 1;
			int x = scanner.nextInt() - 1;
			int r = scanner.nextInt();
			int b = scanner.nextInt();
			for(int j = -r; j <= r; ++j) {
				int loc = j + x;
				if(loc < 0 || loc >= m) {
					continue;
				}
				double val = Math.sqrt(r * r - j * j);
				int min = (int)Math.ceil(y - val);
				int max = (int)Math.floor(y + val);
				if(max >= n) {
					max = n - 1;
				}
				if(min <= 0) {
					min = 0;
				}
				bits[loc][min] += b;
				bits[loc][max + 1] -= b;
			}
		}
		int maxBit = Integer.MIN_VALUE;
		int nShops = 0;
		for(int i = 0; i < m; ++i) {
			int curr = 0;
			for(int j = 0; j <= n; ++j) {
				curr += bits[i][j];
				if(curr > maxBit) {
					maxBit = curr;
					nShops = 1;
				}
				else if(curr == maxBit) {
					nShops ++;
				}
			}
		}
		System.out.println(maxBit);
		System.out.println(nShops);
	}
}
