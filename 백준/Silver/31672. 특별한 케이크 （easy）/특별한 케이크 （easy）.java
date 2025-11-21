import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        br.readLine();
        int n = Integer.parseInt(br.readLine());
        
        boolean[][] c = new boolean[n][n];
        int[] s = new int[n];
        int cnt = 0;
        
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] students = new int[m];
            for (int j = 0; j < m; j++) {
                students[j] = Integer.parseInt(st.nextToken());
            }
            int b = Integer.parseInt(br.readLine());
            
            if (b == 1) {
                for (int student : students) {
                    c[i][student - 1] = true;
                }
            } else {
                for (int j = 0; j < n; j++) {
                    c[i][j] = true;
                }
                for (int student : students) {
                    c[i][student - 1] = false;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (c[j][i]) {
                        s[i]++;
                    }
                } else {
                    if (!c[j][i]) {
                        s[i]++;
                    }
                }
            }
            if (s[i] == n) {
                cnt++;
            }
        }
        
        if (cnt == 0) {
            System.out.println("swi");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (s[i] == n) {
                    if (sb.length() > 0) sb.append(" ");
                    sb.append(i + 1);
                }
            }
            System.out.println(sb.toString());
        }
    }
}