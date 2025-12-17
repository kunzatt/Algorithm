import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        int c0 = 0, c1 = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') c0++;
            else c1++;
        }
        
        boolean[] r = new boolean[s.length()];
        int r0 = c0 / 2, r1 = c1 / 2;
        
        for (int i = 0; i < s.length() && r1 > 0; i++) {
            if (s.charAt(i) == '1') {
                r[i] = true;
                r1--;
            }
        }
        
        for (int i = s.length() - 1; i >= 0 && r0 > 0; i--) {
            if (s.charAt(i) == '0') {
                r[i] = true;
                r0--;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!r[i]) {
                sb.append(s.charAt(i));
            }
        }
        
        System.out.println(sb.toString());
    }
}