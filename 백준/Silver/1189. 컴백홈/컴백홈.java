import java.io.*;
import java.util.*;

public class Main {
    static int r, c, k;
    static char[][] m;
    static boolean[][] v;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int ans = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        m = new char[r][c];
        v = new boolean[r][c];
        
        for (int i = 0; i < r; i++) {
            m[i] = br.readLine().toCharArray();
        }
        
        v[r-1][0] = true;
        dfs(r-1, 0, 1);
        
        System.out.println(ans);
    }
    
    static void dfs(int x, int y, int d) {
        if (x == 0 && y == c-1) {
            if (d == k) ans++;
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < r && ny >= 0 && ny < c && 
                !v[nx][ny] && m[nx][ny] == '.') {
                v[nx][ny] = true;
                dfs(nx, ny, d + 1);
                v[nx][ny] = false;
            }
        }
    }
}