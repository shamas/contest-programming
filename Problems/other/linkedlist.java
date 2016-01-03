import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class linkedlist {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FileDescriptor.in)));
		int n = Integer.parseInt(reader.readLine());
		long[] array = new long[1000003];
		int lastElement = 999999;
		for(int i = 0; i < 1000000; ++i){
			array[i] = ((i == 0 ? 1000003L : (i - 1L)) << 44L) | 0xFFFFFFFFFFFL;
		}
		array[1000000] = (1000002L ^ 1000001L) << 44L | 0xFFFFFFFFFFFL;
		array[1000001] = (1000002L ^ 1000000L) << 44L | 0xFFFFFFFFFFFL;
		int currInd = 1000001;
		int nextInd = 1000002;
		int lastInd = 1000000;
		boolean isNeg;
		long tmp; 
		long l;
		long lCurrent;
		long lNext;
		long lLast;
		int iCurrent;
		int iNext;
		int iLast;
		int iEmpty;
		int tmpPtr;
		for(int i = 0; i < n; ++i){
			String s = reader.readLine();
			lCurrent = array[iCurrent = currInd];
			lNext = array[iNext = nextInd];
			lLast = array[iLast = lastInd];
			iEmpty = lastElement;
			switch(s.charAt(0)){
			case '+':
				l = Long.parseLong(s.substring(2));
				isNeg = l < 0;
				if(isNeg){
					l = -l;
					l |= 1L << 43L;
				}
				tmpPtr = lastElement;
				lastElement = (int) (array[lastElement] >>> 44L);
				currInd = tmpPtr;
				array[currInd] = (long)(lastInd ^ nextInd) << 44L | l;
				System.out.println(Long.toHexString(array[currInd]));
				//System.out.println(lastInd + ", " + nextInd + ", " + l);
				array[lastInd] = (long)((array[lastInd] >>> 44L) ^ iCurrent ^ tmpPtr) << 44L | (array[lastInd] & 0xFFFFFFFFFFFL);
				System.out.println(Long.toHexString(array[lastInd]));
				array[iCurrent] = (long)((array[iCurrent] >>> 44L) ^ iLast ^ tmpPtr) << 44L | (array[iCurrent] & 0xFFFFFFFFFFFL);
				System.out.println(Long.toHexString(array[iCurrent]));
				nextInd = iCurrent;
				break;
			case '=':
				l = Long.parseLong(s.substring(2));
				isNeg = l < 0;
				if(isNeg){
					l = -l;
					l |= 1L << 43L;
					System.out.println(Long.toHexString(l));
				}
				array[currInd] = (array[currInd] & 0xFFFFF00000000000L) | l;
				break;
			case '-':
				
				break;
			case '<':
				nextInd = currInd;
				currInd = lastInd;
				lastInd = (int)((array[currInd] >>> 44L) ^ nextInd);
				break;
			case '>':
				lastInd = currInd;
				currInd = nextInd;
				nextInd = (int)((array[currInd] >>> 44L) ^ lastInd);
				break;
			case '!':
				isNeg = ((array[currInd] >>> 43L) & 1L) == 1;
				tmp = array[currInd] & 0x7FFFFFFFFFFL;
				System.out.println(isNeg ? -tmp : tmp);
				break;
			}
		}
	}
}
