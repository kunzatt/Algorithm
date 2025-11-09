import java.io.*;
import java.util.*;

public class Main {
    static int[][][] a, b;
    static boolean[][][] v;
    static int[] p;
    static boolean[] u;
    static int r = Integer.MAX_VALUE;
    static int[] dx = {-1,0,1,0,0,0};
    static int[] dy = {0,1,0,-1,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = new int[5][5][5];
        p = new int[5];
        u = new boolean[5];
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 5; k++) {
                    a[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        
        f(0);
        System.out.println(r == Integer.MAX_VALUE ? -1 : r);
    }
    
    static void f(int c) {
        if (c == 5) {
            b = new int[5][5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        b[i][j][k] = a[p[i]][j][k];
                    }
                }
            }
            g(0);
            return;
        }
        
        for (int i = 0; i < 5; i++) {
            if (!u[i]) {
                p[c] = i;
                u[i] = true;
                f(c + 1);
                u[i] = false;
            }
        }
    }
    
    static void g(int h) {
        if (h == 5) {
            r = Math.min(r, bfs());
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            rot(h);
            g(h + 1);
        }
    }
    
    static void rot(int z) {
        int[][] t = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                t[j][4-i] = b[z][i][j];
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                b[z][i][j] = t[i][j];
            }
        }
    }
    
    static int bfs() {
        if (b[0][0][0] != 1 || b[4][4][4] != 1) return Integer.MAX_VALUE;
        
        Queue<int[]> q = new ArrayDeque<>();
        v = new boolean[5][5][5];
        q.offer(new int[]{0,0,0,0});
        v[0][0][0] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], z = cur[2], d = cur[3];
            
            if (x == 4 && y == 4 && z == 4) return d;
            
            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];
                
                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && nz >= 0 && nz < 5
                    && b[nz][nx][ny] == 1 && !v[nz][nx][ny]) {
                    v[nz][nx][ny] = true;
                    q.offer(new int[]{nx,ny,nz,d+1});
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}