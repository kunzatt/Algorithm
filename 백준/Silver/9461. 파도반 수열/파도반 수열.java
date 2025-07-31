import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        long[] p = new long[101];
        p[1] = p[2] = p[3] = 1;
        p[4] = p[5] = 2;
        
        for (int i = 6; i <= 100; i++) {
            p[i] = p[i-1] + p[i-5];
        }
        
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(p[n]);
        }
    }
}