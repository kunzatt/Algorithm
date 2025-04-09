import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        int[] alphabets = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
        
        int n = A.length() * 2;
        int[] arr = new int[n];
        int idx = 0;
        
        for (int i = 0; i < A.length() ; i++) {
            arr[idx++] = alphabets[A.charAt(i) - 'A'];
            arr[idx++] = alphabets[B.charAt(i) - 'A'];
        }
        
        while (n > 2) {
            int[] temp = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                temp[i] = (arr[i] + arr[i + 1]) % 10;
            }
            arr = temp;
            n = n - 1;
        }
        
        System.out.printf("%d%d\n", arr[0], arr[1]);
    }
}