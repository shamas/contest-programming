import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class dmopc15c1p5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Point> arrays = new ArrayList<Point>();
		int w = scanner.nextInt();
		int h = scanner.nextInt();
		int a = scanner.nextInt();
		for(int i = 1; i <= w; ++i) {
			Point p = new Point(i, a / i);
			if(p.y > h) {
				p.y = h;
			}
			if(!arrays.contains(p)){
				arrays.add(p);
			}
		}
		int[][] array = new int[w + 1][h + 1];
		int[][] sum = new int[w + 1][h + 1];
		for(int j = 0; j < h; ++j) {
			for(int i = 0; i < w; ++i) {
				array[i + 1][j + 1] = scanner.nextInt();
			}
		}
		for(int i = 1; i <= w; ++i) {
			for(int j = 1; j <= h; ++j) {
				sum[i][j] = array[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
			}
		}
		int max = Integer.MIN_VALUE;
		for(int b = 0; b < arrays.size(); ++b) {
			Point p = arrays.get(b);
			int x = p.x;
			int y = p.y;
			for(int i = 0; i <= w - x; ++i) {
				for(int j = 0; j <= h - y; ++j) {
					int r1 = i + 1;
					int c1 = j + 1;
					int r2 = i + x;
					int c2 = j + y;
					int s = sum[r2][c2] - sum[r1 - 1][c2] - sum[r2][c1 - 1] + sum[r1 - 1][c1 - 1];
					if(s > max) {
						max = s;
					}
				}
			}
		}
		System.out.println(max);
	}
}
