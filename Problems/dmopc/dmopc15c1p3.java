import java.util.Scanner;

public class dmopc15c1p3 {
	public static int shift;
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String a = scanner.nextLine();
		String b = scanner.nextLine();
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < a.length() - b.length() + 1; ++i){
			if(match(a.substring(i, i + b.length()), b)){
				if(shift < min) {
					min = shift;
				}
			}
		}
		System.out.println(min);
		for(int i = 0; i < a.length(); ++i) {
			int s = a.charAt(i) - min;
			if(s < 'a') {
				s = s - 'a' + 'z' + 1;
			}
			System.out.print((char)(s));
		}
		System.out.println();
	}
	public static boolean match(String s1, String s2) {
		if(s1.length() != s2.length()) {
			System.out.println("You messed up jacky!");
			System.exit(-1);
		}
		int diff = Integer.MIN_VALUE;
		for(int i = 0; i < s1.length(); ++i) {
			int c1 = s1.charAt(i);
			int c2 = s2.charAt(i);
			int cdiff = c1 - c2;
			if(cdiff < 0) {
				cdiff += 26;
			}
			if(diff == Integer.MIN_VALUE) {
				diff = cdiff;
			}
			else if(cdiff != diff) {
				return false;
			}
		}
		shift = diff;
		return true;
	}
}
