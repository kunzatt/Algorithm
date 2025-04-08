import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] first = br.readLine().toCharArray();
        char[] second = br.readLine().toCharArray();
        int[] farr = new int[26];
        int[] sarr = new int[26];
        
        for (int i = 0; i < first.length; i++) {
            farr[change(first[i])]++;
        }

        for (int i = 0; i < second.length; i++) {
            sarr[change(second[i])]++;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += Math.abs(farr[i] - sarr[i]);
        }
        System.out.println(ans);
    }

    static int change(char c) {
        int num = c - 'a';
        return num;
    }
}