import java.io.*;
import java.util.*;

public class Main {
    static class P {
        int pos, num;
        P(int pos, int num) {
            this.pos = pos;
            this.num = num;
        }
    }
    
    static int calc(List<P> students, int k, int s) {
        int nowPos = s, nowNum = 0, ans = 0;
        
        while (!students.isEmpty()) {
            int pos = students.get(students.size() - 1).pos;
            int num = students.get(students.size() - 1).num;
            
            if (num + nowNum <= k) {
                students.remove(students.size() - 1);
                nowNum += num;
            } else {
                students.get(students.size() - 1).num -= k - nowNum;
                nowNum += k - nowNum;
            }
            
            ans += Math.abs(nowPos - pos);
            nowPos = pos;
            
            if (nowNum == k || students.isEmpty()) {
                ans += Math.abs(nowPos - s);
                nowPos = s;
                nowNum = 0;
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        
        List<P> left = new ArrayList<>();
        List<P> right = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            
            if (pos < s) {
                left.add(new P(pos, num));
            } else if (pos > s) {
                right.add(new P(pos, num));
            }
        }
        
        left.sort((a, b) -> b.pos - a.pos);
        right.sort((a, b) -> a.pos - b.pos);
        
        System.out.println(calc(left, k, s) + calc(right, k, s));
    }
}