import java.io.*;
import java.util.*;

public class Main {
    static int r, c;
    static char[][] map;
    static int[][] fire;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        map = new char[r][c];
        fire = new int[r][c];
        
        Queue<int[]> fq = new LinkedList<>();
        int jx = 0, jy = 0;
        
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                fire[i][j] = -1;
                if (map[i][j] == 'F') {
                    fq.offer(new int[]{i, j, 0});
                    fire[i][j] = 0;
                } else if (map[i][j] == 'J') {
                    jx = i;
                    jy = j;
                }
            }
        }
        
        while (!fq.isEmpty()) {
            int[] cur = fq.poll();
            int x = cur[0], y = cur[1], t = cur[2];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < r && ny >= 0 && ny < c && map[nx][ny] != '#' && fire[nx][ny] == -1) {
                    fire[nx][ny] = t + 1;
                    fq.offer(new int[]{nx, ny, t + 1});
                }
            }
        }
        
        Queue<int[]> jq = new LinkedList<>();
        boolean[][] v = new boolean[r][c];
        jq.offer(new int[]{jx, jy, 0});
        v[jx][jy] = true;
        
        while (!jq.isEmpty()) {
            int[] cur = jq.poll();
            int x = cur[0], y = cur[1], t = cur[2];
            
            if (x == 0 || x == r - 1 || y == 0 || y == c - 1) {
                System.out.println(t + 1);
                return;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < r && ny >= 0 && ny < c && !v[nx][ny] && map[nx][ny] != '#' && (fire[nx][ny] == -1 || fire[nx][ny] > t + 1)) {
                    v[nx][ny] = true;
                    jq.offer(new int[]{nx, ny, t + 1});
                }
            }
        }
        
        System.out.println("IMPOSSIBLE");
    }
}