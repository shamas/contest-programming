import java.util.*;

public class ccc05j5{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String l;
        while(!(l = scanner.nextLine()).equals("X")){
        	Stack<Character> stack = new Stack<Character>();
            boolean b = true;
            loop:
            for(int i = 0; i < l.length(); ++i){
                char c = l.charAt(i);
                switch(c){
                    case 'A':
                        if(stack.isEmpty()){
                            stack.push('A');
                        }
                        else if(stack.peek() != 'N' && stack.peek() != 'B'){
                            b = false;
                            break loop;
                        }
                        else if(stack.peek() == 'N'){
                        	stack.pop();
                        }
                        else if(stack.peek() == 'B'){
                        	stack.push('A');
                        }
                        break;
                    case 'N':
                        if(stack.isEmpty() || stack.peek() != 'A'){
                            b = false;
                            break loop;
                        }
                        stack.push('N');
                        break;
                    case 'B':
                    	if(stack.isEmpty() || stack.peek() == 'N' || stack.peek() == 'B'){
                    		stack.push('B');
                    	}
                    	else{
                    		b = false;
                    		break loop;
                    	}
                    	break;
                    case 'S':
                    	if(stack.isEmpty()){
                    		b = false;
                    		break loop;
                    	}
                    	if(stack.pop() != 'A'){
                    		b = false;
                    		break loop;
                    	}
                    	if(stack.isEmpty()){
                    		b = false;
                    		break loop;
                    	}
                    	if(stack.pop() != 'B'){
                    		b = false;
                    		break loop;
                    	}
                    	if(stack.isEmpty()){
                            stack.push('A');
                        }
                        else if(stack.peek() != 'N' && stack.peek() != 'B'){
                            b = false;
                            break loop;
                        }
                        else if(stack.peek() == 'N'){
                        	stack.pop();
                        }
                        else if(stack.peek() == 'B'){
                        	stack.push('A');
                        }
                    	break;
                }
            }
            System.out.println((b && stack.size() == 1) ? "YES" : "NO");
        }
    }
}
