import java.io.*;
import java.util.*;

public class Solution_8382_방향전환 {
    static int T, x1, y1, x2, y2, ans;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
 
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            ans = 0;
 
            int dx = Math.abs(x2 - x1);
            int dy = Math.abs(y2 - y1);
 
            if (dy > dx) {
                int temp = dx;
                dx = dy;
                dy = temp;
            }
 
            ans = (dx / 2) * 4 + (dx % 2);
 
            if (dy % 2 == 1) {
                if (dx % 2 == 1) ans++;
                else ans--;
            }
            
            System.out.println("#" + t + " " + ans);
 
        }
    }
}
