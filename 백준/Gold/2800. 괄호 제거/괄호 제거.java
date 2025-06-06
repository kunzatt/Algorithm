import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        Stack<Integer> st = new Stack<>();
        List<int[]> p = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else if (s.charAt(i) == ')') {
                p.add(new int[]{st.pop(), i});
            }
        }
        
        Set<String> r = new TreeSet<>();
        
        for (int m = 1; m < (1 << p.size()); m++) {
            boolean[] rm = new boolean[s.length()];
            
            for (int i = 0; i < p.size(); i++) {
                if ((m & (1 << i)) != 0) {
                    rm[p.get(i)[0]] = true;
                    rm[p.get(i)[1]] = true;
                }
            }
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (!rm[i]) {
                    sb.append(s.charAt(i));
                }
            }
            
            r.add(sb.toString());
        }
        
        StringBuilder sb = new StringBuilder();
        for (String str : r) {
            sb.append(str).append('\n');
        }
        System.out.print(sb);
    }
}