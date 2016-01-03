import java.util.Arrays;
import java.util.Scanner;


public class gfssoc2j5Crap {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int q = scanner.nextInt();
		int[] cpepisode = new int[n];
		int[] currCount = new int[10];
		int[][] count = new int[n][];
		for(int i = 0; i < n; ++i){
			int cCount = scanner.nextInt() - 1;
			++currCount[cCount];
			count[i] = Arrays.copyOf(currCount, 10);
			cpepisode[i] = cCount;
		}
		for(int i = 0; i < q; ++i){
			int a = scanner.nextInt() - 1;
			int b = scanner.nextInt() - 1;
			int[] an = count[a];
			int[] bn = count[b];
			int[] diff = new int[10];
			diff[cpepisode[a]] = -1;
			int ab = 0;
			for(int j = 0; j < 10; ++j){		
				diff[j] += currCount[j] - (bn[j] - an[j]);
				if(diff[j] != 0){
					ab = j;
				}
			}
			System.out.println(ab + 1 + " " + diff[ab]);
		}
	}
}
