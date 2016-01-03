import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class cheasy {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FileDescriptor.in)));
		String[] rb = reader.readLine().split(" ");
		int rows = Integer.parseInt(rb[0]);
		int cols = Integer.parseInt(rb[1]);
		int numO[][] = new int[rows + 1][cols + 1];
		int numE[][] = new int[rows + 1][cols + 1];
		int sumO[][] = new int[rows + 1][cols + 1];
		int sumE[][] = new int[rows + 1][cols + 1];
		String s;
		while(!(s = reader.readLine()).equals("0 0 0")) {
			rb = s.split(" ");
			int r = Integer.parseInt(rb[0]);
			int c = Integer.parseInt(rb[1]);
			int n = Integer.parseInt(rb[2]);
			if((r + c) % 2 == 0) {
				numE[r][c] = n;
			}
			else{
				numO[r][c] = n;
			}
		}
		for(int i = 1; i <= rows; ++i) {
			for(int j = 1; j <= cols; ++j) {
				sumE[i][j] = numE[i][j] + sumE[i - 1][j] + sumE[i][j - 1] - sumE[i - 1][j - 1];
				sumO[i][j] = numO[i][j] + sumO[i - 1][j] + sumO[i][j - 1] - sumO[i - 1][j - 1];
			}
		}
		while(!(s = reader.readLine()).equals("0 0 0 0")) {
			rb = s.split(" ");
			int r1 = Integer.parseInt(rb[0]);
			int c1 = Integer.parseInt(rb[1]);
			int r2 = Integer.parseInt(rb[2]);
			int c2 = Integer.parseInt(rb[3]);
			int e = sumE[r2][c2] - sumE[r1 - 1][c2] - sumE[r2][c1 - 1] + sumE[r1 - 1][c1 - 1];
			int o = sumO[r2][c2] - sumO[r1 - 1][c2] - sumO[r2][c1 - 1] + sumO[r1 - 1][c1 - 1];
			if((r1 + c1) % 2 != 0) {
				System.out.println(o - e);
			}
			else {
				System.out.println(e - o);
			}
		}
	}
}
