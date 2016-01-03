import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class coci087p2 {
	public static int[][] scoreTable = {{1, 0, 2}, {2, 1, 0}, {0, 2, 1}};
	public static int[] ind = new int[127];
	static {
		ind['P'] = 1;
		ind['S'] = 2;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FileDescriptor.in)));
		int n = Integer.parseInt(reader.readLine());
		char[] pp = reader.readLine().toCharArray();
		int nplayers = Integer.parseInt(reader.readLine());
		char[][] ppl = new char[nplayers][];
		int mPoint = 0;
		for(int i = 0; i < nplayers; ++i) {
			ppl[i] = reader.readLine().toCharArray();
			for(int j = 0; j < n; ++j) {
				mPoint += scoreTable[ind[pp[j]]][ind[ppl[i][j]]];
			}
		}
		int maxPointTotal = 0;
		for(int i = 0; i < n; ++i) {
			int maxPoint = Integer.MIN_VALUE;
			for(int rps = 0; rps < 3; ++rps) {
				int scoreCount = 0;
				for(int pi = 0; pi < nplayers; ++pi) {
					scoreCount += scoreTable[rps][ind[ppl[pi][i]]];
				}
				if(scoreCount > maxPoint) {
					maxPoint = scoreCount;
				}
			}
			maxPointTotal += maxPoint;
		}
		System.out.println(mPoint);
		System.out.println(maxPointTotal);
	}
}
