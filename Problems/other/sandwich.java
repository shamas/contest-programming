import java.util.*;

public class sandwich{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String s = scanner.nextLine();
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i = 0; i < s.length(); ++i){
            switch(s.charAt(i)){
                case '1':
                    list.addLast(i);
                    break;
                case '0':
                    list.addFirst(i);
                    break;
            }
        }
        while(!list.isEmpty()){
        	System.out.println(list.removeLast() + 1);
        }
    }
}
