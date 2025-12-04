import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] a;
    static int[][] memo;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        if (solve(0, n - 1)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
    
    static boolean solve(int l, int r) {
        if (l > r) return true;
        if (memo[l][r] != -1) return memo[l][r] == 1;
        
        int sum = 0;
        for (int i = l; i <= r; i++) {
            sum += a[i];
        }
        
        if (sum == 3) {
            memo[l][r] = 1;
            return true;
        }
        
        for (int k = l; k < r; k++) {
            if (solve(l, k) && solve(k + 1, r)) {
                memo[l][r] = 1;
                return true;
            }
        }
        
        memo[l][r] = 0;
        return false;
    }
}