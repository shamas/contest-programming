import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.TreeMap;

public class graph2p1 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FileDescriptor.in)));
		int n = Integer.parseInt(reader.readLine());
		boolean[][] connected = new boolean[n][n];
		boolean[] visited = new boolean[n];
		for(int i = 0; i < n; ++i) {
			String s[] = reader.readLine().split(" ");
			for(int j = 0; j < n; ++j) {
				connected[i][j] = s[j].charAt(0) == '1';
			}
		}
		for(int x = 0; x < n; ++x) {
			if(!visited[x]) {
				TreeMap<Integer, Boolean> map = new TreeMap<Integer, Boolean>();
				map.put(x, true);
				ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
				deque.addLast(x);
				while(!deque.isEmpty()) {
					int a = deque.removeFirst();
					if(visited[a]) {
						continue;
					}
					visited[a] = true;
					map.put(a, true);
					for(int i = 0; i < connected[a].length; ++i) {
						if(connected[a][i]) {
							deque.addLast(i);
						}
					}
				}
				for(Integer k : map.keySet()) {
					System.out.print((k + 1) + " ");
				}
				System.out.println();
			}
		}
	}
}
