import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] r = new int[n];
        
        for(int i = 0; i < n; i++) {
            int c = 0;
            for(int j = 0; j < n; j++) {
                if(c == a[i] && r[j] == 0) {
                    r[j] = i + 1;
                    break;
                }
                if(r[j] == 0) c++;
            }
        }
        
        for(int i = 0; i < n; i++) {
            System.out.print(r[i] + " ");
        }
    }
}