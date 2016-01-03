import java.io.*;

public class PermutationSwaps {

    public static int[] dset = new int[100001];

    public static void build(){
        for (int i = 0; i < 100001; i++)
            dset[i] = i;
    }

    public static int unionFind(int n){
        while(n != dset[n])
            n = dset[n];
        return n;
    }

    public static void unionMerge(int a, int b){
        int ra = unionFind(a), rb = unionFind(b);
        if (ra == rb) return;
        dset[ra] = rb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FileDescriptor.in)));
        String[] tmp = reader.readLine().split(" ");
        int nCases = Integer.parseInt(tmp[0]);
        for(int a = 0; a < nCases; ++a) {
            build();

            tmp = reader.readLine().split(" ");
            int n = Integer.parseInt(tmp[0]);
            int c = Integer.parseInt(tmp[1]);
            tmp = reader.readLine().split(" ");
            int[] array = new int[n];
            for(int i = 0; i < n; ++i) {
                array[i] = Integer.parseInt(tmp[i]);
            }
            tmp = reader.readLine().split(" ");
            int[] array2 = new int[n];
            int[] ind = new int[n];
            for(int i = 0; i < n; ++i) {
                array2[i] = Integer.parseInt(tmp[i]);
                ind[array2[i] - 1] = i;
            }
            for(int i = 0; i < c; ++i) {
                tmp = reader.readLine().split(" ");
                int n1 = Integer.parseInt(tmp[0]) - 1;
                int n2 = Integer.parseInt(tmp[1]) - 1;

                unionMerge(n1, n2);
            }

            boolean works = true;

            for(int i = 0; i < n; ++i) {
                if(unionFind(i) != unionFind(ind[array[i] - 1])) {
                    works = false;
                }
            }

            System.out.println(works ? "YES" : "NO");
        }
    }
}
