import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int u = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        Map<Integer, List<String>> m = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int p = Integer.parseInt(st.nextToken());
            
            if (p <= u) {
                m.putIfAbsent(p, new ArrayList<>());
                m.get(p).add(s);
            }
        }
        
        int min = m.values().stream().mapToInt(List::size).min().orElse(0);
        int key = m.keySet().stream().filter(k -> m.get(k).size() == min).min(Integer::compareTo).orElse(0);
        
        System.out.println(m.get(key).get(0) + " " + key);
    }
}