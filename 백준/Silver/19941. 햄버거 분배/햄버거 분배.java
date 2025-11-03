import java.io.*;
import java.util.StringTokenizer;
public class Main{
    static char[] c;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        c = br.readLine().toCharArray();
        for(int i=0;i<n;i++){
            if(c[i] == 'P'){
                int idx = Math.max(i - k, 0);
                boolean f = false;
                for(int j=idx;j<i;j++){
                    if(check(j)){
                        f = true;
                        break;
                    }
                }
                if(!f){
                    idx = i + k >= n ? n-1 : i + k;
                    for(int j=i+1;j<=idx;j++){
                        if(check(j))
                            break;
                    }
                }
            }
        }
        bw.write(ans + "");
        bw.flush();
        bw.close();
    }
    static boolean check(int idx){
        if(c[idx] == 'H'){
            c[idx] = 'X';
            ans++;
            return true;
        }
        return false;
    }
}