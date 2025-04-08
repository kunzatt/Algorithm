import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int t = 0; t < N; t++) {
            int[] arr = new int[26];
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] first = st.nextToken().toCharArray();
            char[] second = st.nextToken().toCharArray();
            
            for (int i = 0; i < first.length; i++) {
                arr[first[i] - 'a']++;
            }
            
            for (int i = 0; i < second.length; i++) {
                arr[second[i] - 'a']--;
            }
            
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (arr[i] != 0) {
                    flag = false;
                    break;
                }
            }
            
            if (!flag) {
                System.out.println("Impossible");
            } else {
                System.out.println("Possible");
            }
        }
    }
}