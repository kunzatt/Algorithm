import java.io.*;
import java.util.*;

public class Main {
    static int[][] r;
    static int[][] g = {{0,1},{0,2},{0,3},{0,4},{0,5},{1,2},{1,3},{1,4},{1,5},{2,3},{2,4},{2,5},{3,4},{3,5},{4,5}};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for(int t = 0; t < 4; t++) {
            r = new int[6][3];
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int i = 0; i < 6; i++) {
                for(int j = 0; j < 3; j++) {
                    r[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            sb.append(dfs(0) ? "1 " : "0 ");
        }
        
        System.out.println(sb.toString().trim());
    }
    
    static boolean dfs(int m) {
        if(m == 15) {
            for(int i = 0; i < 6; i++) {
                for(int j = 0; j < 3; j++) {
                    if(r[i][j] != 0) return false;
                }
            }
            return true;
        }
        
        int a = g[m][0];
        int b = g[m][1];
        
        if(r[a][0] > 0 && r[b][2] > 0) {
            r[a][0]--; r[b][2]--;
            if(dfs(m + 1)) return true;
            r[a][0]++; r[b][2]++;
        }
        
        if(r[a][1] > 0 && r[b][1] > 0) {
            r[a][1]--; r[b][1]--;
            if(dfs(m + 1)) return true;
            r[a][1]++; r[b][1]++;
        }
        
        if(r[a][2] > 0 && r[b][0] > 0) {
            r[a][2]--; r[b][0]--;
            if(dfs(m + 1)) return true;
            r[a][2]++; r[b][0]++;
        }
        
        return false;
    }
}