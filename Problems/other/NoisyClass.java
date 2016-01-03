import java.util.ArrayList;
import java.util.Scanner;

public class NoisyClass {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		ArrayList<Integer>[] array = new ArrayList[N];
		for(int i = 0; i < array.length; ++i){
			array[i] = new ArrayList<Integer>();
			array[i].add(i);
		}
		int M = scanner.nextInt();
		for(int i = 0; i < M; ++i){
			int a = scanner.nextInt() - 1;
			int b = scanner.nextInt() - 1;
			array[b].addAll(array[a]);
		}
		for(int i = 0; i < array.length; ++i){
			boolean occur = false;
			for(int j = 0; j < array[i].size(); ++j){
				if(array[i].get(j) == i){
					if(!occur){
						occur = true;
					}
					else{
						System.out.println("N");
						return;
					}
				}
			}
		}
		System.out.println("Y");
	}
}
