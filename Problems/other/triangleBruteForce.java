
public class triangleBruteForce {
	public static void main(String[] args) {
		for(int a = 1; a < 1000; ++a) {
			for(int b = 1; b < 1000; ++b) {
				int c2 = a * a + b * b;
				int sqrt = (int)Math.round(Math.sqrt(c2));
				if(sqrt * sqrt == c2) {
					if(a + b + sqrt == 144 && a * b == 1008) {
						System.out.println(a + ", " + b);
					}
				}
			}
		}
	}
}
