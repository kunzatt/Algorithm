import java.io.*;

public class Main {
    static int n;
    static char[][] g;
    static boolean[][] v;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    static void dfs(int x, int y) {
        v[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !v[nx][ny] && g[nx][ny] == g[x][y]) {
                dfs(nx, ny);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        g = new char[n][n];
        v = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            g[i] = br.readLine().toCharArray();
        }
        
        int c1 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!v[i][j]) {
                    dfs(i, j);
                    c1++;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 'G') g[i][j] = 'R';
                v[i][j] = false;
            }
        }
        
        int c2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!v[i][j]) {
                    dfs(i, j);
                    c2++;
                }
            }
        }
        
        System.out.println(c1 + " " + c2);
    }
}