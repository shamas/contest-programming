import java.util.Scanner;

public class ccc04s1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; ++i) {
            String[] s = new String[3];
            s[0] = scanner.next().trim();
            s[1] = scanner.next().trim();
            s[2] = scanner.next().trim();
            boolean prefix = false;
            boolean suffix = false;
            for(int j = 0; j < 3; ++j) {
                for(int k = 0; k < 3; ++k) {
                    if(j == k) {
                        continue;
                    }
                    if(s[j].startsWith(s[k])) {
                        prefix = true;
                    }
                    if(s[j].endsWith(s[k])) {
                        suffix = true;
                    }
                }
            }
            System.out.println(!prefix && !suffix ? "Yes" : "No");
        }
    }
}
