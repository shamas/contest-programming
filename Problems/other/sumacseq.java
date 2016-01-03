import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class sumacseq {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FileDescriptor.in)));
		String[] str;
		
		while((str = reader.readLine().split(" "))[0].charAt(0) != 'q') {
			System.out.println(/*asdf*/);
		}
	}
}
