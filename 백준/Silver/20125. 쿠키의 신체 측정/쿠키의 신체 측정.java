import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        int hx = -1, hy = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '*') {
                    hx = i + 1;
                    hy = j;
                    break;
                }
            }
            if (hx != -1) break;
        }
        
        int la = 0, ra = 0, w = 0, ll = 0, rl = 0;
        
        for (int i = hy - 1; i >= 0; i--) {
            if (map[hx][i] == '*') la++;
            else break;
        }
        
        for (int i = hy + 1; i < n; i++) {
            if (map[hx][i] == '*') ra++;
            else break;
        }
        
        int wx = hx;
        for (int i = hx + 1; i < n; i++) {
            if (map[i][hy] == '*') {
                w++;
                wx = i;
            } else break;
        }
        
        for (int i = wx + 1; i < n; i++) {
            if (map[i][hy - 1] == '*') ll++;
            else break;
        }
        
        for (int i = wx + 1; i < n; i++) {
            if (map[i][hy + 1] == '*') rl++;
            else break;
        }
        
        System.out.println((hx + 1) + " " + (hy + 1));
        System.out.println(la + " " + ra + " " + w + " " + ll + " " + rl);
    }
}