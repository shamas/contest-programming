import java.util.Scanner;


public class dmopc14c2p4 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] sums = new int[n];
		int[] vals = new int[n];
		int currentSum = 0;
		for(int i = 0; i < n; ++i){
			int a = scanner.nextInt();
			currentSum += a;
			sums[i] = currentSum;
			vals[i] = a;
		}
		int m = scanner.nextInt();
		for(int i = 0; i < m; ++i){
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			System.out.println(sums[b] - sums[a] + vals[a]);
		}
	}
}
