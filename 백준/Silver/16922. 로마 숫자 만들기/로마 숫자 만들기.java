import java.io.*;

public class Main {
    static int n;
    static int[] v = {1, 5, 10, 50};
    static boolean[] c = new boolean[1001];
    static int a = 0;
    
    static void f(int d, int s, int st) {
        if (d == n) {
            if (!c[s]) {
                c[s] = true;
                a++;
            }
            return;
        }
        for (int i = st; i < 4; i++) {
            f(d + 1, s + v[i], i);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        f(0, 0, 0);
        System.out.println(a);
    }
}