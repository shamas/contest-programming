import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class ccc05s2 {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FileDescriptor.in)));
		String[] temp = reader.readLine().split(" ");
		int xm = Integer.parseInt(temp[0]);
		int ym = Integer.parseInt(temp[1]);
		int cx = 0;
		int cy = 0;
		String t;
		while(!(t = reader.readLine()).equals("0 0")){
			temp = t.split(" ");
			int x = Integer.parseInt(temp[0]);
			int y = Integer.parseInt(temp[1]);
			cx += x;
			cy += y;
			if(cx < 0)
				cx = 0;
			if(cx > xm)
				cx = xm;
			if(cy < 0)
				cy = 0;
			if(cy > ym){
				cy = ym;
			}
			System.out.println(cx + " " + cy);
		}
	}
}
