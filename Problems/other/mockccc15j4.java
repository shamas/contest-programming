import java.util.Scanner;

public class mockccc15j4 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		char[][] array = new char[n][n];
		int m = (int)Math.ceil(n / 2.0);
		int ll = n - 1;
		boolean hs = true;
		boolean vs = true;
		boolean tls = true;
		boolean bls = true;
		for(int i = 0; i < n; ++i) {
			String str = scanner.nextLine();
			for(int j = 0; j < n; ++j) {
				char c = str.charAt(j);
				array[i][j] = c;
			}
		}
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				int c = array[i][j];
				if(j >= m) {
					char o = array[i][ll - j];
					if(		((c == 'O' || c == '.') && c == o) || 
							(c == '(' && o == ')') || 
							(c == ')' && o == '(') || 
							(c == '/' && o == '\\') || 
							(c == '\\' && o == '/'));
					else {
						hs = false;
					}
				}
				if(i >= m) {
					char o = array[ll - i][j];
					if(		((c == 'O' || c == '.' || c == '(' || c == ')') && c == o) ||
							(c == '/' && o == '\\') || 
							(c == '\\' && o == '/'));
					else {
						vs = false;
					}
				}
				if(i >= j) {
					char o = array[j][i];
					if(		((c == 'O' || c == '.' || c == '/' || c == '\\') && c == o) && c != '(' && c != ')');
					else {
						tls = false;
					}
				}
				if((ll - i) >= j) {
					char o = array[j][i];
					if(		((c == 'O' || c == '.' || c == '/' || c == '\\') && c == o) && c != '(' && c != ')');
					else {
						bls = false;
					}
				}
			}
		}
		int i = 0;
		if(tls)
			++i;
		if(bls)
			++i;
		if(vs)
			++i;
		if(hs)
			++i;
		System.out.println(i);
	}
}
