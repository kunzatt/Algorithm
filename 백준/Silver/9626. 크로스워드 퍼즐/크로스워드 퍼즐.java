import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        int u = Integer.parseInt(s[0]);
        int l = Integer.parseInt(s[1]);
        int r = Integer.parseInt(s[2]);
        int d = Integer.parseInt(s[3]);
        
        char[][] p = new char[m][n];
        for(int i = 0; i < m; i++) {
            p[i] = br.readLine().toCharArray();
        }
        
        int h = u + m + d;
        int w = l + n + r;
        
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(i >= u && i < u + m && j >= l && j < l + n) {
                    System.out.print(p[i - u][j - l]);
                } else {
                    System.out.print((i + j) % 2 == 0 ? '#' : '.');
                }
            }
            System.out.println();
        }
    }
}