import java.util.Scanner;

public class binary{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; ++i) {
            String b = Integer.toBinaryString(scanner.nextInt());
            while(b.length() % 4 != 0) {
                b = "0" + b;
            }
            for(int j = 0; j < b.length(); ++j) {
                System.out.print(b.charAt(j));
                if(j % 4 == 3) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}