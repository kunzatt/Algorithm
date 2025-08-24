import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] map = new int[2][100000];
    static boolean[][] visit = new boolean[2][100000];
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < 2; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        
        System.out.println(bfs());
    }
    
    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        visit[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int t = cur[2];
            
            if (t >= N) break;
            
            for (int i = 0; i < 2; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (ny >= N) return 1;
                
                if (nx >= 0 && ny > t && nx < 2 && ny < N) {
                    if (map[nx][ny] == 1 && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        q.offer(new int[]{nx, ny, t + 1});
                    }
                }
            }
            
            for (int i = 2; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i] + K;
                
                if (ny >= N) return 1;
                
                if (nx >= 0 && ny > t && nx < 2 && ny < N) {
                    if (map[nx][ny] == 1 && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        q.offer(new int[]{nx, ny, t + 1});
                    }
                }
            }
        }
        
        return 0;
    }
}