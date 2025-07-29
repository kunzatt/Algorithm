import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] c = new int[n+1];
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x <= n) c[x]++;
        }
        
        int ans = -1;
        for (int i = 0; i <= n; i++) {
            if (c[i] == i) ans = i;
        }
        
        System.out.println(ans);
    }
}