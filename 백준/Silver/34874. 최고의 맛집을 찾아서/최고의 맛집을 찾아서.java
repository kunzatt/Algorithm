import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] a = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[] max = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                max[i] = Math.max(max[i], a[i][j]);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int j = 0; j < m; j++) {
            int cnt = 0;
            for(int i = 0; i < n; i++) {
                if(a[i][j] < max[i]) {
                    cnt++;
                }
            }
            sb.append(cnt);
            if(j < m - 1) sb.append(" ");
        }
        
        System.out.println(sb);
    }
}