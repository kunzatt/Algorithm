import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringBuilder sb = new StringBuilder();
            String str = br.readLine();
            char[] ch = str.toCharArray();
            int n = (int) Math.sqrt(str.length());
            char[][] map = new char[n][n];
            int temp = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = ch[temp++];
                }
            }
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    sb.append(map[j][i]);
                }
            }
            System.out.println(sb.toString());
        }

    }
}