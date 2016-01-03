import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;


public class deathgun {
	public static void main(String[] args) throws UnknownHostException{
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		HashMap<String, String> map1 = new HashMap<String, String>();
		HashMap<String, String> map2 = new HashMap<String, String>();
		String s1 = "", s2 = "";
		for(int i = 0; i < n; ++i){
			String[] s = scanner.nextLine().split(" ");
			map1.put(s[0], s[1]);
			map2.put(s[1], s[0]);
			s1 = s[0];
			s2 = s[1];
		}
		LinkedList<String> values = new LinkedList<String>();
		String a = s1;
		while((a = map1.get(a)) != null && !values.contains(a)){
			values.addLast(a);
		}
		a = s2;
		while((a = map2.get(a)) != null && !values.contains(a)){
			values.addFirst(a);
		}
		while(!values.isEmpty()){
			System.out.println(values.removeLast());
		}
	}
}
