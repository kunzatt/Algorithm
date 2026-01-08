import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String arr = br.readLine();
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(arr);
        int [] array = new int[L+1];
        array[0] = 0;
        for(int i=1; i< array.length; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        int start = 0;
        int end= 0;

        for(int i=1; i< array.length; i++){
            if(array[i] == n){
                System.out.print(0);
                return;
            } else if (n < array[i]) {
                start = array[i-1]+1;
                end = array[i]-1;
                break;
            }
        }

        System.out.print(counting(start, end, n));
    }

    private static int counting(int start, int end, int n) {
        int count = 0;

        count += n-start;
        count += end-n;
        count += (n-start)*(end-n);

        return count;
    }
}
