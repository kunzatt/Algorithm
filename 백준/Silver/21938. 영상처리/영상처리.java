import java.util.*;

public class Main {
    static int n, m, t;
    static int[][] a;
    static boolean[][] v;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        v = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int r = sc.nextInt();
                int g = sc.nextInt();
                int b = sc.nextInt();
                a[i][j] = (r + g + b) / 3;
            }
        }
        
        t = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] >= t) a[i][j] = 255;
                else a[i][j] = 0;
            }
        }
        
        int c = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 255 && !v[i][j]) {
                    dfs(i, j);
                    c++;
                }
            }
        }
        
        System.out.println(c);
    }
    
    static void dfs(int x, int y) {
        v[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !v[nx][ny] && a[nx][ny] == 255) {
                dfs(nx, ny);
            }
        }
    }
}