import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        
        int[][] s = new int[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            s[i][0] = Integer.parseInt(st.nextToken());
            s[i][1] = Integer.parseInt(st.nextToken());
        }
        
        int max = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int r1 = s[i][0], c1 = s[i][1];
                int r2 = s[j][0], c2 = s[j][1];
                
                int area = r1 * c1 + r2 * c2;
                
                if(check(h, w, r1, c1, r2, c2) ||
                   check(h, w, r1, c1, c2, r2) ||
                   check(h, w, c1, r1, r2, c2) ||
                   check(h, w, c1, r1, c2, r2)) {
                    max = Math.max(max, area);
                }
            }
        }
        
        System.out.println(max);
    }
    
    static boolean check(int h, int w, int r1, int c1, int r2, int c2) {
        return (r1 + r2 <= h && Math.max(c1, c2) <= w) ||
               (Math.max(r1, r2) <= h && c1 + c2 <= w);
    }
}