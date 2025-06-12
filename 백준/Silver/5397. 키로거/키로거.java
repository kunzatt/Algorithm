import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        while(t-- > 0) {
            String s = br.readLine();
            Stack<Character> l = new Stack<>();
            Stack<Character> r = new Stack<>();
            
            for(char c : s.toCharArray()) {
                if(c == '<') {
                    if(!l.isEmpty()) r.push(l.pop());
                } else if(c == '>') {
                    if(!r.isEmpty()) l.push(r.pop());
                } else if(c == '-') {
                    if(!l.isEmpty()) l.pop();
                } else {
                    l.push(c);
                }
            }
            
            StringBuilder sb = new StringBuilder();
            while(!l.isEmpty()) r.push(l.pop());
            while(!r.isEmpty()) sb.append(r.pop());
            
            System.out.println(sb);
        }
    }
}