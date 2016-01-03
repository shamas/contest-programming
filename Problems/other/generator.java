import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class generator {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("/home/jacky/Desktop/primes")));
		String[] s = reader.readLine().split(", ");
		for(int i = 0; i < s.length; ++i){
			System.out.printf("%4s", Integer.toString(Integer.parseInt(s[i]), 36));
		}
	}
}
