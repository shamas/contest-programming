import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class dmopcaurora {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int A = scanner.nextInt();
		int B = scanner.nextInt();
		int C = scanner.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < N; ++i){
			list.add(scanner.nextInt());
		}
		Collections.sort(list);
		Collections.reverse(list);
		int[] timeTakeAtStation = new int[M];
		
		for(int i = 0; i < list.size(); ++i){
			int a = list.get(i);
			timeTakeAtStation[a] += C;
			
			
		}
	}
}
