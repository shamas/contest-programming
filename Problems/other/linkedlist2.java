import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class linkedlist2 {
	public static long[] array = new long[1000006];
	
	public static int lastInd;
	public static int currInd;
	public static int nextInd;
	
	public static int freeInd;
	
	public static void instantiateArray(){
		for(int i = 0; i < array.length; ++i){
			array[i] = i - 1;
		}
		freeInd = array.length - 1;
		lastInd = allocate();
		currInd = allocate();
		nextInd = allocate();
		int nullInd = allocate();
		int aNull1 = allocate();
		int aNull2 = allocate();
		array[aNull1] = (long)(nullInd ^ lastInd) << 44L;
		array[lastInd] = (long)(aNull1 ^ currInd) << 44L;
		array[currInd] = (long)(lastInd ^ nextInd) << 44L;
		array[nextInd] = (long)(nextInd ^ aNull2) << 44L;
		array[aNull2] = (long)(nextInd ^ nullInd) << 44L;
	}
	
	public static int allocate(){
		int i = freeInd;
		freeInd = (int)array[freeInd];
		return i;
	}
	
	public static void free(int i){
		array[i] = freeInd;
		freeInd = i;
	}
	
	public static void insert(long value){
		if(value < 0){
			value = -value;
			value |= 1L << 43L;
		}
		int newPtr = allocate();
		array[lastInd] = array[lastInd] ^ ((long)(currInd ^ newPtr) << 44L);
		array[currInd] = array[currInd] ^ ((long)(lastInd ^ newPtr) << 44L);
		nextInd = currInd;
		currInd = newPtr;
		array[currInd] = ((long)(lastInd ^ nextInd) << 44L) | value;
	}
	public static void set(long value){
		if(value < 0){
			value = -value;
			value |= 1L << 43L;
		}
		array[currInd] = (array[currInd] & 0xFFFFF00000000000L) | value;
	}
	public static void remove(){
		int prevCurr = currInd;
		int nextNext = (int) ((array[nextInd] >>> 44L) ^ currInd);
		array[lastInd] = array[lastInd] ^ ((long)(currInd ^ nextInd) << 44L);
		array[nextInd] = array[nextInd] ^ ((long)(currInd ^ lastInd) << 44L);
		currInd = nextInd;
		nextInd = nextNext;
		free(prevCurr);
	}
	public static void next(){
		lastInd = currInd;
		currInd = nextInd;
		nextInd = (int)((array[currInd] >>> 44L) ^ lastInd);
	}
	public static void prev(){
		nextInd = currInd;
		currInd = lastInd;
		lastInd = (int)((array[currInd] >>> 44L) ^ nextInd);
	}
	public static long get(){
		long l = array[currInd] & 0x7FFFFFFFFFFL;
		if(((array[currInd] >>> 43L) & 1L) == 1L){
			return -l;
		}
		return l;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FileDescriptor.in)));
		instantiateArray();
		int n = Integer.parseInt(reader.readLine());
		for(int i = 0; i < n; ++i){
			String s = reader.readLine();
			switch(s.charAt(0)){
			case '+':
				insert(Long.parseLong(s.substring(2)));
				break;
			case '=':
				set(Long.parseLong(s.substring(2)));
				break;
			case '-':
				remove();
				break;
			case '<':
				prev();
				break;
			case '>':
				next();
				break;
			case '!':
				System.out.println(get());
				break;
			}
		}
	}
}
