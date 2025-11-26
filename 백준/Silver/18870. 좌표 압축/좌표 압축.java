import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        
        int[] t = a.clone();
        Arrays.sort(a);
        
        HashMap<Integer, Integer> m = new HashMap<>();
        int c = 0;
        for(int i = 0; i < n; i++) {
            if(!m.containsKey(a[i])) {
                m.put(a[i], c++);
            }
        }
        
        for(int i = 0; i < n; i++) {
            sb.append(m.get(t[i])).append(" ");
        }
        
        System.out.println(sb.toString());
    }
}