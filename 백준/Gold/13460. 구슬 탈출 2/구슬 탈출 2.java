import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] b;
    static boolean[][][][] v;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static class State {
        int rx, ry, bx, by, cnt;
        State(int rx, int ry, int bx, int by, int cnt) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.cnt = cnt;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        b = new char[n][m];
        v = new boolean[n][m][n][m];
        int rx = 0, ry = 0, bx = 0, by = 0;
        
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++) {
                b[i][j] = line.charAt(j);
                if(b[i][j] == 'R') {
                    rx = i; ry = j;
                    b[i][j] = '.';
                } else if(b[i][j] == 'B') {
                    bx = i; by = j;
                    b[i][j] = '.';
                }
            }
        }
        
        System.out.println(bfs(rx, ry, bx, by));
    }
    
    static int bfs(int rx, int ry, int bx, int by) {
        Queue<State> q = new LinkedList<>();
        q.offer(new State(rx, ry, bx, by, 0));
        v[rx][ry][bx][by] = true;
        
        while(!q.isEmpty()) {
            State cur = q.poll();
            
            if(cur.cnt >= 10) return -1;
            
            for(int d = 0; d < 4; d++) {
                int nrx = cur.rx, nry = cur.ry;
                int nbx = cur.bx, nby = cur.by;
                int rc = 0, bc = 0;
                
                while(b[nrx + dx[d]][nry + dy[d]] != '#' && b[nrx][nry] != 'O') {
                    nrx += dx[d];
                    nry += dy[d];
                    rc++;
                }
                
                while(b[nbx + dx[d]][nby + dy[d]] != '#' && b[nbx][nby] != 'O') {
                    nbx += dx[d];
                    nby += dy[d];
                    bc++;
                }
                
                if(b[nbx][nby] == 'O') continue;
                if(b[nrx][nry] == 'O') return cur.cnt + 1;
                
                if(nrx == nbx && nry == nby) {
                    if(rc > bc) {
                        nrx -= dx[d];
                        nry -= dy[d];
                    } else {
                        nbx -= dx[d];
                        nby -= dy[d];
                    }
                }
                
                if(!v[nrx][nry][nbx][nby]) {
                    v[nrx][nry][nbx][nby] = true;
                    q.offer(new State(nrx, nry, nbx, nby, cur.cnt + 1));
                }
            }
        }
        
        return -1;
    }
}