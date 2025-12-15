import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] c = new int[n];
        boolean[] s = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(st.nextToken());
            if (c[i] != 0) s[i] = true;
        }
        
        boolean h = false;
        for (int i = 0; i < n; i++) {
            if (s[i]) {
                h = true;
                break;
            }
        }
        
        if (!h) {
            System.out.println(n / 2);
        } else {
            int[] m = new int[n];
            for (int i = 0; i < n; i++) m[i] = -1;
            int cnt = 0;
            
            for (int i = 0; i < n; i++) {
                if (s[i]) {
                    cnt += c[i];
                    m[i] = 0;
                }
            }
            
            if (n == 2) {
                int sp = 0;
                for (int i = 0; i < n; i++) {
                    if (s[i]) sp++;
                }
                if (sp == 1) cnt++;
                System.out.println(cnt);
            } else {
                int idx = 0;
                for (int i = 0; i < n; i++) {
                    if (s[i]) {
                        idx = i;
                        break;
                    }
                }
                
                for (int i = idx; i < n + idx; i++) {
                    int cur = i % n;
                    if (m[cur] == -1) {
                        int l = (i - 1 + n) % n;
                        int r = (i + 1) % n;
                        if (m[l] != 1 && m[r] != 1) {
                            m[cur] = 1;
                            cnt++;
                        }
                    }
                }
                System.out.println(cnt);
            }
        }
    }
}