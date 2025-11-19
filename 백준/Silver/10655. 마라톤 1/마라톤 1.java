import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] p = new int[n][2];
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            p[i][0] = Integer.parseInt(st.nextToken());
            p[i][1] = Integer.parseInt(st.nextToken());
        }
        
        int total = 0;
        for(int i = 1; i < n; i++) {
            total += Math.abs(p[i-1][0] - p[i][0]) + Math.abs(p[i-1][1] - p[i][1]);
        }
        
        int max = 0;
        for(int i = 1; i < n-1; i++) {
            int save = Math.abs(p[i-1][0] - p[i][0]) + Math.abs(p[i-1][1] - p[i][1]) + 
                      Math.abs(p[i][0] - p[i+1][0]) + Math.abs(p[i][1] - p[i+1][1]) -
                      Math.abs(p[i-1][0] - p[i+1][0]) - Math.abs(p[i-1][1] - p[i+1][1]);
            max = Math.max(max, save);
        }
        
        System.out.println(total - max);
    }
}