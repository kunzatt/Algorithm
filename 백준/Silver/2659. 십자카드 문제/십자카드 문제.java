import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] a = new int[4];
        for (int i = 0; i < 4; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        int n = f(a);
        boolean[] c = new boolean[10000];
        
        for (int i = 1111; i <= 9999; i++) {
            if (String.valueOf(i).contains("0")) {
                continue;
            }
            int[] d = new int[4];
            int x = i;
            for (int j = 3; j >= 0; j--) {
                d[j] = x % 10;
                x /= 10;
            }
            int m = f(d);
            c[m] = true;
        }
        
        int cnt = 1;
        for (int i = 1111; i < n; i++) {
            if (c[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    
    static int f(int[] a) {
        int m = 9999;
        for (int i = 0; i < 4; i++) {
            int r = 0;
            for (int j = 0; j < 4; j++) {
                r = r * 10 + a[(i + j) % 4];
            }
            if (r < m) {
                m = r;
            }
        }
        return m;
    }
}