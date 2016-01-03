import java.util.Scanner;

public class ccc02j2{
	public static void main(String[] args){
    	Scanner scanner = new Scanner(System.in);
    	String s;
    	while(!(s = scanner.nextLine()).equals("quit!")){
    		if(s.length() > 4){
    			System.out.println(s.replaceAll("(.*)([bcdfghjklmnpqrstvwxz])or", "$1$2our"));
    		}
    		else{
    			System.out.println(s);
    		}
    	}
    }
}