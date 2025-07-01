import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        
        int[] s = new int[m + 2];
        s[0] = 0;
        s[m + 1] = l;
        
        for (int i = 1; i <= m; i++) {
            s[i] = Integer.parseInt(br.readLine());
        }
        
        for (int i = 0; i < n; i++) {
            int q = Integer.parseInt(br.readLine());
            
            int left = 0;
            int right = l;
            int ans = 0;
            
            while (left <= right) {
                int mid = (left + right) / 2;
                
                if (check(s, m, mid, q)) {
                    ans = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            
            System.out.println(ans);
        }
    }
    
    static boolean check(int[] s, int m, int len, int cuts) {
        int cnt = 0;
        int prev = s[0];
        
        for (int i = 1; i <= m + 1; i++) {
            if (s[i] - prev >= len) {
                prev = s[i];
                cnt++;
            }
        }
        
        return cnt > cuts;
    }
}