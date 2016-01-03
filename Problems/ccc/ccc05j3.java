import java.util.Scanner;
import java.util.Stack;


public class ccc05j3 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		Stack<String> stack = new Stack<String>();
		stack.push("$$__LOLHOMELOL__$$");
		String s;
		while(!(s = scanner.nextLine()).equals("SCHOOL")){
			stack.push(s);
		}
		while(!stack.isEmpty()){
			String dir = stack.pop();
			String loc = stack.pop();
			if(loc.equals("$$__LOLHOMELOL__$$")){
				System.out.println("Turn " + (dir.equals("L") ? "RIGHT" : "LEFT") + " into your HOME.");
			}
			else{
				System.out.println("Turn " + (dir.equals("L") ? "RIGHT" : "LEFT") + " onto " + loc + " street.");
			}
		}
	}
}
