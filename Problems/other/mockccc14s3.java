import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class mockccc14s3 {
	public static int colToSort;
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FileDescriptor.in)));
		String[] buf = reader.readLine().split(" ");
		int R = Integer.parseInt(buf[0]);
		int C = Integer.parseInt(buf[1]);
		ArrayList<Row> row = new ArrayList<Row>();
		for(int i = 0; i < R; ++i) {
			buf = reader.readLine().split(" ");
			int[] array = new int[C];
			for(int j = 0; j < C; ++j) {
				array[j] = Integer.parseInt(buf[j]);
			}
			row.add(new Row(array));
		}
		int n = Integer.parseInt(reader.readLine());
		for(int i = 0; i < n; ++i) {
			colToSort = Integer.parseInt(reader.readLine()) - 1;
			Collections.sort(row);
		}
		for(int j = 0; j < R; ++j) {
			Row r = row.get(j);
			int[] array = r.array;
			for(int z = 0; z < array.length; ++z) {
				System.out.print(array[z] + " ");
			}
			System.out.println();
		}
	}
	public static class Row implements Comparable<Row> {
		public int[] array;
		public Row(int[] array) {
			this.array = array;
		}
		public int compareTo(Row arg0) {
			return array[colToSort] - arg0.array[colToSort];
		}
	}
}

