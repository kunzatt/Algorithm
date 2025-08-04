import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] a = new int[101][101];
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            for(int x = x1; x <= x2; x++) {
                for(int y = y1; y <= y2; y++) {
                    a[x][y]++;
                }
            }
        }
        
        int c = 0;
        for(int i = 1; i <= 100; i++) {
            for(int j = 1; j <= 100; j++) {
                if(a[i][j] > m) c++;
            }
        }
        
        System.out.println(c);
    }
}