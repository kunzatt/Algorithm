import java.util.*;
import java.io.*;

class Main {

    static int N;
    static int[][] map;
    static int[] dr = {0, 1};
    static int[] dc = {1, 0};
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(0, 0) ? "HaruHaru" : "Hing");
    }

    private static boolean bfs (int r, int c) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {r, c});
        visited[r][c] = true;

        while (!que.isEmpty()) {
            int[] temp = que.poll();
            int num = map[temp[0]][temp[1]];

            for (int d = 0; d < 2; d++) {
                int nr = temp[0] + dr[d] * num;
                int nc = temp[1] + dc[d] * num;

                if (nr == N - 1 && nc == N - 1) {
                    return true;
                }
                if (!check(nr, nc) || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                que.add(new int[] {nr, nc});
            }
        }

        return false;

    } 

    private static boolean check (int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}