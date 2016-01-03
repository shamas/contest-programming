import java.util.Scanner;


public class bool {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String s;
		boolean b = false;
		while(!(s = scanner.next()).equals("True") && !s.equals("False")){
			b = !b;
		}
		b ^= Boolean.parseBoolean(s);
		System.out.println(b ? "True" : "False");
	}
}
