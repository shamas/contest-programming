import java.util.HashMap;
import java.util.Scanner;


public class dmopcshells {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int orig = scanner.nextInt();
		int nLeft = scanner.nextInt();
		int nRight = scanner.nextInt();
		HashMap<Integer, Boolean> avil = new HashMap<Integer, Boolean>();
		for(int i = 0; i < nLeft; ++i){
			avil.put(scanner.nextInt(), true);
		}
		int rec = 0;
		for(int i = 0; i < nRight; ++i){
			Boolean b = avil.get(scanner.nextInt());
			if(b != null){
				++rec;
			}
		}
		System.out.println(orig - rec);
	}
}
