import java.util.*;
import java.math.*;

public class p5{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int exp = scanner.nextInt();
        System.out.println(new BigInteger("2").multiply(new BigInteger("4").pow(exp - 1)).mod(new BigInteger("998244353")));
    }
}