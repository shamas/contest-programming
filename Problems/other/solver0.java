import java.util.Scanner;

public class solver0 {
	public static void main(String[] args){
		
		Scanner s = new Scanner(System.in);
		
		int N = s.nextInt();
		
		int Q = s.nextInt();
		
		int[][] ratings = new int[N][N];
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; i++){
				ratings[i][j + 1] = s.nextInt();
			}
		}
		
	}
}
