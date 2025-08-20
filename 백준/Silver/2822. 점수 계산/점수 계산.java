import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[][] a = new int[8][2];
        
        for (int i = 0; i < 8; i++) {
            a[i][0] = Integer.parseInt(br.readLine());
            a[i][1] = i + 1;
        }
        
        Arrays.sort(a, (x, y) -> y[0] - x[0]);
        
        int s = 0;
        int[] p = new int[5];
        
        for (int i = 0; i < 5; i++) {
            s += a[i][0];
            p[i] = a[i][1];
        }
        
        Arrays.sort(p);
        
        System.out.println(s);
        for (int i = 0; i < 5; i++) {
            System.out.print(p[i]);
            if (i < 4) System.out.print(" ");
        }
    }
}