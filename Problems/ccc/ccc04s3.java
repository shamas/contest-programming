import java.awt.*;
import java.util.Scanner;
import java.util.Stack;

public class ccc04s3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] vals = new String[10][9];
        int[][] finalVals = new int[10][9];
        boolean[][] visiting = new boolean[10][9];
        for(int r = 0; r < 10; ++r) {
            for(int c = 0; c < 9; ++c) {
                vals[r][c] = scanner.next();
                finalVals[r][c] = Integer.MAX_VALUE;
            }
        }
        for(int r = 0; r < 10; ++r) {
            for(int c = 0; c < 9; ++c) {
                if(finalVals[r][c] == Integer.MAX_VALUE) {
                    visiting[r][c] = true;
                    resolve(r, c, vals, finalVals, visiting);
                    visiting[r][c] = false;
                }
            }
        }
        for(int r = 0; r < 10; ++r) {
            for(int c = 0; c < 9; ++c) {
                int val = finalVals[r][c];
                if(val == Integer.MIN_VALUE)
                    System.out.print("* ");
                else
                    System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    public static void resolve(int r, int c, String[][] chars, int[][] finalVals, boolean[][] resolving) {
        String s = chars[r][c];
        try {
            finalVals[r][c] = Integer.parseInt(s);
        }
        catch(Exception e) {
            String[] operands = s.split("\\+");
            int sum = 0;
            for(int i = 0; i < operands.length; ++i) {
                String cell = operands[i];
                int rr = cell.charAt(0) - 'A';
                int cc = cell.charAt(1) - '1';
                if(resolving[rr][cc]) {
                    finalVals[r][c] = Integer.MIN_VALUE;
                    return;
                }
                resolving[rr][cc] = true;
                if(finalVals[rr][cc] == Integer.MAX_VALUE)
                    resolve(rr, cc, chars, finalVals, resolving);
                if(finalVals[rr][cc] == Integer.MIN_VALUE) {
                    finalVals[r][c] = Integer.MIN_VALUE;
                    resolving[rr][cc] = false;
                    return;
                }
                sum += finalVals[rr][cc];
                resolving[rr][cc] = false;
            }
            finalVals[r][c] = sum;
        }
    }
}
