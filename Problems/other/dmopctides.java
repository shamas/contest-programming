import java.util.Scanner;


public class dmopctides {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int minInd = -1;
		int maxInd = -1;
		int[] values = new int[n];
		for(int i = 0; i < n; ++i){
			int a = scanner.nextInt();
			values[i] = a;
			if(a < min){
				min = a;
				minInd = i;
			}
			if(a > max){
				max = a;
				maxInd = i;
			}
		}
		int lastVal = -1;
		for(int i = minInd; i <= maxInd; ++i){
			if(values[i] > lastVal){
				lastVal = values[i];
			}
			else{
				System.out.println("unknown");
				return;
			}
		}
		if(minInd > maxInd){
			System.out.println("unknown");
			return;
		}
		System.out.println(max - min);
	}
}
