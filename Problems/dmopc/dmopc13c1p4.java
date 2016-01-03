import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Scanner;

public class dmopc13c1p4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		a:
		for(int i = 0; i < n; ++i) {
			int c = scanner.nextInt();
			int r = scanner.nextInt();
			int sr = 0;
			int sc = 0;
			int er = 0;
			int ec = 0;
			boolean[][] pass = new boolean[r][c];
			boolean[][] visited = new boolean[r][c];
			for(int j = 0; j < r; ++j) {
				String s = scanner.next();
				for(int k = 0; k < c; ++k) {
					switch(s.charAt(k)) {
					case 'O':
						pass[j][k] = true;
						break;
					case 'C':
						pass[j][k] = true;
						sr = j;
						sc = k;
						break;
					case 'W':
						pass[j][k] = true;
						er = j;
						ec = k;
						break;
					}
				}
			}
			ArrayDeque<Point> deque = new ArrayDeque<Point>();
			deque.push(new Point(sr, sc, 0));
			while(!deque.isEmpty()) {
				Point p = deque.removeFirst();
				int rr = p.x;
				int cc = p.y;
				int count = p.step;
				if(rr < 0 || rr >= r || cc < 0 || cc >= c || !pass[rr][cc]) {
					continue;
				}
				if(count >= 60) {
					System.out.println("#notworth");
					continue a;
				}
				if(rr == er && cc == ec) {
					System.out.println(count);
					continue a;
				}
				if(visited[rr][cc]) {
					continue;
				}
				visited[rr][cc] = true;
				deque.addLast(new Point(rr - 1, cc, count + 1));
				deque.addLast(new Point(rr + 1, cc, count + 1));
				deque.addLast(new Point(rr, cc - 1, count + 1));
				deque.addLast(new Point(rr, cc + 1, count + 1));
			}
			System.out.println("#notworth");
		}
	}
	public static class Point {
		public int x;
		public int y;
		public int step;
		public Point(int x, int y, int step) {
			this.x = x;
			this.y = y;
			this.step = step;
		}
	}
}
