import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] max = new int[3];
        int[] min = new int[3];
        
        max[0] = min[0] = Integer.parseInt(st.nextToken());
        max[1] = min[1] = Integer.parseInt(st.nextToken());
        max[2] = min[2] = Integer.parseInt(st.nextToken());
        
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            int t0 = max[0], t1 = max[1], t2 = max[2];
            max[0] = Math.max(t0, t1) + a;
            max[1] = Math.max(Math.max(t0, t1), t2) + b;
            max[2] = Math.max(t1, t2) + c;
            
            t0 = min[0]; t1 = min[1]; t2 = min[2];
            min[0] = Math.min(t0, t1) + a;
            min[1] = Math.min(Math.min(t0, t1), t2) + b;
            min[2] = Math.min(t1, t2) + c;
        }
        
        int maxVal = Math.max(Math.max(max[0], max[1]), max[2]);
        int minVal = Math.min(Math.min(min[0], min[1]), min[2]);
        
        System.out.println(maxVal + " " + minVal);
    }
}