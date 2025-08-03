import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] h = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            double slope = Double.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                double s = (double)(h[i] - h[j]) / (i - j);
                if (s < slope) {
                    cnt++;
                    slope = s;
                }
            }
            slope = -Double.MAX_VALUE;
            for (int j = i + 1; j < n; j++) {
                double s = (double)(h[i] - h[j]) / (i - j);
                if (s > slope) {
                    cnt++;
                    slope = s;
                }
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }
}