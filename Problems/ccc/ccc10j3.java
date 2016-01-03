import java.util.Scanner;

public class ccc10j3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int ins;
		int[] sto = new int[2];
		int a;
		while((ins = scanner.nextInt()) != 7) {
			switch(ins) {
			case 1:
				sto[scanner.next().charAt(0) - 'A'] = scanner.nextInt();
				break;
			case 2:
				System.out.println(sto[scanner.next().charAt(0) - 'A']);
				break;
			case 3:
				a = scanner.next().charAt(0) - 'A';
				sto[a] = sto[a] + sto[scanner.next().charAt(0) - 'A'];
				break;
			case 4:
				a = scanner.next().charAt(0) - 'A';
				sto[a] = sto[a] * sto[scanner.next().charAt(0) - 'A'];
				break;
			case 5:
				a = scanner.next().charAt(0) - 'A';
				sto[a] = sto[a] - sto[scanner.next().charAt(0) - 'A'];
				break;
			case 6:
				a = scanner.next().charAt(0) - 'A';
				sto[a] = sto[a] / sto[scanner.next().charAt(0) - 'A'];
				break;
			}
		}
	}
}
