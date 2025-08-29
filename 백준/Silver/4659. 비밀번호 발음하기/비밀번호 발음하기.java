import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            String s = br.readLine();
            if (s.equals("end")) break;
            
            if (check(s)) {
                System.out.println("<" + s + "> is acceptable.");
            } else {
                System.out.println("<" + s + "> is not acceptable.");
            }
        }
    }
    
    static boolean check(String s) {
        boolean v = false;
        int vc = 0, cc = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                v = true;
                vc++;
                cc = 0;
                if (vc >= 3) return false;
            } else {
                cc++;
                vc = 0;
                if (cc >= 3) return false;
            }
            
            if (i > 0 && s.charAt(i - 1) == c && c != 'e' && c != 'o') {
                return false;
            }
        }
        
        return v;
    }
}