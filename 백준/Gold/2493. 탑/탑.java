import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        Stack<int[]> s = new Stack<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int h = Integer.parseInt(st.nextToken());
            
            while (!s.isEmpty() && s.peek()[1] < h) {
                s.pop();
            }
            
            if (s.isEmpty()) {
                sb.append("0 ");
            } else {
                sb.append(s.peek()[0]).append(" ");
            }
            
            s.push(new int[]{i, h});
        }
        
        System.out.println(sb);
    }
}