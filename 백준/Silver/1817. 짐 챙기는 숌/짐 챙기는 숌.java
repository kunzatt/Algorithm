import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        
        int[] books = new int[N];
    
        for (int i = 0; i < N; i++) {
            books[i] = scanner.nextInt();
        }
        
        int count = 0;
        int cur = 0;
        
        for (int i = 0; i < N; i++) {
            if (cur + books[i] <= M) {
                cur += books[i];
            } else {
                count++;
                cur = books[i];
            }
        }
        
        if (cur > 0) {
            count++;
        }
        
        System.out.println(count);
    }
}