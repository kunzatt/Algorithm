import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        String[] mine = new String[n];
        String[] game = new String[n];
        
        for (int i = 0; i < n; i++) {
            mine[i] = br.readLine();
        }
        
        for (int i = 0; i < n; i++) {
            game[i] = br.readLine();
        }
        
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        char[][] result = new char[n][n];
        boolean boom = false;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (game[i].charAt(j) == 'x') {
                    if (mine[i].charAt(j) == '*') {
                        boom = true;
                        result[i][j] = '*';
                    } else {
                        int cnt = 0;
                        for (int k = 0; k < 8; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                if (mine[nx].charAt(ny) == '*') {
                                    cnt++;
                                }
                            }
                        }
                        result[i][j] = (char)(cnt + '0');
                    }
                } else {
                    result[i][j] = '.';
                }
            }
        }
        
        if (boom) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mine[i].charAt(j) == '*') {
                        result[i][j] = '*';
                    }
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            System.out.println(new String(result[i]));
        }
    }
}