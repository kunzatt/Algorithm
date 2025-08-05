import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        if (n == 1) {
            System.out.println(1);
            return;
        }
        
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int t = (a + b) % 15746;
            a = b;
            b = t;
        }
        
        System.out.println(b);
    }
}