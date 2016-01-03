import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class ListMinimum {
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FileDescriptor.in)));
		int n = Integer.parseInt(reader.readLine());
		ArrayList<Integer> array = new ArrayList<Integer>();
		for(int i = 0; i < n; ++i){
			array.add(Integer.parseInt(reader.readLine()));
		}
		Collections.sort(array);
		for(int i = 0; i < n; ++i){
			System.out.println(array.get(i));
		}
	}
}
