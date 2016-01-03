import java.math.BigInteger;
import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
//		BigInteger fib = scanner.nextBigInteger();
		for(int i = 1;; ++i) {
			long ll = fib(i).mod(new BigInteger("1000000007")).longValue();
			if(ll == 0){
				System.out.println("---------------FOUND: " + i);
				System.exit(0);
			}
			if(i % 1000 == 0){
				System.out.println(i);
			}
//			System.out.println(ll);
		}
//		System.out.println();
	}
	private static BigInteger fib(long n) {
		BigInteger a = BigInteger.ZERO;
		BigInteger b = BigInteger.ONE;
		int m = 0;
		for (int i = 63 - Long.numberOfLeadingZeros(n); i >= 0; i--) {
			BigInteger d = a.multiply(b.shiftLeft(1).subtract(a));
			BigInteger e = a.multiply(a).add(b.multiply(b));
			a = d;
			b = e;
			m *= 2;
			
			if (((n >>> i) & 1) != 0) {
				BigInteger c = a.add(b);
				a = b;
				b = c;
				m++;
			}
		}
		return a;
	}
}
