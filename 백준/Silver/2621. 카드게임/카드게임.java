import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] c = new char[5];
        int[] n = new int[5];
        int[] cnt = new int[10];
        boolean same = true;
        
        for(int i=0;i<5;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            c[i] = st.nextToken().charAt(0);
            n[i] = Integer.parseInt(st.nextToken());
            cnt[n[i]]++;
            if(i>0 && c[i]!=c[0]) same = false;
        }
        
        Arrays.sort(n);
        boolean seq = true;
        for(int i=1;i<5;i++) {
            if(n[i]!=n[i-1]+1) seq = false;
        }
        
        int ans = 0;
        if(same && seq) ans = 900+n[4];
        else {
            int four=0, three=0, two1=0, two2=0;
            for(int i=1;i<=9;i++) {
                if(cnt[i]==4) four = i;
                else if(cnt[i]==3) three = i;
                else if(cnt[i]==2) {
                    if(two1==0) two1 = i;
                    else two2 = i;
                }
            }
            
            if(four>0) ans = 800+four;
            else if(three>0 && two1>0) ans = 700+three*10+two1;
            else if(same) ans = 600+n[4];
            else if(seq) ans = 500+n[4];
            else if(three>0) ans = 400+three;
            else if(two2>0) ans = 300+two2*10+two1;
            else if(two1>0) ans = 200+two1;
            else ans = 100+n[4];
        }
        
        System.out.println(ans);
    }
}