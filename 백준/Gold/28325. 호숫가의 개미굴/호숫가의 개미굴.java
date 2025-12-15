import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] list = new long[n];
        boolean flag = false;
        
        for (int i = 0; i < n; i++) {
            list[i] = Long.parseLong(st.nextToken());
            flag |= (list[i] > 0);
        }
        
        if (!flag) {
            System.out.println(n >> 1);
            return;
        }
        
        long ret = 0;
        long cnt = 0;
        long tmp = 0;
        boolean isFirst = true;
        
        for (int i = 0; i < n; i++) {
            if (list[i] == 0) {
                cnt++;
            } else {
                if (isFirst) tmp = cnt;
                ret += list[i];
                isFirst = false;
                ret += ((cnt + 1L) >> 1);
                cnt = 0;
            }
        }
        
        if (list[0] == 0 && list[n - 1] == 0) {
            ret -= ((tmp + 1L) >> 1);
            ret += ((tmp + cnt + 1L) >> 1);
        } else {
            ret += ((cnt + 1L) >> 1);
        }
        
        System.out.println(ret);
    }
}