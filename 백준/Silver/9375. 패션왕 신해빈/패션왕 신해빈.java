import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> m = new HashMap<>();
            
            for(int i = 0; i < n; i++) {
                String[] s = br.readLine().split(" ");
                m.put(s[1], m.getOrDefault(s[1], 0) + 1);
            }
            
            int r = 1;
            for(int v : m.values()) {
                r *= (v + 1);
            }
            
            System.out.println(r - 1);
        }
    }
}