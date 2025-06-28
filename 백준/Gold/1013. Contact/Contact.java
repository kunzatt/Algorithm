import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        while(t-- > 0) {
            String s = br.readLine();
            System.out.println(check(s) ? "YES" : "NO");
        }
    }
    
    static boolean check(String s) {
        int n = s.length();
        int i = 0;
        
        while(i < n) {
            if(s.charAt(i) == '0') {
                if(i + 1 < n && s.charAt(i + 1) == '1') {
                    i += 2;
                } else {
                    return false;
                }
            } else {
                if(i + 2 < n && s.charAt(i + 1) == '0' && s.charAt(i + 2) == '0') {
                    i += 3;
                    while(i < n && s.charAt(i) == '0') i++;
                    if(i >= n || s.charAt(i) != '1') return false;
                    i++;
                    
                    while(i < n && s.charAt(i) == '1') {
                        if(i + 1 < n && s.charAt(i + 1) == '0' && 
                           i + 2 < n && s.charAt(i + 2) == '0') break;
                        i++;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}