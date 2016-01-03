import java.io.*;

//not done
public class StrangeFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FileDescriptor.in)));
        String[] buf = reader.readLine().split(" ");
        int n = Integer.parseInt(buf[0]);
        int c = Integer.parseInt(buf[1]);
        buf = reader.readLine().split(" ");
        int[] array = new int[n];
        for(int i = 0; i < n; ++i) {
            array[i] = Integer.parseInt(buf[i]);
        }
        int diff = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = i + 1; j < n; ++j) {
                diff += Math.abs(array[i] - array[j]);
            }
        }
        System.out.println(diff);
    }
}
