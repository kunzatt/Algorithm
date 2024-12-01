import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5656_D4 {
    
    static int N, W, H, min;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            map = new int[H][W];
            min = Integer.MAX_VALUE;
            
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            solve(N, copyMap(map));
            
            System.out.println("#" + t + " " + min);
        }
    }
    
    private static int[][] copyMap(int[][] original) {
        int[][] copy = new int[H][W];
        for (int i = 0; i < H; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }
    
    private static void solve(int cnt, int[][] currentMap) {
        if (cnt == 0) {
            int count = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (currentMap[i][j] != 0) count++;
                }
            }
            min = Math.min(min, count);
            return;
        }
        
        for (int col = 0; col < W; col++) {
            int[][] copyMap = copyMap(currentMap);
            ballBreak(col, copyMap);
            dropBlocks(copyMap);
            solve(cnt - 1, copyMap);
        }
    }
    
    private static void ballBreak(int col, int[][] currentMap) {
        for (int row = 0; row < H; row++) {
            if (currentMap[row][col] > 0) {
                breakBlock(row, col, currentMap[row][col], currentMap);
                break;
            }
        }
    }
    
    private static void breakBlock(int r, int c, int power, int[][] currentMap) {
        currentMap[r][c] = 0;
        
        for (int d = 0; d < 4; d++) {
            for (int k = 1; k < power; k++) {
                int nr = r + dr[d] * k;
                int nc = c + dc[d] * k;
                
                if (nr >= 0 && nr < H && nc >= 0 && nc < W && currentMap[nr][nc] > 0) {
                    breakBlock(nr, nc, currentMap[nr][nc], currentMap);
                }
            }
        }
    }
    
    private static void dropBlocks(int[][] currentMap) {
        for (int col = 0; col < W; col++) {
            for (int row = H-1; row >= 0; row--) {
                if (currentMap[row][col] == 0) {
                    int nrow = row - 1;
                    while (nrow >= 0) {
                        if (currentMap[nrow][col] > 0) {
                            currentMap[row][col] = currentMap[nrow][col];
                            currentMap[nrow][col] = 0;
                            break;
                        }
                        nrow--;
                    }
                }
            }
        }
    }
}