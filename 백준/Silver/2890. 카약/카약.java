import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);
        
        int[] r = new int[10];
        int c = 1;
        boolean f = false;
        String[] v = new String[R];
        
        for (int i = 0; i < R; i++) {
            v[i] = br.readLine();
        }
        
        for (int i = C - 2; i >= 1; i--) {
            for (int j = 0; j < R; j++) {
                char ch = v[j].charAt(i);
                if (ch >= '0' && ch <= '9') {
                    int k = ch - '0';
                    if (r[k] == 0 && k > 0 && k <= 9) {
                        r[k] = c;
                        f = true;
                    }
                }
            }
            if (f) c++;
            f = false;
        }
        
        for (int i = 1; i <= 9; i++) {
            System.out.println(r[i]);
        }
        
    }
}