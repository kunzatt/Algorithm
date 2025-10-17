import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        int[] course;
        int N;
        long K;
        boolean reverse = false;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Long.valueOf(st.nextToken());

        course = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            course[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            K -=course[i];
            if(K < 0){
                System.out.println(i+1);
                reverse = true;
                break;
            }
        }

        if(!reverse){
            for (int i = N - 1; i >= 0; i--) {
                K -= course[i];
                if(K < 0){
                    System.out.println(i+1);
                    break;
                }
            }
        }
    }

}