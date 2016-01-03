import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class dmopc13c3p3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int h = scanner.nextInt();
		int[][] elevation = new int[n][n];
		boolean[][] visited = new boolean[n][n];
		for(int i = 0; i < n; ++i) {	
			for(int j = 0; j < n; ++j) {	
				elevation[i][j] = scanner.nextInt();
			}
		}
		ArrayDeque<Point> deque = new ArrayDeque<Point>();
		deque.addFirst(new Point(0, 0, elevation[0][0]));
		while(!deque.isEmpty()) {
			Point p = deque.removeFirst();
			int x = p.x;
			int y = p.y;
			int le = p.last;
			if(x < 0 || y < 0 || x >= n || y >= n || visited[x][y]) {
				continue;
			}
			if(Math.abs(le - elevation[x][y]) > h) {
				continue;
			}
			if(x == n - 1 && y == n - 1) {
				System.out.println("yes");
				return;
			}
			if(visited[x][y]) {
				continue;
			}
			visited[x][y] = true;
			deque.addLast(new Point(x + 1, y, elevation[x][y]));
			deque.addLast(new Point(x - 1, y, elevation[x][y]));
			deque.addLast(new Point(x, y + 1, elevation[x][y]));
			deque.addLast(new Point(x, y - 1, elevation[x][y]));
		}
		System.out.println("no");
	}
	public static class Point {
		public int x;
		public int y;
		public int last;
		public Point(int x, int y, int last) {
			this.x = x;
			this.y = y;
			this.last = last;
		}
	}
}
