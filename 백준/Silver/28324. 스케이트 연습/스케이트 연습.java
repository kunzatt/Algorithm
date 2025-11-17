import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int s = 0;
        long t = 0;
        
        for(int i = n-1; i >= 0; i--) {
            if(s < a[i]) {
                s++;
            } else {
                s = a[i];
            }
            t += s;
        }
        
        System.out.println(t);
    }
}