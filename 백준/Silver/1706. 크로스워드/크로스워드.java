import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] a = new char[r][c];
        
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                a[i][j] = s.charAt(j);
            }
        }
        
        String min = "{";
        
        for (int i = 0; i < r; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j <= c; j++) {
                if (j == c || a[i][j] == '#') {
                    String t = sb.toString();
                    if (t.length() >= 2 && min.compareTo(t) > 0)
                        min = t;
                    sb = new StringBuilder();
                } else {
                    sb.append(a[i][j]);
                }
            }
        }
        
        for (int j = 0; j < c; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= r; i++) {
                if (i == r || a[i][j] == '#') {
                    String t = sb.toString();
                    if (t.length() >= 2 && min.compareTo(t) > 0)
                        min = t;
                    sb = new StringBuilder();
                } else {
                    sb.append(a[i][j]);
                }
            }
        }
        
        System.out.println(min);
    }
}