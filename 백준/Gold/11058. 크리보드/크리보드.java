import java.io.*;
public class Main {
    static int N;
    static long[] DP;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        DP = new long[N+1];
        for(int i=1;i<=N;i++){
            DP[i] = DP[i-1] + 1;
            if(i>6){
                for(int j=3;j<=5;j++){
                    DP[i] = Math.max(DP[i], DP[i-j] * (j-1));
                }
            }
        }
        bw.write(DP[N] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}