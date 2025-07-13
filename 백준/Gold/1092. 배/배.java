import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Integer[] c = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }
        
        int m = Integer.parseInt(br.readLine());
        List<Integer> b = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b.add(Integer.parseInt(st.nextToken()));
        }
        
        Arrays.sort(c, Collections.reverseOrder());
        Collections.sort(b, Collections.reverseOrder());
        
        if (b.get(0) > c[0]) {
            System.out.println(-1);
            return;
        }
        
        int t = 0;
        while (!b.isEmpty()) {
            t++;
            int idx = 0;
            int temp = 0;
            while (idx < n) {
                if (temp == b.size()) break;
                if (b.get(temp) <= c[idx]) {
                    b.remove(temp);
                    idx++;
                } else {
                    temp++;
                }
            }
        }
        
        System.out.println(t);
    }
}