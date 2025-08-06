import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            
            for (int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(a);
            
            int mx = a[n - 1];
            int mn = a[0];
            int gap = 0;
            
            for (int j = 1; j < n; j++) {
                gap = Math.max(gap, a[j] - a[j - 1]);
            }
            
            System.out.println("Class " + i);
            System.out.println("Max " + mx + ", Min " + mn + ", Largest gap " + gap);
        }
    }
}