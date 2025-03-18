import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int a = 1;  
        int b = 2; 

        int[] min = new int[N +1]; 
        int[] max = new int[N +1];  

        for(int i = 1; i <= N; i++) {
            min[i] = Integer.MAX_VALUE;
        }

        while(b <= N) {
            for(int i = b; i <= N; i++) {
                if(min[i-b] != Integer.MAX_VALUE) {
                    min[i] = Math.min(min[i], min[i-b] + a);
                }
                max[i] = Math.max(max[i], max[i-b] + a);
            }

            int tmp = b;
            b += a;
            a = tmp;
        }

        System.out.println(min[N] + " " + max[N]);
    }
}