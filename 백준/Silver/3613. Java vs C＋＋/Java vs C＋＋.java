import java.io.*;

public class Main {
    static boolean isJava(String s) {
        for (char c : s.toCharArray()) 
            if (c >= 'A' && c <= 'Z') return true;
        return false;
    }
    
    static boolean isCpp(String s) {
        for (char c : s.toCharArray()) 
            if (c == '_') return true;
        return false;
    }
    
    static boolean isError(String s) {
        boolean u = false, h = false;
        for (char c : s.toCharArray()) {
            if (c == '_') u = true;
            else if (c >= 'A' && c <= 'Z') h = true;
        }
        if (u && h) return true;
        
        if (s.charAt(0) >= 'A' && s.charAt(0) <= 'Z' || s.charAt(0) == '_') return true;
        if (s.charAt(s.length()-1) == '_') return true;
        
        for (int i = 0; i < s.length()-1; i++)
            if (s.charAt(i) == '_' && s.charAt(i+1) == '_') return true;
        
        return false;
    }
    
    static String jToC(String s) {
        String r = "";
        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                r += '_';
                r += (char)(c + 32);
            } else r += c;
        }
        return r;
    }
    
    static String cToJ(String s) {
        String r = "";
        boolean f = false;
        for (char c : s.toCharArray()) {
            if (c == '_') f = true;
            else {
                if (f) {
                    r += (char)(c - 32);
                    f = false;
                } else r += c;
            }
        }
        return r;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        if (isError(s)) System.out.println("Error!");
        else if (isCpp(s)) System.out.println(cToJ(s));
        else if (isJava(s)) System.out.println(jToC(s));
        else System.out.println(s);
    }
}