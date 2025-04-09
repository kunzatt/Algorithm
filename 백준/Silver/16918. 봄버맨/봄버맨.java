import java.util.*;
import java.io.*;
class Main {
    static int R, C, N;
    static int[][] map;
    static char[][] ans;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        ans = new char[R][C];
        
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                if (str.charAt(j) == '.') {
                    map[i][j] = -1;
                } else if (str.charAt(j) == 'O') {
                    map[i][j] = 3;
                }
            }
        }
        
        if (N == 1) {
            printAnswer();
            return;
        }
        
        timegoes(map);
        
        int time = 2;
        while (time <= N) {
            if (time % 2 == 0) {
                fillmap(map);
            }
            
            timegoes(map);
            
            if (time % 2 == 1) {
                boolean[][] willExplode = new boolean[R][C];
                markExplosions(map, willExplode);
                bomb(map, willExplode);
            }
            
            time++;
        }
        
        printAnswer();
    }
    
    private static void printAnswer() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] >= 0) {
                    ans[i][j] = 'O';
                } else {
                    ans[i][j] = '.';
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
    
    private static void fillmap(int[][] map) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) {
                    map[i][j] = 3;
                }
            }
        }
    }
    
    private static void timegoes(int[][] map) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    map[i][j]--;
                }
            }
        }
    }
    
    private static void markExplosions(int[][] map, boolean[][] willExplode) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 0) {
                    willExplode[i][j] = true;
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        
                        if (check(nr, nc)) {
                            willExplode[nr][nc] = true;
                        }
                    }
                }
            }
        }
    }
    
    private static void bomb(int[][] map, boolean[][] willExplode) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (willExplode[i][j]) {
                    map[i][j] = -1;
                }
            }
        }
    }
    
    private static boolean check(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }
}