import java.util.Scanner;

public class dmopc15c2p1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int rate = scanner.nextInt();
        int total = 0;
        int swordLeft = 0;
        
        while(n > 0) {
        	swordLeft = swordLeft;
            n /= rate;
        }
        System.out.println(total);
    }
}