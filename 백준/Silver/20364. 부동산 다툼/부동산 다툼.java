import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        
        boolean[] v = new boolean[n + 1];
        
        for (int i = 0; i < q; i++) {
            int x = Integer.parseInt(br.readLine());
            int t = x;
            int r = 0;
            
            while (t > 0) {
                if (v[t]) {
                    r = t;
                }
                t /= 2;
            }
            
            if (r == 0) {
                v[x] = true;
            }
            
            System.out.println(r);
        }
    }
}