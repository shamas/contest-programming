import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class bit {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FileDescriptor.in)));
		String[] buf = reader.readLine().split(" ");
		int n = Integer.parseInt(buf[0]);
		int m = Integer.parseInt(buf[1]);
		int[] array = new int[n + 1];
		int[] arrayC = new int[1000001];
		
		long[] bitA = new long[n + 1];
		int[] bitC = new int[1000001];
		
		buf = reader.readLine().split(" ");
		
		for(int i = 1; i <= n; ++i){
			array[i] = Integer.parseInt(buf[i - 1]);
			arrayC[array[i]] ++;
		}
		
		for(int i = 1; i <= n; ++i) {
			int c = i & -i;
			for(int j = i - c + 1; j <= i; ++j) {
				bitA[i] += array[j];
			}
		}
		
		for(int i = 1; i <= 1000000; ++i) {
			int c = i & -i;
			for(int j = i - c + 1; j <= i; ++j) {
				bitC[i] += arrayC[j];
			}
		}
		
		for(int i = 0; i < m; ++i) {
			buf = reader.readLine().split(" ");
			char op = buf[0].charAt(0);
			switch(op) {
			case 'C':{
				int ind = Integer.parseInt(buf[1]);
				int changeTo = Integer.parseInt(buf[2]);
				int toInd = ind;
				while(ind <= n) {
					bitA[ind] = bitA[ind] - array[toInd] + changeTo;
					ind += (ind & -ind);
				}
				int oldVal = array[toInd];
				array[toInd] = changeTo;
				
				while(oldVal <= 1000000) {
					bitC[oldVal] = bitC[oldVal] - 1;
					oldVal += (oldVal & -oldVal);
				}
				
				int newVal = changeTo;
				
				while(newVal <= 1000000) {
					bitC[newVal] = bitC[newVal] + 1;
					newVal += (newVal & -newVal);
				}
				
			}
			break;
			case 'S':{
				int l = Integer.parseInt(buf[1]) - 1;
				int r = Integer.parseInt(buf[2]);
				long sum = 0;
				while(l > 0) {
					sum -= bitA[l];
					l -= (l & -l);
				}
				while(r > 0) {
					sum += bitA[r];
					r -= (r & -r);
				}
				System.out.println(sum);
			}
			break;
			case 'Q':{
				int v = Integer.parseInt(buf[1]);
				long sum = 0;
				while(v > 0) {
					sum += bitC[v];
					v -= (v & -v);
				}
				System.out.println(sum);
			}
			break;
			}
		}
	}
}
