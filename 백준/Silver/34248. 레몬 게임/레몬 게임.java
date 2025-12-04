import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int ones = 0, twos = 0;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x == 1) ones++;
            else twos++;
        }
        
        int total = ones + 2 * twos;
        
        if (total % 3 != 0) {
            System.out.println("No");
            return;
        }
        
        if (ones < twos) {
            System.out.println("No");
            return;
        }
        
        if ((ones - twos) % 3 != 0) {
            System.out.println("No");
            return;
        }
        
        System.out.println("Yes");
    }
}