import java.util.*;
import java.io.*;

class Main {

    static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {            
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            if (R == 0 && C == 0) break;
            char[][] map = new char[R][C];
            char[][] ans = new char[R][C];
            for (int i = 0; i < R; i++) {
                map[i] = br.readLine().toCharArray();
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == '*') {
                        ans[i][j] = '*';
                    } else {
                        int count = 0;
                        for (int d = 0; d < 8; d++) {
                            int nr = i + dr[d];
                            int nc = j + dc[d];

                            if (!check(nr, nc, R, C)) continue;
                            if (map[nr][nc] == '*') count++;
                        }
                        ans[i][j] = (char)(count + '0');                        
                    }
                }
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print(ans[i][j]);
                }
                System.out.println();
            }
        }
    }

    private static boolean check (int r, int c, int R, int C) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }
}