import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        if (n == 0) {
            System.out.println(0);
            return;
        }
        
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(a);
        
        int c = (int) Math.round(n * 0.15);
        int s = 0;
        
        for (int i = c; i < n - c; i++) {
            s += a[i];
        }
        
        System.out.println(Math.round((double) s / (n - c * 2)));
    }
}