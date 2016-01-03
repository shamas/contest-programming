import java.util.*;

public class fizzfixx{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 1; i <= n; ++i){
            String s = Integer.toString(i);
            boolean isAdd = false;
            if(i % 7 == 0){
                s = "Fizz";
                isAdd = true;
            }
            if(i % 13 == 0){
            	if(isAdd){
            		s += " Fuzz";
            	}
            	else{
            		s = "Fuzz";
            	}
            }
            System.out.print(s + " ");
            s = Integer.toString(i * 2 - 1);
            isAdd = false;
            if((2 * i - 1) % 7 == 0){
                s = "Fizz";
                isAdd = true;
            }
            if((2 * i - 1) % 13 == 0){
            	if(isAdd){
            		s += " Fuzz";
            	}
            	else{
            		s = "Fuzz";
            	}
            }
            System.out.println(s);
        }
    }
}