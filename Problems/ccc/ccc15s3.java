import java.util.Scanner;


public class ccc15s3 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int gates = scanner.nextInt();
		int planes = scanner.nextInt();
		int[] pointers = new int[gates];
		for(int i = 0; i < gates; ++i){
			pointers[i] = i;
		}
		int nplanes = 0;
		loop:
		for(int i = 0; i < planes; ++i){
			int a = scanner.nextInt();
			int ptr = pointers[a];
			while(ptr != a){
				ptr = pointers[ptr];
			}
			break;
		}
		System.out.println(nplanes);
	}
}
