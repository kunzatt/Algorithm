import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Map<String, Integer> m = new TreeMap<>();
        
        for (int i = 0; i < n; i++) {
            String f = br.readLine();
            String e = f.substring(f.lastIndexOf('.') + 1);
            m.put(e, m.getOrDefault(e, 0) + 1);
        }
        
        for (Map.Entry<String, Integer> entry : m.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}