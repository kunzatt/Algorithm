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

        System.out.println(dfs(0, 0) ? "HaruHaru" : "Hing");
    }

    private static boolean dfs (int r, int c) {
        if (r == N - 1 && c == N - 1) {
            return true;
        }

        visited[r][c] = true;
        int num = map[r][c];

        for (int d = 0; d < 2; d++) {
            int nr = r + dr[d] * num;
            int nc = c + dc[d] * num;

            if (check(nr, nc) && !visited[nr][nc]) {
                if (dfs(nr, nc)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean check (int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}