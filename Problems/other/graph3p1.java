import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class graph3p1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		boolean[] visited = new boolean[n];
		ArrayList<Integer>[] array = new ArrayList[n];
		for(int i = 0; i < m; ++i) {
			int f = scanner.nextInt() - 1;
			int t = scanner.nextInt() - 1;
			if(array[f] == null) {
				array[f] = new ArrayList<Integer>();
			}
			if(array[t] == null) {
				array[t] = new ArrayList<Integer>();
			}
			array[f].add(t);
			array[t].add(f);
		}
		ArrayDeque<Node> adj = new ArrayDeque<Node>();
		int k = scanner.nextInt();
		for(int i = 0; i < k; ++i) {
			int ind = scanner.nextInt() - 1;
			adj.addLast(new Node(ind, 0));
		}
		int maxNewNodeCount = Integer.MIN_VALUE;
		while(!adj.isEmpty()) {
			Node node = adj.removeFirst();
			if(visited[node.location]) {
				continue;
			}
			visited[node.location] = true;
			ArrayList<Integer> next = array[node.location];
			for(int i = 0; i < next.size(); ++i) {
				int newNodeCount = node.count + 1;
				maxNewNodeCount = Math.max(maxNewNodeCount, newNodeCount);
				adj.addLast(new Node(next.get(i), newNodeCount));
			}
		}
		System.out.println(maxNewNodeCount - 1);
	}
	public static class Node {
		int location;
		int count;
		public Node(int location, int count) {
			this.location = location;
			this.count = count;
		}
	}
}
