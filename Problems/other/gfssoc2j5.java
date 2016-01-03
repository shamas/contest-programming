import java.util.Arrays;
import java.util.Scanner;

public class gfssoc2j5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int q = scanner.nextInt();
		int[] nums = new int[n];
		for(int i = 0; i < n; ++i) {
			nums[i] = scanner.nextInt();
		}
		int[] leftN = new int[n + 2];
		int[] leftC = new int[n + 2];
		int[] rightN = new int[n + 2];
		int[] rightC = new int[n + 2];
		for(int i = 0; i < n; ++i) {
			if(leftN[i] < nums[i]) {
				leftN[i + 1] = nums[i];
				leftC[i + 1] = 1;
			}
			else if(leftN[i] == nums[i]) {
				leftN[i + 1] = leftN[i];
				leftC[i + 1] = leftC[i] + 1;
			}
			else {
				leftN[i + 1] = leftN[i];
				leftC[i + 1] = leftC[i];
			}
		}
		for(int i = nums.length - 1; i >= 0; --i) {
			if(rightN[i + 1] < nums[i]) {
				rightN[i] = nums[i];
				rightC[i] = 1;
			}
			else if(rightN[i + 1] == nums[i]) {
				rightN[i] = rightN[i + 1];
				rightC[i] = rightC[i + 1] + 1;
			}
			else{
				rightN[i] = rightN[i + 1];
				rightC[i] = rightC[i + 1];
			}
		}
		System.out.println(Arrays.toString(leftN));
		System.out.println(Arrays.toString(leftC));
		System.out.println(Arrays.toString(rightN));
		System.out.println(Arrays.toString(rightC));
		for(int i = 0; i < q; ++i) {
			int l = scanner.nextInt();
			int r = scanner.nextInt();
			int nl = leftN[l - 1];
			int cl = leftC[l - 1];
			int nr = rightN[r];
			int cr = rightC[r];
			System.out.println(nl + ", " + cl + ",, " + nr + ", " + cr);
			if(nl > nr){
				System.out.println(nl + " " + cl);
			}
			else if(nl == nr) {
				System.out.println(nr + " " + (cl + cr));
			}
			else{
				System.out.println(nr + " " + cr);
			}
		}
	}
}
