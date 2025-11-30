import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(a, (x, y) -> x[0] - y[0]);
        
        long s = a[0][0];
        long e = a[0][1];
        long r = 0;
        
        for (int i = 1; i < n; i++) {
            if (a[i][0] <= e) {
                e = Math.max(e, a[i][1]);
            } else {
                r += e - s;
                s = a[i][0];
                e = a[i][1];
            }
        }
        r += e - s;
        
        System.out.println(r);
    }
}