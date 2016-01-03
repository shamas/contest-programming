import java.math.BigInteger;
import java.util.Scanner;


public class seq {
	public static void main(String[] args){
		BigInteger b = new Scanner(System.in).nextBigInteger();
		System.out.println(new BigInteger("1").add(b).multiply(b).divide(new BigInteger("2")));
	}
}
