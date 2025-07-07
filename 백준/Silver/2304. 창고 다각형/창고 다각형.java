import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(a, (x, y) -> x[0] - y[0]);
        
        int m = 0, mi = 0;
        for (int i = 0; i < n; i++) {
            if (a[i][1] > m) {
                m = a[i][1];
                mi = i;
            }
        }
        
        int s = 0;
        
        int h = a[0][1];
        for (int i = 0; i < mi; i++) {
            s += h * (a[i+1][0] - a[i][0]);
            h = Math.max(h, a[i+1][1]);
        }
        
        s += m;
        
        h = a[n-1][1];
        for (int i = n-1; i > mi; i--) {
            s += h * (a[i][0] - a[i-1][0]);
            h = Math.max(h, a[i-1][1]);
        }
        
        System.out.println(s);
    }
}