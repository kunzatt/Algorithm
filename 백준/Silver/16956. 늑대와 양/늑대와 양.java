import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        char[][] g = new char[r][c];
        for (int i = 0; i < r; i++) {
            g[i] = br.readLine().toCharArray();
        }
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        boolean ok = true;
        for (int i = 0; i < r && ok; i++) {
            for (int j = 0; j < c && ok; j++) {
                if (g[i][j] == 'W') {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                            if (g[nx][ny] == 'S') {
                                ok = false;
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        if (!ok) {
            System.out.println(0);
        } else {
            System.out.println(1);
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (g[i][j] == '.') {
                        g[i][j] = 'D';
                    }
                    System.out.print(g[i][j]);
                }
                System.out.println();
            }
        }
    }
}