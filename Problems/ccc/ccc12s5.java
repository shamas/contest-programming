import java.util.Arrays;
import java.util.Scanner;

public class ccc12s5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int r = scanner.nextInt();
		int c = scanner.nextInt();
		boolean[][] cats = new boolean[r + 1][c + 1];
		int[][] count = new int[r + 1][c + 1];
		int n = scanner.nextInt();
		for(int i = 0; i < n; ++i) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			cats[x][y] = true;
		}
		for(int i = 1; i <= r; ++i) {
			for(int j = 1; j <= c; ++j) {
				if(i == 1 && j == 1) {
					count[1][1] = 1;
				}
				else if(!cats[i][j]) {
					count[i][j] = count[i - 1][j] + count[i][j - 1];
				}
			}
		}
		System.out.println(count[r][c]);
	}
}
