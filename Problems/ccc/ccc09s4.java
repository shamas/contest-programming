import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;


public class ccc09s4 {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FileDescriptor.in)));
		int nCities = Integer.parseInt(reader.readLine());
		int nPaths = Integer.parseInt(reader.readLine());
		int[] cityWeights = new int[nCities];
		for(int i = 0; i < cityWeights.length; ++i){
			cityWeights[i] = Integer.MAX_VALUE;
		}
		int[] pencils = new int[nCities];
		Tuple[][] adjacencies = new Tuple[nCities][5];
		int lengths[] = new int[nCities];
		for(int i = 0; i < nPaths; ++i){
			String[] line = reader.readLine().split(" ");
			int a = Integer.parseInt(line[0]) - 1;
			int b = Integer.parseInt(line[1]) - 1;
			int weight = Integer.parseInt(line[2]);
			Tuple toA = new Tuple(a, weight);
			Tuple toB = new Tuple(b, weight);
			
			if(lengths[a] + 1 > adjacencies[a].length){
				Tuple[] tmp = adjacencies[a];
				adjacencies[a] = new Tuple[adjacencies[a].length * 2 + 1];
				System.arraycopy(tmp, 0, adjacencies[a], 0, tmp.length);
			}
			if(lengths[b] + 1 > adjacencies[b].length){
				Tuple[] tmp = adjacencies[b];
				adjacencies[b] = new Tuple[adjacencies[b].length * 2 + 1];
				System.arraycopy(tmp, 0, adjacencies[b], 0, tmp.length);
			}
			
			adjacencies[b][lengths[b]++] = toA;
			adjacencies[a][lengths[a]++] = toB;
			
		}
		int inputs = Integer.parseInt(reader.readLine());
		for(int i = 0; i < inputs; ++i){
			String[] line = reader.readLine().split(" ");
			pencils[Integer.parseInt(line[0]) - 1] = Integer.parseInt(line[1]);
		}
		int dst = Integer.parseInt(reader.readLine()) - 1;
		ArrayDeque<Node> deque = new ArrayDeque<Node>();
		cityWeights[dst] = 0;
		deque.addLast(new Node(dst, 0));
//		while(!deque.isEmpty()){
//			Node n = deque.removeFirst();
//			Tuple[] adjc = adjacencies[n.city];
//			int len = lengths[n.city];
//			for(int i = 0; i < len; ++i){
//				Tuple t = adjc[i];
//				if(n.weight + t.weight < cityWeights[t.adjacency]){
//					cityWeights[t.adjacency] = n.weight + t.weight;
//					deque.addLast(new Node(t.adjacency, n.weight + t.weight));
//				}
//			}
//		}
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < cityWeights.length; ++i){
			min = Math.min(cityWeights[i] + pencils[i], min);
		}
		System.out.println(min);
	}
	public static class Node{
		int city;
		int weight;
		public Node(int city, int weight){
			this.city = city;
			this.weight = weight;
		}
	}
	public static class Tuple{
		public int adjacency;
		public int weight;
		public Tuple(int adjacency, int weight){
			this.adjacency = adjacency;
			this.weight = weight;
		}
	}
}
