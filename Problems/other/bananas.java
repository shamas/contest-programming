import java.util.Scanner;

public class bananas {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String s;
		while(!(s = scanner.nextLine()).equals("X")) {
			String reg1 = ".*?BAS.*?";
			String reg2 = ".*?A(NA)+.*?";
			boolean match1 = s.matches(reg1);
			boolean match2 = s.matches(reg2);
			while(match1 || match2) {
				if(match1) {
					s = s.replaceAll("BAS", "A");
				}
				else if(match2) {
					s = s.replaceAll("A(NA)+", "A");
				}
				match1 = s.matches(reg1);
				match2 = s.matches(reg2);
			}
			System.out.println(s.equals("A") ? "YES" : "NO");
		}
	}
}
