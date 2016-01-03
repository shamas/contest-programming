import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class ccc07s5 {
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FileDescriptor.in)));
		int nTestCase = Integer.parseInt(reader.readLine());
		for(int x = 0; x < nTestCase; ++x){
			String[] data = reader.readLine().split(" ");
			int numBowlingPin = Integer.parseInt(data[0]);
			int numBowlingBall = Integer.parseInt(data[1]);
			int ballWidth = Integer.parseInt(data[2]);
			int[] ballNumberSum = new int[numBowlingPin];
			int currentSum = 0;
			for(int i = 0; i < numBowlingPin; ++i){
				ballNumberSum[i] = currentSum += Integer.parseInt(reader.readLine());
			}
			for(int a = 0; a < numBowlingBall; ++a){
				int minIndex = -1;
				int queryValue = Integer.MIN_VALUE;
				for(int i = ballWidth - 1; i < numBowlingPin; ++i){
					int query = i == ballWidth - 1 ? ballNumberSum[i] : ballNumberSum[i] - ballNumberSum[i - ballWidth];
					if(query > queryValue){
						
					}
				}
			}
		}
	}
}
