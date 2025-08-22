import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        String o = "";
        String y = "";
        int max = 0;
        int min = 30000000;
        
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            String name = s[0];
            int d = Integer.parseInt(s[1]);
            int m = Integer.parseInt(s[2]);
            int year = Integer.parseInt(s[3]);
            
            int date = year * 10000 + m * 100 + d;
            
            if (date > max) {
                max = date;
                y = name;
            }
            if (date < min) {
                min = date;
                o = name;
            }
        }
        
        System.out.println(y);
        System.out.println(o);
    }
}