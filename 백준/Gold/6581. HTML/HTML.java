import java.util.*;
import java.io.*;

public class Main {
    
    static int idx = 0;
    static StringBuilder sb = new StringBuilder();
    
    private static void br() {
        sb.append('\n');
        idx = 0;
    }
    
    private static void hr() {
        if (idx != 0) br();
        for (int i = 0; i < 80; i++) sb.append('-');
        sb.append('\n');
        idx = 0;
    }
    
    public static void main(String[] args) throws Exception {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        ArrayList<String> arr = new ArrayList<>();
        while ((s = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s, " \t\n");
            while (st.hasMoreTokens())
                arr.add(st.nextToken());
        }
        for (String cur : arr) {
            if (cur.equals("<br>")) {
                br();
                continue;
            }
            if (cur.equals("<hr>")) {
                hr();
                continue;
            }
            if (idx + cur.length() + (idx == 0 ? 0: 1) > 80) {
                idx = 0;
                br();
            }
            if (idx != 0) sb.append(' ');
            sb.append(cur);
            idx += cur.length() + (idx == 0 ? 0: 1);
        }
        br();
        System.out.print(sb);
    }
}