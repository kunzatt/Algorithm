import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String str = br.readLine();
            if (str.equals("0")) break;
            char[] ch = str.toCharArray();
            int ans = 0;
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] == '1') {
                    ans += 2;
                } else if (ch[i] == '0') {
                    ans += 4;
                } else {
                    ans += 3;
                }
            }
            System.out.println(ans + ch.length + 1);
        }
    }
}