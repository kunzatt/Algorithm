import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10164 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        
        int num = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = num++;
            }
        }
        
        int r = 0;
        int c = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == K) {
                    r = i;
                    c = j;
                }
            }
        }
        
        int ans = 0;
        if (K == 0) {
            ans = sol(map, N, M);
        } else {
            int[][] fdp = new int[r + 1][c + 1];
            int[][] sdp = new int[N - r][M - c];
            ans = sol(fdp, r + 1, c + 1) * sol(sdp, N - r, M - c);
        }
        
        System.out.println(ans);
    }
    
    private static int sol(int[][] map, int r, int c) {
        
        map[0][0] = 1;
        for (int i = 1; i < r; i++) {
            map[i][0] = 1;
        }
        for (int i = 1; i < c; i++) {
            map[0][i] = 1;
        }
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }
        
        return map[r - 1][c - 1];
        
    }
}
