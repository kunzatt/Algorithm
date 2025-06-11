import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] mul(int[][] a, int[][] b) {
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    c[i][j] = (c[i][j] + a[i][k] * b[k][j]) % 1000;
                }
            }
        }
        return c;
    }
    
    static int[][] pow(int[][] a, long b) {
        if (b == 1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] %= 1000;
                }
            }
            return a;
        }
        
        int[][] temp = pow(a, b / 2);
        temp = mul(temp, temp);
        
        if (b % 2 == 1) {
            temp = mul(temp, a);
        }
        
        return temp;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] result = pow(a, b);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
}