import java.util.Arrays;
import java.util.Scanner;

public class dmopc15c1p2 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int L = scanner.nextInt();
		int R = scanner.nextInt() - 1;
		int[] array = new int[N];
		for(int i = 0; i < N; ++i) {
			array[i] = -scanner.nextInt();
		}
		Arrays.sort(array);
		int rankTotal = 0;
		int index = 0;
		loop:
		while(index < array.length) {
			for(int i = 0; i < L; ++i) {
				if(index >= array.length) {
					break loop;
				}
				if(i == R) {
					rankTotal += array[index];
				}
				index ++;
			}
		}
		System.out.println(-rankTotal);
	}
}
