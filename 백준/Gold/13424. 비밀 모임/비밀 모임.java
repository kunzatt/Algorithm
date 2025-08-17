import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 987654321;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            int[][] d = new int[n+1][n+1];
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(i == j) d[i][j] = 0;
                    else d[i][j] = INF;
                }
            }
            
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                d[a][b] = c;
                d[b][a] = c;
            }
            
            for(int k = 1; k <= n; k++) {
                for(int i = 1; i <= n; i++) {
                    for(int j = 1; j <= n; j++) {
                        if(d[i][k] != INF && d[k][j] != INF) {
                            d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                        }
                    }
                }
            }
            
            int k = Integer.parseInt(br.readLine());
            int[] f = new int[k];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < k; i++) {
                f[i] = Integer.parseInt(st.nextToken());
            }
            
            int min = INF;
            int ans = 0;
            for(int i = 1; i <= n; i++) {
                int sum = 0;
                for(int j = 0; j < k; j++) {
                    sum += d[f[j]][i];
                }
                if(sum < min) {
                    min = sum;
                    ans = i;
                }
            }
            
            System.out.println(ans);
        }
    }
}