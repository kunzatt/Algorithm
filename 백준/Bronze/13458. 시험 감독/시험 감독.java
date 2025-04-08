import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken()); 
        int C = Integer.parseInt(st.nextToken());
        
        long count = N; 
        
        for (int i = 0; i < N; i++) {
            arr[i] -= B;
            if (arr[i] > 0) {
                count += (arr[i] + C - 1) / C;
            }
        }
        
        System.out.println(count);
    }
}