import java.util.ArrayList;
import java.util.Scanner;


public class ccc07s4 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		ArrayList<Integer>[] list = new ArrayList[n];
		for(int i = 0; i < list.length; ++i){
			list[i] = new ArrayList<Integer>();
		}
		String s;
		while(!(s = scanner.nextLine()).equals("0 0")){
			String[] ss = s.split(" ");
			int i1 = Integer.parseInt(ss[0]) - 1;
			int i2 = Integer.parseInt(ss[1]) - 1;
			list[i1].add(i2);
		}
		int[] count = new int[n];
		count[0] = 1;
		for(int i = 0; i < list.length; ++i){
			ArrayList<Integer> l = list[i];
			for(int j = 0; j < l.size(); ++j){
				count[l.get(j)] += count[i];
			}
		}
		System.out.println(count[n - 1]);
	}
}
